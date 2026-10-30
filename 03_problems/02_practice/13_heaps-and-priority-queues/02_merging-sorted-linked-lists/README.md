# 13.02 - Merging K Sorted Lists

<!-- study-navigation -->
[← Previous: Exercise 13.01](../01_sift-down/README.md) · [Index](../README.md) · [Next: Exercise 13.03 →](../03_running-median/README.md)
<!-- /study-navigation -->

[Practice index](../../README.md) | Theory: [Heaps and Priority Queues](../../../../02_data-structures/06_heaps/13-heaps-and-priority-queues.md)

**Status:** Not started. This is a repository-written practice prompt, not a recruiting question-bank item.

## Exercise

Implement `Node mergeK(Node[] heads)` for sorted, acyclic, pairwise-disjoint singly linked lists. Reuse their nodes and use a priority queue with at most one pending node per list. Empty lists are allowed.

## Examples and checks

`[1->4,1->3,2->6]` merges into `1->1->2->3->4->6`; verify node identities and test zero lists.

## Your workspace

Write your Java 17 implementation and an executable test runner in `src/`. Use `AlgorithmXX_YY.java` and `MainXX_YY.java` with this exercise's numbers, or keep the existing class names. For data-structure exercises, use the requested class and a separate runner. Compare actual and expected results, including the cases above; throw `AssertionError` on a mismatch (or run Java assertions with `-ea`).

The deliverable is working Java code and checks. You may add a short explanation of the algorithm in `src/README.md`, like exercise 02.01; a formal proof or a separate theoretical answer is not required. Unless stated otherwise, inputs are non-null, indices and graph endpoints are valid, and auxiliary result types such as `Node` or `Selection` are yours to define.

<details><summary>Implementation hint</summary>

Save a removed node's successor before rewiring it.

</details>

## Your solution

Keep your Java implementation and executable checks in `src/`. Optionally add a short algorithm explanation in `src/README.md`. Record the attempt in [PROGRESS.md](../../../../PROGRESS.md).

---

<!-- study-navigation -->
[← Previous: Exercise 13.01](../01_sift-down/README.md) · [Index](../README.md) · [Next: Exercise 13.03 →](../03_running-median/README.md)
<!-- /study-navigation -->
