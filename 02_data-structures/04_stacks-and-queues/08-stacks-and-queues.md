# 08A - Stacks and Queues

<!-- study-navigation -->
[← Previous: Unit 07](../03_linked-lists/07-linked-lists.md) · [Index](../../README.md#study-index) · [Next: Unit 08B →](../../01_algorithms/04_monotonic-structures/08-monotonic-stacks-and-deques.md)
<!-- /study-navigation -->

[Curriculum](../../CURRICULUM.md) | [Quick reference](../../04_notes/patterns.md) | [Companion chapter](../../01_algorithms/04_monotonic-structures/08-monotonic-stacks-and-deques.md)

> **Core idea:** A stack removes the newest pending item; a queue removes the oldest.

## On this page

- [Order is part of the abstraction](#order-is-part-of-the-abstraction)
- [Worked visual](#worked-visual)
- [Stack invariants](#stack-invariants)
- [Explain it in English](#explain-it-in-english)
- [Practice](#practice)
- [Attribution and references](#attribution-and-references)

## Order is part of the abstraction

A stack is last-in, first-out; it represents suspended work, nesting, and reversible choices. A queue is first-in, first-out; it represents arrival order and graph frontiers. A deque supports both ends. These behaviors do not require linked nodes: arrays and circular buffers are often appropriate.

A circular queue stores a head index and size (or another unambiguous empty/full convention). Logical position `i` maps to `(head+i) mod capacity`. Reusing departed slots avoids shifting an entire array on each dequeue. A bounded queue must define what happens when full; a resizable queue needs an amortized analysis.

Use Java `ArrayDeque` for ordinary stacks and queues. Its endpoint operations are amortized constant time; searching for and removing an arbitrary value is linear. Do not enqueue null or rely on iterators as a sorted traversal.

## Worked visual

| Operations | Stack result | Queue result |
|---|---|---|
| Insert A, then B, then C | Top is C | Front is A |
| Remove once | Returns C | Returns A |
| Remaining removal order | B, A | B, C |

## Stack invariants

For bracket validation, the stack contains unmatched opening brackets in order. A closing bracket must match the latest opening bracket; a mismatch or empty stack rejects immediately. At the end, acceptance requires an empty stack. Counting opening and closing brackets alone cannot reject `([)]`.

A minimum stack can store `(value,minimumSoFar)` in each entry. Alternatively keep a second stack of minima, retaining duplicate minima or counts so popping one equal minimum does not lose another. All operations are constant time, with linear total space.

Two stacks implement a queue: enqueue into an input stack; dequeue from an output stack; transfer all input entries only when output is empty. An item moves at most once between stacks, proving amortized constant operations. Transferring before every dequeue would destroy that bound.

## Explain it in English

> “This candidate is dominated by a newer one that is at least as good and remains valid longer.”

**Vocabulary:** frontier, nesting, unresolved, domination, expiration, amortized.

## Practice

Attempt the [unit 08 exercise set](../../03_problems/02_practice/08-stacks-queues-and-monotonic-structures.md). Exercises and hints live in `03_problems/`; this chapter contains the theory.

## Attribution and references

**Provenance:** This chapter is a synthesis of the sources mapped below. Standard definitions, algorithms and proof techniques belong to those established references; the explanatory wording, traces, diagrams and Java examples were written for this repository. No source passage is quoted verbatim.

| Section / claim | Source used | How it is used |
|---|---|---|
| Stacks, queues and circular storage | [Pat Morin, Open Data Structures, chapter 2](https://opendatastructures.org/ods-java/2_Array_Based_Lists.html) | Array queue/deque sections and amortization. |
| Java deque behavior | [Oracle Java 21: ArrayDeque](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/ArrayDeque.html) | Endpoint costs and null restrictions. |

See [SOURCES.md](../../SOURCES.md) for editions, review scope, and the distinction between consulted material and further reading.

---

<!-- study-navigation -->
[← Previous: Unit 07](../03_linked-lists/07-linked-lists.md) · [Index](../../README.md#study-index) · [Next: Unit 08B →](../../01_algorithms/04_monotonic-structures/08-monotonic-stacks-and-deques.md)
<!-- /study-navigation -->
