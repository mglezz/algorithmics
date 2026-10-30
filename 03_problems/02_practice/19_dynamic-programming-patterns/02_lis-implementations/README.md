# 19.02 - Two LIS Implementations

<!-- study-navigation -->
[← Previous: Exercise 19.01](../01_lcs-and-edit-reconstruction/README.md) · [Index](../README.md) · [Next: Exercise 19.03 →](../03_weighted-interval-scheduling/README.md)
<!-- /study-navigation -->

[Practice index](../../README.md) | Theory: [Dynamic Programming Patterns and Reconstruction](../../../../01_algorithms/10_dynamic-programming/19-dynamic-programming-patterns.md)

**Status:** Not started. This is a repository-written practice prompt, not a recruiting question-bank item.

## Exercise

Implement `int lisQuadratic(int[] values)` and `int lisFast(int[] values)` for the length of a strictly increasing subsequence, with O(n^2) and O(n log n) time respectively. Compare their outputs on seeded random arrays.

## Examples and checks

`[10,9,2,5,3,7,101,18]` returns 4; `[2,2,2]` returns 1; empty input returns 0.

## Your workspace

Write your Java 17 implementation and an executable test runner in `src/`. Use `AlgorithmXX_YY.java` and `MainXX_YY.java` with this exercise's numbers, or keep the existing class names. For data-structure exercises, use the requested class and a separate runner. Compare actual and expected results, including the cases above; throw `AssertionError` on a mismatch (or run Java assertions with `-ea`).

The deliverable is working Java code and checks. You may add a short explanation of the algorithm in `src/README.md`, like exercise 02.01; a formal proof or a separate theoretical answer is not required. Unless stated otherwise, inputs are non-null, indices and graph endpoints are valid, and auxiliary result types such as `Node` or `Selection` are yours to define.

<details><summary>Implementation hint</summary>

The fast version replaces the first tail greater than or equal to the current value.

</details>

## Your solution

Keep your Java implementation and executable checks in `src/`. Optionally add a short algorithm explanation in `src/README.md`. Record the attempt in [PROGRESS.md](../../../../PROGRESS.md).

---

<!-- study-navigation -->
[← Previous: Exercise 19.01](../01_lcs-and-edit-reconstruction/README.md) · [Index](../README.md) · [Next: Exercise 19.03 →](../03_weighted-interval-scheduling/README.md)
<!-- /study-navigation -->
