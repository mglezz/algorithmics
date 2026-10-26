# Complexity: Quick Reference

<!-- study-navigation -->
[← Previous: Quick notes](README.md) · [Index](README.md) · [Next: Data Structures: Quick Reference →](data-structures.md)
<!-- /study-navigation -->

[Quick-reference index](README.md) | [Curriculum](../CURRICULUM.md)

> **First name the input size and the cost model.** Key comparison, string copying, and arbitrary-precision arithmetic are not automatically constant time.

| Bound / term | Meaning |
|---|---|
| O(g(n)) | An eventual upper bound |
| Omega(g(n)) | An eventual lower bound |
| Theta(g(n)) | Matching upper and lower bounds |
| Worst case | Maximum over legal inputs of a given size |
| Expected | Average over a specified random experiment |
| Amortized | Cost across an operation sequence; no randomness required |

| Pattern | Usual bound | Check |
|---|---|---|
| Halve the remaining search interval | O(log(n+1)) | Predicate cost and safe boundaries |
| Advance each pointer at most n times | O(n) | No hidden reset or expensive operation |
| Sort n fixed-size comparable values | O(n log n) | Algorithm, stability and extra memory |
| Visit adjacency lists once | O(V+E) | Include isolated vertices and neighbor generation |
| Copy every subset | Theta(n * 2^n) | Include output cost |
| Recursive depth h | O(h) stack | A skewed tree may have h = n |

**Recurring mistakes:** treating a hash lookup as unconditional worst-case O(1); ignoring the recursion stack; multiplying every nested loop blindly; hiding copying inside a transition.

## Full explanations

- [Analysis and amortization](../01_algorithms/01_foundations/02-complexity-and-amortization.md)
- [Sorting](../01_algorithms/06_sorting/10-sorting-and-selection.md)

These are summaries of the linked chapters. Their source attribution is in those chapters and [SOURCES.md](../SOURCES.md).

---

<!-- study-navigation -->
[← Previous: Quick notes](README.md) · [Index](README.md) · [Next: Data Structures: Quick Reference →](data-structures.md)
<!-- /study-navigation -->
