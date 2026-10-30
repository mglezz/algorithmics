# 19.05 - Digit DP without Equal Adjacent Digits

<!-- study-navigation -->
[← Previous: Exercise 19.04](../04_rerooting-distance-sums/README.md) · [Index](../README.md) · [Next: Exercise 20.01 →](../../20_tries-and-string-matching/01_overlapping-kmp-matches/README.md)
<!-- /study-navigation -->

[Practice index](../../README.md) | Theory: [Dynamic Programming Patterns and Reconstruction](../../../../01_algorithms/10_dynamic-programming/19-dynamic-programming-patterns.md)

**Status:** Not started. This is a repository-written practice prompt, not a recruiting question-bank item.

## Exercise

Implement `long countValid(long n)` for `0<=n<=10^18`. Count integers in `[0,n]` whose usual decimal representation has no equal adjacent digits. Include zero; leading padding zeros do not belong to the representation.

## Examples and checks

n=0 returns 1; n=20 returns 20; n=100 returns 91. Compare small bounds with direct enumeration.

## Your workspace

Write your Java 17 implementation and an executable test runner in `src/`. Use `AlgorithmXX_YY.java` and `MainXX_YY.java` with this exercise's numbers, or keep the existing class names. For data-structure exercises, use the requested class and a separate runner. Compare actual and expected results, including the cases above; throw `AssertionError` on a mismatch (or run Java assertions with `-ea`).

The deliverable is working Java code and checks. You may add a short explanation of the algorithm in `src/README.md`, like exercise 02.01; a formal proof or a separate theoretical answer is not required. Unless stated otherwise, inputs are non-null, indices and graph endpoints are valid, and auxiliary result types such as `Node` or `Selection` are yours to define.

<details><summary>Implementation hint</summary>

Track the previous digit, whether the number has started and whether the prefix is tight.

</details>

## Your solution

Keep your Java implementation and executable checks in `src/`. Optionally add a short algorithm explanation in `src/README.md`. Record the attempt in [PROGRESS.md](../../../../PROGRESS.md).

---

<!-- study-navigation -->
[← Previous: Exercise 19.04](../04_rerooting-distance-sums/README.md) · [Index](../README.md) · [Next: Exercise 20.01 →](../../20_tries-and-string-matching/01_overlapping-kmp-matches/README.md)
<!-- /study-navigation -->
