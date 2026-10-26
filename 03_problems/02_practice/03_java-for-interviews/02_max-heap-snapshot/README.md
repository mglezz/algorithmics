# 03.02 - Max-Heap Snapshot

<!-- study-navigation -->
[← Previous: Exercise 03.01](../01_integer-promotion/README.md) · [Index](../README.md) · [Next: Exercise 03.03 →](../03_immutable-coordinate-keys/README.md)
<!-- /study-navigation -->

[Practice index](../../README.md) | Theory: [Java for Algorithmic Interviews](../../../../01_algorithms/01_foundations/03-java-for-interviews.md)

**Status:** Not started. This is a repository-written practice prompt, not a recruiting question-bank item.

## Exercise

Build a max-heap of integers and identify how you would obtain a sorted snapshot without changing the original.

## Your workspace

Keep your implementation (for example, `Solution.java`) and your tests in this folder. For a proof, analysis, or counterexample task, write your answer in the solution section below; add code only when useful.

State the input/output contract, explain correctness, analyze time and space, and check boundary cases. Java helper fragments belong inside your own class with `import java.util.*;`.

<details><summary>Hints and checkpoints</summary>

Use `Comparator.reverseOrder()`. Copy the heap and poll the copy, or copy to an array and sort.

### Java starting point

Copy a queue before polling a snapshot. These members need import java.util.*; as described in the practice index.

<!-- java-hint -->
```java
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

## Your solution

Add your approach, correctness argument, complexity analysis, and test results after attempting the exercise. Record the attempt in [PROGRESS.md](../../../../PROGRESS.md).

---

<!-- study-navigation -->
[← Previous: Exercise 03.01](../01_integer-promotion/README.md) · [Index](../README.md) · [Next: Exercise 03.03 →](../03_immutable-coordinate-keys/README.md)
<!-- /study-navigation -->
