# 23.04 - Bipartite Matching with Reassignment

<!-- study-navigation -->
[← Previous: Exercise 23.03](../03_tree-distance-queries/README.md) · [Index](../README.md) · [Next: Exercise 23.05 →](../05_minimum-cut-certificate/README.md)
<!-- /study-navigation -->

[Practice index](../../README.md) | Theory: [Strong Connectivity, Tree Queries, Matching, and Flow](../../../../01_algorithms/08_graphs/23-advanced-graphs-and-flow.md)

**Status:** Not started. This is a repository-written practice prompt, not a recruiting question-bank item.

## Exercise

Implement `int[] maximumMatching(int leftCount, int rightCount, int[][] edges)` for bipartite `[left,right]` pairs. Return the matched right vertex for each left vertex, or -1. Maximize the number of matches without using any vertex twice.

## Examples and checks

Edges `[[0,0],[0,1],[1,0]]` require result `[1,0]` for size 2. Test isolated vertices and empty sides.

## Your workspace

Write your Java 17 implementation and an executable test runner in `src/`. Use `AlgorithmXX_YY.java` and `MainXX_YY.java` with this exercise's numbers, or keep the existing class names. For data-structure exercises, use the requested class and a separate runner. Compare actual and expected results, including the cases above; throw `AssertionError` on a mismatch (or run Java assertions with `-ea`).

The deliverable is working Java code and checks. You may add a short explanation of the algorithm in `src/README.md`, like exercise 02.01; a formal proof or a separate theoretical answer is not required. Unless stated otherwise, inputs are non-null, indices and graph endpoints are valid, and auxiliary result types such as `Node` or `Selection` are yours to define.

<details><summary>Implementation hint</summary>

Search augmenting paths that can move a previously matched left vertex to another right vertex.

</details>

## Your solution

Keep your Java implementation and executable checks in `src/`. Optionally add a short algorithm explanation in `src/README.md`. Record the attempt in [PROGRESS.md](../../../../PROGRESS.md).

---

<!-- study-navigation -->
[← Previous: Exercise 23.03](../03_tree-distance-queries/README.md) · [Index](../README.md) · [Next: Exercise 23.05 →](../05_minimum-cut-certificate/README.md)
<!-- /study-navigation -->
