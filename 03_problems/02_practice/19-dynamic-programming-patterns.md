# 19 - Dynamic Programming Patterns and Reconstruction

<!-- study-navigation -->
[← Previous: Unit 18](18-dynamic-programming.md) · [Index](README.md) · [Next: Unit 20 →](20-tries-and-string-matching.md)
<!-- /study-navigation -->

[Practice index](README.md) | Theory: [Dynamic Programming Patterns and Reconstruction](../../01_algorithms/10_dynamic-programming/19-dynamic-programming-patterns.md)

**Status:** Suggested practice; no solution or completion is implied. These prompts and hints were written for this repository, not copied from a recruiting question bank.

## Your deliverable

Write a specification, your solution, a correctness argument, time/space analysis, and tests. Record independent attempts in [PROGRESS.md](../../PROGRESS.md).

## Exercises

1. Reconstruct an LCS and an edit script; validate them independently.
2. Implement both LIS algorithms and compare lengths on random arrays with duplicates.
3. Solve weighted intervals and produce the chosen job IDs.
4. Derive the reroot distance formula by partitioning vertices into two groups.
5. Count nonnegative integers up to N with no adjacent equal decimal digits.

<details><summary>Hints and checkpoints</summary>

1. Check subsequence membership / apply the edit operations, not just the reported length.
2. Strictness changes the binary-search boundary.
3. Backtrack through the skip/take decision and predecessor index.
4. Exactly `size[c]` distances decrease; the other `V-size[c]` increase.
5. Track the previous digit plus tight/started flags; leading padding is not an ordinary digit.

### Java starting point

For exercise 4, use the size of the child subtree to express the change when moving the root across one edge. Distances count edges in an unweighted tree, and both vertex counts are positive with childSize < vertexCount.

<!-- java-hint -->
```java
static long rerootDistanceSum(long parentSum, int vertexCount, int childSize) {
    return parentSum + (long) vertexCount - 2L * childSize;
}
```
<!-- /java-hint -->

**Complete the reasoning:** Derive the formula before using it: childSize vertices get one step closer, while every other vertex gets one step farther away. Compute subtree sizes and the first sum separately.

</details>

---

<!-- study-navigation -->
[← Previous: Unit 18](18-dynamic-programming.md) · [Index](README.md) · [Next: Unit 20 →](20-tries-and-string-matching.md)
<!-- /study-navigation -->
