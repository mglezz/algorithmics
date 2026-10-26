# 14B - Graph Traversal and Topological Order

<!-- study-navigation -->
[← Previous: Unit 14A](../../02_data-structures/07_graphs/14-graph-representations.md) · [Index](../../README.md#study-index) · [Next: Unit 15 →](15-shortest-paths.md)
<!-- /study-navigation -->

[Curriculum](../../CURRICULUM.md) | [Quick reference](../../04_notes/graphs.md) | [Companion chapter](../../02_data-structures/07_graphs/14-graph-representations.md)

> **Core idea:** Separate the graph model from the traversal rule and its correctness invariant.

## On this page

- [Breadth-first search](#breadth-first-search)
- [Worked visual](#worked-visual)
- [Depth-first search and cycles](#depth-first-search-and-cycles)
- [DAGs and Kahn's algorithm](#dags-and-kahns-algorithm)
- [Case study: Service Startup Dependencies](#case-study-service-startup-dependencies)
- [Explain it in English](#explain-it-in-english)
- [Practice](#practice)
- [Attribution and references](#attribution-and-references)

## Breadth-first search

Initialize the source's distance to zero, enqueue it, and mark it discovered **when enqueued**. Repeatedly dequeue a vertex and discover its unseen neighbors with distance one greater. Marking only when dequeued can enqueue the same vertex many times.

The queue processes nondecreasing distance layers. If a vertex first appears at distance `d`, any shorter path would have reached it from an earlier layer already processed; contradiction. Thus BFS finds shortest paths by number of edges when every edge has the same nonnegative cost. With zero-cost edges, all reachable vertices have the same total cost; BFS still minimizes edge count. Equal negative costs do not justify BFS for minimum total cost. It is not a general weighted shortest-path algorithm.

Store a parent on first discovery to reconstruct one shortest path. Multi-source BFS starts all sources at distance zero and finds distance to the nearest source. A full adjacency-list traversal costs `O(V+E)` time and `O(V)` auxiliary space. To explore a disconnected graph, start another traversal from each still-unseen vertex.

## Worked visual

| Removed vertex | Newly ready vertices | Remaining unmet prerequisites of 3 |
|---|---|---|
| 0 | 1 and 2 | 2 |
| 1 | None | 1 |
| 2 | 3 | 0 |
| 3 | None | 0 |

## Depth-first search and cycles

DFS pursues one branch before returning. Use recursion or an explicit stack. Directed cycle detection needs three states: unseen, active on the current DFS path, and finished. An edge to an active vertex closes a directed cycle. An edge to a finished vertex does not by itself imply a cycle.

In an undirected graph, ignore the exact edge used to enter a vertex; an edge to another visited vertex indicates a cycle. For multigraphs, track parent **edge IDs**, because another parallel edge to the same parent is distinct. A single visited flag with a parent-vertex shortcut can miss this case.

DFS finishing order becomes useful for topological sorting, strongly connected components, and tree DP. An iterative stack that merely pops vertices does not automatically reproduce recursive postorder; retain child-iteration state or explicit enter/exit events.

## DAGs and Kahn's algorithm

A directed acyclic graph (DAG) admits a topological order in which every edge goes forward. Kahn's algorithm counts indegrees and repeatedly removes a zero-indegree vertex, decrementing the indegrees of its outgoing neighbors. Enqueue a neighbor when its remaining indegree becomes zero.

Invariant: each stored indegree counts incoming edges from **unprocessed** vertices. Therefore a dequeued vertex has no unmet prerequisites. Removing it preserves the invariant by decrementing exactly its outgoing edges.

Why failure detects a cycle: if unprocessed vertices remain but none has zero indegree, follow incoming edges within that finite remaining graph. Some vertex repeats, creating a cycle. Conversely, vertices in a directed cycle cannot become the first removed member of that cycle. Thus processing all vertices is equivalent to acyclicity.

Time is `O(V+E)` and auxiliary space including constructed adjacency is `O(V+E)`. A min-heap instead of a FIFO queue chooses the lexicographically smallest available vertex, adding `O(V log V)` heap work. A topological order is unique exactly when there is one available choice at every step of Kahn's process for the DAG.

## Case study: Service Startup Dependencies

Read [SimpleServiceAlgorithm.java](../../03_problems/01_serviceDependencies/src/SimpleServiceAlgorithm.java). A pair `{service, prerequisite}` creates edge `prerequisite -> service`, not the reverse. For the existing example:

```text
0 -> 1 -> 3
 \-> 2 --^

indegree: [0,1,1,2]
ready: [0]
process 0: indegree[1]=0, indegree[2]=0
process 1: indegree[3]=1
process 2: indegree[3]=0
process 3: all four vertices are output
```

Both orders with 1 and 2 exchanged are legal. Test output properties rather than one arbitrary sequence: result length is `n`, entries are unique and in range, and `position[prerequisite]<position[service]` for every pair.

Duplicate dependency pairs remain consistent in this implementation because it increments and decrements once per stored edge. A deduplicating variant must deduplicate both operations. A self-loop prevents that service from becoming ready. Isolated services must still appear. With `n=0`, an empty result is a valid order as well as the chosen failure sentinel; callers need the input size to interpret it.

The implementation assumes nonnegative `n`, well-formed pairs, and IDs in range. The verbose [ServiceAlgorithm.java](../../03_problems/01_serviceDependencies/src/ServiceAlgorithm.java) prints whole arrays and growing prefixes: debug output can print `Theta(V^2)` vertex entries over all prefixes (and additional characters for their labels), so its traced runtime is not simply the clean algorithm's linear bound.

## Explain it in English

> “Each indegree counts prerequisites that have not yet been processed.”

**Vocabulary:** directed edge, indegree, reachability, component, frontier, acyclic, topological order.

## Practice

Attempt the [unit 14 exercise set](../../03_problems/02_practice/14_graphs-and-topological-order/README.md). Exercises and hints live in `03_problems/`; this chapter contains the theory.

## Attribution and references

**Provenance:** This chapter is a synthesis of the sources mapped below. Standard definitions, algorithms and proof techniques belong to those established references; the explanatory wording, traces, diagrams and Java examples were written for this repository. No source passage is quoted verbatim.

| Section / claim | Source used | How it is used |
|---|---|---|
| BFS layers, DFS and topological ordering | [Demaine, Ku and Solomon, MIT 6.006 (Spring 2020)](https://ocw.mit.edu/courses/6-006-introduction-to-algorithms-spring-2020/pages/lecture-notes/) | Lectures 9-10; algorithms and correctness framework. |
| Service-dependency case study | This repository | Analysis of this repository's existing SimpleServiceAlgorithm.java; not an external example. |

See [SOURCES.md](../../SOURCES.md) for editions, review scope, and the distinction between consulted material and further reading.

---

<!-- study-navigation -->
[← Previous: Unit 14A](../../02_data-structures/07_graphs/14-graph-representations.md) · [Index](../../README.md#study-index) · [Next: Unit 15 →](15-shortest-paths.md)
<!-- /study-navigation -->
