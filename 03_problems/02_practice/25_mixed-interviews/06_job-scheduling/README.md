# 25.06 - Job Scheduling

<!-- study-navigation -->
[← Previous: Exercise 25.05](../05_route-with-a-free-edge/README.md) · [Index](../README.md) · [Next: Exercise 25.07 →](../07_longest-increasing-subsequence/README.md)
<!-- /study-navigation -->

[Practice index](../../README.md) | Theory: [Solving, Testing, and Communicating](../../../../01_algorithms/14_problem-solving/25-solving-testing-and-communication.md)

**Status:** Not started. This is a repository-written practice prompt, not a recruiting question-bank item.

## Exercise

Define jobs with ID, start<end and nonnegative value. Implement one method selecting the most compatible jobs and another maximizing their total value. Both return selected IDs in time order; jobs are half-open and touching is compatible.

## Examples and checks

Jobs `(0,0,2,4),(1,2,4,4),(2,0,4,10)` select `[0,1]` for count and `[2]` for value. Test empty and overlapping input.

## Your workspace

Write your Java 17 implementation and an executable test runner in `src/`. Use `AlgorithmXX_YY.java` and `MainXX_YY.java` with this exercise's numbers, or keep the existing class names. For data-structure exercises, use the requested class and a separate runner. Compare actual and expected results, including the cases above; throw `AssertionError` on a mismatch (or run Java assertions with `-ea`).

The deliverable is working Java code and checks. You may add a short explanation of the algorithm in `src/README.md`, like exercise 02.01; a formal proof or a separate theoretical answer is not required. Unless stated otherwise, inputs are non-null, indices and graph endpoints are valid, and auxiliary result types such as `Node` or `Selection` are yours to define.

<details><summary>Implementation hint</summary>

Use earliest-finish greedy selection for count and weighted-interval DP for value.

</details>

## Your solution

Keep your Java implementation and executable checks in `src/`. Optionally add a short algorithm explanation in `src/README.md`. Record the attempt in [PROGRESS.md](../../../../PROGRESS.md).

---

<!-- study-navigation -->
[← Previous: Exercise 25.05](../05_route-with-a-free-edge/README.md) · [Index](../README.md) · [Next: Exercise 25.07 →](../07_longest-increasing-subsequence/README.md)
<!-- /study-navigation -->
