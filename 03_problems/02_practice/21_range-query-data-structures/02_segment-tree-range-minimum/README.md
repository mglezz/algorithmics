# 21.02 - Segment Tree Range Minimum

<!-- study-navigation -->
[← Previous: Exercise 21.01](../01_fenwick-inversion-counting/README.md) · [Index](../README.md) · [Next: Exercise 21.03 →](../03_lazy-assignment-and-addition/README.md)
<!-- /study-navigation -->

[Practice index](../../README.md) | Theory: [Fenwick Trees, Segment Trees, and Sparse Tables](../../../../02_data-structures/10_range-queries/21-range-query-data-structures.md)

**Status:** Not started. This is a repository-written practice prompt, not a recruiting question-bank item.

## Exercise

Implement `RangeMin(int[] values)` with `void set(int index, int value)` and `int min(int left, int right)` over half-open `[left,right)`. Empty queries return Integer.MAX_VALUE. Support O(log n) updates and queries.

## Examples and checks

For `[5,2,7]`, min(0,3)=2; after set(1,9), min(0,3)=5; min(1,1)=Integer.MAX_VALUE. An empty structure allows only its empty query.

## Your workspace

Write your Java 17 implementation and an executable test runner in `src/`. Use `AlgorithmXX_YY.java` and `MainXX_YY.java` with this exercise's numbers, or keep the existing class names. For data-structure exercises, use the requested class and a separate runner. Compare actual and expected results, including the cases above; throw `AssertionError` on a mismatch (or run Java assertions with `-ea`).

The deliverable is working Java code and checks. You may add a short explanation of the algorithm in `src/README.md`, like exercise 02.01; a formal proof or a separate theoretical answer is not required. Unless stated otherwise, inputs are non-null, indices and graph endpoints are valid, and auxiliary result types such as `Node` or `Selection` are yours to define.

<details><summary>Implementation hint</summary>

Use the minimum identity for nonoverlapping segments.

</details>

## Your solution

Keep your Java implementation and executable checks in `src/`. Optionally add a short algorithm explanation in `src/README.md`. Record the attempt in [PROGRESS.md](../../../../PROGRESS.md).

---

<!-- study-navigation -->
[← Previous: Exercise 21.01](../01_fenwick-inversion-counting/README.md) · [Index](../README.md) · [Next: Exercise 21.03 →](../03_lazy-assignment-and-addition/README.md)
<!-- /study-navigation -->
