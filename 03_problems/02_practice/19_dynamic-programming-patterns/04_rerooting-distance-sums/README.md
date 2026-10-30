# 19.04 - Tree Distance Sums

<!-- study-navigation -->
[← Previous: Exercise 19.03](../03_weighted-interval-scheduling/README.md) · [Index](../README.md) · [Next: Exercise 19.05 →](../05_digit-dp-without-equal-adjacent-digits/README.md)
<!-- /study-navigation -->

[Practice index](../../README.md) | Theory: [Dynamic Programming Patterns and Reconstruction](../../../../01_algorithms/10_dynamic-programming/19-dynamic-programming-patterns.md)

**Status:** Not started. This is a repository-written practice prompt, not a recruiting question-bank item.

## Exercise

Implement `long[] distanceSums(int n, int[][] edges)` for an unweighted undirected tree, returning for each vertex the sum of distances to all vertices. Use O(n) time with a subtree pass and a rerooting pass. Empty input with n=0 returns empty.

## Examples and checks

Chain `0-1-2` returns `[3,2,3]`; a single vertex returns `[0]`; compare a small star with BFS from each vertex.

## Your workspace

Write your Java 17 implementation and an executable test runner in `src/`. Use `AlgorithmXX_YY.java` and `MainXX_YY.java` with this exercise's numbers, or keep the existing class names. For data-structure exercises, use the requested class and a separate runner. Compare actual and expected results, including the cases above; throw `AssertionError` on a mismatch (or run Java assertions with `-ea`).

The deliverable is working Java code and checks. You may add a short explanation of the algorithm in `src/README.md`, like exercise 02.01; a formal proof or a separate theoretical answer is not required. Unless stated otherwise, inputs are non-null, indices and graph endpoints are valid, and auxiliary result types such as `Node` or `Selection` are yours to define.

<details><summary>Implementation hint</summary>

Compute subtree sizes and one root sum before propagating sums with the helper below.

### Java helper

Optional helper members for your class; add the necessary imports from java.util. Complete the public API and tests described above.

<!-- java-hint -->
```java
static long rerootDistanceSum(long parentSum, int vertexCount, int childSize) {
    return parentSum + (long) vertexCount - 2L * childSize;
}
```
<!-- /java-hint -->

</details>

## Your solution

Keep your Java implementation and executable checks in `src/`. Optionally add a short algorithm explanation in `src/README.md`. Record the attempt in [PROGRESS.md](../../../../PROGRESS.md).

---

<!-- study-navigation -->
[← Previous: Exercise 19.03](../03_weighted-interval-scheduling/README.md) · [Index](../README.md) · [Next: Exercise 19.05 →](../05_digit-dp-without-equal-adjacent-digits/README.md)
<!-- /study-navigation -->
