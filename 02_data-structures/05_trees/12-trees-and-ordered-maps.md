# 12 - Trees, Ordered Maps, and Augmentation

<!-- study-navigation -->
[← Previous: Unit 11](../../01_algorithms/07_backtracking/11-recursion-and-backtracking.md) · [Index](../../README.md#study-index) · [Next: Unit 13 →](../06_heaps/13-heaps-and-priority-queues.md)
<!-- /study-navigation -->

[Curriculum](../../CURRICULUM.md) | [Quick reference](../../04_notes/data-structures.md)

> **Core idea:** Tree operations depend on subtree invariants and height, not just the presence of child pointers.

## On this page

- [Tree terminology and contracts](#tree-terminology-and-contracts)
- [Worked visual](#worked-visual)
- [Traversal order encodes dependencies](#traversal-order-encodes-dependencies)
- [Binary search trees](#binary-search-trees)
- [Why balance matters](#why-balance-matters)
- [Augment a tree with summaries](#augment-a-tree-with-summaries)
- [Worked recurrence: diameter](#worked-recurrence-diameter)
- [Explain it in English](#explain-it-in-english)
- [Practice](#practice)
- [Attribution and references](#attribution-and-references)

## Tree terminology and contracts

A tree is a connected undirected graph with no cycle. Between any two vertices there is exactly one simple path; an `n`-vertex tree has `n-1` edges. Rooting it assigns parent/child relationships. A binary tree has at most two children per node; it is not necessarily ordered, balanced, complete, or full.

State whether height counts edges or nodes. Here an empty tree has height zero and a leaf has height one. The maximum height is `n`; a balanced tree has logarithmic height. Any algorithm advertised as `O(h)` can therefore be linear on an unbalanced tree.

## Worked visual

```text
Right rotation around y:

        y                  x
       / \                / \
      x   C      ->       A   y
     / \                    / \
    A   B                  B   C

Key order remains: A < x < B < y < C.
```

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

## Explain it in English

> “The result for this node depends only on summaries already computed for its children.”

**Vocabulary:** ancestor, descendant, height, depth, rotation, inorder, augmentation.

## Practice

Attempt the [unit 12 exercise set](../../03_problems/02_practice/12_trees-and-ordered-maps/README.md). Exercises and hints live in `03_problems/`; this chapter contains the theory.

## Attribution and references

**Provenance:** This chapter is a synthesis of the sources mapped below. Standard definitions, algorithms and proof techniques belong to those established references; the explanatory wording, traces, diagrams and Java examples were written for this repository. No source passage is quoted verbatim.

| Section / claim | Source used | How it is used |
|---|---|---|
| BST representations and traversals | [Pat Morin, Open Data Structures, chapter 6](https://opendatastructures.org/ods-java/6_Binary_Trees.html) | Definitions and operation costs. |
| Balancing | [Demaine, Ku and Solomon, MIT 6.006 (Spring 2020)](https://ocw.mit.edu/courses/6-006-introduction-to-algorithms-spring-2020/pages/lecture-notes/) | Lectures 6-7; rotations and AVL invariants. |
| Red-black trees and Java ordered maps | [Oracle Java 21: TreeMap](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/TreeMap.html) | Library contract; Morin chapter 9 provides structural detail. |

See [SOURCES.md](../../SOURCES.md) for editions, review scope, and the distinction between consulted material and further reading.

---

<!-- study-navigation -->
[← Previous: Unit 11](../../01_algorithms/07_backtracking/11-recursion-and-backtracking.md) · [Index](../../README.md#study-index) · [Next: Unit 13 →](../06_heaps/13-heaps-and-priority-queues.md)
<!-- /study-navigation -->
