# 22.02 - Modular Exponentiation

<!-- study-navigation -->
[← Previous: Exercise 22.01](../01_two-singleton-values/README.md) · [Index](../README.md) · [Next: Exercise 22.03 →](../03_reservoir-retention-proof/README.md)
<!-- /study-navigation -->

[Practice index](../../README.md) | Theory: [Bits, Number Theory, and Randomized Algorithms](../../../../01_algorithms/12_mathematics/22-bits-number-theory-and-randomness.md)

**Status:** Not started. This is a repository-written practice prompt, not a recruiting question-bank item.

## Exercise

Implement modular exponentiation with explicitly stated numeric bounds.

## Your workspace

Keep your implementation (for example, `Solution.java`) and your tests in this folder. For a proof, analysis, or counterexample task, write your answer in the solution section below; add code only when useful.

State the input/output contract, explain correctness, analyze time and space, and check boundary cases. Java helper fragments belong inside your own class with `import java.util.*;`.

<details><summary>Hints and checkpoints</summary>

The product of two residues must fit, or multiplication needs additional work.

### Java starting point

For this exercise, impose a numeric contract before choosing multiplication. When residues are in [0, modulus) and 1 <= modulus <= Integer.MAX_VALUE, their product fits in long.

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

**Complete the reasoning:** Use this in repeated squaring with a nonnegative exponent. Initialize the result to 1 % modulus; modulus 1 is a useful boundary case.

</details>

## Your solution

Add your approach, correctness argument, complexity analysis, and test results after attempting the exercise. Record the attempt in [PROGRESS.md](../../../../PROGRESS.md).

---

<!-- study-navigation -->
[← Previous: Exercise 22.01](../01_two-singleton-values/README.md) · [Index](../README.md) · [Next: Exercise 22.03 →](../03_reservoir-retention-proof/README.md)
<!-- /study-navigation -->
