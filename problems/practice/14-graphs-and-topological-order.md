# 14 - Graphs, Traversals, and Topological Order

[Practice index](README.md) | Theory: [Graph Representations](../../data-structures/graphs/14-graph-representations.md) | [Graph Traversal and Topological Order](../../algorithms/graphs/14-traversal-and-topological-order.md)

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

</details>
