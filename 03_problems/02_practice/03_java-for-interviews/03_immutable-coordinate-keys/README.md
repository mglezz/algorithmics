# 03.03 - Immutable Coordinate Keys

<!-- study-navigation -->
[← Previous: Exercise 03.02](../02_max-heap-snapshot/README.md) · [Index](../README.md) · [Next: Exercise 03.04 →](../04_dependency-trace-complexity/README.md)
<!-- /study-navigation -->

[Practice index](../../README.md) | Theory: [Java for Algorithmic Interviews](../../../../01_algorithms/01_foundations/03-java-for-interviews.md)

**Status:** Not started. This is a repository-written practice prompt, not a recruiting question-bank item.

## Exercise

Design an immutable coordinate key with correct equality.

## Your workspace

Keep your implementation (for example, `Solution.java`) and your tests in this folder. For a proof, analysis, or counterexample task, write your answer in the solution section below; add code only when useful.

State the input/output contract, explain correctness, analyze time and space, and check boundary cases. Java helper fragments belong inside your own class with `import java.util.*;`.

<details><summary>Hints and checkpoints</summary>

A record with two int components has suitable value semantics; an `int[]` does not.

### Java starting point

Use a record with primitive components for an immutable coordinate key with value equality.

<!-- java-hint -->
```java
record Point(int row, int column) {}
```
<!-- /java-hint -->

**Complete the reasoning:** Compare two separately constructed keys with equal coordinates. Explain why equality and hash codes must agree.

</details>

## Your solution

Add your approach, correctness argument, complexity analysis, and test results after attempting the exercise. Record the attempt in [PROGRESS.md](../../../../PROGRESS.md).

---

<!-- study-navigation -->
[← Previous: Exercise 03.02](../02_max-heap-snapshot/README.md) · [Index](../README.md) · [Next: Exercise 03.04 →](../04_dependency-trace-complexity/README.md)
<!-- /study-navigation -->
