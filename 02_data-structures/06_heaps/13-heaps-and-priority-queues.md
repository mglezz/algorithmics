# 13 - Heaps and Priority Queues

<!-- study-navigation -->
[← Previous: Unit 12](../05_trees/12-trees-and-ordered-maps.md) · [Index](../../README.md#study-index) · [Next: Unit 14A →](../07_graphs/14-graph-representations.md)
<!-- /study-navigation -->

[Curriculum](../../CURRICULUM.md) | [Quick reference](../../04_notes/data-structures.md)

> **Core idea:** A heap exposes the best frontier candidate without sorting the entire collection.

## On this page

- [Heap order is weaker than sorted order](#heap-order-is-weaker-than-sorted-order)
- [Worked visual](#worked-visual)
- [Bottom-up construction is linear](#bottom-up-construction-is-linear)
- [Top-k invariant](#top-k-invariant)
- [Merge k sorted streams](#merge-k-sorted-streams)
- [Two heaps for a running median](#two-heaps-for-a-running-median)
- [Java and update semantics](#java-and-update-semantics)
- [Explain it in English](#explain-it-in-english)
- [Practice](#practice)
- [Attribution and references](#attribution-and-references)

## Heap order is weaker than sorted order

A min-heap is a complete binary tree whose parent is no greater than either child. Thus the root is globally smallest, but siblings and unrelated subtrees need not be ordered. Searching for an arbitrary value remains linear in the worst case.

An array stores a binary heap compactly. For zero-based index `i`, children are `2i+1` and `2i+2`; the parent for `i>0` is `(i-1)/2`. Completeness ensures no gaps. Keep logical size separate from backing-array capacity and guard child-index arithmetic at numerical boundaries.

Insertion appends then **sifts up** while the parent is too large. Removing the minimum moves the last entry to the root, reduces size, and **sifts down**, exchanging with the smaller child while needed. Only one ancestor/descendant path changes, so each operation takes `O(log n)` time; peek takes `O(1)`.

## Worked visual

```text
Min-heap array: [2, 5, 3, 9, 7]

          2
        /   \
       5     3
      / \
     9   7

The root is minimal. The array itself is not sorted.
```

## Bottom-up construction is linear

Call sift-down from the last internal node backward to the root. At that moment, each child subtree is already a heap. Most nodes are near the bottom and can move only a few levels. The total work is bounded by `n * sum(h/2^h)` over heights, which is `O(n)`. Multiplying `n` by the root's worst-case height overestimates the work.

Repeated insertion also constructs a heap, but takes `O(n log n)` worst-case time. Distinguish the two methods in analysis. A dynamic backing array adds occasional resizing costs; geometric resizing is amortized.

## Top-k invariant

To retain the `k` largest stream values, maintain a min-heap of at most `k` entries. If fewer than `k` are stored, insert. Otherwise, replace the minimum only when the incoming value is larger.

Invariant: after each prefix, the heap contains the largest `min(k,itemsSeen)` values, counting duplicates. A discarded value is no larger than every retained value and cannot enter that prefix's top k. Time is `O(n log(k+1))`, space `O(k)` for `k>=1`; define `k=0` separately. The heap is not sorted output; polling it adds `O(k log k)` time if order is required.

Example: with `k=3` and stream `7,2,9,1,8`, retained values progress `{7}`, `{2,7}`, `{2,7,9}`, unchanged, then `{7,8,9}`. The root is the threshold for accepting a new item.

## Merge k sorted streams

Insert the first available entry from each stream along with its stream identifier and position. Repeatedly remove the global minimum, emit it, and insert the next item from the same stream. The heap contains exactly the smallest un-emitted item from each nonempty stream; every later item in that stream is no smaller. This proves global order.

For `N` total items and `k` streams, time is `O(N log(k+1)+k)` and auxiliary heap space is `O(k)`. Empty streams, duplicate values, and stable tie-breaking require explicit handling. This pattern also appears in external merge sorting.

## Two heaps for a running median

Keep a max-heap for the lower half and a min-heap for the upper half. Maintain two invariants: every lower-half value is no greater than every upper-half value, and sizes differ by at most one with a chosen larger side. Inserting and rebalancing costs `O(log n)`; reading the middle value(s) costs constant time.

For an even number of int values, add the middle values as long before averaging. A sliding median is harder because arbitrary deletions are needed. Lazy deletion requires counts and logical sizes, and stale elements may accumulate unless storage is managed; do not assume the simple streaming proof gives `O(k)` physical storage automatically.

## Java and update semantics

`PriorityQueue` provides logarithmic insertion/removal of the head and constant peek; `contains` and removal by object are linear. It does not expose a general decrease-key operation. For shortest paths, insert immutable `(distance,vertex)` entries and skip stale ones when polled. A true indexed heap maintains each item's position and repairs the heap after priority changes.

If equal priorities require FIFO behavior, add an increasing sequence number to the comparator. Mutating an entry's priority in place does not restore heap order.

## Explain it in English

> “The heap stores one relevant frontier candidate from each source.”

**Vocabulary:** priority, sift, complete tree, heapify, stale entry, tie-breaker.

## Practice

Attempt the [unit 13 exercise set](../../03_problems/02_practice/13_heaps-and-priority-queues/README.md). Exercises and hints live in `03_problems/`; this chapter contains the theory.

## Attribution and references

**Provenance:** This chapter is a synthesis of the sources mapped below. Standard definitions, algorithms and proof techniques belong to those established references; the explanatory wording, traces, diagrams and Java examples were written for this repository. No source passage is quoted verbatim.

| Section / claim | Source used | How it is used |
|---|---|---|
| Binary heaps and heap order | [Pat Morin, Open Data Structures, chapter 10](https://opendatastructures.org/ods-java/10_Heaps.html) | Heap representation and operations. |
| Linear bottom-up heap construction | [Demaine, Ku and Solomon, MIT 6.006 (Spring 2020)](https://ocw.mit.edu/courses/6-006-introduction-to-algorithms-spring-2020/pages/lecture-notes/) | Lecture 8; height-based aggregate proof. |
| Java priority queues | [Oracle Java 21: PriorityQueue](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/PriorityQueue.html) | Operation and iterator contracts. |

See [SOURCES.md](../../SOURCES.md) for editions, review scope, and the distinction between consulted material and further reading.

---

<!-- study-navigation -->
[← Previous: Unit 12](../05_trees/12-trees-and-ordered-maps.md) · [Index](../../README.md#study-index) · [Next: Unit 14A →](../07_graphs/14-graph-representations.md)
<!-- /study-navigation -->
