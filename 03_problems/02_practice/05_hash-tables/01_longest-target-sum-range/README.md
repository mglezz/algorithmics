# 05.01 - Longest Target-Sum Range

<!-- study-navigation -->
[← Previous: Exercise 04.04](../../04_arrays-strings-and-prefix-sums/04_product-except-self/README.md) · [Index](../README.md) · [Next: Exercise 05.02 →](../02_grouping-anagrams/README.md)
<!-- /study-navigation -->

[Practice index](../../README.md) | Theory: [Hash Tables, Sets, and Canonical Keys](../../../../02_data-structures/02_hash-tables/05-hash-tables.md)

**Status:** Not started. This is a repository-written practice prompt, not a recruiting question-bank item.

## Exercise

Implement `int[] longestRange(int[] values, long target)` returning inclusive `[start,end]` for the longest nonempty contiguous range with that sum. Negatives are allowed. Break length ties by smallest start; return an empty array if absent. Aim for expected O(n) time.

## Examples and checks

`[1,-1,5,-2,3], target=3` returns `[0,3]`; `[1,2], target=9` returns `[]`; check zero target and repeated prefix sums.

## Your workspace

Write your Java 17 implementation and an executable test runner in `src/`. Use `AlgorithmXX_YY.java` and `MainXX_YY.java` with this exercise's numbers, or keep the existing class names. For data-structure exercises, use the requested class and a separate runner. Compare actual and expected results, including the cases above; throw `AssertionError` on a mismatch (or run Java assertions with `-ea`).

The deliverable is working Java code and checks. You may add a short explanation of the algorithm in `src/README.md`, like exercise 02.01; a formal proof or a separate theoretical answer is not required. Unless stated otherwise, inputs are non-null, indices and graph endpoints are valid, and auxiliary result types such as `Node` or `Selection` are yours to define.

<details><summary>Implementation hint</summary>

Store the earliest index of each prefix sum, seeded with sum zero at index -1.

### Java helper

Optional helper members for your class; add the necessary imports from java.util. Complete the public API and tests described above.

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

</details>

## Your solution

Keep your Java implementation and executable checks in `src/`. Optionally add a short algorithm explanation in `src/README.md`. Record the attempt in [PROGRESS.md](../../../../PROGRESS.md).

---

<!-- study-navigation -->
[← Previous: Exercise 04.04](../../04_arrays-strings-and-prefix-sums/04_product-except-self/README.md) · [Index](../README.md) · [Next: Exercise 05.02 →](../02_grouping-anagrams/README.md)
<!-- /study-navigation -->
