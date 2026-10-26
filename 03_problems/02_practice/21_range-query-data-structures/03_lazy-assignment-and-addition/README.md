# 21.03 - Lazy Assignment and Addition

<!-- study-navigation -->
[← Previous: Exercise 21.02](../02_segment-tree-range-minimum/README.md) · [Index](../README.md) · [Next: Exercise 21.04 →](../04_sparse-table-overlap/README.md)
<!-- /study-navigation -->

[Practice index](../../README.md) | Theory: [Fenwick Trees, Segment Trees, and Sparse Tables](../../../../02_data-structures/10_range-queries/21-range-query-data-structures.md)

**Status:** Not started. This is a repository-written practice prompt, not a recruiting question-bank item.

## Exercise

Implement range assignment plus range addition plus range sum with lazy tags.

## Your workspace

Keep your implementation (for example, `Solution.java`) and your tests in this folder. For a proof, analysis, or counterexample task, write your answer in the solution section below; add code only when useful.

State the input/output contract, explain correctness, analyze time and space, and check boundary cases. Java helper fragments belong inside your own class with `import java.util.*;`.

<details><summary>Hints and checkpoints</summary>

Test assign zero, add, partial query, assign again, and overlapping updates against a plain array.

### Java starting point

For this exercise, an addition after an existing assignment can be folded into that assignment. These helpers describe tag composition only; updating a segment sum also needs its length. Assume arithmetic fits in long.

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

## Your solution

Add your approach, correctness argument, complexity analysis, and test results after attempting the exercise. Record the attempt in [PROGRESS.md](../../../../PROGRESS.md).

---

<!-- study-navigation -->
[← Previous: Exercise 21.02](../02_segment-tree-range-minimum/README.md) · [Index](../README.md) · [Next: Exercise 21.04 →](../04_sparse-table-overlap/README.md)
<!-- /study-navigation -->
