# 14.01 - Service Startup Order

<!-- study-navigation -->
[← Previous: Exercise 13.04](../../13_heaps-and-priority-queues/04_minimum-extraction-versus-predecessors/README.md) · [Index](../README.md) · [Next: Exercise 14.02 →](../02_directed-cycle-witness/README.md)
<!-- /study-navigation -->

[Practice index](../../README.md) | Theory: [Graph Representations](../../../../02_data-structures/07_graphs/14-graph-representations.md) | [Graph Traversal and Topological Order](../../../../01_algorithms/08_graphs/14-traversal-and-topological-order.md)

**Status:** Not started. This is a repository-written practice prompt, not a recruiting question-bank item.

## Exercise

Implement `int[] findStartupOrder(int n, int[][] dependencies)` using Kahn's algorithm. A pair `[service,prerequisite]` requires prerequisite first. Return all service IDs in any valid order, or an empty array on a cycle. Duplicate pairs must not change feasibility.

## Examples and checks

`n=4, [[1,0],[2,0],[3,1],[3,2]]` permits `[0,1,2,3]`; two mutual dependencies return empty; isolated services must appear.

## Your workspace

Write your Java 17 implementation and an executable test runner in `src/`. Use `AlgorithmXX_YY.java` and `MainXX_YY.java` with this exercise's numbers, or keep the existing class names. For data-structure exercises, use the requested class and a separate runner. Compare actual and expected results, including the cases above; throw `AssertionError` on a mismatch (or run Java assertions with `-ea`).

The deliverable is working Java code and checks. You may add a short explanation of the algorithm in `src/README.md`, like exercise 02.01; a formal proof or a separate theoretical answer is not required. Unless stated otherwise, inputs are non-null, indices and graph endpoints are valid, and auxiliary result types such as `Node` or `Selection` are yours to define.

<details><summary>Implementation hint</summary>

Keep indegrees consistent with the stored adjacency entries, including duplicates.

### Java helper

Optional helper members for your class; add the necessary imports from java.util. Complete the public API and tests described above.

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

</details>

## Your solution

Keep your Java implementation and executable checks in `src/`. Optionally add a short algorithm explanation in `src/README.md`. Record the attempt in [PROGRESS.md](../../../../PROGRESS.md).

---

<!-- study-navigation -->
[← Previous: Exercise 13.04](../../13_heaps-and-priority-queues/04_minimum-extraction-versus-predecessors/README.md) · [Index](../README.md) · [Next: Exercise 14.02 →](../02_directed-cycle-witness/README.md)
<!-- /study-navigation -->
