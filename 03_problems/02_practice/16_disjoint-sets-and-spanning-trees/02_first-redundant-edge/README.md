# 16.02 - First Redundant Edge

<!-- study-navigation -->
[← Previous: Exercise 16.01](../01_incremental-connectivity/README.md) · [Index](../README.md) · [Next: Exercise 16.03 →](../03_kruskal-spanning-tree/README.md)
<!-- /study-navigation -->

[Practice index](../../README.md) | Theory: [Disjoint Sets](../../../../02_data-structures/08_disjoint-sets/16-disjoint-sets.md) | [Minimum Spanning Trees](../../../../01_algorithms/08_graphs/16-minimum-spanning-trees.md)

**Status:** Not started. This is a repository-written practice prompt, not a recruiting question-bank item.

## Exercise

Implement `int firstRedundantEdge(int n, int[][] edges)` returning the zero-based index of the first undirected edge whose endpoints were already connected, or -1. Self-loops are redundant, as is a repeated parallel edge.

## Examples and checks

`[[0,1],[1,2],[0,2]]` returns 2; `[[0,1],[0,1]]` returns 1; a forest returns -1.

## Your workspace

Write your Java 17 implementation and an executable test runner in `src/`. Use `AlgorithmXX_YY.java` and `MainXX_YY.java` with this exercise's numbers, or keep the existing class names. For data-structure exercises, use the requested class and a separate runner. Compare actual and expected results, including the cases above; throw `AssertionError` on a mismatch (or run Java assertions with `-ea`).

The deliverable is working Java code and checks. You may add a short explanation of the algorithm in `src/README.md`, like exercise 02.01; a formal proof or a separate theoretical answer is not required. Unless stated otherwise, inputs are non-null, indices and graph endpoints are valid, and auxiliary result types such as `Node` or `Selection` are yours to define.

<details><summary>Implementation hint</summary>

Check representatives before unioning endpoints.

</details>

## Your solution

Keep your Java implementation and executable checks in `src/`. Optionally add a short algorithm explanation in `src/README.md`. Record the attempt in [PROGRESS.md](../../../../PROGRESS.md).

---

<!-- study-navigation -->
[← Previous: Exercise 16.01](../01_incremental-connectivity/README.md) · [Index](../README.md) · [Next: Exercise 16.03 →](../03_kruskal-spanning-tree/README.md)
<!-- /study-navigation -->
