# 16B - Minimum Spanning Trees

<!-- study-navigation -->
[← Previous: Unit 16A](../../02_data-structures/08_disjoint-sets/16-disjoint-sets.md) · [Index](../../README.md#study-index) · [Next: Unit 17 →](../09_greedy/17-greedy-and-intervals.md)
<!-- /study-navigation -->

[Curriculum](../../CURRICULUM.md) | [Quick reference](../../04_notes/graphs.md) | [Companion chapter](../../02_data-structures/08_disjoint-sets/16-disjoint-sets.md)

> **Core idea:** An MST minimizes the sum of chosen undirected edge weights, not the distance from a source.

## On this page

- [Spanning trees and their objective](#spanning-trees-and-their-objective)
- [Worked visual](#worked-visual)
- [Cut and cycle arguments](#cut-and-cycle-arguments)
- [Kruskal and Prim](#kruskal-and-prim)
- [Explain it in English](#explain-it-in-english)
- [Practice](#practice)
- [Attribution and references](#attribution-and-references)

## Spanning trees and their objective

For a connected undirected weighted graph, a spanning tree connects every vertex without a cycle; an MST minimizes the **sum of selected edge weights**. A shortest-path tree minimizes source-to-vertex path lengths, which is a different objective. Negative edge weights are allowed for MSTs. Disconnected input yields a minimum spanning forest, not a single spanning tree.

## Worked visual

| Edge considered | Action | Chosen total |
|---|---|---|
| a-b, weight 2 | Join separate components | 2 |
| b-c, weight 3 | Join separate components | 5 |
| a-c, weight 9 | Reject: endpoints already connected | 5 |

## Cut and cycle arguments

A cut partitions vertices into two nonempty groups. If a cut respects the edges already chosen, a minimum-weight edge crossing that cut can be added while preserving compatibility with some MST. Proof: if an MST omits it, add it to create a cycle; the cycle includes another crossing edge. Replacing that edge cannot increase weight.

On a cycle, a **strictly** heaviest edge belongs to no MST. With ties, a maximum-weight edge can be excluded from some MST, but need not be excluded from every MST. Distinct edge weights guarantee uniqueness; they are sufficient but not necessary.

## Kruskal and Prim

**Kruskal:** sort edges by nondecreasing weight; accept an edge exactly when its endpoints currently belong to different DSU components. Each accepted edge joins components without a cycle. The cut property makes the choice safe. Stop after `V-1` accepted edges for connected nonempty input; otherwise detect disconnection. Time is `O(V+E log(E+1)+E alpha(V))`; sorting generally dominates. Retain chosen edges if a witness is required.

**Prim:** start from one vertex and repeatedly choose the cheapest edge crossing from the current tree to an outside vertex. A lazy edge heap may contain obsolete internal edges; discard them on removal. This variant takes `O(V+E log(E+1))` time with up to `O(E)` heap entries. An indexed eager version stores the best connecting edge per outside vertex and takes `O((V+E) log(V+1))`. An adjacency-matrix implementation takes `O(V^2)`, useful for dense graphs.

Example: on a triangle with weights `ab=2`, `bc=3`, `ac=9`, Kruskal accepts the first two edges and rejects the third because it closes a cycle. The minimum total is five, regardless of a chosen source.

## Explain it in English

> “The light edge crossing this cut is safe by an exchange argument.”

**Vocabulary:** representative, component, path compression, cut, spanning forest, safe edge.

## Practice

Attempt the [unit 16 exercise set](../../03_problems/02_practice/16_disjoint-sets-and-spanning-trees/README.md). Exercises and hints live in `03_problems/`; this chapter contains the theory.

## Attribution and references

**Provenance:** This chapter is a synthesis of the sources mapped below. Standard definitions, algorithms and proof techniques belong to those established references; the explanatory wording, traces, diagrams and Java examples were written for this repository. No source passage is quoted verbatim.

| Section / claim | Source used | How it is used |
|---|---|---|
| Cut/cycle properties, Kruskal and Prim | [Jeff Erickson, Algorithms, chapter 7: Minimum Spanning Trees](https://jeffe.cs.illinois.edu/teaching/algorithms/book/07-mst.pdf) | Standard MST algorithms and exchange proofs. |

See [SOURCES.md](../../SOURCES.md) for editions, review scope, and the distinction between consulted material and further reading.

---

<!-- study-navigation -->
[← Previous: Unit 16A](../../02_data-structures/08_disjoint-sets/16-disjoint-sets.md) · [Index](../../README.md#study-index) · [Next: Unit 17 →](../09_greedy/17-greedy-and-intervals.md)
<!-- /study-navigation -->
