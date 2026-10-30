# 20.03 - Shortest Repeating Period

<!-- study-navigation -->
[← Previous: Exercise 20.02](../02_trie-operations-and-deletion/README.md) · [Index](../README.md) · [Next: Exercise 20.04 →](../04_kmp-versus-rolling-hashes/README.md)
<!-- /study-navigation -->

[Practice index](../../README.md) | Theory: [Tries](../../../../02_data-structures/09_tries/20-tries.md) | [String Matching](../../../../01_algorithms/11_strings/20-string-matching.md)

**Status:** Not started. This is a repository-written practice prompt, not a recruiting question-bank item.

## Exercise

Implement `int shortestPeriod(String text)` using its prefix function. Return the length of the shortest block whose whole repetitions produce the string; return 0 for empty input.

## Examples and checks

`ababab` returns 2; `aaaa` returns 1; `ababa` returns 5; empty returns 0.

## Your workspace

Write your Java 17 implementation and an executable test runner in `src/`. Use `AlgorithmXX_YY.java` and `MainXX_YY.java` with this exercise's numbers, or keep the existing class names. For data-structure exercises, use the requested class and a separate runner. Compare actual and expected results, including the cases above; throw `AssertionError` on a mismatch (or run Java assertions with `-ea`).

The deliverable is working Java code and checks. You may add a short explanation of the algorithm in `src/README.md`, like exercise 02.01; a formal proof or a separate theoretical answer is not required. Unless stated otherwise, inputs are non-null, indices and graph endpoints are valid, and auxiliary result types such as `Node` or `Selection` are yours to define.

<details><summary>Implementation hint</summary>

The candidate length n-prefix[n-1] is valid only when it divides n.

</details>

## Your solution

Keep your Java implementation and executable checks in `src/`. Optionally add a short algorithm explanation in `src/README.md`. Record the attempt in [PROGRESS.md](../../../../PROGRESS.md).

---

<!-- study-navigation -->
[← Previous: Exercise 20.02](../02_trie-operations-and-deletion/README.md) · [Index](../README.md) · [Next: Exercise 20.04 →](../04_kmp-versus-rolling-hashes/README.md)
<!-- /study-navigation -->
