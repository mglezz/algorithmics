# 01.04 - Counting Subsequences

<!-- study-navigation -->
[← Previous: Exercise 01.03](../03_zero-indegree-counterexample/README.md) · [Index](../README.md) · [Next: Exercise 02.01 →](../../02_complexity-and-amortization/01_repeated-division/README.md)
<!-- /study-navigation -->

[Practice index](../../README.md) | Theory: [Discrete Mathematics and Correctness](../../../../01_algorithms/01_foundations/01-mathematics-and-correctness.md)

**Status:** Theoretical solution added with assistance; independent review pending. This is a repository-written practice prompt, not a recruiting question-bank item.

## Exercise

Implement `java.math.BigInteger countSubsequences(int[] values, int k)` to count subsequences of length `k` by chosen indices. Equal values at different indices count separately. Return zero for `k<0` or `k>values.length`, and one for `k=0`. Avoid enumerating all subsequences.

## Examples and checks

`[7,7,9], k=2` returns `3`; `[], k=0` returns `1`; 100 elements and `k=50` must work without primitive-number overflow.

## Your workspace

Write your Java 17 implementation and an executable test runner in `src/`. Use `AlgorithmXX_YY.java` and `MainXX_YY.java` with this exercise's numbers, or keep the existing class names. For data-structure exercises, use the requested class and a separate runner. Compare actual and expected results, including the cases above; throw `AssertionError` on a mismatch (or run Java assertions with `-ea`).

The deliverable is working Java code and checks. You may add a short explanation of the algorithm in `src/README.md`, like exercise 02.01; a formal proof or a separate theoretical answer is not required. Unless stated otherwise, inputs are non-null, indices and graph endpoints are valid, and auxiliary result types such as `Node` or `Selection` are yours to define.

<details><summary>Implementation hint</summary>

Build binomial coefficients with BigInteger and a one-dimensional DP array.

</details>

## Your solution

[Read the solution](src/README.md).

---

<!-- study-navigation -->
[← Previous: Exercise 01.03](../03_zero-indegree-counterexample/README.md) · [Index](../README.md) · [Next: Exercise 02.01 →](../../02_complexity-and-amortization/01_repeated-division/README.md)
<!-- /study-navigation -->
