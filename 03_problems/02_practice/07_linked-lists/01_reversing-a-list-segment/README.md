# 07.01 - Reversing a List Segment

<!-- study-navigation -->
[← Previous: Exercise 06.04](../../06_two-pointers-and-sliding-windows/04_negative-value-counterexample/README.md) · [Index](../README.md) · [Next: Exercise 07.02 →](../02_cycle-entry-and-length/README.md)
<!-- /study-navigation -->

[Practice index](../../README.md) | Theory: [Linked Lists and Reference Manipulation](../../../../02_data-structures/03_linked-lists/07-linked-lists.md)

**Status:** Not started. This is a repository-written practice prompt, not a recruiting question-bank item.

## Exercise

Define a singly linked `Node` with an int value and next reference. Implement `Node reverseBetween(Node head, int left, int right)` for valid zero-based inclusive positions in a nonempty acyclic list. Reuse nodes and return the possibly new head.

## Examples and checks

`1->2->3->4->5`, left=1, right=3 becomes `1->4->3->2->5`; check the entire list and left=right.

## Your workspace

Write your Java 17 implementation and an executable test runner in `src/`. Use `AlgorithmXX_YY.java` and `MainXX_YY.java` with this exercise's numbers, or keep the existing class names. For data-structure exercises, use the requested class and a separate runner. Compare actual and expected results, including the cases above; throw `AssertionError` on a mismatch (or run Java assertions with `-ea`).

The deliverable is working Java code and checks. You may add a short explanation of the algorithm in `src/README.md`, like exercise 02.01; a formal proof or a separate theoretical answer is not required. Unless stated otherwise, inputs are non-null, indices and graph endpoints are valid, and auxiliary result types such as `Node` or `Selection` are yours to define.

<details><summary>Implementation hint</summary>

Retain the segment predecessor and successor; a temporary sentinel can simplify head changes.

### Java helper

Optional helper members for your class; add the necessary imports from java.util. Complete the public API and tests described above.

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

</details>

## Your solution

Keep your Java implementation and executable checks in `src/`. Optionally add a short algorithm explanation in `src/README.md`. Record the attempt in [PROGRESS.md](../../../../PROGRESS.md).

---

<!-- study-navigation -->
[← Previous: Exercise 06.04](../../06_two-pointers-and-sliding-windows/04_negative-value-counterexample/README.md) · [Index](../README.md) · [Next: Exercise 07.02 →](../02_cycle-entry-and-length/README.md)
<!-- /study-navigation -->
