# 09.02 - Integer Square Root

<!-- study-navigation -->
[← Previous: Exercise 09.01](../01_upper-bound-and-occurrence-count/README.md) · [Index](../README.md) · [Next: Exercise 09.03 →](../03_minimizing-the-largest-group-sum/README.md)
<!-- /study-navigation -->

[Practice index](../../README.md) | Theory: [Binary Search and Monotone Decisions](../../../../01_algorithms/05_searching/09-binary-search.md)

**Status:** Not started. This is a repository-written practice prompt, not a recruiting question-bank item.

## Exercise

Implement `long floorSqrt(long value)` for `0<=value<=Long.MAX_VALUE`. Return the largest integer whose square is at most value, without floating-point arithmetic or overflowing multiplication.

## Examples and checks

0 returns 0; 8 returns 2; 9 returns 3; Long.MAX_VALUE returns 3037000499L.

## Your workspace

Write your Java 17 implementation and an executable test runner in `src/`. Use `AlgorithmXX_YY.java` and `MainXX_YY.java` with this exercise's numbers, or keep the existing class names. For data-structure exercises, use the requested class and a separate runner. Compare actual and expected results, including the cases above; throw `AssertionError` on a mismatch (or run Java assertions with `-ea`).

The deliverable is working Java code and checks. You may add a short explanation of the algorithm in `src/README.md`, like exercise 02.01; a formal proof or a separate theoretical answer is not required. Unless stated otherwise, inputs are non-null, indices and graph endpoints are valid, and auxiliary result types such as `Node` or `Selection` are yours to define.

<details><summary>Implementation hint</summary>

Compare a positive candidate with value/candidate and use safe search boundaries.

### Java helper

Optional helper members for your class; add the necessary imports from java.util. Complete the public API and tests described above.

<!-- java-hint -->
```java
static boolean squareAtMost(long candidate, long value) {
    if (candidate < 0 || value < 0) {
        throw new IllegalArgumentException("Nonnegative values required");
    }
    return candidate == 0 || candidate <= value / candidate;
}
```
<!-- /java-hint -->

</details>

## Your solution

Keep your Java implementation and executable checks in `src/`. Optionally add a short algorithm explanation in `src/README.md`. Record the attempt in [PROGRESS.md](../../../../PROGRESS.md).

---

<!-- study-navigation -->
[← Previous: Exercise 09.01](../01_upper-bound-and-occurrence-count/README.md) · [Index](../README.md) · [Next: Exercise 09.03 →](../03_minimizing-the-largest-group-sum/README.md)
<!-- /study-navigation -->
