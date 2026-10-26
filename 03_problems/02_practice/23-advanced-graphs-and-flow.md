# 23 - Strong Connectivity, Tree Queries, Matching, and Flow

<!-- study-navigation -->
[← Previous: Unit 22](22-bits-number-theory-and-randomness.md) · [Index](README.md) · [Next: Unit 24 →](24-complexity-and-advanced-design.md)
<!-- /study-navigation -->

[Practice index](README.md) | Theory: [Strong Connectivity, Tree Queries, Matching, and Flow](../../01_algorithms/08_graphs/23-advanced-graphs-and-flow.md)

**Status:** Suggested practice; no solution or completion is implied. These prompts and hints were written for this repository, not copied from a recruiting question bank.

## Your deliverable

Write a specification, your solution, a correctness argument, time/space analysis, and tests. Record independent attempts in [PROGRESS.md](../../PROGRESS.md).

## Exercises

1. Compress SCCs and compute reachability-related summaries on the condensation DAG.
2. Find bridges in a graph containing parallel edges and disconnected components.
3. Answer tree-distance queries after one preprocessing pass.
4. Build a matching example requiring reassignment through a backward residual edge.
5. After computing max flow, output a cut certificate and verify equal values.

<details><summary>Hints and checkpoints</summary>

1. Deduplicate intercomponent edges when the subsequent computation treats them as unique.
2. Ignore only the exact parent edge, not all edges to the parent vertex.
3. LCA identifies the shared root-path prefix counted twice.
4. One left vertex can take either of two tasks while another can take only the first.
5. BFS residual positive-capacity edges from the source after termination.

### Java starting point

For exercise 2, store a shared edge ID on both adjacency entries of one undirected edge. Parallel edges must receive different IDs.

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

---

<!-- study-navigation -->
[← Previous: Unit 22](22-bits-number-theory-and-randomness.md) · [Index](README.md) · [Next: Unit 24 →](24-complexity-and-advanced-design.md)
<!-- /study-navigation -->
