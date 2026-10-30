# 04.04 - Product Except Self

<!-- study-navigation -->
[← Previous: Exercise 04.03](../03_rectangle-sums/README.md) · [Index](../README.md) · [Next: Exercise 05.01 →](../../05_hash-tables/01_longest-target-sum-range/README.md)
<!-- /study-navigation -->

[Practice index](../../README.md) | Theory: [Arrays and Strings](../../../../02_data-structures/01_arrays-and-strings/04-arrays-and-strings.md) | [Prefix Sums and Difference Arrays](../../../../01_algorithms/02_range-queries/04-prefix-sums-and-difference-arrays.md)

**Status:** Not started. This is a repository-written practice prompt, not a recruiting question-bank item.

## Exercise

Implement `long[] productExceptSelf(int[] values)` without division in O(n) time and O(1) extra space beyond the result. Assume every intermediate prefix and suffix product fits in long. Empty input returns an empty array and a single element produces `[1]`.

## Examples and checks

`[1,2,3,4]` returns `[24,12,8,6]`; `[0,2,3]` returns `[6,0,0]`; two zeros produce all zeros.

## Your workspace

Write your Java 17 implementation and an executable test runner in `src/`. Use `AlgorithmXX_YY.java` and `MainXX_YY.java` with this exercise's numbers, or keep the existing class names. For data-structure exercises, use the requested class and a separate runner. Compare actual and expected results, including the cases above; throw `AssertionError` on a mismatch (or run Java assertions with `-ea`).

The deliverable is working Java code and checks. You may add a short explanation of the algorithm in `src/README.md`, like exercise 02.01; a formal proof or a separate theoretical answer is not required. Unless stated otherwise, inputs are non-null, indices and graph endpoints are valid, and auxiliary result types such as `Node` or `Selection` are yours to define.

<details><summary>Implementation hint</summary>

Store prefix products in the result, then multiply by suffix products.

</details>

## Your solution

Keep your Java implementation and executable checks in `src/`. Optionally add a short algorithm explanation in `src/README.md`. Record the attempt in [PROGRESS.md](../../../../PROGRESS.md).

---

<!-- study-navigation -->
[← Previous: Exercise 04.03](../03_rectangle-sums/README.md) · [Index](../README.md) · [Next: Exercise 05.01 →](../../05_hash-tables/01_longest-target-sum-range/README.md)
<!-- /study-navigation -->
