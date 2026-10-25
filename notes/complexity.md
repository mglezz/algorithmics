# Complexity: Quick Reference

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

- [Analysis and amortization](../algorithms/foundations/02-complexity-and-amortization.md)
- [Sorting](../algorithms/sorting/10-sorting-and-selection.md)

These are summaries of the linked chapters. Their source attribution is in those chapters and [SOURCES.md](../SOURCES.md).
