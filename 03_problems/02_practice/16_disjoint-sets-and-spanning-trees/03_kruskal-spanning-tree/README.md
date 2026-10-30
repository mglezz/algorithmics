# 16.03 - Kruskal Minimum Spanning Tree

<!-- study-navigation -->
[← Previous: Exercise 16.02](../02_first-redundant-edge/README.md) · [Index](../README.md) · [Next: Exercise 16.04 →](../04_mst-versus-shortest-path-tree/README.md)
<!-- /study-navigation -->

[Practice index](../../README.md) | Theory: [Disjoint Sets](../../../../02_data-structures/08_disjoint-sets/16-disjoint-sets.md) | [Minimum Spanning Trees](../../../../01_algorithms/08_graphs/16-minimum-spanning-trees.md)

**Status:** Not started. This is a repository-written practice prompt, not a recruiting question-bank item.

## Exercise

Implement `MstResult kruskal(int n, List<Edge> edges)` for n>=1 and undirected weighted edges. Define the result with a `boolean connected`, selected edges and their long total. When disconnected, return `connected=false` with an empty edge list and total zero; otherwise return the minimum spanning tree. Negative and parallel edges are allowed; ignore self-loops.

## Examples and checks

Triangle weights 2,2,3 has total 4 with two selected edges; a single vertex has total 0; test disconnected input and equal weights.

## Your workspace

Write your Java 17 implementation and an executable test runner in `src/`. Use `AlgorithmXX_YY.java` and `MainXX_YY.java` with this exercise's numbers, or keep the existing class names. For data-structure exercises, use the requested class and a separate runner. Compare actual and expected results, including the cases above; throw `AssertionError` on a mismatch (or run Java assertions with `-ea`).

The deliverable is working Java code and checks. You may add a short explanation of the algorithm in `src/README.md`, like exercise 02.01; a formal proof or a separate theoretical answer is not required. Unless stated otherwise, inputs are non-null, indices and graph endpoints are valid, and auxiliary result types such as `Node` or `Selection` are yours to define.

<details><summary>Implementation hint</summary>

Sort by weight and select only edges joining different disjoint-set components.

### Java helper

Optional helper members for your class; add the necessary imports from java.util. Complete the public API and tests described above.

<!-- java-hint -->
```java
record Edge(int from, int to, long weight) {}

static void orderByWeight(List<Edge> edges) {
    edges.sort(Comparator.comparingLong(Edge::weight));
}
```
<!-- /java-hint -->

</details>

## Your solution

Keep your Java implementation and executable checks in `src/`. Optionally add a short algorithm explanation in `src/README.md`. Record the attempt in [PROGRESS.md](../../../../PROGRESS.md).

---

<!-- study-navigation -->
[← Previous: Exercise 16.02](../02_first-redundant-edge/README.md) · [Index](../README.md) · [Next: Exercise 16.04 →](../04_mst-versus-shortest-path-tree/README.md)
<!-- /study-navigation -->
