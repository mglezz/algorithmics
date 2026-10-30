# 10.01 - Stable Merge Sort

<!-- study-navigation -->
[← Previous: Exercise 09.04](../../09_binary-search/04_rotated-arrays-with-duplicates/README.md) · [Index](../README.md) · [Next: Exercise 10.02 →](../02_counting-inversions/README.md)
<!-- /study-navigation -->

[Practice index](../../README.md) | Theory: [Sorting, Selection, and Divide and Conquer](../../../../01_algorithms/06_sorting/10-sorting-and-selection.md)

**Status:** Not started. This is a repository-written practice prompt, not a recruiting question-bank item.

## Exercise

Define `Item(int key, String label)` and implement `void mergeSort(Item[] items)` sorting by key while retaining input order among equal keys. Write the merge sort yourself using O(n) auxiliary storage.

## Examples and checks

`[(2,a),(1,b),(2,c)]` becomes `[(1,b),(2,a),(2,c)]`; verify every original item appears once; test empty and sorted input.

## Your workspace

Write your Java 17 implementation and an executable test runner in `src/`. Use `AlgorithmXX_YY.java` and `MainXX_YY.java` with this exercise's numbers, or keep the existing class names. For data-structure exercises, use the requested class and a separate runner. Compare actual and expected results, including the cases above; throw `AssertionError` on a mismatch (or run Java assertions with `-ea`).

The deliverable is working Java code and checks. You may add a short explanation of the algorithm in `src/README.md`, like exercise 02.01; a formal proof or a separate theoretical answer is not required. Unless stated otherwise, inputs are non-null, indices and graph endpoints are valid, and auxiliary result types such as `Node` or `Selection` are yours to define.

<details><summary>Implementation hint</summary>

When keys tie, take the left-hand item first.

</details>

## Your solution

Keep your Java implementation and executable checks in `src/`. Optionally add a short algorithm explanation in `src/README.md`. Record the attempt in [PROGRESS.md](../../../../PROGRESS.md).

---

<!-- study-navigation -->
[← Previous: Exercise 09.04](../../09_binary-search/04_rotated-arrays-with-duplicates/README.md) · [Index](../README.md) · [Next: Exercise 10.02 →](../02_counting-inversions/README.md)
<!-- /study-navigation -->
