# 19.04 - Rerooting Distance Sums

<!-- study-navigation -->
[← Previous: Exercise 19.03](../03_weighted-interval-scheduling/README.md) · [Index](../README.md) · [Next: Exercise 19.05 →](../05_digit-dp-without-equal-adjacent-digits/README.md)
<!-- /study-navigation -->

[Practice index](../../README.md) | Theory: [Dynamic Programming Patterns and Reconstruction](../../../../01_algorithms/10_dynamic-programming/19-dynamic-programming-patterns.md)

**Status:** Not started. This is a repository-written practice prompt, not a recruiting question-bank item.

## Exercise

Derive the reroot distance formula by partitioning vertices into two groups.

## Your workspace

Keep your implementation (for example, `Solution.java`) and your tests in this folder. For a proof, analysis, or counterexample task, write your answer in the solution section below; add code only when useful.

State the input/output contract, explain correctness, analyze time and space, and check boundary cases. Java helper fragments belong inside your own class with `import java.util.*;`.

<details><summary>Hints and checkpoints</summary>

Exactly `size[c]` distances decrease; the other `V-size[c]` increase.

### Java starting point

For this exercise, use the size of the child subtree to express the change when moving the root across one edge. Distances count edges in an unweighted tree, and both vertex counts are positive with childSize < vertexCount.

<!-- java-hint -->
```java
static long rerootDistanceSum(long parentSum, int vertexCount, int childSize) {
    return parentSum + (long) vertexCount - 2L * childSize;
}
```
<!-- /java-hint -->

**Complete the reasoning:** Derive the formula before using it: childSize vertices get one step closer, while every other vertex gets one step farther away. Compute subtree sizes and the first sum separately.

</details>

## Your solution

Add your approach, correctness argument, complexity analysis, and test results after attempting the exercise. Record the attempt in [PROGRESS.md](../../../../PROGRESS.md).

---

<!-- study-navigation -->
[← Previous: Exercise 19.03](../03_weighted-interval-scheduling/README.md) · [Index](../README.md) · [Next: Exercise 19.05 →](../05_digit-dp-without-equal-adjacent-digits/README.md)
<!-- /study-navigation -->
