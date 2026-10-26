# 24.03 - Convex Hull Edge Cases

<!-- study-navigation -->
[← Previous: Exercise 24.02](../02_vertex-cover-approximation/README.md) · [Index](../README.md) · [Next: Exercise 24.04 →](../04_persistent-range-sums/README.md)
<!-- /study-navigation -->

[Practice index](../../README.md) | Theory: [Computational Limits and Advanced Algorithm Design](../../../../01_algorithms/13_advanced/24-complexity-and-advanced-design.md)

**Status:** Not started. This is a repository-written practice prompt, not a recruiting question-bank item.

## Exercise

Test convex hull on duplicate, collinear, and extreme-coordinate points.

## Your workspace

Keep your implementation (for example, `Solution.java`) and your tests in this folder. For a proof, analysis, or counterexample task, write your answer in the solution section below; add code only when useful.

State the input/output contract, explain correctness, analyze time and space, and check boundary cases. Java helper fragments belong inside your own class with `import java.util.*;`.

<details><summary>Hints and checkpoints</summary>

Define the output policy before checking expected hull vertices.

### Java starting point

For this exercise, subtract int coordinates only after widening. This exact orientation helper uses BigInteger because a determinant involving extreme int coordinates can overflow long.

<!-- java-hint -->
```java
record Point(int x, int y) {}

static int orientation(Point a, Point b, Point c) {
    java.math.BigInteger abX = java.math.BigInteger.valueOf((long) b.x() - a.x());
    java.math.BigInteger abY = java.math.BigInteger.valueOf((long) b.y() - a.y());
    java.math.BigInteger acX = java.math.BigInteger.valueOf((long) c.x() - a.x());
    java.math.BigInteger acY = java.math.BigInteger.valueOf((long) c.y() - a.y());
    return abX.multiply(acY).subtract(abY.multiply(acX)).signum();
}
```
<!-- /java-hint -->

**Complete the reasoning:** Decide whether collinear boundary points should remain in the hull. State that BigInteger arithmetic is not a constant-time operation for arbitrary bit lengths.

</details>

## Your solution

Add your approach, correctness argument, complexity analysis, and test results after attempting the exercise. Record the attempt in [PROGRESS.md](../../../../PROGRESS.md).

---

<!-- study-navigation -->
[← Previous: Exercise 24.02](../02_vertex-cover-approximation/README.md) · [Index](../README.md) · [Next: Exercise 24.04 →](../04_persistent-range-sums/README.md)
<!-- /study-navigation -->
