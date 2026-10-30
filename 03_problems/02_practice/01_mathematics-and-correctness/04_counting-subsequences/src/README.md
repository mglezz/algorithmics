# 01.04 - Counting Subsequences - Solution

[Exercise](../README.md)

A subsequence is formed by choosing positions and keeping their original order. The positions do not have to be next to each other.

To choose `k` positions from `n`, there are `C(n, k) = n! / (k! · (n - k)!)` possibilities. Repeated values do not change this count because the positions are still different.

For example, choosing two positions from `[A, A, B]` gives three choices: `(0, 1)`, `(0, 2)`, and `(1, 2)`. Their values are `[A, A]`, `[A, B]`, and `[A, B]`. So there are three choices of positions, but only two different sequences of values.

Choosing zero elements gives one empty subsequence. Choosing all elements gives one complete subsequence. Choosing more elements than available gives none.
