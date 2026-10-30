# 04.02 - Range Increments

<!-- study-navigation -->
[← Previous: Exercise 04.01](../01_equilibrium-index/README.md) · [Index](../README.md) · [Next: Exercise 04.03 →](../03_rectangle-sums/README.md)
<!-- /study-navigation -->

[Practice index](../../README.md) | Theory: [Arrays and Strings](../../../../02_data-structures/01_arrays-and-strings/04-arrays-and-strings.md) | [Prefix Sums and Difference Arrays](../../../../01_algorithms/02_range-queries/04-prefix-sums-and-difference-arrays.md)

**Status:** Not started. This is a repository-written practice prompt, not a recruiting question-bank item.

## Exercise

Implement `long[] applyIncrements(int n, int[][] updates)` starting with n zeros. Each update `[left,right,delta]` adds delta to the inclusive range with `0<=left<=right<n`. Use a difference array for O(n+q) time. With n zero, updates must be empty.

## Examples and checks

`n=5, [[1,3,2],[2,4,-1]]` returns `[0,2,1,1,-1]`; check no updates and an update covering the whole array.

## Your workspace

Write your Java 17 implementation and an executable test runner in `src/`. Use `AlgorithmXX_YY.java` and `MainXX_YY.java` with this exercise's numbers, or keep the existing class names. For data-structure exercises, use the requested class and a separate runner. Compare actual and expected results, including the cases above; throw `AssertionError` on a mismatch (or run Java assertions with `-ea`).

The deliverable is working Java code and checks. You may add a short explanation of the algorithm in `src/README.md`, like exercise 02.01; a formal proof or a separate theoretical answer is not required. Unless stated otherwise, inputs are non-null, indices and graph endpoints are valid, and auxiliary result types such as `Node` or `Selection` are yours to define.

<details><summary>Implementation hint</summary>

Translate inclusive right into the exclusive position right+1 for the helper below.

### Java helper

Optional helper members for your class; add the necessary imports from java.util. Complete the public API and tests described above.

<!-- java-hint -->
```java
static void addRange(long[] difference, int left, int right, long delta) {
    int n = difference.length - 1;
    if (left < 0 || left > right || right > n) {
        throw new IllegalArgumentException("Invalid half-open range");
    }
    difference[left] += delta;
    difference[right] -= delta;
}
```
<!-- /java-hint -->

</details>

## Your solution

Keep your Java implementation and executable checks in `src/`. Optionally add a short algorithm explanation in `src/README.md`. Record the attempt in [PROGRESS.md](../../../../PROGRESS.md).

---

<!-- study-navigation -->
[← Previous: Exercise 04.01](../01_equilibrium-index/README.md) · [Index](../README.md) · [Next: Exercise 04.03 →](../03_rectangle-sums/README.md)
<!-- /study-navigation -->
