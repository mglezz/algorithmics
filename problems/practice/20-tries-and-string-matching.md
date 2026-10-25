# 20 - Tries and String Matching

[Practice index](README.md) | Theory: [Tries](../../data-structures/tries/20-tries.md) | [String Matching](../../algorithms/strings/20-string-matching.md)

**Status:** Suggested practice; no solution or completion is implied. These prompts and hints were written for this repository, not copied from a recruiting question bank.

## Your deliverable

Write a specification, your solution, a correctness argument, time/space analysis, and tests. Record independent attempts in [PROGRESS.md](../../PROGRESS.md).

## Exercises

1. Extend KMP to return overlapping matches; test `aaa` inside `aaaaa`.
2. Implement a trie with exact lookup, prefix lookup, and deletion.
3. Find the shortest repeating period of a string from its prefix function.
4. Explain the tradeoff between KMP's deterministic guarantee and hash-based substring comparison.

<details><summary>Hints and checkpoints</summary>

1. The valid indices are zero, one, and two.
2. Deleting `car` must not delete `cart`; prefix existence does not imply word existence.
3. Candidate period is `n-pi[n-1]`; it tiles the nonempty string only if it divides n.
4. Hash equality needs collision handling; KMP compares actual symbols and reuses border structure.

</details>
