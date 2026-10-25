# 10 - Sorting, Selection, and Divide and Conquer

[Practice index](README.md) | Theory: [Sorting, Selection, and Divide and Conquer](../../algorithms/sorting/10-sorting-and-selection.md)

**Status:** Suggested practice; no solution or completion is implied. These prompts and hints were written for this repository, not copied from a recruiting question bank.

## Your deliverable

Write a specification, your solution, a correctness argument, time/space analysis, and tests. Record independent attempts in [PROGRESS.md](../../PROGRESS.md).

## Exercises

1. Implement a stable merge sort and verify both ordering and permutation preservation.
2. Count inversions with duplicate values; define an inversion as strictly greater.
3. Design a three-way partition and write its region invariant before coding.
4. Choose among sorting, quickselect, and a heap for one query, many queries, and a stream.

<details><summary>Hints and checkpoints</summary>

1. Compare pairs `(key, originalIndex)` to test stability independently of ordinary value sorting.
2. Equal values do not contribute inversions; choose left first on equality.
3. A swap from the right unclassified end may bring in another unclassified element, so do not always advance the scan pointer.
4. Sorting amortizes across many rank queries; a bounded heap supports online arrival.

</details>
