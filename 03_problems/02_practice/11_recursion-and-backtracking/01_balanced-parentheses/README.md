# 11.01 - Balanced Parentheses

<!-- study-navigation -->
[← Previous: Exercise 10.04](../../10_sorting-and-selection/04_choosing-a-selection-strategy/README.md) · [Index](../README.md) · [Next: Exercise 11.02 →](../02_unique-permutations/README.md)
<!-- /study-navigation -->

[Practice index](../../README.md) | Theory: [Recursion, Backtracking, and Search Spaces](../../../../01_algorithms/07_backtracking/11-recursion-and-backtracking.md)

**Status:** Not started. This is a repository-written practice prompt, not a recruiting question-bank item.

## Exercise

Implement `List<String> generateParentheses(int n)` for `0<=n<=10`. Generate each balanced sequence of n pairs once by backtracking; do not enumerate every binary string and filter.

## Examples and checks

n=2 returns `"(())"` and `"()()"` in any order; n=0 returns a list containing the empty string.

## Your workspace

Write your Java 17 implementation and an executable test runner in `src/`. Use `AlgorithmXX_YY.java` and `MainXX_YY.java` with this exercise's numbers, or keep the existing class names. For data-structure exercises, use the requested class and a separate runner. Compare actual and expected results, including the cases above; throw `AssertionError` on a mismatch (or run Java assertions with `-ea`).

The deliverable is working Java code and checks. You may add a short explanation of the algorithm in `src/README.md`, like exercise 02.01; a formal proof or a separate theoretical answer is not required. Unless stated otherwise, inputs are non-null, indices and graph endpoints are valid, and auxiliary result types such as `Node` or `Selection` are yours to define.

<details><summary>Implementation hint</summary>

Only add a closing parenthesis when fewer have been closed than opened.

</details>

## Your solution

Keep your Java implementation and executable checks in `src/`. Optionally add a short algorithm explanation in `src/README.md`. Record the attempt in [PROGRESS.md](../../../../PROGRESS.md).

---

<!-- study-navigation -->
[← Previous: Exercise 10.04](../../10_sorting-and-selection/04_choosing-a-selection-strategy/README.md) · [Index](../README.md) · [Next: Exercise 11.02 →](../02_unique-permutations/README.md)
<!-- /study-navigation -->
