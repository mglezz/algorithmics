# 07.03 - Merging Sorted Lists

<!-- study-navigation -->
[← Previous: Exercise 07.02](../02_cycle-entry-and-length/README.md) · [Index](../README.md) · [Next: Exercise 07.04 →](../04_lru-cache/README.md)
<!-- /study-navigation -->

[Practice index](../../README.md) | Theory: [Linked Lists and Reference Manipulation](../../../../02_data-structures/03_linked-lists/07-linked-lists.md)

**Status:** Not started. This is a repository-written practice prompt, not a recruiting question-bank item.

## Exercise

Implement `Node merge(Node first, Node second)` for two sorted, acyclic lists with no shared nodes. Rewire the existing nodes into one sorted list. On equal values, take the node from the first list first.

## Examples and checks

`1->3` and `1->2` merge into `1->1->2->3`; check node identities, empty lists and a remaining suffix.

## Your workspace

Write your Java 17 implementation and an executable test runner in `src/`. Use `AlgorithmXX_YY.java` and `MainXX_YY.java` with this exercise's numbers, or keep the existing class names. For data-structure exercises, use the requested class and a separate runner. Compare actual and expected results, including the cases above; throw `AssertionError` on a mismatch (or run Java assertions with `-ea`).

The deliverable is working Java code and checks. You may add a short explanation of the algorithm in `src/README.md`, like exercise 02.01; a formal proof or a separate theoretical answer is not required. Unless stated otherwise, inputs are non-null, indices and graph endpoints are valid, and auxiliary result types such as `Node` or `Selection` are yours to define.

<details><summary>Implementation hint</summary>

Link the smaller current node and attach the remaining list when one ends.

</details>

## Your solution

Keep your Java implementation and executable checks in `src/`. Optionally add a short algorithm explanation in `src/README.md`. Record the attempt in [PROGRESS.md](../../../../PROGRESS.md).

---

<!-- study-navigation -->
[← Previous: Exercise 07.02](../02_cycle-entry-and-length/README.md) · [Index](../README.md) · [Next: Exercise 07.04 →](../04_lru-cache/README.md)
<!-- /study-navigation -->
