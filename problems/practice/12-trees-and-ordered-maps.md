# 12 - Trees, Ordered Maps, and Augmentation

[Practice index](README.md) | Theory: [Trees, Ordered Maps, and Augmentation](../../data-structures/trees/12-trees-and-ordered-maps.md)

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

</details>
