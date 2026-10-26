# 15.03 - One Free Edge

<!-- study-navigation -->
[← Previous: Exercise 15.02](../02_shortest-path-reconstruction/README.md) · [Index](../README.md) · [Next: Exercise 15.04 →](../04_negative-cycles-and-a-target/README.md)
<!-- /study-navigation -->

[Practice index](../../README.md) | Theory: [Weighted Shortest Paths](../../../../01_algorithms/08_graphs/15-shortest-paths.md)

**Status:** Not started. This is a repository-written practice prompt, not a recruiting question-bank item.

## Exercise

Find a shortest path when one edge may be traversed for free.

## Your workspace

Keep your implementation (for example, `Solution.java`) and your tests in this folder. For a proof, analysis, or counterexample task, write your answer in the solution section below; add code only when useful.

State the input/output contract, explain correctness, analyze time and space, and check boundary cases. Java helper fragments belong inside your own class with `import java.util.*;`.

<details><summary>Hints and checkpoints</summary>

Use states `(vertex,couponUsed)` and Dijkstra if original costs are nonnegative.

### Java starting point

For this exercise, a queue entry must distinguish whether the free edge has already been used. Assume nonnegative weights for Dijkstra; keep a distance for each (vertex, usedFreeEdge) state.

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

## Your solution

Add your approach, correctness argument, complexity analysis, and test results after attempting the exercise. Record the attempt in [PROGRESS.md](../../../../PROGRESS.md).

---

<!-- study-navigation -->
[← Previous: Exercise 15.02](../02_shortest-path-reconstruction/README.md) · [Index](../README.md) · [Next: Exercise 15.04 →](../04_negative-cycles-and-a-target/README.md)
<!-- /study-navigation -->
