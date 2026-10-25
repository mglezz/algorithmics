# 11 - Recursion, Backtracking, and Search Spaces

[Curriculum](README.md) | Prerequisites: 01-02, 04

## A recursive call needs a smaller contract

Specify what a call returns, what state it reads or changes, and a measure that decreases. For tree recursion, smaller subtrees are natural; for ranges, use their length; for combinatorial search, use the number of unmade decisions. A base case is a valid smallest instance, not a line added to stop a crash.

Recursion is a control mechanism, not a complexity class. Binary search is logarithmic, a full tree traversal is linear, and permutation enumeration is factorial. Count the actual recursive states and work per state. Stack space depends on maximum simultaneous depth, not total calls.

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

## Practice

1. Generate balanced parentheses for `n` pairs without generating all strings first.
2. Generate unique permutations of a multiset.
3. Solve a small constraint grid using “fewest legal choices first,” while keeping correctness separate from the heuristic.
4. Implement meet-in-the-middle subset sum and compare it against exhaustive search on small inputs.

<details><summary>Hints and checkpoints</summary>

1. A prefix needs `0<=closed<=opened<=n`. The number of outputs is the nth Catalan number, not `2^n`.
2. Use frequency counts or a sorted array with a same-depth duplicate rule.
3. Choice ordering can accelerate search but does not replace exploring all necessary branches.
4. Include the empty subset and negative values; use a type that holds sums.

</details>

**Explain aloud:** “These two histories are equivalent only if they leave exactly the same future possibilities.” Vocabulary: search tree, branching factor, pruning, restore, soundness, completeness.

## Sources

- [Erickson, Backtracking](https://jeffe.cs.illinois.edu/teaching/algorithms/book/02-backtracking.pdf): systematic recursive search and state design.
- [Erickson's algorithms materials](https://jeffe.cs.illinois.edu/teaching/algorithms/): recursion and fast exponential algorithms offer deeper proofs and extensions.
