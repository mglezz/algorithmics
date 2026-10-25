# Compile the Java examples directly from the Markdown and verify their behavior.
# Requires PowerShell and a JDK whose javac supports --release 17.
$ErrorActionPreference = 'Stop'
$repositoryPath = Split-Path -Parent $PSScriptRoot
$documentationFiles = @(
    Get-ChildItem -LiteralPath $repositoryPath -Filter '*.md'
    foreach ($folder in @('algorithms', 'data-structures', 'notes', 'problems', 'tests')) {
        Get-ChildItem -LiteralPath (Join-Path $repositoryPath $folder) -Filter '*.md' -Recurse
    }
)
$documentationFiles = @($documentationFiles | Sort-Object FullName)
$headingAnchors = @{}
$theoryChapterCount = 0
foreach ($document in $documentationFiles) {
    $anchors = [System.Collections.Generic.List[string]]::new()
    $slugCounts = @{}
    $inFence = $false
    foreach ($line in [System.IO.File]::ReadAllLines($document.FullName)) {
        if ($line -match '^```') { $inFence = -not $inFence; continue }
        if (-not $inFence -and $line -match '^#{1,6} (.+)$') {
            $slug = $Matches[1].ToLowerInvariant() -replace '<[^>]*>', '' -replace '[^\p{L}\p{Nd}_\-\s]', '' -replace ' ', '-'
            $baseSlug = $slug
            if ($slugCounts.ContainsKey($baseSlug)) {
                $slugCounts[$baseSlug]++
                $slug = $baseSlug + '-' + $slugCounts[$baseSlug]
            } else {
                $slugCounts[$baseSlug] = 0
            }
            $anchors.Add($slug)
        }
    }
    $headingAnchors[$document.FullName] = $anchors
}
$snippets = [System.Collections.Generic.List[string]]::new()
$localLinkCount = 0
$anchorCount = 0
foreach ($document in $documentationFiles) {
    $content = [System.IO.File]::ReadAllText($document.FullName)
    $relativeDocument = $document.FullName.Substring($repositoryPath.Length + 1).Replace('\', '/')
    $isTheory = $relativeDocument -match '^(algorithms|data-structures)/'
    if ($isTheory -and $document.Name -match '^\d{2}-') {
        $theoryChapterCount++
        foreach ($requiredHeading in @('## On this page', '## Worked visual', '## Attribution and references')) {
            if (-not $content.Contains($requiredHeading)) {
                throw "Missing chapter navigation, example or attribution: $relativeDocument ($requiredHeading)"
            }
        }
    }
    $fences = [regex]::Matches($content, '(?m)^```')
    if ($fences.Count % 2 -ne 0) { throw "Unbalanced code fences: $($document.Name)" }
    if ([regex]::Matches($content, '<details(?:\s[^>]*)?>').Count -ne
        [regex]::Matches($content, '</details>').Count) {
        throw "Unbalanced hint disclosure: $relativeDocument"
    }
    foreach ($match in [regex]::Matches($content, '\[[^\]\r\n]+\]\(([^)\r\n]+)\)')) {
        $target = $match.Groups[1].Value
        if ($target -match '^[a-zA-Z][a-zA-Z0-9+.-]*:') { continue }
        $targetParts = $target -split '#', 2
        $relativePath = [Uri]::UnescapeDataString($targetParts[0])
        $resolvedPath = $document.FullName
        if ($relativePath) {
            $resolvedPath = [System.IO.Path]::GetFullPath((Join-Path $document.DirectoryName $relativePath))
        }
        if (-not (Test-Path -LiteralPath $resolvedPath)) {
            throw "Broken local link in $($document.Name): $target"
        }
        if ($targetParts.Count -eq 2 -and $targetParts[1]) {
            $anchor = [Uri]::UnescapeDataString($targetParts[1])
            if (-not $headingAnchors.ContainsKey($resolvedPath) -or
                -not $headingAnchors[$resolvedPath].Contains($anchor)) {
                throw "Broken heading link in $relativeDocument : $target"
            }
            $anchorCount++
        }
        $localLinkCount++
    }
    if ($isTheory) {
        foreach ($match in [regex]::Matches($content, '(?ms)^```java\r?\n(.*?)^```[ \t]*\r?$')) {
            $snippets.Add($match.Groups[1].Value)
        }
    }
}
if ($snippets.Count -eq 0) { throw 'No Java examples were found.' }

$temporaryParent = [System.IO.Path]::GetFullPath([System.IO.Path]::GetTempPath())
$temporaryName = 'algorithmics-theory-' + [Guid]::NewGuid().ToString('N')
$temporaryPath = Join-Path $temporaryParent $temporaryName
New-Item -ItemType Directory -Path $temporaryPath | Out-Null
try {
    $examplePath = Join-Path $temporaryPath 'TheoryExamples.java'
    $exampleSource = "import java.util.*;`nclass TheoryExamples {`n" + ($snippets -join "`n") + "`n}`n"
    [System.IO.File]::WriteAllText($examplePath, $exampleSource, [System.Text.UTF8Encoding]::new($false))
    $classPath = Join-Path $temporaryPath 'classes'
    New-Item -ItemType Directory -Path $classPath | Out-Null
    $originalSources = @(Get-ChildItem -LiteralPath (Join-Path $repositoryPath 'problems/serviceDependencies') -Filter '*.java' | ForEach-Object FullName)
    $compilerArguments = @('--release', '17', '-encoding', 'UTF-8', '-Xlint:all', '-Werror', '-d', $classPath, $examplePath,
        (Join-Path $PSScriptRoot 'TheoryChecks.java')) + $originalSources
    & javac @compilerArguments
    if ($LASTEXITCODE -ne 0) { throw 'Java compilation failed.' }
    & java -cp $classPath TheoryChecks
    if ($LASTEXITCODE -ne 0) { throw 'Java behavioral checks failed.' }
    Write-Output "Verified $theoryChapterCount theory chapters, $($snippets.Count) Java blocks, $localLinkCount local links and $anchorCount heading anchors."
} finally {
    # Delete only the exact unique directory created above, within the OS temp directory.
    $resolvedTemporary = [System.IO.Path]::GetFullPath($temporaryPath)
    $resolvedParent = [System.IO.Path]::GetFullPath((Split-Path -Parent $resolvedTemporary))
    if ($resolvedParent.TrimEnd('\', '/') -ne $temporaryParent.TrimEnd('\', '/') -or
        (Split-Path -Leaf $resolvedTemporary) -ne $temporaryName -or
        -not $temporaryName.StartsWith('algorithmics-theory-')) {
        throw 'Refusing to remove a temporary directory outside the verified location.'
    }
    if (Test-Path -LiteralPath $resolvedTemporary) {
        Remove-Item -LiteralPath $resolvedTemporary -Recurse -Force
    }
}
