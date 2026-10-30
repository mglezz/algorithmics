# 01.02 - Array Reversal

<!-- study-navigation -->
[← Previous: Exercise 01.01](../01_sorted-array-deduplication/README.md) · [Index](../README.md) · [Next: Exercise 01.03 →](../03_zero-indegree-counterexample/README.md)
<!-- /study-navigation -->

[Practice index](../../README.md) | Theory: [Discrete Mathematics and Correctness](../../../../01_algorithms/01_foundations/01-mathematics-and-correctness.md)

**Status:** Not started. This is a repository-written practice prompt, not a recruiting question-bank item.

## Exercise

Implement `void reverse(int[] values)` by swapping elements in the original array. Do not allocate a second array. If you already wrote a copy-based version, keep it and add this in-place version as a separate method.

## Examples and checks

`[1,2,3,4,5]` becomes `[5,4,3,2,1]`; also check an empty array, one element and an even length.

## Your workspace

Write your Java 17 implementation and an executable test runner in `src/`. Use `AlgorithmXX_YY.java` and `MainXX_YY.java` with this exercise's numbers, or keep the existing class names. For data-structure exercises, use the requested class and a separate runner. Compare actual and expected results, including the cases above; throw `AssertionError` on a mismatch (or run Java assertions with `-ea`).

The deliverable is working Java code and checks. You may add a short explanation of the algorithm in `src/README.md`, like exercise 02.01; a formal proof or a separate theoretical answer is not required. Unless stated otherwise, inputs are non-null, indices and graph endpoints are valid, and auxiliary result types such as `Node` or `Selection` are yours to define.

<details><summary>Implementation hint</summary>

Move two indices toward the center and stop before they cross.

### Java helper

Optional helper members for your class; add the necessary imports from java.util. Complete the public API and tests described above.

<!-- java-hint -->
```java
static void swap(int[] values, int left, int right) {
    int saved = values[left];
    values[left] = values[right];
    values[right] = saved;
}
```
<!-- /java-hint -->

</details>

## Your solution

Keep your Java implementation and executable checks in `src/`. Optionally add a short algorithm explanation in `src/README.md`. Record the attempt in [PROGRESS.md](../../../../PROGRESS.md).

---

<!-- study-navigation -->
[← Previous: Exercise 01.01](../01_sorted-array-deduplication/README.md) · [Index](../README.md) · [Next: Exercise 01.03 →](../03_zero-indegree-counterexample/README.md)
<!-- /study-navigation -->
