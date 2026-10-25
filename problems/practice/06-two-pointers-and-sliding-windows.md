# 06 - Two Pointers and Sliding Windows

[Practice index](README.md) | Theory: [Two Pointers and Sliding Windows](../../algorithms/two-pointers/06-two-pointers-and-sliding-windows.md)

**Status:** Suggested practice; no solution or completion is implied. These prompts and hints were written for this repository, not copied from a recruiting question bank.

## Your deliverable

Write a specification, your solution, a correctness argument, time/space analysis, and tests. Record independent attempts in [PROGRESS.md](../../PROGRESS.md).

## Exercises

1. Find the longest binary subarray after flipping at most `k` zeros, for `k>=0`.
2. Find the minimum window containing a target multiset of characters.
3. Count ranges containing exactly `k` distinct integers.
4. Construct a counterexample to a sum window when negatives are allowed.

<details><summary>Hints and checkpoints</summary>

1. Maintain zero count; shrink while it exceeds `k`.
2. Track required multiplicities and the number of satisfied requirements. Shrink only while all are met; clarify the empty-target result.
3. Subtract the two at-most counts; use long for the answer.
4. Explain the invalid elimination step, not just a wrong output.

</details>
