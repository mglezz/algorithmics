# 08.04 - Largest Histogram Rectangle

<!-- study-navigation -->
[← Previous: Exercise 08.03](../03_queue-from-two-stacks/README.md) · [Index](../README.md) · [Next: Exercise 09.01 →](../../09_binary-search/01_upper-bound-and-occurrence-count/README.md)
<!-- /study-navigation -->

[Practice index](../../README.md) | Theory: [Stacks and Queues](../../../../02_data-structures/04_stacks-and-queues/08-stacks-and-queues.md) | [Monotonic Stacks and Deques](../../../../01_algorithms/04_monotonic-structures/08-monotonic-stacks-and-deques.md)

**Status:** Not started. This is a repository-written practice prompt, not a recruiting question-bank item.

## Exercise

Implement `long largestRectangle(int[] heights)` for nonnegative heights and unit-width bars in O(n) time. Empty input returns zero.

## Examples and checks

`[2,1,5,6,2,3]` returns `10`; `[2,2]` returns `4`; `[2,0,2]` returns `2`; test an increasing histogram.

## Your workspace

Write your Java 17 implementation and an executable test runner in `src/`. Use `AlgorithmXX_YY.java` and `MainXX_YY.java` with this exercise's numbers, or keep the existing class names. For data-structure exercises, use the requested class and a separate runner. Compare actual and expected results, including the cases above; throw `AssertionError` on a mismatch (or run Java assertions with `-ea`).

The deliverable is working Java code and checks. You may add a short explanation of the algorithm in `src/README.md`, like exercise 02.01; a formal proof or a separate theoretical answer is not required. Unless stated otherwise, inputs are non-null, indices and graph endpoints are valid, and auxiliary result types such as `Node` or `Selection` are yours to define.

<details><summary>Implementation hint</summary>

Use a monotonic stack and flush pending bars at the end.

</details>

## Your solution

Keep your Java implementation and executable checks in `src/`. Optionally add a short algorithm explanation in `src/README.md`. Record the attempt in [PROGRESS.md](../../../../PROGRESS.md).

---

<!-- study-navigation -->
[← Previous: Exercise 08.03](../03_queue-from-two-stacks/README.md) · [Index](../README.md) · [Next: Exercise 09.01 →](../../09_binary-search/01_upper-bound-and-occurrence-count/README.md)
<!-- /study-navigation -->
