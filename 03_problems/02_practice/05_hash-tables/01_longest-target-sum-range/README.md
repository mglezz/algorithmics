# 05.01 - Longest Target-Sum Range

<!-- study-navigation -->
[← Previous: Exercise 04.04](../../04_arrays-strings-and-prefix-sums/04_product-except-self/README.md) · [Index](../README.md) · [Next: Exercise 05.02 →](../02_grouping-anagrams/README.md)
<!-- /study-navigation -->

[Practice index](../../README.md) | Theory: [Hash Tables, Sets, and Canonical Keys](../../../../02_data-structures/02_hash-tables/05-hash-tables.md)

**Status:** Not started. This is a repository-written practice prompt, not a recruiting question-bank item.

## Exercise

Adapt the prefix method to find the longest target-sum range rather than count all ranges.

## Your workspace

Keep your implementation (for example, `Solution.java`) and your tests in this folder. For a proof, analysis, or counterexample task, write your answer in the solution section below; add code only when useful.

State the input/output contract, explain correctness, analyze time and space, and check boundary cases. Java helper fragments belong inside your own class with `import java.util.*;`.

<details><summary>Hints and checkpoints</summary>

Store the earliest index of each prefix, not its frequency; do not overwrite that earliest index.

### Java starting point

For this exercise, preserve the first index of a prefix sum. Initialize the map with 0L mapped to -1, query before recording the current prefix, and assume all prefix arithmetic fits in long.

<!-- java-hint -->
```java
static int candidateLength(Map<Long, Integer> earliest,
                           long prefix, long target, int index) {
    Integer start = earliest.get(prefix - target);
    return start == null ? 0 : index - start;
}

static void rememberFirst(Map<Long, Integer> earliest, long prefix, int index) {
    earliest.putIfAbsent(prefix, index);
}
```
<!-- /java-hint -->

**Complete the reasoning:** Explain why overwriting the earliest index can shorten the best range. Supply the scan and maximum update.

</details>

## Your solution

Add your approach, correctness argument, complexity analysis, and test results after attempting the exercise. Record the attempt in [PROGRESS.md](../../../../PROGRESS.md).

---

<!-- study-navigation -->
[← Previous: Exercise 04.04](../../04_arrays-strings-and-prefix-sums/04_product-except-self/README.md) · [Index](../README.md) · [Next: Exercise 05.02 →](../02_grouping-anagrams/README.md)
<!-- /study-navigation -->
