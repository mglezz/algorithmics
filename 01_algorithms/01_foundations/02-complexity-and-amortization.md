# 02 - Complexity, Recurrences, and Amortization

<!-- study-navigation -->
[← Previous: Unit 01](01-mathematics-and-correctness.md) · [Index](../../README.md#study-index) · [Next: Unit 03 →](03-java-for-interviews.md)
<!-- /study-navigation -->

[Curriculum](../../CURRICULUM.md) | [Quick reference](../../04_notes/complexity.md)

> **Core idea:** Count the actual work under an explicit model; keep worst-case, expected and amortized bounds separate.

## On this page

- [Define the input and cost model](#define-the-input-and-cost-model)
- [Worked visual](#worked-visual)
- [Asymptotic notation](#asymptotic-notation)
- [Count work rather than loops](#count-work-rather-than-loops)
- [Recurrences](#recurrences)
- [Amortized analysis](#amortized-analysis)
- [Space and lower bounds](#space-and-lower-bounds)
- [Explain it in English](#explain-it-in-english)
- [Practice](#practice)
- [Attribution and references](#attribution-and-references)

## Define the input and cost model

A running-time claim needs a size parameter and a model of elementary operations. Scanning `n` integers is different from comparing `n` strings of maximum length `L`. Graph bounds often need both `V` and `E`; rectangular grids need rows and columns. Integer input magnitude `W` occupies only `Theta(log W)` bits.

The usual word-RAM model treats fixed-width arithmetic, comparisons, and indexed access as constant time. It does not make arbitrarily long integers, string comparison, copying, or hashing arbitrary objects free. A loop executing `n` additions is not necessarily `O(n)` bit complexity if its numbers keep growing.

## Worked visual

| Append number | Capacity after append | Old entries copied |
|---|---|---|
| 1 | 1 | 0 |
| 2 | 2 | 1 |
| 3 | 4 | 2 |
| 4 | 4 | 0 |
| 5 | 8 | 4 |

The expensive operations are sparse: copies through append 5 total 1 + 2 + 4, not five copies of the largest array.

## Asymptotic notation

For eventually nonnegative functions, `f(n)=O(g(n))` means some positive constants `c,n0` satisfy `f(n)<=c*g(n)` for every `n>=n0`. `Omega` is a lower bound; `Theta` is both. `o(g)` is strictly smaller asymptotic growth: the ratio tends to zero where defined. Big O is an upper bound, not an exact count or a synonym for worst case.

**Worst case** maximizes over legal inputs of a given size. **Average case** needs an input distribution. **Expected time** may average over internal random choices for a fixed input. **Amortized cost** bounds a sequence of operations without needing randomness. Never substitute these terms for one another.

Fixed logarithm bases differ by a constant. A useful growth ordering is `1`, `log n`, `sqrt(n)`, `n`, `n log n`, `n^2`, `n^3`, `2^n`, `n!`. Small inputs, cache behavior, allocation, and constants can still reverse practical rankings.

## Count work rather than loops

```text
for i = 0 .. n-1:
    for j = 0 .. i-1:
        constant_work()
```

This performs `sum(i)=n(n-1)/2`, so time is `Theta(n^2)`. A nested loop whose inner pointer only moves forward across the entire execution can instead be linear. Two separate scans cost `O(n)+O(m)`, not `O(n*m)`.

For `i=1; i<n; i*=2`, there are `Theta(log n)` iterations mathematically. In code, ensure multiplication cannot overflow and make the loop nonterminating. If iteration `i` performs `i` work while `i` doubles, the geometric sum is `Theta(n)`, not `Theta(n log n)`.

Account for output: enumerating all subsets and copying each costs `Theta(n*2^n)` in aggregate, even if generating the next choice is cheap. Returning `k` items requires at least `Omega(k)` writes in an explicit-output model.

## Recurrences

Define a base case and include nonrecursive work:

| Recurrence | Bound | Typical origin |
|---|---|---|
| `T(n)=T(n/2)+Theta(1)` | `Theta(log n)` | Binary search |
| `T(n)=2T(n/2)+Theta(n)` | `Theta(n log n)` | Merge sort |
| `T(n)=T(n-1)+Theta(n)` | `Theta(n^2)` | Repeated linear reduction |
| `T(n)=T(n-1)+T(n-2)+Theta(1)` | `Theta(phi^n)` | Naive Fibonacci, `phi=(1+sqrt(5))/2` |

Use recursion trees to sum work by level, or substitution to prove a guessed bound. For `T(n)=aT(n/b)+f(n)`, assume constant `a>=1`, `b>1`, and a constant-size base case. Write `p=log_b(a)`.

| Case | Required comparison | Result |
|---|---|---|
| Smaller combine work | f(n) = O(n^(p-epsilon)) for some epsilon > 0 | Theta(n^p) |
| Matching growth | f(n) = Theta(n^p log^k n), with k >= 0 | Theta(n^p log^(k+1) n) |
| Larger combine work | f(n) = Omega(n^(p+epsilon)) and a*f(n/b) <= c*f(n), for c < 1 | Theta(f(n)) |

> **Applicability check:** These cases require their stated polynomial gap or matching form. They do not cover every possible f(n), unequal branch sizes, or `T(n-1)` recurrences.

## Amortized analysis

Consider a dynamic array whose capacity doubles when full. Over `n` appends from empty, copies cost at most `1+2+4+...<2n`; writes cost `n`. Total time is `O(n)`, so an append costs `O(1)` amortized, although a resize costs `Theta(n)`.

Three proof styles express the same accounting:

- **Aggregate:** bound total actual work directly.
- **Accounting:** charge cheap operations extra credit to pay for later expensive ones.
- **Potential:** let `Phi(state)>=0`; charge `actual + Phi(after)-Phi(before)`. Summing telescopes. With zero initial potential, total actual cost is at most total amortized cost.

For a queue made from two stacks, each item is pushed onto the input stack, moved once to the output stack, and popped once. Any operation can move many items, but `m` queue operations cost `O(m)`. For shrinking arrays, use hysteresis, such as shrinking at one-quarter full, to avoid alternating grow/shrink operations at the same threshold.

## Space and lower bounds

Count peak simultaneously live memory. A recursive depth-`n` algorithm uses `O(n)` stack even if every frame stores only two variables. Balanced tree recursion uses `O(log n)` depth; a skewed tree uses `O(n)`. Allocating two arrays sequentially does not multiply their sizes.

An exact maximum in an unsorted array requires `n-1` comparisons in the comparison model: every nonmaximum must lose at least one comparison. Comparison sorting needs `Omega(n log n)` worst-case comparisons because, on n distinct keys, a binary decision tree must distinguish `n!` permutations. Counting sort does not contradict that result: it uses bounded integer keys and a different operation model.

## Explain it in English

> “This is an amortized bound over a sequence, not a worst-case bound for one operation.”

**Vocabulary:** tight bound, dominant term, recurrence, allocation, peak memory, adversarial input.

## Practice

Attempt the [unit 02 exercise set](../../03_problems/02_practice/02_complexity-and-amortization/README.md). Exercises and hints live in `03_problems/`; this chapter contains the theory.

## Attribution and references

**Provenance:** This chapter is a synthesis of the sources mapped below. Standard definitions, algorithms and proof techniques belong to those established references; the explanatory wording, traces, diagrams and Java examples were written for this repository. No source passage is quoted verbatim.

| Section / claim | Source used | How it is used |
|---|---|---|
| Cost models, notation and lower bounds | [Demaine, Ku and Solomon, MIT 6.006 (Spring 2020)](https://ocw.mit.edu/courses/6-006-introduction-to-algorithms-spring-2020/pages/lecture-notes/) | Lectures 1, 3, 5 and 19; models and bounds. |
| Dynamic arrays and amortization | [Pat Morin, Open Data Structures, chapter 2](https://opendatastructures.org/ods-java/2_Array_Based_Lists.html) | Resizing analysis; rewritten explanation and a new trace. |
| Recurrence-solving methods | [Jeff Erickson, Algorithms and supplementary notes](https://jeffe.cs.illinois.edu/teaching/algorithms/) | Appendix II and amortized-analysis notes; standard proof methods. |

See [SOURCES.md](../../SOURCES.md) for editions, review scope, and the distinction between consulted material and further reading.

---

<!-- study-navigation -->
[← Previous: Unit 01](01-mathematics-and-correctness.md) · [Index](../../README.md#study-index) · [Next: Unit 03 →](03-java-for-interviews.md)
<!-- /study-navigation -->
