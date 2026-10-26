# 03 - Java for Algorithmic Interviews

<!-- study-navigation -->
[← Previous: Unit 02](02-complexity-and-amortization.md) · [Index](README.md) · [Next: Unit 04 →](04-arrays-strings-and-prefix-sums.md)
<!-- /study-navigation -->

[Practice index](README.md) | Theory: [Java for Algorithmic Interviews](../../01_algorithms/01_foundations/03-java-for-interviews.md)

**Status:** Suggested practice; no solution or completion is implied. These prompts and hints were written for this repository, not copied from a recruiting question bank.

## Your deliverable

Write a specification, your solution, a correctness argument, time/space analysis, and tests. Record independent attempts in [PROGRESS.md](../../PROGRESS.md).

## Exercises

1. Explain why `(long) (a*b)` can be wrong when `a` and `b` are ints.
2. Build a max-heap of integers and identify how you would obtain a sorted snapshot without changing the original.
3. Design an immutable coordinate key with correct equality.
4. Review the existing dependency solution: distinguish the clean algorithm's cost from verbose tracing that prints growing arrays.

<details><summary>Hints and checkpoints</summary>

1. Promotion occurs after the overflowing multiplication; move the cast to an operand.
2. Use `Comparator.reverseOrder()`. Copy the heap and poll the copy, or copy to an array and sort.
3. A record with two int components has suitable value semantics; an `int[]` does not.
4. Repeatedly printing prefixes of increasing size can contribute quadratic output even when the underlying graph processing is linear.

### Java starting point

For exercises 2 and 3, use value equality for a coordinate and copy a queue before polling a snapshot. These members need import java.util.*; as described in the practice index.

<!-- java-hint -->
```java
record Point(int row, int column) {}

static List<Integer> descendingSnapshot(PriorityQueue<Integer> maximumHeap) {
    // Precondition: maximumHeap uses Comparator.reverseOrder().
    PriorityQueue<Integer> copy = new PriorityQueue<>(maximumHeap);
    List<Integer> result = new ArrayList<>();
    while (!copy.isEmpty()) result.add(copy.remove());
    return result;
}
```
<!-- /java-hint -->

**Complete the reasoning:** Construct the original max-heap yourself. Explain why iteration over that heap would not produce the same sorted snapshot.

</details>

---

<!-- study-navigation -->
[← Previous: Unit 02](02-complexity-and-amortization.md) · [Index](README.md) · [Next: Unit 04 →](04-arrays-strings-and-prefix-sums.md)
<!-- /study-navigation -->
