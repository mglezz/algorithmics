# 25.09 - Versioned Service Costs

<!-- study-navigation -->
[← Previous: Exercise 25.08](../08_dynamic-range-sums/README.md) · [Index](../README.md) · [Next: Unit index →](../README.md)
<!-- /study-navigation -->

[Practice index](../../README.md) | Theory: [Solving, Testing, and Communicating](../../../../01_algorithms/14_problem-solving/25-solving-testing-and-communication.md)

**Status:** Not started. This is a repository-written practice prompt, not a recruiting question-bank item.

## Exercise

Implement `ServiceCosts(long[] initial)` where array positions are service IDs. Provide `int update(int baseVersion,int service,long newCost)` and `long total(int version,int left,int right)` for half-open service ranges. Version 0 is the initial array; each update creates a new version that can branch from any old version, sharing untouched tree nodes.

## Examples and checks

Initial `[4,6,8]` totals 18. Update version 0 service 1 to 10: new total 22, old total 18. Branch from version 0 service 0 to 1: branch total 15, other versions unchanged.

## Your workspace

Write your Java 17 implementation and an executable test runner in `src/`. Use `AlgorithmXX_YY.java` and `MainXX_YY.java` with this exercise's numbers, or keep the existing class names. For data-structure exercises, use the requested class and a separate runner. Compare actual and expected results, including the cases above; throw `AssertionError` on a mismatch (or run Java assertions with `-ea`).

The deliverable is working Java code and checks. You may add a short explanation of the algorithm in `src/README.md`, like exercise 02.01; a formal proof or a separate theoretical answer is not required. Unless stated otherwise, inputs are non-null, indices and graph endpoints are valid, and auxiliary result types such as `Node` or `Selection` are yours to define.

<details><summary>Implementation hint</summary>

Keep immutable nodes and a root per version; only allocate nodes along the modified path.

### Java helper

Optional helper members for your class; add the necessary imports from java.util. Complete the public API and tests described above.

<!-- java-hint -->
```java
static final class SumNode {
    final long sum;
    final SumNode left;
    final SumNode right;

    SumNode(long sum, SumNode left, SumNode right) {
        this.sum = sum;
        this.left = left;
        this.right = right;
    }
}
```
<!-- /java-hint -->

</details>

## Your solution

Keep your Java implementation and executable checks in `src/`. Optionally add a short algorithm explanation in `src/README.md`. Record the attempt in [PROGRESS.md](../../../../PROGRESS.md).

---

<!-- study-navigation -->
[← Previous: Exercise 25.08](../08_dynamic-range-sums/README.md) · [Index](../README.md) · [Next: Unit index →](../README.md)
<!-- /study-navigation -->
