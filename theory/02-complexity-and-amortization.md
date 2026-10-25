# 02 - Complexity, Recurrences, and Amortization

[Curriculum](README.md) | Prerequisite: [01](01-mathematics-and-correctness.md)

## Define the input and cost model

A running-time claim needs a size parameter and a model of elementary operations. Scanning `n` integers is different from comparing `n` strings of maximum length `L`. Graph bounds often need both `V` and `E`; rectangular grids need rows and columns. Integer input magnitude `W` occupies only `Theta(log W)` bits.

The usual word-RAM model treats fixed-width arithmetic, comparisons, and indexed access as constant time. It does not make arbitrarily long integers, string comparison, copying, or hashing arbitrary objects free. A loop executing `n` additions is not necessarily `O(n)` bit complexity if its numbers keep growing.

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

Use recursion trees to sum work by level, or substitution to prove a guessed bound. A common Master Theorem form applies to `aT(n/b)+f(n)` with constant `a>=1,b>1`. Compare `f(n)` with `n^(log_b a)`: polynomially smaller gives the latter bound; equal up to a nonnegative logarithmic power adds one logarithm; polynomially larger gives `Theta(f(n))` **if** the regularity condition `a*f(n/b)<=c*f(n)` holds for a constant `c<1`. Do not apply this shortcut to unequal branches or `T(n-1)`.

## Amortized analysis

Consider a dynamic array whose capacity doubles when full. Over `n` appends from empty, copies cost at most `1+2+4+...<2n`; writes cost `n`. Total time is `O(n)`, so an append costs `O(1)` amortized, although a resize costs `Theta(n)`.

Three proof styles express the same accounting:

- **Aggregate:** bound total actual work directly.
- **Accounting:** charge cheap operations extra credit to pay for later expensive ones.
- **Potential:** let `Phi(state)>=0`; charge `actual + Phi(after)-Phi(before)`. Summing telescopes. With zero initial potential, total actual cost is at most total amortized cost.

For a queue made from two stacks, each item is pushed onto the input stack, moved once to the output stack, and popped once. Any operation can move many items, but `m` queue operations cost `O(m)`. For shrinking arrays, use hysteresis, such as shrinking at one-quarter full, to avoid alternating grow/shrink operations at the same threshold.

## Space and lower bounds

Count peak simultaneously live memory. A recursive depth-`n` algorithm uses `O(n)` stack even if every frame stores only two variables. Balanced tree recursion uses `O(log n)` depth; a skewed tree uses `O(n)`. Allocating two arrays sequentially does not multiply their sizes.

An exact maximum in an unsorted array requires `n-1` comparisons in the comparison model: every nonmaximum must lose at least one comparison. Comparison sorting needs `Omega(n log n)` worst-case comparisons because a binary decision tree must distinguish `n!` permutations. Counting sort does not contradict that result: it uses bounded integer keys and a different operation model.

## Practice

1. Analyze a loop that repeatedly divides a positive integer by three.
2. Analyze all pairs of strings when each comparison can inspect `L` characters.
3. Prove linear total time for popping smaller entries from a monotonic stack.
4. Why is `O(nW)` knapsack called pseudopolynomial?

<details><summary>Hints and checkpoints</summary>

1. `Theta(log n)` iterations under unit-cost arithmetic.
2. `O(n^2 L)` worst case; equal long prefixes realize costly comparisons.
3. Charge each pop to the unique earlier push of that entry.
4. `W` may be exponential in the bit length used to represent it.

</details>

**Explain aloud:** “This is an amortized bound over a sequence, not a worst-case bound for one operation.” Vocabulary: tight bound, dominant term, recurrence, allocation, peak memory, adversarial input.

## Sources and deeper study

- [Open Data Structures, Array-Based Lists](https://opendatastructures.org/ods-java/2_Array_Based_Lists.html): operation costs and resizing analysis.
- [MIT 6.006 lecture notes](https://ocw.mit.edu/courses/6-006-introduction-to-algorithms-spring-2020/pages/lecture-notes/): lectures 1-3 and 19 for computational models, sorting, and complexity.
- [Erickson's algorithms materials](https://jeffe.cs.illinois.edu/teaching/algorithms/): the appendices on recurrences and the separate amortized-analysis notes provide additional proofs.
