# 06 - Two Pointers and Sliding Windows

<!-- study-navigation -->
[← Previous: Unit 05](../../02_data-structures/02_hash-tables/05-hash-tables.md) · [Index](../../README.md#study-index) · [Next: Unit 07 →](../../02_data-structures/03_linked-lists/07-linked-lists.md)
<!-- /study-navigation -->

[Curriculum](../../CURRICULUM.md) | [Quick reference](../../04_notes/patterns.md)

> **Core idea:** Move a boundary only when every discarded candidate is provably irrelevant.

## On this page

- [The proof is about what can be discarded](#the-proof-is-about-what-can-be-discarded)
- [Worked visual](#worked-visual)
- [Opposite ends: pair sum in a sorted array](#opposite-ends-pair-sum-in-a-sorted-array)
- [Fixed windows](#fixed-windows)
- [Variable windows](#variable-windows)
- [Worked example: shortest sum reaching a positive target](#worked-example-shortest-sum-reaching-a-positive-target)
- [Choosing between nearby techniques](#choosing-between-nearby-techniques)
- [Explain it in English](#explain-it-in-english)
- [Practice](#practice)
- [Attribution and references](#attribution-and-references)

## The proof is about what can be discarded

Two pointers are a way of maintaining boundaries or positions. Their movement becomes an algorithm only when a monotonicity or dominance argument proves that skipped candidates cannot improve the answer. Nested syntax does not determine complexity: if each pointer advances at most `n` times, the total movement is linear.

## Worked visual

| Right index | Window reaching target 7 | Consequence |
|---|---|---|
| 0 | [2], sum 2 | Expand |
| 1 | [2,1], sum 3 | Expand |
| 2 | [2,1,5], sum 8 | Record length 3; remove 2 |
| 3 | [1,5,2], sum 8 | Remove 1, then record [5,2] with length 2 |

## Opposite ends: pair sum in a sorted array

With `left<right`, compare `a[left]+a[right]` to the target using a wide enough type. If the sum is too small, every pair using that left value and a no-larger right value is also too small; discard `left`. If the sum is too large, every pair using that right value and a no-smaller left value is too large; discard `right`.

The invariant is that any still-possible pair lies inside the remaining interval. Termination occurs when fewer than two positions remain. This uses `O(n)` time and `O(1)` auxiliary space on sorted input. If you sort first, include `O(n log n)` time and preserve original indices if required. The argument fails for an arbitrary unsorted array.

Other applications include merging sorted sequences, removing duplicates, and checking palindromes under an explicit character-normalization policy. The movement rules differ; do not carry the pair-sum proof into unrelated problems.

## Fixed windows

For every length-`k` subarray sum, maintain the current sum, add the incoming value, and subtract the outgoing value. Validate `1<=k<=n` or define another contract. After initialization, each move is constant time, for `O(n)` total time and `O(1)` auxiliary space.

If the aggregate is not invertible, removal may require more information. A maximum cannot be updated simply by subtracting the departed element; use a monotonic deque or another structure.

## Variable windows

For the longest substring with no repeated code unit, expand the right endpoint, add the new character to counts, and shrink from the left until all counts are at most one. Every valid candidate ending at the current right boundary is considered through the longest valid window there.

The essential property is hereditary validity: removing elements cannot introduce a duplicate. Once a left boundary has been ruled out by a duplicate, extending right cannot make that same boundary valid again until the duplicate is removed. Counts and last-seen indices are two different ways to preserve this information.

For “at most `k` distinct values,” after shrinking, every suffix of the valid window is valid. Therefore there are `right-left+1` valid nonempty ranges ending at that position. Counting exactly `k` can be reduced to `atMost(k)-atMost(k-1)`, with `atMost(negative)=0`.

## Worked example: shortest sum reaching a positive target

```java
static int shortestAtLeast(int[] values, long target) {
    if (target <= 0) throw new IllegalArgumentException("Target must be positive");
    for (int value : values) {
        if (value < 0) throw new IllegalArgumentException("Values must be nonnegative");
    }
    int left = 0;
    int best = Integer.MAX_VALUE;
    long sum = 0;
    for (int right = 0; right < values.length; right++) {
        sum += values[right];
        while (sum >= target) {
            best = Math.min(best, right - left + 1);
            sum -= values[left++];
        }
    }
    return best == Integer.MAX_VALUE ? 0 : best;
}
```

Contract: nonnull, nonnegative int array; positive target; return zero if no nonempty range qualifies. For `[2,1,5,2]` and target `7`, the answer is two, from `[5,2]`. While a window qualifies, removing its leftmost value cannot increase its sum. Once it fails, removing more cannot restore validity. A left boundary discarded after producing a valid window cannot yield a shorter answer at a later right endpoint.

Both boundaries move at most `n` times: `O(n)` time, including validation, and `O(1)` auxiliary space. With negative numbers, the monotonicity fails. For `[1,-1,5]` and target `5`, the simple method can miss the single-element answer. Use prefix sums with a monotonic deque for that harder variant; see unit 08.

## Choosing between nearby techniques

| Problem property | Candidate |
|---|---|
| Sorted values; safely discard an endpoint | Two pointers |
| Contiguous range; removable state; monotone validity | Sliding window |
| Exact sum with arbitrary signs | Prefix sums plus a frequency map |
| Shortest sum threshold with arbitrary signs | Prefix sums plus a monotonic deque |
| Independent arbitrary interval queries | Prefix preprocessing or range-query structure |

## Explain it in English

> “Advancing this boundary discards only candidates that cannot improve the answer.”

**Vocabulary:** window, endpoint, monotone, feasible, multiplicity, discard.

## Practice

Attempt the [unit 06 exercise set](../../03_problems/02_practice/06_two-pointers-and-sliding-windows/README.md). Exercises and hints live in `03_problems/`; this chapter contains the theory.

## Attribution and references

**Provenance:** This chapter is a synthesis of the sources mapped below. Standard definitions, algorithms and proof techniques belong to those established references; the explanatory wording, traces, diagrams and Java examples were written for this repository. No source passage is quoted verbatim.

| Section / claim | Source used | How it is used |
|---|---|---|
| Two-pointer and sliding-window techniques | [Antti Laaksonen, Competitive Programmer's Handbook (2018 draft)](https://cses.fi/book/book.pdf) | Amortized-analysis chapter; two pointers and sliding windows. |
| Correctness arguments | [Demaine, Ku and Solomon, MIT 6.006 (Spring 2020)](https://ocw.mit.edu/courses/6-006-introduction-to-algorithms-spring-2020/pages/lecture-notes/) | Lecture 1 invariant framework; this chapter supplies its own elimination proofs. |

See [SOURCES.md](../../SOURCES.md) for editions, review scope, and the distinction between consulted material and further reading.

---

<!-- study-navigation -->
[← Previous: Unit 05](../../02_data-structures/02_hash-tables/05-hash-tables.md) · [Index](../../README.md#study-index) · [Next: Unit 07 →](../../02_data-structures/03_linked-lists/07-linked-lists.md)
<!-- /study-navigation -->
