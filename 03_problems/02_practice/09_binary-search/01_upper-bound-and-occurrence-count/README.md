# 09.01 - Upper Bound and Occurrence Count

<!-- study-navigation -->
[← Previous: Exercise 08.04](../../08_stacks-queues-and-monotonic-structures/04_largest-histogram-rectangle/README.md) · [Index](../README.md) · [Next: Exercise 09.02 →](../02_integer-square-root/README.md)
<!-- /study-navigation -->

[Practice index](../../README.md) | Theory: [Binary Search and Monotone Decisions](../../../../01_algorithms/05_searching/09-binary-search.md)

**Status:** Not started. This is a repository-written practice prompt, not a recruiting question-bank item.

## Exercise

Implement `int upperBound(int[] sorted, int target)` returning the first position with value greater than target, or length. Also implement `int countOccurrences(...)` using two binary-search boundaries. Both must run in O(log n).

## Examples and checks

For `[1,2,2,4]`, target 2 gives upper bound 3 and count 2; target 3 gives 3 and 0; an empty array gives 0 and 0.

## Your workspace

Write your Java 17 implementation and an executable test runner in `src/`. Use `AlgorithmXX_YY.java` and `MainXX_YY.java` with this exercise's numbers, or keep the existing class names. For data-structure exercises, use the requested class and a separate runner. Compare actual and expected results, including the cases above; throw `AssertionError` on a mismatch (or run Java assertions with `-ea`).

The deliverable is working Java code and checks. You may add a short explanation of the algorithm in `src/README.md`, like exercise 02.01; a formal proof or a separate theoretical answer is not required. Unless stated otherwise, inputs are non-null, indices and graph endpoints are valid, and auxiliary result types such as `Node` or `Selection` are yours to define.

<details><summary>Implementation hint</summary>

Find the first value greater than target and the first value at least target.

</details>

## Your solution

Keep your Java implementation and executable checks in `src/`. Optionally add a short algorithm explanation in `src/README.md`. Record the attempt in [PROGRESS.md](../../../../PROGRESS.md).

---

<!-- study-navigation -->
[← Previous: Exercise 08.04](../../08_stacks-queues-and-monotonic-structures/04_largest-histogram-rectangle/README.md) · [Index](../README.md) · [Next: Exercise 09.02 →](../02_integer-square-root/README.md)
<!-- /study-navigation -->
