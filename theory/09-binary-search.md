# 09 - Binary Search and Monotone Decisions

[Curriculum](README.md) | Prerequisites: 01-04

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

## Practice

1. Implement upper bound and derive the occurrence count.
2. Find the integer square root of a nonnegative long without overflowing a square.
3. Minimize the largest contiguous group sum and prove feasibility monotonicity.
4. Construct an input on which duplicate values make rotated-array search ambiguous.

<details><summary>Hints and checkpoints</summary>

1. Change the predicate to `value>target`; test absent and repeated targets.
2. Compare `middle <= value/middle` for positive middle; handle zero separately and choose safe boundaries.
3. Separate the greedy correctness proof from the monotonicity proof.
4. Compare cases such as `[1,1,1,0,1]`; equal endpoints may force cautious shrinking.

</details>

**Explain aloud:** “The answer remains inside my candidate interval, and each iteration strictly reduces that interval.” Vocabulary: lower bound, upper bound, predicate, insertion point, feasibility.

## Sources

- [Open Data Structures, Sorting Algorithms](https://opendatastructures.org/ods-java/11_Sorting_Algorithms.html): ordered data and comparison-based reasoning.
- [MIT 6.006 lecture notes](https://ocw.mit.edu/courses/6-006-introduction-to-algorithms-spring-2020/pages/lecture-notes/), lecture 3: binary search on sorted arrays.

The partition-capacity example includes both proofs needed to justify searching its answer space.
