# 08.02 - Sliding Maximum

<!-- study-navigation -->
[← Previous: Exercise 08.01](../01_daily-temperatures/README.md) · [Index](../README.md) · [Next: Exercise 08.03 →](../03_queue-from-two-stacks/README.md)
<!-- /study-navigation -->

[Practice index](../../README.md) | Theory: [Stacks and Queues](../../../../02_data-structures/04_stacks-and-queues/08-stacks-and-queues.md) | [Monotonic Stacks and Deques](../../../../01_algorithms/04_monotonic-structures/08-monotonic-stacks-and-deques.md)

**Status:** Not started. This is a repository-written practice prompt, not a recruiting question-bank item.

## Exercise

Implement `int[] slidingMax(int[] values, int k)` for `1<=k<=values.length`. Return the maximum of every length-k window in O(n) time. Add a simple scanning implementation for comparison on small arrays.

## Examples and checks

`[1,3,-1,-3,5,3,6,7], k=3` returns `[3,3,5,5,6,7]`; check k=1, k=n and repeated maxima.

## Your workspace

Write your Java 17 implementation and an executable test runner in `src/`. Use `AlgorithmXX_YY.java` and `MainXX_YY.java` with this exercise's numbers, or keep the existing class names. For data-structure exercises, use the requested class and a separate runner. Compare actual and expected results, including the cases above; throw `AssertionError` on a mismatch (or run Java assertions with `-ea`).

The deliverable is working Java code and checks. You may add a short explanation of the algorithm in `src/README.md`, like exercise 02.01; a formal proof or a separate theoretical answer is not required. Unless stated otherwise, inputs are non-null, indices and graph endpoints are valid, and auxiliary result types such as `Node` or `Selection` are yours to define.

<details><summary>Implementation hint</summary>

A deque holds candidate indices; remove expired indices from the front.

</details>

## Your solution

Keep your Java implementation and executable checks in `src/`. Optionally add a short algorithm explanation in `src/README.md`. Record the attempt in [PROGRESS.md](../../../../PROGRESS.md).

---

<!-- study-navigation -->
[← Previous: Exercise 08.01](../01_daily-temperatures/README.md) · [Index](../README.md) · [Next: Exercise 08.03 →](../03_queue-from-two-stacks/README.md)
<!-- /study-navigation -->
