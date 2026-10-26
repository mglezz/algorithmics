# 21 - Fenwick Trees, Segment Trees, and Sparse Tables

<!-- study-navigation -->
[← Previous: Unit 20B](../../01_algorithms/11_strings/20-string-matching.md) · [Index](../../README.md#study-index) · [Next: Unit 22 →](../../01_algorithms/12_mathematics/22-bits-number-theory-and-randomness.md)
<!-- /study-navigation -->

[Curriculum](../../CURRICULUM.md) | [Quick reference](../../04_notes/data-structures.md)

> **Core idea:** Choose a range structure from its combine operation and its update model.

## On this page

- [Choose from the algebra and update model](#choose-from-the-algebra-and-update-model)
- [Worked visual](#worked-visual)
- [Fenwick tree: binary prefix decomposition](#fenwick-tree-binary-prefix-decomposition)
- [Segment trees: combine disjoint intervals](#segment-trees-combine-disjoint-intervals)
- [Sparse tables and coordinate compression](#sparse-tables-and-coordinate-compression)
- [Explain it in English](#explain-it-in-english)
- [Practice](#practice)
- [Attribution and references](#attribution-and-references)

## Choose from the algebra and update model

First specify whether data changes, what an update changes, what a query combines, and whether operations arrive online. An associative combine operation allows grouping: `(a op b) op c = a op (b op c)`. An identity permits empty ranges. Inverses allow cancellation; idempotence means `x op x=x`, allowing overlap without changing the result. Sum is associative and invertible, but not idempotent; min is associative and idempotent, but lacks an inverse.

| Structure | Build | Query | Update | Typical use |
|---|---|---|---|---|
| Prefix sums | `O(n)` | `O(1)` range sum | `O(n)` affected suffix | Static sums |
| Fenwick tree | `O(n log n)` by repeated add; linear build exists | `O(log n)` | `O(log n)` point add | Dynamic prefix/range sums |
| Segment tree | `O(n)` | `O(log n)` interval aggregate | `O(log n)` point update | General associative aggregates |
| Sparse table | `O(n log n)` | `O(1)` for idempotent query | Rebuild in basic version | Static range minimum |
| Square-root decomposition | `O(n)` | Usually `O(sqrt n)` | Depends on aggregate | Simpler block-based tradeoffs |

## Worked visual

| Internal index | lowbit | Block covered (one-based, inclusive) |
|---|---|---|
| 13 | 1 | [13,13] |
| 12 | 4 | [9,12] |
| 8 | 8 | [1,8] |

Subtracting lowbit visits disjoint blocks whose union is the first 13 positions.

## Fenwick tree: binary prefix decomposition

Use internal one-based indices. Entry `tree[i]` stores the sum of the last `lowbit(i)=i & -i` positions ending at i. A prefix query repeatedly subtracts lowbit to visit disjoint blocks that exactly cover the prefix. A point addition repeatedly adds lowbit to visit the blocks containing that point.

```java
static final class Fenwick {
    private final long[] tree;

    Fenwick(int n) {
        if (n < 0 || n == Integer.MAX_VALUE) {
            throw new IllegalArgumentException("Unsupported size");
        }
        tree = new long[n + 1];
    }

    void add(int index, long delta) {
        if (index < 0 || index >= tree.length - 1) {
            throw new IndexOutOfBoundsException();
        }
        for (long i = (long) index + 1; i < tree.length; i += i & -i) {
            tree[(int) i] += delta;
        }
    }

    long prefixSum(int end) {
        if (end < 0 || end >= tree.length) throw new IndexOutOfBoundsException();
        long sum = 0;
        for (int i = end; i > 0; i -= i & -i) sum += tree[i];
        return sum;
    }

    long rangeSum(int left, int right) {
        if (left > right) throw new IllegalArgumentException("Reversed range");
        return prefixSum(right) - prefixSum(left);
    }
}
```

External indices are zero-based; `prefixSum(end)` queries `[0,end)`. Contract: updates, stored block sums, and results must fit in long. The add loop uses a long index to avoid signed int wraparound when stepping beyond the highest valid position. Each step changes a significant binary boundary, giving `O(log(n+1))` time. Storage and constructor initialization are `O(n)`.

For a prefix ending at internal index 13, queried blocks end at 13, 12, and 8, with lengths 1, 4, and 8. Their disjoint union covers positions one through thirteen. A point assignment requires knowing the old value and applying the difference.

## Segment trees: combine disjoint intervals

Recursively split `[0,n)` into halves; leaves represent values, internal nodes combine their children. A range query returns the identity on no overlap, the stored summary on full coverage, and combines child results on partial overlap. Only boundary paths keep splitting while fully covered middle blocks stop, giving logarithmic query time in the standard tree.

Associativity is necessary; commutativity is not. For string concatenation or matrix multiplication, preserve left-to-right order when combining. A static array implementation commonly allocates a linear-size buffer such as `4*n`, with size-arithmetic checks. An iterative tree is another layout.

### Lazy propagation

For range addition with range sums, a node covering length L changes its stored sum by `delta*L`. Store a pending delta for descendants; push it before partially descending, and recompute parents after child updates. A lazy tag is a transformation, not merely an extra number.

Tag composition order matters. Assignment followed by addition differs from addition followed by assignment. Define `apply(summary,tag,length)` and `compose(oldTag,newTag)` precisely. Use an explicit flag for “no pending assignment,” since assigning zero is a legitimate update. Incorrect composition often passes point-query tests but fails interleaved range operations.

## Sparse tables and coordinate compression

Store aggregates for intervals of length `2^k`. For a minimum query of length L, let `k=floor(log2 L)` and combine the two length-`2^k` blocks at its ends. They may overlap, but idempotence prevents double-counting problems. The same two-block formula is invalid for sum. Non-idempotent queries can combine disjoint blocks in logarithmic time, or use a different structure.

Coordinate compression sorts distinct coordinates and maps them to ranks. It preserves order and equality, not metric distance. If original coordinates are 10 and 1000, adjacent ranks do not mean distance one. Use original gaps for lengths and geometric measures. Compression enables Fenwick queries on large sparse coordinate domains after an `O(n log n)` sort.

## Explain it in English

> “This structure works because its combine operation is associative, and this shortcut additionally needs idempotence.”

**Vocabulary:** aggregate, identity, inverse, lazy propagation, composition, compression.

## Practice

Attempt the [unit 21 exercise set](../../03_problems/02_practice/21_range-query-data-structures/README.md). Exercises and hints live in `03_problems/`; this chapter contains the theory.

## Attribution and references

**Provenance:** This chapter is a synthesis of the sources mapped below. Standard definitions, algorithms and proof techniques belong to those established references; the explanatory wording, traces, diagrams and Java examples were written for this repository. No source passage is quoted verbatim.

| Section / claim | Source used | How it is used |
|---|---|---|
| Fenwick blocks, segment trees and lazy updates | [Antti Laaksonen, Competitive Programmer's Handbook (2018 draft)](https://cses.fi/book/book.pdf) | Range-query and advanced-segment-tree sections. |
| Persistence and advanced range structures | [Erik Demaine, MIT 6.851 lecture catalogue (Spring 2012)](https://courses.csail.mit.edu/6.851/spring12/lectures/) | Further study; not the source of the introductory Fenwick code. |

See [SOURCES.md](../../SOURCES.md) for editions, review scope, and the distinction between consulted material and further reading.

---

<!-- study-navigation -->
[← Previous: Unit 20B](../../01_algorithms/11_strings/20-string-matching.md) · [Index](../../README.md#study-index) · [Next: Unit 22 →](../../01_algorithms/12_mathematics/22-bits-number-theory-and-randomness.md)
<!-- /study-navigation -->
