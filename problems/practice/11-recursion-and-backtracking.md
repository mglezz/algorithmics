# 11 - Recursion, Backtracking, and Search Spaces

[Practice index](README.md) | Theory: [Recursion, Backtracking, and Search Spaces](../../algorithms/backtracking/11-recursion-and-backtracking.md)

**Status:** Suggested practice; no solution or completion is implied. These prompts and hints were written for this repository, not copied from a recruiting question bank.

## Your deliverable

Write a specification, your solution, a correctness argument, time/space analysis, and tests. Record independent attempts in [PROGRESS.md](../../PROGRESS.md).

## Exercises

1. Generate balanced parentheses for `n` pairs without generating all strings first.
2. Generate unique permutations of a multiset.
3. Solve a small constraint grid using “fewest legal choices first,” while keeping correctness separate from the heuristic.
4. Implement meet-in-the-middle subset sum and compare it against exhaustive search on small inputs.

<details><summary>Hints and checkpoints</summary>

1. A prefix needs `0<=closed<=opened<=n`. The number of outputs is the nth Catalan number, not `2^n`.
2. Use frequency counts or a sorted array with a same-depth duplicate rule.
3. Choice ordering can accelerate search but does not replace exploring all necessary branches.
4. Include the empty subset and negative values; use a type that holds sums.

</details>
