# 22.01 - Two Singleton Values

<!-- study-navigation -->
[← Previous: Exercise 21.04](../../21_range-query-data-structures/04_sparse-table-overlap/README.md) · [Index](../README.md) · [Next: Exercise 22.02 →](../02_modular-exponentiation/README.md)
<!-- /study-navigation -->

[Practice index](../../README.md) | Theory: [Bits, Number Theory, and Randomized Algorithms](../../../../01_algorithms/12_mathematics/22-bits-number-theory-and-randomness.md)

**Status:** Not started. This is a repository-written practice prompt, not a recruiting question-bank item.

## Exercise

Implement `int[] twoSingles(int[] values)` where exactly two different values appear once and every other value appears twice. Return the two singletons in ascending order, using O(n) time and O(1) extra space.

## Examples and checks

`[1,2,1,3,2,5]` returns `[3,5]`; test negative values, zero and Integer.MIN_VALUE.

## Your workspace

Write your Java 17 implementation and an executable test runner in `src/`. Use `AlgorithmXX_YY.java` and `MainXX_YY.java` with this exercise's numbers, or keep the existing class names. For data-structure exercises, use the requested class and a separate runner. Compare actual and expected results, including the cases above; throw `AssertionError` on a mismatch (or run Java assertions with `-ea`).

The deliverable is working Java code and checks. You may add a short explanation of the algorithm in `src/README.md`, like exercise 02.01; a formal proof or a separate theoretical answer is not required. Unless stated otherwise, inputs are non-null, indices and graph endpoints are valid, and auxiliary result types such as `Node` or `Selection` are yours to define.

<details><summary>Implementation hint</summary>

Partition using one set bit of the XOR of all values.

</details>

## Your solution

Keep your Java implementation and executable checks in `src/`. Optionally add a short algorithm explanation in `src/README.md`. Record the attempt in [PROGRESS.md](../../../../PROGRESS.md).

---

<!-- study-navigation -->
[← Previous: Exercise 21.04](../../21_range-query-data-structures/04_sparse-table-overlap/README.md) · [Index](../README.md) · [Next: Exercise 22.02 →](../02_modular-exponentiation/README.md)
<!-- /study-navigation -->
