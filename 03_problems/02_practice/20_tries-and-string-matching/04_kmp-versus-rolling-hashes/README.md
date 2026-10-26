# 20.04 - KMP versus Rolling Hashes

<!-- study-navigation -->
[← Previous: Exercise 20.03](../03_shortest-repeating-period/README.md) · [Index](../README.md) · [Next: Exercise 21.01 →](../../21_range-query-data-structures/01_fenwick-inversion-counting/README.md)
<!-- /study-navigation -->

[Practice index](../../README.md) | Theory: [Tries](../../../../02_data-structures/09_tries/20-tries.md) | [String Matching](../../../../01_algorithms/11_strings/20-string-matching.md)

**Status:** Not started. This is a repository-written practice prompt, not a recruiting question-bank item.

## Exercise

Explain the tradeoff between KMP's deterministic guarantee and hash-based substring comparison.

## Your workspace

Keep your implementation (for example, `Solution.java`) and your tests in this folder. For a proof, analysis, or counterexample task, write your answer in the solution section below; add code only when useful.

State the input/output contract, explain correctness, analyze time and space, and check boundary cases. Java helper fragments belong inside your own class with `import java.util.*;`.

<details><summary>Hints and checkpoints</summary>

Hash equality needs collision handling; KMP compares actual symbols and reuses border structure.

</details>

## Your solution

Add your approach, correctness argument, complexity analysis, and test results after attempting the exercise. Record the attempt in [PROGRESS.md](../../../../PROGRESS.md).

---

<!-- study-navigation -->
[← Previous: Exercise 20.03](../03_shortest-repeating-period/README.md) · [Index](../README.md) · [Next: Exercise 21.01 →](../../21_range-query-data-structures/01_fenwick-inversion-counting/README.md)
<!-- /study-navigation -->
