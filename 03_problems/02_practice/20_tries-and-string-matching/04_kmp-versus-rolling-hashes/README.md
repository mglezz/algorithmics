# 20.04 - Collision-Safe Rolling-Hash Search

<!-- study-navigation -->
[← Previous: Exercise 20.03](../03_shortest-repeating-period/README.md) · [Index](../README.md) · [Next: Exercise 21.01 →](../../21_range-query-data-structures/01_fenwick-inversion-counting/README.md)
<!-- /study-navigation -->

[Practice index](../../README.md) | Theory: [Tries](../../../../02_data-structures/09_tries/20-tries.md) | [String Matching](../../../../01_algorithms/11_strings/20-string-matching.md)

**Status:** Not started. This is a repository-written practice prompt, not a recruiting question-bank item.

## Exercise

Implement `List<Integer> findWithHash(String text, String pattern)` using a rolling hash to find candidate windows, then character checks to confirm every match. Return all starts including overlaps; an empty pattern matches all boundaries. Compare results with KMP.

## Examples and checks

`aaaaa, aaa` returns `[0,1,2]`. Make the modulus configurable for tests and use a tiny modulus to exercise collisions without false matches.

## Your workspace

Write your Java 17 implementation and an executable test runner in `src/`. Use `AlgorithmXX_YY.java` and `MainXX_YY.java` with this exercise's numbers, or keep the existing class names. For data-structure exercises, use the requested class and a separate runner. Compare actual and expected results, including the cases above; throw `AssertionError` on a mismatch (or run Java assertions with `-ea`).

The deliverable is working Java code and checks. You may add a short explanation of the algorithm in `src/README.md`, like exercise 02.01; a formal proof or a separate theoretical answer is not required. Unless stated otherwise, inputs are non-null, indices and graph endpoints are valid, and auxiliary result types such as `Node` or `Selection` are yours to define.

<details><summary>Implementation hint</summary>

A matching hash is a candidate, not a final equality test; use long arithmetic with bounded base and modulus.

</details>

## Your solution

Keep your Java implementation and executable checks in `src/`. Optionally add a short algorithm explanation in `src/README.md`. Record the attempt in [PROGRESS.md](../../../../PROGRESS.md).

---

<!-- study-navigation -->
[← Previous: Exercise 20.03](../03_shortest-repeating-period/README.md) · [Index](../README.md) · [Next: Exercise 21.01 →](../../21_range-query-data-structures/01_fenwick-inversion-counting/README.md)
<!-- /study-navigation -->
