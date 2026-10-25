# 20 - Tries and String Matching

[Curriculum](README.md) | Prerequisites: 04-05, 12

## State the string model

Let text length be n and pattern length m, measured in the same symbol units. Java examples below use UTF-16 code units, matching `String.charAt` indexing. If code-point or user-perceived-character behavior is needed, transform or segment deliberately and account for index conversion. Define empty-pattern behavior and whether overlapping occurrences count.

The naive search tries every alignment and compares symbols until mismatch, taking `O(nm)` worst-case time. Repeated prefixes such as many `a` symbols followed by a differing symbol expose repeated work.

## Tries: share prefixes structurally

A trie edge represents a symbol; the root represents the empty prefix. Insert a word by following or creating one edge per symbol, and mark its final node terminal. Terminal status is separate from having children: `car` can be a word while `cart` extends it.

With constant-time child access, insertion and exact/prefix lookup cost `O(L)` for a length-L key. A fixed alphabet array gives predictable access but can waste space: if there are N trie nodes and alphabet size sigma, child arrays occupy `O(N*sigma)`. Sparse child maps store only present edges, with their own lookup guarantees. N is at most one plus the total inserted length before accounting for shared prefixes.

Autocomplete first finds the prefix node, then traverses descendants. Its cost includes the explored subtree and output; listing many completions cannot be only `O(prefixLength)`. Deletion must retain nodes needed by other words and distinguish word frequency from prefix count if duplicates are supported.

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

## Practice

1. Extend KMP to return overlapping matches; test `aaa` inside `aaaaa`.
2. Implement a trie with exact lookup, prefix lookup, and deletion.
3. Find the shortest repeating period of a string from its prefix function.
4. Explain the tradeoff between KMP's deterministic guarantee and hash-based substring comparison.

<details><summary>Hints and checkpoints</summary>

1. The valid indices are zero, one, and two.
2. Deleting `car` must not delete `cart`; prefix existence does not imply word existence.
3. Candidate period is `n-pi[n-1]`; it tiles the nonempty string only if it divides n.
4. Hash equality needs collision handling; KMP compares actual symbols and reuses border structure.

</details>

**Explain aloud:** “After this mismatch, only a suffix that is also a pattern prefix can still be useful.” Vocabulary: border, failure link, prefix function, terminal node, collision, overlapping match.

## Sources

- [Cornell CS312, String Matching](https://www.cs.cornell.edu/courses/cs312/2002sp/lectures/lec25.htm): KMP fallback reasoning.
- [Erickson, String Matching](https://jeffe.cs.illinois.edu/teaching/algorithms/notes/07-strings.pdf): deterministic and randomized matching approaches.
- [CMU String Algorithms course](https://www.cs.cmu.edu/~02414/schedule.html): advanced study of matching, suffix arrays, suffix trees, and alignment.
