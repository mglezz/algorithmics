# 25.04 - Smallest Service Startup Order

<!-- study-navigation -->
[← Previous: Exercise 25.03](../03_least-recently-used-cache/README.md) · [Index](../README.md) · [Next: Exercise 25.05 →](../05_route-with-a-free-edge/README.md)
<!-- /study-navigation -->

[Practice index](../../README.md) | Theory: [Solving, Testing, and Communicating](../../../../01_algorithms/14_problem-solving/25-solving-testing-and-communication.md)

**Status:** Not started. This is a repository-written practice prompt, not a recruiting question-bank item.

## Exercise

Implement `int[] startupOrder(int n,int[][] dependencies)` for `[service,prerequisite]` pairs, returning the lexicographically smallest legal order or an empty array on a cycle. Duplicate pairs must not change feasibility.

## Examples and checks

`n=4, [[2,0],[2,1]]` returns `[0,1,2,3]`; mutual dependencies return empty; no dependencies returns ascending IDs.

## Your workspace

Write your Java 17 implementation and an executable test runner in `src/`. Use `AlgorithmXX_YY.java` and `MainXX_YY.java` with this exercise's numbers, or keep the existing class names. For data-structure exercises, use the requested class and a separate runner. Compare actual and expected results, including the cases above; throw `AssertionError` on a mismatch (or run Java assertions with `-ea`).

The deliverable is working Java code and checks. You may add a short explanation of the algorithm in `src/README.md`, like exercise 02.01; a formal proof or a separate theoretical answer is not required. Unless stated otherwise, inputs are non-null, indices and graph endpoints are valid, and auxiliary result types such as `Node` or `Selection` are yours to define.

<details><summary>Implementation hint</summary>

Use a min-priority queue for currently ready services.

</details>

## Your solution

Keep your Java implementation and executable checks in `src/`. Optionally add a short algorithm explanation in `src/README.md`. Record the attempt in [PROGRESS.md](../../../../PROGRESS.md).

---

<!-- study-navigation -->
[← Previous: Exercise 25.03](../03_least-recently-used-cache/README.md) · [Index](../README.md) · [Next: Exercise 25.05 →](../05_route-with-a-free-edge/README.md)
<!-- /study-navigation -->
