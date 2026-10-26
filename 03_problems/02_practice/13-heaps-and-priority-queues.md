# 13 - Heaps and Priority Queues

<!-- study-navigation -->
[← Previous: Unit 12](12-trees-and-ordered-maps.md) · [Index](README.md) · [Next: Unit 14 →](14-graphs-and-topological-order.md)
<!-- /study-navigation -->

[Practice index](README.md) | Theory: [Heaps and Priority Queues](../../02_data-structures/06_heaps/13-heaps-and-priority-queues.md)

**Status:** Suggested practice; no solution or completion is implied. These prompts and hints were written for this repository, not copied from a recruiting question bank.

## Your deliverable

Write a specification, your solution, a correctness argument, time/space analysis, and tests. Record independent attempts in [PROGRESS.md](../../PROGRESS.md).

## Exercises

1. Implement sift-down and prove that only the chosen child path can remain invalid.
2. Merge sorted linked lists without losing the successor before rewiring.
3. Maintain a running median and compare every prefix with a sorted copy.
4. Choose a structure for frequent minimum extraction versus predecessor queries.

<details><summary>Hints and checkpoints</summary>

1. Exchange with the smaller child, not an arbitrary child.
2. Save the removed node's next reference and enqueue it before changing links.
3. Include negative extremes, equal values, and alternating very small/large values.
4. A heap supports the minimum well; an ordered tree supports ordered navigation.

### Java starting point

For exercise 3, separate the comparator choice from the balancing logic. The lower half needs a max-heap and the upper half needs a min-heap.

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

---

<!-- study-navigation -->
[← Previous: Unit 12](12-trees-and-ordered-maps.md) · [Index](README.md) · [Next: Unit 14 →](14-graphs-and-topological-order.md)
<!-- /study-navigation -->
