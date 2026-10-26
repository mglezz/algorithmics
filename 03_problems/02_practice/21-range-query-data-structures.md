# 21 - Fenwick Trees, Segment Trees, and Sparse Tables

<!-- study-navigation -->
[← Previous: Unit 20](20-tries-and-string-matching.md) · [Index](README.md) · [Next: Unit 22 →](22-bits-number-theory-and-randomness.md)
<!-- /study-navigation -->

[Practice index](README.md) | Theory: [Fenwick Trees, Segment Trees, and Sparse Tables](../../02_data-structures/10_range-queries/21-range-query-data-structures.md)

**Status:** Suggested practice; no solution or completion is implied. These prompts and hints were written for this repository, not copied from a recruiting question bank.

## Your deliverable

Write a specification, your solution, a correctness argument, time/space analysis, and tests. Record independent attempts in [PROGRESS.md](../../PROGRESS.md).

## Exercises

1. Count inversions with compressed ranks and a Fenwick tree; compare with merge-sort counting.
2. Implement point updates and range minimum with a segment tree.
3. Implement range assignment plus range addition plus range sum with lazy tags.
4. Explain why a static sparse-table sum query cannot use two overlapping blocks.

<details><summary>Hints and checkpoints</summary>

1. Query strictly smaller/larger ranks as appropriate; duplicates are not inversions.
2. Empty ranges need an identity such as positive infinity for minimum.
3. Test assign zero, add, partial query, assign again, and overlapping updates against a plain array.
4. Shared elements would be added twice, while taking min twice changes nothing.

### Java starting point

For exercise 3, an addition after an existing assignment can be folded into that assignment. These helpers describe tag composition only; updating a segment sum also needs its length. Assume arithmetic fits in long.

<!-- java-hint -->
```java
static final class Tag {
    boolean hasAssignment;
    long assignment;
    long addition;

    void assign(long value) {
        hasAssignment = true;
        assignment = value;
        addition = 0;
    }

    void add(long delta) {
        if (hasAssignment) assignment += delta;
        else addition += delta;
    }
}
```
<!-- /java-hint -->

**Complete the reasoning:** Supply propagation and sum updates. Test assign-then-add and add-then-assign; they have different meanings. An assignment of zero must still carry hasAssignment = true.

</details>

---

<!-- study-navigation -->
[← Previous: Unit 20](20-tries-and-string-matching.md) · [Index](README.md) · [Next: Unit 22 →](22-bits-number-theory-and-randomness.md)
<!-- /study-navigation -->
