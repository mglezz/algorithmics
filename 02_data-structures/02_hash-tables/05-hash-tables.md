# 05 - Hash Tables, Sets, and Canonical Keys

<!-- study-navigation -->
[← Previous: Unit 04B](../../01_algorithms/02_range-queries/04-prefix-sums-and-difference-arrays.md) · [Index](../../README.md#study-index) · [Next: Unit 06 →](../../01_algorithms/03_two-pointers/06-two-pointers-and-sliding-windows.md)
<!-- /study-navigation -->

[Curriculum](../../CURRICULUM.md) | [Quick reference](../../04_notes/data-structures.md)

> **Core idea:** A hash key summarizes equivalence; hashing narrows candidates but never replaces equality.

## On this page

- [From direct addressing to hashing](#from-direct-addressing-to-hashing)
- [Worked visual](#worked-visual)
- [Equality is the semantic contract](#equality-is-the-semantic-contract)
- [Worked reduction: count target-sum subarrays](#worked-reduction-count-target-sum-subarrays)
- [Frequent reductions](#frequent-reductions)
- [Explain it in English](#explain-it-in-english)
- [Practice](#practice)
- [Attribution and references](#attribution-and-references)

## From direct addressing to hashing

If keys are small integers in `[0,U)`, an array gives deterministic constant lookup using `O(U)` space. Hashing maps a larger universe into `m` buckets, storing only the keys present. Distinct keys can share a bucket: a collision is normal and does not imply equality.

In **separate chaining**, each bucket stores a collection of entries. With an appropriate uniform-hashing assumption and load factor `alpha=n/m`, expected lookup cost is `O(1+alpha)` plus hashing/equality costs. Keeping `alpha` bounded gives expected constant lookup. An adversarial collision pattern can make a simple chained table linear per lookup.

In **open addressing**, entries occupy slots in the table and collisions follow a probe sequence. Lookup must follow the same sequence as insertion. Deleting an entry cannot simply make its slot “never occupied,” because that could break a later key's probe chain. Tombstones or a carefully designed repair preserve reachability. As occupancy approaches full capacity, probes become expensive; keep spare capacity and rehash when needed.

Resizing redistributes entries because bucket positions depend on capacity. One resize may be linear. Geometric growth amortizes those rebuilding costs; hashing assumptions remain separately necessary for expected lookup behavior.

## Worked visual

| Endpoint processed | Prefix sum | Earlier equal prefixes | New zero-sum ranges |
|---|---|---|---|
| Before input | 0 | Seed one empty prefix | 0 |
| First zero | 0 | 1 | 1 |
| Second zero | 0 | 2 | 2 |

For `[0,0]`, the total is three. Query before inserting the current prefix.

## Equality is the semantic contract

Equal keys must hash equally. Equal hash codes do not prove equal keys; compare the actual keys after finding candidates. Use immutable keys or avoid mutation of equality-relevant fields while stored.

A canonical representation maps equivalent objects to identical keys. For anagrams over lowercase English letters, a 26-count vector is canonical; sorting characters is another option. With `n` words of length at most `L`, sorting keys costs `O(n L log L)`; counting keys costs `O(n(L+26))`, plus storing the output. State the alphabet restriction and implement value equality for the vector.

String concatenation without boundaries is not always an unambiguous composite key: `(1,23)` and `(12,3)` both yield `123`. Use a structured pair or an encoding with explicit lengths/separators that cannot be confused with data.

## Worked reduction: count target-sum subarrays

Let `P[j]` be the sum before index `j`. A nonempty range `[i,j)` sums to `target` iff `P[i]=P[j]-target`. Scan prefixes left to right and count how many **earlier** matching prefixes exist.

```java
static long countTargetSubarrays(int[] values, long target) {
    Map<Long, Long> frequency = new HashMap<>();
    frequency.put(0L, 1L);
    long prefix = 0;
    long count = 0;
    for (int value : values) {
        prefix += value;
        // The caller must ensure prefix - target fits in long.
        count += frequency.getOrDefault(prefix - target, 0L);
        frequency.put(prefix, frequency.getOrDefault(prefix, 0L) + 1);
    }
    return count;
}
```

Invariant: before counting the current endpoint, the map contains frequencies of exactly the earlier prefixes. Querying before insertion prevents counting an empty range when the target is zero. Seeding prefix zero counts ranges starting at index zero. A set would lose multiplicity: `[0,0]` has three nonempty zero-sum ranges.

For nonnull int input and a target for which the difference fits in long, this costs expected `O(n)` time and `O(n)` auxiliary space under suitable hash behavior. Negative values are allowed; no monotonicity of sums is needed. This is why it works where many sliding-window sum methods fail.

## Frequent reductions

- Two-sum: store prior values or their needed complements; query before insertion to avoid reusing one position.
- First unique item: count, then scan in original order; hash iteration order is not the answer order.
- Longest consecutive integer run: store a set and only expand from values with no predecessor. Each value belongs to one expanded run; guard integer boundary arithmetic.
- Deduplicate a stream: a set answers whether a value was seen, but exact storage grows with distinct values. A bounded-memory requirement changes the problem.

An ordered map is preferable when you need floor/ceiling queries, range scans, or guaranteed logarithmic operations. Hashing is not an ordering mechanism.

## Explain it in English

> “The key represents the information I need to recognize an equivalent earlier state.”

**Vocabulary:** collision, load factor, bucket, probe sequence, canonical representation, multiplicity.

## Practice

Attempt the [unit 05 exercise set](../../03_problems/02_practice/05-hash-tables.md). Exercises and hints live in `03_problems/`; this chapter contains the theory.

## Attribution and references

**Provenance:** This chapter is a synthesis of the sources mapped below. Standard definitions, algorithms and proof techniques belong to those established references; the explanatory wording, traces, diagrams and Java examples were written for this repository. No source passage is quoted verbatim.

| Section / claim | Source used | How it is used |
|---|---|---|
| Hash tables, collisions and probing | [Pat Morin, Open Data Structures, chapter 5](https://opendatastructures.org/ods-java/5_Hash_Tables.html) | Chaining/probing models and assumptions. |
| Java dictionary guarantees | [Oracle Java 21: HashMap](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/HashMap.html) | Documented key, hashing and iteration contract. |
| Prefix-state application | [Antti Laaksonen, Competitive Programmer's Handbook (2018 draft)](https://cses.fi/book/book.pdf) | Prefix/range-query ideas; the counting derivation and Java example are written here. |

See [SOURCES.md](../../SOURCES.md) for editions, review scope, and the distinction between consulted material and further reading.

---

<!-- study-navigation -->
[← Previous: Unit 04B](../../01_algorithms/02_range-queries/04-prefix-sums-and-difference-arrays.md) · [Index](../../README.md#study-index) · [Next: Unit 06 →](../../01_algorithms/03_two-pointers/06-two-pointers-and-sliding-windows.md)
<!-- /study-navigation -->
