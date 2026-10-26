# 04 - Arrays, Strings, Prefix Sums, and Difference Arrays

<!-- study-navigation -->
[← Previous: Unit 03](03-java-for-interviews.md) · [Index](README.md) · [Next: Unit 05 →](05-hash-tables.md)
<!-- /study-navigation -->

[Practice index](README.md) | Theory: [Arrays and Strings](../../02_data-structures/01_arrays-and-strings/04-arrays-and-strings.md) | [Prefix Sums and Difference Arrays](../../01_algorithms/02_range-queries/04-prefix-sums-and-difference-arrays.md)

**Status:** Suggested practice; no solution or completion is implied. These prompts and hints were written for this repository, not copied from a recruiting question bank.

## Your deliverable

Write a specification, your solution, a correctness argument, time/space analysis, and tests. Record independent attempts in [PROGRESS.md](../../PROGRESS.md).

## Exercises

1. Return the index whose left and right sums agree, or `-1` if none exists.
2. Apply `q` inclusive range increments to an array; translate the contract into half-open events.
3. Answer rectangle-sum queries and test a single cell, a full matrix, and an empty-width rectangle.
4. Compute all products except self without division. Account for zeros and overflow.

<details><summary>Hints and checkpoints</summary>

1. Maintain a running left sum and use `total-left-a[i]` for the right sum; `O(n)` time, `O(1)` auxiliary space.
2. Subtract at `right+1`; allocate a sentinel position beyond the last valid index.
3. The four-prefix formula must return zero for an empty rectangle.
4. Combine a left product and a right product; the output array can store the left products. Zero counts matter if using a total-product approach.

### Java starting point

For exercise 2, use a difference array of length n + 1, including a sentinel. This helper records a half-open update; reconstruct the values with a prefix scan yourself. Assume all accumulated values fit in long.

<!-- java-hint -->
```java
static void addRange(long[] difference, int left, int right, long delta) {
    int n = difference.length - 1;
    if (left < 0 || left > right || right > n) {
        throw new IllegalArgumentException("Invalid half-open range");
    }
    difference[left] += delta;
    difference[right] -= delta;
}
```
<!-- /java-hint -->

**Complete the reasoning:** Translate an inclusive [a, b] update into [a, b + 1). Check an empty update and an update ending at n.

</details>

---

<!-- study-navigation -->
[← Previous: Unit 03](03-java-for-interviews.md) · [Index](README.md) · [Next: Unit 05 →](05-hash-tables.md)
<!-- /study-navigation -->
