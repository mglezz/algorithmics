# 19.01 - LCS and Edit Reconstruction

<!-- study-navigation -->
[← Previous: Exercise 18.04](../../18_dynamic-programming/04_memoization-sentinels/README.md) · [Index](../README.md) · [Next: Exercise 19.02 →](../02_lis-implementations/README.md)
<!-- /study-navigation -->

[Practice index](../../README.md) | Theory: [Dynamic Programming Patterns and Reconstruction](../../../../01_algorithms/10_dynamic-programming/19-dynamic-programming-patterns.md)

**Status:** Not started. This is a repository-written practice prompt, not a recruiting question-bank item.

## Exercise

Implement `String lcs(String a, String b)` and `List<Edit> editScript(String a, String b)` using char units. An Edit is INSERT(index,char), DELETE(index) or REPLACE(index,char), with indices referring to the string after preceding edits. Return any longest common subsequence and any minimum-length script with unit operation costs.

## Examples and checks

For `abc` and `adc`, an LCS is `ac` and one replacement at index 1 suffices. Apply the returned script in a test; check empty and identical strings.

## Your workspace

Write your Java 17 implementation and an executable test runner in `src/`. Use `AlgorithmXX_YY.java` and `MainXX_YY.java` with this exercise's numbers, or keep the existing class names. For data-structure exercises, use the requested class and a separate runner. Compare actual and expected results, including the cases above; throw `AssertionError` on a mismatch (or run Java assertions with `-ea`).

The deliverable is working Java code and checks. You may add a short explanation of the algorithm in `src/README.md`, like exercise 02.01; a formal proof or a separate theoretical answer is not required. Unless stated otherwise, inputs are non-null, indices and graph endpoints are valid, and auxiliary result types such as `Node` or `Selection` are yours to define.

<details><summary>Implementation hint</summary>

Build DP tables and backtrack; account for index shifts when emitting edits.

</details>

## Your solution

Keep your Java implementation and executable checks in `src/`. Optionally add a short algorithm explanation in `src/README.md`. Record the attempt in [PROGRESS.md](../../../../PROGRESS.md).

---

<!-- study-navigation -->
[← Previous: Exercise 18.04](../../18_dynamic-programming/04_memoization-sentinels/README.md) · [Index](../README.md) · [Next: Exercise 19.02 →](../02_lis-implementations/README.md)
<!-- /study-navigation -->
