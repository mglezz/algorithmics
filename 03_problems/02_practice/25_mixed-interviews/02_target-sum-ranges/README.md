# 25.02 - Target-Sum Ranges

<!-- study-navigation -->
[← Previous: Exercise 25.01](../01_threshold-search/README.md) · [Index](../README.md) · [Next: Exercise 25.03 →](../03_least-recently-used-cache/README.md)
<!-- /study-navigation -->

[Practice index](../../README.md) | Theory: [Solving, Testing, and Communicating](../../../../01_algorithms/14_problem-solving/25-solving-testing-and-communication.md)

**Status:** Not started. This is a repository-written practice prompt, not a recruiting question-bank item.

## Exercise

Implement `long countRanges(int[] values,long target)` and `int[] longestRange(int[] values,long target)` with negatives allowed. Return inclusive endpoints for the longest nonempty range, earliest start on ties, or empty if absent. Aim for expected O(n) time per method.

## Examples and checks

`[1,-1,1], target=1` has count 3 and longest range `[0,2]`; empty input has count 0 and no range.

## Your workspace

Write your Java 17 implementation and an executable test runner in `src/`. Use `AlgorithmXX_YY.java` and `MainXX_YY.java` with this exercise's numbers, or keep the existing class names. For data-structure exercises, use the requested class and a separate runner. Compare actual and expected results, including the cases above; throw `AssertionError` on a mismatch (or run Java assertions with `-ea`).

The deliverable is working Java code and checks. You may add a short explanation of the algorithm in `src/README.md`, like exercise 02.01; a formal proof or a separate theoretical answer is not required. Unless stated otherwise, inputs are non-null, indices and graph endpoints are valid, and auxiliary result types such as `Node` or `Selection` are yours to define.

<details><summary>Implementation hint</summary>

Counts need prefix frequencies; longest ranges need earliest prefix positions.

</details>

## Your solution

Keep your Java implementation and executable checks in `src/`. Optionally add a short algorithm explanation in `src/README.md`. Record the attempt in [PROGRESS.md](../../../../PROGRESS.md).

---

<!-- study-navigation -->
[← Previous: Exercise 25.01](../01_threshold-search/README.md) · [Index](../README.md) · [Next: Exercise 25.03 →](../03_least-recently-used-cache/README.md)
<!-- /study-navigation -->
