# 01.02 - Array Reversal Invariant

<!-- study-navigation -->
[← Previous: Exercise 01.01](../01_sorted-array-deduplication/README.md) · [Index](../README.md) · [Next: Exercise 01.03 →](../03_zero-indegree-counterexample/README.md)
<!-- /study-navigation -->

[Practice index](../../README.md) | Theory: [Discrete Mathematics and Correctness](../../../../01_algorithms/01_foundations/01-mathematics-and-correctness.md)

**Status:** Not started. This is a repository-written practice prompt, not a recruiting question-bank item.

## Exercise

Prove iterative array reversal using a statement about the processed ends and the untouched middle.

## Your workspace

Keep your implementation (for example, `Solution.java`) and your tests in this folder. For a proof, analysis, or counterexample task, write your answer in the solution section below; add code only when useful.

State the input/output contract, explain correctness, analyze time and space, and check boundary cases. Java helper fragments belong inside your own class with `import java.util.*;`.

<details><summary>Hints and checkpoints</summary>

Before each swap, positions outside `[left,right]` already hold their final reversed values. The middle shrinks by two.

### Java starting point

For this exercise, isolate one swap before writing the two-pointer loop. Preconditions: both indices are valid. The missing part is the loop invariant and the stopping condition.

<!-- java-hint -->
```java
static void swap(int[] values, int left, int right) {
    int saved = values[left];
    values[left] = values[right];
    values[right] = saved;
}
```
<!-- /java-hint -->

**Complete the reasoning:** Trace an odd-length array. Why does leaving the middle element untouched preserve the result?

</details>

## Your solution

Add your approach, correctness argument, complexity analysis, and test results after attempting the exercise. Record the attempt in [PROGRESS.md](../../../../PROGRESS.md).

---

<!-- study-navigation -->
[← Previous: Exercise 01.01](../01_sorted-array-deduplication/README.md) · [Index](../README.md) · [Next: Exercise 01.03 →](../03_zero-indegree-counterexample/README.md)
<!-- /study-navigation -->
