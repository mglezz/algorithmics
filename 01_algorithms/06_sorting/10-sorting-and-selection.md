# 10 - Sorting, Selection, and Divide and Conquer

<!-- study-navigation -->
[← Previous: Unit 09](../05_searching/09-binary-search.md) · [Index](../../README.md#study-index) · [Next: Unit 11 →](../07_backtracking/11-recursion-and-backtracking.md)
<!-- /study-navigation -->

[Curriculum](../../CURRICULUM.md) | [Quick reference](../../04_notes/complexity.md)

> **Core idea:** Sorting establishes order; selection finds a rank without ordering everything.

## On this page

- [What exactly must be preserved?](#what-exactly-must-be-preserved)
- [Worked visual](#worked-visual)
- [Merge sort: prove the combine step](#merge-sort-prove-the-combine-step)
- [Quicksort: partitioning is the invariant](#quicksort-partitioning-is-the-invariant)
- [Selection instead of sorting everything](#selection-instead-of-sorting-everything)
- [Why linear sorting can exist](#why-linear-sorting-can-exist)
- [Explain it in English](#explain-it-in-english)
- [Practice](#practice)
- [Attribution and references](#attribution-and-references)

## What exactly must be preserved?

A sorting algorithm produces an ordered permutation of the input. Checking only that the output is sorted misses lost or duplicated values. **Stability** preserves input order among equal keys. **In-place** usually describes small auxiliary storage, but clarify whether recursion stacks count. A comparator must define a consistent ordering.

Sorting is often a preprocessing step that exposes adjacency, enables two pointers, groups duplicates, or gives a useful event order. Include the preprocessing cost and decide whether mutating input is allowed.

| Algorithm | Time | Extra storage in a standard implementation | Stable? |
|---|---|---|---|
| Insertion sort | Best `O(n)`, worst `O(n^2)` | `O(1)` | Yes, if equal keys are not shifted past each other |
| Selection sort | `Theta(n^2)` | `O(1)` | Usually no |
| Bubble sort with early exit | Best `O(n)`, worst `O(n^2)` | `O(1)` | Yes with strict swap rule |
| Merge sort on arrays | `Theta(n log n)` | `O(n)` buffer plus `O(log n)` stack | Yes with left-first ties |
| Quicksort | Expected `O(n log n)` with suitable random pivots, worst `O(n^2)` | Stack depends on recursion strategy | Usually no |
| Heapsort | `O(n log n)` worst case | `O(1)` iterative auxiliary space | No |
| Counting sort | `O(n+U)` for key universe size `U` | Typically `O(n+U)` | Stable output form exists |
| LSD radix sort | `O(d(n+B))` for `d` digits in base `B` | Typically `O(n+B)` | Requires stable digit passes |

These are algorithm bounds, not a promise about every language's `sort` implementation. Consult the relevant Java overload and documented guarantees.

## Worked visual

```text
             [6,2,5,1]
             /       \
         [6,2]       [5,1]
         /   \       /   \
       [6]  [2]     [5]  [1]
         \   /       \   /
         [2,6]       [1,5]
             \       /
             [1,2,5,6]
```

## Merge sort: prove the combine step

Recursively sort two halves, then merge their smallest remaining values. The output prefix contains exactly the smallest consumed elements in order. Taking the smaller head is safe because nothing later in either sorted half can precede it. Exhausting one half leaves an already sorted suffix in the other.

The recurrence is `T(n)=2T(n/2)+Theta(n)`. Each recursion level performs linear work and there are logarithmically many levels. Reuse a buffer rather than allocating a new copy for every tiny operation. For inversion counting, when a right-half value precedes the current left value, it forms inversions with every remaining left-half value; add that remaining count in one step. Use long because the number of pairs can be quadratic.

## Quicksort: partitioning is the invariant

A three-way partition maintains regions `< pivot`, `= pivot`, unclassified, and `> pivot`. Inspect one unclassified element; move it into the appropriate region; recurse only on the strictly smaller and strictly greater regions. This handles many duplicates well.

Balanced splits lead to logarithmic depth; repeatedly choosing an extreme pivot leads to quadratic work. Random pivot selection gives an expectation over random choices, not a guarantee for every run. Recursing on the smaller side and looping on the larger side bounds stack depth by `O(log n)` even when total work is quadratic. A naive recursive implementation can use `O(n)` stack.

## Selection instead of sorting everything

Quickselect partitions and continues only in the region containing the desired zero-based rank. It is expected linear with suitable randomization but quadratic in the worst case. Three-way partitioning also helps repeated values. Do not say the remaining region halves on every random pivot: expected progress requires a probabilistic argument.

Deterministic median-of-medians groups values into small groups, selects a pivot from their medians, and guarantees a constant-fraction discard. With groups of five, the standard recurrence is bounded by `T(n/5)+T(7n/10+O(1))+O(n)`, giving worst-case linear selection. Understand the guarantee before attempting to implement this longer method under interview pressure.

For a stream's `k` largest values, a size-`k` min-heap costs `O(n log k)` and `O(k)` storage. For a static mutable array and one order statistic, selection may be better. Returning the top `k` in sorted order adds ordering work.

## Why linear sorting can exist

The comparison lower bound comes from distinguishing `n!` input orders using binary outcomes. Counting and radix sorting exploit key structure and direct indexing. They do not refute the comparison bound. If the key universe is enormous, `O(U)` storage is unsuitable; coordinate compression itself typically requires sorting and does not make that cost vanish.

## Explain it in English

> “Sorting reveals structure, but it changes order and may cost more than selecting only the needed rank.”

**Vocabulary:** stable, partition, pivot, inversion, order statistic, comparison model.

## Practice

Attempt the [unit 10 exercise set](../../03_problems/02_practice/10-sorting-and-selection.md). Exercises and hints live in `03_problems/`; this chapter contains the theory.

## Attribution and references

**Provenance:** This chapter is a synthesis of the sources mapped below. Standard definitions, algorithms and proof techniques belong to those established references; the explanatory wording, traces, diagrams and Java examples were written for this repository. No source passage is quoted verbatim.

| Section / claim | Source used | How it is used |
|---|---|---|
| Sorting families and integer sorting | [Pat Morin, Open Data Structures, chapter 11](https://opendatastructures.org/ods-java/11_Sorting_Algorithms.html) | Comparison/integer models, bounds and mechanisms. |
| Lower bounds and linear sorting | [Demaine, Ku and Solomon, MIT 6.006 (Spring 2020)](https://ocw.mit.edu/courses/6-006-introduction-to-algorithms-spring-2020/pages/lecture-notes/) | Lectures 3 and 5. |
| Selection | [Jeff Erickson, Algorithms and supplementary notes](https://jeffe.cs.illinois.edu/teaching/algorithms/) | Chapter 1, Recursion; quickselect and deterministic selection. |

See [SOURCES.md](../../SOURCES.md) for editions, review scope, and the distinction between consulted material and further reading.

---

<!-- study-navigation -->
[← Previous: Unit 09](../05_searching/09-binary-search.md) · [Index](../../README.md#study-index) · [Next: Unit 11 →](../07_backtracking/11-recursion-and-backtracking.md)
<!-- /study-navigation -->
