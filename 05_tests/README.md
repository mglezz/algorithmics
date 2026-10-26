# Documentation and Example Verification

<!-- study-navigation -->
[← Previous: Progress](../PROGRESS.md) · [Index](../README.md) · [Next: Overview →](../README.md)
<!-- /study-navigation -->

From the repository root, with PowerShell and a JDK supporting `--release 17`:

```powershell
powershell -NoProfile -ExecutionPolicy Bypass -File .\05_tests\verify-theory.ps1
```

The execution-policy option is process-local. If scripts are already permitted, `./05_tests/verify-theory.ps1` is enough.

## What is checked

- Repository-local Markdown file targets and heading anchors.
- Balanced fenced code blocks and collapsible hint markup.
- Identical previous/index/next navigation at the top and bottom of every Markdown document; the index target must be a README.
- Chapter contents navigation, worked visuals, and attribution sections.
- Every marked Java hint fragment, compiled in its own wrapper class with Java 17 and compiler warnings treated as errors. Compilation checks syntax and types; the hints are partial helpers, not completed exercise solutions.
- Every Java block under `01_algorithms/` and `02_data-structures/`, compiled as static members with `java.util.*` available.
- Prefix sums, target-sum counting, a nonnegative sliding window, linked-list reversal, lower bound, DSU, nonadjacent-sum DP, KMP and Fenwick operations.
- The existing clean service-dependency algorithm, including cycle detection through a separate transitive-closure oracle.

[TheoryChecks.java](TheoryChecks.java) depends on a temporary class generated from the Markdown by [verify-theory.ps1](verify-theory.ps1); do not compile it alone. Generated files live in a unique OS temporary directory and are removed afterward.

## Limits

These tests do not prove all mathematical prose, validate every suggested exercise solution, execute the hint helpers, or execute every pseudocode algorithm. External URLs and visual rendering require separate review. Source attribution and editorial corrections are recorded in [SOURCES.md](../SOURCES.md).

---

<!-- study-navigation -->
[← Previous: Progress](../PROGRESS.md) · [Index](../README.md) · [Next: Overview →](../README.md)
<!-- /study-navigation -->
