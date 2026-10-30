# 14.02 - Directed Cycle Witness

<!-- study-navigation -->
[← Previous: Exercise 14.01](../01_service-startup-order/README.md) · [Index](../README.md) · [Next: Exercise 14.03 →](../03_nearest-source-grid-distances/README.md)
<!-- /study-navigation -->

[Practice index](../../README.md) | Theory: [Graph Representations](../../../../02_data-structures/07_graphs/14-graph-representations.md) | [Graph Traversal and Topological Order](../../../../01_algorithms/08_graphs/14-traversal-and-topological-order.md)

**Status:** Not started. This is a repository-written practice prompt, not a recruiting question-bank item.

## Exercise

Implement `List<Integer> findCycle(int n, int[][] edges)` for directed `[from,to]` edges. Return a cycle with its start repeated at the end and no other repeated vertex, or an empty list. Search disconnected components too.

## Examples and checks

`[[0,1],[1,2],[2,0]]` permits `[0,1,2,0]`; a self-loop returns `[v,v]`; a DAG returns empty.

## Your workspace

Write your Java 17 implementation and an executable test runner in `src/`. Use `AlgorithmXX_YY.java` and `MainXX_YY.java` with this exercise's numbers, or keep the existing class names. For data-structure exercises, use the requested class and a separate runner. Compare actual and expected results, including the cases above; throw `AssertionError` on a mismatch (or run Java assertions with `-ea`).

The deliverable is working Java code and checks. You may add a short explanation of the algorithm in `src/README.md`, like exercise 02.01; a formal proof or a separate theoretical answer is not required. Unless stated otherwise, inputs are non-null, indices and graph endpoints are valid, and auxiliary result types such as `Node` or `Selection` are yours to define.

<details><summary>Implementation hint</summary>

Use DFS colors and reconstruct a back edge's ancestor path.

</details>

## Your solution

Keep your Java implementation and executable checks in `src/`. Optionally add a short algorithm explanation in `src/README.md`. Record the attempt in [PROGRESS.md](../../../../PROGRESS.md).

---

<!-- study-navigation -->
[← Previous: Exercise 14.01](../01_service-startup-order/README.md) · [Index](../README.md) · [Next: Exercise 14.03 →](../03_nearest-source-grid-distances/README.md)
<!-- /study-navigation -->
