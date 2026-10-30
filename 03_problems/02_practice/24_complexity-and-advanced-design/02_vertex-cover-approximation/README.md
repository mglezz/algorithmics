# 24.02 - Approximate Vertex Cover

<!-- study-navigation -->
[← Previous: Exercise 24.01](../01_hamiltonian-cycle-verification/README.md) · [Index](../README.md) · [Next: Exercise 24.03 →](../03_convex-hull-edge-cases/README.md)
<!-- /study-navigation -->

[Practice index](../../README.md) | Theory: [Computational Limits and Advanced Algorithm Design](../../../../01_algorithms/13_advanced/24-complexity-and-advanced-design.md)

**Status:** Not started. This is a repository-written practice prompt, not a recruiting question-bank item.

## Exercise

Implement `Set<Integer> approximateCover(int n, int[][] edges)` for a simple undirected graph without self-loops. Process edges in input order: when both endpoints are unmatched, select both and mark them matched. Add a validator checking every edge has a selected endpoint. For n<=20, implement brute-force minimum cover to compare sizes.

## Examples and checks

One edge selects both endpoints while the optimum uses one. On small graphs, check validity and that the selected size is at most twice the brute-force optimum.

## Your workspace

Write your Java 17 implementation and an executable test runner in `src/`. Use `AlgorithmXX_YY.java` and `MainXX_YY.java` with this exercise's numbers, or keep the existing class names. For data-structure exercises, use the requested class and a separate runner. Compare actual and expected results, including the cases above; throw `AssertionError` on a mismatch (or run Java assertions with `-ea`).

The deliverable is working Java code and checks. You may add a short explanation of the algorithm in `src/README.md`, like exercise 02.01; a formal proof or a separate theoretical answer is not required. Unless stated otherwise, inputs are non-null, indices and graph endpoints are valid, and auxiliary result types such as `Node` or `Selection` are yours to define.

<details><summary>Implementation hint</summary>

The selected edges form a maximal matching; enumerate vertex subsets only in the small-input comparison method.

</details>

## Your solution

Keep your Java implementation and executable checks in `src/`. Optionally add a short algorithm explanation in `src/README.md`. Record the attempt in [PROGRESS.md](../../../../PROGRESS.md).

---

<!-- study-navigation -->
[← Previous: Exercise 24.01](../01_hamiltonian-cycle-verification/README.md) · [Index](../README.md) · [Next: Exercise 24.03 →](../03_convex-hull-edge-cases/README.md)
<!-- /study-navigation -->
