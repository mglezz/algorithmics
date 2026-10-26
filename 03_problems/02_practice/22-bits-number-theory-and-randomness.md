# 22 - Bits, Number Theory, and Randomized Algorithms

<!-- study-navigation -->
[← Previous: Unit 21](21-range-query-data-structures.md) · [Index](README.md) · [Next: Unit 23 →](23-advanced-graphs-and-flow.md)
<!-- /study-navigation -->

[Practice index](README.md) | Theory: [Bits, Number Theory, and Randomized Algorithms](../../01_algorithms/12_mathematics/22-bits-number-theory-and-randomness.md)

**Status:** Suggested practice; no solution or completion is implied. These prompts and hints were written for this repository, not copied from a recruiting question bank.

## Your deliverable

Write a specification, your solution, a correctness argument, time/space analysis, and tests. Record independent attempts in [PROGRESS.md](../../PROGRESS.md).

## Exercises

1. Find the two singleton values when all others occur twice, using one differing XOR bit.
2. Implement modular exponentiation with explicitly stated numeric bounds.
3. Prove the reservoir retention probability for an item already stored.
4. Enumerate all permutations for a tiny shuffle and compare exact outcome counts for correct and biased procedures.

<details><summary>Hints and checkpoints</summary>

1. XOR all entries; use a set bit to partition them, then XOR within each group.
2. The product of two residues must fit, or multiplication needs additional work.
3. An old item survives step t with probability `1-1/t` for a size-one reservoir.
4. Exhaustive enumeration of random-choice paths is stronger than a few empirical histograms for tiny n.

### Java starting point

For exercise 2, impose a numeric contract before choosing multiplication. When residues are in [0, modulus) and 1 <= modulus <= Integer.MAX_VALUE, their product fits in long.

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

---

<!-- study-navigation -->
[← Previous: Unit 21](21-range-query-data-structures.md) · [Index](README.md) · [Next: Unit 23 →](23-advanced-graphs-and-flow.md)
<!-- /study-navigation -->
