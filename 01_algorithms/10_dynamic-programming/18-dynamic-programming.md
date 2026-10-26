# 18 - Dynamic Programming from First Principles

<!-- study-navigation -->
[← Previous: Unit 17](../09_greedy/17-greedy-and-intervals.md) · [Index](../../README.md#study-index) · [Next: Unit 19 →](19-dynamic-programming-patterns.md)
<!-- /study-navigation -->

[Curriculum](../../CURRICULUM.md) | [Quick reference](../../04_notes/dynamic-programming.md)

> **Core idea:** Define what a state means before choosing how to store or compute it.

## On this page

- [A state summarizes the relevant past](#a-state-summarizes-the-relevant-past)
- [Worked visual](#worked-visual)
- [The derivation checklist](#the-derivation-checklist)
- [Worked example: nonadjacent maximum sum](#worked-example-nonadjacent-maximum-sum)
- [State design examples](#state-design-examples)
- [Compress storage only after correctness](#compress-storage-only-after-correctness)
- [Common failures](#common-failures)
- [Explain it in English](#explain-it-in-english)
- [Practice](#practice)
- [Attribution and references](#attribution-and-references)

## A state summarizes the relevant past

Dynamic programming evaluates recurring subproblems once and reuses their results. Start from a correct recursive formulation, then identify which histories leave the same future problem. A state is sufficient when two histories with the same state have the same legal continuations and future contribution under the recurrence.

Overlapping subproblems explain why reuse helps. Optimal substructure explains why composing optimal subproblem answers can give an optimum. Neither phrase replaces an actual state definition. “Use a DP array” is a storage decision, not a solution.

## Worked visual

| Entries considered | Skip last | Take last | Best |
|---|---|---|---|
| [4] | 0 | 4 | 4 |
| [4,1] | 4 | 1 | 4 |
| [4,1,7] | 4 | 4 + 7 | 11 |
| [4,1,7,3] | 11 | 4 + 3 | 11 |

## The derivation checklist

1. Define each state in a complete sentence, including whether it describes a prefix, suffix, interval, or remaining resource.
2. Enumerate the first or last decision and derive every transition.
3. Prove that transitions are exhaustive and compose valid subsolutions.
4. Define base cases and unreachable states.
5. Establish an acyclic dependency order or a decreasing measure.
6. Locate the final answer and describe reconstruction if needed.
7. Count states times transition work, then include representation and copying costs.

Top-down memoization computes only reached states but uses recursion and cache lookups. Bottom-up tabulation evaluates an explicit dependency order and avoids recursion depth issues. They implement the same recurrence when their state definitions agree. Memoization does not automatically solve cyclic state dependencies; shortest-path relaxation is a different fixed-point process.

## Worked example: nonadjacent maximum sum

Let `F(i)` be the maximum sum from the first `i` entries, with no two selected positions adjacent and the empty selection allowed. For the last entry, either skip it or take it and exclude its predecessor:

```text
F(0) = 0
F(1) = max(0, a[0])
F(i) = max(F(i-1), F(i-2) + a[i-1]) for i >= 2
```

Any legal optimum falls into exactly one of these alternatives. In the take case, replacing its earlier selection by a better solution on the first `i-2` entries would improve the total, so the best earlier subsolution suffices. This proves the recurrence inductively.

```java
static long maximumNonAdjacentSum(int[] values) {
    long twoBack = 0;
    long oneBack = 0;
    for (int value : values) {
        long current = Math.max(oneBack, twoBack + value);
        twoBack = oneBack;
        oneBack = current;
    }
    return oneBack;
}
```

Contract: nonnull int array; empty selection is allowed. For `[4,1,7,3]`, successive best values are `4,4,11,11`. All-negative input returns zero. The time is `O(n)` and auxiliary space constant because only two prior states are needed. If at least one entry must be selected, the base cases and state semantics must change. If actual indices are requested, retain decisions or a full table and backtrack.

## State design examples

- **Grid paths:** `ways[r][c]` counts ways to reach a cell using only specified acyclic moves. An obstacle contributes zero. For right/down movement, predecessors are above and left. Counts may require a modulus or arbitrary precision.
- **Minimum coins with unlimited positive denominations:** `best[amount] = 1 + min(best[amount-coin])` over reachable predecessors, with `best[0]=0`. Use an unreachable sentinel and never add one to it blindly.
- **0/1 knapsack:** `best[i][capacity]` is the maximum value using only the first `i` items within that capacity. The transition chooses skip or take the current item once. A capacity-based `O(nW)` algorithm is pseudopolynomial.
- **DAG paths:** a topological traversal evaluates a recurrence whose states are vertices. DP need not look like a rectangular table.

The same state graph can support different aggregates: OR for feasibility, sum for counting, minimum or maximum for optimization. Counting requires disjoint alternatives or a correction for double counting; taking a min over overlapping alternatives does not have that same issue.

## Compress storage only after correctness

For 0/1 knapsack with positive weights, a one-dimensional capacity array must update from high capacity to low so `dp[c-weight]` still refers to the previous item layer. Low-to-high updates allow the current item to be used repeatedly, which solves the unbounded version instead. Direction is a dependency proof, not a memorized preference.

For sequence DP with rolling rows, preserve any previous-row and diagonal values before overwriting. Space optimization can remove information needed for reconstruction; keep parents, recompute carefully, or use a specialized reconstruction method.

## Common failures

An omitted state dimension can merge inequivalent futures. A default zero can falsely make unreachable states feasible. Substring creation can turn an apparent quadratic recurrence cubic. Memoizing a mutable key can corrupt lookup. Returning the last table cell is wrong if the state does not define the answer there, such as a subsequence that may end anywhere.

## Explain it in English

> “This state contains exactly the information needed to choose the remaining decisions.”

**Vocabulary:** state, transition, memoization, tabulation, base case, unreachable, reconstruction.

## Practice

Attempt the [unit 18 exercise set](../../03_problems/02_practice/18-dynamic-programming.md). Exercises and hints live in `03_problems/`; this chapter contains the theory.

## Attribution and references

**Provenance:** This chapter is a synthesis of the sources mapped below. Standard definitions, algorithms and proof techniques belong to those established references; the explanatory wording, traces, diagrams and Java examples were written for this repository. No source passage is quoted verbatim.

| Section / claim | Source used | How it is used |
|---|---|---|
| State design, recurrence and reuse | [Jeff Erickson, Algorithms, chapter 3: Dynamic Programming](https://jeffe.cs.illinois.edu/teaching/algorithms/book/03-dynprog.pdf) | Dynamic-programming method; examples reformulated here. |
| Evaluation order and pseudopolynomial complexity | [Demaine, Ku and Solomon, MIT 6.006 (Spring 2020)](https://ocw.mit.edu/courses/6-006-introduction-to-algorithms-spring-2020/pages/lecture-notes/) | Lectures 15-18. |

See [SOURCES.md](../../SOURCES.md) for editions, review scope, and the distinction between consulted material and further reading.

---

<!-- study-navigation -->
[← Previous: Unit 17](../09_greedy/17-greedy-and-intervals.md) · [Index](../../README.md#study-index) · [Next: Unit 19 →](19-dynamic-programming-patterns.md)
<!-- /study-navigation -->
