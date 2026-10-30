# 20.02 - Trie Operations and Deletion

<!-- study-navigation -->
[← Previous: Exercise 20.01](../01_overlapping-kmp-matches/README.md) · [Index](../README.md) · [Next: Exercise 20.03 →](../03_shortest-repeating-period/README.md)
<!-- /study-navigation -->

[Practice index](../../README.md) | Theory: [Tries](../../../../02_data-structures/09_tries/20-tries.md) | [String Matching](../../../../01_algorithms/11_strings/20-string-matching.md)

**Status:** Not started. This is a repository-written practice prompt, not a recruiting question-bank item.

## Exercise

Implement a trie with `insert(String)`, `contains(String)`, `startsWith(String)` and `boolean delete(String)`, using char units. Duplicate insertions count separately; delete removes one occurrence and reports whether it existed. The empty string is allowed and startsWith("") is always true.

## Examples and checks

Insert car twice and cart once; deleting car twice removes car but preserves cart. A third deletion returns false. Test empty-string insertion and deletion.

## Your workspace

Write your Java 17 implementation and an executable test runner in `src/`. Use `AlgorithmXX_YY.java` and `MainXX_YY.java` with this exercise's numbers, or keep the existing class names. For data-structure exercises, use the requested class and a separate runner. Compare actual and expected results, including the cases above; throw `AssertionError` on a mismatch (or run Java assertions with `-ea`).

The deliverable is working Java code and checks. You may add a short explanation of the algorithm in `src/README.md`, like exercise 02.01; a formal proof or a separate theoretical answer is not required. Unless stated otherwise, inputs are non-null, indices and graph endpoints are valid, and auxiliary result types such as `Node` or `Selection` are yours to define.

<details><summary>Implementation hint</summary>

Keep a terminal count and prune only nonterminal nodes with no children.

### Java helper

Optional helper members for your class; add the necessary imports from java.util. Complete the public API and tests described above.

<!-- java-hint -->
```java
static final class TrieNode {
    final Map<Character, TrieNode> children = new HashMap<>();
    int terminalCount;
}

static TrieNode extend(TrieNode node, char symbol) {
    return node.children.computeIfAbsent(symbol, ignored -> new TrieNode());
}
```
<!-- /java-hint -->

</details>

## Your solution

Keep your Java implementation and executable checks in `src/`. Optionally add a short algorithm explanation in `src/README.md`. Record the attempt in [PROGRESS.md](../../../../PROGRESS.md).

---

<!-- study-navigation -->
[← Previous: Exercise 20.01](../01_overlapping-kmp-matches/README.md) · [Index](../README.md) · [Next: Exercise 20.03 →](../03_shortest-repeating-period/README.md)
<!-- /study-navigation -->
