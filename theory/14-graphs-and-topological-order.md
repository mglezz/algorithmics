# 14 - Graphs, Traversals, and Topological Order

[Curriculum](README.md) | Prerequisites: 08, 11

## Modeling comes before traversal

A graph has vertices and edges. Specify whether edges are directed, weighted, repeated, or self-loops. A path follows edge direction. Undirected connectivity, directed reachability, and strong connectivity are different questions.

Useful models include cells as vertices with legal moves as edges; words with one-edit transitions; tasks with prerequisite edges; and states such as `(position,remainingFuel)`. A state must retain all information determining future transitions. Marking only a location visited can be wrong if reaching it with different resources changes what is possible.

| Representation | Storage | Enumerate neighbors of v | Check one edge |
|---|---|---|---|
| Adjacency lists | `O(V+E)` | `O(outdegree(v))` | Linear in degree without an index |
| Adjacency matrix | `O(V^2)` | `O(V)` | `O(1)` |
| Edge list | `O(E)` plus vertex data | Usually scan all edges | Usually `O(E)` |

An undirected adjacency list stores each edge twice; asymptotic space remains `O(V+E)`. Implicit graphs generate neighbors on demand, so include the cost of generating and checking each neighbor.

## Breadth-first search

Initialize the source's distance to zero, enqueue it, and mark it discovered **when enqueued**. Repeatedly dequeue a vertex and discover its unseen neighbors with distance one greater. Marking only when dequeued can enqueue the same vertex many times.

The queue processes nondecreasing distance layers. If a vertex first appears at distance `d`, any shorter path would have reached it from an earlier layer already processed; contradiction. Thus BFS finds shortest paths by number of edges when every edge has equal cost. It is not a general weighted shortest-path algorithm.

Store a parent on first discovery to reconstruct one shortest path. Multi-source BFS starts all sources at distance zero and finds distance to the nearest source. A full adjacency-list traversal costs `O(V+E)` time and `O(V)` auxiliary space. To explore a disconnected graph, start another traversal from each still-unseen vertex.

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

Read [SimpleAlgorithm.java](../problems/serviceDependencies/SimpleAlgorithm.java). A pair `{service, prerequisite}` creates edge `prerequisite -> service`, not the reverse. For the existing example:

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

The implementation assumes nonnegative `n`, well-formed pairs, and IDs in range. The verbose [Algorithm.java](../problems/serviceDependencies/Algorithm.java) prints whole arrays and growing prefixes: debug output can add quadratic character volume in `V`, so its traced runtime is not simply the clean algorithm's linear bound.

## Practice

1. Reimplement Kahn's algorithm without looking at the existing solution.
2. Return a concrete directed cycle using DFS parent links.
3. Find nearest-source distances on a grid with obstacles.
4. Compute earliest task completion times in a DAG with task durations and unlimited parallel workers.

<details><summary>Hints and checkpoints</summary>

1. Include empty graphs, isolated vertices, repeated edges, self-loops, and a cycle in a disconnected component.
2. An edge to an active ancestor identifies the endpoints of a parent-chain cycle.
3. Enqueue all sources before beginning; unreachable cells retain a sentinel.
4. In topological order, completion is duration plus the maximum predecessor completion, or just duration with no prerequisites. This is not the same as scheduling with a fixed worker limit.

</details>

**Explain aloud:** “Each indegree counts prerequisites that have not yet been processed.” Vocabulary: directed edge, indegree, reachability, component, frontier, acyclic, topological order.

## Sources

- [Open Data Structures, Graphs](https://opendatastructures.org/ods-java/12_Graphs.html): representations and traversal.
- MIT 6.006: [BFS](https://ocw.mit.edu/courses/6-006-introduction-to-algorithms-spring-2020/resources/mit6_006s20_lec9/) and [DFS](https://ocw.mit.edu/courses/6-006-introduction-to-algorithms-spring-2020/resources/mit6_006s20_lec10/).
- [Erickson's algorithms materials](https://jeffe.cs.illinois.edu/teaching/algorithms/), chapters 5-6: graph search, cycles, and DAG reasoning.
