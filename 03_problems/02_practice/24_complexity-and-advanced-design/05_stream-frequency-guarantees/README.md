# 24.05 - Frequent Stream Candidates

<!-- study-navigation -->
[← Previous: Exercise 24.04](../04_persistent-range-sums/README.md) · [Index](../README.md) · [Next: Exercise 25.01 →](../../25_mixed-interviews/01_threshold-search/README.md)
<!-- /study-navigation -->

[Practice index](../../README.md) | Theory: [Computational Limits and Advanced Algorithm Design](../../../../01_algorithms/13_advanced/24-complexity-and-advanced-design.md)

**Status:** Not started. This is a repository-written practice prompt, not a recruiting question-bank item.

## Exercise

Implement `List<Integer> frequentOverK(int[] values, int k)` for k>=2 using Misra-Gries with at most k-1 candidate counters during the first pass. Make a second pass to verify exact counts and return sorted values occurring strictly more than n/k times. Do not keep a frequency map of all distinct values.

## Examples and checks

`[1,1,1,2,2,3,1], k=3` returns `[1]`; `[1,2,3], k=2` returns empty; test empty input and counts exactly at the threshold.

## Your workspace

Write your Java 17 implementation and an executable test runner in `src/`. Use `AlgorithmXX_YY.java` and `MainXX_YY.java` with this exercise's numbers, or keep the existing class names. For data-structure exercises, use the requested class and a separate runner. Compare actual and expected results, including the cases above; throw `AssertionError` on a mismatch (or run Java assertions with `-ea`).

The deliverable is working Java code and checks. You may add a short explanation of the algorithm in `src/README.md`, like exercise 02.01; a formal proof or a separate theoretical answer is not required. Unless stated otherwise, inputs are non-null, indices and graph endpoints are valid, and auxiliary result types such as `Node` or `Selection` are yours to define.

<details><summary>Implementation hint</summary>

Increment an existing candidate, fill a free slot, or decrement all counters; verify survivors before returning them.

</details>

## Your solution

Keep your Java implementation and executable checks in `src/`. Optionally add a short algorithm explanation in `src/README.md`. Record the attempt in [PROGRESS.md](../../../../PROGRESS.md).

---

<!-- study-navigation -->
[← Previous: Exercise 24.04](../04_persistent-range-sums/README.md) · [Index](../README.md) · [Next: Exercise 25.01 →](../../25_mixed-interviews/01_threshold-search/README.md)
<!-- /study-navigation -->
