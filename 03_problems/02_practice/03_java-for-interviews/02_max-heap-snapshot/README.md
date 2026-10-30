# 03.02 - Max-Heap Snapshot

<!-- study-navigation -->
[← Previous: Exercise 03.01](../01_integer-promotion/README.md) · [Index](../README.md) · [Next: Exercise 03.03 →](../03_immutable-coordinate-keys/README.md)
<!-- /study-navigation -->

[Practice index](../../README.md) | Theory: [Java for Algorithmic Interviews](../../../../01_algorithms/01_foundations/03-java-for-interviews.md)

**Status:** Not started. This is a repository-written practice prompt, not a recruiting question-bank item.

## Exercise

Create a max-heap using `PriorityQueue<Integer>` and implement `List<Integer> descendingSnapshot(PriorityQueue<Integer> heap)`. Return all elements in descending order, preserving duplicates and leaving the original heap unchanged.

## Examples and checks

Insert `3,1,3,2`: snapshot is `[3,3,2,1]`, original size remains 4 and its next removal is 3. An empty heap gives an empty list.

## Your workspace

Write your Java 17 implementation and an executable test runner in `src/`. Use `AlgorithmXX_YY.java` and `MainXX_YY.java` with this exercise's numbers, or keep the existing class names. For data-structure exercises, use the requested class and a separate runner. Compare actual and expected results, including the cases above; throw `AssertionError` on a mismatch (or run Java assertions with `-ea`).

The deliverable is working Java code and checks. You may add a short explanation of the algorithm in `src/README.md`, like exercise 02.01; a formal proof or a separate theoretical answer is not required. Unless stated otherwise, inputs are non-null, indices and graph endpoints are valid, and auxiliary result types such as `Node` or `Selection` are yours to define.

<details><summary>Implementation hint</summary>

Copy the heap before polling; the input must use a descending comparator.

### Java helper

Optional helper members for your class; add the necessary imports from java.util. Complete the public API and tests described above.

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

</details>

## Your solution

Keep your Java implementation and executable checks in `src/`. Optionally add a short algorithm explanation in `src/README.md`. Record the attempt in [PROGRESS.md](../../../../PROGRESS.md).

---

<!-- study-navigation -->
[← Previous: Exercise 03.01](../01_integer-promotion/README.md) · [Index](../README.md) · [Next: Exercise 03.03 →](../03_immutable-coordinate-keys/README.md)
<!-- /study-navigation -->
