# Documentation and Example Verification

From the repository root, with PowerShell and a JDK supporting `--release 17`:

```powershell
powershell -NoProfile -ExecutionPolicy Bypass -File .\tests\verify-theory.ps1
```

The execution-policy option is process-local. If scripts are already permitted, `./tests/verify-theory.ps1` is enough.

## What is checked

- Repository-local Markdown file targets and heading anchors.
- Balanced fenced code blocks and collapsible hint markup.
- Chapter navigation, worked visuals, and attribution sections.
- Every Java block under `algorithms/` and `data-structures/`, compiled as static members with `java.util.*` available.
- Prefix sums, target-sum counting, a nonnegative sliding window, linked-list reversal, lower bound, DSU, nonadjacent-sum DP, KMP and Fenwick operations.
- The existing clean service-dependency algorithm, including cycle detection through a separate transitive-closure oracle.

[TheoryChecks.java](TheoryChecks.java) depends on a temporary class generated from the Markdown by [verify-theory.ps1](verify-theory.ps1); do not compile it alone. Generated files live in a unique OS temporary directory and are removed afterward.

## Limits

These tests do not prove all mathematical prose, validate every suggested exercise solution, or execute every pseudocode algorithm. External URLs and visual rendering require separate review. Source attribution and editorial corrections are recorded in [SOURCES.md](../SOURCES.md).
