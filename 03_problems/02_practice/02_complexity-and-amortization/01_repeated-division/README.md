# 02.01 - Repeated Division

<!-- study-navigation -->
[← Previous: Exercise 01.04](../../01_mathematics-and-correctness/04_counting-subsequences/README.md) · [Index](../README.md) · [Next: Exercise 02.02 →](../02_pairwise-string-comparison/README.md)
<!-- /study-navigation -->

[Practice index](../../README.md) | Theory: [Complexity, Recurrences, and Amortization](../../../../01_algorithms/01_foundations/02-complexity-and-amortization.md)

**Status:** Not started. This is a repository-written practice prompt, not a recruiting question-bank item.

## Exercise

Analyze a loop that repeatedly divides a positive integer by three.

## Your workspace

Keep your implementation (for example, `Solution.java`) and your tests in this folder. For a proof, analysis, or counterexample task, write your answer in the solution section below; add code only when useful.

State the input/output contract, explain correctness, analyze time and space, and check boundary cases. Java helper fragments belong inside your own class with `import java.util.*;`.

<details><summary>Hints and checkpoints</summary>

`Theta(log n)` iterations under unit-cost arithmetic.

### Java starting point

For this exercise, this instrumented loop counts the iterations for a positive input. Use the trace to derive a bound; timing measurements are not a proof.

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

## Your solution

Add your approach, correctness argument, complexity analysis, and test results after attempting the exercise. Record the attempt in [PROGRESS.md](../../../../PROGRESS.md).

---

<!-- study-navigation -->
[← Previous: Exercise 01.04](../../01_mathematics-and-correctness/04_counting-subsequences/README.md) · [Index](../README.md) · [Next: Exercise 02.02 →](../02_pairwise-string-comparison/README.md)
<!-- /study-navigation -->
