# Data Structures: Quick Reference

[Quick-reference index](README.md) | [Curriculum](../CURRICULUM.md)

| Need | Structure | Relevant operation / caveat |
|---|---|---|
| Indexed sequence | Array / ArrayList | O(1) indexed access; middle shifts are O(n) |
| Equality lookup | Hash map / set | Expected O(1) with suitable hashing and constant key work |
| Ordered navigation | Balanced search tree | O(log n) lookup/update; supports predecessor/successor |
| Newest or oldest pending work | Stack / queue | O(1) amortized deque endpoints |
| Repeated best candidate | Heap | O(log n) push/pop, O(1) peek; not sorted iteration |
| Merge-only connectivity | DSU | O(alpha(n)) amortized after initialization; no arbitrary deletion |
| Prefix dictionary lookup | Trie | O(L) with constant-time child access |
| Point add + range sum | Fenwick tree | O(log n) update/query; O(n) storage |
| General associative range aggregate | Segment tree | O(log n) query/point update; preserve combine order |
| Static range minimum | Sparse table | O(n log n) build, O(1) query using idempotence |

**Selection questions:** Does order matter? Does data change? Do you need a witness? Can keys be large? Is the guarantee worst-case or amortized?

## Full explanations

- [Data structure catalogue](../data-structures/README.md)
- [Range-query algebra](../data-structures/range-queries/21-range-query-data-structures.md)
- [Java contracts](../algorithms/foundations/03-java-for-interviews.md)

These are summaries of the linked chapters. Their source attribution is in those chapters and [SOURCES.md](../SOURCES.md).
