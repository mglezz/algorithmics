# 03.01 - Safe Integer Products

<!-- study-navigation -->
[← Previous: Exercise 02.04](../../02_complexity-and-amortization/04_pseudopolynomial-knapsack/README.md) · [Index](../README.md) · [Next: Exercise 03.02 →](../02_max-heap-snapshot/README.md)
<!-- /study-navigation -->

[Practice index](../../README.md) | Theory: [Java for Algorithmic Interviews](../../../../01_algorithms/01_foundations/03-java-for-interviews.md)

**Status:** Not started. This is a repository-written practice prompt, not a recruiting question-bank item.

## Exercise

Implement `long multiply(int a, int b)` that returns the exact product for any two int values. Add a small Java runner that compares it with `(long) (a*b)` on overflowing inputs.

## Examples and checks

`50000,50000` returns `2500000000L`; include zero, negative operands and both int extremes.

## Your workspace

Write your Java 17 implementation and an executable test runner in `src/`. Use `AlgorithmXX_YY.java` and `MainXX_YY.java` with this exercise's numbers, or keep the existing class names. For data-structure exercises, use the requested class and a separate runner. Compare actual and expected results, including the cases above; throw `AssertionError` on a mismatch (or run Java assertions with `-ea`).

The deliverable is working Java code and checks. You may add a short explanation of the algorithm in `src/README.md`, like exercise 02.01; a formal proof or a separate theoretical answer is not required. Unless stated otherwise, inputs are non-null, indices and graph endpoints are valid, and auxiliary result types such as `Node` or `Selection` are yours to define.

<details><summary>Implementation hint</summary>

Widen an operand before multiplication.

</details>

## Your solution

Keep your Java implementation and executable checks in `src/`. Optionally add a short algorithm explanation in `src/README.md`. Record the attempt in [PROGRESS.md](../../../../PROGRESS.md).

---

<!-- study-navigation -->
[← Previous: Exercise 02.04](../../02_complexity-and-amortization/04_pseudopolynomial-knapsack/README.md) · [Index](../README.md) · [Next: Exercise 03.02 →](../02_max-heap-snapshot/README.md)
<!-- /study-navigation -->
