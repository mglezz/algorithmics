# 07 - Linked Lists and Reference Manipulation

<!-- study-navigation -->
[← Previous: Unit 06](06-two-pointers-and-sliding-windows.md) · [Index](README.md) · [Next: Unit 08 →](08-stacks-queues-and-monotonic-structures.md)
<!-- /study-navigation -->

[Practice index](README.md) | Theory: [Linked Lists and Reference Manipulation](../../02_data-structures/03_linked-lists/07-linked-lists.md)

**Status:** Suggested practice; no solution or completion is implied. These prompts and hints were written for this repository, not copied from a recruiting question bank.

## Your deliverable

Write a specification, your solution, a correctness argument, time/space analysis, and tests. Record independent attempts in [PROGRESS.md](../../PROGRESS.md).

## Exercises

1. Reverse only a specified contiguous list segment.
2. Find the cycle entry and cycle length without modifying nodes.
3. Merge two sorted disjoint lists, preserving node identity.
4. Specify and implement an LRU cache; test repeated access, overwrite, eviction, and capacity zero.

<details><summary>Hints and checkpoints</summary>

1. Preserve the predecessor and successor of the segment; reconnect both ends.
2. After a meeting, walk once around the cycle to count its length; reset a pointer for the entry proof.
3. Attach the untouched remainder when either list ends.
4. Every unlink must update both adjacent links; every eviction must remove the map entry.

### Java starting point

For exercise 1, make one reference change explicit. The helper removes the node after a predecessor and returns it; decide where to reconnect that node in your reversal. Preconditions: previous and previous.next are non-null.

<!-- java-hint -->
```java
static final class Node {
    int value;
    Node next;
    Node(int value) { this.value = value; }
}

static Node detachAfter(Node previous) {
    Node removed = previous.next;
    previous.next = removed.next;
    removed.next = null;
    return removed;
}
```
<!-- /java-hint -->

**Complete the reasoning:** Use a sentinel when the reversed segment begins at the head. Which references must survive before you detach a node?

</details>

---

<!-- study-navigation -->
[← Previous: Unit 06](06-two-pointers-and-sliding-windows.md) · [Index](README.md) · [Next: Unit 08 →](08-stacks-queues-and-monotonic-structures.md)
<!-- /study-navigation -->
