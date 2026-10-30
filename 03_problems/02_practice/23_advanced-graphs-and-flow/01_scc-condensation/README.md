# 23.01 - SCC Condensation

<!-- study-navigation -->
[← Previous: Exercise 22.04](../../22_bits-number-theory-and-randomness/04_exact-shuffle-probabilities/README.md) · [Index](../README.md) · [Next: Exercise 23.02 →](../02_bridges-with-parallel-edges/README.md)
<!-- /study-navigation -->

[Practice index](../../README.md) | Theory: [Strong Connectivity, Tree Queries, Matching, and Flow](../../../../01_algorithms/08_graphs/23-advanced-graphs-and-flow.md)

**Status:** Not started. This is a repository-written practice prompt, not a recruiting question-bank item.

## Exercise

Implement `Condensation condense(int n, int[][] edges)` for directed edges, returning a component ID per vertex, deduplicated directed component edges and the number of components with indegree zero. IDs need not follow a specific order.

## Examples and checks

`[[0,1],[1,0],[1,2]]` yields groups `{0,1}` and `{2}`, one component edge and one source component; check isolated vertices and an empty graph.

## Your workspace

Write your Java 17 implementation and an executable test runner in `src/`. Use `AlgorithmXX_YY.java` and `MainXX_YY.java` with this exercise's numbers, or keep the existing class names. For data-structure exercises, use the requested class and a separate runner. Compare actual and expected results, including the cases above; throw `AssertionError` on a mismatch (or run Java assertions with `-ea`).

The deliverable is working Java code and checks. You may add a short explanation of the algorithm in `src/README.md`, like exercise 02.01; a formal proof or a separate theoretical answer is not required. Unless stated otherwise, inputs are non-null, indices and graph endpoints are valid, and auxiliary result types such as `Node` or `Selection` are yours to define.

<details><summary>Implementation hint</summary>

Run Tarjan or Kosaraju, then rebuild edges between distinct component IDs.

</details>

## Your solution

Keep your Java implementation and executable checks in `src/`. Optionally add a short algorithm explanation in `src/README.md`. Record the attempt in [PROGRESS.md](../../../../PROGRESS.md).

---

<!-- study-navigation -->
[← Previous: Exercise 22.04](../../22_bits-number-theory-and-randomness/04_exact-shuffle-probabilities/README.md) · [Index](../README.md) · [Next: Exercise 23.02 →](../02_bridges-with-parallel-edges/README.md)
<!-- /study-navigation -->
