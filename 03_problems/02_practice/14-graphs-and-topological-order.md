# 14 - Graphs, Traversals, and Topological Order

<!-- study-navigation -->
[← Previous: Unit 13](13-heaps-and-priority-queues.md) · [Index](README.md) · [Next: Unit 15 →](15-shortest-paths.md)
<!-- /study-navigation -->

[Practice index](README.md) | Theory: [Graph Representations](../../02_data-structures/07_graphs/14-graph-representations.md) | [Graph Traversal and Topological Order](../../01_algorithms/08_graphs/14-traversal-and-topological-order.md)

**Status:** Suggested practice; no solution or completion is implied. These prompts and hints were written for this repository, not copied from a recruiting question bank.

## Your deliverable

Write a specification, your solution, a correctness argument, time/space analysis, and tests. Record independent attempts in [PROGRESS.md](../../PROGRESS.md).

## Exercises

1. Reimplement Kahn's algorithm without looking at the existing solution.
2. Return a concrete directed cycle using DFS parent links.
3. Find nearest-source distances on a grid with obstacles.
4. Compute earliest task completion times in a DAG with task durations and unlimited parallel workers.

<details><summary>Hints and checkpoints</summary>

1. Include empty graphs, isolated vertices, repeated edges, self-loops, and a cycle in a disconnected component.
2. An edge to an active ancestor identifies the endpoints of a parent-chain cycle.
3. Enqueue all sources before beginning; unreachable cells retain a sentinel.
4. In topological order, completion is duration plus the maximum predecessor completion, or just duration with no prerequisites. This is not the same as scheduling with a fixed worker limit.

### Java starting point

For exercise 1, collect the initially ready vertices after computing indegrees. This is initialization only; add the loop that removes dependencies and detects incomplete processing.

<!-- java-hint -->
```java
static Deque<Integer> initiallyReady(int[] indegree) {
    Deque<Integer> ready = new ArrayDeque<>();
    for (int vertex = 0; vertex < indegree.length; vertex++) {
        if (indegree[vertex] == 0) ready.addLast(vertex);
    }
    return ready;
}
```
<!-- /java-hint -->

**Complete the reasoning:** For a dependency pair [service, prerequisite], which vertex receives the incoming edge? Decide whether duplicate input pairs represent one constraint or repeated edges.

</details>

---

<!-- study-navigation -->
[← Previous: Unit 13](13-heaps-and-priority-queues.md) · [Index](README.md) · [Next: Unit 15 →](15-shortest-paths.md)
<!-- /study-navigation -->
