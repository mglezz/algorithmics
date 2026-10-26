# 25.09 - Versioned Service Costs

<!-- study-navigation -->
[← Previous: Exercise 25.08](../08_dynamic-range-sums/README.md) · [Index](../README.md) · [Next: Unit index →](../README.md)
<!-- /study-navigation -->

[Practice index](../../README.md) | Theory: [Solving, Testing, and Communicating](../../../../01_algorithms/14_problem-solving/25-solving-testing-and-communication.md)

**Status:** Not started. This is a repository-written practice prompt, not a recruiting question-bank item.

## Exercise

Maintain versioned service-cost arrays and query an old version's range total

**Stage:** Synthesis.

**Required follow-up:** Explain persistence, sharing, and memory growth

## Your workspace

Keep your implementation (for example, `Solution.java`) and your tests in this folder. For a proof, analysis, or counterexample task, write your answer in the solution section below; add code only when useful.

State the input/output contract, explain correctness, analyze time and space, and check boundary cases. Java helper fragments belong inside your own class with `import java.util.*;`.

<details><summary>Hints and checkpoints</summary>

### Java starting point

For this exercise, start with immutable nodes so that unchanged subtrees can be shared across versions. A leaf has null children. This representation does not yet perform queries or updates.

<!-- java-hint -->
```java
static final class SumNode {
    final long sum;
    final SumNode left;
    final SumNode right;

    SumNode(long sum, SumNode left, SumNode right) {
        this.sum = sum;
        this.left = left;
        this.right = right;
    }
}
```
<!-- /java-hint -->

**Complete the reasoning:** Implement an update by allocating nodes on one root-to-leaf path and retaining untouched children. Keep every version root and test that an update leaves old queries unchanged.

</details>

## Your solution

Add your approach, correctness argument, complexity analysis, and test results after attempting the exercise. Record the attempt in [PROGRESS.md](../../../../PROGRESS.md).

---

<!-- study-navigation -->
[← Previous: Exercise 25.08](../08_dynamic-range-sums/README.md) · [Index](../README.md) · [Next: Unit index →](../README.md)
<!-- /study-navigation -->
