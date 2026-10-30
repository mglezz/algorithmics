# 05.04 - Collision-Safe Word Counts

<!-- study-navigation -->
[← Previous: Exercise 05.03](../03_nearby-duplicates/README.md) · [Index](../README.md) · [Next: Exercise 06.01 →](../../06_two-pointers-and-sliding-windows/01_flipping-zeros/README.md)
<!-- /study-navigation -->

[Practice index](../../README.md) | Theory: [Hash Tables, Sets, and Canonical Keys](../../../../02_data-structures/02_hash-tables/05-hash-tables.md)

**Status:** Not started. This is a repository-written practice prompt, not a recruiting question-bank item.

## Exercise

Implement `Map<String,Integer> countWords(String[] words)` using complete strings as keys. Add a Java regression test with different strings that share a hash code; both must retain separate counts.

## Examples and checks

`["Aa","BB","Aa"]` returns `Aa=2, BB=1`; assert that `"Aa".hashCode()=="BB".hashCode()` and that the result contains two keys.

## Your workspace

Write your Java 17 implementation and an executable test runner in `src/`. Use `AlgorithmXX_YY.java` and `MainXX_YY.java` with this exercise's numbers, or keep the existing class names. For data-structure exercises, use the requested class and a separate runner. Compare actual and expected results, including the cases above; throw `AssertionError` on a mismatch (or run Java assertions with `-ea`).

The deliverable is working Java code and checks. You may add a short explanation of the algorithm in `src/README.md`, like exercise 02.01; a formal proof or a separate theoretical answer is not required. Unless stated otherwise, inputs are non-null, indices and graph endpoints are valid, and auxiliary result types such as `Node` or `Selection` are yours to define.

<details><summary>Implementation hint</summary>

Let HashMap use equality as well as hashes; do not key counts by hashCode alone.

</details>

## Your solution

Keep your Java implementation and executable checks in `src/`. Optionally add a short algorithm explanation in `src/README.md`. Record the attempt in [PROGRESS.md](../../../../PROGRESS.md).

---

<!-- study-navigation -->
[← Previous: Exercise 05.03](../03_nearby-duplicates/README.md) · [Index](../README.md) · [Next: Exercise 06.01 →](../../06_two-pointers-and-sliding-windows/01_flipping-zeros/README.md)
<!-- /study-navigation -->
