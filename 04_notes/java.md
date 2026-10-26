# Java: Quick Reference

<!-- study-navigation -->
[← Previous: Algorithm Patterns: Quick Reference](patterns.md) · [Index](README.md) · [Next: Graphs: Quick Reference →](graphs.md)
<!-- /study-navigation -->

[Quick-reference index](README.md) | [Curriculum](../CURRICULUM.md)

| Task / trap | Use or check |
|---|---|
| Wide multiplication of int values | `(long) a * b`, not `(long) (a * b)` |
| Comparator | `Integer.compare(a,b)` or `Long.compare(a,b)` |
| Text equality | `.equals()`; `==` tests reference identity |
| FIFO / LIFO | ArrayDeque: addLast/removeFirst or push/pop |
| Heap | PriorityQueue iterator is not sorted; avoid mutating stored priorities |
| Hash key | Keep equality/hash fields immutable; arrays use identity equality |
| List removal | remove(1) removes an index; remove(Integer.valueOf(1)) removes a value |
| Text units | charAt indexes UTF-16 code units, not grapheme clusters |
| Negative remainder | Use floorMod when a nonnegative residue is required |
| Absolute minimum int | abs(Integer.MIN_VALUE) does not become positive |
| Bit shift | int distance is masked to 5 bits; long distance to 6 bits |
| Deep recursion | Account for stack space; no promised tail-call elimination |

**Before choosing a type:** bound every sum, product, distance and count. A long is wider, not unlimited.

## Full explanations

- [Java reasoning and contracts](../01_algorithms/01_foundations/03-java-for-interviews.md)
- [Bits and arithmetic](../01_algorithms/12_mathematics/22-bits-number-theory-and-randomness.md)

These are summaries of the linked chapters. Their source attribution is in those chapters and [SOURCES.md](../SOURCES.md).

---

<!-- study-navigation -->
[← Previous: Algorithm Patterns: Quick Reference](patterns.md) · [Index](README.md) · [Next: Graphs: Quick Reference →](graphs.md)
<!-- /study-navigation -->
