# 20.01 - Overlapping KMP Matches

<!-- study-navigation -->
[← Previous: Exercise 19.05](../../19_dynamic-programming-patterns/05_digit-dp-without-equal-adjacent-digits/README.md) · [Index](../README.md) · [Next: Exercise 20.02 →](../02_trie-operations-and-deletion/README.md)
<!-- /study-navigation -->

[Practice index](../../README.md) | Theory: [Tries](../../../../02_data-structures/09_tries/20-tries.md) | [String Matching](../../../../01_algorithms/11_strings/20-string-matching.md)

**Status:** Not started. This is a repository-written practice prompt, not a recruiting question-bank item.

## Exercise

Implement `List<Integer> findAll(String text, String pattern)` with KMP, returning zero-based match starts including overlaps. Use Java char units. An empty pattern matches at every boundary from 0 through text.length().

## Examples and checks

`aaaaa` with `aaa` returns `[0,1,2]`; a longer absent pattern returns empty; empty text and pattern return `[0]`.

## Your workspace

Write your Java 17 implementation and an executable test runner in `src/`. Use `AlgorithmXX_YY.java` and `MainXX_YY.java` with this exercise's numbers, or keep the existing class names. For data-structure exercises, use the requested class and a separate runner. Compare actual and expected results, including the cases above; throw `AssertionError` on a mismatch (or run Java assertions with `-ea`).

The deliverable is working Java code and checks. You may add a short explanation of the algorithm in `src/README.md`, like exercise 02.01; a formal proof or a separate theoretical answer is not required. Unless stated otherwise, inputs are non-null, indices and graph endpoints are valid, and auxiliary result types such as `Node` or `Selection` are yours to define.

<details><summary>Implementation hint</summary>

After a full match, reuse the prefix-function fallback instead of resetting to zero.

</details>

## Your solution

Keep your Java implementation and executable checks in `src/`. Optionally add a short algorithm explanation in `src/README.md`. Record the attempt in [PROGRESS.md](../../../../PROGRESS.md).

---

<!-- study-navigation -->
[← Previous: Exercise 19.05](../../19_dynamic-programming-patterns/05_digit-dp-without-equal-adjacent-digits/README.md) · [Index](../README.md) · [Next: Exercise 20.02 →](../02_trie-operations-and-deletion/README.md)
<!-- /study-navigation -->
