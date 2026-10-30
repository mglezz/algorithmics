# 05.02 - Grouping Anagrams

<!-- study-navigation -->
[← Previous: Exercise 05.01](../01_longest-target-sum-range/README.md) · [Index](../README.md) · [Next: Exercise 05.03 →](../03_nearby-duplicates/README.md)
<!-- /study-navigation -->

[Practice index](../../README.md) | Theory: [Hash Tables, Sets, and Canonical Keys](../../../../02_data-structures/02_hash-tables/05-hash-tables.md)

**Status:** Not started. This is a repository-written practice prompt, not a recruiting question-bank item.

## Exercise

Implement `List<List<String>> groupAnagrams(String[] words)` for lowercase English words. Preserve repeated words. Group order and order within a group may vary; tests should compare groups without relying on those orders.

## Examples and checks

`["eat","tea","tan","ate","nat","bat"]` forms groups `[eat,tea,ate]`, `[tan,nat]`, `[bat]`; two empty words belong together.

## Your workspace

Write your Java 17 implementation and an executable test runner in `src/`. Use `AlgorithmXX_YY.java` and `MainXX_YY.java` with this exercise's numbers, or keep the existing class names. For data-structure exercises, use the requested class and a separate runner. Compare actual and expected results, including the cases above; throw `AssertionError` on a mismatch (or run Java assertions with `-ea`).

The deliverable is working Java code and checks. You may add a short explanation of the algorithm in `src/README.md`, like exercise 02.01; a formal proof or a separate theoretical answer is not required. Unless stated otherwise, inputs are non-null, indices and graph endpoints are valid, and auxiliary result types such as `Node` or `Selection` are yours to define.

<details><summary>Implementation hint</summary>

Use a sorted-character string or an immutable frequency key.

</details>

## Your solution

Keep your Java implementation and executable checks in `src/`. Optionally add a short algorithm explanation in `src/README.md`. Record the attempt in [PROGRESS.md](../../../../PROGRESS.md).

---

<!-- study-navigation -->
[← Previous: Exercise 05.01](../01_longest-target-sum-range/README.md) · [Index](../README.md) · [Next: Exercise 05.03 →](../03_nearby-duplicates/README.md)
<!-- /study-navigation -->
