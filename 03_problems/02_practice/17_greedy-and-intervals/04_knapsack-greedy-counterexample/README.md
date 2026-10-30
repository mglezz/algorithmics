# 17.04 - Greedy and Exact Knapsack Implementations

<!-- study-navigation -->
[← Previous: Exercise 17.03](../03_interval-union-length/README.md) · [Index](../README.md) · [Next: Exercise 18.01 →](../../18_dynamic-programming/01_nonadjacent-selection-reconstruction/README.md)
<!-- /study-navigation -->

[Practice index](../../README.md) | Theory: [Greedy Algorithms, Intervals, and Sweeps](../../../../01_algorithms/09_greedy/17-greedy-and-intervals.md)

**Status:** Not started. This is a repository-written practice prompt, not a recruiting question-bank item.

## Exercise

Implement `long greedyValue(int[] weights, int[] values, int capacity)` selecting whole items by decreasing value/weight ratio, ties by original index, skipping items that do not fit. Also implement exact 0/1 DP and compare outputs. Weights are positive and values nonnegative.

## Examples and checks

Weights `[10,20,30]`, values `[60,100,120]`, capacity 50 give greedy 160 and optimal 220; check empty input and zero capacity.

## Your workspace

Write your Java 17 implementation and an executable test runner in `src/`. Use `AlgorithmXX_YY.java` and `MainXX_YY.java` with this exercise's numbers, or keep the existing class names. For data-structure exercises, use the requested class and a separate runner. Compare actual and expected results, including the cases above; throw `AssertionError` on a mismatch (or run Java assertions with `-ea`).

The deliverable is working Java code and checks. You may add a short explanation of the algorithm in `src/README.md`, like exercise 02.01; a formal proof or a separate theoretical answer is not required. Unless stated otherwise, inputs are non-null, indices and graph endpoints are valid, and auxiliary result types such as `Node` or `Selection` are yours to define.

<details><summary>Implementation hint</summary>

Compare ratios by long cross-products rather than integer division; reuse the capacity DP pattern for the exact method.

</details>

## Your solution

Keep your Java implementation and executable checks in `src/`. Optionally add a short algorithm explanation in `src/README.md`. Record the attempt in [PROGRESS.md](../../../../PROGRESS.md).

---

<!-- study-navigation -->
[← Previous: Exercise 17.03](../03_interval-union-length/README.md) · [Index](../README.md) · [Next: Exercise 18.01 →](../../18_dynamic-programming/01_nonadjacent-selection-reconstruction/README.md)
<!-- /study-navigation -->
