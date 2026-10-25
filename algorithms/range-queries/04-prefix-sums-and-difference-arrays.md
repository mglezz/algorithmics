# 04B - Prefix Sums and Difference Arrays

[Curriculum](../../CURRICULUM.md) | [Quick reference](../../notes/patterns.md) | [Companion chapter](../../data-structures/arrays-and-strings/04-arrays-and-strings.md)

> **Core idea:** Represent sequences explicitly, then exploit cancellation only when the aggregate supports it.

## On this page

- [Prefix aggregation](#prefix-aggregation)
- [Worked visual](#worked-visual)
- [Two-dimensional prefixes](#two-dimensional-prefixes)
- [Difference arrays: deferred updates](#difference-arrays-deferred-updates)
- [Practice](#practice)
- [Attribution and references](#attribution-and-references)

## Prefix aggregation

For an array `a` of length `n`, define `prefix[0]=0` and `prefix[i+1]=prefix[i]+a[i]`. Then the sum over `[left,right)` is `prefix[right]-prefix[left]`. Preprocessing costs `Theta(n)` time and space, each query `Theta(1)`. This is useful for many queries on unchanged data; updating one array item changes an entire suffix of the prefix array.

Why it works: the first `left` terms occur in both prefixes and cancel. The half-open convention gives length `right-left` and makes empty ranges return zero without a special formula.

```java
static long[] prefixSums(int[] values) {
    long[] prefix = new long[values.length + 1];
    for (int i = 0; i < values.length; i++) {
        prefix[i + 1] = prefix[i] + values[i];
    }
    return prefix;
}
```

For `[5,-2,7,1]`, prefixes are `[0,5,3,10,11]`; `[1,3)` sums to `10-5=5`. The method assumes a nonnull input and uses long to hold sums of int elements.

Prefix XOR supports the analogous cancellation because `x XOR x=0`. Prefix minimum does not support arbitrary range minimum by subtraction: a minimum outside the query can hide all information about the inside. The required algebra determines which preprocessing works.

## Worked visual

```text
index:        0   1   2   3
value:        5  -2   7   1
prefix index: 0   1   2   3   4
prefix sum:   0   5   3  10  11

range [1,3): prefix[3] - prefix[1] = 10 - 5 = 5
```

## Two-dimensional prefixes

Use a padded `(R+1)*(C+1)` table. Let `P[r][c]` sum rows before `r` and columns before `c`:

```text
P[r+1][c+1] = a[r][c] + P[r][c+1] + P[r+1][c] - P[r][c]
rectangle([r1,r2), [c1,c2)) =
    P[r2][c2] - P[r1][c2] - P[r2][c1] + P[r1][c1]
```

The overlap is subtracted twice and therefore added back once. Preprocessing is `O(RC)`; each rectangle query is constant time. Establish numerical bounds for the entire matrix, not just a cell.

## Difference arrays: deferred updates

For many additions of `delta` to `[left,right)`, maintain an initially zero difference array of length `n+1`. Add `delta` at `left`, subtract it at `right`, then take prefix sums once at the end. Each update costs `O(1)`, and reconstructing all values costs `O(n)`; total `O(q+n)` for `q` updates. Add the reconstructed increments to the original array.

The start event turns the increment on; the end event turns it off. This is an offline technique: if queries must be answered between updates, consider Fenwick or segment trees. The same corner-event principle extends to rectangle additions in two dimensions.

## Practice

Attempt the [unit 04 exercise set](../../problems/practice/04-arrays-strings-and-prefix-sums.md). Exercises and hints live in `problems/`; this chapter contains the theory.

## Attribution and references

**Provenance:** This chapter is a synthesis of the sources mapped below. Standard definitions, algorithms and proof techniques belong to those established references; the explanatory wording, traces, diagrams and Java examples were written for this repository. No source passage is quoted verbatim.

| Section / claim | Source used | How it is used |
|---|---|---|
| Prefix and difference techniques | [Antti Laaksonen, Competitive Programmer's Handbook (2018 draft)](https://cses.fi/book/book.pdf) | Range queries and range-update sections; standard formulas independently derived here. |
| Cancellation and boundary events | This repository | Formulas and worked trace derived in this repository. |

See [SOURCES.md](../../SOURCES.md) for editions, review scope, and the distinction between consulted material and further reading.
