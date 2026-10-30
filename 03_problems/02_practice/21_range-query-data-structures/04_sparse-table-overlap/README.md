# 21.04 - Static Range Minimum and Sum

<!-- study-navigation -->
[← Previous: Exercise 21.03](../03_lazy-assignment-and-addition/README.md) · [Index](../README.md) · [Next: Exercise 22.01 →](../../22_bits-number-theory-and-randomness/01_two-singleton-values/README.md)
<!-- /study-navigation -->

[Practice index](../../README.md) | Theory: [Fenwick Trees, Segment Trees, and Sparse Tables](../../../../02_data-structures/10_range-queries/21-range-query-data-structures.md)

**Status:** Not started. This is a repository-written practice prompt, not a recruiting question-bank item.

## Exercise

Implement `StaticQueries(int[] values)` with `int min(int left,int right)` and `long sum(int left,int right)` on half-open ranges. Use a sparse table for O(1) nonempty minimum queries and prefix sums for O(1) sums. Empty queries return Integer.MAX_VALUE and 0 respectively.

## Examples and checks

For `[2,4,1,3]`, query `[0,3)` gives minimum 1 and sum 7; check single-element, full and empty ranges.

## Your workspace

Write your Java 17 implementation and an executable test runner in `src/`. Use `AlgorithmXX_YY.java` and `MainXX_YY.java` with this exercise's numbers, or keep the existing class names. For data-structure exercises, use the requested class and a separate runner. Compare actual and expected results, including the cases above; throw `AssertionError` on a mismatch (or run Java assertions with `-ea`).

The deliverable is working Java code and checks. You may add a short explanation of the algorithm in `src/README.md`, like exercise 02.01; a formal proof or a separate theoretical answer is not required. Unless stated otherwise, inputs are non-null, indices and graph endpoints are valid, and auxiliary result types such as `Node` or `Selection` are yours to define.

<details><summary>Implementation hint</summary>

Overlapping sparse-table blocks work for minimum; prefix subtraction avoids counting sum elements twice.

</details>

## Your solution

Keep your Java implementation and executable checks in `src/`. Optionally add a short algorithm explanation in `src/README.md`. Record the attempt in [PROGRESS.md](../../../../PROGRESS.md).

---

<!-- study-navigation -->
[← Previous: Exercise 21.03](../03_lazy-assignment-and-addition/README.md) · [Index](../README.md) · [Next: Exercise 22.01 →](../../22_bits-number-theory-and-randomness/01_two-singleton-values/README.md)
<!-- /study-navigation -->
