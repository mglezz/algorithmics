# 08.03 - Queue from Two Stacks

<!-- study-navigation -->
[← Previous: Exercise 08.02](../02_sliding-maximum/README.md) · [Index](../README.md) · [Next: Exercise 08.04 →](../04_largest-histogram-rectangle/README.md)
<!-- /study-navigation -->

[Practice index](../../README.md) | Theory: [Stacks and Queues](../../../../02_data-structures/04_stacks-and-queues/08-stacks-and-queues.md) | [Monotonic Stacks and Deques](../../../../01_algorithms/04_monotonic-structures/08-monotonic-stacks-and-deques.md)

**Status:** Not started. This is a repository-written practice prompt, not a recruiting question-bank item.

## Exercise

Implement `IntQueue` using two ArrayDeque stacks, with `add`, `remove`, `peek` and `isEmpty`. Remove and peek throw NoSuchElementException when empty. Add a counter for transfers between stacks.

## Examples and checks

Add 1 and 2, remove gives 1, add 3, then remove gives 2 and 3. Across any sequence, the transfer count must not exceed the number of additions.

## Your workspace

Write your Java 17 implementation and an executable test runner in `src/`. Use `AlgorithmXX_YY.java` and `MainXX_YY.java` with this exercise's numbers, or keep the existing class names. For data-structure exercises, use the requested class and a separate runner. Compare actual and expected results, including the cases above; throw `AssertionError` on a mismatch (or run Java assertions with `-ea`).

The deliverable is working Java code and checks. You may add a short explanation of the algorithm in `src/README.md`, like exercise 02.01; a formal proof or a separate theoretical answer is not required. Unless stated otherwise, inputs are non-null, indices and graph endpoints are valid, and auxiliary result types such as `Node` or `Selection` are yours to define.

<details><summary>Implementation hint</summary>

Transfer only when the output stack is empty.

</details>

## Your solution

Keep your Java implementation and executable checks in `src/`. Optionally add a short algorithm explanation in `src/README.md`. Record the attempt in [PROGRESS.md](../../../../PROGRESS.md).

---

<!-- study-navigation -->
[← Previous: Exercise 08.02](../02_sliding-maximum/README.md) · [Index](../README.md) · [Next: Exercise 08.04 →](../04_largest-histogram-rectangle/README.md)
<!-- /study-navigation -->
