# 11.04 - Meet-in-the-Middle Subset Sum

<!-- study-navigation -->
[← Previous: Exercise 11.03](../03_constraint-grid-search/README.md) · [Index](../README.md) · [Next: Exercise 12.01 →](../../12_trees-and-ordered-maps/01_bst-validation/README.md)
<!-- /study-navigation -->

[Practice index](../../README.md) | Theory: [Recursion, Backtracking, and Search Spaces](../../../../01_algorithms/07_backtracking/11-recursion-and-backtracking.md)

**Status:** Not started. This is a repository-written practice prompt, not a recruiting question-bank item.

## Exercise

Implement `boolean hasSubsetSum(int[] values, long target)` for at most 40 values, allowing negatives and the empty subset. Split the input and combine half-subset sums. Compare against exhaustive search for small arrays.

## Examples and checks

`[3,-2,7], target=5` returns true; target=1 returns true; target=6 returns false; empty input reaches only zero.

## Your workspace

Write your Java 17 implementation and an executable test runner in `src/`. Use `AlgorithmXX_YY.java` and `MainXX_YY.java` with this exercise's numbers, or keep the existing class names. For data-structure exercises, use the requested class and a separate runner. Compare actual and expected results, including the cases above; throw `AssertionError` on a mismatch (or run Java assertions with `-ea`).

The deliverable is working Java code and checks. You may add a short explanation of the algorithm in `src/README.md`, like exercise 02.01; a formal proof or a separate theoretical answer is not required. Unless stated otherwise, inputs are non-null, indices and graph endpoints are valid, and auxiliary result types such as `Node` or `Selection` are yours to define.

<details><summary>Implementation hint</summary>

Enumerate sums of each half and search for complementary sums.

</details>

## Your solution

Keep your Java implementation and executable checks in `src/`. Optionally add a short algorithm explanation in `src/README.md`. Record the attempt in [PROGRESS.md](../../../../PROGRESS.md).

---

<!-- study-navigation -->
[← Previous: Exercise 11.03](../03_constraint-grid-search/README.md) · [Index](../README.md) · [Next: Exercise 12.01 →](../../12_trees-and-ordered-maps/01_bst-validation/README.md)
<!-- /study-navigation -->
