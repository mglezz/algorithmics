# 08 - Stacks, Queues, and Monotonic Structures

<!-- study-navigation -->
[← Previous: Unit 07](07-linked-lists.md) · [Index](README.md) · [Next: Unit 09 →](09-binary-search.md)
<!-- /study-navigation -->

[Practice index](README.md) | Theory: [Stacks and Queues](../../02_data-structures/04_stacks-and-queues/08-stacks-and-queues.md) | [Monotonic Stacks and Deques](../../01_algorithms/04_monotonic-structures/08-monotonic-stacks-and-deques.md)

**Status:** Suggested practice; no solution or completion is implied. These prompts and hints were written for this repository, not copied from a recruiting question bank.

## Your deliverable

Write a specification, your solution, a correctness argument, time/space analysis, and tests. Record independent attempts in [PROGRESS.md](../../PROGRESS.md).

## Exercises

1. Compute daily waiting times for a strictly warmer temperature.
2. Return each length-`k` sliding maximum and compare with brute-force scanning.
3. Implement a queue from two stacks and count all item transfers over a long operation sequence.
4. Solve the histogram rectangle problem with repeated heights and zero-height separators.

<details><summary>Hints and checkpoints</summary>

1. Use unresolved indices; equal temperatures do not resolve each other.
2. Test `k=1`, `k=n`, increasing, decreasing, and all-equal arrays.
3. A transfer is charged to the earlier enqueue of that same item.
4. Test `[2,2]`, `[2,0,2]`, and an increasing sequence that only resolves during the flush.

### Java starting point

For exercise 1, pending holds indices whose answer is still unknown, with nonincreasing temperatures from bottom to top. Call this helper for each index in increasing order. A zero-initialized waiting array preserves zero for days with no warmer successor.

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

---

<!-- study-navigation -->
[← Previous: Unit 07](07-linked-lists.md) · [Index](README.md) · [Next: Unit 09 →](09-binary-search.md)
<!-- /study-navigation -->
