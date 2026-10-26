# 01 - Discrete Mathematics and Correctness

<!-- study-navigation -->
[← Previous: Practice sets](README.md) · [Index](README.md) · [Next: Unit 02 →](02-complexity-and-amortization.md)
<!-- /study-navigation -->

[Practice index](README.md) | Theory: [Discrete Mathematics and Correctness](../../01_algorithms/01_foundations/01-mathematics-and-correctness.md)

**Status:** Suggested practice; no solution or completion is implied. These prompts and hints were written for this repository, not copied from a recruiting question bank.

## Your deliverable

Write a specification, your solution, a correctness argument, time/space analysis, and tests. Record independent attempts in [PROGRESS.md](../../PROGRESS.md).

## Exercises

1. State a contract for removing duplicates from a sorted array in place. Specify the returned length and which portion of the array is meaningful.
2. Prove iterative array reversal using a statement about the processed ends and the untouched middle.
3. Give a counterexample to “a directed graph with at least one zero-indegree vertex has no cycle.”
4. Count subsequences by index of length `k`; explain why repeated values do not change that count but can change the number of distinct resulting sequences.

<details><summary>Hints and checkpoints</summary>

1. The prefix of returned length should contain each distinct value exactly once in sorted order; the suffix is unspecified.
2. Before each swap, positions outside `[left,right]` already hold their final reversed values. The middle shrinks by two.
3. Use an isolated vertex plus a separate directed two-cycle.
4. Choose `k` of `n` positions: `C(n,k)`. Equal values can collapse several position choices into one sequence.

### Java starting point

For exercise 2, isolate one swap before writing the two-pointer loop. Preconditions: both indices are valid. The missing part is the loop invariant and the stopping condition.

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

---

<!-- study-navigation -->
[← Previous: Practice sets](README.md) · [Index](README.md) · [Next: Unit 02 →](02-complexity-and-amortization.md)
<!-- /study-navigation -->
