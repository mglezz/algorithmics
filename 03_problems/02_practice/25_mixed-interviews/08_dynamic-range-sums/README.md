# 25.08 - Dynamic Range Sums

<!-- study-navigation -->
[← Previous: Exercise 25.07](../07_longest-increasing-subsequence/README.md) · [Index](../README.md) · [Next: Exercise 25.09 →](../09_versioned-service-costs/README.md)
<!-- /study-navigation -->

[Practice index](../../README.md) | Theory: [Solving, Testing, and Communicating](../../../../01_algorithms/14_problem-solving/25-solving-testing-and-communication.md)

**Status:** Not started. This is a repository-written practice prompt, not a recruiting question-bank item.

## Exercise

Implement `DynamicSums(long[] values)` with `set(index,value)` and `long sum(left,right)` over half-open ranges. Then add `add(left,right,delta)`. All operations must run in O(log n); empty sums are zero and empty additions do nothing. Assume arithmetic fits in long.

## Examples and checks

Start `[1,2,3]`, set(1,5), add(0,2,2): final values `[3,7,3]` sum to 13. Compare mixed operations against a plain array.

## Your workspace

Write your Java 17 implementation and an executable test runner in `src/`. Use `AlgorithmXX_YY.java` and `MainXX_YY.java` with this exercise's numbers, or keep the existing class names. For data-structure exercises, use the requested class and a separate runner. Compare actual and expected results, including the cases above; throw `AssertionError` on a mismatch (or run Java assertions with `-ea`).

The deliverable is working Java code and checks. You may add a short explanation of the algorithm in `src/README.md`, like exercise 02.01; a formal proof or a separate theoretical answer is not required. Unless stated otherwise, inputs are non-null, indices and graph endpoints are valid, and auxiliary result types such as `Node` or `Selection` are yours to define.

<details><summary>Implementation hint</summary>

A lazy segment tree supports range additions and point assignments; push pending tags before descending.

</details>

## Your solution

Keep your Java implementation and executable checks in `src/`. Optionally add a short algorithm explanation in `src/README.md`. Record the attempt in [PROGRESS.md](../../../../PROGRESS.md).

---

<!-- study-navigation -->
[← Previous: Exercise 25.07](../07_longest-increasing-subsequence/README.md) · [Index](../README.md) · [Next: Exercise 25.09 →](../09_versioned-service-costs/README.md)
<!-- /study-navigation -->
