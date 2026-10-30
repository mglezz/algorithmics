# 18.02 - Minimum Coin Count

<!-- study-navigation -->
[← Previous: Exercise 18.01](../01_nonadjacent-selection-reconstruction/README.md) · [Index](../README.md) · [Next: Exercise 18.03 →](../03_zero-one-knapsack/README.md)
<!-- /study-navigation -->

[Practice index](../../README.md) | Theory: [Dynamic Programming from First Principles](../../../../01_algorithms/10_dynamic-programming/18-dynamic-programming.md)

**Status:** Not started. This is a repository-written practice prompt, not a recruiting question-bank item.

## Exercise

Implement `int minCoins(int[] coins, int amount)` for positive denominations, unlimited copies and `0<=amount<=100000`. Return the fewest coins, or -1 when impossible. Empty denominations can form only zero.

## Examples and checks

Coins `[1,3,4]`, amount 6 return 2; `[2]`, amount 3 returns -1; amount 0 returns 0.

## Your workspace

Write your Java 17 implementation and an executable test runner in `src/`. Use `AlgorithmXX_YY.java` and `MainXX_YY.java` with this exercise's numbers, or keep the existing class names. For data-structure exercises, use the requested class and a separate runner. Compare actual and expected results, including the cases above; throw `AssertionError` on a mismatch (or run Java assertions with `-ea`).

The deliverable is working Java code and checks. You may add a short explanation of the algorithm in `src/README.md`, like exercise 02.01; a formal proof or a separate theoretical answer is not required. Unless stated otherwise, inputs are non-null, indices and graph endpoints are valid, and auxiliary result types such as `Node` or `Selection` are yours to define.

<details><summary>Implementation hint</summary>

Try every denomination as the final coin in each reachable amount.

</details>

## Your solution

Keep your Java implementation and executable checks in `src/`. Optionally add a short algorithm explanation in `src/README.md`. Record the attempt in [PROGRESS.md](../../../../PROGRESS.md).

---

<!-- study-navigation -->
[← Previous: Exercise 18.01](../01_nonadjacent-selection-reconstruction/README.md) · [Index](../README.md) · [Next: Exercise 18.03 →](../03_zero-one-knapsack/README.md)
<!-- /study-navigation -->
