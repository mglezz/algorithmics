# 14.03 - Nearest-Source Grid Distances

<!-- study-navigation -->
[← Previous: Exercise 14.02](../02_directed-cycle-witness/README.md) · [Index](../README.md) · [Next: Exercise 14.04 →](../04_dag-task-completion-times/README.md)
<!-- /study-navigation -->

[Practice index](../../README.md) | Theory: [Graph Representations](../../../../02_data-structures/07_graphs/14-graph-representations.md) | [Graph Traversal and Topological Order](../../../../01_algorithms/08_graphs/14-traversal-and-topological-order.md)

**Status:** Not started. This is a repository-written practice prompt, not a recruiting question-bank item.

## Exercise

Implement `int[][] distances(int[][] grid)` with `-1` for walls, `0` for open cells and `1` for sources. Move orthogonally with unit cost. Return each traversable cell's distance to its nearest source, and -1 for walls or unreachable cells.

## Examples and checks

`[[1,0,0],[0,-1,0]]` returns `[[0,1,2],[1,-1,3]]`; with no sources all results are -1. Support an empty grid.

## Your workspace

Write your Java 17 implementation and an executable test runner in `src/`. Use `AlgorithmXX_YY.java` and `MainXX_YY.java` with this exercise's numbers, or keep the existing class names. For data-structure exercises, use the requested class and a separate runner. Compare actual and expected results, including the cases above; throw `AssertionError` on a mismatch (or run Java assertions with `-ea`).

The deliverable is working Java code and checks. You may add a short explanation of the algorithm in `src/README.md`, like exercise 02.01; a formal proof or a separate theoretical answer is not required. Unless stated otherwise, inputs are non-null, indices and graph endpoints are valid, and auxiliary result types such as `Node` or `Selection` are yours to define.

<details><summary>Implementation hint</summary>

Start BFS with all sources at distance zero.

</details>

## Your solution

Keep your Java implementation and executable checks in `src/`. Optionally add a short algorithm explanation in `src/README.md`. Record the attempt in [PROGRESS.md](../../../../PROGRESS.md).

---

<!-- study-navigation -->
[← Previous: Exercise 14.02](../02_directed-cycle-witness/README.md) · [Index](../README.md) · [Next: Exercise 14.04 →](../04_dag-task-completion-times/README.md)
<!-- /study-navigation -->
