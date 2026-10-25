# 08 - Stacks, Queues, and Monotonic Structures

[Curriculum](README.md) | Prerequisites: 04, 07

## Order is part of the abstraction

A stack is last-in, first-out; it represents suspended work, nesting, and reversible choices. A queue is first-in, first-out; it represents arrival order and graph frontiers. A deque supports both ends. These behaviors do not require linked nodes: arrays and circular buffers are often appropriate.

A circular queue stores a head index and size (or another unambiguous empty/full convention). Logical position `i` maps to `(head+i) mod capacity`. Reusing departed slots avoids shifting an entire array on each dequeue. A bounded queue must define what happens when full; a resizable queue needs an amortized analysis.

Use Java `ArrayDeque` for ordinary stacks and queues. Its endpoint operations are amortized constant time; searching for and removing an arbitrary value is linear. Do not enqueue null or rely on iterators as a sorted traversal.

## Stack invariants

For bracket validation, the stack contains unmatched opening brackets in order. A closing bracket must match the latest opening bracket; a mismatch or empty stack rejects immediately. At the end, acceptance requires an empty stack. Counting opening and closing brackets alone cannot reject `([)]`.

A minimum stack can store `(value,minimumSoFar)` in each entry. Alternatively keep a second stack of minima, retaining duplicate minima or counts so popping one equal minimum does not lose another. All operations are constant time, with linear total space.

Two stacks implement a queue: enqueue into an input stack; dequeue from an output stack; transfer all input entries only when output is empty. An item moves at most once between stacks, proving amortized constant operations. Transferring before every dequeue would destroy that bound.

## Monotonic stacks: unresolved candidates

To find the next strictly greater value to the right, scan left to right with a stack of unresolved indices. While the current value exceeds the value at the top index, pop that index and assign the current position as its answer. Then push the current index.

Why the answer is nearest: the index stayed unresolved through every intervening value; the current value is the first qualifying one. The stack values are nonincreasing when equal values remain. Every index is pushed once and popped at most once, giving `O(n)` time and `O(n)` space.

Strict versus non-strict comparisons determine duplicate behavior. “Next greater” and “next greater or equal” need different pop rules. Store indices when distance, expiration, or ties matter.

For the largest rectangle in a histogram, a popped bar supplies a limiting height; its right boundary is the first smaller bar and its left boundary comes from the remaining stack. A final sentinel flushes unresolved bars. Equal-height conventions must be consistent when computing widths. Use long for height times width.

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

1. Compute daily waiting times for a strictly warmer temperature.
2. Return each length-`k` sliding maximum and compare with brute-force scanning.
3. Implement a queue from two stacks and count all item transfers over a long operation sequence.
4. Solve the histogram rectangle problem with repeated heights and zero-height separators.

<details><summary>Hints and checkpoints</summary>

1. Use unresolved indices; equal temperatures do not resolve each other.
2. Test `k=1`, `k=n`, increasing, decreasing, and all-equal arrays.
3. A transfer is charged to the earlier enqueue of that same item.
4. Test `[2,2]`, `[2,0,2]`, and an increasing sequence that only resolves during the flush.

</details>

**Explain aloud:** “This candidate is dominated by a newer one that is at least as good and remains valid longer.” Vocabulary: frontier, nesting, unresolved, domination, expiration, amortized.

## Sources

- [Open Data Structures, Array-Based Lists](https://opendatastructures.org/ods-java/2_Array_Based_Lists.html): array queues, deques, and amortization.
- [Oracle ArrayDeque](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/ArrayDeque.html): Java operation contracts. The monotonic-structure applications above include their own safety and aggregate-work arguments.
