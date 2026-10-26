# 09.02 - Integer Square Root

<!-- study-navigation -->
[← Previous: Exercise 09.01](../01_upper-bound-and-occurrence-count/README.md) · [Index](../README.md) · [Next: Exercise 09.03 →](../03_minimizing-the-largest-group-sum/README.md)
<!-- /study-navigation -->

[Practice index](../../README.md) | Theory: [Binary Search and Monotone Decisions](../../../../01_algorithms/05_searching/09-binary-search.md)

**Status:** Not started. This is a repository-written practice prompt, not a recruiting question-bank item.

## Exercise

Find the integer square root of a nonnegative long without overflowing a square.

## Your workspace

Keep your implementation (for example, `Solution.java`) and your tests in this folder. For a proof, analysis, or counterexample task, write your answer in the solution section below; add code only when useful.

State the input/output contract, explain correctness, analyze time and space, and check boundary cases. Java helper fragments belong inside your own class with `import java.util.*;`.

<details><summary>Hints and checkpoints</summary>

Compare `middle <= value/middle` for positive middle; handle zero separately and choose safe boundaries.

### Java starting point

For this exercise, compare without evaluating candidate * candidate. The helper assumes value and candidate are nonnegative; the explicit zero case avoids division by zero.

<!-- java-hint -->
```java
static boolean squareAtMost(long candidate, long value) {
    if (candidate < 0 || value < 0) {
        throw new IllegalArgumentException("Nonnegative values required");
    }
    return candidate == 0 || candidate <= value / candidate;
}
```
<!-- /java-hint -->

**Complete the reasoning:** Choose safe search boundaries even for Long.MAX_VALUE. Do not compute value + 1 as a long upper bound in that case.

</details>

## Your solution

Add your approach, correctness argument, complexity analysis, and test results after attempting the exercise. Record the attempt in [PROGRESS.md](../../../../PROGRESS.md).

---

<!-- study-navigation -->
[← Previous: Exercise 09.01](../01_upper-bound-and-occurrence-count/README.md) · [Index](../README.md) · [Next: Exercise 09.03 →](../03_minimizing-the-largest-group-sum/README.md)
<!-- /study-navigation -->
