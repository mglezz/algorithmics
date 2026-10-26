# 18.03 - Zero-One Knapsack

<!-- study-navigation -->
[← Previous: Exercise 18.02](../02_minimum-coin-count/README.md) · [Index](../README.md) · [Next: Exercise 18.04 →](../04_memoization-sentinels/README.md)
<!-- /study-navigation -->

[Practice index](../../README.md) | Theory: [Dynamic Programming from First Principles](../../../../01_algorithms/10_dynamic-programming/18-dynamic-programming.md)

**Status:** Not started. This is a repository-written practice prompt, not a recruiting question-bank item.

## Exercise

Implement 0/1 knapsack in two dimensions, then compress it and justify the update order.

## Your workspace

Keep your implementation (for example, `Solution.java`) and your tests in this folder. For a proof, analysis, or counterexample task, write your answer in the solution section below; add code only when useful.

State the input/output contract, explain correctness, analyze time and space, and check boundary cases. Java helper fragments belong inside your own class with `import java.util.*;`.

<details><summary>Hints and checkpoints</summary>

With one item of weight two, an ascending loop must not fill capacity four with that item twice.

### Java starting point

For this exercise, isolate the update for one 0/1 item. dp[c] stores the best value with capacity at most c; initially it is zero and the empty selection is allowed. Require positive weight and nonnegative value, and assume all value sums fit in long.

<!-- java-hint -->
```java
static void includeOnce(long[] dp, int weight, long value) {
    if (weight <= 0 || value < 0) throw new IllegalArgumentException();
    for (int capacity = dp.length - 1; capacity >= weight; capacity--) {
        dp[capacity] = Math.max(dp[capacity], dp[capacity - weight] + value);
    }
}
```
<!-- /java-hint -->

**Complete the reasoning:** Supply the item loop and reconstruction strategy. Find the smallest example where scanning capacities upward incorrectly reuses the same item.

</details>

## Your solution

Add your approach, correctness argument, complexity analysis, and test results after attempting the exercise. Record the attempt in [PROGRESS.md](../../../../PROGRESS.md).

---

<!-- study-navigation -->
[← Previous: Exercise 18.02](../02_minimum-coin-count/README.md) · [Index](../README.md) · [Next: Exercise 18.04 →](../04_memoization-sentinels/README.md)
<!-- /study-navigation -->
