# 23.02 - Bridges with Parallel Edges

<!-- study-navigation -->
[← Previous: Exercise 23.01](../01_scc-condensation/README.md) · [Index](../README.md) · [Next: Exercise 23.03 →](../03_tree-distance-queries/README.md)
<!-- /study-navigation -->

[Practice index](../../README.md) | Theory: [Strong Connectivity, Tree Queries, Matching, and Flow](../../../../01_algorithms/08_graphs/23-advanced-graphs-and-flow.md)

**Status:** Not started. This is a repository-written practice prompt, not a recruiting question-bank item.

## Exercise

Find bridges in a graph containing parallel edges and disconnected components.

## Your workspace

Keep your implementation (for example, `Solution.java`) and your tests in this folder. For a proof, analysis, or counterexample task, write your answer in the solution section below; add code only when useful.

State the input/output contract, explain correctness, analyze time and space, and check boundary cases. Java helper fragments belong inside your own class with `import java.util.*;`.

<details><summary>Hints and checkpoints</summary>

Ignore only the exact parent edge, not all edges to the parent vertex.

### Java starting point

For this exercise, store a shared edge ID on both adjacency entries of one undirected edge. Parallel edges must receive different IDs.

<!-- java-hint -->
```java
record Arc(int to, int edgeId) {}

static void addUndirected(List<List<Arc>> graph, int u, int v, int edgeId) {
    graph.get(u).add(new Arc(v, edgeId));
    graph.get(v).add(new Arc(u, edgeId));
}
```
<!-- /java-hint -->

**Complete the reasoning:** In DFS, skip only the incoming edge ID, not every edge to the parent vertex. Supply discovery times, low-link updates, and the strict bridge inequality.

</details>

## Your solution

Add your approach, correctness argument, complexity analysis, and test results after attempting the exercise. Record the attempt in [PROGRESS.md](../../../../PROGRESS.md).

---

<!-- study-navigation -->
[← Previous: Exercise 23.01](../01_scc-condensation/README.md) · [Index](../README.md) · [Next: Exercise 23.03 →](../03_tree-distance-queries/README.md)
<!-- /study-navigation -->
