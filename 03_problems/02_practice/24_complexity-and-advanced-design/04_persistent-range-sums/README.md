# 24.04 - Persistent Range Sums

<!-- study-navigation -->
[← Previous: Exercise 24.03](../03_convex-hull-edge-cases/README.md) · [Index](../README.md) · [Next: Exercise 24.05 →](../05_stream-frequency-guarantees/README.md)
<!-- /study-navigation -->

[Practice index](../../README.md) | Theory: [Computational Limits and Advanced Algorithm Design](../../../../01_algorithms/13_advanced/24-complexity-and-advanced-design.md)

**Status:** Not started. This is a repository-written practice prompt, not a recruiting question-bank item.

## Exercise

Implement `PersistentSums(long[] initial)` with version 0, `int set(int version,int index,long value)` creating a new version, and `long sum(int version,int left,int right)` over half-open ranges. Updates may branch from any version and must preserve old versions. Assume sums fit in long.

## Examples and checks

Start `[1,2,3]`; setting version 0 index 1 to 9 creates total 13 while version 0 stays 6. Branch again from version 0 and verify both earlier versions remain unchanged.

## Your workspace

Write your Java 17 implementation and an executable test runner in `src/`. Use `AlgorithmXX_YY.java` and `MainXX_YY.java` with this exercise's numbers, or keep the existing class names. For data-structure exercises, use the requested class and a separate runner. Compare actual and expected results, including the cases above; throw `AssertionError` on a mismatch (or run Java assertions with `-ea`).

The deliverable is working Java code and checks. You may add a short explanation of the algorithm in `src/README.md`, like exercise 02.01; a formal proof or a separate theoretical answer is not required. Unless stated otherwise, inputs are non-null, indices and graph endpoints are valid, and auxiliary result types such as `Node` or `Selection` are yours to define.

<details><summary>Implementation hint</summary>

Copy only the update path in a persistent segment tree and store every version root.

</details>

## Your solution

Keep your Java implementation and executable checks in `src/`. Optionally add a short algorithm explanation in `src/README.md`. Record the attempt in [PROGRESS.md](../../../../PROGRESS.md).

---

<!-- study-navigation -->
[← Previous: Exercise 24.03](../03_convex-hull-edge-cases/README.md) · [Index](../README.md) · [Next: Exercise 24.05 →](../05_stream-frequency-guarantees/README.md)
<!-- /study-navigation -->
