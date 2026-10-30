# 15.04 - Negative Cycles Affecting a Target

<!-- study-navigation -->
[← Previous: Exercise 15.03](../03_one-free-edge/README.md) · [Index](../README.md) · [Next: Exercise 16.01 →](../../16_disjoint-sets-and-spanning-trees/01_incremental-connectivity/README.md)
<!-- /study-navigation -->

[Practice index](../../README.md) | Theory: [Weighted Shortest Paths](../../../../01_algorithms/08_graphs/15-shortest-paths.md)

**Status:** Not started. This is a repository-written practice prompt, not a recruiting question-bank item.

## Exercise

Implement `PathResult classifyPath(int n, int[][] edges, int source, int target)` for directed signed int weights. Define statuses FINITE, UNREACHABLE and UNBOUNDED; return a long distance only for FINITE. A reachable negative cycle matters only if it can also reach target.

## Examples and checks

For `[[0,1,1],[1,1,-1],[0,2,5]]`, target 2 is FINITE with 5; adding `[1,2,0]` makes it UNBOUNDED; an isolated target is UNREACHABLE.

## Your workspace

Write your Java 17 implementation and an executable test runner in `src/`. Use `AlgorithmXX_YY.java` and `MainXX_YY.java` with this exercise's numbers, or keep the existing class names. For data-structure exercises, use the requested class and a separate runner. Compare actual and expected results, including the cases above; throw `AssertionError` on a mismatch (or run Java assertions with `-ea`).

The deliverable is working Java code and checks. You may add a short explanation of the algorithm in `src/README.md`, like exercise 02.01; a formal proof or a separate theoretical answer is not required. Unless stated otherwise, inputs are non-null, indices and graph endpoints are valid, and auxiliary result types such as `Node` or `Selection` are yours to define.

<details><summary>Implementation hint</summary>

Propagate reachability from vertices still improvable after Bellman-Ford rounds.

</details>

## Your solution

Keep your Java implementation and executable checks in `src/`. Optionally add a short algorithm explanation in `src/README.md`. Record the attempt in [PROGRESS.md](../../../../PROGRESS.md).

---

<!-- study-navigation -->
[← Previous: Exercise 15.03](../03_one-free-edge/README.md) · [Index](../README.md) · [Next: Exercise 16.01 →](../../16_disjoint-sets-and-spanning-trees/01_incremental-connectivity/README.md)
<!-- /study-navigation -->
