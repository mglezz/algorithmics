# 07.01 - Reversing a List Segment

<!-- study-navigation -->
[← Previous: Exercise 06.04](../../06_two-pointers-and-sliding-windows/04_negative-value-counterexample/README.md) · [Index](../README.md) · [Next: Exercise 07.02 →](../02_cycle-entry-and-length/README.md)
<!-- /study-navigation -->

[Practice index](../../README.md) | Theory: [Linked Lists and Reference Manipulation](../../../../02_data-structures/03_linked-lists/07-linked-lists.md)

**Status:** Not started. This is a repository-written practice prompt, not a recruiting question-bank item.

## Exercise

Reverse only a specified contiguous list segment.

## Your workspace

Keep your implementation (for example, `Solution.java`) and your tests in this folder. For a proof, analysis, or counterexample task, write your answer in the solution section below; add code only when useful.

State the input/output contract, explain correctness, analyze time and space, and check boundary cases. Java helper fragments belong inside your own class with `import java.util.*;`.

<details><summary>Hints and checkpoints</summary>

Preserve the predecessor and successor of the segment; reconnect both ends.

### Java starting point

For this exercise, make one reference change explicit. The helper removes the node after a predecessor and returns it; decide where to reconnect that node in your reversal. Preconditions: previous and previous.next are non-null.

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

## Your solution

Add your approach, correctness argument, complexity analysis, and test results after attempting the exercise. Record the attempt in [PROGRESS.md](../../../../PROGRESS.md).

---

<!-- study-navigation -->
[← Previous: Exercise 06.04](../../06_two-pointers-and-sliding-windows/04_negative-value-counterexample/README.md) · [Index](../README.md) · [Next: Exercise 07.02 →](../02_cycle-entry-and-length/README.md)
<!-- /study-navigation -->
