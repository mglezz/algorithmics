# 03.03 - Coordinate Frequency Map

<!-- study-navigation -->
[← Previous: Exercise 03.02](../02_max-heap-snapshot/README.md) · [Index](../README.md) · [Next: Exercise 03.04 →](../04_dependency-trace-complexity/README.md)
<!-- /study-navigation -->

[Practice index](../../README.md) | Theory: [Java for Algorithmic Interviews](../../../../01_algorithms/01_foundations/03-java-for-interviews.md)

**Status:** Not started. This is a repository-written practice prompt, not a recruiting question-bank item.

## Exercise

Define an immutable `Point(int row, int column)` and implement `Map<Point,Integer> frequencies(int[][] coordinates)`, counting each coordinate pair by value.

## Examples and checks

`[[1,2],[1,2],[2,1]]` produces counts 2 and 1. Lookup with a newly constructed `Point(1,2)` returns 2.

## Your workspace

Write your Java 17 implementation and an executable test runner in `src/`. Use `AlgorithmXX_YY.java` and `MainXX_YY.java` with this exercise's numbers, or keep the existing class names. For data-structure exercises, use the requested class and a separate runner. Compare actual and expected results, including the cases above; throw `AssertionError` on a mismatch (or run Java assertions with `-ea`).

The deliverable is working Java code and checks. You may add a short explanation of the algorithm in `src/README.md`, like exercise 02.01; a formal proof or a separate theoretical answer is not required. Unless stated otherwise, inputs are non-null, indices and graph endpoints are valid, and auxiliary result types such as `Node` or `Selection` are yours to define.

<details><summary>Implementation hint</summary>

A Java record supplies value equality and a compatible hash code.

### Java helper

Optional helper members for your class; add the necessary imports from java.util. Complete the public API and tests described above.

<!-- java-hint -->
```java
record Point(int row, int column) {}
```
<!-- /java-hint -->

</details>

## Your solution

Keep your Java implementation and executable checks in `src/`. Optionally add a short algorithm explanation in `src/README.md`. Record the attempt in [PROGRESS.md](../../../../PROGRESS.md).

---

<!-- study-navigation -->
[← Previous: Exercise 03.02](../02_max-heap-snapshot/README.md) · [Index](../README.md) · [Next: Exercise 03.04 →](../04_dependency-trace-complexity/README.md)
<!-- /study-navigation -->
