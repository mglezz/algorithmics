# 04.02 - Range Increments

<!-- study-navigation -->
[← Previous: Exercise 04.01](../01_equilibrium-index/README.md) · [Index](../README.md) · [Next: Exercise 04.03 →](../03_rectangle-sums/README.md)
<!-- /study-navigation -->

[Practice index](../../README.md) | Theory: [Arrays and Strings](../../../../02_data-structures/01_arrays-and-strings/04-arrays-and-strings.md) | [Prefix Sums and Difference Arrays](../../../../01_algorithms/02_range-queries/04-prefix-sums-and-difference-arrays.md)

**Status:** Not started. This is a repository-written practice prompt, not a recruiting question-bank item.

## Exercise

Apply `q` inclusive range increments to an array; translate the contract into half-open events.

## Your workspace

Keep your implementation (for example, `Solution.java`) and your tests in this folder. For a proof, analysis, or counterexample task, write your answer in the solution section below; add code only when useful.

State the input/output contract, explain correctness, analyze time and space, and check boundary cases. Java helper fragments belong inside your own class with `import java.util.*;`.

<details><summary>Hints and checkpoints</summary>

Subtract at `right+1`; allocate a sentinel position beyond the last valid index.

### Java starting point

For this exercise, use a difference array of length n + 1, including a sentinel. This helper records a half-open update; reconstruct the values with a prefix scan yourself. Assume all accumulated values fit in long.

<!-- java-hint -->
```java
static void addRange(long[] difference, int left, int right, long delta) {
    int n = difference.length - 1;
    if (left < 0 || left > right || right > n) {
        throw new IllegalArgumentException("Invalid half-open range");
    }
    difference[left] += delta;
    difference[right] -= delta;
}
```
<!-- /java-hint -->

**Complete the reasoning:** Translate an inclusive [a, b] update into [a, b + 1). Check an empty update and an update ending at n.

</details>

## Your solution

Add your approach, correctness argument, complexity analysis, and test results after attempting the exercise. Record the attempt in [PROGRESS.md](../../../../PROGRESS.md).

---

<!-- study-navigation -->
[← Previous: Exercise 04.01](../01_equilibrium-index/README.md) · [Index](../README.md) · [Next: Exercise 04.03 →](../03_rectangle-sums/README.md)
<!-- /study-navigation -->
