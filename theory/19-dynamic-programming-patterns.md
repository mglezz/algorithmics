# 19 - Dynamic Programming Patterns and Reconstruction

[Curriculum](README.md) | Prerequisites: 12, 18

## Sequence alignment: two prefixes

For longest common subsequence, let `L[i][j]` be the LCS length of prefixes `a[0..i)` and `b[0..j)`. Empty-prefix rows and columns are zero. If the final symbols agree, use `1+L[i-1][j-1]`; otherwise use `max(L[i-1][j],L[i][j-1])`. In the mismatch case, a common subsequence cannot use both final symbols as its final matched pair, so at least one must be skipped. In the match case, there exists an optimum using that final matching pair, with an optimal smaller-prefix solution before it.

There are `(n+1)(m+1)` states with constant transition work: `O(nm)` time and table space. Rolling rows reduce value-only space to `O(min(n,m))`. To reconstruct, walk backward according to matching and skip choices; a full parent/table representation is simpler. Longest common **substring** requires contiguity, so its matching-suffix recurrence resets to zero on mismatch; it is not LCS.

For unit-cost edit distance, define `D[i][j]` as the cost to transform the first `i` symbols into the first `j` symbols. Initialize `D[i][0]=i` and `D[0][j]=j`. Take the minimum of deletion `D[i-1][j]+1`, insertion `D[i][j-1]+1`, and match/substitution `D[i-1][j-1]+cost`. This has the same state dimensions but different semantics.

## Longest increasing subsequence: dominance reduces state

The quadratic recurrence is `end[i]=1+max(end[j])` for `j<i` with `a[j]<a[i]`, or one if no predecessor qualifies. The answer is the maximum over ending positions.

For `O(n log n)` time, maintain `tails[len-1]`, the smallest possible ending value of an increasing subsequence of length `len` seen so far. A smaller tail is at least as easy to extend, so larger tails of the same length are dominated. Replace the first tail `>=x`, or append x if none exists. For nondecreasing subsequences use first tail `>x` instead.

The tails array gives the optimal length but need not itself be an actual subsequence: replacements may come from incompatible histories. Store predecessor indices and the index representing each length to reconstruct one. On `[3,1,2]`, tails progress `[3]`, `[1]`, `[1,2]`, giving length two.

## Weighted interval scheduling

Sort positive-length jobs by finish time and number them **1 through n in this recurrence**. Let `p(i)` be the number of earlier jobs finishing no later than job i starts. These compatible earlier jobs form a prefix. Let `F(i)` be the maximum value among the first `i` jobs:

```text
F(0) = 0
F(i) = max(F(i-1), value[i] + F(p(i)))
```

Binary search computes predecessor boundaries after sorting. Total time is `O(n log n)` and table space `O(n)`. Record the chosen alternative for reconstruction. The recurrence succeeds where earliest-finish greedy fails because it compares skip and take rather than irrevocably committing.

## Interval DP: choose a split

For multiplying matrices with dimensions `p[0]...p[n]`, let `C[i][j]` be the minimum scalar multiplications for matrices in `[i,j)`. A single matrix costs zero. For `j-i>=2`, choose split `k` strictly inside:

```text
C[i][j] = min over i<k<j of
    C[i][k] + C[k][j] + p[i]*p[k]*p[j]
```

Fill by increasing interval length. There are `O(n^2)` states and `O(n)` splits each, giving `O(n^3)` time and `O(n^2)` space. Products require sufficiently wide arithmetic. This is a parenthesization problem; matrix order does not change. Other interval DPs may choose the **last** removed item so the remaining boundaries are known.

## Tree DP: condition on the connection to the parent

For maximum-weight independent set on a rooted tree, `take[v]` is the best value when v is selected, and `skip[v]` when it is not:

```text
take[v] = weight[v] + sum(skip[child])
skip[v] = sum(max(take[child], skip[child]))
```

Children become independent only after fixing the parent's selection. Process postorder. Time is `O(V)` and storage `O(V)` for tables plus traversal memory. The empty set can be allowed with appropriate base values. The same recurrence is not valid on general cyclic graphs because child regions can share constraints.

Rerooting computes answers for every possible root by combining downward and upward contributions. For sum of distances in an unweighted tree, after subtree sizes are known, moving root from parent p to child c gives `answer[c]=answer[p]+V-2*size[c]`: vertices in c's subtree become one step closer, all others one step farther. Two traversals give all answers in linear time.

## Subset and digit DP

For a small Hamiltonian-path/TSP-style state space, `dp[mask][v]` stores a best route visiting exactly the mask and ending at v. Extend to one unvisited vertex. There are `O(2^n n)` states and up to n transitions each: `O(2^n n^2)` time, `O(2^n n)` space. Fix the starting vertex if required; add a closing edge only for a tour.

Digit DP counts integers up to a bound by scanning its digits. Typical state includes position, whether the prefix is tight to the bound, whether a non-leading digit has begun, and a property such as digit sum or remainder. Leading zeros and whether zero itself is counted must be explicit. Answer a range using `count(R)-count(L-1)` with a safe zero boundary.

Optimization techniques such as divide-and-conquer DP or convex hull methods require additional monotonicity or algebraic structure. Do not apply them just because a recurrence has a nested loop.

## Practice

1. Reconstruct an LCS and an edit script; validate them independently.
2. Implement both LIS algorithms and compare lengths on random arrays with duplicates.
3. Solve weighted intervals and produce the chosen job IDs.
4. Derive the reroot distance formula by partitioning vertices into two groups.
5. Count nonnegative integers up to N with no adjacent equal decimal digits.

<details><summary>Hints and checkpoints</summary>

1. Check subsequence membership / apply the edit operations, not just the reported length.
2. Strictness changes the binary-search boundary.
3. Backtrack through the skip/take decision and predecessor index.
4. Exactly `size[c]` distances decrease; the other `V-size[c]` increase.
5. Track the previous digit plus tight/started flags; leading padding is not an ordinary digit.

</details>

**Explain aloud:** “I choose this state boundary because it makes the remaining subproblems independent.” Vocabulary: alignment, split point, parent pointer, dominance, bitmask, rerooting.

## Sources

- [Erickson, Dynamic Programming](https://jeffe.cs.illinois.edu/teaching/algorithms/book/03-dynprog.pdf): sequence and structural recurrences.
- [MIT 6.006 lecture notes](https://ocw.mit.edu/courses/6-006-introduction-to-algorithms-spring-2020/pages/lecture-notes/), lectures 16-18: subsequences and DP formulations.
- [Erickson's extended notes](https://jeffe.cs.illinois.edu/teaching/algorithms/): advanced dynamic programming and fast exponential algorithms for further study.
