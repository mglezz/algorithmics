# 15 - Weighted Shortest Paths

<!-- study-navigation -->
[← Previous: Unit 14B](14-traversal-and-topological-order.md) · [Index](../../README.md#study-index) · [Next: Unit 16A →](../../02_data-structures/08_disjoint-sets/16-disjoint-sets.md)
<!-- /study-navigation -->

[Curriculum](../../CURRICULUM.md) | [Quick reference](../../04_notes/graphs.md)

> **Core idea:** Weight assumptions determine when tentative distances can safely become final.

## On this page

- [Relaxation is the common operation](#relaxation-is-the-common-operation)
- [Worked visual](#worked-visual)
- [Dijkstra: why nonnegative matters](#dijkstra-why-nonnegative-matters)
- [Special relaxation orders](#special-relaxation-orders)
- [Bellman-Ford and negative cycles](#bellman-ford-and-negative-cycles)
- [Floyd-Warshall and Johnson](#floyd-warshall-and-johnson)
- [Explain it in English](#explain-it-in-english)
- [Practice](#practice)
- [Attribution and references](#attribution-and-references)

## Relaxation is the common operation

Maintain tentative distance `d[v]`, initially zero at a source and infinity elsewhere. Relax edge `u -> v` of weight `w` by replacing `d[v]` with `d[u]+w` when that is smaller. Also store a predecessor if a path is needed. Do not add a weight to an infinity sentinel; ensure finite sums fit the chosen type.

An edge relaxation improves an upper bound on the true shortest distance. Algorithms differ mainly in the order and number of relaxations, and in the assumptions making that schedule sufficient.

| Edge / graph condition | Algorithm | Typical time with adjacency lists |
|---|---|---|
| Equal nonnegative edge costs | BFS | `O(V+E)` |
| Weights only 0 or 1 | 0-1 BFS with deque | `O(V+E)` |
| DAG, including negative weights | Topological relaxation | `O(V+E)` |
| Nonnegative weights | Dijkstra with binary heap | See heap-variant distinction below |
| General weights, one source | Bellman-Ford | `O(VE)` |
| All pairs, moderate V | Floyd-Warshall | `O(V^3)` time, `O(V^2)` space |

## Worked visual

| Action | d[a] | d[b] | Heap consequence |
|---|---|---|---|
| Relax edges from s | 7 | 2 | Queue (7,a) and (2,b) |
| Pop b; relax b -> a with weight 1 | 3 | 2 | Queue (3,a) |
| Pop a at distance 3 | 3 | 2 | Distance is final |
| Later pop (7,a) | 3 | 2 | Discard stale entry |

## Dijkstra: why nonnegative matters

Repeatedly settle the unsettled vertex with the smallest tentative distance. Suppose a shorter path to it existed. Along that path, consider the first unsettled vertex and its settled predecessor; relaxation would already have assigned that frontier vertex a distance no greater than the path's length to the chosen vertex, because remaining edge weights are nonnegative. This contradicts choosing the smallest tentative distance. Negative edges invalidate that finalization argument.

An indexed heap maintains one entry per unsettled vertex and supports decrease-key, yielding `O((V+E) log(V+1))` time and `O(V)` heap space. Java's standard priority queue has no such operation. A lazy version inserts a new immutable pair after every successful relaxation and skips entries whose distance no longer matches `d[vertex]`. It can hold `O(E)` entries and takes `O(V+E log(E+1))` time; for a simple graph this is commonly expressed as `O((V+E) log(V+1))`.

```text
d[source] = 0
push (0, source)
while heap is not empty:
    (distance, u) = pop minimum
    if distance != d[u]: continue
    for each edge (u, v, weight):
        candidate = distance + weight
        if candidate < d[v]:
            d[v] = candidate
            parent[v] = u
            push (candidate, v)
```

Example: `s->a:7`, `s->b:2`, `b->a:1`. The heap initially includes `(7,a)` and `(2,b)`. Processing b improves a to three; `(7,a)` later becomes stale. To stop at a target, wait until its current nonstale entry is popped, not when it is first discovered.

## Special relaxation orders

In a DAG, process vertices in topological order. Every predecessor has already had its best value computed, so one pass works even with negative weights. Acyclicity prevents revisiting a vertex along a path.

For weights zero or one, use a deque: a zero-weight improvement goes to the front, a one-weight improvement to the back. This preserves a frontier ordered by distance. Use a standard implementation that finalizes entries or discards stale entries; correctness and linear time depend on that discipline, not merely replacing a heap with a deque for arbitrary weights.

## Bellman-Ford and negative cycles

After `i` full relaxation passes, all shortest paths using at most `i` edges have been accounted for; in-place updates may discover additional paths earlier. Without reachable negative cycles, a shortest path can be chosen simple, so at most `V-1` edges suffice. An improvement on an additional pass proves a reachable negative cycle. Early termination is valid if a whole pass changes nothing.

A reachable negative cycle does not make every destination unbounded below: only destinations reachable from that cycle are affected. Propagate from vertices improved on the extra pass to mark them. An unreachable negative cycle does not affect a single-source query.

## Floyd-Warshall and Johnson

Let `D_k[i][j]` be the shortest distance allowing only the first `k` vertices as intermediates. Either an optimal route avoids the new intermediate or splits at it:

```text
D[i][j] = min(D[i][j], D[i][k] + D[k][j])
```

The `k` loop must be outermost. Initialize diagonal distances to zero, then minimize each entry over its actual edges, including negative self-loops. A negative self-loop must lower its diagonal below zero. Keep the minimum of parallel edge weights. Check reachability before addition. A negative diagonal after completion signals a negative cycle; relevant source/destination pairs then lack a finite shortest-walk value.

For sparse all-pairs problems, Johnson computes vertex potentials with Bellman-Ford and reweights edges to nonnegative values before running Dijkstra from each source. Potentials shift every path between the same endpoints by the same amount, preserving which path is shortest. This requires no negative cycle.

## Explain it in English

> “The edge weights determine when a tentative distance can safely become final.”

**Vocabulary:** relaxation, tentative, settle, predecessor, negative cycle, potential.

## Practice

Attempt the [unit 15 exercise set](../../03_problems/02_practice/15_shortest-paths/README.md). Exercises and hints live in `03_problems/`; this chapter contains the theory.

## Attribution and references

**Provenance:** This chapter is a synthesis of the sources mapped below. Standard definitions, algorithms and proof techniques belong to those established references; the explanatory wording, traces, diagrams and Java examples were written for this repository. No source passage is quoted verbatim.

| Section / claim | Source used | How it is used |
|---|---|---|
| Relaxation, negative cycles and shortest-path proofs | [Jeff Erickson, Algorithms, chapter 8: Shortest Paths](https://jeffe.cs.illinois.edu/teaching/algorithms/book/08-sssp.pdf) | Standard algorithms and assumptions. |
| DAG, Bellman-Ford, Dijkstra, Johnson and Floyd-Warshall | [Demaine, Ku and Solomon, MIT 6.006 (Spring 2020)](https://ocw.mit.edu/courses/6-006-introduction-to-algorithms-spring-2020/pages/lecture-notes/) | Lectures 11-14 and 18; algorithm-specific reasoning. |
| Lazy-heap implementation tradeoff | [Oracle Java 21: PriorityQueue](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/PriorityQueue.html) | Java heap API; operation counts are derived here. |

See [SOURCES.md](../../SOURCES.md) for editions, review scope, and the distinction between consulted material and further reading.

---

<!-- study-navigation -->
[← Previous: Unit 14B](14-traversal-and-topological-order.md) · [Index](../../README.md#study-index) · [Next: Unit 16A →](../../02_data-structures/08_disjoint-sets/16-disjoint-sets.md)
<!-- /study-navigation -->
