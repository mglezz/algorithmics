# 07 - Linked Lists and Reference Manipulation

[Curriculum](README.md) | Prerequisites: 01-03

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

## Practice

1. Reverse only a specified contiguous list segment.
2. Find the cycle entry and cycle length without modifying nodes.
3. Merge two sorted disjoint lists, preserving node identity.
4. Specify and implement an LRU cache; test repeated access, overwrite, eviction, and capacity zero.

<details><summary>Hints and checkpoints</summary>

1. Preserve the predecessor and successor of the segment; reconnect both ends.
2. After a meeting, walk once around the cycle to count its length; reset a pointer for the entry proof.
3. Attach the untouched remainder when either list ends.
4. Every unlink must update both adjacent links; every eviction must remove the map entry.

</details>

**Explain aloud:** “I save the successor before changing the link so the unprocessed suffix stays reachable.” Vocabulary: predecessor, successor, sentinel, alias, identity, unlink.

## Sources

- [Open Data Structures, Linked Lists](https://opendatastructures.org/ods-java/3_Linked_Lists.html): singly and doubly linked representations and their operation costs.
- [Open Data Structures, contents](https://opendatastructures.org/ods-java/Contents.html), chapters 3 and 5: list and dictionary foundations for the cache composition.
