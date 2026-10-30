# 12.02 - Kth Smallest BST Key

<!-- study-navigation -->
[← Previous: Exercise 12.01](../01_bst-validation/README.md) · [Index](../README.md) · [Next: Exercise 12.03 →](../03_tree-serialization/README.md)
<!-- /study-navigation -->

[Practice index](../../README.md) | Theory: [Trees, Ordered Maps, and Augmentation](../../../../02_data-structures/05_trees/12-trees-and-ordered-maps.md)

**Status:** Not started. This is a repository-written practice prompt, not a recruiting question-bank item.

## Exercise

Implement `int kthSmallest(Node root, int k)` for a strict BST using iterative inorder traversal. k is one-based; throw IllegalArgumentException if k<=0 or exceeds the number of nodes.

## Examples and checks

In a BST containing 1,2,3, k=2 returns 2. Test first and last keys, a skewed tree and invalid k.

## Your workspace

Write your Java 17 implementation and an executable test runner in `src/`. Use `AlgorithmXX_YY.java` and `MainXX_YY.java` with this exercise's numbers, or keep the existing class names. For data-structure exercises, use the requested class and a separate runner. Compare actual and expected results, including the cases above; throw `AssertionError` on a mismatch (or run Java assertions with `-ea`).

The deliverable is working Java code and checks. You may add a short explanation of the algorithm in `src/README.md`, like exercise 02.01; a formal proof or a separate theoretical answer is not required. Unless stated otherwise, inputs are non-null, indices and graph endpoints are valid, and auxiliary result types such as `Node` or `Selection` are yours to define.

<details><summary>Implementation hint</summary>

Use an explicit stack and stop at the kth visited node.

</details>

## Your solution

Keep your Java implementation and executable checks in `src/`. Optionally add a short algorithm explanation in `src/README.md`. Record the attempt in [PROGRESS.md](../../../../PROGRESS.md).

---

<!-- study-navigation -->
[← Previous: Exercise 12.01](../01_bst-validation/README.md) · [Index](../README.md) · [Next: Exercise 12.03 →](../03_tree-serialization/README.md)
<!-- /study-navigation -->
