# 02.02 - Pairwise String Comparison

<!-- study-navigation -->
[← Previous: Exercise 02.01](../01_repeated-division/README.md) · [Index](../README.md) · [Next: Exercise 02.03 →](../03_monotonic-stack-amortization/README.md)
<!-- /study-navigation -->

[Practice index](../../README.md) | Theory: [Complexity, Recurrences, and Amortization](../../../../01_algorithms/01_foundations/02-complexity-and-amortization.md)

**Status:** Not started. This is a repository-written practice prompt, not a recruiting question-bank item.

## Exercise

Implement `long countEqualPairs(String[] words)`. Compare every pair of positions `i<j`, checking equal-length strings character by character; do not use `String.equals`, hashing or sorting for the comparison. Return the number of pairs with identical contents. Add a counter of character comparisons so you can inspect the work performed.

## Examples and checks

`["cat","dog","cat","cat"]` returns `3`; `["",""]` returns `1`; an empty array returns `0`. Check long strings sharing a prefix and strings of different lengths.

## Your workspace

Write your Java 17 implementation and an executable test runner in `src/`. Use `AlgorithmXX_YY.java` and `MainXX_YY.java` with this exercise's numbers, or keep the existing class names. For data-structure exercises, use the requested class and a separate runner. Compare actual and expected results, including the cases above; throw `AssertionError` on a mismatch (or run Java assertions with `-ea`).

The deliverable is working Java code and checks. You may add a short explanation of the algorithm in `src/README.md`, like exercise 02.01; a formal proof or a separate theoretical answer is not required. Unless stated otherwise, inputs are non-null, indices and graph endpoints are valid, and auxiliary result types such as `Node` or `Selection` are yours to define.

<details><summary>Implementation hint</summary>

Use two loops for pairs and stop each character scan at its first mismatch.

</details>

## Your solution

Keep your Java implementation and executable checks in `src/`. Optionally add a short algorithm explanation in `src/README.md`. Record the attempt in [PROGRESS.md](../../../../PROGRESS.md).

---

<!-- study-navigation -->
[← Previous: Exercise 02.01](../01_repeated-division/README.md) · [Index](../README.md) · [Next: Exercise 02.03 →](../03_monotonic-stack-amortization/README.md)
<!-- /study-navigation -->
