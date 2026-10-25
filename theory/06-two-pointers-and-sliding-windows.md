# 06 - Two Pointers and Sliding Windows

[Curriculum](README.md) | Prerequisites: 04-05

## The proof is about what can be discarded

Two pointers are a way of maintaining boundaries or positions. Their movement becomes an algorithm only when a monotonicity or dominance argument proves that skipped candidates cannot improve the answer. Nested syntax does not determine complexity: if each pointer advances at most `n` times, the total movement is linear.

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

## Practice

1. Find the longest binary subarray after flipping at most `k` zeros, for `k>=0`.
2. Find the minimum window containing a target multiset of characters.
3. Count ranges containing exactly `k` distinct integers.
4. Construct a counterexample to a sum window when negatives are allowed.

<details><summary>Hints and checkpoints</summary>

1. Maintain zero count; shrink while it exceeds `k`.
2. Track required multiplicities and the number of satisfied requirements. Shrink only while all are met; clarify the empty-target result.
3. Subtract the two at-most counts; use long for the answer.
4. Explain the invalid elimination step, not just a wrong output.

</details>

**Explain aloud:** “Advancing this boundary discards only candidates that cannot improve the answer.” Vocabulary: window, endpoint, monotone, feasible, multiplicity, discard.

## Sources

- [MIT 6.006 course materials](https://ocw.mit.edu/courses/6-006-introduction-to-algorithms-spring-2020/pages/lecture-notes/): invariants and operation counting underpin the arguments here.
- [Open Data Structures, Array-Based Lists](https://opendatastructures.org/ods-java/2_Array_Based_Lists.html): sequence operations. The elimination and window proofs above are given explicitly rather than relying on a template catalogue.
