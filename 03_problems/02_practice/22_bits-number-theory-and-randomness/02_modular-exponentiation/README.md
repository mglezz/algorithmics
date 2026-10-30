# 22.02 - Modular Exponentiation

<!-- study-navigation -->
[← Previous: Exercise 22.01](../01_two-singleton-values/README.md) · [Index](../README.md) · [Next: Exercise 22.03 →](../03_reservoir-retention-proof/README.md)
<!-- /study-navigation -->

[Practice index](../../README.md) | Theory: [Bits, Number Theory, and Randomized Algorithms](../../../../01_algorithms/12_mathematics/22-bits-number-theory-and-randomness.md)

**Status:** Not started. This is a repository-written practice prompt, not a recruiting question-bank item.

## Exercise

Implement `long modPow(long base, long exponent, int modulus)` for exponent>=0 and `1<=modulus<=Integer.MAX_VALUE`. Return the normalized residue of base raised to exponent. Use repeated squaring, supporting negative bases and avoiding overflowing products.

## Examples and checks

`2,10,1000` returns 24; `-2,3,5` returns 2; exponent zero returns `1 % modulus`; modulus 1 returns 0.

## Your workspace

Write your Java 17 implementation and an executable test runner in `src/`. Use `AlgorithmXX_YY.java` and `MainXX_YY.java` with this exercise's numbers, or keep the existing class names. For data-structure exercises, use the requested class and a separate runner. Compare actual and expected results, including the cases above; throw `AssertionError` on a mismatch (or run Java assertions with `-ea`).

The deliverable is working Java code and checks. You may add a short explanation of the algorithm in `src/README.md`, like exercise 02.01; a formal proof or a separate theoretical answer is not required. Unless stated otherwise, inputs are non-null, indices and graph endpoints are valid, and auxiliary result types such as `Node` or `Selection` are yours to define.

<details><summary>Implementation hint</summary>

Normalize the base before multiplication; two residues within these bounds have a product that fits in long.

### Java helper

Optional helper members for your class; add the necessary imports from java.util. Complete the public API and tests described above.

<!-- java-hint -->
```java
static long multiplyResidues(long a, long b, int modulus) {
    if (modulus <= 0 || a < 0 || a >= modulus || b < 0 || b >= modulus) {
        throw new IllegalArgumentException("Invalid residue or modulus");
    }
    return (a * b) % modulus;
}
```
<!-- /java-hint -->

</details>

## Your solution

Keep your Java implementation and executable checks in `src/`. Optionally add a short algorithm explanation in `src/README.md`. Record the attempt in [PROGRESS.md](../../../../PROGRESS.md).

---

<!-- study-navigation -->
[← Previous: Exercise 22.01](../01_two-singleton-values/README.md) · [Index](../README.md) · [Next: Exercise 22.03 →](../03_reservoir-retention-proof/README.md)
<!-- /study-navigation -->
