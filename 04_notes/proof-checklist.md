# Correctness: Quick Reference

<!-- study-navigation -->
[← Previous: Dynamic Programming: Quick Reference](dynamic-programming.md) · [Index](README.md) · [Next: Interview: Quick Checklist →](interview-checklist.md)
<!-- /study-navigation -->

[Quick-reference index](README.md) | [Curriculum](../CURRICULUM.md)

| Method | Obligations |
|---|---|
| Loop invariant | Initialize; preserve; derive result on exit; prove termination |
| Recursion / induction | Specify smaller subproblem; base case; combine correctly; decreasing measure |
| Greedy exchange | Show some optimum can adopt your choice without getting worse |
| DP recurrence | Sufficient state; exhaustive alternatives; valid composition; evaluation order |
| Amortized analysis | Bound total work or charge each expensive event to a limited earlier event |
| Reduction | Preserve yes/no in both directions; polynomial transformation; correct direction |
| Randomized claim | Specify experiment and probability; distinguish correctness from runtime |

**Tests are evidence, not a universal proof.** A valid witness may still be suboptimal. For a topological order, check all vertices and every dependency; for an optimum, also justify why no better solution exists.

**Useful counterexamples:** all-negative input with maximum initialized to zero; a separate directed cycle beside an isolated vertex; coin denominations `{1,3,4}` for greedy change of six.

## Full explanations

- [Mathematics and correctness](../01_algorithms/01_foundations/01-mathematics-and-correctness.md)
- [Greedy proofs](../01_algorithms/09_greedy/17-greedy-and-intervals.md)
- [Computational limits](../01_algorithms/13_advanced/24-complexity-and-advanced-design.md)

These are summaries of the linked chapters. Their source attribution is in those chapters and [SOURCES.md](../SOURCES.md).

---

<!-- study-navigation -->
[← Previous: Dynamic Programming: Quick Reference](dynamic-programming.md) · [Index](README.md) · [Next: Interview: Quick Checklist →](interview-checklist.md)
<!-- /study-navigation -->
