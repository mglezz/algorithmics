# 04 - Arrays, Strings, Prefix Sums, and Difference Arrays

[Curriculum](README.md) | Prerequisites: 01-03

## Representation and operations

An array stores an indexed sequence. Indexed access is constant time in the usual model. Inserting in the middle of a packed sequence shifts a suffix, so the cost is linear. A dynamic array separates logical size from allocated capacity; geometric resizing provides amortized constant append, not constant worst-case append.

Adjacent storage usually improves locality. A linked list avoids shifting when you already have the relevant node, but sacrifices constant indexed access and adds references. Select from the required operations rather than declaring one structure universally faster.

For matrix algorithms, establish whether rows can be empty or different lengths. Java `int[][]` is an array of arrays. A rectangular `R*C` scan costs `Theta(RC)`; storing a visited matrix also costs `Theta(RC)`.

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

## Transformations and in-place invariants

To compact values satisfying a predicate, scan with `read` and write accepted values at `write`. Before each iteration, `[0,write)` is exactly the accepted subsequence of `[0,read)`, preserving order. Since `write<=read`, a write never destroys unread data. Return `write`; the suffix is irrelevant.

To rotate an array by `k`, normalize `k` modulo nonzero `n`, then reverse suitable segments. For a right rotation: reverse the whole array, reverse the first `k`, reverse the rest. Prove it by splitting the original sequence into `A B` and tracking each reversal until it becomes `B A`.

For strings, distinguish substring from subsequence, code units from code points, and mutable buffers from immutable values. If you sort characters as a canonical key, you lose original order intentionally; this fits anagram grouping but not general string identity.

## Practice

1. Return the index whose left and right sums agree, or `-1` if none exists.
2. Apply `q` inclusive range increments to an array; translate the contract into half-open events.
3. Answer rectangle-sum queries and test a single cell, a full matrix, and an empty-width rectangle.
4. Compute all products except self without division. Account for zeros and overflow.

<details><summary>Hints and checkpoints</summary>

1. Maintain a running left sum and use `total-left-a[i]` for the right sum; `O(n)` time, `O(1)` auxiliary space.
2. Subtract at `right+1`; allocate a sentinel position beyond the last valid index.
3. The four-prefix formula must return zero for an empty rectangle.
4. Combine a left product and a right product; the output array can store the left products. Zero counts matter if using a total-product approach.

</details>

**Explain aloud:** “I spend linear preprocessing time to answer each later range query in constant time.” Vocabulary: contiguous, prefix, suffix, sentinel, half-open interval, preprocessing.

## Sources

- [Open Data Structures, Array-Based Lists](https://opendatastructures.org/ods-java/2_Array_Based_Lists.html): indexed storage, shifts, resizing.
- [Oracle String API](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/String.html): string representation and operations.
- [MIT 6.006 notes](https://ocw.mit.edu/courses/6-006-introduction-to-algorithms-spring-2020/pages/lecture-notes/), lecture 2: sequence representations. Prefix and difference formulas above are derived directly by cancellation.
