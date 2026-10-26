# 14.01 - Service Startup Order

<!-- study-navigation -->
[← Previous: Exercise 13.04](../../13_heaps-and-priority-queues/04_minimum-extraction-versus-predecessors/README.md) · [Index](../README.md) · [Next: Exercise 14.02 →](../02_directed-cycle-witness/README.md)
<!-- /study-navigation -->

[Practice index](../../README.md) | Theory: [Graph Representations](../../../../02_data-structures/07_graphs/14-graph-representations.md) | [Graph Traversal and Topological Order](../../../../01_algorithms/08_graphs/14-traversal-and-topological-order.md)

**Status:** Not started. This is a repository-written practice prompt, not a recruiting question-bank item.

## Exercise

Reimplement Kahn's algorithm without looking at the existing solution.

## Your workspace

Keep your implementation (for example, `Solution.java`) and your tests in this folder. For a proof, analysis, or counterexample task, write your answer in the solution section below; add code only when useful.

State the input/output contract, explain correctness, analyze time and space, and check boundary cases. Java helper fragments belong inside your own class with `import java.util.*;`.

<details><summary>Hints and checkpoints</summary>

Include empty graphs, isolated vertices, repeated edges, self-loops, and a cycle in a disconnected component.

### Java starting point

For this exercise, collect the initially ready vertices after computing indegrees. This is initialization only; add the loop that removes dependencies and detects incomplete processing.

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

## Your solution

Add your approach, correctness argument, complexity analysis, and test results after attempting the exercise. Record the attempt in [PROGRESS.md](../../../../PROGRESS.md).

---

<!-- study-navigation -->
[← Previous: Exercise 13.04](../../13_heaps-and-priority-queues/04_minimum-extraction-versus-predecessors/README.md) · [Index](../README.md) · [Next: Exercise 14.02 →](../02_directed-cycle-witness/README.md)
<!-- /study-navigation -->
