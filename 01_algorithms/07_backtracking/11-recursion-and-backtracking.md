# 11 - Recursion, Backtracking, and Search Spaces

<!-- study-navigation -->
[← Previous: Unit 10](../06_sorting/10-sorting-and-selection.md) · [Index](../../README.md#study-index) · [Next: Unit 12 →](../../02_data-structures/05_trees/12-trees-and-ordered-maps.md)
<!-- /study-navigation -->

[Curriculum](../../CURRICULUM.md) | [Quick reference](../../04_notes/proof-checklist.md)

> **Core idea:** Explore a decision tree with sufficient state, safe pruning, and exact restoration.

## On this page

- [A recursive call needs a smaller contract](#a-recursive-call-needs-a-smaller-contract)
- [Worked visual](#worked-visual)
- [Backtracking as a decision tree](#backtracking-as-a-decision-tree)
- [Worked enumeration: subsets of distinct entries](#worked-enumeration-subsets-of-distinct-entries)
- [Permutations and combinations](#permutations-and-combinations)
- [Pruning must be justified](#pruning-must-be-justified)
- [Meet in the middle](#meet-in-the-middle)
- [Explain it in English](#explain-it-in-english)
- [Practice](#practice)
- [Attribution and references](#attribution-and-references)

## A recursive call needs a smaller contract

Specify what a call returns, what state it reads or changes, and a measure that decreases. For tree recursion, smaller subtrees are natural; for ranges, use their length; for combinatorial search, use the number of unmade decisions. A base case is a valid smallest instance, not a line added to stop a crash.

Recursion is a control mechanism, not a complexity class. Binary search is logarithmic, a full tree traversal is linear, and permutation enumeration is factorial. Count the actual recursive states and work per state. Stack space depends on maximum simultaneous depth, not total calls.

## Worked visual

```text
Decide whether to include a, then b:
                 []
             /        \
         skip a      take a
           []          [a]
          /  \        /   \
        []   [b]     [a]  [a,b]

Each subset corresponds to exactly one root-to-leaf choice sequence.
```

## Backtracking as a decision tree

Represent a partial solution and extend it with each legal choice. Explore a choice, recurse, then restore the state exactly. When a complete solution is reached, copy it if it will be stored: retaining a reference to a mutable working list makes all saved answers change later.

```text
search(state):
    if state is complete:
        emit a copy of the solution
        return
    for each candidate choice:
        if choice is feasible:
            apply choice
            search(updated state)
            undo choice
```

To prove correctness, show **soundness** (every emitted object is legal), **completeness** (every legal object has an explored choice sequence), and **uniqueness** when required (no two sequences emit the same result). State restoration is part of the induction hypothesis.

## Worked enumeration: subsets of distinct entries

At position `i`, either exclude or include entry `i`; recurse on `i+1`. At `i=n`, emit the selected entries. Every subset determines one unique binary decision vector, proving completeness and uniqueness. There are `2^n` leaves, and copying all explicit subsets takes `Theta(n*2^n)` total work and output storage. The working path and recursion stack use `O(n)` auxiliary space if output is streamed or excluded.

If values repeat but only distinct value-subsets are wanted, index-based enumeration overcounts. Sort and skip equal choices at the same decision depth, or recurse on value frequencies. Skipping an equal value at every depth would also forbid legitimate repeated selections.

## Permutations and combinations

For distinct permutations, select an unused position at each depth. There are `n!` answers of length `n`, so explicit output takes `Theta(n*n!)` time. A used array plus a path uses linear working space. Swapping in place is an alternative, but every swap needs a matching undo.

For combinations of size `k`, pass a start index and choose only later positions. This enforces an increasing index sequence and avoids generating all `k!` orders of each combination. Stop if the number of remaining entries is smaller than the number still required.

## Pruning must be justified

Constraint pruning rejects a partial assignment that cannot extend to a legal solution. In N-Queens, occupied columns and the two diagonal identifiers `row-col` and `row+col` reject conflicts in constant time per test. For a word-search path, mark cells on the current path and unmark on return; a global permanent visited set may incorrectly forbid a valid path starting elsewhere.

For a positive-number target sum, exceeding the target can justify pruning. With negative numbers, a later value can bring the sum back down, so that pruning rule is unsound. For optimization, **branch and bound** prunes only when an optimistic bound cannot beat the best complete solution found so far. A bad bound can silently remove the optimum.

Memoization merges equivalent subproblems. It is valid only when the stored state contains everything influencing future outcomes. Memoizing a grid search by position alone is wrong if different visited-cell sets allow different future moves. Dynamic programming develops this idea in units 18-19.

## Meet in the middle

For subset sum with roughly forty entries, split into halves, enumerate both sets of subset sums, sort one, and search for complementary sums from the other. This trades a search of `2^n` combinations for lists of about `2^(n/2)` entries, with sorting/search overhead. It is still exponential and uses substantial memory, but the smaller exponent can be decisive. Preserve masks if reconstructing a subset is required.

## Explain it in English

> “These two histories are equivalent only if they leave exactly the same future possibilities.”

**Vocabulary:** search tree, branching factor, pruning, restore, soundness, completeness.

## Practice

Attempt the [unit 11 exercise set](../../03_problems/02_practice/11_recursion-and-backtracking/README.md). Exercises and hints live in `03_problems/`; this chapter contains the theory.

## Attribution and references

**Provenance:** This chapter is a synthesis of the sources mapped below. Standard definitions, algorithms and proof techniques belong to those established references; the explanatory wording, traces, diagrams and Java examples were written for this repository. No source passage is quoted verbatim.

| Section / claim | Source used | How it is used |
|---|---|---|
| Recursive enumeration and pruning | [Jeff Erickson, Algorithms, chapter 2: Backtracking](https://jeffe.cs.illinois.edu/teaching/algorithms/book/02-backtracking.pdf) | Search-tree and state-design methods. |
| Meet in the middle | [Antti Laaksonen, Competitive Programmer's Handbook (2018 draft)](https://cses.fi/book/book.pdf) | Section 5.5; exponential-search reduction. |

See [SOURCES.md](../../SOURCES.md) for editions, review scope, and the distinction between consulted material and further reading.

---

<!-- study-navigation -->
[← Previous: Unit 10](../06_sorting/10-sorting-and-selection.md) · [Index](../../README.md#study-index) · [Next: Unit 12 →](../../02_data-structures/05_trees/12-trees-and-ordered-maps.md)
<!-- /study-navigation -->
