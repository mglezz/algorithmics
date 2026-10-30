# 21.03 - Lazy Range Assignment and Addition

<!-- study-navigation -->
[← Previous: Exercise 21.02](../02_segment-tree-range-minimum/README.md) · [Index](../README.md) · [Next: Exercise 21.04 →](../04_sparse-table-overlap/README.md)
<!-- /study-navigation -->

[Practice index](../../README.md) | Theory: [Fenwick Trees, Segment Trees, and Sparse Tables](../../../../02_data-structures/10_range-queries/21-range-query-data-structures.md)

**Status:** Not started. This is a repository-written practice prompt, not a recruiting question-bank item.

## Exercise

Implement `RangeSums(long[] values)` with `assign(left,right,value)`, `add(left,right,delta)` and `long sum(left,right)` on half-open ranges. Use lazy propagation with O(log n) operations. Empty updates do nothing; empty sums are zero. Assume arithmetic fits in long.

## Examples and checks

Start `[1,2,3]`, assign(0,2,0), add(1,3,5): values are `[0,5,8]` and total is 13. Compare mixed overlapping operations with a plain array.

## Your workspace

Write your Java 17 implementation and an executable test runner in `src/`. Use `AlgorithmXX_YY.java` and `MainXX_YY.java` with this exercise's numbers, or keep the existing class names. For data-structure exercises, use the requested class and a separate runner. Compare actual and expected results, including the cases above; throw `AssertionError` on a mismatch (or run Java assertions with `-ea`).

The deliverable is working Java code and checks. You may add a short explanation of the algorithm in `src/README.md`, like exercise 02.01; a formal proof or a separate theoretical answer is not required. Unless stated otherwise, inputs are non-null, indices and graph endpoints are valid, and auxiliary result types such as `Node` or `Selection` are yours to define.

<details><summary>Implementation hint</summary>

Track whether an assignment exists separately from its numeric value; assignment and addition order matters.

### Java helper

Optional helper members for your class; add the necessary imports from java.util. Complete the public API and tests described above.

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

</details>

## Your solution

Keep your Java implementation and executable checks in `src/`. Optionally add a short algorithm explanation in `src/README.md`. Record the attempt in [PROGRESS.md](../../../../PROGRESS.md).

---

<!-- study-navigation -->
[← Previous: Exercise 21.02](../02_segment-tree-range-minimum/README.md) · [Index](../README.md) · [Next: Exercise 21.04 →](../04_sparse-table-overlap/README.md)
<!-- /study-navigation -->
