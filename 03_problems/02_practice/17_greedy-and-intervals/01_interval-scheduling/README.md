# 17.01 - Interval Scheduling

<!-- study-navigation -->
[← Previous: Exercise 16.04](../../16_disjoint-sets-and-spanning-trees/04_mst-versus-shortest-path-tree/README.md) · [Index](../README.md) · [Next: Exercise 17.02 →](../02_minimum-room-assignment/README.md)
<!-- /study-navigation -->

[Practice index](../../README.md) | Theory: [Greedy Algorithms, Intervals, and Sweeps](../../../../01_algorithms/09_greedy/17-greedy-and-intervals.md)

**Status:** Not started. This is a repository-written practice prompt, not a recruiting question-bank item.

## Exercise

Implement maximum-cardinality interval scheduling and return the selected interval IDs.

## Your workspace

Keep your implementation (for example, `Solution.java`) and your tests in this folder. For a proof, analysis, or counterexample task, write your answer in the solution section below; add code only when useful.

State the input/output contract, explain correctness, analyze time and space, and check boundary cases. Java helper fragments belong inside your own class with `import java.util.*;`.

<details><summary>Hints and checkpoints</summary>

Stable identity tracking matters if sorting changes input order.

### Java starting point

For this exercise, sort by finish time. These intervals are nonempty and half-open: [start, end), with start < end. Equality between the next start and previous end is compatible.

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

**Complete the reasoning:** Supply the selection loop and retain original IDs. Prove why replacing the first selected interval with an earliest-finishing one is safe.

</details>

## Your solution

Add your approach, correctness argument, complexity analysis, and test results after attempting the exercise. Record the attempt in [PROGRESS.md](../../../../PROGRESS.md).

---

<!-- study-navigation -->
[← Previous: Exercise 16.04](../../16_disjoint-sets-and-spanning-trees/04_mst-versus-shortest-path-tree/README.md) · [Index](../README.md) · [Next: Exercise 17.02 →](../02_minimum-room-assignment/README.md)
<!-- /study-navigation -->
