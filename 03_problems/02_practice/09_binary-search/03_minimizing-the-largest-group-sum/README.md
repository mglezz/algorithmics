# 09.03 - Minimizing the Largest Group Sum

<!-- study-navigation -->
[← Previous: Exercise 09.02](../02_integer-square-root/README.md) · [Index](../README.md) · [Next: Exercise 09.04 →](../04_rotated-arrays-with-duplicates/README.md)
<!-- /study-navigation -->

[Practice index](../../README.md) | Theory: [Binary Search and Monotone Decisions](../../../../01_algorithms/05_searching/09-binary-search.md)

**Status:** Not started. This is a repository-written practice prompt, not a recruiting question-bank item.

## Exercise

Implement `long minimizeLargestSum(int[] values, int k)` for a nonempty nonnegative array and `1<=k<=n`. Split into exactly k nonempty contiguous groups and return the smallest possible maximum group sum.

## Examples and checks

`[7,2,5,10,8], k=2` returns `18`; k=1 returns the total; k=n returns the largest element; all zeros return zero.

## Your workspace

Write your Java 17 implementation and an executable test runner in `src/`. Use `AlgorithmXX_YY.java` and `MainXX_YY.java` with this exercise's numbers, or keep the existing class names. For data-structure exercises, use the requested class and a separate runner. Compare actual and expected results, including the cases above; throw `AssertionError` on a mismatch (or run Java assertions with `-ea`).

The deliverable is working Java code and checks. You may add a short explanation of the algorithm in `src/README.md`, like exercise 02.01; a formal proof or a separate theoretical answer is not required. Unless stated otherwise, inputs are non-null, indices and graph endpoints are valid, and auxiliary result types such as `Node` or `Selection` are yours to define.

<details><summary>Implementation hint</summary>

Binary-search the answer using a greedy group-count check.

</details>

## Your solution

Keep your Java implementation and executable checks in `src/`. Optionally add a short algorithm explanation in `src/README.md`. Record the attempt in [PROGRESS.md](../../../../PROGRESS.md).

---

<!-- study-navigation -->
[← Previous: Exercise 09.02](../02_integer-square-root/README.md) · [Index](../README.md) · [Next: Exercise 09.04 →](../04_rotated-arrays-with-duplicates/README.md)
<!-- /study-navigation -->
