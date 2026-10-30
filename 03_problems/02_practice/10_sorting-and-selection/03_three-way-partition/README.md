# 10.03 - Three-Way Partition

<!-- study-navigation -->
[← Previous: Exercise 10.02](../02_counting-inversions/README.md) · [Index](../README.md) · [Next: Exercise 10.04 →](../04_choosing-a-selection-strategy/README.md)
<!-- /study-navigation -->

[Practice index](../../README.md) | Theory: [Sorting, Selection, and Divide and Conquer](../../../../01_algorithms/06_sorting/10-sorting-and-selection.md)

**Status:** Not started. This is a repository-written practice prompt, not a recruiting question-bank item.

## Exercise

Implement `int[] partition(int[] values, int pivot)` in place, returning `[equalStart,equalEnd)` so smaller values precede that region and greater values follow it. Preserve the multiset, use O(n) time and O(1) extra space.

## Examples and checks

For `[3,1,2,3,4]`, pivot 3 returns `[2,4]`; order inside each region is unspecified. Test absent pivots, all equal values and empty input.

## Your workspace

Write your Java 17 implementation and an executable test runner in `src/`. Use `AlgorithmXX_YY.java` and `MainXX_YY.java` with this exercise's numbers, or keep the existing class names. For data-structure exercises, use the requested class and a separate runner. Compare actual and expected results, including the cases above; throw `AssertionError` on a mismatch (or run Java assertions with `-ea`).

The deliverable is working Java code and checks. You may add a short explanation of the algorithm in `src/README.md`, like exercise 02.01; a formal proof or a separate theoretical answer is not required. Unless stated otherwise, inputs are non-null, indices and graph endpoints are valid, and auxiliary result types such as `Node` or `Selection` are yours to define.

<details><summary>Implementation hint</summary>

Track less-than, unknown and greater-than regions; inspect a value swapped in from the right.

</details>

## Your solution

Keep your Java implementation and executable checks in `src/`. Optionally add a short algorithm explanation in `src/README.md`. Record the attempt in [PROGRESS.md](../../../../PROGRESS.md).

---

<!-- study-navigation -->
[← Previous: Exercise 10.02](../02_counting-inversions/README.md) · [Index](../README.md) · [Next: Exercise 10.04 →](../04_choosing-a-selection-strategy/README.md)
<!-- /study-navigation -->
