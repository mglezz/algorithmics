# 23.05 - Maximum Flow and Minimum Cut

<!-- study-navigation -->
[← Previous: Exercise 23.04](../04_matching-reassignment/README.md) · [Index](../README.md) · [Next: Exercise 24.01 →](../../24_complexity-and-advanced-design/01_hamiltonian-cycle-verification/README.md)
<!-- /study-navigation -->

[Practice index](../../README.md) | Theory: [Strong Connectivity, Tree Queries, Matching, and Flow](../../../../01_algorithms/08_graphs/23-advanced-graphs-and-flow.md)

**Status:** Not started. This is a repository-written practice prompt, not a recruiting question-bank item.

## Exercise

Implement `FlowResult maxFlow(int n, int[][] edges, int source, int sink)` with source!=sink and directed `[from,to,capacity]` edges of nonnegative int capacity. Return the long flow value and source-side vertices of a minimum cut. Support parallel edges and reverse residual arcs.

## Examples and checks

Edges `[[0,1,3],[0,2,2],[1,2,1],[1,3,2],[2,3,3]]` have flow 5 from 0 to 3. Sum capacities crossing your returned cut and check that it is 5; test no path.

## Your workspace

Write your Java 17 implementation and an executable test runner in `src/`. Use `AlgorithmXX_YY.java` and `MainXX_YY.java` with this exercise's numbers, or keep the existing class names. For data-structure exercises, use the requested class and a separate runner. Compare actual and expected results, including the cases above; throw `AssertionError` on a mismatch (or run Java assertions with `-ea`).

The deliverable is working Java code and checks. You may add a short explanation of the algorithm in `src/README.md`, like exercise 02.01; a formal proof or a separate theoretical answer is not required. Unless stated otherwise, inputs are non-null, indices and graph endpoints are valid, and auxiliary result types such as `Node` or `Selection` are yours to define.

<details><summary>Implementation hint</summary>

After augmenting paths are exhausted, traverse positive residual edges from source to obtain the cut.

</details>

## Your solution

Keep your Java implementation and executable checks in `src/`. Optionally add a short algorithm explanation in `src/README.md`. Record the attempt in [PROGRESS.md](../../../../PROGRESS.md).

---

<!-- study-navigation -->
[← Previous: Exercise 23.04](../04_matching-reassignment/README.md) · [Index](../README.md) · [Next: Exercise 24.01 →](../../24_complexity-and-advanced-design/01_hamiltonian-cycle-verification/README.md)
<!-- /study-navigation -->
