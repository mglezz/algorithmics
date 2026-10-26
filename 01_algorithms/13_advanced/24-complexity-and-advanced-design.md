# 24 - Computational Limits and Advanced Algorithm Design

<!-- study-navigation -->
[← Previous: Unit 23](../08_graphs/23-advanced-graphs-and-flow.md) · [Index](../../README.md#study-index) · [Next: Unit 25 →](../14_problem-solving/25-solving-testing-and-communication.md)
<!-- /study-navigation -->

[Curriculum](../../CURRICULUM.md) | [Quick reference](../../04_notes/proof-checklist.md)

> **Core idea:** Recognize which constraints permit exact, approximate, offline, or specialized solutions.

## On this page

- [Decision problems, P, NP, and reductions](#decision-problems-p-np-and-reductions)
- [Worked visual](#worked-visual)
- [Responding to hardness](#responding-to-hardness)
- [Approximation with a proof](#approximation-with-a-proof)
- [Computational geometry: robust predicates first](#computational-geometry-robust-predicates-first)
- [Persistence, rollback, and offline algorithms](#persistence-rollback-and-offline-algorithms)
- [External memory and probabilistic summaries](#external-memory-and-probabilistic-summaries)
- [More specialist directions](#more-specialist-directions)
- [Explain it in English](#explain-it-in-english)
- [Practice](#practice)
- [Attribution and references](#attribution-and-references)

This is an extension map, not a full specialist course. Use the main-route units before pursuing these topics.

## Decision problems, P, NP, and reductions

A decision problem asks yes/no, such as whether a graph has a Hamiltonian cycle. P consists of decision problems solvable in polynomial time in the **encoded input length**. NP consists of decision problems whose yes answers have polynomial-length certificates verifiable in polynomial time. NP does not mean “not polynomial”; P is contained in NP, and whether they are equal remains unresolved.

A polynomial-time many-one reduction `A <=p B` transforms any instance of A into an instance of B with the same yes/no answer. Thus an efficient B solver would give an efficient A solver. To show B is NP-hard, reduce a known NP-hard problem **to B**, not B to the known problem. To establish NP-completeness, also show B belongs to NP.

Optimization problems are often called NP-hard; NP-completeness formally applies to their decision forms. A pseudopolynomial algorithm, such as capacity-based knapsack DP, does not imply P=NP because numeric magnitude can be exponential in its representation length. NP-hard does not mean every instance is impossible, or that every exact algorithm must enumerate every candidate.

## Worked visual

```text
To show problem B is NP-hard:

known hard problem A
         |
         | polynomial-time transformation preserving yes/no
         v
    instance of B
         |
         | hypothetical efficient B solver
         v
    efficient answer for A

The reduction direction is A -> B.
```

## Responding to hardness

Inspect structure and constraints before giving up. A problem may become tractable on trees, DAGs, bounded-size universes, or bounded parameters. For small n, exponential search with pruning or subset DP may be entirely suitable. For small numeric targets, pseudopolynomial DP may work. Other options include approximation, randomized methods, and domain-specific heuristics, each with explicit guarantees.

A fixed-parameter algorithm has time `f(k)*n^c` where c is independent of parameter k. This differs from `n^k`, whose polynomial degree grows with k. Parameterization identifies which part of the input causes the combinatorial explosion.

## Approximation with a proof

For minimum vertex cover, repeatedly choose an uncovered edge, add **both** endpoints to the cover, and delete all incident edges. The chosen edges form a matching: they share no endpoints. Any cover needs at least one vertex for each such edge, so `OPT>=numberOfChosenEdges`. The algorithm uses twice that many vertices and covers every edge, proving a factor-two approximation.

This proof separates feasibility from quality. A heuristic that often performs well on examples is not an approximation algorithm with a guaranteed ratio unless such a bound is established. For minimization, the usual ratio compares algorithm cost to OPT; for maximization, state the convention to avoid reversing inequalities.

## Computational geometry: robust predicates first

For points a,b,c, the sign of `(bx-ax)*(cy-ay)-(by-ay)*(cx-ax)` determines orientation: counterclockwise, clockwise, or collinear. Orientation supports segment intersection, point-in-polygon methods, and convex hull construction. Cast before subtracting if int coordinates can differ beyond int range; even long products can overflow for unrestricted 32-bit coordinates. Use bounds or exact arithmetic where needed.

Segment intersection needs both orientation tests and a collinear bounding-box check. A strict sign-only test misses touching endpoints and overlapping collinear segments. Define whether touching counts as intersection.

The monotone-chain convex hull sorts points lexicographically, then builds lower and upper chains by popping turns inconsistent with convexity. Each point is pushed/popped at most once per chain, so sorting dominates at `O(n log n)`. Choose whether collinear boundary points should be retained; deduplicate points and test all-collinear input. Floating-point tolerances must match the application's scale and robustness requirements.

## Persistence, rollback, and offline algorithms

A persistent structure retains access to old versions. A persistent segment tree copies only nodes on an updated root-to-leaf path and shares untouched subtrees, using `O(log n)` new nodes per point update after a linear initial build. Old roots must never observe mutation of shared nodes.

Rollback DSU logs changed parent/size fields so updates can be undone. It commonly avoids path compression, whose many writes complicate rollback; union by size alone gives logarithmic find depth. Combining rollback with a segment tree over time can answer offline connectivity under additions and deletions by applying edges exactly during their active intervals.

Offline means all queries are known in advance and may be reordered or grouped. An online problem must respond as input arrives. An offline optimization is invalid if immediate output is part of the contract. Mo's algorithm reorders static range queries to reduce window-boundary movement, typically to `O((n+q)*sqrt(n))` movement with a suitable block order; each add/remove must be supported efficiently, and sorting queries adds its own cost.

## External memory and probabilistic summaries

When data exceeds memory, disk/block transfers can dominate CPU operations. External merge sort creates sorted runs that fit in memory, then merges several runs using buffers. A B-tree stores many children per node to reduce tree height in block accesses; its branching factor is tied to block capacity. A pointer-heavy binary tree with the same comparison count may have far more I/O.

A Bloom filter stores bits set by several hashes. A query finding a zero bit proves absence; all-one bits mean “possibly present.” Standard insertion-only filters have false positives but no false negatives when implemented correctly. Clearing bits for deletion can introduce false negatives unless a suitable counting/deletion scheme is used.

A Count-Min Sketch approximates nonnegative stream frequencies with hashed counter rows, taking the minimum estimate across rows. Collisions only inflate counts in the insertion-only model; accuracy and failure probability depend on table dimensions and hashing assumptions. These summaries trade exactness for bounded storage and cannot replace exact algorithms when the contract forbids errors.

## More specialist directions

- **A\* search:** prioritize `g+h`. An admissible heuristic never overestimates remaining cost. Graph search that permanently closes states needs consistency or a correct reopening strategy; `h=0` reduces to Dijkstra for nonnegative edges.
- **FFT / NTT:** polynomial multiplication becomes pointwise multiplication after a transform, yielding near-linear convolution algorithms. Floating-point error or modular-root requirements are part of correctness, not implementation trivia.
- **Heavy-light decomposition:** split tree paths into logarithmically many chains, then use a segment tree; a typical path query takes `O(log^2 V)`.
- **Suffix trees / suffix automata:** index substring structure with different invariants and space tradeoffs. Linear-time claims require alphabet and implementation assumptions.
- **Game DP:** on finite acyclic impartial normal-play games, a state is losing iff all legal successors are winning. Sprague-Grundy values use the mex of successor values and XOR for independent sums; these rules do not apply to arbitrary games with draws or hidden information.

## Explain it in English

> “The unrestricted problem is hard, but this constraint may permit a different algorithm or guarantee.”

**Vocabulary:** reduction, certificate, NP-hard, approximation ratio, persistent, offline, admissible.

## Practice

Attempt the [unit 24 exercise set](../../03_problems/02_practice/24_complexity-and-advanced-design/README.md). Exercises and hints live in `03_problems/`; this chapter contains the theory.

## Attribution and references

**Provenance:** This chapter is a synthesis of the sources mapped below. Standard definitions, algorithms and proof techniques belong to those established references; the explanatory wording, traces, diagrams and Java examples were written for this repository. No source passage is quoted verbatim.

| Section / claim | Source used | How it is used |
|---|---|---|
| P, NP and reduction direction | [Jeff Erickson, Algorithms, chapter 12: NP-Hardness](https://jeffe.cs.illinois.edu/teaching/algorithms/book/12-nphard.pdf) | Definitions and hardness-proof structure. |
| Persistence and memory models | [Erik Demaine, MIT 6.851 lecture catalogue (Spring 2012)](https://courses.csail.mit.edu/6.851/spring12/lectures/) | Lecture catalogue and associated notes; extension material. |
| Geometry and specialist techniques | [Antti Laaksonen, Competitive Programmer's Handbook (2018 draft)](https://cses.fi/book/book.pdf) | Geometry and advanced-algorithm sections. |
| Approximation and advanced directions | [Jeff Erickson, Algorithms and supplementary notes](https://jeffe.cs.illinois.edu/teaching/algorithms/) | Supplementary approximation/FFT/streaming notes; extension reading. |

See [SOURCES.md](../../SOURCES.md) for editions, review scope, and the distinction between consulted material and further reading.

---

<!-- study-navigation -->
[← Previous: Unit 23](../08_graphs/23-advanced-graphs-and-flow.md) · [Index](../../README.md#study-index) · [Next: Unit 25 →](../14_problem-solving/25-solving-testing-and-communication.md)
<!-- /study-navigation -->
