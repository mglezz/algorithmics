# 11 - Recursion, Backtracking, and Search Spaces

<!-- study-navigation -->
[← Previous: Unit 10](10-sorting-and-selection.md) · [Index](README.md) · [Next: Unit 12 →](12-trees-and-ordered-maps.md)
<!-- /study-navigation -->

[Practice index](README.md) | Theory: [Recursion, Backtracking, and Search Spaces](../../01_algorithms/07_backtracking/11-recursion-and-backtracking.md)

**Status:** Suggested practice; no solution or completion is implied. These prompts and hints were written for this repository, not copied from a recruiting question bank.

## Your deliverable

Write a specification, your solution, a correctness argument, time/space analysis, and tests. Record independent attempts in [PROGRESS.md](../../PROGRESS.md).

## Exercises

1. Generate balanced parentheses for `n` pairs without generating all strings first.
2. Generate unique permutations of a multiset.
3. Solve a small constraint grid using “fewest legal choices first,” while keeping correctness separate from the heuristic.
4. Implement meet-in-the-middle subset sum and compare it against exhaustive search on small inputs.

<details><summary>Hints and checkpoints</summary>

1. A prefix needs `0<=closed<=opened<=n`. The number of outputs is the nth Catalan number, not `2^n`.
2. Use frequency counts or a sorted array with a same-depth duplicate rule.
3. Choice ordering can accelerate search but does not replace exploring all necessary branches.
4. Include the empty subset and negative values; use a type that holds sums.

### Java starting point

For exercise 2, sort the values first and track which positions are already used in the current permutation. This helper breaks symmetry between equal values.

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

---

<!-- study-navigation -->
[← Previous: Unit 10](10-sorting-and-selection.md) · [Index](README.md) · [Next: Unit 12 →](12-trees-and-ordered-maps.md)
<!-- /study-navigation -->
