# 09 - Binary Search and Monotone Decisions

[Practice index](README.md) | Theory: [Binary Search and Monotone Decisions](../../algorithms/searching/09-binary-search.md)

**Status:** Suggested practice; no solution or completion is implied. These prompts and hints were written for this repository, not copied from a recruiting question bank.

## Your deliverable

Write a specification, your solution, a correctness argument, time/space analysis, and tests. Record independent attempts in [PROGRESS.md](../../PROGRESS.md).

## Exercises

1. Implement upper bound and derive the occurrence count.
2. Find the integer square root of a nonnegative long without overflowing a square.
3. Minimize the largest contiguous group sum and prove feasibility monotonicity.
4. Construct an input on which duplicate values make rotated-array search ambiguous.

<details><summary>Hints and checkpoints</summary>

1. Change the predicate to `value>target`; test absent and repeated targets.
2. Compare `middle <= value/middle` for positive middle; handle zero separately and choose safe boundaries.
3. Separate the greedy correctness proof from the monotonicity proof.
4. Compare cases such as `[1,1,1,0,1]`; equal endpoints may force cautious shrinking.

</details>
