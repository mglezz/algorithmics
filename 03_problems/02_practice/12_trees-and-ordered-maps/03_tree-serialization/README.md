# 12.03 - Tree Serialization

<!-- study-navigation -->
[← Previous: Exercise 12.02](../02_kth-smallest-key/README.md) · [Index](../README.md) · [Next: Exercise 12.04 →](../04_height-balance-and-diameter/README.md)
<!-- /study-navigation -->

[Practice index](../../README.md) | Theory: [Trees, Ordered Maps, and Augmentation](../../../../02_data-structures/05_trees/12-trees-and-ordered-maps.md)

**Status:** Not started. This is a repository-written practice prompt, not a recruiting question-bank item.

## Exercise

Implement `String serialize(Node root)` and `Node deserialize(String data)` for binary trees with int keys. Use preorder comma-separated tokens and `#` for null; deserialization must reject malformed data with IllegalArgumentException.

## Examples and checks

A root 1 with only right child 2 serializes as `1,#,2,#,#`; null serializes as `#`. Check structural round trips, negative keys and missing/extra tokens.

## Your workspace

Write your Java 17 implementation and an executable test runner in `src/`. Use `AlgorithmXX_YY.java` and `MainXX_YY.java` with this exercise's numbers, or keep the existing class names. For data-structure exercises, use the requested class and a separate runner. Compare actual and expected results, including the cases above; throw `AssertionError` on a mismatch (or run Java assertions with `-ea`).

The deliverable is working Java code and checks. You may add a short explanation of the algorithm in `src/README.md`, like exercise 02.01; a formal proof or a separate theoretical answer is not required. Unless stated otherwise, inputs are non-null, indices and graph endpoints are valid, and auxiliary result types such as `Node` or `Selection` are yours to define.

<details><summary>Implementation hint</summary>

Null markers distinguish trees with identical value traversals.

</details>

## Your solution

Keep your Java implementation and executable checks in `src/`. Optionally add a short algorithm explanation in `src/README.md`. Record the attempt in [PROGRESS.md](../../../../PROGRESS.md).

---

<!-- study-navigation -->
[← Previous: Exercise 12.02](../02_kth-smallest-key/README.md) · [Index](../README.md) · [Next: Exercise 12.04 →](../04_height-balance-and-diameter/README.md)
<!-- /study-navigation -->
