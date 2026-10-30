# 11.02 - Unique Permutations

<!-- study-navigation -->
[← Previous: Exercise 11.01](../01_balanced-parentheses/README.md) · [Index](../README.md) · [Next: Exercise 11.03 →](../03_constraint-grid-search/README.md)
<!-- /study-navigation -->

[Practice index](../../README.md) | Theory: [Recursion, Backtracking, and Search Spaces](../../../../01_algorithms/07_backtracking/11-recursion-and-backtracking.md)

**Status:** Not started. This is a repository-written practice prompt, not a recruiting question-bank item.

## Exercise

Implement `List<List<Integer>> permutations(int[] values)` for at most 9 elements. Return every distinct permutation once; output order is unrestricted and the input must remain unchanged.

## Examples and checks

`[1,1,2]` returns `[1,1,2]`, `[1,2,1]`, `[2,1,1]`; an empty array returns one empty permutation.

## Your workspace

Write your Java 17 implementation and an executable test runner in `src/`. Use `AlgorithmXX_YY.java` and `MainXX_YY.java` with this exercise's numbers, or keep the existing class names. For data-structure exercises, use the requested class and a separate runner. Compare actual and expected results, including the cases above; throw `AssertionError` on a mismatch (or run Java assertions with `-ea`).

The deliverable is working Java code and checks. You may add a short explanation of the algorithm in `src/README.md`, like exercise 02.01; a formal proof or a separate theoretical answer is not required. Unless stated otherwise, inputs are non-null, indices and graph endpoints are valid, and auxiliary result types such as `Node` or `Selection` are yours to define.

<details><summary>Implementation hint</summary>

Sort a copy and track used positions or keep value frequencies.

### Java helper

Optional helper members for your class; add the necessary imports from java.util. Complete the public API and tests described above.

<!-- java-hint -->
```java
static boolean skipCandidate(int[] sorted, boolean[] used, int index) {
    if (used[index]) return true;
    return index > 0 && sorted[index] == sorted[index - 1] && !used[index - 1];
}
```
<!-- /java-hint -->

</details>

## Your solution

Keep your Java implementation and executable checks in `src/`. Optionally add a short algorithm explanation in `src/README.md`. Record the attempt in [PROGRESS.md](../../../../PROGRESS.md).

---

<!-- study-navigation -->
[← Previous: Exercise 11.01](../01_balanced-parentheses/README.md) · [Index](../README.md) · [Next: Exercise 11.03 →](../03_constraint-grid-search/README.md)
<!-- /study-navigation -->
