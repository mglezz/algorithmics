# 25.01 - Threshold Search

<!-- study-navigation -->
[← Previous: Exercise 24.05](../../24_complexity-and-advanced-design/05_stream-frequency-guarantees/README.md) · [Index](../README.md) · [Next: Exercise 25.02 →](../02_target-sum-ranges/README.md)
<!-- /study-navigation -->

[Practice index](../../README.md) | Theory: [Solving, Testing, and Communicating](../../../../01_algorithms/14_problem-solving/25-solving-testing-and-communication.md)

**Status:** Not started. This is a repository-written practice prompt, not a recruiting question-bank item.

## Exercise

Implement `int firstAtLeast(int[] sorted,int threshold)` returning the first index whose value reaches threshold, or length. Then implement `int countEqual(int[] sorted,int value)` using two binary searches, both in O(log n).

## Examples and checks

For `[1,2,2,5]`, threshold 2 returns 1 and countEqual(2) returns 2; threshold 6 returns 4; check empty input.

## Your workspace

Write your Java 17 implementation and an executable test runner in `src/`. Use `AlgorithmXX_YY.java` and `MainXX_YY.java` with this exercise's numbers, or keep the existing class names. For data-structure exercises, use the requested class and a separate runner. Compare actual and expected results, including the cases above; throw `AssertionError` on a mismatch (or run Java assertions with `-ea`).

The deliverable is working Java code and checks. You may add a short explanation of the algorithm in `src/README.md`, like exercise 02.01; a formal proof or a separate theoretical answer is not required. Unless stated otherwise, inputs are non-null, indices and graph endpoints are valid, and auxiliary result types such as `Node` or `Selection` are yours to define.

<details><summary>Implementation hint</summary>

Use half-open search boundaries and distinguish >= from >.

</details>

## Your solution

Keep your Java implementation and executable checks in `src/`. Optionally add a short algorithm explanation in `src/README.md`. Record the attempt in [PROGRESS.md](../../../../PROGRESS.md).

---

<!-- study-navigation -->
[← Previous: Exercise 24.05](../../24_complexity-and-advanced-design/05_stream-frequency-guarantees/README.md) · [Index](../README.md) · [Next: Exercise 25.02 →](../02_target-sum-ranges/README.md)
<!-- /study-navigation -->
