# Graphs: Quick Reference

[Quick-reference index](README.md) | [Curriculum](../CURRICULUM.md)

| Task / condition | Technique | Key invariant or restriction |
|---|---|---|
| Fewest edges / equal nonnegative costs | BFS | Mark on enqueue; process distance layers |
| Directed cycle | DFS colors | An edge to an active ancestor closes a cycle |
| Dependency order | Kahn or DFS topological sort | A full order exists exactly for a DAG |
| Weights 0 or 1 | 0-1 BFS | Zero improvements to front, one improvements to back |
| Weighted DAG | Topological relaxation | Predecessors are finalized before successors |
| Nonnegative weights | Dijkstra | Settle the smallest current distance; skip stale entries |
| General signed weights | Bellman-Ford | Extra relaxation detects a reachable negative cycle |
| All pairs, moderate V | Floyd-Warshall | Intermediate-vertex loop outermost; retain negative self-loops |
| Minimum total undirected connection cost | Kruskal / Prim | Cut/exchange proof; different from shortest paths |
| Incremental connectivity | DSU | Merge components; do not infer an actual graph path |
| Reassignable allocation | Matching / flow | Reverse residual edges allow earlier choices to be undone |

**Graph contract:** direction, weights, vertex IDs, parallel edges, self-loops, disconnected components, and state dimensions.

**Costs:** adjacency-list BFS/DFS is O(V+E). Dijkstra depends on indexed versus lazy heap storage. Bellman-Ford has O(VE) relaxation work plus initialization.

## Full explanations

- [Graph representations](../data-structures/graphs/14-graph-representations.md)
- [Traversal and dependencies](../algorithms/graphs/14-traversal-and-topological-order.md)
- [Shortest paths](../algorithms/graphs/15-shortest-paths.md)
- [MST](../algorithms/graphs/16-minimum-spanning-trees.md)
- [Advanced graph methods](../algorithms/graphs/23-advanced-graphs-and-flow.md)

These are summaries of the linked chapters. Their source attribution is in those chapters and [SOURCES.md](../SOURCES.md).
