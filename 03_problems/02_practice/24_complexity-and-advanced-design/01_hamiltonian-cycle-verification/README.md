# 24.01 - Hamiltonian Cycle Verifier

<!-- study-navigation -->
[← Previous: Exercise 23.05](../../23_advanced-graphs-and-flow/05_minimum-cut-certificate/README.md) · [Index](../README.md) · [Next: Exercise 24.02 →](../02_vertex-cover-approximation/README.md)
<!-- /study-navigation -->

[Practice index](../../README.md) | Theory: [Computational Limits and Advanced Algorithm Design](../../../../01_algorithms/13_advanced/24-complexity-and-advanced-design.md)

**Status:** Not started. This is a repository-written practice prompt, not a recruiting question-bank item.

## Exercise

Implement `boolean isHamiltonianCycle(boolean[][] adjacency, int[] cycle)` for a directed n-vertex graph. Require exactly n+1 entries, every vertex once before the final repeated start, valid IDs and all traversed edges. Define n=0 as false; for n=1 require a self-loop.

## Examples and checks

A directed triangle accepts `[0,1,2,0]`; reject a missing closing edge, duplicate internal vertex, out-of-range ID and incorrect length.

## Your workspace

Write your Java 17 implementation and an executable test runner in `src/`. Use `AlgorithmXX_YY.java` and `MainXX_YY.java` with this exercise's numbers, or keep the existing class names. For data-structure exercises, use the requested class and a separate runner. Compare actual and expected results, including the cases above; throw `AssertionError` on a mismatch (or run Java assertions with `-ea`).

The deliverable is working Java code and checks. You may add a short explanation of the algorithm in `src/README.md`, like exercise 02.01; a formal proof or a separate theoretical answer is not required. Unless stated otherwise, inputs are non-null, indices and graph endpoints are valid, and auxiliary result types such as `Node` or `Selection` are yours to define.

<details><summary>Implementation hint</summary>

Use a seen array and inspect each consecutive edge; do not search for a cycle.

</details>

## Your solution

Keep your Java implementation and executable checks in `src/`. Optionally add a short algorithm explanation in `src/README.md`. Record the attempt in [PROGRESS.md](../../../../PROGRESS.md).

---

<!-- study-navigation -->
[← Previous: Exercise 23.05](../../23_advanced-graphs-and-flow/05_minimum-cut-certificate/README.md) · [Index](../README.md) · [Next: Exercise 24.02 →](../02_vertex-cover-approximation/README.md)
<!-- /study-navigation -->
