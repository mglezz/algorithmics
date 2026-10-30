# 19.03 - Weighted Interval Scheduling

<!-- study-navigation -->
[← Previous: Exercise 19.02](../02_lis-implementations/README.md) · [Index](../README.md) · [Next: Exercise 19.04 →](../04_rerooting-distance-sums/README.md)
<!-- /study-navigation -->

[Practice index](../../README.md) | Theory: [Dynamic Programming Patterns and Reconstruction](../../../../01_algorithms/10_dynamic-programming/19-dynamic-programming-patterns.md)

**Status:** Not started. This is a repository-written practice prompt, not a recruiting question-bank item.

## Exercise

Implement `Schedule maxValueSchedule(List<Job> jobs)` for jobs with unique IDs, start<end and nonnegative long values. Return the maximum total value and compatible selected IDs in time order. Intervals are half-open; assume total values fit in long.

## Examples and checks

Jobs `(0,0,2,5),(1,1,4,6),(2,2,4,5)` select IDs `[0,2]` with total 10; empty input returns zero and no IDs.

## Your workspace

Write your Java 17 implementation and an executable test runner in `src/`. Use `AlgorithmXX_YY.java` and `MainXX_YY.java` with this exercise's numbers, or keep the existing class names. For data-structure exercises, use the requested class and a separate runner. Compare actual and expected results, including the cases above; throw `AssertionError` on a mismatch (or run Java assertions with `-ea`).

The deliverable is working Java code and checks. You may add a short explanation of the algorithm in `src/README.md`, like exercise 02.01; a formal proof or a separate theoretical answer is not required. Unless stated otherwise, inputs are non-null, indices and graph endpoints are valid, and auxiliary result types such as `Node` or `Selection` are yours to define.

<details><summary>Implementation hint</summary>

Sort by end, binary-search compatible predecessors, then reconstruct DP choices.

</details>

## Your solution

Keep your Java implementation and executable checks in `src/`. Optionally add a short algorithm explanation in `src/README.md`. Record the attempt in [PROGRESS.md](../../../../PROGRESS.md).

---

<!-- study-navigation -->
[← Previous: Exercise 19.02](../02_lis-implementations/README.md) · [Index](../README.md) · [Next: Exercise 19.04 →](../04_rerooting-distance-sums/README.md)
<!-- /study-navigation -->
