# Compile the Java examples directly from the Markdown and verify their behavior.
# Requires PowerShell and a JDK whose javac supports --release 17.
$ErrorActionPreference = 'Stop'
$repositoryPath = Split-Path -Parent $PSScriptRoot
$theoryPath = Join-Path $repositoryPath 'theory'
$documentationFiles = @(
    Get-Item -LiteralPath (Join-Path $repositoryPath 'README.md')
    Get-Item -LiteralPath (Join-Path $repositoryPath 'PROGRESS.md')
    Get-ChildItem -LiteralPath $theoryPath -Filter '*.md' | Sort-Object Name
)
$snippets = [System.Collections.Generic.List[string]]::new()
$localLinkCount = 0
foreach ($document in $documentationFiles) {
    $content = [System.IO.File]::ReadAllText($document.FullName)
    $fences = [regex]::Matches($content, '(?m)^```')
    if ($fences.Count % 2 -ne 0) { throw "Unbalanced code fences: $($document.Name)" }
    foreach ($match in [regex]::Matches($content, '\[[^\]\r\n]+\]\(([^)\r\n]+)\)')) {
        $target = $match.Groups[1].Value
        if ($target -match '^[a-zA-Z][a-zA-Z0-9+.-]*:' -or $target.StartsWith('#')) { continue }
        $relativePath = [Uri]::UnescapeDataString(($target -split '#', 2)[0])
        $resolvedPath = [System.IO.Path]::GetFullPath((Join-Path $document.DirectoryName $relativePath))
        if (-not (Test-Path -LiteralPath $resolvedPath)) {
            throw "Broken local link in $($document.Name): $target"
        }
        $localLinkCount++
    }
    foreach ($match in [regex]::Matches($content, '(?ms)^```java\r?\n(.*?)^```[ \t]*\r?$')) {
        $snippets.Add($match.Groups[1].Value)
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
    Write-Output "Verified $($snippets.Count) Java blocks and $localLinkCount local documentation links."
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
