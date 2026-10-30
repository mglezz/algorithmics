# 21.01 - Fenwick Inversion Counting

<!-- study-navigation -->
[← Previous: Exercise 20.04](../../20_tries-and-string-matching/04_kmp-versus-rolling-hashes/README.md) · [Index](../README.md) · [Next: Exercise 21.02 →](../02_segment-tree-range-minimum/README.md)
<!-- /study-navigation -->

[Practice index](../../README.md) | Theory: [Fenwick Trees, Segment Trees, and Sparse Tables](../../../../02_data-structures/10_range-queries/21-range-query-data-structures.md)

**Status:** Not started. This is a repository-written practice prompt, not a recruiting question-bank item.

## Exercise

Implement `long countInversions(int[] values)` using coordinate compression and a Fenwick tree. Count pairs i<j with values[i]>values[j], preserve the input, and compare with merge-sort or brute-force counting on small arrays.

## Examples and checks

`[3,1,2]` returns 2; `[2,2,1]` returns 2; check negative values and int extremes.

## Your workspace

Write your Java 17 implementation and an executable test runner in `src/`. Use `AlgorithmXX_YY.java` and `MainXX_YY.java` with this exercise's numbers, or keep the existing class names. For data-structure exercises, use the requested class and a separate runner. Compare actual and expected results, including the cases above; throw `AssertionError` on a mismatch (or run Java assertions with `-ea`).

The deliverable is working Java code and checks. You may add a short explanation of the algorithm in `src/README.md`, like exercise 02.01; a formal proof or a separate theoretical answer is not required. Unless stated otherwise, inputs are non-null, indices and graph endpoints are valid, and auxiliary result types such as `Node` or `Selection` are yours to define.

<details><summary>Implementation hint</summary>

Equal values share a rank; query only strictly smaller or larger ranks.

</details>

## Your solution

Keep your Java implementation and executable checks in `src/`. Optionally add a short algorithm explanation in `src/README.md`. Record the attempt in [PROGRESS.md](../../../../PROGRESS.md).

---

<!-- study-navigation -->
[← Previous: Exercise 20.04](../../20_tries-and-string-matching/04_kmp-versus-rolling-hashes/README.md) · [Index](../README.md) · [Next: Exercise 21.02 →](../02_segment-tree-range-minimum/README.md)
<!-- /study-navigation -->
