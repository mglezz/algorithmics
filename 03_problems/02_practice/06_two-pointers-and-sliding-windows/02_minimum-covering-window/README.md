# 06.02 - Minimum Covering Window

<!-- study-navigation -->
[← Previous: Exercise 06.01](../01_flipping-zeros/README.md) · [Index](../README.md) · [Next: Exercise 06.03 →](../03_exactly-k-distinct-values/README.md)
<!-- /study-navigation -->

[Practice index](../../README.md) | Theory: [Two Pointers and Sliding Windows](../../../../01_algorithms/03_two-pointers/06-two-pointers-and-sliding-windows.md)

**Status:** Not started. This is a repository-written practice prompt, not a recruiting question-bank item.

## Exercise

Implement `String minWindow(String text, String target)` using Java char units. Return the shortest substring containing all target characters with their multiplicities; choose the earliest on ties. Return an empty string when impossible or target is empty.

## Examples and checks

`"ADOBECODEBANC","ABC"` returns `"BANC"`; `"aa","aa"` returns `"aa"`; `"a","aa"` returns empty.

## Your workspace

Write your Java 17 implementation and an executable test runner in `src/`. Use `AlgorithmXX_YY.java` and `MainXX_YY.java` with this exercise's numbers, or keep the existing class names. For data-structure exercises, use the requested class and a separate runner. Compare actual and expected results, including the cases above; throw `AssertionError` on a mismatch (or run Java assertions with `-ea`).

The deliverable is working Java code and checks. You may add a short explanation of the algorithm in `src/README.md`, like exercise 02.01; a formal proof or a separate theoretical answer is not required. Unless stated otherwise, inputs are non-null, indices and graph endpoints are valid, and auxiliary result types such as `Node` or `Selection` are yours to define.

<details><summary>Implementation hint</summary>

Track missing characters and shrink only while the window covers the target.

### Java helper

Optional helper members for your class; add the necessary imports from java.util. Complete the public API and tests described above.

<!-- java-hint -->
```java
static int adjustDeficit(Map<Character, Integer> deficit, char symbol, int delta) {
    int updated = deficit.getOrDefault(symbol, 0) + delta;
    deficit.put(symbol, updated);
    return updated;
}
```
<!-- /java-hint -->

</details>

## Your solution

Keep your Java implementation and executable checks in `src/`. Optionally add a short algorithm explanation in `src/README.md`. Record the attempt in [PROGRESS.md](../../../../PROGRESS.md).

---

<!-- study-navigation -->
[← Previous: Exercise 06.01](../01_flipping-zeros/README.md) · [Index](../README.md) · [Next: Exercise 06.03 →](../03_exactly-k-distinct-values/README.md)
<!-- /study-navigation -->
