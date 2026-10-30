# 24.03 - Convex Hull

<!-- study-navigation -->
[← Previous: Exercise 24.02](../02_vertex-cover-approximation/README.md) · [Index](../README.md) · [Next: Exercise 24.04 →](../04_persistent-range-sums/README.md)
<!-- /study-navigation -->

[Practice index](../../README.md) | Theory: [Computational Limits and Advanced Algorithm Design](../../../../01_algorithms/13_advanced/24-complexity-and-advanced-design.md)

**Status:** Not started. This is a repository-written practice prompt, not a recruiting question-bank item.

## Exercise

Implement `List<Point> convexHull(List<Point> points)` with int coordinates, deduplicating equal points. Return extreme hull vertices counterclockwise, starting at the lexicographically smallest point, without repeating the start. Remove interior collinear boundary points; all-collinear input returns only its endpoints.

## Examples and checks

A square with a center point and duplicates returns its four corners; test empty input, one point, a line and int-extreme coordinates.

## Your workspace

Write your Java 17 implementation and an executable test runner in `src/`. Use `AlgorithmXX_YY.java` and `MainXX_YY.java` with this exercise's numbers, or keep the existing class names. For data-structure exercises, use the requested class and a separate runner. Compare actual and expected results, including the cases above; throw `AssertionError` on a mismatch (or run Java assertions with `-ea`).

The deliverable is working Java code and checks. You may add a short explanation of the algorithm in `src/README.md`, like exercise 02.01; a formal proof or a separate theoretical answer is not required. Unless stated otherwise, inputs are non-null, indices and graph endpoints are valid, and auxiliary result types such as `Node` or `Selection` are yours to define.

<details><summary>Implementation hint</summary>

Use a monotone chain and exact orientation arithmetic; the helper below avoids determinant overflow.

### Java helper

Optional helper members for your class; add the necessary imports from java.util. Complete the public API and tests described above.

<!-- java-hint -->
```java
record Point(int x, int y) {}

static int orientation(Point a, Point b, Point c) {
    java.math.BigInteger abX = java.math.BigInteger.valueOf((long) b.x() - a.x());
    java.math.BigInteger abY = java.math.BigInteger.valueOf((long) b.y() - a.y());
    java.math.BigInteger acX = java.math.BigInteger.valueOf((long) c.x() - a.x());
    java.math.BigInteger acY = java.math.BigInteger.valueOf((long) c.y() - a.y());
    return abX.multiply(acY).subtract(abY.multiply(acX)).signum();
}
```
<!-- /java-hint -->

</details>

## Your solution

Keep your Java implementation and executable checks in `src/`. Optionally add a short algorithm explanation in `src/README.md`. Record the attempt in [PROGRESS.md](../../../../PROGRESS.md).

---

<!-- study-navigation -->
[← Previous: Exercise 24.02](../02_vertex-cover-approximation/README.md) · [Index](../README.md) · [Next: Exercise 24.04 →](../04_persistent-range-sums/README.md)
<!-- /study-navigation -->
