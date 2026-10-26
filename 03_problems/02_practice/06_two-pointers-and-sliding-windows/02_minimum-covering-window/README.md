# 06.02 - Minimum Covering Window

<!-- study-navigation -->
[← Previous: Exercise 06.01](../01_flipping-zeros/README.md) · [Index](../README.md) · [Next: Exercise 06.03 →](../03_exactly-k-distinct-values/README.md)
<!-- /study-navigation -->

[Practice index](../../README.md) | Theory: [Two Pointers and Sliding Windows](../../../../01_algorithms/03_two-pointers/06-two-pointers-and-sliding-windows.md)

**Status:** Not started. This is a repository-written practice prompt, not a recruiting question-bank item.

## Exercise

Find the minimum window containing a target multiset of characters.

## Your workspace

Keep your implementation (for example, `Solution.java`) and your tests in this folder. For a proof, analysis, or counterexample task, write your answer in the solution section below; add code only when useful.

State the input/output contract, explain correctness, analyze time and space, and check boundary cases. Java helper fragments belong inside your own class with `import java.util.*;`.

<details><summary>Hints and checkpoints</summary>

Track required multiplicities and the number of satisfied requirements. Shrink only while all are met; clarify the empty-target result.

### Java starting point

For this exercise, this small helper maintains a character deficit map: adding a character to the window uses delta = -1; removing it uses delta = +1. Restrict calls to characters in the target. Negative deficits represent surplus copies. This version uses UTF-16 code units.

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

## Your solution

Add your approach, correctness argument, complexity analysis, and test results after attempting the exercise. Record the attempt in [PROGRESS.md](../../../../PROGRESS.md).

---

<!-- study-navigation -->
[← Previous: Exercise 06.01](../01_flipping-zeros/README.md) · [Index](../README.md) · [Next: Exercise 06.03 →](../03_exactly-k-distinct-values/README.md)
<!-- /study-navigation -->
