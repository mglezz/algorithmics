# 20A - Tries

[Curriculum](../../CURRICULUM.md) | [Quick reference](../../notes/patterns.md) | [Companion chapter](../../algorithms/strings/20-string-matching.md)

> **Core idea:** A trie shares storage for common prefixes and distinguishes complete words from extendable prefixes.

## On this page

- [State the string model](#state-the-string-model)
- [Worked visual](#worked-visual)
- [Tries: share prefixes structurally](#tries-share-prefixes-structurally)
- [Operation walkthrough](#operation-walkthrough)
- [Practice](#practice)
- [Attribution and references](#attribution-and-references)

## State the string model

Let text length be n and pattern length m, measured in the same symbol units. Java examples below use UTF-16 code units, matching `String.charAt` indexing. If code-point or user-perceived-character behavior is needed, transform or segment deliberately and account for index conversion. Define empty-pattern behavior and whether overlapping occurrences count.

For pattern search in a long text, continue with the companion string-matching chapter; a trie primarily organizes a dictionary of keys.

## Worked visual

```text
Words: car, cart, cat

(root)
   | c
   a
  / \
 r*  t*
 |
 t*

* marks a complete word. The r node is terminal and still has a child.
```

## Tries: share prefixes structurally

A trie edge represents a symbol; the root represents the empty prefix. Insert a word by following or creating one edge per symbol, and mark its final node terminal. Terminal status is separate from having children: `car` can be a word while `cart` extends it.

With constant-time child access, insertion and exact/prefix lookup cost `O(L)` for a length-L key. A fixed alphabet array gives predictable access but can waste space: if there are N trie nodes and alphabet size sigma, child arrays occupy `O(N*sigma)`. Sparse child maps store only present edges, with their own lookup guarantees. N is at most one plus the total inserted length before accounting for shared prefixes.

Autocomplete first finds the prefix node, then traverses descendants. Its cost includes the explored subtree and output; listing many completions cannot be only `O(prefixLength)`. Deletion must retain nodes needed by other words and distinguish word frequency from prefix count if duplicates are supported.

## Operation walkthrough

| Operation | Steps | Contract |
|---|---|---|
| Insert cart | Follow c, a, r, t; create missing nodes; mark t | Inserting a prefix does not remove longer words |
| Search car | Follow c, a, r; inspect terminal flag | A path alone is not proof of an exact word |
| Search prefix ca | Follow c, a | Terminal flag is irrelevant to prefix existence |
| Delete car | Clear its terminal flag; prune only unused nonterminal nodes | Preserve cart and cat |

## Practice

Attempt the [unit 20 exercise set](../../problems/practice/20-tries-and-string-matching.md). Exercises and hints live in `problems/`; this chapter contains the theory.

## Attribution and references

**Provenance:** This chapter is a synthesis of the sources mapped below. Standard definitions, algorithms and proof techniques belong to those established references; the explanatory wording, traces, diagrams and Java examples were written for this repository. No source passage is quoted verbatim.

| Section / claim | Source used | How it is used |
|---|---|---|
| Trie representation and dictionary operations | [Antti Laaksonen, Competitive Programmer's Handbook (2018 draft)](https://cses.fi/book/book.pdf) | Chapter 26, string algorithms; standard prefix-sharing representation. |
| Choice of Java symbol units | [Oracle Java 21: String](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/String.html) | UTF-16 indices; code points require a different representation. |

See [SOURCES.md](../../SOURCES.md) for editions, review scope, and the distinction between consulted material and further reading.
