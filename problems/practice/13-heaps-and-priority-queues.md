# 13 - Heaps and Priority Queues

[Practice index](README.md) | Theory: [Heaps and Priority Queues](../../data-structures/heaps/13-heaps-and-priority-queues.md)

**Status:** Suggested practice; no solution or completion is implied. These prompts and hints were written for this repository, not copied from a recruiting question bank.

## Your deliverable

Write a specification, your solution, a correctness argument, time/space analysis, and tests. Record independent attempts in [PROGRESS.md](../../PROGRESS.md).

## Exercises

1. Implement sift-down and prove that only the chosen child path can remain invalid.
2. Merge sorted linked lists without losing the successor before rewiring.
3. Maintain a running median and compare every prefix with a sorted copy.
4. Choose a structure for frequent minimum extraction versus predecessor queries.

<details><summary>Hints and checkpoints</summary>

1. Exchange with the smaller child, not an arbitrary child.
2. Save the removed node's next reference and enqueue it before changing links.
3. Include negative extremes, equal values, and alternating very small/large values.
4. A heap supports the minimum well; an ordered tree supports ordered navigation.

</details>
