# 02 - Complexity, Recurrences, and Amortization

<!-- study-navigation -->
[← Previous: Unit 01](01-mathematics-and-correctness.md) · [Index](README.md) · [Next: Unit 03 →](03-java-for-interviews.md)
<!-- /study-navigation -->

[Practice index](README.md) | Theory: [Complexity, Recurrences, and Amortization](../../01_algorithms/01_foundations/02-complexity-and-amortization.md)

**Status:** Suggested practice; no solution or completion is implied. These prompts and hints were written for this repository, not copied from a recruiting question bank.

## Your deliverable

Write a specification, your solution, a correctness argument, time/space analysis, and tests. Record independent attempts in [PROGRESS.md](../../PROGRESS.md).

## Exercises

1. Analyze a loop that repeatedly divides a positive integer by three.
2. Analyze all pairs of strings when each comparison can inspect `L` characters.
3. Prove linear total time for popping smaller entries from a monotonic stack.
4. Why is `O(nW)` knapsack called pseudopolynomial?

<details><summary>Hints and checkpoints</summary>

1. `Theta(log n)` iterations under unit-cost arithmetic.
2. `O(n^2 L)` worst case; equal long prefixes realize costly comparisons.
3. Charge each pop to the unique earlier push of that entry.
4. `W` may be exponential in the bit length used to represent it.

### Java starting point

For exercise 1, this instrumented loop counts the iterations for a positive input. Use the trace to derive a bound; timing measurements are not a proof.

<!-- java-hint -->
```java
static int divisionSteps(long value) {
    if (value <= 0) throw new IllegalArgumentException("Positive input required");
    int steps = 0;
    while (value > 0) {
        value /= 3;
        steps++;
    }
    return steps;
}
```
<!-- /java-hint -->

**Complete the reasoning:** Compare inputs 1, 2, 3, 8 and 9. Explain the floor in the exact logarithmic count.

</details>

---

<!-- study-navigation -->
[← Previous: Unit 01](01-mathematics-and-correctness.md) · [Index](README.md) · [Next: Unit 03 →](03-java-for-interviews.md)
<!-- /study-navigation -->
