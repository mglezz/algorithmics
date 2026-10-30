# 13.01 - Min-Heap Sift-Down

<!-- study-navigation -->
[← Previous: Exercise 12.04](../../12_trees-and-ordered-maps/04_height-balance-and-diameter/README.md) · [Index](../README.md) · [Next: Exercise 13.02 →](../02_merging-sorted-linked-lists/README.md)
<!-- /study-navigation -->

[Practice index](../../README.md) | Theory: [Heaps and Priority Queues](../../../../02_data-structures/06_heaps/13-heaps-and-priority-queues.md)

**Status:** Not started. This is a repository-written practice prompt, not a recruiting question-bank item.

## Exercise

Implement `void siftDown(int[] heap, int size, int index)` for a valid index in the active prefix `[0,size)`. Both child subtrees are already min-heaps; only the indexed value may violate heap order. Restore that subtree without modifying values outside the active prefix.

## Examples and checks

`[9,2,3,4,5]`, size=5, index=0 becomes a min-heap with the same values. Check a leaf, one child and equal children.

## Your workspace

Write your Java 17 implementation and an executable test runner in `src/`. Use `AlgorithmXX_YY.java` and `MainXX_YY.java` with this exercise's numbers, or keep the existing class names. For data-structure exercises, use the requested class and a separate runner. Compare actual and expected results, including the cases above; throw `AssertionError` on a mismatch (or run Java assertions with `-ea`).

The deliverable is working Java code and checks. You may add a short explanation of the algorithm in `src/README.md`, like exercise 02.01; a formal proof or a separate theoretical answer is not required. Unless stated otherwise, inputs are non-null, indices and graph endpoints are valid, and auxiliary result types such as `Node` or `Selection` are yours to define.

<details><summary>Implementation hint</summary>

Swap with the smaller child and continue down that path.

</details>

## Your solution

Keep your Java implementation and executable checks in `src/`. Optionally add a short algorithm explanation in `src/README.md`. Record the attempt in [PROGRESS.md](../../../../PROGRESS.md).

---

<!-- study-navigation -->
[← Previous: Exercise 12.04](../../12_trees-and-ordered-maps/04_height-balance-and-diameter/README.md) · [Index](../README.md) · [Next: Exercise 13.02 →](../02_merging-sorted-linked-lists/README.md)
<!-- /study-navigation -->
