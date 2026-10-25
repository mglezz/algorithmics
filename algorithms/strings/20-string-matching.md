# 20B - String Matching

[Curriculum](../../CURRICULUM.md) | [Quick reference](../../notes/patterns.md) | [Companion chapter](../../data-structures/tries/20-tries.md)

> **Core idea:** Shared prefixes let a trie share storage and let a matcher reuse already established comparisons.

## On this page

- [State the string model](#state-the-string-model)
- [Worked visual](#worked-visual)
- [KMP: keep the longest reusable border](#kmp-keep-the-longest-reusable-border)
- [Other matching tools](#other-matching-tools)
- [Explain it in English](#explain-it-in-english)
- [Practice](#practice)
- [Attribution and references](#attribution-and-references)

## State the string model

Let text length be n and pattern length m, measured in the same symbol units. Java examples below use UTF-16 code units, matching `String.charAt` indexing. If code-point or user-perceived-character behavior is needed, transform or segment deliberately and account for index conversion. Define empty-pattern behavior and whether overlapping occurrences count.

The naive search tries every alignment and compares symbols until mismatch, taking `O(nm)` worst-case time. Repeated prefixes such as many `a` symbols followed by a differing symbol expose repeated work.

## Worked visual

| Pattern position | Symbol | Longest proper border length |
|---|---|---|
| 0 | a | 0 |
| 1 | b | 0 |
| 2 | a | 1 |
| 3 | b | 2 |
| 4 | a | 3 |
| 5 | c | 0 |
| 6 | a | 1 |

## KMP: keep the longest reusable border

A **border** of a string is a proper prefix that is also a suffix. Let `pi[i]` be the length of the longest border of the pattern prefix ending at i. When a partial match of length j fails, any reusable suffix must also be a prefix; the next candidate length is `pi[j-1]`. Repeated fallback visits only valid shorter borders, avoiding rescanning the text.

```java
static int[] prefixFunction(String pattern) {
    int[] pi = new int[pattern.length()];
    for (int i = 1; i < pattern.length(); i++) {
        int j = pi[i - 1];
        while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
            j = pi[j - 1];
        }
        if (pattern.charAt(i) == pattern.charAt(j)) j++;
        pi[i] = j;
    }
    return pi;
}

static int firstMatch(String text, String pattern) {
    if (pattern.isEmpty()) return 0;
    int[] pi = prefixFunction(pattern);
    int matched = 0;
    for (int i = 0; i < text.length(); i++) {
        while (matched > 0 && text.charAt(i) != pattern.charAt(matched)) {
            matched = pi[matched - 1];
        }
        if (text.charAt(i) == pattern.charAt(matched)) matched++;
        if (matched == pattern.length()) return i - matched + 1;
    }
    return -1;
}
```

Contract: nonnull strings; return the first match index, zero for an empty pattern, and `-1` if absent. For pattern `ababaca`, the prefix values are `[0,0,1,2,3,0,1]`. In the search, `matched` summarizes the longest pattern prefix matching the text suffix processed so far. Fallback strictly decreases it; forward progress increases it by at most one per text symbol. This aggregate argument gives `O(n+m)` time and `O(m)` space, despite the inner while loop.

To report all matches including overlaps, emit an index on a complete match and reset `matched=pi[m-1]` rather than zero. Handle the empty pattern separately to avoid indexing it.

## Other matching tools

The **Z-array** stores, for each position, the length matching the string's prefix. Maintain a rightmost known prefix-matching interval; initialize positions inside it from earlier Z values, capped by the interval boundary, then extend if needed. Successful comparisons beyond the boundary advance it, yielding linear time. Searching in `pattern + separator + text` requires a separator outside the alphabet or an integer encoding with a reserved symbol.

**Rolling hashes** assign arithmetic fingerprints to substrings. Prefix hashes and precomputed powers allow constant-time substring fingerprints after linear preprocessing under fixed-width modular operations. Equal hashes are candidates, not a deterministic proof of equality. Verify candidate matches for exact correctness, accepting potential worst-case verification cost; multiple independent hashes reduce collision risk but do not eliminate it. Guard modular multiplication overflow.

**Aho-Corasick** combines a trie of many patterns with failure links to the longest suffix that is a trie prefix. With a fixed alphabet and an appropriate automaton construction, scan time is `O(textLength + numberOfReportedMatches)` after preprocessing proportional to automaton size times alphabet size. Sparse transition implementations need their own cost accounting.

**Suffix arrays** order all suffixes lexicographically. An accompanying LCP array summarizes adjacent common prefixes and supports repeated-substring analysis. A basic comparison-sort doubling construction is `O(n log^2 n)`; using integer/radix sorting per round reduces it to `O(n log n)`. Avoid constructing and comparing every full suffix as copied strings while claiming these bounds.

## Explain it in English

> “After this mismatch, only a suffix that is also a pattern prefix can still be useful.”

**Vocabulary:** border, failure link, prefix function, terminal node, collision, overlapping match.

## Practice

Attempt the [unit 20 exercise set](../../problems/practice/20-tries-and-string-matching.md). Exercises and hints live in `problems/`; this chapter contains the theory.

## Attribution and references

**Provenance:** This chapter is a synthesis of the sources mapped below. Standard definitions, algorithms and proof techniques belong to those established references; the explanatory wording, traces, diagrams and Java examples were written for this repository. No source passage is quoted verbatim.

| Section / claim | Source used | How it is used |
|---|---|---|
| KMP borders and fallback | [Cornell CS312, lecture 25 (Spring 2002)](https://www.cs.cornell.edu/courses/cs312/2002sp/lectures/lec25.htm) | KMP section; re-expressed using a zero-based prefix table. |
| String-matching families | [Jeff Erickson, supplementary notes: String Matching](https://jeffe.cs.illinois.edu/teaching/algorithms/notes/07-strings.pdf) | Matching and fingerprinting concepts. |
| Tries, Z and suffix structures | [Antti Laaksonen, Competitive Programmer's Handbook (2018 draft)](https://cses.fi/book/book.pdf) | String-algorithm material; alphabet and implementation qualifications added here. |

See [SOURCES.md](../../SOURCES.md) for editions, review scope, and the distinction between consulted material and further reading.
