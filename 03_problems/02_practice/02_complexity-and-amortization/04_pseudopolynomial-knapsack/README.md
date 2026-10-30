# 02.04 - Capacity-Limited Knapsack

<!-- study-navigation -->
[← Previous: Exercise 02.03](../03_monotonic-stack-amortization/README.md) · [Index](../README.md) · [Next: Exercise 03.01 →](../../03_java-for-interviews/01_integer-promotion/README.md)
<!-- /study-navigation -->

[Practice index](../../README.md) | Theory: [Complexity, Recurrences, and Amortization](../../../../01_algorithms/01_foundations/02-complexity-and-amortization.md)

**Status:** Not started. This is a repository-written practice prompt, not a recruiting question-bank item.

## Exercise

Implement `long maxValue(int[] weights, int[] values, int capacity)` for 0/1 knapsack. Weights are positive, values nonnegative, arrays have equal length and `0<=capacity<=10000`. Each item may be used once. Use capacity-based DP with O(capacity) extra space.

## Examples and checks

Weights `[2,3,4]`, values `[4,5,7]`, capacity `5` return `9`; empty items or capacity zero return `0`; one item of weight 2 cannot be used twice.

## Your workspace

Write your Java 17 implementation and an executable test runner in `src/`. Use `AlgorithmXX_YY.java` and `MainXX_YY.java` with this exercise's numbers, or keep the existing class names. For data-structure exercises, use the requested class and a separate runner. Compare actual and expected results, including the cases above; throw `AssertionError` on a mismatch (or run Java assertions with `-ea`).

The deliverable is working Java code and checks. You may add a short explanation of the algorithm in `src/README.md`, like exercise 02.01; a formal proof or a separate theoretical answer is not required. Unless stated otherwise, inputs are non-null, indices and graph endpoints are valid, and auxiliary result types such as `Node` or `Selection` are yours to define.

<details><summary>Implementation hint</summary>

Scan capacities downward for each item. Capacity controls the size of the DP array.

</details>

## Your solution

Keep your Java implementation and executable checks in `src/`. Optionally add a short algorithm explanation in `src/README.md`. Record the attempt in [PROGRESS.md](../../../../PROGRESS.md).

---

<!-- study-navigation -->
[← Previous: Exercise 02.03](../03_monotonic-stack-amortization/README.md) · [Index](../README.md) · [Next: Exercise 03.01 →](../../03_java-for-interviews/01_integer-promotion/README.md)
<!-- /study-navigation -->
