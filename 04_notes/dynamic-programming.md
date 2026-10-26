# Dynamic Programming: Quick Reference

<!-- study-navigation -->
[← Previous: Graphs: Quick Reference](graphs.md) · [Index](README.md) · [Next: Correctness: Quick Reference →](proof-checklist.md)
<!-- /study-navigation -->

[Quick-reference index](README.md) | [Curriculum](../CURRICULUM.md)

## Derivation checklist

1. State in one sentence what one table entry means.
2. List all possible first/last decisions.
3. Define base cases and unreachable values.
4. Prove transitions are exhaustive and valid.
5. Choose an acyclic evaluation order.
6. Identify the answer and reconstruction information.
7. Count states times transition work, including copying.

| Pattern | State / update reminder |
|---|---|
| 0/1 knapsack | Descending capacity for one-dimensional compression |
| Unbounded knapsack | Ascending capacity permits reuse of the current item |
| LCS / edit distance | Two prefixes; preserve previous-row and diagonal dependencies |
| Strict LIS | Replace first tail >= x; tails alone are not a witness |
| Interval DP | Fill increasing lengths; choose a split or final action |
| Tree DP | Condition on the parent connection before combining children |
| Subset DP | Mask records visited items; endpoint may be another dimension |
| Digit DP | Position, tight/started flags, and the property being tracked |

**Common error:** two histories with the same cache key may leave different futures. Add the missing state dimension before memoizing.

## Full explanations

- [DP foundations](../01_algorithms/10_dynamic-programming/18-dynamic-programming.md)
- [DP patterns](../01_algorithms/10_dynamic-programming/19-dynamic-programming-patterns.md)

These are summaries of the linked chapters. Their source attribution is in those chapters and [SOURCES.md](../SOURCES.md).

---

<!-- study-navigation -->
[← Previous: Graphs: Quick Reference](graphs.md) · [Index](README.md) · [Next: Correctness: Quick Reference →](proof-checklist.md)
<!-- /study-navigation -->
