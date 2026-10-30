# 02.03 - Next Greater Element with Operation Counts

<!-- study-navigation -->
[← Previous: Exercise 02.02](../02_pairwise-string-comparison/README.md) · [Index](../README.md) · [Next: Exercise 02.04 →](../04_pseudopolynomial-knapsack/README.md)
<!-- /study-navigation -->

[Practice index](../../README.md) | Theory: [Complexity, Recurrences, and Amortization](../../../../01_algorithms/01_foundations/02-complexity-and-amortization.md)

**Status:** Not started. This is a repository-written practice prompt, not a recruiting question-bank item.

## Exercise

Implement `int[] nextGreaterIndex(int[] values)` returning the first index to the right with a strictly greater value, or `-1`. Use a monotonic stack of indices. Instrument pushes and pops in a separate result or debug counter.

## Examples and checks

`[2,1,2,4,3]` returns `[3,2,3,-1,-1]`; check increasing, decreasing and equal arrays. Assert exactly n pushes and at most n pops.

## Your workspace

Write your Java 17 implementation and an executable test runner in `src/`. Use `AlgorithmXX_YY.java` and `MainXX_YY.java` with this exercise's numbers, or keep the existing class names. For data-structure exercises, use the requested class and a separate runner. Compare actual and expected results, including the cases above; throw `AssertionError` on a mismatch (or run Java assertions with `-ea`).

The deliverable is working Java code and checks. You may add a short explanation of the algorithm in `src/README.md`, like exercise 02.01; a formal proof or a separate theoretical answer is not required. Unless stated otherwise, inputs are non-null, indices and graph endpoints are valid, and auxiliary result types such as `Node` or `Selection` are yours to define.

<details><summary>Implementation hint</summary>

Resolve smaller pending values before pushing the current index; equal values remain pending.

</details>

## Your solution

Keep your Java implementation and executable checks in `src/`. Optionally add a short algorithm explanation in `src/README.md`. Record the attempt in [PROGRESS.md](../../../../PROGRESS.md).

---

<!-- study-navigation -->
[← Previous: Exercise 02.02](../02_pairwise-string-comparison/README.md) · [Index](../README.md) · [Next: Exercise 02.04 →](../04_pseudopolynomial-knapsack/README.md)
<!-- /study-navigation -->
