# 25.05 - Route with a Free Edge

<!-- study-navigation -->
[← Previous: Exercise 25.04](../04_service-startup-order/README.md) · [Index](../README.md) · [Next: Exercise 25.06 →](../06_job-scheduling/README.md)
<!-- /study-navigation -->

[Practice index](../../README.md) | Theory: [Solving, Testing, and Communicating](../../../../01_algorithms/14_problem-solving/25-solving-testing-and-communication.md)

**Status:** Not started. This is a repository-written practice prompt, not a recruiting question-bank item.

## Exercise

Implement `Route cheapestRoute(int n,int[][] edges,int source,int target)` for directed nonnegative weights. Return cost, vertex sequence, input edge IDs and the position of the free edge in that sequence, or -1 if none is used. Use an explicit unreachable status. At most one edge may be free.

## Examples and checks

For `[[0,1,5],[1,2,7]]`, source 0 and target 2 give cost 5, vertices `[0,1,2]` and free edge position 1. Check source=target and parallel edges.

## Your workspace

Write your Java 17 implementation and an executable test runner in `src/`. Use `AlgorithmXX_YY.java` and `MainXX_YY.java` with this exercise's numbers, or keep the existing class names. For data-structure exercises, use the requested class and a separate runner. Compare actual and expected results, including the cases above; throw `AssertionError` on a mismatch (or run Java assertions with `-ea`).

The deliverable is working Java code and checks. You may add a short explanation of the algorithm in `src/README.md`, like exercise 02.01; a formal proof or a separate theoretical answer is not required. Unless stated otherwise, inputs are non-null, indices and graph endpoints are valid, and auxiliary result types such as `Node` or `Selection` are yours to define.

<details><summary>Implementation hint</summary>

Store parents by vertex and coupon state, retaining edge IDs for unambiguous reconstruction.

</details>

## Your solution

Keep your Java implementation and executable checks in `src/`. Optionally add a short algorithm explanation in `src/README.md`. Record the attempt in [PROGRESS.md](../../../../PROGRESS.md).

---

<!-- study-navigation -->
[← Previous: Exercise 25.04](../04_service-startup-order/README.md) · [Index](../README.md) · [Next: Exercise 25.06 →](../06_job-scheduling/README.md)
<!-- /study-navigation -->
