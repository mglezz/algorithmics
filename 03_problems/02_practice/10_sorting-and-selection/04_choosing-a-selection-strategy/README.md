# 10.04 - Kth Largest in Arrays and Streams

<!-- study-navigation -->
[← Previous: Exercise 10.03](../03_three-way-partition/README.md) · [Index](../README.md) · [Next: Exercise 11.01 →](../../11_recursion-and-backtracking/01_balanced-parentheses/README.md)
<!-- /study-navigation -->

[Practice index](../../README.md) | Theory: [Sorting, Selection, and Divide and Conquer](../../../../01_algorithms/06_sorting/10-sorting-and-selection.md)

**Status:** Not started. This is a repository-written practice prompt, not a recruiting question-bank item.

## Exercise

Implement `int kthLargest(int[] values, int k)` using quickselect on a copy, and a `KthLargestStream(int k)` with `void add(int value)` and `Integer kth()`. k is positive; array queries require k<=n, while the stream returns null until k values arrive. Use a heap of at most k items for the stream.

## Examples and checks

`[3,2,1,5,6,4], k=2` returns `5`; compare with sorting. Stream 4,1,5 with k=2 reports null,1,4; duplicates count separately.

## Your workspace

Write your Java 17 implementation and an executable test runner in `src/`. Use `AlgorithmXX_YY.java` and `MainXX_YY.java` with this exercise's numbers, or keep the existing class names. For data-structure exercises, use the requested class and a separate runner. Compare actual and expected results, including the cases above; throw `AssertionError` on a mismatch (or run Java assertions with `-ea`).

The deliverable is working Java code and checks. You may add a short explanation of the algorithm in `src/README.md`, like exercise 02.01; a formal proof or a separate theoretical answer is not required. Unless stated otherwise, inputs are non-null, indices and graph endpoints are valid, and auxiliary result types such as `Node` or `Selection` are yours to define.

<details><summary>Implementation hint</summary>

Quickselect narrows one partition; a min-heap retains the k largest arrivals.

</details>

## Your solution

Keep your Java implementation and executable checks in `src/`. Optionally add a short algorithm explanation in `src/README.md`. Record the attempt in [PROGRESS.md](../../../../PROGRESS.md).

---

<!-- study-navigation -->
[← Previous: Exercise 10.03](../03_three-way-partition/README.md) · [Index](../README.md) · [Next: Exercise 11.01 →](../../11_recursion-and-backtracking/01_balanced-parentheses/README.md)
<!-- /study-navigation -->
