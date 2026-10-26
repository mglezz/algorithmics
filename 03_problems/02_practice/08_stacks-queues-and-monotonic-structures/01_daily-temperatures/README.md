# 08.01 - Daily Temperatures

<!-- study-navigation -->
[← Previous: Exercise 07.04](../../07_linked-lists/04_lru-cache/README.md) · [Index](../README.md) · [Next: Exercise 08.02 →](../02_sliding-maximum/README.md)
<!-- /study-navigation -->

[Practice index](../../README.md) | Theory: [Stacks and Queues](../../../../02_data-structures/04_stacks-and-queues/08-stacks-and-queues.md) | [Monotonic Stacks and Deques](../../../../01_algorithms/04_monotonic-structures/08-monotonic-stacks-and-deques.md)

**Status:** Not started. This is a repository-written practice prompt, not a recruiting question-bank item.

## Exercise

Compute daily waiting times for a strictly warmer temperature.

## Your workspace

Keep your implementation (for example, `Solution.java`) and your tests in this folder. For a proof, analysis, or counterexample task, write your answer in the solution section below; add code only when useful.

State the input/output contract, explain correctness, analyze time and space, and check boundary cases. Java helper fragments belong inside your own class with `import java.util.*;`.

<details><summary>Hints and checkpoints</summary>

Use unresolved indices; equal temperatures do not resolve each other.

### Java starting point

For this exercise, pending holds indices whose answer is still unknown, with nonincreasing temperatures from bottom to top. Call this helper for each index in increasing order. A zero-initialized waiting array preserves zero for days with no warmer successor.

<!-- java-hint -->
```java
static void acceptDay(int[] temperature, int day,
                      Deque<Integer> pending, int[] waiting) {
    while (!pending.isEmpty() && temperature[pending.peek()] < temperature[day]) {
        int earlier = pending.pop();
        waiting[earlier] = day - earlier;
    }
    pending.push(day);
}
```
<!-- /java-hint -->

**Complete the reasoning:** Why is the comparison strict? Complete the outer scan and prove that every index is pushed and popped at most once.

</details>

## Your solution

Add your approach, correctness argument, complexity analysis, and test results after attempting the exercise. Record the attempt in [PROGRESS.md](../../../../PROGRESS.md).

---

<!-- study-navigation -->
[← Previous: Exercise 07.04](../../07_linked-lists/04_lru-cache/README.md) · [Index](../README.md) · [Next: Exercise 08.02 →](../02_sliding-maximum/README.md)
<!-- /study-navigation -->
