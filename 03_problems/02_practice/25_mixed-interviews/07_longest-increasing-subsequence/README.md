# 25.07 - Longest Increasing Subsequence

<!-- study-navigation -->
[← Previous: Exercise 25.06](../06_job-scheduling/README.md) · [Index](../README.md) · [Next: Exercise 25.08 →](../08_dynamic-range-sums/README.md)
<!-- /study-navigation -->

[Practice index](../../README.md) | Theory: [Solving, Testing, and Communicating](../../../../01_algorithms/14_problem-solving/25-solving-testing-and-communication.md)

**Status:** Not started. This is a repository-written practice prompt, not a recruiting question-bank item.

## Exercise

Implement `int[] lisIndices(int[] values)` returning indices of any longest strictly increasing subsequence in increasing index order. Use O(n log n) time and O(n) extra space; return empty for empty input.

## Examples and checks

`[3,1,2,5,4]` permits indices `[1,2,4]`; verify increasing indices, strictly increasing values and length against quadratic DP on small arrays.

## Your workspace

Write your Java 17 implementation and an executable test runner in `src/`. Use `AlgorithmXX_YY.java` and `MainXX_YY.java` with this exercise's numbers, or keep the existing class names. For data-structure exercises, use the requested class and a separate runner. Compare actual and expected results, including the cases above; throw `AssertionError` on a mismatch (or run Java assertions with `-ea`).

The deliverable is working Java code and checks. You may add a short explanation of the algorithm in `src/README.md`, like exercise 02.01; a formal proof or a separate theoretical answer is not required. Unless stated otherwise, inputs are non-null, indices and graph endpoints are valid, and auxiliary result types such as `Node` or `Selection` are yours to define.

<details><summary>Implementation hint</summary>

Keep predecessor indices and the index realizing each current tail length.

</details>

## Your solution

Keep your Java implementation and executable checks in `src/`. Optionally add a short algorithm explanation in `src/README.md`. Record the attempt in [PROGRESS.md](../../../../PROGRESS.md).

---

<!-- study-navigation -->
[← Previous: Exercise 25.06](../06_job-scheduling/README.md) · [Index](../README.md) · [Next: Exercise 25.08 →](../08_dynamic-range-sums/README.md)
<!-- /study-navigation -->
