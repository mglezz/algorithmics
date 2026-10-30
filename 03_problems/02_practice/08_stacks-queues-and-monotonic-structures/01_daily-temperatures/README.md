# 08.01 - Daily Temperatures

<!-- study-navigation -->
[← Previous: Exercise 07.04](../../07_linked-lists/04_lru-cache/README.md) · [Index](../README.md) · [Next: Exercise 08.02 →](../02_sliding-maximum/README.md)
<!-- /study-navigation -->

[Practice index](../../README.md) | Theory: [Stacks and Queues](../../../../02_data-structures/04_stacks-and-queues/08-stacks-and-queues.md) | [Monotonic Stacks and Deques](../../../../01_algorithms/04_monotonic-structures/08-monotonic-stacks-and-deques.md)

**Status:** Not started. This is a repository-written practice prompt, not a recruiting question-bank item.

## Exercise

Implement `int[] dailyTemperatures(int[] temperatures)` returning days until the next strictly warmer day, or zero when none exists. Use a stack of indices and O(n) time.

## Examples and checks

`[73,74,75,71,69,72,76,73]` returns `[1,1,4,2,1,1,0,0]`; equal temperatures return zeros.

## Your workspace

Write your Java 17 implementation and an executable test runner in `src/`. Use `AlgorithmXX_YY.java` and `MainXX_YY.java` with this exercise's numbers, or keep the existing class names. For data-structure exercises, use the requested class and a separate runner. Compare actual and expected results, including the cases above; throw `AssertionError` on a mismatch (or run Java assertions with `-ea`).

The deliverable is working Java code and checks. You may add a short explanation of the algorithm in `src/README.md`, like exercise 02.01; a formal proof or a separate theoretical answer is not required. Unless stated otherwise, inputs are non-null, indices and graph endpoints are valid, and auxiliary result types such as `Node` or `Selection` are yours to define.

<details><summary>Implementation hint</summary>

Keep unresolved days on a stack; the helper below handles one incoming day.

### Java helper

Optional helper members for your class; add the necessary imports from java.util. Complete the public API and tests described above.

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

</details>

## Your solution

Keep your Java implementation and executable checks in `src/`. Optionally add a short algorithm explanation in `src/README.md`. Record the attempt in [PROGRESS.md](../../../../PROGRESS.md).

---

<!-- study-navigation -->
[← Previous: Exercise 07.04](../../07_linked-lists/04_lru-cache/README.md) · [Index](../README.md) · [Next: Exercise 08.02 →](../02_sliding-maximum/README.md)
<!-- /study-navigation -->
