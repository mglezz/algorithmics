# 12 - Trees, Ordered Maps, and Augmentation

[Curriculum](README.md) | Prerequisites: 07, 09, 11

## Tree terminology and contracts

A tree is a connected undirected graph with no cycle. Between any two vertices there is exactly one simple path; an `n`-vertex tree has `n-1` edges. Rooting it assigns parent/child relationships. A binary tree has at most two children per node; it is not necessarily ordered, balanced, complete, or full.

State whether height counts edges or nodes. Here an empty tree has height zero and a leaf has height one. The maximum height is `n`; a balanced tree has logarithmic height. Any algorithm advertised as `O(h)` can therefore be linear on an unbalanced tree.

## Traversal order encodes dependencies

| Order | Sequence | Useful when |
|---|---|---|
| Preorder | node, left, right | Pass context from ancestors; serialize with null markers |
| Inorder | left, node, right | Read a BST in sorted order |
| Postorder | left, right, node | Combine child results into a parent result |
| Level order | increasing depth | Process layers with a queue |

Every traversal visits `n` nodes in `O(n)` time if work per node is constant. Recursive depth-first traversal uses `O(h)` stack; level order uses `O(w)` queue space for maximum width `w`. Explicit iterative DFS must retain enough state to distinguish first arrival from returning after a child when computing postorder results.

## Binary search trees

Under a no-duplicate policy, every left-subtree key is less than its node's key and every right-subtree key is greater. This is a **global subtree property**. Comparing only a node with its immediate children misses violations farther below.

Search follows one branch after each comparison, costing `O(h)`. Insertion finds a null child. Deletion has three cases: remove a leaf; splice in a single child; or replace a two-child node's key/value with its successor and remove that successor from the right subtree. Define whether externally held node identities matter before using value replacement.

Validation can pass strict lower and upper bounds down the tree, using long bounds for int keys, or check a strictly increasing inorder sequence. If duplicates are allowed, define exactly which side or count field holds them and update all proofs accordingly.

## Why balance matters

Sorted insertions create a chain in a plain BST. Balanced trees use rotations to change local shape while preserving inorder key order. A right rotation around `y` with left child `x` makes `x` the local root and transfers `x`'s right subtree to `y`'s left; those middle keys lie between `x` and `y`, so order is preserved.

An AVL tree maintains child-height difference at most one at every node. A single rotation repairs an outside-heavy imbalance; an inside-heavy imbalance requires two rotations. The minimum node count at height `h` satisfies a Fibonacci-like recurrence, yielding `h=O(log n)`. Height and augmentation metadata must be recomputed after rotations, from lower nodes upward.

A red-black tree uses coloring constraints, including no red-red parent-child edge and equal black counts on root-to-null paths. These imply logarithmic height while permitting a different repair strategy. Java `TreeMap` uses this family and guarantees logarithmic basic lookup/update operations; you need not reimplement its internals to use its contract correctly.

## Augment a tree with summaries

Store subtree size `size(v)=1+size(left)+size(right)`. Then the left size tells you the root's rank within its subtree; descend left, return the root, or adjust the rank and descend right. Balanced height gives logarithmic rank/select operations. The summary must be maintained on insertion, deletion, and rotations.

Other summaries include subtree sums and interval maximum endpoints. An augmentation is useful when it can be recomputed from local information and directs a query to a small number of branches. Adding a field without a maintenance rule is not a complete design.

## Worked recurrence: diameter

For an unweighted rooted binary tree, recursively return each child's height in nodes. A longest path through the current node has `leftHeight+rightHeight` edges. Update a global maximum and return `1+max(leftHeight,rightHeight)`. Every path either lies wholly in a child subtree or passes through the current node, so the recurrence covers all possibilities. The result takes `O(n)` time and `O(h)` stack. Recomputing height separately at every node can instead take `O(n^2)` on a chain.

For a general rooted tree, use the two greatest child heights. For negative weighted edges, the choice of whether an empty path is allowed changes the base cases and answer.

## Practice

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

**Explain aloud:** “The result for this node depends only on summaries already computed for its children.” Vocabulary: ancestor, descendant, height, depth, rotation, inorder, augmentation.

## Sources

- [Open Data Structures, Binary Trees](https://opendatastructures.org/ods-java/6_Binary_Trees.html) and [Red-Black Trees](https://opendatastructures.org/ods-java/9_Red_Black_Trees.html).
- [MIT 6.006 lecture notes](https://ocw.mit.edu/courses/6-006-introduction-to-algorithms-spring-2020/pages/lecture-notes/), lectures 6-7: tree operations, rotations, and AVL balance.
- [Oracle TreeMap](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/TreeMap.html): ordered-map guarantees.
