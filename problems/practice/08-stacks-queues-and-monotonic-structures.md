# 08 - Stacks, Queues, and Monotonic Structures

[Practice index](README.md) | Theory: [Stacks and Queues](../../data-structures/stacks-and-queues/08-stacks-and-queues.md) | [Monotonic Stacks and Deques](../../algorithms/monotonic-structures/08-monotonic-stacks-and-deques.md)

**Status:** Suggested practice; no solution or completion is implied. These prompts and hints were written for this repository, not copied from a recruiting question bank.

## Your deliverable

Write a specification, your solution, a correctness argument, time/space analysis, and tests. Record independent attempts in [PROGRESS.md](../../PROGRESS.md).

## Exercises

1. Compute daily waiting times for a strictly warmer temperature.
2. Return each length-`k` sliding maximum and compare with brute-force scanning.
3. Implement a queue from two stacks and count all item transfers over a long operation sequence.
4. Solve the histogram rectangle problem with repeated heights and zero-height separators.

<details><summary>Hints and checkpoints</summary>

1. Use unresolved indices; equal temperatures do not resolve each other.
2. Test `k=1`, `k=n`, increasing, decreasing, and all-equal arrays.
3. A transfer is charged to the earlier enqueue of that same item.
4. Test `[2,2]`, `[2,0,2]`, and an increasing sequence that only resolves during the flush.

</details>
