# 09.04 - Search in Rotated Arrays with Duplicates

<!-- study-navigation -->
[← Previous: Exercise 09.03](../03_minimizing-the-largest-group-sum/README.md) · [Index](../README.md) · [Next: Exercise 10.01 →](../../10_sorting-and-selection/01_stable-merge-sort/README.md)
<!-- /study-navigation -->

[Practice index](../../README.md) | Theory: [Binary Search and Monotone Decisions](../../../../01_algorithms/05_searching/09-binary-search.md)

**Status:** Not started. This is a repository-written practice prompt, not a recruiting question-bank item.

## Exercise

Implement `boolean contains(int[] values, int target)` for a nondecreasing array rotated at an unknown position, possibly containing duplicates. Use binary-search decisions and handle ambiguous equal endpoints; linear worst-case time is allowed.

## Examples and checks

`[1,1,1,0,1]` contains 0 but not 2; test empty input, no rotation and all equal values.

## Your workspace

Write your Java 17 implementation and an executable test runner in `src/`. Use `AlgorithmXX_YY.java` and `MainXX_YY.java` with this exercise's numbers, or keep the existing class names. For data-structure exercises, use the requested class and a separate runner. Compare actual and expected results, including the cases above; throw `AssertionError` on a mismatch (or run Java assertions with `-ea`).

The deliverable is working Java code and checks. You may add a short explanation of the algorithm in `src/README.md`, like exercise 02.01; a formal proof or a separate theoretical answer is not required. Unless stated otherwise, inputs are non-null, indices and graph endpoints are valid, and auxiliary result types such as `Node` or `Selection` are yours to define.

<details><summary>Implementation hint</summary>

When equal boundary values hide the sorted half, shrink cautiously.

</details>

## Your solution

Keep your Java implementation and executable checks in `src/`. Optionally add a short algorithm explanation in `src/README.md`. Record the attempt in [PROGRESS.md](../../../../PROGRESS.md).

---

<!-- study-navigation -->
[← Previous: Exercise 09.03](../03_minimizing-the-largest-group-sum/README.md) · [Index](../README.md) · [Next: Exercise 10.01 →](../../10_sorting-and-selection/01_stable-merge-sort/README.md)
<!-- /study-navigation -->
