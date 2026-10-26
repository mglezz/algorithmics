# 12.01 - BST Validation

<!-- study-navigation -->
[← Previous: Exercise 11.04](../../11_recursion-and-backtracking/04_meet-in-the-middle-subset-sum/README.md) · [Index](../README.md) · [Next: Exercise 12.02 →](../02_kth-smallest-key/README.md)
<!-- /study-navigation -->

[Practice index](../../README.md) | Theory: [Trees, Ordered Maps, and Augmentation](../../../../02_data-structures/05_trees/12-trees-and-ordered-maps.md)

**Status:** Not started. This is a repository-written practice prompt, not a recruiting question-bank item.

## Exercise

Validate a BST containing extreme int keys without `key-1` or `key+1` overflow.

## Your workspace

Keep your implementation (for example, `Solution.java`) and your tests in this folder. For a proof, analysis, or counterexample task, write your answer in the solution section below; add code only when useful.

State the input/output contract, explain correctness, analyze time and space, and check boundary cases. Java helper fragments belong inside your own class with `import java.util.*;`.

<details><summary>Hints and checkpoints</summary>

Pass exclusive long bounds for the strict int-key policy.

### Java starting point

For this exercise, carry strict bounds as long values when node keys are ints. Start with Long.MIN_VALUE and Long.MAX_VALUE. This version rejects duplicate keys.

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

**Complete the reasoning:** Supply the traversal and propagate both bounds. Checking only the immediate parent does not validate a BST.

</details>

## Your solution

Add your approach, correctness argument, complexity analysis, and test results after attempting the exercise. Record the attempt in [PROGRESS.md](../../../../PROGRESS.md).

---

<!-- study-navigation -->
[← Previous: Exercise 11.04](../../11_recursion-and-backtracking/04_meet-in-the-middle-subset-sum/README.md) · [Index](../README.md) · [Next: Exercise 12.02 →](../02_kth-smallest-key/README.md)
<!-- /study-navigation -->
