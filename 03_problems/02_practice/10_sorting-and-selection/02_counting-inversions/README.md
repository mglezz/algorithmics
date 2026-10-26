# 10.02 - Counting Inversions

<!-- study-navigation -->
[← Previous: Exercise 10.01](../01_stable-merge-sort/README.md) · [Index](../README.md) · [Next: Exercise 10.03 →](../03_three-way-partition/README.md)
<!-- /study-navigation -->

[Practice index](../../README.md) | Theory: [Sorting, Selection, and Divide and Conquer](../../../../01_algorithms/06_sorting/10-sorting-and-selection.md)

**Status:** Not started. This is a repository-written practice prompt, not a recruiting question-bank item.

## Exercise

Count inversions with duplicate values; define an inversion as strictly greater.

## Your workspace

Keep your implementation (for example, `Solution.java`) and your tests in this folder. For a proof, analysis, or counterexample task, write your answer in the solution section below; add code only when useful.

State the input/output contract, explain correctness, analyze time and space, and check boundary cases. Java helper fragments belong inside your own class with `import java.util.*;`.

<details><summary>Hints and checkpoints</summary>

Equal values do not contribute inversions; choose left first on equality.

### Java starting point

For this exercise, this helper accounts for the inversions created when the next right-half value is strictly less than the next left-half value. Both halves must already be sorted; leftEnd is exclusive.

<!-- java-hint -->
```java
static long crossInversionsWhenTakingRight(int leftIndex, int leftEnd) {
    return (long) leftEnd - leftIndex;
}
```
<!-- /java-hint -->

**Complete the reasoning:** Supply the merge and call this only when rightValue < leftValue. Equality contributes no inversion; choose the left element first to preserve stability.

</details>

## Your solution

Add your approach, correctness argument, complexity analysis, and test results after attempting the exercise. Record the attempt in [PROGRESS.md](../../../../PROGRESS.md).

---

<!-- study-navigation -->
[← Previous: Exercise 10.01](../01_stable-merge-sort/README.md) · [Index](../README.md) · [Next: Exercise 10.03 →](../03_three-way-partition/README.md)
<!-- /study-navigation -->
