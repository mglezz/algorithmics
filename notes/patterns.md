# Algorithm Patterns: Quick Reference

[Quick-reference index](README.md) | [Curriculum](../CURRICULUM.md)

| Clue | Candidate | Required check |
|---|---|---|
| Sorted pair search | Opposite-end pointers | Prove every discarded endpoint cannot participate |
| Contiguous range with removable state | Sliding window | Validity must support monotone boundary movement |
| Exact range sum, including negatives | Prefix sums + frequency map | Seed prefix zero; query before insertion |
| Next greater / smaller item | Monotonic stack | Define strictness and duplicate behavior |
| Sliding maximum / minimum | Monotonic deque | Keep useful candidates and expire old indices |
| First feasible value | Binary search on the answer | Prove feasibility is monotone |
| Many prefixes in a dictionary | Trie | Specify alphabet and terminal flags |
| Exact substring search | KMP | Use border fallback; define empty-pattern behavior |
| Repeated equivalent subproblems | Dynamic programming | State must determine future possibilities |

**Counterexample to remember:** a sum window designed for nonnegative values can miss the best range in `[1,-1,5]` with target 5.

## Full explanations

- [Two pointers and windows](../algorithms/two-pointers/06-two-pointers-and-sliding-windows.md)
- [Monotonic structures](../algorithms/monotonic-structures/08-monotonic-stacks-and-deques.md)
- [Binary search](../algorithms/searching/09-binary-search.md)
- [String matching](../algorithms/strings/20-string-matching.md)

These are summaries of the linked chapters. Their source attribution is in those chapters and [SOURCES.md](../SOURCES.md).
