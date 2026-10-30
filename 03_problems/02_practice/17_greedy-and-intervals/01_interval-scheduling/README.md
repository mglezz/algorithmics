# 17.01 - Interval Scheduling

<!-- study-navigation -->
[← Previous: Exercise 16.04](../../16_disjoint-sets-and-spanning-trees/04_mst-versus-shortest-path-tree/README.md) · [Index](../README.md) · [Next: Exercise 17.02 →](../02_minimum-room-assignment/README.md)
<!-- /study-navigation -->

[Practice index](../../README.md) | Theory: [Greedy Algorithms, Intervals, and Sweeps](../../../../01_algorithms/09_greedy/17-greedy-and-intervals.md)

**Status:** Not started. This is a repository-written practice prompt, not a recruiting question-bank item.

## Exercise

Implement `List<Integer> selectIntervals(List<Interval> intervals)` returning original IDs of a maximum-cardinality compatible subset. Intervals have unique IDs and nonempty half-open bounds `[start,end)`; touching endpoints are compatible. Return IDs in scheduled order.

## Examples and checks

Intervals `[0,2),[1,3),[2,4)` with IDs 0,1,2 select `[0,2]`; empty input returns empty.

## Your workspace

Write your Java 17 implementation and an executable test runner in `src/`. Use `AlgorithmXX_YY.java` and `MainXX_YY.java` with this exercise's numbers, or keep the existing class names. For data-structure exercises, use the requested class and a separate runner. Compare actual and expected results, including the cases above; throw `AssertionError` on a mismatch (or run Java assertions with `-ea`).

The deliverable is working Java code and checks. You may add a short explanation of the algorithm in `src/README.md`, like exercise 02.01; a formal proof or a separate theoretical answer is not required. Unless stated otherwise, inputs are non-null, indices and graph endpoints are valid, and auxiliary result types such as `Node` or `Selection` are yours to define.

<details><summary>Implementation hint</summary>

Sort by finish time and accept each compatible interval.

### Java helper

Optional helper members for your class; add the necessary imports from java.util. Complete the public API and tests described above.

<!-- java-hint -->
```java
record Interval(int id, long start, long end) {}

static void orderByFinish(List<Interval> intervals) {
    intervals.sort(Comparator.comparingLong(Interval::end)
                             .thenComparingLong(Interval::start));
}

static boolean compatible(Interval next, long previousEnd) {
    return next.start() >= previousEnd;
}
```
<!-- /java-hint -->

</details>

## Your solution

Keep your Java implementation and executable checks in `src/`. Optionally add a short algorithm explanation in `src/README.md`. Record the attempt in [PROGRESS.md](../../../../PROGRESS.md).

---

<!-- study-navigation -->
[← Previous: Exercise 16.04](../../16_disjoint-sets-and-spanning-trees/04_mst-versus-shortest-path-tree/README.md) · [Index](../README.md) · [Next: Exercise 17.02 →](../02_minimum-room-assignment/README.md)
<!-- /study-navigation -->
