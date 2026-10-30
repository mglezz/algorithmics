# 16.01 - Incremental Connectivity

<!-- study-navigation -->
[← Previous: Exercise 15.04](../../15_shortest-paths/04_negative-cycles-and-a-target/README.md) · [Index](../README.md) · [Next: Exercise 16.02 →](../02_first-redundant-edge/README.md)
<!-- /study-navigation -->

[Practice index](../../README.md) | Theory: [Disjoint Sets](../../../../02_data-structures/08_disjoint-sets/16-disjoint-sets.md) | [Minimum Spanning Trees](../../../../01_algorithms/08_graphs/16-minimum-spanning-trees.md)

**Status:** Not started. This is a repository-written practice prompt, not a recruiting question-bank item.

## Exercise

Implement `int[] componentCounts(int n, int[][] edges)` for undirected edges added in input order. Return the number of connected components after each addition, using a disjoint-set structure. Self-loops and duplicate edges are allowed.

## Examples and checks

`n=4, [[0,1],[1,2],[0,2],[2,3]]` returns `[3,2,2,1]`; no edges gives an empty result.

## Your workspace

Write your Java 17 implementation and an executable test runner in `src/`. Use `AlgorithmXX_YY.java` and `MainXX_YY.java` with this exercise's numbers, or keep the existing class names. For data-structure exercises, use the requested class and a separate runner. Compare actual and expected results, including the cases above; throw `AssertionError` on a mismatch (or run Java assertions with `-ea`).

The deliverable is working Java code and checks. You may add a short explanation of the algorithm in `src/README.md`, like exercise 02.01; a formal proof or a separate theoretical answer is not required. Unless stated otherwise, inputs are non-null, indices and graph endpoints are valid, and auxiliary result types such as `Node` or `Selection` are yours to define.

<details><summary>Implementation hint</summary>

Decrease the component count only when union joins different roots.

</details>

## Your solution

Keep your Java implementation and executable checks in `src/`. Optionally add a short algorithm explanation in `src/README.md`. Record the attempt in [PROGRESS.md](../../../../PROGRESS.md).

---

<!-- study-navigation -->
[← Previous: Exercise 15.04](../../15_shortest-paths/04_negative-cycles-and-a-target/README.md) · [Index](../README.md) · [Next: Exercise 16.02 →](../02_first-redundant-edge/README.md)
<!-- /study-navigation -->
