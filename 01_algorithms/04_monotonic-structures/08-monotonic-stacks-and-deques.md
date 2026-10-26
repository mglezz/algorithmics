# 08B - Monotonic Stacks and Deques

<!-- study-navigation -->
[← Previous: Unit 08A](../../02_data-structures/04_stacks-and-queues/08-stacks-and-queues.md) · [Index](../../README.md#study-index) · [Next: Unit 09 →](../05_searching/09-binary-search.md)
<!-- /study-navigation -->

[Curriculum](../../CURRICULUM.md) | [Quick reference](../../04_notes/patterns.md) | [Companion chapter](../../02_data-structures/04_stacks-and-queues/08-stacks-and-queues.md)

> **Core idea:** The order of stored candidates determines which work can be processed or discarded safely.

## On this page

- [Monotonic stacks: unresolved candidates](#monotonic-stacks-unresolved-candidates)
- [Worked visual](#worked-visual)
- [Monotonic deques: useful and unexpired candidates](#monotonic-deques-useful-and-unexpired-candidates)
- [Harder application: shortest threshold sum with negatives](#harder-application-shortest-threshold-sum-with-negatives)
- [Practice](#practice)
- [Attribution and references](#attribution-and-references)

## Monotonic stacks: unresolved candidates

To find the next strictly greater value to the right, scan left to right with a stack of unresolved indices. While the current value exceeds the value at the top index, pop that index and assign the current position as its answer. Then push the current index.

Why the answer is nearest: the index stayed unresolved through every intervening value; the current value is the first qualifying one. The stack values are nonincreasing when equal values remain. Every index is pushed once and popped at most once, giving `O(n)` time and `O(n)` space.

Strict versus non-strict comparisons determine duplicate behavior. “Next greater” and “next greater or equal” need different pop rules. Store indices when distance, expiration, or ties matter.

For the largest rectangle in a histogram, a popped bar supplies a limiting height; its right boundary is the first smaller bar and its left boundary comes from the remaining stack. A final sentinel flushes unresolved bars. Equal-height conventions must be consistent when computing widths. Use long for height times width.

## Worked visual

| Incoming value | Unresolved stack after processing | Answers resolved |
|---|---|---|
| 2 | [2] | None |
| 1 | [2,1] | None |
| 3 | [3] | 1 -> 3 and 2 -> 3 |

For next strictly greater values, equal entries remain unresolved. Each index is pushed once and popped at most once.

## Monotonic deques: useful and unexpired candidates

For sliding-window maximum, keep indices in increasing order, with corresponding values decreasing. At each new index:

```text
remove front indices outside the current window
remove back indices whose values are <= the incoming value
append the incoming index
once a full window exists, its maximum is at the front
```

Removing a dominated index is safe: the newer value is at least as large and expires later, so the old candidate can never win a future window containing both. Each index enters and leaves once; total time is `O(n)`, auxiliary space `O(k)` for window size `k`. A heap with lazy expiration may retain stale entries away from its top and use `O(n)` space unless additional cleanup is implemented.

## Harder application: shortest threshold sum with negatives

Let `P[j]` be prefix sums. For each endpoint `j`, maintain prior indices with strictly increasing prefixes. While `P[j]-P[front]>=K`, update the shortest length and pop the front: future endpoints would only make that same start produce a longer range. While `P[j]<=P[back]`, pop the back: the newer prefix is no larger, so it makes future sums at least as large and lengths shorter. Append `j`.

For positive `K`, this finds the shortest nonempty range even with negative values in `O(n)` time and space. It combines two different reasons for deletion: an answered candidate cannot improve later, and a dominated candidate cannot outperform its replacement. Perform these operations with well-defined ordering and wide prefix arithmetic.

## Practice

Attempt the [unit 08 exercise set](../../03_problems/02_practice/08-stacks-queues-and-monotonic-structures.md). Exercises and hints live in `03_problems/`; this chapter contains the theory.

## Attribution and references

**Provenance:** This chapter is a synthesis of the sources mapped below. Standard definitions, algorithms and proof techniques belong to those established references; the explanatory wording, traces, diagrams and Java examples were written for this repository. No source passage is quoted verbatim.

| Section / claim | Source used | How it is used |
|---|---|---|
| Monotonic scan techniques | [Antti Laaksonen, Competitive Programmer's Handbook (2018 draft)](https://cses.fi/book/book.pdf) | Amortized-analysis chapter; sliding minimum and nearest-smaller ideas. |
| Java deque behavior | [Oracle Java 21: ArrayDeque](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/ArrayDeque.html) | Endpoint costs and null restrictions. |

See [SOURCES.md](../../SOURCES.md) for editions, review scope, and the distinction between consulted material and further reading.

---

<!-- study-navigation -->
[← Previous: Unit 08A](../../02_data-structures/04_stacks-and-queues/08-stacks-and-queues.md) · [Index](../../README.md#study-index) · [Next: Unit 09 →](../05_searching/09-binary-search.md)
<!-- /study-navigation -->
