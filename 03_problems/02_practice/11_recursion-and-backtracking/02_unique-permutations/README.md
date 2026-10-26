# 11.02 - Unique Permutations

<!-- study-navigation -->
[← Previous: Exercise 11.01](../01_balanced-parentheses/README.md) · [Index](../README.md) · [Next: Exercise 11.03 →](../03_constraint-grid-search/README.md)
<!-- /study-navigation -->

[Practice index](../../README.md) | Theory: [Recursion, Backtracking, and Search Spaces](../../../../01_algorithms/07_backtracking/11-recursion-and-backtracking.md)

**Status:** Not started. This is a repository-written practice prompt, not a recruiting question-bank item.

## Exercise

Generate unique permutations of a multiset.

## Your workspace

Keep your implementation (for example, `Solution.java`) and your tests in this folder. For a proof, analysis, or counterexample task, write your answer in the solution section below; add code only when useful.

State the input/output contract, explain correctness, analyze time and space, and check boundary cases. Java helper fragments belong inside your own class with `import java.util.*;`.

<details><summary>Hints and checkpoints</summary>

Use frequency counts or a sorted array with a same-depth duplicate rule.

### Java starting point

For this exercise, sort the values first and track which positions are already used in the current permutation. This helper breaks symmetry between equal values.

<!-- java-hint -->
```java
static boolean skipCandidate(int[] sorted, boolean[] used, int index) {
    if (used[index]) return true;
    return index > 0 && sorted[index] == sorted[index - 1] && !used[index - 1];
}
```
<!-- /java-hint -->

**Complete the reasoning:** Add the choose, recurse and undo steps. Explain why the second equal value is allowed after the first equal value has already been used.

</details>

## Your solution

Add your approach, correctness argument, complexity analysis, and test results after attempting the exercise. Record the attempt in [PROGRESS.md](../../../../PROGRESS.md).

---

<!-- study-navigation -->
[← Previous: Exercise 11.01](../01_balanced-parentheses/README.md) · [Index](../README.md) · [Next: Exercise 11.03 →](../03_constraint-grid-search/README.md)
<!-- /study-navigation -->
