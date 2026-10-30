# 06.03 - Exactly K Distinct Values

<!-- study-navigation -->
[← Previous: Exercise 06.02](../02_minimum-covering-window/README.md) · [Index](../README.md) · [Next: Exercise 06.04 →](../04_negative-value-counterexample/README.md)
<!-- /study-navigation -->

[Practice index](../../README.md) | Theory: [Two Pointers and Sliding Windows](../../../../01_algorithms/03_two-pointers/06-two-pointers-and-sliding-windows.md)

**Status:** Not started. This is a repository-written practice prompt, not a recruiting question-bank item.

## Exercise

Implement `long countExactlyK(int[] values, int k)` counting nonempty contiguous ranges containing exactly k distinct values. Return zero for `k<=0`. Aim for expected O(n) time.

## Examples and checks

`[1,2,1,2,3], k=2` returns `7`; empty input and k larger than the number of distinct values return zero.

## Your workspace

Write your Java 17 implementation and an executable test runner in `src/`. Use `AlgorithmXX_YY.java` and `MainXX_YY.java` with this exercise's numbers, or keep the existing class names. For data-structure exercises, use the requested class and a separate runner. Compare actual and expected results, including the cases above; throw `AssertionError` on a mismatch (or run Java assertions with `-ea`).

The deliverable is working Java code and checks. You may add a short explanation of the algorithm in `src/README.md`, like exercise 02.01; a formal proof or a separate theoretical answer is not required. Unless stated otherwise, inputs are non-null, indices and graph endpoints are valid, and auxiliary result types such as `Node` or `Selection` are yours to define.

<details><summary>Implementation hint</summary>

Subtract the counts for at most k and at most k-1 distinct values.

</details>

## Your solution

Keep your Java implementation and executable checks in `src/`. Optionally add a short algorithm explanation in `src/README.md`. Record the attempt in [PROGRESS.md](../../../../PROGRESS.md).

---

<!-- study-navigation -->
[← Previous: Exercise 06.02](../02_minimum-covering-window/README.md) · [Index](../README.md) · [Next: Exercise 06.04 →](../04_negative-value-counterexample/README.md)
<!-- /study-navigation -->
