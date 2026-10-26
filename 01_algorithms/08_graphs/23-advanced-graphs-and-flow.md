# 23 - Strong Connectivity, Tree Queries, Matching, and Flow

<!-- study-navigation -->
[← Previous: Unit 22](../12_mathematics/22-bits-number-theory-and-randomness.md) · [Index](../../README.md#study-index) · [Next: Unit 24 →](../13_advanced/24-complexity-and-advanced-design.md)
<!-- /study-navigation -->

[Curriculum](../../CURRICULUM.md) | [Quick reference](../../04_notes/graphs.md)

> **Core idea:** Expose graph structure or reduce the task to a model with a known correctness argument.

## On this page

- [Strongly connected components](#strongly-connected-components)
- [Worked visual](#worked-visual)
- [Bridges and articulation points](#bridges-and-articulation-points)
- [Lowest common ancestor and binary lifting](#lowest-common-ancestor-and-binary-lifting)
- [Bipartite matching as reassignment](#bipartite-matching-as-reassignment)
- [Flow networks and residual capacity](#flow-networks-and-residual-capacity)
- [Explain it in English](#explain-it-in-english)
- [Practice](#practice)
- [Attribution and references](#attribution-and-references)

## Strongly connected components

In a directed graph, vertices are strongly connected if each can reach the other. Maximal such classes are SCCs. Contract each SCC into one vertex: the resulting **condensation graph is a DAG**, since a directed cycle between components would make them mutually reachable and therefore one component.

Kosaraju's algorithm performs DFS on the original graph to collect finishing order, then processes vertices in decreasing finish order with DFS on the transposed graph. Each second-pass search discovers one SCC. The finish order prevents a search from leaking into a different still-unassigned component. Time and storage are `O(V+E)` with explicit transpose storage.

Tarjan's SCC algorithm uses discovery times, low-link values, and a stack of vertices not yet assigned to a component. For a DFS child, propagate its low-link value; for an edge to a vertex still on the SCC stack, use that vertex's discovery time. When `low[v]==discovery[v]`, pop through v to emit a component. “On the SCC stack” is not the same as “active recursive call”: substituting the wrong condition breaks the algorithm.

## Worked visual

```text
Original capacity: u --5--> v
Current flow:      u --3--> v

Residual options:
  u --2--> v    send up to 2 more units
  v --3--> u    cancel up to 3 units already sent

A backward residual edge represents revision, not new original capacity.
```

## Bridges and articulation points

In an undirected DFS, let `low[v]` be the earliest discovery time reachable from v's subtree through tree edges followed by at most one back edge. For tree edge `v->child`, it is a bridge iff `low[child]>discovery[v]`: the child subtree has no alternative route to v or an ancestor.

A nonroot v is an articulation point if some child satisfies `low[child]>=discovery[v]`. The equality case can return to v but cannot bypass removing v. A DFS root is an articulation point iff it has at least two DFS children. Use edge IDs to skip only the parent edge when parallel edges exist. Both algorithms take `O(V+E)` time.

## Lowest common ancestor and binary lifting

For a rooted tree, precompute `up[v][j]`, the `2^j`-th ancestor, from `up[v][j-1]` and that ancestor's table. Use a consistent root sentinel convention. Preprocessing takes `O(V log(V+1))` time and space.

To find LCA(u,v), first lift the deeper node to equal depth. If equal, that node is the answer. Otherwise, from large powers down, lift both when their proposed ancestors differ. Their parents now agree and give the LCA. Each query costs `O(log(V+1))`. Unweighted tree distance is `depth[u]+depth[v]-2*depth[lca]`; weighted distance uses root-distance sums.

An Euler tour records entry times so each rooted subtree forms one contiguous interval, enabling unit 21's range structures. A different Euler walk records vertices on returns too; minimum depth between first occurrences then yields an LCA reduction. Keep these two tour conventions distinct.

## Bipartite matching as reassignment

A bipartite graph partitions vertices into left and right groups, with edges only across groups. A matching uses no vertex twice. A path alternating unmatched and matched edges, starting and ending at unmatched vertices, increases matching size when its edge choices are flipped.

The augmenting-path theorem says a matching is maximum iff no augmenting path exists. To see why, compare it with a larger matching: their symmetric difference consists of alternating paths and cycles, and one path must contain more edges from the larger matching. Repeated DFS augmentations give a simple polynomial algorithm; Hopcroft-Karp batches shortest augmenting paths for the standard `O(E sqrt(V))` bound after handling isolated vertices, with linear input setup.

This is useful for assigning workers to tasks, pairing compatible items, and finding disjoint resource allocations. Greedily taking the first available match can block a larger matching; reassignment is essential.

## Flow networks and residual capacity

A flow network has directed edges with nonnegative capacities, a source s, and a distinct sink t. A feasible flow respects capacities and conserves incoming/outgoing flow at every other vertex. The value is net flow leaving s.

For an edge with capacity c and flow f, residual capacity is `c-f` forward and f backward. A backward residual edge means previous flow can be undone. Store paired residual edges with reverse indices, especially when the original graph also has an antiparallel edge.

```text
initialize zero flow
while there is a residual s-to-t path:
    delta = minimum residual capacity on the path
    subtract delta from each traversed residual edge on the path
    add delta to its paired reverse residual edge
    increase total flow by delta
```

If no augmenting path exists, take S as the vertices reachable from s in the residual graph. Every original edge from S to its complement is saturated, and every original edge from the complement into S carries zero flow. Otherwise a positive-capacity forward or reverse residual edge would leave S, contradicting its definition. The flow value equals the cut capacity. Since every flow is bounded by every cut, this proves both maximality and the max-flow/min-cut theorem.

Ford-Fulkerson is a method whose complexity depends on path choice and capacities. With integral capacities it increases value by at least one per augmentation; the conventional augmentation bound `O(E*flowValue)` is pseudopolynomial. This assumes an edge-linear path search on the relevant network and omits setup and the final unsuccessful search. Including graph setup and that search gives `O(V + E*(flowValue+1))` with reusable visitation bookkeeping. Arbitrary real capacities can cause nontermination for unsuitable path choices. Edmonds-Karp chooses shortest residual paths by BFS and runs in `O(VE^2)`; Dinic uses level graphs and blocking flows with a general `O(V^2 E)` bound. Specialized networks permit stronger bounds, but require their own assumptions.

To reduce bipartite matching to flow, connect source to left vertices, compatibility edges left-to-right, and right vertices to sink, all capacity one. Integral maximum flow corresponds to a matching. To impose vertex capacities, split a vertex into in/out copies joined by its capacity edge.

## Explain it in English

> “A reverse residual edge lets me revise an earlier allocation instead of being trapped by it.”

**Vocabulary:** condensation, low-link, articulation point, augmenting path, residual, capacity, conservation.

## Practice

Attempt the [unit 23 exercise set](../../03_problems/02_practice/23_advanced-graphs-and-flow/README.md). Exercises and hints live in `03_problems/`; this chapter contains the theory.

## Attribution and references

**Provenance:** This chapter is a synthesis of the sources mapped below. Standard definitions, algorithms and proof techniques belong to those established references; the explanatory wording, traces, diagrams and Java examples were written for this repository. No source passage is quoted verbatim.

| Section / claim | Source used | How it is used |
|---|---|---|
| DFS structure and SCCs | [Jeff Erickson, Algorithms and supplementary notes](https://jeffe.cs.illinois.edu/teaching/algorithms/) | Chapter 6, Depth-First Search. |
| Tree queries and connectivity | [Antti Laaksonen, Competitive Programmer's Handbook (2018 draft)](https://cses.fi/book/book.pdf) | Tree-query and graph-connectivity sections. |
| Matching and flow | [Jeff Erickson, Algorithms, chapter 10: Maximum Flows and Minimum Cuts](https://jeffe.cs.illinois.edu/teaching/algorithms/book/10-maxflow.pdf) | Residual networks and max-flow/min-cut; chapter 11 covers reductions. |

See [SOURCES.md](../../SOURCES.md) for editions, review scope, and the distinction between consulted material and further reading.

---

<!-- study-navigation -->
[← Previous: Unit 22](../12_mathematics/22-bits-number-theory-and-randomness.md) · [Index](../../README.md#study-index) · [Next: Unit 24 →](../13_advanced/24-complexity-and-advanced-design.md)
<!-- /study-navigation -->
