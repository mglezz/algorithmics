# 17 - Greedy Algorithms, Intervals, and Sweeps

[Curriculum](README.md) | Prerequisites: 10, 13-16

## A local preference needs a global proof

A greedy algorithm commits to a choice without exploring alternatives later. “It seems best now” is a hypothesis. Establish that some optimal solution contains the chosen action, and that the remaining problem has the same structure. Useful proofs include exchanging choices in an optimum, showing a greedy prefix stays ahead, and matching a constructive solution to a lower bound.

Optimal substructure alone does not establish a greedy rule: dynamic programming also uses optimal substructure but may compare several choices. Before coding, try to break your proposed preference with a small counterexample.

## Interval scheduling: earliest finish time

Given positive-length half-open intervals `[start,end)`, maximize the number of nonoverlapping intervals. Sort by end and repeatedly choose the next interval whose start is at least the last chosen end. Time is `O(n log n)` for sorting and `O(n)` for the scan.

Exchange proof: let g be an earliest-finishing interval, and let o be the first interval in an optimal schedule. Since g finishes no later than o, replacing o by g leaves room for every later interval in that schedule. Therefore some optimum starts with g. Apply the same argument to intervals beginning after g finishes.

Example: `[0,6)`, `[1,3)`, `[3,5)`, `[5,7)`. Choosing earliest start takes only the long interval and possibly nothing else; earliest finish selects the three short compatible intervals. Choosing shortest duration also lacks the needed exchange guarantee in general.

If intervals have values and the objective is total value, this rule fails: `[0,2)` value 2 and `[0,3)` value 100 make the earliest finish a bad first commitment. Weighted interval scheduling needs a recurrence; see unit 19.

## Interval partitioning: minimize resources

To assign all intervals to as few rooms as possible, sort by start time. Keep each room's latest finish in a min-heap. Reuse the earliest-finishing room when its finish is no greater than the next start; otherwise allocate a new room.

When a new room is necessary, every existing room has an interval active at that start time. Those intervals plus the new interval require that many simultaneous rooms in **any** solution. The algorithm reaches this lower bound, proving optimality. This is a different problem from selecting a maximum-size compatible subset.

With half-open intervals, an interval ending at time t does not overlap one starting at t. For a sweep-line count, process ends before starts at equal coordinates. Closed intervals have different tie semantics. Define zero-length interval behavior rather than letting event sorting decide it accidentally.

## Merge intervals and sweep events

For merging overlapping intervals, sort by start, keep one active merged interval, and extend its end while overlap continues. When the next start lies beyond the active end, no later interval can bridge that gap because starts are sorted, so emit the active interval. Decide separately whether merely touching intervals should merge.

A sweep transforms each object into boundary events and maintains active information while processing events in coordinate order. Examples include maximum overlap, union length, active resource counts, and geometric intersections. Before updating at coordinate x, accumulate any contribution over the span since the previous coordinate using the old active state; events at a single coordinate have zero width.

For union length of half-open intervals, group events by coordinate, add the gap length when coverage count is positive, then update the count. An event list is sufficient in one dimension; higher-dimensional sweeps may require ordered sets or segment trees.

## Other greedy models and failure cases

- **Fractional knapsack:** taking by value/weight ratio works when arbitrary fractions are allowed. It fails for indivisible 0/1 items.
- **Huffman coding:** repeatedly combine the two smallest frequencies. An exchange argument allows the two least frequent symbols to be deepest siblings in some optimal prefix-code tree; merging them reduces the problem. Heap implementation costs `O(n log n)`.
- **Coin change:** repeatedly taking the largest coin is not universally correct. With denominations `{1,3,4}`, amount six needs two threes; greedy uses four plus two ones.
- **Scheduling with deadlines:** changing the objective or adding multiple resources can invalidate a familiar greedy rule. Re-derive the proof for the actual contract.

## Practice

1. Implement maximum-cardinality interval scheduling and return the selected interval IDs.
2. Return a concrete minimum-room assignment, not just its room count.
3. Compute union length and test equal endpoints, nested intervals, and repeated intervals.
4. Invent a greedy proposal for 0/1 knapsack and disprove it with a tiny input.

<details><summary>Hints and checkpoints</summary>

1. Stable identity tracking matters if sorting changes input order.
2. Heap entries need both end time and room ID; reuse the popped room.
3. Group same-coordinate events before advancing the sweep.
4. Ratio preference can select an item that blocks a more valuable combination of whole items.

</details>

**Explain aloud:** “I can exchange the first choice of an optimal solution for my choice without making it worse.” Vocabulary: exchange argument, stays ahead, feasible schedule, overlap, sweep event, lower bound.

## Sources

- [Erickson, Greedy Algorithms](https://jeffe.cs.illinois.edu/teaching/algorithms/book/04-greedy.pdf): greedy proof techniques and scheduling.
- [Erickson, Minimum Spanning Trees](https://jeffe.cs.illinois.edu/teaching/algorithms/book/07-mst.pdf): additional exchange proofs in graph optimization.
