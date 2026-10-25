# 03 - Java for Algorithmic Interviews

[Curriculum](README.md) | Prerequisites: 01-02

## Choose representations deliberately

Use Java as a reasoning tool, not just a syntax exercise. Be able to create and traverse arrays, lists, maps, sets, queues, and heaps without searching for every method. Examples in this course use Java 17-compatible syntax; API references are pinned to Java 21. Confirm the runtime available in any assessment.

| Need | Typical choice | Relevant cost / caveat |
|---|---|---|
| Dense integer-indexed data | `int[]`, `long[]`, `boolean[]` | Constant indexed access; fixed length |
| Growable indexed sequence | `ArrayList<E>` | Constant get/set; amortized constant append; linear middle insertion |
| Membership / lookup | `HashSet<E>`, `HashMap<K,V>` | Expected constant operations with suitable hashing; no sorted order |
| Ordered keys / predecessor | `TreeSet<E>`, `TreeMap<K,V>` | Logarithmic basic operations; comparison defines key equivalence |
| Stack or FIFO queue | `ArrayDeque<E>` | Amortized constant operations at either end; no null entries |
| Repeated minimum / maximum | `PriorityQueue<E>` | Logarithmic offer/poll; constant peek; arbitrary removal is linear |
| Build text incrementally | `StringBuilder` | Avoid repeatedly copying a growing immutable prefix |

These costs assume constant-time element comparisons and hashes. A map with strings as keys can spend time reading the strings. An `ArrayList<Integer>` boxes values; a primitive array avoids those wrappers and often uses less memory.

## Numerical correctness

`int` is signed 32-bit; `long` is signed 64-bit. A correct mathematical formula can still overflow in Java. For int inputs `a,b`, use `(long) a * b`; assigning `a*b` to a long computes the int multiplication first. Use `long` for prefix sums, path lengths, and counts when constraints require it, and still establish that long is sufficient.

Avoid subtraction comparators: `(a,b) -> a-b` can overflow and reverse the ordering. Use `Integer.compare(a,b)`, `Long.compare`, or comparator factories. Comparators must be transitive. Break ties explicitly when deterministic results matter.

`Integer.MAX_VALUE + 1` wraps; arithmetic overflow is not generally an exception. `Math.addExact` and `Math.multiplyExact` can detect overflow. `Math.abs(Integer.MIN_VALUE)` remains negative because its positive counterpart does not fit. `%` is a remainder operator and can return a negative result; use `Math.floorMod` for a nonnegative residue with positive modulus. Integer division truncates toward zero.

## Identity, equality, and mutation

`==` on object references tests identity. Use value equality for strings and keys. Two equal keys must have equal hash codes, though unequal keys may collide. Never mutate fields involved in equality or hashing while an object is stored as a hash key. Arrays do not automatically provide content-based equality as map keys; wrap or encode them deliberately.

Java passes arguments by value, including reference values. A method can mutate an object through a copied reference; reassigning that parameter does not reassign the caller's variable. Copying a list of nodes is shallow: the nodes are still shared. Copying a two-dimensional array's outer array does not copy the inner rows.

For `List<Integer>`, `remove(1)` removes the element at index one; `remove(Integer.valueOf(1))` removes a matching value. This overload distinction can silently change an algorithm.

## Ordering and iteration traps

Do not assume a hash map's iteration order. Do not assume a priority queue iterator returns sorted values: repeated polling does, but destroys that queue. Updating a priority field of an element already in a heap does not repair heap order; remove and reinsert, or use immutable entries and discard stale ones.

Choose one deque convention and keep it consistent: `addLast` plus `removeFirst` for FIFO, or `push` plus `pop` for LIFO. Check emptiness before removing when the contract allows an empty structure. Avoid structural mutation through a collection while iterating unless the iterator/API explicitly supports it.

## Strings and the stack

Java string indices address UTF-16 code units. A `char` need not be a complete Unicode code point, and a code point need not be an entire user-perceived character. If a problem guarantees lowercase English letters, a 26-entry frequency array is appropriate. Otherwise agree on the alphabet and equality rules. `codePoints()` helps with code points, not grapheme segmentation.

Repeatedly constructing `result = result + next` can cause quadratic copying across a loop. Use a builder when constructing growing text. Treat substring extraction and string equality as potentially proportional to the relevant length; do not hide them inside “constant-time” DP transitions.

Deep recursion can exhaust the thread stack. Java does not promise tail-call elimination. A chain with hundreds of thousands of vertices should usually use an explicit traversal stack; increasing stack size is not an algorithmic fix.

## Practice

1. Explain why `(long) (a*b)` can be wrong when `a` and `b` are ints.
2. Build a max-heap of integers and identify how you would obtain a sorted snapshot without changing the original.
3. Design an immutable coordinate key with correct equality.
4. Review the existing dependency solution: distinguish the clean algorithm's cost from verbose tracing that prints growing arrays.

<details><summary>Hints and checkpoints</summary>

1. Promotion occurs after the overflowing multiplication; move the cast to an operand.
2. Use `Comparator.reverseOrder()`. Copy the heap and poll the copy, or copy to an array and sort.
3. A record with two int components has suitable value semantics; an `int[]` does not.
4. Repeatedly printing prefixes of increasing size can contribute quadratic output even when the underlying graph processing is linear.

</details>

**Explain aloud:** “The data structure supports the operation I need, but I must include the cost of its keys and comparisons.” Vocabulary: reference, aliasing, boxing, comparator, overflow, immutable.

## Sources

Oracle Java 21: [ArrayList](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/ArrayList.html), [HashMap](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/HashMap.html), [ArrayDeque](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/ArrayDeque.html), [TreeMap](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/TreeMap.html), [PriorityQueue](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/PriorityQueue.html), [String](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/String.html), and [JLS expressions](https://docs.oracle.com/javase/specs/jls/se21/html/jls-15.html). Read contracts rather than depending on undocumented implementation details.
