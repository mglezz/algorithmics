# 13.04 - Ordered Multiset

<!-- study-navigation -->
[← Previous: Exercise 13.03](../03_running-median/README.md) · [Index](../README.md) · [Next: Exercise 14.01 →](../../14_graphs-and-topological-order/01_service-startup-order/README.md)
<!-- /study-navigation -->

[Practice index](../../README.md) | Theory: [Heaps and Priority Queues](../../../../02_data-structures/06_heaps/13-heaps-and-priority-queues.md)

**Status:** Not started. This is a repository-written practice prompt, not a recruiting question-bank item.

## Exercise

Implement `OrderedMultiset` using TreeMap counts, with `add(int)`, `Integer pollMin()` and `Integer predecessor(int)`. Poll removes one smallest occurrence; predecessor returns the greatest stored value strictly below the argument without removing it. Return null when no answer exists.

## Examples and checks

Add 2,2,5: predecessor(5) is 2; two polls return 2 then 2; predecessor(5) then returns null.

## Your workspace

Write your Java 17 implementation and an executable test runner in `src/`. Use `AlgorithmXX_YY.java` and `MainXX_YY.java` with this exercise's numbers, or keep the existing class names. For data-structure exercises, use the requested class and a separate runner. Compare actual and expected results, including the cases above; throw `AssertionError` on a mismatch (or run Java assertions with `-ea`).

The deliverable is working Java code and checks. You may add a short explanation of the algorithm in `src/README.md`, like exercise 02.01; a formal proof or a separate theoretical answer is not required. Unless stated otherwise, inputs are non-null, indices and graph endpoints are valid, and auxiliary result types such as `Node` or `Selection` are yours to define.

<details><summary>Implementation hint</summary>

Store multiplicities and use lowerKey for strict predecessor queries.

</details>

## Your solution

Keep your Java implementation and executable checks in `src/`. Optionally add a short algorithm explanation in `src/README.md`. Record the attempt in [PROGRESS.md](../../../../PROGRESS.md).

---

<!-- study-navigation -->
[← Previous: Exercise 13.03](../03_running-median/README.md) · [Index](../README.md) · [Next: Exercise 14.01 →](../../14_graphs-and-topological-order/01_service-startup-order/README.md)
<!-- /study-navigation -->
