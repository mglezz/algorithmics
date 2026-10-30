# 22.04 - Shuffle and Exhaustive Outcome Counts

<!-- study-navigation -->
[← Previous: Exercise 22.03](../03_reservoir-retention-proof/README.md) · [Index](../README.md) · [Next: Exercise 23.01 →](../../23_advanced-graphs-and-flow/01_scc-condensation/README.md)
<!-- /study-navigation -->

[Practice index](../../README.md) | Theory: [Bits, Number Theory, and Randomized Algorithms](../../../../01_algorithms/12_mathematics/22-bits-number-theory-and-randomness.md)

**Status:** Not started. This is a repository-written practice prompt, not a recruiting question-bank item.

## Exercise

Implement in-place Fisher-Yates `void shuffle(int[] values, Random random)`. Also write an exhaustive Java enumerator for arrays of size at most 5 that counts every random-choice path: compare Fisher-Yates (i=n-1 down to 1, j in 0..i) with a biased variant (i=0..n-1, j in 0..n-1).

## Examples and checks

For `[0,1,2]`, Fisher-Yates has 6 paths and each permutation occurs once. The biased variant has 27 paths and unequal outcome counts. Verify the shuffle preserves values.

## Your workspace

Write your Java 17 implementation and an executable test runner in `src/`. Use `AlgorithmXX_YY.java` and `MainXX_YY.java` with this exercise's numbers, or keep the existing class names. For data-structure exercises, use the requested class and a separate runner. Compare actual and expected results, including the cases above; throw `AssertionError` on a mismatch (or run Java assertions with `-ea`).

The deliverable is working Java code and checks. You may add a short explanation of the algorithm in `src/README.md`, like exercise 02.01; a formal proof or a separate theoretical answer is not required. Unless stated otherwise, inputs are non-null, indices and graph endpoints are valid, and auxiliary result types such as `Node` or `Selection` are yours to define.

<details><summary>Implementation hint</summary>

Enumerate choices recursively, undoing each swap and counting immutable permutation keys.

</details>

## Your solution

Keep your Java implementation and executable checks in `src/`. Optionally add a short algorithm explanation in `src/README.md`. Record the attempt in [PROGRESS.md](../../../../PROGRESS.md).

---

<!-- study-navigation -->
[← Previous: Exercise 22.03](../03_reservoir-retention-proof/README.md) · [Index](../README.md) · [Next: Exercise 23.01 →](../../23_advanced-graphs-and-flow/01_scc-condensation/README.md)
<!-- /study-navigation -->
