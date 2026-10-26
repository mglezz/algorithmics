# 16.03 - Kruskal Spanning Tree

<!-- study-navigation -->
[← Previous: Exercise 16.02](../02_first-redundant-edge/README.md) · [Index](../README.md) · [Next: Exercise 16.04 →](../04_mst-versus-shortest-path-tree/README.md)
<!-- /study-navigation -->

[Practice index](../../README.md) | Theory: [Disjoint Sets](../../../../02_data-structures/08_disjoint-sets/16-disjoint-sets.md) | [Minimum Spanning Trees](../../../../01_algorithms/08_graphs/16-minimum-spanning-trees.md)

**Status:** Not started. This is a repository-written practice prompt, not a recruiting question-bank item.

## Exercise

Implement Kruskal and verify the output connects all vertices, has no cycle, and contains `V-1` edges when connected.

## Your workspace

Keep your implementation (for example, `Solution.java`) and your tests in this folder. For a proof, analysis, or counterexample task, write your answer in the solution section below; add code only when useful.

State the input/output contract, explain correctness, analyze time and space, and check boundary cases. Java helper fragments belong inside your own class with `import java.util.*;`.

<details><summary>Hints and checkpoints</summary>

Feasibility alone does not prove minimum weight; compare tiny graphs against exhaustive spanning-tree enumeration.

### Java starting point

For this exercise, separate safe weight comparison from the union decision. Use a long total and assume the selected weights fit in that total.

<!-- java-hint -->
```java
record Edge(int from, int to, long weight) {}

static void orderByWeight(List<Edge> edges) {
    edges.sort(Comparator.comparingLong(Edge::weight));
}
```
<!-- /java-hint -->

**Complete the reasoning:** Add an edge only when union joins two previously distinct components. Stop after V - 1 successful unions only if a spanning tree is possible.

</details>

## Your solution

Add your approach, correctness argument, complexity analysis, and test results after attempting the exercise. Record the attempt in [PROGRESS.md](../../../../PROGRESS.md).

---

<!-- study-navigation -->
[← Previous: Exercise 16.02](../02_first-redundant-edge/README.md) · [Index](../README.md) · [Next: Exercise 16.04 →](../04_mst-versus-shortest-path-tree/README.md)
<!-- /study-navigation -->
