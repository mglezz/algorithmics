# 15.02 - Shortest Path Reconstruction

<!-- study-navigation -->
[← Previous: Exercise 15.01](../01_dijkstra-counterexample/README.md) · [Index](../README.md) · [Next: Exercise 15.03 →](../03_one-free-edge/README.md)
<!-- /study-navigation -->

[Practice index](../../README.md) | Theory: [Weighted Shortest Paths](../../../../01_algorithms/08_graphs/15-shortest-paths.md)

**Status:** Not started. This is a repository-written practice prompt, not a recruiting question-bank item.

## Exercise

Implement `List<Integer> shortestPath(int n, int[][] edges, int source, int target)` for directed nonnegative weighted edges `[from,to,weight]`. Return one minimum-cost path including endpoints, or empty when unreachable. Equal-cost paths are interchangeable.

## Examples and checks

`[[0,1,2],[1,2,3],[0,2,9]]` from 0 to 2 returns `[0,1,2]`; source=target returns `[source]`; test an unreachable target.

## Your workspace

Write your Java 17 implementation and an executable test runner in `src/`. Use `AlgorithmXX_YY.java` and `MainXX_YY.java` with this exercise's numbers, or keep the existing class names. For data-structure exercises, use the requested class and a separate runner. Compare actual and expected results, including the cases above; throw `AssertionError` on a mismatch (or run Java assertions with `-ea`).

The deliverable is working Java code and checks. You may add a short explanation of the algorithm in `src/README.md`, like exercise 02.01; a formal proof or a separate theoretical answer is not required. Unless stated otherwise, inputs are non-null, indices and graph endpoints are valid, and auxiliary result types such as `Node` or `Selection` are yours to define.

<details><summary>Implementation hint</summary>

Run Dijkstra with long distances and save a predecessor only on a strict improvement.

</details>

## Your solution

Keep your Java implementation and executable checks in `src/`. Optionally add a short algorithm explanation in `src/README.md`. Record the attempt in [PROGRESS.md](../../../../PROGRESS.md).

---

<!-- study-navigation -->
[← Previous: Exercise 15.01](../01_dijkstra-counterexample/README.md) · [Index](../README.md) · [Next: Exercise 15.03 →](../03_one-free-edge/README.md)
<!-- /study-navigation -->
