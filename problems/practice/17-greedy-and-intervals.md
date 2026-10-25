# 17 - Greedy Algorithms, Intervals, and Sweeps

[Practice index](README.md) | Theory: [Greedy Algorithms, Intervals, and Sweeps](../../algorithms/greedy/17-greedy-and-intervals.md)

**Status:** Suggested practice; no solution or completion is implied. These prompts and hints were written for this repository, not copied from a recruiting question bank.

## Your deliverable

Write a specification, your solution, a correctness argument, time/space analysis, and tests. Record independent attempts in [PROGRESS.md](../../PROGRESS.md).

## Exercises

1. Implement maximum-cardinality interval scheduling and return the selected interval IDs.
2. Return a concrete minimum-room assignment, not just its room count.
3. Compute union length and test equal endpoints, nested intervals, and repeated intervals.
4. Invent a greedy proposal for 0/1 knapsack and disprove it with a tiny input.

<details><summary>Hints and checkpoints</summary>

1. Stable identity tracking matters if sorting changes input order.
2. Heap entries need both end time and room ID; reuse the popped room.
3. Group same-coordinate events before advancing the sweep.
4. Ratio preference can select an item that blocks a more valuable combination of whole items.

</details>
