# 19 - Dynamic Programming Patterns and Reconstruction

[Curriculum](../../CURRICULUM.md) | [Quick reference](../../notes/dynamic-programming.md)

> **Core idea:** Choose state boundaries that isolate independent subproblems, then preserve reconstruction information.

## On this page

- [Sequence alignment: two prefixes](#sequence-alignment-two-prefixes)
- [Worked visual](#worked-visual)
- [Longest increasing subsequence: dominance reduces state](#longest-increasing-subsequence-dominance-reduces-state)
- [Weighted interval scheduling](#weighted-interval-scheduling)
- [Interval DP: choose a split](#interval-dp-choose-a-split)
- [Tree DP: condition on the connection to the parent](#tree-dp-condition-on-the-connection-to-the-parent)
- [Subset and digit DP](#subset-and-digit-dp)
- [Explain it in English](#explain-it-in-english)
- [Practice](#practice)
- [Attribution and references](#attribution-and-references)

## Sequence alignment: two prefixes

For longest common subsequence, let `L[i][j]` be the LCS length of prefixes `a[0..i)` and `b[0..j)`. Empty-prefix rows and columns are zero. If the final symbols agree, use `1+L[i-1][j-1]`; otherwise use `max(L[i-1][j],L[i][j-1])`. In the mismatch case, a common subsequence cannot use both final symbols as its final matched pair, so at least one must be skipped. In the match case, there exists an optimum using that final matching pair, with an optimal smaller-prefix solution before it.

There are `(n+1)(m+1)` states with constant transition work: `O(nm)` time and table space. Rolling rows reduce value-only space to `O(min(n,m))`. To reconstruct, walk backward according to matching and skip choices; a full parent/table representation is simpler. Longest common **substring** requires contiguity, so its matching-suffix recurrence resets to zero on mismatch; it is not LCS.

For unit-cost edit distance, define `D[i][j]` as the cost to transform the first `i` symbols into the first `j` symbols. Initialize `D[i][0]=i` and `D[0][j]=j`. Take the minimum of deletion `D[i-1][j]+1`, insertion `D[i][j-1]+1`, and match/substitution `D[i-1][j-1]+cost`. This has the same state dimensions but different semantics.

## Worked visual

| Question | State design | What must be preserved |
|---|---|---|
| Compare two sequences | Two prefix lengths | The relevant previous row/diagonal |
| Choose a parenthesization | An interval and a split | Both child interval costs |
| Choose tree vertices | Node plus parent-choice condition | Independent child summaries |
| Visit a small vertex set | Mask plus last vertex | Exactly which vertices were visited |

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

## Explain it in English

> “I choose this state boundary because it makes the remaining subproblems independent.”

**Vocabulary:** alignment, split point, parent pointer, dominance, bitmask, rerooting.

## Practice

Attempt the [unit 19 exercise set](../../problems/practice/19-dynamic-programming-patterns.md). Exercises and hints live in `problems/`; this chapter contains the theory.

## Attribution and references

**Provenance:** This chapter is a synthesis of the sources mapped below. Standard definitions, algorithms and proof techniques belong to those established references; the explanatory wording, traces, diagrams and Java examples were written for this repository. No source passage is quoted verbatim.

| Section / claim | Source used | How it is used |
|---|---|---|
| Sequence and structural recurrences | [Jeff Erickson, Algorithms, chapter 3: Dynamic Programming](https://jeffe.cs.illinois.edu/teaching/algorithms/book/03-dynprog.pdf) | Standard DP methods and correctness reasoning. |
| LCS, LIS and reconstruction | [Demaine, Ku and Solomon, MIT 6.006 (Spring 2020)](https://ocw.mit.edu/courses/6-006-introduction-to-algorithms-spring-2020/pages/lecture-notes/) | Lectures 16-18; recurrence ideas. |
| Tree, subset and digit techniques | [Antti Laaksonen, Competitive Programmer's Handbook (2018 draft)](https://cses.fi/book/book.pdf) | Tree algorithms and dynamic-programming optimizations; independent formulations here. |

See [SOURCES.md](../../SOURCES.md) for editions, review scope, and the distinction between consulted material and further reading.
