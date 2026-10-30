# 14.04 - Task Completion Times

<!-- study-navigation -->
[← Previous: Exercise 14.03](../03_nearest-source-grid-distances/README.md) · [Index](../README.md) · [Next: Exercise 15.01 →](../../15_shortest-paths/01_dijkstra-counterexample/README.md)
<!-- /study-navigation -->

[Practice index](../../README.md) | Theory: [Graph Representations](../../../../02_data-structures/07_graphs/14-graph-representations.md) | [Graph Traversal and Topological Order](../../../../01_algorithms/08_graphs/14-traversal-and-topological-order.md)

**Status:** Not started. This is a repository-written practice prompt, not a recruiting question-bank item.

## Exercise

Implement `long[] completionTimes(int[] duration, int[][] dependencies)` for nonnegative durations and `[task,prerequisite]` pairs, with unlimited parallel workers. Return the earliest finish of each task. Throw IllegalArgumentException for a cycle.

## Examples and checks

Durations `[2,3,4]`, dependencies `[[1,0],[2,0]]` return `[2,5,6]`; independent tasks finish at their own durations.

## Your workspace

Write your Java 17 implementation and an executable test runner in `src/`. Use `AlgorithmXX_YY.java` and `MainXX_YY.java` with this exercise's numbers, or keep the existing class names. For data-structure exercises, use the requested class and a separate runner. Compare actual and expected results, including the cases above; throw `AssertionError` on a mismatch (or run Java assertions with `-ea`).

The deliverable is working Java code and checks. You may add a short explanation of the algorithm in `src/README.md`, like exercise 02.01; a formal proof or a separate theoretical answer is not required. Unless stated otherwise, inputs are non-null, indices and graph endpoints are valid, and auxiliary result types such as `Node` or `Selection` are yours to define.

<details><summary>Implementation hint</summary>

In topological order, a task starts at the latest prerequisite finish.

</details>

## Your solution

Keep your Java implementation and executable checks in `src/`. Optionally add a short algorithm explanation in `src/README.md`. Record the attempt in [PROGRESS.md](../../../../PROGRESS.md).

---

<!-- study-navigation -->
[← Previous: Exercise 14.03](../03_nearest-source-grid-distances/README.md) · [Index](../README.md) · [Next: Exercise 15.01 →](../../15_shortest-paths/01_dijkstra-counterexample/README.md)
<!-- /study-navigation -->
