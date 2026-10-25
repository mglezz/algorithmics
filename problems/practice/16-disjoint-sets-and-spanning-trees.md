# 16 - Disjoint Sets and Minimum Spanning Trees

[Practice index](README.md) | Theory: [Disjoint Sets](../../data-structures/disjoint-sets/16-disjoint-sets.md) | [Minimum Spanning Trees](../../algorithms/graphs/16-minimum-spanning-trees.md)

**Status:** Suggested practice; no solution or completion is implied. These prompts and hints were written for this repository, not copied from a recruiting question bank.

## Your deliverable

Write a specification, your solution, a correctness argument, time/space analysis, and tests. Record independent attempts in [PROGRESS.md](../../PROGRESS.md).

## Exercises

1. Count connected components while edges are added, decrementing only after a successful union.
2. Detect the first redundant undirected edge, including parallel-edge cases.
3. Implement Kruskal and verify the output connects all vertices, has no cycle, and contains `V-1` edges when connected.
4. Give an MST that is not a shortest-path tree from a specified source.

<details><summary>Hints and checkpoints</summary>

1. Begin with `n` components. Repeated unions must not decrement twice.
2. If endpoints already have the same representative, the edge is redundant for connectivity.
3. Feasibility alone does not prove minimum weight; compare tiny graphs against exhaustive spanning-tree enumeration.
4. Use triangle weights `sa=2`, `ab=2`, `sb=3`: the MST uses total four, but its route from s to b has length four instead of three.

</details>
