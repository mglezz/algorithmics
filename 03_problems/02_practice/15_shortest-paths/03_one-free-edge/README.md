# 15.03 - One Free Edge

<!-- study-navigation -->
[← Previous: Exercise 15.02](../02_shortest-path-reconstruction/README.md) · [Index](../README.md) · [Next: Exercise 15.04 →](../04_negative-cycles-and-a-target/README.md)
<!-- /study-navigation -->

[Practice index](../../README.md) | Theory: [Weighted Shortest Paths](../../../../01_algorithms/08_graphs/15-shortest-paths.md)

**Status:** Not started. This is a repository-written practice prompt, not a recruiting question-bank item.

## Exercise

Implement `long cheapestWithFreeEdge(int n, int[][] edges, int source, int target)` for directed nonnegative weighted edges. You may traverse at most one edge at zero cost. Return -1 when unreachable and zero for source=target.

## Examples and checks

`[[0,1,5],[1,2,7]]` from 0 to 2 returns `5`; check zero-weight edges and a disconnected target.

## Your workspace

Write your Java 17 implementation and an executable test runner in `src/`. Use `AlgorithmXX_YY.java` and `MainXX_YY.java` with this exercise's numbers, or keep the existing class names. For data-structure exercises, use the requested class and a separate runner. Compare actual and expected results, including the cases above; throw `AssertionError` on a mismatch (or run Java assertions with `-ea`).

The deliverable is working Java code and checks. You may add a short explanation of the algorithm in `src/README.md`, like exercise 02.01; a formal proof or a separate theoretical answer is not required. Unless stated otherwise, inputs are non-null, indices and graph endpoints are valid, and auxiliary result types such as `Node` or `Selection` are yours to define.

<details><summary>Implementation hint</summary>

Use separate distances for states with and without the free traversal already used.

### Java helper

Optional helper members for your class; add the necessary imports from java.util. Complete the public API and tests described above.

<!-- java-hint -->
```java
record Entry(long distance, int vertex, int usedFreeEdge) {}

static PriorityQueue<Entry> frontier() {
    return new PriorityQueue<>(Comparator.comparingLong(Entry::distance));
}

static boolean stale(Entry entry, long[][] distance) {
    return entry.distance() != distance[entry.vertex()][entry.usedFreeEdge()];
}
```
<!-- /java-hint -->

</details>

## Your solution

Keep your Java implementation and executable checks in `src/`. Optionally add a short algorithm explanation in `src/README.md`. Record the attempt in [PROGRESS.md](../../../../PROGRESS.md).

---

<!-- study-navigation -->
[← Previous: Exercise 15.02](../02_shortest-path-reconstruction/README.md) · [Index](../README.md) · [Next: Exercise 15.04 →](../04_negative-cycles-and-a-target/README.md)
<!-- /study-navigation -->
