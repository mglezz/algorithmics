# 14.04 - DAG Task Completion Times

<!-- study-navigation -->
[← Previous: Exercise 14.03](../03_nearest-source-grid-distances/README.md) · [Index](../README.md) · [Next: Exercise 15.01 →](../../15_shortest-paths/01_dijkstra-counterexample/README.md)
<!-- /study-navigation -->

[Practice index](../../README.md) | Theory: [Graph Representations](../../../../02_data-structures/07_graphs/14-graph-representations.md) | [Graph Traversal and Topological Order](../../../../01_algorithms/08_graphs/14-traversal-and-topological-order.md)

**Status:** Not started. This is a repository-written practice prompt, not a recruiting question-bank item.

## Exercise

Compute earliest task completion times in a DAG with task durations and unlimited parallel workers.

## Your workspace

Keep your implementation (for example, `Solution.java`) and your tests in this folder. For a proof, analysis, or counterexample task, write your answer in the solution section below; add code only when useful.

State the input/output contract, explain correctness, analyze time and space, and check boundary cases. Java helper fragments belong inside your own class with `import java.util.*;`.

<details><summary>Hints and checkpoints</summary>

In topological order, completion is duration plus the maximum predecessor completion, or just duration with no prerequisites. This is not the same as scheduling with a fixed worker limit.

</details>

## Your solution

Add your approach, correctness argument, complexity analysis, and test results after attempting the exercise. Record the attempt in [PROGRESS.md](../../../../PROGRESS.md).

---

<!-- study-navigation -->
[← Previous: Exercise 14.03](../03_nearest-source-grid-distances/README.md) · [Index](../README.md) · [Next: Exercise 15.01 →](../../15_shortest-paths/01_dijkstra-counterexample/README.md)
<!-- /study-navigation -->
