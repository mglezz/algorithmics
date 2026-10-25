# 05 - Hash Tables, Sets, and Canonical Keys

[Practice index](README.md) | Theory: [Hash Tables, Sets, and Canonical Keys](../../data-structures/hash-tables/05-hash-tables.md)

**Status:** Suggested practice; no solution or completion is implied. These prompts and hints were written for this repository, not copied from a recruiting question bank.

## Your deliverable

Write a specification, your solution, a correctness argument, time/space analysis, and tests. Record independent attempts in [PROGRESS.md](../../PROGRESS.md).

## Exercises

1. Adapt the prefix method to find the longest target-sum range rather than count all ranges.
2. Group anagrams without a collision-prone serialization.
3. Find a repeated value within distance `k`, keeping only relevant prior indices.
4. Explain why two distinct strings with the same hash must not be treated as equal.

<details><summary>Hints and checkpoints</summary>

1. Store the earliest index of each prefix, not its frequency; do not overwrite that earliest index.
2. Use an immutable content-based key, or sort the word into a canonical string.
3. A sliding set or a last-seen index map works; define whether distance exactly `k` is allowed.
4. Hashes compress the key space; collisions follow from the pigeonhole principle when the key universe is larger.

</details>
