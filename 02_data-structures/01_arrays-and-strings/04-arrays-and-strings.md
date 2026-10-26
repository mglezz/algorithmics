# 04A - Arrays and Strings

<!-- study-navigation -->
[← Previous: Unit 03](../../01_algorithms/01_foundations/03-java-for-interviews.md) · [Index](../../README.md#study-index) · [Next: Unit 04B →](../../01_algorithms/02_range-queries/04-prefix-sums-and-difference-arrays.md)
<!-- /study-navigation -->

[Curriculum](../../CURRICULUM.md) | [Quick reference](../../04_notes/patterns.md) | [Companion chapter](../../01_algorithms/02_range-queries/04-prefix-sums-and-difference-arrays.md)

> **Core idea:** Arrays give indexed access; insertion costs and string representation still depend on the operation.

## On this page

- [Representation and operations](#representation-and-operations)
- [Worked visual](#worked-visual)
- [Transformations and in-place invariants](#transformations-and-in-place-invariants)
- [Explain it in English](#explain-it-in-english)
- [Practice](#practice)
- [Attribution and references](#attribution-and-references)

## Representation and operations

An array stores an indexed sequence. Indexed access is constant time in the usual model. Inserting in the middle of a packed sequence shifts a suffix, so the cost is linear. A dynamic array separates logical size from allocated capacity; geometric resizing provides amortized constant append, not constant worst-case append.

Adjacent storage usually improves locality. A linked list avoids shifting when you already have the relevant node, but sacrifices constant indexed access and adds references. Select from the required operations rather than declaring one structure universally faster.

For matrix algorithms, establish whether rows can be empty or different lengths. Java `int[][]` is an array of arrays. A rectangular `R*C` scan costs `Theta(RC)`; storing a visited matrix also costs `Theta(RC)`.

## Worked visual

| Operation on n packed entries | Cost | Reason |
|---|---|---|
| Read index i | O(1) | Direct addressing |
| Insert at the front | O(n) | Shift existing entries |
| Append to a dynamic array | O(1) amortized | Occasional geometric resizing |
| Copy all entries | O(n) | Write every copied position |

## Transformations and in-place invariants

To compact values satisfying a predicate, scan with `read` and write accepted values at `write`. Before each iteration, `[0,write)` is exactly the accepted subsequence of `[0,read)`, preserving order. Since `write<=read`, a write never destroys unread data. Return `write`; the suffix is irrelevant.

To rotate an array by `k`, normalize `k` modulo nonzero `n`, then reverse suitable segments. For a right rotation: reverse the whole array, reverse the first `k`, reverse the rest. Prove it by splitting the original sequence into `A B` and tracking each reversal until it becomes `B A`.

For strings, distinguish substring from subsequence, code units from code points, and mutable buffers from immutable values. If you sort characters as a canonical key, you lose original order intentionally; this fits anagram grouping but not general string identity.

## Explain it in English

> “Indexed access is constant time, but inserting into a packed middle shifts the suffix.”

**Vocabulary:** contiguous, prefix, suffix, sentinel, half-open interval, preprocessing.

## Practice

Attempt the [unit 04 exercise set](../../03_problems/02_practice/04-arrays-strings-and-prefix-sums.md). Exercises and hints live in `03_problems/`; this chapter contains the theory.

## Attribution and references

**Provenance:** This chapter is a synthesis of the sources mapped below. Standard definitions, algorithms and proof techniques belong to those established references; the explanatory wording, traces, diagrams and Java examples were written for this repository. No source passage is quoted verbatim.

| Section / claim | Source used | How it is used |
|---|---|---|
| Indexed storage and resizing | [Pat Morin, Open Data Structures, chapter 2](https://opendatastructures.org/ods-java/2_Array_Based_Lists.html) | Representation and operation bounds. |
| String representation | [Oracle Java 21: String](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/String.html) | Java-specific contract. |

See [SOURCES.md](../../SOURCES.md) for editions, review scope, and the distinction between consulted material and further reading.

---

<!-- study-navigation -->
[← Previous: Unit 03](../../01_algorithms/01_foundations/03-java-for-interviews.md) · [Index](../../README.md#study-index) · [Next: Unit 04B →](../../01_algorithms/02_range-queries/04-prefix-sums-and-difference-arrays.md)
<!-- /study-navigation -->
