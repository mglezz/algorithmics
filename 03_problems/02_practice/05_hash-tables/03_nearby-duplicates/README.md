# 05.03 - Nearby Duplicates

<!-- study-navigation -->
[← Previous: Exercise 05.02](../02_grouping-anagrams/README.md) · [Index](../README.md) · [Next: Exercise 05.04 →](../04_hash-collisions/README.md)
<!-- /study-navigation -->

[Practice index](../../README.md) | Theory: [Hash Tables, Sets, and Canonical Keys](../../../../02_data-structures/02_hash-tables/05-hash-tables.md)

**Status:** Not started. This is a repository-written practice prompt, not a recruiting question-bank item.

## Exercise

Implement `boolean containsNearbyDuplicate(int[] values, int k)` for `k>=0`. Return true when two different positions have equal values and their index distance is at most k. Keep at most O(min(n,k+1)) entries.

## Examples and checks

`[1,2,3,1], k=3` returns true and k=2 returns false; k=0 and empty input return false.

## Your workspace

Write your Java 17 implementation and an executable test runner in `src/`. Use `AlgorithmXX_YY.java` and `MainXX_YY.java` with this exercise's numbers, or keep the existing class names. For data-structure exercises, use the requested class and a separate runner. Compare actual and expected results, including the cases above; throw `AssertionError` on a mismatch (or run Java assertions with `-ea`).

The deliverable is working Java code and checks. You may add a short explanation of the algorithm in `src/README.md`, like exercise 02.01; a formal proof or a separate theoretical answer is not required. Unless stated otherwise, inputs are non-null, indices and graph endpoints are valid, and auxiliary result types such as `Node` or `Selection` are yours to define.

<details><summary>Implementation hint</summary>

Maintain a set for the relevant preceding positions and evict expired entries.

</details>

## Your solution

Keep your Java implementation and executable checks in `src/`. Optionally add a short algorithm explanation in `src/README.md`. Record the attempt in [PROGRESS.md](../../../../PROGRESS.md).

---

<!-- study-navigation -->
[← Previous: Exercise 05.02](../02_grouping-anagrams/README.md) · [Index](../README.md) · [Next: Exercise 05.04 →](../04_hash-collisions/README.md)
<!-- /study-navigation -->
