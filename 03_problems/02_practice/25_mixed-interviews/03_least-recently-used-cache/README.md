# 25.03 - Least-Recently-Used Cache

<!-- study-navigation -->
[← Previous: Exercise 25.02](../02_target-sum-ranges/README.md) · [Index](../README.md) · [Next: Exercise 25.04 →](../04_service-startup-order/README.md)
<!-- /study-navigation -->

[Practice index](../../README.md) | Theory: [Solving, Testing, and Communicating](../../../../01_algorithms/14_problem-solving/25-solving-testing-and-communication.md)

**Status:** Not started. This is a repository-written practice prompt, not a recruiting question-bank item.

## Exercise

Implement an integer `LRUCache(int capacity)` with expected O(1) `Integer get(int key)` and `void put(int key,int value)`, using your own doubly linked list plus HashMap. Return null for misses; reads and overwrites refresh recency. Add a runner comparing operation sequences with an access-ordered LinkedHashMap reference.

## Examples and checks

Capacity 2: put(1,10), put(2,20), get(1), put(3,30) evicts 2. Check overwrites, repeated reads and capacity zero.

## Your workspace

Write your Java 17 implementation and an executable test runner in `src/`. Use `AlgorithmXX_YY.java` and `MainXX_YY.java` with this exercise's numbers, or keep the existing class names. For data-structure exercises, use the requested class and a separate runner. Compare actual and expected results, including the cases above; throw `AssertionError` on a mismatch (or run Java assertions with `-ea`).

The deliverable is working Java code and checks. You may add a short explanation of the algorithm in `src/README.md`, like exercise 02.01; a formal proof or a separate theoretical answer is not required. Unless stated otherwise, inputs are non-null, indices and graph endpoints are valid, and auxiliary result types such as `Node` or `Selection` are yours to define.

<details><summary>Implementation hint</summary>

Keep the map and list synchronized after every operation.

</details>

## Your solution

Keep your Java implementation and executable checks in `src/`. Optionally add a short algorithm explanation in `src/README.md`. Record the attempt in [PROGRESS.md](../../../../PROGRESS.md).

---

<!-- study-navigation -->
[← Previous: Exercise 25.02](../02_target-sum-ranges/README.md) · [Index](../README.md) · [Next: Exercise 25.04 →](../04_service-startup-order/README.md)
<!-- /study-navigation -->
