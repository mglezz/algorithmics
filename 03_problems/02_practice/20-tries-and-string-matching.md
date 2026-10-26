# 20 - Tries and String Matching

<!-- study-navigation -->
[← Previous: Unit 19](19-dynamic-programming-patterns.md) · [Index](README.md) · [Next: Unit 21 →](21-range-query-data-structures.md)
<!-- /study-navigation -->

[Practice index](README.md) | Theory: [Tries](../../02_data-structures/09_tries/20-tries.md) | [String Matching](../../01_algorithms/11_strings/20-string-matching.md)

**Status:** Suggested practice; no solution or completion is implied. These prompts and hints were written for this repository, not copied from a recruiting question bank.

## Your deliverable

Write a specification, your solution, a correctness argument, time/space analysis, and tests. Record independent attempts in [PROGRESS.md](../../PROGRESS.md).

## Exercises

1. Extend KMP to return overlapping matches; test `aaa` inside `aaaaa`.
2. Implement a trie with exact lookup, prefix lookup, and deletion.
3. Find the shortest repeating period of a string from its prefix function.
4. Explain the tradeoff between KMP's deterministic guarantee and hash-based substring comparison.

<details><summary>Hints and checkpoints</summary>

1. The valid indices are zero, one, and two.
2. Deleting `car` must not delete `cart`; prefix existence does not imply word existence.
3. Candidate period is `n-pi[n-1]`; it tiles the nonempty string only if it divides n.
4. Hash equality needs collision handling; KMP compares actual symbols and reuses border structure.

### Java starting point

For exercise 2, terminal status is independent of the existence of children. This node stores UTF-16 code units. Use a count rather than a boolean when inserting a word multiple times is meaningful.

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

**Complete the reasoning:** Implement lookup without creating missing children. During deletion, prune a node only if it has no children and its terminal count is zero.

</details>

---

<!-- study-navigation -->
[← Previous: Unit 19](19-dynamic-programming-patterns.md) · [Index](README.md) · [Next: Unit 21 →](21-range-query-data-structures.md)
<!-- /study-navigation -->
