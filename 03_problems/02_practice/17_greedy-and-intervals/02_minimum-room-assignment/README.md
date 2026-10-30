# 17.02 - Minimum Room Assignment

<!-- study-navigation -->
[← Previous: Exercise 17.01](../01_interval-scheduling/README.md) · [Index](../README.md) · [Next: Exercise 17.03 →](../03_interval-union-length/README.md)
<!-- /study-navigation -->

[Practice index](../../README.md) | Theory: [Greedy Algorithms, Intervals, and Sweeps](../../../../01_algorithms/09_greedy/17-greedy-and-intervals.md)

**Status:** Not started. This is a repository-written practice prompt, not a recruiting question-bank item.

## Exercise

Implement `RoomAssignment assignRooms(int[][] intervals)` for nonempty half-open intervals. Return the minimum room count and a room ID per input interval; IDs run from 0 to count-1. Touching intervals can reuse a room.

## Examples and checks

`[[0,10],[1,3],[3,5]]` needs 2 rooms; the last two can share one. Empty input needs 0 rooms.

## Your workspace

Write your Java 17 implementation and an executable test runner in `src/`. Use `AlgorithmXX_YY.java` and `MainXX_YY.java` with this exercise's numbers, or keep the existing class names. For data-structure exercises, use the requested class and a separate runner. Compare actual and expected results, including the cases above; throw `AssertionError` on a mismatch (or run Java assertions with `-ea`).

The deliverable is working Java code and checks. You may add a short explanation of the algorithm in `src/README.md`, like exercise 02.01; a formal proof or a separate theoretical answer is not required. Unless stated otherwise, inputs are non-null, indices and graph endpoints are valid, and auxiliary result types such as `Node` or `Selection` are yours to define.

<details><summary>Implementation hint</summary>

Process starts in order and track room finish times in a min-heap.

</details>

## Your solution

Keep your Java implementation and executable checks in `src/`. Optionally add a short algorithm explanation in `src/README.md`. Record the attempt in [PROGRESS.md](../../../../PROGRESS.md).

---

<!-- study-navigation -->
[← Previous: Exercise 17.01](../01_interval-scheduling/README.md) · [Index](../README.md) · [Next: Exercise 17.03 →](../03_interval-union-length/README.md)
<!-- /study-navigation -->
