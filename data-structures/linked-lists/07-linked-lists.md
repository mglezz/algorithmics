# 07 - Linked Lists and Reference Manipulation

[Curriculum](../../CURRICULUM.md) | [Quick reference](../../notes/data-structures.md)

> **Core idea:** Preserve access to the unprocessed nodes before changing references.

## On this page

- [Representation determines the operation cost](#representation-determines-the-operation-cost)
- [Worked visual](#worked-visual)
- [Reverse without losing the remaining suffix](#reverse-without-losing-the-remaining-suffix)
- [Fast and slow pointers](#fast-and-slow-pointers)
- [Common compositions](#common-compositions)
- [LRU cache design](#lru-cache-design)
- [Explain it in English](#explain-it-in-english)
- [Practice](#practice)
- [Attribution and references](#attribution-and-references)

## Representation determines the operation cost

A singly linked node stores a value and a reference to its successor. A doubly linked node also stores its predecessor. Nodes need not be adjacent in memory. A head reference identifies the first node; an optional tail makes append constant time. Sentinels can represent boundaries uniformly.

| Operation | Singly linked list |
|---|---|
| Read position `i` | `O(i+1)` from the head |
| Insert after a known node | `O(1)` |
| Remove after a known predecessor | `O(1)` |
| Find a value / predecessor | `O(n)` worst case |
| Remove the tail | `O(n)` without a predecessor reference |

“Linked-list deletion is constant time” is incomplete. You need the references that make rewiring possible. A doubly linked node supports constant-time unlinking when known, but finding it still costs time. The trick of copying a successor into a node cannot remove a tail and may violate identity semantics.

## Worked visual

```text
Before rewiring:
previous -> 2 -> 1 -> null
current  -> 3 -> 4 -> null
                 ^
                 next (saved before changing current.next)

After one step:
previous -> 3 -> 2 -> 1 -> null
current  -> 4 -> null
```

## Reverse without losing the remaining suffix

```java
static final class ListNode {
    int value;
    ListNode next;
    ListNode(int value) { this.value = value; }
}

static ListNode reverse(ListNode head) {
    ListNode previous = null;
    ListNode current = head;
    while (current != null) {
        ListNode next = current.next;
        current.next = previous;
        previous = current;
        current = next;
    }
    return previous;
}
```

Contract: the input is an acyclic singly linked list; the method reuses and rewires its nodes and returns the new head. At each iteration, `previous` heads the reversed processed prefix and `current` heads the original unprocessed suffix. Saving `next` before overwriting the link preserves access to unread nodes. Every node moves once, giving `O(n)` time and `O(1)` auxiliary space. Empty and singleton lists work naturally.

Drawing the three references before each assignment is more reliable than memorizing assignment order. Tests should also check node identity, not just values: a function that allocates replacement nodes has a different contract.

## Fast and slow pointers

For cycle detection, advance slow by one edge and fast by two, checking that fast and its successor exist before advancing. In an acyclic list, fast reaches null. In a cycle of length `lambda`, their relative offset advances by one modulo `lambda`, so they eventually meet.

Let the noncyclic prefix have length `mu`. At a meeting after `t` slow steps, fast has taken `2t`; their difference implies `t` is a multiple of `lambda`. Reset one pointer to the head and move both one step at a time. After `mu` steps, one arrives at the cycle entry, and the other has advanced to the same cycle position because `t` is divisible by `lambda`. This proves the usual entry-finding method after a genuine meeting.

Time is `O(mu+lambda)` and auxiliary space is constant. A visited-node identity set is an easier alternative using linear space. Equal values do not imply equal nodes.

## Common compositions

- **Middle:** slow/fast pointers; choose which middle is returned for even length by specifying initialization and loop conditions.
- **Remove nth from end:** keep a gap of `n` between pointers; a dummy head handles deleting the original head. Validate `n` and list length.
- **Merge sorted lists:** connect the smaller current node; a dummy head avoids a special first append. Stable merging chooses from the left list on equal keys.
- **Palindrome:** find the middle, reverse one half, compare, then restore it if mutation must not persist.
- **Intersection of acyclic lists:** align lengths or switch each pointer to the other head after null. Both traverse equal total distance; identity is the intersection criterion.

Each composition inherits mutation and aliasing concerns. If two inputs share nodes, a merge designed for disjoint lists may create a cycle. State disjointness when required.

## LRU cache design

Combine a map from key to node with a doubly linked recency list. Lookup finds the node; unlink and move it to the most-recent end. On insertion beyond capacity, remove the least-recent node from both the list and map. Maintain a bijection between cached keys and list nodes. Expected constant operations rely on the hash map; capacity zero needs an explicit behavior. This combines two representations because neither alone supports both lookup and recency updates efficiently.

## Explain it in English

> “I save the successor before changing the link so the unprocessed suffix stays reachable.”

**Vocabulary:** predecessor, successor, sentinel, alias, identity, unlink.

## Practice

Attempt the [unit 07 exercise set](../../problems/practice/07-linked-lists.md). Exercises and hints live in `problems/`; this chapter contains the theory.

## Attribution and references

**Provenance:** This chapter is a synthesis of the sources mapped below. Standard definitions, algorithms and proof techniques belong to those established references; the explanatory wording, traces, diagrams and Java examples were written for this repository. No source passage is quoted verbatim.

| Section / claim | Source used | How it is used |
|---|---|---|
| Node representation and operation costs | [Pat Morin, Open Data Structures, chapter 3](https://opendatastructures.org/ods-java/3_Linked_Lists.html) | Singly/doubly linked lists; definitions and complexity. |
| Cycle detection | [Antti Laaksonen, Competitive Programmer's Handbook (2018 draft)](https://cses.fi/book/book.pdf) | Successor-graph section; Floyd-style reasoning, restated here. |

See [SOURCES.md](../../SOURCES.md) for editions, review scope, and the distinction between consulted material and further reading.
