# 06 - Two Pointers and Sliding Windows

<!-- study-navigation -->
[← Previous: Unit 05](05-hash-tables.md) · [Index](README.md) · [Next: Unit 07 →](07-linked-lists.md)
<!-- /study-navigation -->

[Practice index](README.md) | Theory: [Two Pointers and Sliding Windows](../../01_algorithms/03_two-pointers/06-two-pointers-and-sliding-windows.md)

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

### Java starting point

For exercise 2, this small helper maintains a character deficit map: adding a character to the window uses delta = -1; removing it uses delta = +1. Restrict calls to characters in the target. Negative deficits represent surplus copies. This version uses UTF-16 code units.

<!-- java-hint -->
```java
static int adjustDeficit(Map<Character, Integer> deficit, char symbol, int delta) {
    int updated = deficit.getOrDefault(symbol, 0) + delta;
    deficit.put(symbol, updated);
    return updated;
}
```
<!-- /java-hint -->

**Complete the reasoning:** Maintain a separate missing-character count. Decide which transitions change it; a negative deficit must not count as a missing character.

</details>

---

<!-- study-navigation -->
[← Previous: Unit 05](05-hash-tables.md) · [Index](README.md) · [Next: Unit 07 →](07-linked-lists.md)
<!-- /study-navigation -->
