# 04.03 - Rectangle Sum Queries

<!-- study-navigation -->
[← Previous: Exercise 04.02](../02_range-increments/README.md) · [Index](../README.md) · [Next: Exercise 04.04 →](../04_product-except-self/README.md)
<!-- /study-navigation -->

[Practice index](../../README.md) | Theory: [Arrays and Strings](../../../../02_data-structures/01_arrays-and-strings/04-arrays-and-strings.md) | [Prefix Sums and Difference Arrays](../../../../01_algorithms/02_range-queries/04-prefix-sums-and-difference-arrays.md)

**Status:** Not started. This is a repository-written practice prompt, not a recruiting question-bank item.

## Exercise

Implement a `RectangleSums` class constructed from a rectangular `int[][]` matrix, with `long sum(int top, int left, int bottom, int right)`. Query half-open rows `[top,bottom)` and columns `[left,right)`. Preprocess once and answer each query in O(1); empty rectangles return zero.

## Examples and checks

For `[[1,2],[3,4]]`, the full rectangle sums to 10, `(1,0,2,1)` to 3 and `(0,1,2,1)` to 0. Support an empty matrix.

## Your workspace

Write your Java 17 implementation and an executable test runner in `src/`. Use `AlgorithmXX_YY.java` and `MainXX_YY.java` with this exercise's numbers, or keep the existing class names. For data-structure exercises, use the requested class and a separate runner. Compare actual and expected results, including the cases above; throw `AssertionError` on a mismatch (or run Java assertions with `-ea`).

The deliverable is working Java code and checks. You may add a short explanation of the algorithm in `src/README.md`, like exercise 02.01; a formal proof or a separate theoretical answer is not required. Unless stated otherwise, inputs are non-null, indices and graph endpoints are valid, and auxiliary result types such as `Node` or `Selection` are yours to define.

<details><summary>Implementation hint</summary>

Use a padded two-dimensional prefix table and four lookups.

</details>

## Your solution

Keep your Java implementation and executable checks in `src/`. Optionally add a short algorithm explanation in `src/README.md`. Record the attempt in [PROGRESS.md](../../../../PROGRESS.md).

---

<!-- study-navigation -->
[← Previous: Exercise 04.02](../02_range-increments/README.md) · [Index](../README.md) · [Next: Exercise 04.04 →](../04_product-except-self/README.md)
<!-- /study-navigation -->
