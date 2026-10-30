# 07.02 - Cycle Entry and Length

<!-- study-navigation -->
[← Previous: Exercise 07.01](../01_reversing-a-list-segment/README.md) · [Index](../README.md) · [Next: Exercise 07.03 →](../03_merging-sorted-lists/README.md)
<!-- /study-navigation -->

[Practice index](../../README.md) | Theory: [Linked Lists and Reference Manipulation](../../../../02_data-structures/03_linked-lists/07-linked-lists.md)

**Status:** Not started. This is a repository-written practice prompt, not a recruiting question-bank item.

## Exercise

Implement `CycleInfo detectCycle(Node head)` for a singly linked list, returning the entry node reference and cycle length. Return `(null,0)` when acyclic. Do not mutate nodes and use O(1) extra space.

## Examples and checks

For `a->b->c->d->b`, return entry b and length 3; a self-loop has length 1; null and an acyclic chain return `(null,0)`.

## Your workspace

Write your Java 17 implementation and an executable test runner in `src/`. Use `AlgorithmXX_YY.java` and `MainXX_YY.java` with this exercise's numbers, or keep the existing class names. For data-structure exercises, use the requested class and a separate runner. Compare actual and expected results, including the cases above; throw `AssertionError` on a mismatch (or run Java assertions with `-ea`).

The deliverable is working Java code and checks. You may add a short explanation of the algorithm in `src/README.md`, like exercise 02.01; a formal proof or a separate theoretical answer is not required. Unless stated otherwise, inputs are non-null, indices and graph endpoints are valid, and auxiliary result types such as `Node` or `Selection` are yours to define.

<details><summary>Implementation hint</summary>

Use slow and fast pointers, then count one lap and locate the entry.

</details>

## Your solution

Keep your Java implementation and executable checks in `src/`. Optionally add a short algorithm explanation in `src/README.md`. Record the attempt in [PROGRESS.md](../../../../PROGRESS.md).

---

<!-- study-navigation -->
[← Previous: Exercise 07.01](../01_reversing-a-list-segment/README.md) · [Index](../README.md) · [Next: Exercise 07.03 →](../03_merging-sorted-lists/README.md)
<!-- /study-navigation -->
