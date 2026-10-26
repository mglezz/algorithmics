# 13.03 - Running Median

<!-- study-navigation -->
[← Previous: Exercise 13.02](../02_merging-sorted-linked-lists/README.md) · [Index](../README.md) · [Next: Exercise 13.04 →](../04_minimum-extraction-versus-predecessors/README.md)
<!-- /study-navigation -->

[Practice index](../../README.md) | Theory: [Heaps and Priority Queues](../../../../02_data-structures/06_heaps/13-heaps-and-priority-queues.md)

**Status:** Not started. This is a repository-written practice prompt, not a recruiting question-bank item.

## Exercise

Maintain a running median and compare every prefix with a sorted copy.

## Your workspace

Keep your implementation (for example, `Solution.java`) and your tests in this folder. For a proof, analysis, or counterexample task, write your answer in the solution section below; add code only when useful.

State the input/output contract, explain correctness, analyze time and space, and check boundary cases. Java helper fragments belong inside your own class with `import java.util.*;`.

<details><summary>Hints and checkpoints</summary>

Include negative extremes, equal values, and alternating very small/large values.

### Java starting point

For this exercise, separate the comparator choice from the balancing logic. The lower half needs a max-heap and the upper half needs a min-heap.

<!-- java-hint -->
```java
static PriorityQueue<Integer> lowerHalf() {
    return new PriorityQueue<>(Comparator.reverseOrder());
}

static double averageMiddle(int lower, int upper) {
    return ((long) lower + upper) / 2.0;
}
```
<!-- /java-hint -->

**Complete the reasoning:** Maintain ordering across heaps and a size difference of at most one. The cast happens before addition so two int values cannot overflow the sum.

</details>

## Your solution

Add your approach, correctness argument, complexity analysis, and test results after attempting the exercise. Record the attempt in [PROGRESS.md](../../../../PROGRESS.md).

---

<!-- study-navigation -->
[← Previous: Exercise 13.02](../02_merging-sorted-linked-lists/README.md) · [Index](../README.md) · [Next: Exercise 13.04 →](../04_minimum-extraction-versus-predecessors/README.md)
<!-- /study-navigation -->
