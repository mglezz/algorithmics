# 11.03 - Mini Sudoku Solver

<!-- study-navigation -->
[← Previous: Exercise 11.02](../02_unique-permutations/README.md) · [Index](../README.md) · [Next: Exercise 11.04 →](../04_meet-in-the-middle-subset-sum/README.md)
<!-- /study-navigation -->

[Practice index](../../README.md) | Theory: [Recursion, Backtracking, and Search Spaces](../../../../01_algorithms/07_backtracking/11-recursion-and-backtracking.md)

**Status:** Not started. This is a repository-written practice prompt, not a recruiting question-bank item.

## Exercise

Implement `boolean solve(int[][] board)` for a 4x4 Sudoku: zeros are empty, digits 1..4 must appear once per row, column and 2x2 box. Fill one solution in place, choosing the empty cell with fewest legal candidates. Invalid or unsolvable boards return false and remain unchanged.

## Examples and checks

Solve `[[1,0,0,4],[0,4,1,0],[0,1,4,0],[4,0,0,1]]` and check all constraints. Test a completed board and a row with duplicate givens.

## Your workspace

Write your Java 17 implementation and an executable test runner in `src/`. Use `AlgorithmXX_YY.java` and `MainXX_YY.java` with this exercise's numbers, or keep the existing class names. For data-structure exercises, use the requested class and a separate runner. Compare actual and expected results, including the cases above; throw `AssertionError` on a mismatch (or run Java assertions with `-ea`).

The deliverable is working Java code and checks. You may add a short explanation of the algorithm in `src/README.md`, like exercise 02.01; a formal proof or a separate theoretical answer is not required. Unless stated otherwise, inputs are non-null, indices and graph endpoints are valid, and auxiliary result types such as `Node` or `Selection` are yours to define.

<details><summary>Implementation hint</summary>

Compute candidates for empty cells and undo every unsuccessful assignment.

</details>

## Your solution

Keep your Java implementation and executable checks in `src/`. Optionally add a short algorithm explanation in `src/README.md`. Record the attempt in [PROGRESS.md](../../../../PROGRESS.md).

---

<!-- study-navigation -->
[← Previous: Exercise 11.02](../02_unique-permutations/README.md) · [Index](../README.md) · [Next: Exercise 11.04 →](../04_meet-in-the-middle-subset-sum/README.md)
<!-- /study-navigation -->
