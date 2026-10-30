# 15.01 - Shortest Paths with Negative Edges

<!-- study-navigation -->
[← Previous: Exercise 14.04](../../14_graphs-and-topological-order/04_dag-task-completion-times/README.md) · [Index](../README.md) · [Next: Exercise 15.02 →](../02_shortest-path-reconstruction/README.md)
<!-- /study-navigation -->

[Practice index](../../README.md) | Theory: [Weighted Shortest Paths](../../../../01_algorithms/08_graphs/15-shortest-paths.md)

**Status:** Not started. This is a repository-written practice prompt, not a recruiting question-bank item.

## Exercise

Implement `long[] bellmanFord(int n, int[][] edges, int source)` for directed `[from,to,weight]` edges. Negative weights are allowed. Use Long.MAX_VALUE for unreachable vertices; throw IllegalArgumentException if a negative cycle is reachable from source. Assume finite path arithmetic fits in long.

## Examples and checks

Edges `[[0,1,1],[0,2,3],[2,1,-5]]` from 0 give `[0,-2,3]`. Test an unreachable vertex and reachable versus disconnected negative cycles.

## Your workspace

Write your Java 17 implementation and an executable test runner in `src/`. Use `AlgorithmXX_YY.java` and `MainXX_YY.java` with this exercise's numbers, or keep the existing class names. For data-structure exercises, use the requested class and a separate runner. Compare actual and expected results, including the cases above; throw `AssertionError` on a mismatch (or run Java assertions with `-ea`).

The deliverable is working Java code and checks. You may add a short explanation of the algorithm in `src/README.md`, like exercise 02.01; a formal proof or a separate theoretical answer is not required. Unless stated otherwise, inputs are non-null, indices and graph endpoints are valid, and auxiliary result types such as `Node` or `Selection` are yours to define.

<details><summary>Implementation hint</summary>

Relax only from reachable vertices and check for further improvements after n-1 rounds.

</details>

## Your solution

Keep your Java implementation and executable checks in `src/`. Optionally add a short algorithm explanation in `src/README.md`. Record the attempt in [PROGRESS.md](../../../../PROGRESS.md).

---

<!-- study-navigation -->
[← Previous: Exercise 14.04](../../14_graphs-and-topological-order/04_dag-task-completion-times/README.md) · [Index](../README.md) · [Next: Exercise 15.02 →](../02_shortest-path-reconstruction/README.md)
<!-- /study-navigation -->
