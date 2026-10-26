# 14A - Graph Representations

<!-- study-navigation -->
[← Previous: Unit 13](../06_heaps/13-heaps-and-priority-queues.md) · [Index](../../README.md#study-index) · [Next: Unit 14B →](../../01_algorithms/08_graphs/14-traversal-and-topological-order.md)
<!-- /study-navigation -->

[Curriculum](../../CURRICULUM.md) | [Quick reference](../../04_notes/graphs.md) | [Companion chapter](../../01_algorithms/08_graphs/14-traversal-and-topological-order.md)

> **Core idea:** Define vertices, edges and legal transitions before selecting a graph algorithm.

## On this page

- [Modeling comes before traversal](#modeling-comes-before-traversal)
- [Worked visual](#worked-visual)
- [Model checklist](#model-checklist)
- [Practice](#practice)
- [Attribution and references](#attribution-and-references)

## Modeling comes before traversal

A graph has vertices and edges. Specify whether edges are directed, weighted, repeated, or self-loops. A path follows edge direction. Undirected connectivity, directed reachability, and strong connectivity are different questions.

Useful models include cells as vertices with legal moves as edges; words with one-edit transitions; tasks with prerequisite edges; and states such as `(position,remainingFuel)`. A state must retain all information determining future transitions. Marking only a location visited can be wrong if reaching it with different resources changes what is possible.

| Representation | Storage | Enumerate neighbors of v | Check one edge |
|---|---|---|---|
| Adjacency lists | `O(V+E)` | `O(outdegree(v))` | Linear in degree without an index |
| Adjacency matrix | `O(V^2)` | `O(V)` | `O(1)` |
| Edge list | `O(E)` plus vertex data | Usually scan all edges | Usually `O(E)` |

An undirected adjacency list stores each edge twice; asymptotic space remains `O(V+E)`. Implicit graphs generate neighbors on demand, so include the cost of generating and checking each neighbor.

## Worked visual

```text
Edges: 0 -> 1, 0 -> 2, 1 -> 2

Adjacency lists          Adjacency matrix
0: [1, 2]                   0  1  2
1: [2]                   0  0  1  1
2: []                    1  0  0  1
                         2  0  0  0

Rows are sources; columns are destinations.
```

## Model checklist

| Question | Why it changes the model |
|---|---|
| Directed or undirected? | Decides which reverse moves exist |
| Weighted or unweighted? | Decides whether BFS can optimize the required distance |
| Simple graph or multigraph? | Parallel edges affect indegrees and parent-edge handling |
| Explicit or implicit states? | Neighbor generation can dominate traversal time |
| Which resources belong in a vertex? | Location alone may not identify equivalent futures |

## Practice

Attempt the [unit 14 exercise set](../../03_problems/02_practice/14-graphs-and-topological-order.md). Exercises and hints live in `03_problems/`; this chapter contains the theory.

## Attribution and references

**Provenance:** This chapter is a synthesis of the sources mapped below. Standard definitions, algorithms and proof techniques belong to those established references; the explanatory wording, traces, diagrams and Java examples were written for this repository. No source passage is quoted verbatim.

| Section / claim | Source used | How it is used |
|---|---|---|
| Graph representation and traversal | [Pat Morin, Open Data Structures, chapter 12](https://opendatastructures.org/ods-java/12_Graphs.html) | Adjacency representations and BFS/DFS. |

See [SOURCES.md](../../SOURCES.md) for editions, review scope, and the distinction between consulted material and further reading.

---

<!-- study-navigation -->
[← Previous: Unit 13](../06_heaps/13-heaps-and-priority-queues.md) · [Index](../../README.md#study-index) · [Next: Unit 14B →](../../01_algorithms/08_graphs/14-traversal-and-topological-order.md)
<!-- /study-navigation -->
