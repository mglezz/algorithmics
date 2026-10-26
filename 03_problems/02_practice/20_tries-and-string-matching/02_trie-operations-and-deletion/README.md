# 20.02 - Trie Operations and Deletion

<!-- study-navigation -->
[← Previous: Exercise 20.01](../01_overlapping-kmp-matches/README.md) · [Index](../README.md) · [Next: Exercise 20.03 →](../03_shortest-repeating-period/README.md)
<!-- /study-navigation -->

[Practice index](../../README.md) | Theory: [Tries](../../../../02_data-structures/09_tries/20-tries.md) | [String Matching](../../../../01_algorithms/11_strings/20-string-matching.md)

**Status:** Not started. This is a repository-written practice prompt, not a recruiting question-bank item.

## Exercise

Implement a trie with exact lookup, prefix lookup, and deletion.

## Your workspace

Keep your implementation (for example, `Solution.java`) and your tests in this folder. For a proof, analysis, or counterexample task, write your answer in the solution section below; add code only when useful.

State the input/output contract, explain correctness, analyze time and space, and check boundary cases. Java helper fragments belong inside your own class with `import java.util.*;`.

<details><summary>Hints and checkpoints</summary>

Deleting `car` must not delete `cart`; prefix existence does not imply word existence.

### Java starting point

For this exercise, terminal status is independent of the existence of children. This node stores UTF-16 code units. Use a count rather than a boolean when inserting a word multiple times is meaningful.

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

## Your solution

Add your approach, correctness argument, complexity analysis, and test results after attempting the exercise. Record the attempt in [PROGRESS.md](../../../../PROGRESS.md).

---

<!-- study-navigation -->
[← Previous: Exercise 20.01](../01_overlapping-kmp-matches/README.md) · [Index](../README.md) · [Next: Exercise 20.03 →](../03_shortest-repeating-period/README.md)
<!-- /study-navigation -->
