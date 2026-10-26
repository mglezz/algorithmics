# 09 - Binary Search and Monotone Decisions

<!-- study-navigation -->
[← Previous: Unit 08B](../04_monotonic-structures/08-monotonic-stacks-and-deques.md) · [Index](../../README.md#study-index) · [Next: Unit 10 →](../06_sorting/10-sorting-and-selection.md)
<!-- /study-navigation -->

[Curriculum](../../CURRICULUM.md) | [Quick reference](../../04_notes/patterns.md)

> **Core idea:** Binary search locates a boundary in a monotone predicate while preserving a shrinking interval.

## On this page

- [Search a boundary, not just a value](#search-a-boundary-not-just-a-value)
- [Worked visual](#worked-visual)
- [Binary search on the answer](#binary-search-on-the-answer)
- [Variations and pitfalls](#variations-and-pitfalls)
- [Explain it in English](#explain-it-in-english)
- [Practice](#practice)
- [Attribution and references](#attribution-and-references)

## Search a boundary, not just a value

Binary search finds the boundary between a false prefix and a true suffix of a monotone predicate. A sorted array is one example: `a[i]>=target` becomes true once and remains true. The central design work is specifying that predicate and proving it is monotone.

For **lower bound**, return the first index whose value is at least the target, or `n` if none exists. For **upper bound**, return the first index whose value is strictly greater. Their difference counts target occurrences. A lower bound is an insertion point; check both `index<n` and equality before calling it a successful lookup.

```java
static int lowerBound(int[] values, int target) {
    int low = 0;
    int high = values.length;
    while (low < high) {
        int middle = low + (high - low) / 2;
        if (values[middle] < target) {
            low = middle + 1;
        } else {
            high = middle;
        }
    }
    return low;
}
```

Contract: nonnull array sorted in nondecreasing order; no mutation. The invariant is that every index before `low` has value below the target, and every valid index at or after `high` has value at least the target. The unknown region is `[low,high)`. If the midpoint is too small, it cannot be the answer; otherwise it remains a possible answer. Each branch shortens the interval, so the loop terminates. At exit the two classified regions meet at exactly the lower bound.

For `[2,4,4,8]` and target `4`, `(low,high)` moves `(0,4)->(0,2)->(0,1)->(1,1)` and returns one. Empty input returns zero. Time is `O(log(n+1))`; auxiliary space is constant. The midpoint expression is safe for nonnegative array indices; do not assume it prevents every possible overflow for arbitrary signed numeric endpoints.

## Worked visual

| low | high (exclusive) | middle | Decision for target 4 in [2,4,4,8] |
|---|---|---|---|
| 0 | 4 | 2 | 4 is large enough: high = 2 |
| 0 | 2 | 1 | 4 is large enough: high = 1 |
| 0 | 1 | 0 | 2 is too small: low = 1 |
| 1 | 1 | - | Stop; first qualifying index is 1 |

## Binary search on the answer

Suppose ordered positive job sizes must be partitioned into at most `k>=1` contiguous groups, minimizing the largest group sum. For a capacity `C`, greedily fill each group until the next job would exceed `C`, then start another. Reject if a single job exceeds `C` or more than `k` groups are needed.

This feasibility check is correct because each greedy group ends as late as possible under the capacity. Any feasible partition's first group ends no later; repeating the argument shows greedy uses no more groups than necessary. If capacity `C` works, every larger capacity works: the decision predicate is monotone.

For nonempty input, search integer capacities from `max(job)` to `sum(job)` using long arithmetic. Each check is `O(n)`, so total cost is `O(n log(sum-max+1))`. The answer domain, not the number of jobs, determines the logarithm. Requiring exactly `k` nonempty groups needs `k<=n`; with positive jobs, a feasible solution with fewer groups can be split without increasing the maximum.

## Variations and pitfalls

- **Rotated sorted array:** determine which side is sorted before discarding a region. Duplicates can remove distinguishing information and lead to linear worst-case time.
- **Peak finding:** a comparison with a neighbor can identify a side containing a peak under an appropriate peak definition; this is not ordinary target lookup.
- **Exponential search:** when a searchable sequence's bound is unknown, double the boundary until it brackets the answer, then binary search. Handle overflow and finite-end detection.
- **Continuous answers:** use a justified error tolerance or fixed iteration budget and stable arithmetic. Equality comparisons of floating-point values are not a termination strategy.
- **Expensive predicates:** include their time and space; a binary-search loop is not automatically logarithmic overall.

Never combine updates from different interval conventions. For a closed `[low,high]` interval, termination and updates differ from the half-open version above. Explain what both boundaries mean before writing code.

## Explain it in English

> “The answer remains inside my candidate interval, and each iteration strictly reduces that interval.”

**Vocabulary:** lower bound, upper bound, predicate, insertion point, feasibility.

## Practice

Attempt the [unit 09 exercise set](../../03_problems/02_practice/09-binary-search.md). Exercises and hints live in `03_problems/`; this chapter contains the theory.

## Attribution and references

**Provenance:** This chapter is a synthesis of the sources mapped below. Standard definitions, algorithms and proof techniques belong to those established references; the explanatory wording, traces, diagrams and Java examples were written for this repository. No source passage is quoted verbatim.

| Section / claim | Source used | How it is used |
|---|---|---|
| Binary-search boundaries | [Antti Laaksonen, Competitive Programmer's Handbook (2018 draft)](https://cses.fi/book/book.pdf) | Section 3.3, Binary search; standard technique. |
| Loop proof framework | [Demaine, Ku and Solomon, MIT 6.006 (Spring 2020)](https://ocw.mit.edu/courses/6-006-introduction-to-algorithms-spring-2020/pages/lecture-notes/) | Lecture 1; the half-open invariant and capacity-search proof are written here. |

See [SOURCES.md](../../SOURCES.md) for editions, review scope, and the distinction between consulted material and further reading.

---

<!-- study-navigation -->
[← Previous: Unit 08B](../04_monotonic-structures/08-monotonic-stacks-and-deques.md) · [Index](../../README.md#study-index) · [Next: Unit 10 →](../06_sorting/10-sorting-and-selection.md)
<!-- /study-navigation -->
