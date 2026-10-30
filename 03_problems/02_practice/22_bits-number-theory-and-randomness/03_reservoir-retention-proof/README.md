# 22.03 - Reservoir Sampling

<!-- study-navigation -->
[← Previous: Exercise 22.02](../02_modular-exponentiation/README.md) · [Index](../README.md) · [Next: Exercise 22.04 →](../04_exact-shuffle-probabilities/README.md)
<!-- /study-navigation -->

[Practice index](../../README.md) | Theory: [Bits, Number Theory, and Randomized Algorithms](../../../../01_algorithms/12_mathematics/22-bits-number-theory-and-randomness.md)

**Status:** Not started. This is a repository-written practice prompt, not a recruiting question-bank item.

## Exercise

Implement `OptionalInt sample(Iterator<Integer> input, Random random)` selecting one uniformly random stream item without storing the stream. Return empty for no items; use O(1) extra space. For this exercise the stream length fits in int.

## Examples and checks

A one-item stream always returns that item; an empty stream returns empty. Use seeded Random instances to check reproducible behavior and run a frequency experiment on `[10,20,30]`.

## Your workspace

Write your Java 17 implementation and an executable test runner in `src/`. Use `AlgorithmXX_YY.java` and `MainXX_YY.java` with this exercise's numbers, or keep the existing class names. For data-structure exercises, use the requested class and a separate runner. Compare actual and expected results, including the cases above; throw `AssertionError` on a mismatch (or run Java assertions with `-ea`).

The deliverable is working Java code and checks. You may add a short explanation of the algorithm in `src/README.md`, like exercise 02.01; a formal proof or a separate theoretical answer is not required. Unless stated otherwise, inputs are non-null, indices and graph endpoints are valid, and auxiliary result types such as `Node` or `Selection` are yours to define.

<details><summary>Implementation hint</summary>

At the t-th item, replace the sample when random.nextInt(t) is zero; the frequency experiment is observational, not an exact test.

</details>

## Your solution

Keep your Java implementation and executable checks in `src/`. Optionally add a short algorithm explanation in `src/README.md`. Record the attempt in [PROGRESS.md](../../../../PROGRESS.md).

---

<!-- study-navigation -->
[← Previous: Exercise 22.02](../02_modular-exponentiation/README.md) · [Index](../README.md) · [Next: Exercise 22.04 →](../04_exact-shuffle-probabilities/README.md)
<!-- /study-navigation -->
