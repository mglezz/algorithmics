# 18.01 - Nonadjacent Selection Reconstruction

<!-- study-navigation -->
[← Previous: Exercise 17.04](../../17_greedy-and-intervals/04_knapsack-greedy-counterexample/README.md) · [Index](../README.md) · [Next: Exercise 18.02 →](../02_minimum-coin-count/README.md)
<!-- /study-navigation -->

[Practice index](../../README.md) | Theory: [Dynamic Programming from First Principles](../../../../01_algorithms/10_dynamic-programming/18-dynamic-programming.md)

**Status:** Not started. This is a repository-written practice prompt, not a recruiting question-bank item.

## Exercise

Implement `Selection bestNonAdjacent(int[] values)` returning the maximum long sum and chosen indices in increasing order, with no adjacent indices. Allow an empty selection. On equal take/skip totals, skip the current index during reconstruction.

## Examples and checks

`[2,7,9,3,1]` gives sum 12 with indices `[0,2,4]`; all negative values give sum 0 and no indices.

## Your workspace

Write your Java 17 implementation and an executable test runner in `src/`. Use `AlgorithmXX_YY.java` and `MainXX_YY.java` with this exercise's numbers, or keep the existing class names. For data-structure exercises, use the requested class and a separate runner. Compare actual and expected results, including the cases above; throw `AssertionError` on a mismatch (or run Java assertions with `-ea`).

The deliverable is working Java code and checks. You may add a short explanation of the algorithm in `src/README.md`, like exercise 02.01; a formal proof or a separate theoretical answer is not required. Unless stated otherwise, inputs are non-null, indices and graph endpoints are valid, and auxiliary result types such as `Node` or `Selection` are yours to define.

<details><summary>Implementation hint</summary>

Store prefix optima and walk backward through take/skip choices.

</details>

## Your solution

Keep your Java implementation and executable checks in `src/`. Optionally add a short algorithm explanation in `src/README.md`. Record the attempt in [PROGRESS.md](../../../../PROGRESS.md).

---

<!-- study-navigation -->
[← Previous: Exercise 17.04](../../17_greedy-and-intervals/04_knapsack-greedy-counterexample/README.md) · [Index](../README.md) · [Next: Exercise 18.02 →](../02_minimum-coin-count/README.md)
<!-- /study-navigation -->
