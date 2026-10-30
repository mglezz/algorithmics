# 06.04 - Shortest Target-Sum Range with Negatives

<!-- study-navigation -->
[← Previous: Exercise 06.03](../03_exactly-k-distinct-values/README.md) · [Index](../README.md) · [Next: Exercise 07.01 →](../../07_linked-lists/01_reversing-a-list-segment/README.md)
<!-- /study-navigation -->

[Practice index](../../README.md) | Theory: [Two Pointers and Sliding Windows](../../../../01_algorithms/03_two-pointers/06-two-pointers-and-sliding-windows.md)

**Status:** Not started. This is a repository-written practice prompt, not a recruiting question-bank item.

## Exercise

Implement `int shortestAtLeast(int[] values, long target)` returning the shortest nonempty contiguous range whose sum is at least target, or `-1`. Values may be negative. Use prefix sums and a monotonic deque for O(n) time.

## Examples and checks

`[2,-1,2], target=3` returns `3`; `[1,-1,5], target=5` returns `1`; `[1,2], target=4` returns `-1`; empty input returns `-1`.

## Your workspace

Write your Java 17 implementation and an executable test runner in `src/`. Use `AlgorithmXX_YY.java` and `MainXX_YY.java` with this exercise's numbers, or keep the existing class names. For data-structure exercises, use the requested class and a separate runner. Compare actual and expected results, including the cases above; throw `AssertionError` on a mismatch (or run Java assertions with `-ea`).

The deliverable is working Java code and checks. You may add a short explanation of the algorithm in `src/README.md`, like exercise 02.01; a formal proof or a separate theoretical answer is not required. Unless stated otherwise, inputs are non-null, indices and graph endpoints are valid, and auxiliary result types such as `Node` or `Selection` are yours to define.

<details><summary>Implementation hint</summary>

Maintain candidate prefix indices; a positive-only sliding window is insufficient here.

</details>

## Your solution

Keep your Java implementation and executable checks in `src/`. Optionally add a short algorithm explanation in `src/README.md`. Record the attempt in [PROGRESS.md](../../../../PROGRESS.md).

---

<!-- study-navigation -->
[← Previous: Exercise 06.03](../03_exactly-k-distinct-values/README.md) · [Index](../README.md) · [Next: Exercise 07.01 →](../../07_linked-lists/01_reversing-a-list-segment/README.md)
<!-- /study-navigation -->
