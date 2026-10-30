# 18.04 - Memoized Grid Path Counter

<!-- study-navigation -->
[← Previous: Exercise 18.03](../03_zero-one-knapsack/README.md) · [Index](../README.md) · [Next: Exercise 19.01 →](../../19_dynamic-programming-patterns/01_lcs-and-edit-reconstruction/README.md)
<!-- /study-navigation -->

[Practice index](../../README.md) | Theory: [Dynamic Programming from First Principles](../../../../01_algorithms/10_dynamic-programming/18-dynamic-programming.md)

**Status:** Not started. This is a repository-written practice prompt, not a recruiting question-bank item.

## Exercise

Implement `long countPaths(boolean[][] blocked)` for a rectangular grid of at most 20x20 cells, moving only right or down from top-left to bottom-right. Use recursive memoization with a separate computed flag, since zero is a valid result. Add a counter of computed states.

## Examples and checks

A clear 2x2 grid returns 2; a blocked destination returns 0; an empty grid returns 0. A 20x20 grid with a blocked final row returns 0 without repeatedly computing the same state.

## Your workspace

Write your Java 17 implementation and an executable test runner in `src/`. Use `AlgorithmXX_YY.java` and `MainXX_YY.java` with this exercise's numbers, or keep the existing class names. For data-structure exercises, use the requested class and a separate runner. Compare actual and expected results, including the cases above; throw `AssertionError` on a mismatch (or run Java assertions with `-ea`).

The deliverable is working Java code and checks. You may add a short explanation of the algorithm in `src/README.md`, like exercise 02.01; a formal proof or a separate theoretical answer is not required. Unless stated otherwise, inputs are non-null, indices and graph endpoints are valid, and auxiliary result types such as `Node` or `Selection` are yours to define.

<details><summary>Implementation hint</summary>

Cache zero results too; each in-bounds state should be computed at most once.

</details>

## Your solution

Keep your Java implementation and executable checks in `src/`. Optionally add a short algorithm explanation in `src/README.md`. Record the attempt in [PROGRESS.md](../../../../PROGRESS.md).

---

<!-- study-navigation -->
[← Previous: Exercise 18.03](../03_zero-one-knapsack/README.md) · [Index](../README.md) · [Next: Exercise 19.01 →](../../19_dynamic-programming-patterns/01_lcs-and-edit-reconstruction/README.md)
<!-- /study-navigation -->
