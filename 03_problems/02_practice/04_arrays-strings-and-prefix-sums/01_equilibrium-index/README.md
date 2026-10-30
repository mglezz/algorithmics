# 04.01 - Equilibrium Index

<!-- study-navigation -->
[← Previous: Exercise 03.04](../../03_java-for-interviews/04_dependency-trace-complexity/README.md) · [Index](../README.md) · [Next: Exercise 04.02 →](../02_range-increments/README.md)
<!-- /study-navigation -->

[Practice index](../../README.md) | Theory: [Arrays and Strings](../../../../02_data-structures/01_arrays-and-strings/04-arrays-and-strings.md) | [Prefix Sums and Difference Arrays](../../../../01_algorithms/02_range-queries/04-prefix-sums-and-difference-arrays.md)

**Status:** Not started. This is a repository-written practice prompt, not a recruiting question-bank item.

## Exercise

Implement `int equilibriumIndex(int[] values)` returning the smallest index whose left and right sums are equal, excluding that element. Return `-1` if none exists. Accumulate sums as long.

## Examples and checks

`[-7,1,5,2,-4,3,0]` returns `3`; `[8]` returns `0`; `[]` and `[1,2]` return `-1`.

## Your workspace

Write your Java 17 implementation and an executable test runner in `src/`. Use `AlgorithmXX_YY.java` and `MainXX_YY.java` with this exercise's numbers, or keep the existing class names. For data-structure exercises, use the requested class and a separate runner. Compare actual and expected results, including the cases above; throw `AssertionError` on a mismatch (or run Java assertions with `-ea`).

The deliverable is working Java code and checks. You may add a short explanation of the algorithm in `src/README.md`, like exercise 02.01; a formal proof or a separate theoretical answer is not required. Unless stated otherwise, inputs are non-null, indices and graph endpoints are valid, and auxiliary result types such as `Node` or `Selection` are yours to define.

<details><summary>Implementation hint</summary>

Compute the total once and maintain the left sum while scanning.

</details>

## Your solution

Keep your Java implementation and executable checks in `src/`. Optionally add a short algorithm explanation in `src/README.md`. Record the attempt in [PROGRESS.md](../../../../PROGRESS.md).

---

<!-- study-navigation -->
[← Previous: Exercise 03.04](../../03_java-for-interviews/04_dependency-trace-complexity/README.md) · [Index](../README.md) · [Next: Exercise 04.02 →](../02_range-increments/README.md)
<!-- /study-navigation -->
