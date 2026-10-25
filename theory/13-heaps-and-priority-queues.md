# 13 - Heaps and Priority Queues

[Curriculum](README.md) | Prerequisites: 04, 12

## Heap order is weaker than sorted order

A min-heap is a complete binary tree whose parent is no greater than either child. Thus the root is globally smallest, but siblings and unrelated subtrees need not be ordered. Searching for an arbitrary value remains linear in the worst case.

An array stores a binary heap compactly. For zero-based index `i`, children are `2i+1` and `2i+2`; the parent for `i>0` is `(i-1)/2`. Completeness ensures no gaps. Keep logical size separate from backing-array capacity and guard child-index arithmetic at numerical boundaries.

Insertion appends then **sifts up** while the parent is too large. Removing the minimum moves the last entry to the root, reduces size, and **sifts down**, exchanging with the smaller child while needed. Only one ancestor/descendant path changes, so each operation takes `O(log n)` time; peek takes `O(1)`.

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

## Practice

1. Implement sift-down and prove that only the chosen child path can remain invalid.
2. Merge sorted linked lists without losing the successor before rewiring.
3. Maintain a running median and compare every prefix with a sorted copy.
4. Choose a structure for frequent minimum extraction versus predecessor queries.

<details><summary>Hints and checkpoints</summary>

1. Exchange with the smaller child, not an arbitrary child.
2. Save the removed node's next reference and enqueue it before changing links.
3. Include negative extremes, equal values, and alternating very small/large values.
4. A heap supports the minimum well; an ordered tree supports ordered navigation.

</details>

**Explain aloud:** “The heap stores one relevant frontier candidate from each source.” Vocabulary: priority, sift, complete tree, heapify, stale entry, tie-breaker.

## Sources

- [Open Data Structures, Heaps](https://opendatastructures.org/ods-java/10_Heaps.html): heap representations and operations.
- [MIT 6.006 lecture notes](https://ocw.mit.edu/courses/6-006-introduction-to-algorithms-spring-2020/pages/lecture-notes/), lecture 8: binary heaps and linear construction.
- [Oracle PriorityQueue](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/PriorityQueue.html): Java costs and iteration semantics.
