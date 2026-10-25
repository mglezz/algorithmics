# 07 - Linked Lists and Reference Manipulation

[Practice index](README.md) | Theory: [Linked Lists and Reference Manipulation](../../data-structures/linked-lists/07-linked-lists.md)

**Status:** Suggested practice; no solution or completion is implied. These prompts and hints were written for this repository, not copied from a recruiting question bank.

## Your deliverable

Write a specification, your solution, a correctness argument, time/space analysis, and tests. Record independent attempts in [PROGRESS.md](../../PROGRESS.md).

## Exercises

1. Reverse only a specified contiguous list segment.
2. Find the cycle entry and cycle length without modifying nodes.
3. Merge two sorted disjoint lists, preserving node identity.
4. Specify and implement an LRU cache; test repeated access, overwrite, eviction, and capacity zero.

<details><summary>Hints and checkpoints</summary>

1. Preserve the predecessor and successor of the segment; reconnect both ends.
2. After a meeting, walk once around the cycle to count its length; reset a pointer for the entry proof.
3. Attach the untouched remainder when either list ends.
4. Every unlink must update both adjacent links; every eviction must remove the map entry.

</details>
