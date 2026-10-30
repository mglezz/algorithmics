# 23.02 - Bridges with Parallel Edges

<!-- study-navigation -->
[← Previous: Exercise 23.01](../01_scc-condensation/README.md) · [Index](../README.md) · [Next: Exercise 23.03 →](../03_tree-distance-queries/README.md)
<!-- /study-navigation -->

[Practice index](../../README.md) | Theory: [Strong Connectivity, Tree Queries, Matching, and Flow](../../../../01_algorithms/08_graphs/23-advanced-graphs-and-flow.md)

**Status:** Not started. This is a repository-written practice prompt, not a recruiting question-bank item.

## Exercise

Implement `List<Integer> bridges(int n, int[][] edges)` returning sorted input edge indices whose removal increases the number of connected components. Treat edges as undirected; allow parallel edges and self-loops.

## Examples and checks

For `[[0,1],[0,1],[1,2]]`, only index 2 is a bridge. Test disconnected components and self-loops.

## Your workspace

Write your Java 17 implementation and an executable test runner in `src/`. Use `AlgorithmXX_YY.java` and `MainXX_YY.java` with this exercise's numbers, or keep the existing class names. For data-structure exercises, use the requested class and a separate runner. Compare actual and expected results, including the cases above; throw `AssertionError` on a mismatch (or run Java assertions with `-ea`).

The deliverable is working Java code and checks. You may add a short explanation of the algorithm in `src/README.md`, like exercise 02.01; a formal proof or a separate theoretical answer is not required. Unless stated otherwise, inputs are non-null, indices and graph endpoints are valid, and auxiliary result types such as `Node` or `Selection` are yours to define.

<details><summary>Implementation hint</summary>

Give each input edge a unique ID and skip only the incoming edge in DFS.

### Java helper

Optional helper members for your class; add the necessary imports from java.util. Complete the public API and tests described above.

<!-- java-hint -->
```java
record Arc(int to, int edgeId) {}

static void addUndirected(List<List<Arc>> graph, int u, int v, int edgeId) {
    graph.get(u).add(new Arc(v, edgeId));
    graph.get(v).add(new Arc(u, edgeId));
}
```
<!-- /java-hint -->

</details>

## Your solution

Keep your Java implementation and executable checks in `src/`. Optionally add a short algorithm explanation in `src/README.md`. Record the attempt in [PROGRESS.md](../../../../PROGRESS.md).

---

<!-- study-navigation -->
[← Previous: Exercise 23.01](../01_scc-condensation/README.md) · [Index](../README.md) · [Next: Exercise 23.03 →](../03_tree-distance-queries/README.md)
<!-- /study-navigation -->
