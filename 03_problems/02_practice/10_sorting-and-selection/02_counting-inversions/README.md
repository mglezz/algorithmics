# 10.02 - Counting Inversions

<!-- study-navigation -->
[← Previous: Exercise 10.01](../01_stable-merge-sort/README.md) · [Index](../README.md) · [Next: Exercise 10.03 →](../03_three-way-partition/README.md)
<!-- /study-navigation -->

[Practice index](../../README.md) | Theory: [Sorting, Selection, and Divide and Conquer](../../../../01_algorithms/06_sorting/10-sorting-and-selection.md)

**Status:** Not started. This is a repository-written practice prompt, not a recruiting question-bank item.

## Exercise

Implement `long countInversions(int[] values)` in O(n log n), using a working copy so the input remains unchanged. Count pairs i<j with values[i]>values[j]; equality is not an inversion.

## Examples and checks

`[2,4,1,3,5]` returns `3`; `[2,2,1]` returns `2`; empty and sorted arrays return zero.

## Your workspace

Write your Java 17 implementation and an executable test runner in `src/`. Use `AlgorithmXX_YY.java` and `MainXX_YY.java` with this exercise's numbers, or keep the existing class names. For data-structure exercises, use the requested class and a separate runner. Compare actual and expected results, including the cases above; throw `AssertionError` on a mismatch (or run Java assertions with `-ea`).

The deliverable is working Java code and checks. You may add a short explanation of the algorithm in `src/README.md`, like exercise 02.01; a formal proof or a separate theoretical answer is not required. Unless stated otherwise, inputs are non-null, indices and graph endpoints are valid, and auxiliary result types such as `Node` or `Selection` are yours to define.

<details><summary>Implementation hint</summary>

Count remaining left-half elements when taking a strictly smaller right-half value during merging.

### Java helper

Optional helper members for your class; add the necessary imports from java.util. Complete the public API and tests described above.

<!-- java-hint -->
```java
static long crossInversionsWhenTakingRight(int leftIndex, int leftEnd) {
    return (long) leftEnd - leftIndex;
}
```
<!-- /java-hint -->

</details>

## Your solution

Keep your Java implementation and executable checks in `src/`. Optionally add a short algorithm explanation in `src/README.md`. Record the attempt in [PROGRESS.md](../../../../PROGRESS.md).

---

<!-- study-navigation -->
[← Previous: Exercise 10.01](../01_stable-merge-sort/README.md) · [Index](../README.md) · [Next: Exercise 10.03 →](../03_three-way-partition/README.md)
<!-- /study-navigation -->
