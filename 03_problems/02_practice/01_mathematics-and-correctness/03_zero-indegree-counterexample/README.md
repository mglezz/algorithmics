# 01.03 - Directed Cycle Detection

<!-- study-navigation -->
[← Previous: Exercise 01.02](../02_array-reversal-invariant/README.md) · [Index](../README.md) · [Next: Exercise 01.04 →](../04_counting-subsequences/README.md)
<!-- /study-navigation -->

[Practice index](../../README.md) | Theory: [Discrete Mathematics and Correctness](../../../../01_algorithms/01_foundations/01-mathematics-and-correctness.md)

**Status:** Theoretical solution added with assistance; independent review pending. This is a repository-written practice prompt, not a recruiting question-bank item.

## Exercise

Implement `boolean hasCycle(int n, int[][] edges)` for a directed graph with vertices `0..n-1`; each pair is `[from,to]`. Detect cycles in every component, including components disconnected from vertices with indegree zero.

## Examples and checks

`n=3, edges=[[1,2],[2,1]]` returns `true`; `[[0,1],[1,2]]` returns `false`; a self-loop returns `true`; an empty graph returns `false`.

## Your workspace

Write your Java 17 implementation and an executable test runner in `src/`. Use `AlgorithmXX_YY.java` and `MainXX_YY.java` with this exercise's numbers, or keep the existing class names. For data-structure exercises, use the requested class and a separate runner. Compare actual and expected results, including the cases above; throw `AssertionError` on a mismatch (or run Java assertions with `-ea`).

The deliverable is working Java code and checks. You may add a short explanation of the algorithm in `src/README.md`, like exercise 02.01; a formal proof or a separate theoretical answer is not required. Unless stated otherwise, inputs are non-null, indices and graph endpoints are valid, and auxiliary result types such as `Node` or `Selection` are yours to define.

<details><summary>Implementation hint</summary>

Process all components with DFS colors, or count how many vertices Kahn's algorithm removes.

</details>

## Your solution

[Read the solution](src/README.md).

---

<!-- study-navigation -->
[← Previous: Exercise 01.02](../02_array-reversal-invariant/README.md) · [Index](../README.md) · [Next: Exercise 01.04 →](../04_counting-subsequences/README.md)
<!-- /study-navigation -->
