# 15 - Weighted Shortest Paths

<!-- study-navigation -->
[← Previous: Unit 14](14-graphs-and-topological-order.md) · [Index](README.md) · [Next: Unit 16 →](16-disjoint-sets-and-spanning-trees.md)
<!-- /study-navigation -->

[Practice index](README.md) | Theory: [Weighted Shortest Paths](../../01_algorithms/08_graphs/15-shortest-paths.md)

**Status:** Suggested practice; no solution or completion is implied. These prompts and hints were written for this repository, not copied from a recruiting question bank.

## Your deliverable

Write a specification, your solution, a correctness argument, time/space analysis, and tests. Record independent attempts in [PROGRESS.md](../../PROGRESS.md).

## Exercises

1. Find a small negative-edge graph that defeats Dijkstra's settled-vertex rule.
2. Return a path, not just its length, and define the unreachable result.
3. Find a shortest path when one edge may be traversed for free.
4. Decide whether a reachable negative cycle can affect a particular target.

<details><summary>Hints and checkpoints</summary>

1. Try `s->a:1`, `s->b:3`, `b->a:-5`; a is settled too early.
2. Follow parents backward only after proving the destination is reachable.
3. Use states `(vertex,couponUsed)` and Dijkstra if original costs are nonnegative.
4. Combine reachability from the source, a negative-cycle witness region, and reachability to the target.

### Java starting point

For exercise 3, a queue entry must distinguish whether the free edge has already been used. Assume nonnegative weights for Dijkstra; keep a distance for each (vertex, usedFreeEdge) state.

<!-- java-hint -->
```java
record Entry(long distance, int vertex, int usedFreeEdge) {}

static PriorityQueue<Entry> frontier() {
    return new PriorityQueue<>(Comparator.comparingLong(Entry::distance));
}

static boolean stale(Entry entry, long[][] distance) {
    return entry.distance() != distance[entry.vertex()][entry.usedFreeEdge()];
}
```
<!-- /java-hint -->

**Complete the reasoning:** Write the normal transition and the optional zero-cost transition. Why can a single visited flag per vertex discard a better answer?

</details>

---

<!-- study-navigation -->
[← Previous: Unit 14](14-graphs-and-topological-order.md) · [Index](README.md) · [Next: Unit 16 →](16-disjoint-sets-and-spanning-trees.md)
<!-- /study-navigation -->
