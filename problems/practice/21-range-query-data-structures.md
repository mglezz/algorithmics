# 21 - Fenwick Trees, Segment Trees, and Sparse Tables

[Practice index](README.md) | Theory: [Fenwick Trees, Segment Trees, and Sparse Tables](../../data-structures/range-queries/21-range-query-data-structures.md)

**Status:** Suggested practice; no solution or completion is implied. These prompts and hints were written for this repository, not copied from a recruiting question bank.

## Your deliverable

Write a specification, your solution, a correctness argument, time/space analysis, and tests. Record independent attempts in [PROGRESS.md](../../PROGRESS.md).

## Exercises

1. Count inversions with compressed ranks and a Fenwick tree; compare with merge-sort counting.
2. Implement point updates and range minimum with a segment tree.
3. Implement range assignment plus range addition plus range sum with lazy tags.
4. Explain why a static sparse-table sum query cannot use two overlapping blocks.

<details><summary>Hints and checkpoints</summary>

1. Query strictly smaller/larger ranks as appropriate; duplicates are not inversions.
2. Empty ranges need an identity such as positive infinity for minimum.
3. Test assign zero, add, partial query, assign again, and overlapping updates against a plain array.
4. Shared elements would be added twice, while taking min twice changes nothing.

</details>
