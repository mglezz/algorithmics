# 01.01 - Sorted Array Deduplication

<!-- study-navigation -->
[← Previous: Unit index](../README.md) · [Index](../README.md) · [Next: Exercise 01.02 →](../02_array-reversal-invariant/README.md)
<!-- /study-navigation -->

[Practice index](../../README.md) | Theory: [Discrete Mathematics and Correctness](../../../../01_algorithms/01_foundations/01-mathematics-and-correctness.md)

**Status:** Not started. This is a repository-written practice prompt, not a recruiting question-bank item.

## Exercise

Implement `int removeDuplicated(int[] values)` for a sorted array. Modify it in place so the first returned-length elements contain each distinct value once, in ascending order. The remaining suffix is unspecified. Use O(1) extra space.

## Examples and checks

`[1,1,2,2,3]` returns `3` and leaves prefix `[1,2,3]`; `[]` returns `0`; `[4,4]` returns `1`.

## Your workspace

Write your Java 17 implementation and an executable test runner in `src/`. Use `AlgorithmXX_YY.java` and `MainXX_YY.java` with this exercise's numbers, or keep the existing class names. For data-structure exercises, use the requested class and a separate runner. Compare actual and expected results, including the cases above; throw `AssertionError` on a mismatch (or run Java assertions with `-ea`).

The deliverable is working Java code and checks. You may add a short explanation of the algorithm in `src/README.md`, like exercise 02.01; a formal proof or a separate theoretical answer is not required. Unless stated otherwise, inputs are non-null, indices and graph endpoints are valid, and auxiliary result types such as `Node` or `Selection` are yours to define.

<details><summary>Implementation hint</summary>

Keep a write position for the next distinct value.

</details>

## Your solution

Keep your Java implementation and executable checks in `src/`. Optionally add a short algorithm explanation in `src/README.md`. Record the attempt in [PROGRESS.md](../../../../PROGRESS.md).

---

<!-- study-navigation -->
[← Previous: Unit index](../README.md) · [Index](../README.md) · [Next: Exercise 01.02 →](../02_array-reversal-invariant/README.md)
<!-- /study-navigation -->
