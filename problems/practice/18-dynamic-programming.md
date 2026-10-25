# 18 - Dynamic Programming from First Principles

[Practice index](README.md) | Theory: [Dynamic Programming from First Principles](../../algorithms/dynamic-programming/18-dynamic-programming.md)

**Status:** Suggested practice; no solution or completion is implied. These prompts and hints were written for this repository, not copied from a recruiting question bank.

## Your deliverable

Write a specification, your solution, a correctness argument, time/space analysis, and tests. Record independent attempts in [PROGRESS.md](../../PROGRESS.md).

## Exercises

1. Reconstruct one optimal nonadjacent selection, including tie handling.
2. Solve minimum coin count and explain why greedy fails on `{1,3,4}` for amount six.
3. Implement 0/1 knapsack in two dimensions, then compress it and justify the update order.
4. Give a case where using zero as “uncomputed” causes redundant computation or wrong results.

<details><summary>Hints and checkpoints</summary>

1. Compare `F(i)` against the skip/take alternatives while walking backward.
2. DP considers all last coins; greedy fixes one without a valid exchange proof.
3. With one item of weight two, an ascending loop must not fill capacity four with that item twice.
4. Zero may be a legitimate optimal value or count; use a visited flag or an impossible sentinel.

</details>
