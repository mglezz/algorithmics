# 18.03 - 0/1 Knapsack and Reconstruction

<!-- study-navigation -->
[← Previous: Exercise 18.02](../02_minimum-coin-count/README.md) · [Index](../README.md) · [Next: Exercise 18.04 →](../04_memoization-sentinels/README.md)
<!-- /study-navigation -->

[Practice index](../../README.md) | Theory: [Dynamic Programming from First Principles](../../../../01_algorithms/10_dynamic-programming/18-dynamic-programming.md)

**Status:** Not started. This is a repository-written practice prompt, not a recruiting question-bank item.

## Exercise

Implement a two-dimensional DP returning the optimal long value and selected item indices for 0/1 knapsack. Then implement `long maxValueCompressed(int[] weights, int[] values, int capacity)` using O(capacity) storage. Weights are positive, values nonnegative and capacity is at most 10000; compare both totals.

## Examples and checks

Weights `[2,3,4]`, values `[4,5,7]`, capacity 5 give value 9 with items 0 and 1; one weight-2 value-3 item at capacity 4 still gives 3.

## Your workspace

Write your Java 17 implementation and an executable test runner in `src/`. Use `AlgorithmXX_YY.java` and `MainXX_YY.java` with this exercise's numbers, or keep the existing class names. For data-structure exercises, use the requested class and a separate runner. Compare actual and expected results, including the cases above; throw `AssertionError` on a mismatch (or run Java assertions with `-ea`).

The deliverable is working Java code and checks. You may add a short explanation of the algorithm in `src/README.md`, like exercise 02.01; a formal proof or a separate theoretical answer is not required. Unless stated otherwise, inputs are non-null, indices and graph endpoints are valid, and auxiliary result types such as `Node` or `Selection` are yours to define.

<details><summary>Implementation hint</summary>

Reconstruct from the 2D table; scan capacities downward in the compressed version.

### Java helper

Optional helper members for your class; add the necessary imports from java.util. Complete the public API and tests described above.

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

</details>

## Your solution

Keep your Java implementation and executable checks in `src/`. Optionally add a short algorithm explanation in `src/README.md`. Record the attempt in [PROGRESS.md](../../../../PROGRESS.md).

---

<!-- study-navigation -->
[← Previous: Exercise 18.02](../02_minimum-coin-count/README.md) · [Index](../README.md) · [Next: Exercise 18.04 →](../04_memoization-sentinels/README.md)
<!-- /study-navigation -->
