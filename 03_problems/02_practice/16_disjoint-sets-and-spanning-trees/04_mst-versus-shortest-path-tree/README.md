# 16.04 - MST Routes and Shortest Routes

<!-- study-navigation -->
[← Previous: Exercise 16.03](../03_kruskal-spanning-tree/README.md) · [Index](../README.md) · [Next: Exercise 17.01 →](../../17_greedy-and-intervals/01_interval-scheduling/README.md)
<!-- /study-navigation -->

[Practice index](../../README.md) | Theory: [Disjoint Sets](../../../../02_data-structures/08_disjoint-sets/16-disjoint-sets.md) | [Minimum Spanning Trees](../../../../01_algorithms/08_graphs/16-minimum-spanning-trees.md)

**Status:** Not started. This is a repository-written practice prompt, not a recruiting question-bank item.

## Exercise

Implement `long[] distancesInMst(int n, int[][] edges, int source)` for a connected undirected graph with nonnegative weights. Build an MST with Kruskal, then compute path distances from source within that tree. Also implement Dijkstra on the original graph and return or print both arrays.

## Examples and checks

For edges `[[0,1,2],[1,2,2],[0,2,3]]`, source 0 gives tree distances `[0,2,4]` and shortest distances `[0,2,3]`. On a tree both arrays agree.

## Your workspace

Write your Java 17 implementation and an executable test runner in `src/`. Use `AlgorithmXX_YY.java` and `MainXX_YY.java` with this exercise's numbers, or keep the existing class names. For data-structure exercises, use the requested class and a separate runner. Compare actual and expected results, including the cases above; throw `AssertionError` on a mismatch (or run Java assertions with `-ea`).

The deliverable is working Java code and checks. You may add a short explanation of the algorithm in `src/README.md`, like exercise 02.01; a formal proof or a separate theoretical answer is not required. Unless stated otherwise, inputs are non-null, indices and graph endpoints are valid, and auxiliary result types such as `Node` or `Selection` are yours to define.

<details><summary>Implementation hint</summary>

Keep the chosen MST adjacency list separate from the original graph.

</details>

## Your solution

Keep your Java implementation and executable checks in `src/`. Optionally add a short algorithm explanation in `src/README.md`. Record the attempt in [PROGRESS.md](../../../../PROGRESS.md).

---

<!-- study-navigation -->
[← Previous: Exercise 16.03](../03_kruskal-spanning-tree/README.md) · [Index](../README.md) · [Next: Exercise 17.01 →](../../17_greedy-and-intervals/01_interval-scheduling/README.md)
<!-- /study-navigation -->
