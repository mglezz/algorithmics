# 15.01 - Dijkstra Counterexample

<!-- study-navigation -->
[← Previous: Exercise 14.04](../../14_graphs-and-topological-order/04_dag-task-completion-times/README.md) · [Index](../README.md) · [Next: Exercise 15.02 →](../02_shortest-path-reconstruction/README.md)
<!-- /study-navigation -->

[Practice index](../../README.md) | Theory: [Weighted Shortest Paths](../../../../01_algorithms/08_graphs/15-shortest-paths.md)

**Status:** Not started. This is a repository-written practice prompt, not a recruiting question-bank item.

## Exercise

Find a small negative-edge graph that defeats Dijkstra's settled-vertex rule.

## Your workspace

Keep your implementation (for example, `Solution.java`) and your tests in this folder. For a proof, analysis, or counterexample task, write your answer in the solution section below; add code only when useful.

State the input/output contract, explain correctness, analyze time and space, and check boundary cases. Java helper fragments belong inside your own class with `import java.util.*;`.

<details><summary>Hints and checkpoints</summary>

Try `s->a:1`, `s->b:3`, `b->a:-5`; a is settled too early.

</details>

## Your solution

Add your approach, correctness argument, complexity analysis, and test results after attempting the exercise. Record the attempt in [PROGRESS.md](../../../../PROGRESS.md).

---

<!-- study-navigation -->
[← Previous: Exercise 14.04](../../14_graphs-and-topological-order/04_dag-task-completion-times/README.md) · [Index](../README.md) · [Next: Exercise 15.02 →](../02_shortest-path-reconstruction/README.md)
<!-- /study-navigation -->
