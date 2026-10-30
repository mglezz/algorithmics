# 23.03 - Tree Distance Queries

<!-- study-navigation -->
[← Previous: Exercise 23.02](../02_bridges-with-parallel-edges/README.md) · [Index](../README.md) · [Next: Exercise 23.04 →](../04_matching-reassignment/README.md)
<!-- /study-navigation -->

[Practice index](../../README.md) | Theory: [Strong Connectivity, Tree Queries, Matching, and Flow](../../../../01_algorithms/08_graphs/23-advanced-graphs-and-flow.md)

**Status:** Not started. This is a repository-written practice prompt, not a recruiting question-bank item.

## Exercise

Implement `TreeDistances(int n, int[][] edges)` for an unweighted tree with n>=1, and `int distance(int u,int v)`. Preprocess binary-lifting ancestors in O(n log n) and answer each query in O(log n).

## Examples and checks

Edges `[[0,1],[1,2],[1,3]]` give distance(2,3)=2, distance(0,2)=2 and distance(1,1)=0.

## Your workspace

Write your Java 17 implementation and an executable test runner in `src/`. Use `AlgorithmXX_YY.java` and `MainXX_YY.java` with this exercise's numbers, or keep the existing class names. For data-structure exercises, use the requested class and a separate runner. Compare actual and expected results, including the cases above; throw `AssertionError` on a mismatch (or run Java assertions with `-ea`).

The deliverable is working Java code and checks. You may add a short explanation of the algorithm in `src/README.md`, like exercise 02.01; a formal proof or a separate theoretical answer is not required. Unless stated otherwise, inputs are non-null, indices and graph endpoints are valid, and auxiliary result types such as `Node` or `Selection` are yours to define.

<details><summary>Implementation hint</summary>

Combine depths with the lowest common ancestor.

</details>

## Your solution

Keep your Java implementation and executable checks in `src/`. Optionally add a short algorithm explanation in `src/README.md`. Record the attempt in [PROGRESS.md](../../../../PROGRESS.md).

---

<!-- study-navigation -->
[← Previous: Exercise 23.02](../02_bridges-with-parallel-edges/README.md) · [Index](../README.md) · [Next: Exercise 23.04 →](../04_matching-reassignment/README.md)
<!-- /study-navigation -->
