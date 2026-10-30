# 12.04 - Height, Balance and Diameter

<!-- study-navigation -->
[← Previous: Exercise 12.03](../03_tree-serialization/README.md) · [Index](../README.md) · [Next: Exercise 13.01 →](../../13_heaps-and-priority-queues/01_sift-down/README.md)
<!-- /study-navigation -->

[Practice index](../../README.md) | Theory: [Trees, Ordered Maps, and Augmentation](../../../../02_data-structures/05_trees/12-trees-and-ordered-maps.md)

**Status:** Not started. This is a repository-written practice prompt, not a recruiting question-bank item.

## Exercise

Implement `TreeStats analyze(Node root)` returning height in edges, whether every node's child heights differ by at most one, and diameter in edges. Use one postorder traversal. Null has height -1, diameter 0 and is balanced.

## Examples and checks

A leaf gives `(0,true,0)`; a three-node chain gives `(2,false,2)`; a root with two leaves gives `(1,true,2)`.

## Your workspace

Write your Java 17 implementation and an executable test runner in `src/`. Use `AlgorithmXX_YY.java` and `MainXX_YY.java` with this exercise's numbers, or keep the existing class names. For data-structure exercises, use the requested class and a separate runner. Compare actual and expected results, including the cases above; throw `AssertionError` on a mismatch (or run Java assertions with `-ea`).

The deliverable is working Java code and checks. You may add a short explanation of the algorithm in `src/README.md`, like exercise 02.01; a formal proof or a separate theoretical answer is not required. Unless stated otherwise, inputs are non-null, indices and graph endpoints are valid, and auxiliary result types such as `Node` or `Selection` are yours to define.

<details><summary>Implementation hint</summary>

Combine child summaries instead of traversing subtrees again.

</details>

## Your solution

Keep your Java implementation and executable checks in `src/`. Optionally add a short algorithm explanation in `src/README.md`. Record the attempt in [PROGRESS.md](../../../../PROGRESS.md).

---

<!-- study-navigation -->
[← Previous: Exercise 12.03](../03_tree-serialization/README.md) · [Index](../README.md) · [Next: Exercise 13.01 →](../../13_heaps-and-priority-queues/01_sift-down/README.md)
<!-- /study-navigation -->
