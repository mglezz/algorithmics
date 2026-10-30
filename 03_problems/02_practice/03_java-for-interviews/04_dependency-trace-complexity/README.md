# 03.04 - Service Ordering with Optional Tracing

<!-- study-navigation -->
[← Previous: Exercise 03.03](../03_immutable-coordinate-keys/README.md) · [Index](../README.md) · [Next: Exercise 04.01 →](../../04_arrays-strings-and-prefix-sums/01_equilibrium-index/README.md)
<!-- /study-navigation -->

[Practice index](../../README.md) | Theory: [Java for Algorithmic Interviews](../../../../01_algorithms/01_foundations/03-java-for-interviews.md)

**Status:** Not started. This is a repository-written practice prompt, not a recruiting question-bank item.

## Exercise

Implement Kahn's algorithm as `int[] startupOrder(int n, int[][] dependencies, boolean trace)`, where `[service,prerequisite]` requires the prerequisite first. Return an empty array on cycles. When tracing is enabled, print the current order prefix after each removal and count how many vertex IDs were printed; expose that count for tests.

## Examples and checks

For a chain of 4 services, both modes return `[0,1,2,3]`; tracing prints 10 IDs in total and quiet mode prints none. Check disconnected services and cycles.

## Your workspace

Write your Java 17 implementation and an executable test runner in `src/`. Use `AlgorithmXX_YY.java` and `MainXX_YY.java` with this exercise's numbers, or keep the existing class names. For data-structure exercises, use the requested class and a separate runner. Compare actual and expected results, including the cases above; throw `AssertionError` on a mismatch (or run Java assertions with `-ea`).

The deliverable is working Java code and checks. You may add a short explanation of the algorithm in `src/README.md`, like exercise 02.01; a formal proof or a separate theoretical answer is not required. Unless stated otherwise, inputs are non-null, indices and graph endpoints are valid, and auxiliary result types such as `Node` or `Selection` are yours to define.

<details><summary>Implementation hint</summary>

Keep tracing outside the graph bookkeeping; count output entries instead of measuring elapsed time.

</details>

## Your solution

Keep your Java implementation and executable checks in `src/`. Optionally add a short algorithm explanation in `src/README.md`. Record the attempt in [PROGRESS.md](../../../../PROGRESS.md).

---

<!-- study-navigation -->
[← Previous: Exercise 03.03](../03_immutable-coordinate-keys/README.md) · [Index](../README.md) · [Next: Exercise 04.01 →](../../04_arrays-strings-and-prefix-sums/01_equilibrium-index/README.md)
<!-- /study-navigation -->
