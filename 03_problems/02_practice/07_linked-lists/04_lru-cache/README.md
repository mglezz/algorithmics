# 07.04 - LRU Cache

<!-- study-navigation -->
[← Previous: Exercise 07.03](../03_merging-sorted-lists/README.md) · [Index](../README.md) · [Next: Exercise 08.01 →](../../08_stacks-queues-and-monotonic-structures/01_daily-temperatures/README.md)
<!-- /study-navigation -->

[Practice index](../../README.md) | Theory: [Linked Lists and Reference Manipulation](../../../../02_data-structures/03_linked-lists/07-linked-lists.md)

**Status:** Not started. This is a repository-written practice prompt, not a recruiting question-bank item.

## Exercise

Implement `LRUCache(int capacity)` with `Integer get(int key)` and `void put(int key, int value)`, both expected O(1). Missing keys return null. Reads and overwrites mark a key most recently used. Use a HashMap and your own doubly linked list; capacity is nonnegative.

## Examples and checks

With capacity 2, put 1, put 2, get 1, put 3 evicts 2. Check overwrite without growing size and capacity zero retaining nothing.

## Your workspace

Write your Java 17 implementation and an executable test runner in `src/`. Use `AlgorithmXX_YY.java` and `MainXX_YY.java` with this exercise's numbers, or keep the existing class names. For data-structure exercises, use the requested class and a separate runner. Compare actual and expected results, including the cases above; throw `AssertionError` on a mismatch (or run Java assertions with `-ea`).

The deliverable is working Java code and checks. You may add a short explanation of the algorithm in `src/README.md`, like exercise 02.01; a formal proof or a separate theoretical answer is not required. Unless stated otherwise, inputs are non-null, indices and graph endpoints are valid, and auxiliary result types such as `Node` or `Selection` are yours to define.

<details><summary>Implementation hint</summary>

Update both list links and remove evicted keys from the map.

</details>

## Your solution

Keep your Java implementation and executable checks in `src/`. Optionally add a short algorithm explanation in `src/README.md`. Record the attempt in [PROGRESS.md](../../../../PROGRESS.md).

---

<!-- study-navigation -->
[← Previous: Exercise 07.03](../03_merging-sorted-lists/README.md) · [Index](../README.md) · [Next: Exercise 08.01 →](../../08_stacks-queues-and-monotonic-structures/01_daily-temperatures/README.md)
<!-- /study-navigation -->
