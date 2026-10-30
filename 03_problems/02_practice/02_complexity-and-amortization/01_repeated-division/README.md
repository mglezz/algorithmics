# 02.01 - Repeated Division

<!-- study-navigation -->
[← Previous: Exercise 01.04](../../01_mathematics-and-correctness/04_counting-subsequences/README.md) · [Index](../README.md) · [Next: Exercise 02.02 →](../02_pairwise-string-comparison/README.md)
<!-- /study-navigation -->

[Practice index](../../README.md) | Theory: [Complexity, Recurrences, and Amortization](../../../../01_algorithms/01_foundations/02-complexity-and-amortization.md)

**Status:** Implementation correct for positive inputs; theoretical solution added with assistance; input handling reviewed. This is a repository-written practice prompt, not a recruiting question-bank item.

## Exercise

Implement `Integer divide(Integer number)` to count integer divisions by three until a positive number reaches zero. Return `0` for null, zero or negative input, matching the existing implementation. Use a loop rather than logarithms.

## Examples and checks

`200` returns `5`; inputs `1,2,3,8,9` return `1,1,2,2,3`; check null, zero and a negative value.

## Your workspace

Write your Java 17 implementation and an executable test runner in `src/`. Use `AlgorithmXX_YY.java` and `MainXX_YY.java` with this exercise's numbers, or keep the existing class names. For data-structure exercises, use the requested class and a separate runner. Compare actual and expected results, including the cases above; throw `AssertionError` on a mismatch (or run Java assertions with `-ea`).

The deliverable is working Java code and checks. You may add a short explanation of the algorithm in `src/README.md`, like exercise 02.01; a formal proof or a separate theoretical answer is not required. Unless stated otherwise, inputs are non-null, indices and graph endpoints are valid, and auxiliary result types such as `Node` or `Selection` are yours to define.

<details><summary>Implementation hint</summary>

Count each executed division. The primitive helper below assumes a positive value; handle the public method's invalid inputs before using it.

### Java helper

Optional helper members for your class; add the necessary imports from java.util. Complete the public API and tests described above.

<!-- java-hint -->
```java
static int divisionSteps(long value) {
    if (value <= 0) throw new IllegalArgumentException("Positive input required");
    int steps = 0;
    while (value > 0) {
        value /= 3;
        steps++;
    }
    return steps;
}
```
<!-- /java-hint -->

</details>

## Your solution

[Read the solution](src/README.md).

---

<!-- study-navigation -->
[← Previous: Exercise 01.04](../../01_mathematics-and-correctness/04_counting-subsequences/README.md) · [Index](../README.md) · [Next: Exercise 02.02 →](../02_pairwise-string-comparison/README.md)
<!-- /study-navigation -->
