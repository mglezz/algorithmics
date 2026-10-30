# 13.03 - Running Median

<!-- study-navigation -->
[← Previous: Exercise 13.02](../02_merging-sorted-linked-lists/README.md) · [Index](../README.md) · [Next: Exercise 13.04 →](../04_minimum-extraction-versus-predecessors/README.md)
<!-- /study-navigation -->

[Practice index](../../README.md) | Theory: [Heaps and Priority Queues](../../../../02_data-structures/06_heaps/13-heaps-and-priority-queues.md)

**Status:** Not started. This is a repository-written practice prompt, not a recruiting question-bank item.

## Exercise

Implement `RunningMedian` with `void add(int value)` and `double median()`, using two heaps. Median throws NoSuchElementException while empty. Use O(log n) insertion and O(1) median lookup.

## Examples and checks

After 1,5,2,10, medians are 1,3,2,3.5. Compare each prefix with a sorted copy; test both int extremes.

## Your workspace

Write your Java 17 implementation and an executable test runner in `src/`. Use `AlgorithmXX_YY.java` and `MainXX_YY.java` with this exercise's numbers, or keep the existing class names. For data-structure exercises, use the requested class and a separate runner. Compare actual and expected results, including the cases above; throw `AssertionError` on a mismatch (or run Java assertions with `-ea`).

The deliverable is working Java code and checks. You may add a short explanation of the algorithm in `src/README.md`, like exercise 02.01; a formal proof or a separate theoretical answer is not required. Unless stated otherwise, inputs are non-null, indices and graph endpoints are valid, and auxiliary result types such as `Node` or `Selection` are yours to define.

<details><summary>Implementation hint</summary>

Balance the heap sizes and widen before adding the middle two values.

### Java helper

Optional helper members for your class; add the necessary imports from java.util. Complete the public API and tests described above.

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

</details>

## Your solution

Keep your Java implementation and executable checks in `src/`. Optionally add a short algorithm explanation in `src/README.md`. Record the attempt in [PROGRESS.md](../../../../PROGRESS.md).

---

<!-- study-navigation -->
[← Previous: Exercise 13.02](../02_merging-sorted-linked-lists/README.md) · [Index](../README.md) · [Next: Exercise 13.04 →](../04_minimum-extraction-versus-predecessors/README.md)
<!-- /study-navigation -->
