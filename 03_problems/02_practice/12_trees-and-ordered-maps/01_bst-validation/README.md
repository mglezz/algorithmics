# 12.01 - BST Validation

<!-- study-navigation -->
[← Previous: Exercise 11.04](../../11_recursion-and-backtracking/04_meet-in-the-middle-subset-sum/README.md) · [Index](../README.md) · [Next: Exercise 12.02 →](../02_kth-smallest-key/README.md)
<!-- /study-navigation -->

[Practice index](../../README.md) | Theory: [Trees, Ordered Maps, and Augmentation](../../../../02_data-structures/05_trees/12-trees-and-ordered-maps.md)

**Status:** Not started. This is a repository-written practice prompt, not a recruiting question-bank item.

## Exercise

Define a binary-tree Node with an int key and left/right references. Implement `boolean isValidBst(Node root)` with strict ordering and no duplicate keys. Empty trees are valid; support int extremes.

## Examples and checks

Root 2 with children 1 and 3 is valid. Root 10 with right child 15 whose left child is 6 is invalid. Check duplicates and int extremes.

## Your workspace

Write your Java 17 implementation and an executable test runner in `src/`. Use `AlgorithmXX_YY.java` and `MainXX_YY.java` with this exercise's numbers, or keep the existing class names. For data-structure exercises, use the requested class and a separate runner. Compare actual and expected results, including the cases above; throw `AssertionError` on a mismatch (or run Java assertions with `-ea`).

The deliverable is working Java code and checks. You may add a short explanation of the algorithm in `src/README.md`, like exercise 02.01; a formal proof or a separate theoretical answer is not required. Unless stated otherwise, inputs are non-null, indices and graph endpoints are valid, and auxiliary result types such as `Node` or `Selection` are yours to define.

<details><summary>Implementation hint</summary>

Carry exclusive long bounds through the entire subtree.

### Java helper

Optional helper members for your class; add the necessary imports from java.util. Complete the public API and tests described above.

<!-- java-hint -->
```java
record Bounds(long lower, long upper) {}

static boolean fits(int key, Bounds bounds) {
    return bounds.lower() < key && key < bounds.upper();
}

static Bounds leftBounds(int key, Bounds parent) {
    return new Bounds(parent.lower(), key);
}

static Bounds rightBounds(int key, Bounds parent) {
    return new Bounds(key, parent.upper());
}
```
<!-- /java-hint -->

</details>

## Your solution

Keep your Java implementation and executable checks in `src/`. Optionally add a short algorithm explanation in `src/README.md`. Record the attempt in [PROGRESS.md](../../../../PROGRESS.md).

---

<!-- study-navigation -->
[← Previous: Exercise 11.04](../../11_recursion-and-backtracking/04_meet-in-the-middle-subset-sum/README.md) · [Index](../README.md) · [Next: Exercise 12.02 →](../02_kth-smallest-key/README.md)
<!-- /study-navigation -->
