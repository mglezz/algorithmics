# 12 - Trees, Ordered Maps, and Augmentation

<!-- study-navigation -->
[← Previous: Unit 11](11-recursion-and-backtracking.md) · [Index](README.md) · [Next: Unit 13 →](13-heaps-and-priority-queues.md)
<!-- /study-navigation -->

[Practice index](README.md) | Theory: [Trees, Ordered Maps, and Augmentation](../../02_data-structures/05_trees/12-trees-and-ordered-maps.md)

**Status:** Suggested practice; no solution or completion is implied. These prompts and hints were written for this repository, not copied from a recruiting question bank.

## Your deliverable

Write a specification, your solution, a correctness argument, time/space analysis, and tests. Record independent attempts in [PROGRESS.md](../../PROGRESS.md).

## Exercises

1. Validate a BST containing extreme int keys without `key-1` or `key+1` overflow.
2. Return the kth smallest key using an iterative inorder traversal.
3. Serialize and deserialize a binary tree with an unambiguous format.
4. Compute height, balance, and diameter in one postorder traversal.

<details><summary>Hints and checkpoints</summary>

1. Pass exclusive long bounds for the strict int-key policy.
2. An explicit stack uses `O(h)` space; stop when the kth node is visited. Validate `k`.
3. Include null markers or another structural encoding; preorder values alone are insufficient.
4. Return a tuple of summaries from children rather than rescanning them.

### Java starting point

For exercise 1, carry strict bounds as long values when node keys are ints. Start with Long.MIN_VALUE and Long.MAX_VALUE. This version rejects duplicate keys.

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

---

<!-- study-navigation -->
[← Previous: Unit 11](11-recursion-and-backtracking.md) · [Index](README.md) · [Next: Unit 13 →](13-heaps-and-priority-queues.md)
<!-- /study-navigation -->
