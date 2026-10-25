# 24 - Computational Limits and Advanced Algorithm Design

[Practice index](README.md) | Theory: [Computational Limits and Advanced Algorithm Design](../../algorithms/advanced/24-complexity-and-advanced-design.md)

**Status:** Suggested practice; no solution or completion is implied. These prompts and hints were written for this repository, not copied from a recruiting question bank.

## Your deliverable

Write a specification, your solution, a correctness argument, time/space analysis, and tests. Record independent attempts in [PROGRESS.md](../../PROGRESS.md).

## Exercises

1. Explain why a verifier for a Hamiltonian cycle is polynomial even though finding one is harder.
2. Prove the vertex-cover approximation and find a case where it is not optimal.
3. Test convex hull on duplicate, collinear, and extreme-coordinate points.
4. Design a persistent range-sum query with versioned point updates.
5. Decide which exactness guarantees can be relaxed in a stream-frequency problem.

<details><summary>Hints and checkpoints</summary>

1. Check vertex uniqueness, all required edges, and return to the start.
2. A single edge needs one cover vertex, while the algorithm picks two.
3. Define the output policy before checking expected hull vertices.
4. Each version retains a root; copy before changing any shared path node.
5. State additive/relative error, failure probability, update model, and query volume.

</details>
