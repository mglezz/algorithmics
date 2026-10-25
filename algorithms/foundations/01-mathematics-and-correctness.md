# 01 - Discrete Mathematics and Correctness

[Curriculum](../../CURRICULUM.md) | [Quick reference](../../notes/proof-checklist.md)

> **Core idea:** A solution needs a precise contract, a correctness argument, and a termination argument.

## On this page

- [Learning objectives](#learning-objectives)
- [Worked visual](#worked-visual)
- [Start with the specification](#start-with-the-specification)
- [Mathematical toolkit](#mathematical-toolkit)
- [Proof techniques](#proof-techniques)
- [Worked proof: maximum of a nonempty array](#worked-proof-maximum-of-a-nonempty-array)
- [Certificates and validation](#certificates-and-validation)
- [Explain it in English](#explain-it-in-english)
- [Practice](#practice)
- [Attribution and references](#attribution-and-references)

## Learning objectives

Translate prose into a precise contract; reason about sets, sequences, graphs, and counting; prove that an algorithm returns the required result and terminates.

## Worked visual

| Proof obligation | Maximum-scan example |
|---|---|
| Initialize | best is the maximum of the first entry |
| Maintain | Compare best with the next unread entry |
| Conclude | No unread entries remain, so best covers the whole array |
| Terminate | The unread suffix loses one entry each iteration |

## Start with the specification

An algorithm maps legal inputs to outputs satisfying a relation. A problem can admit several correct outputs: a topological ordering need not be unique. Separate the **precondition** (what inputs are allowed), **postcondition** (what must be true afterward), and **side effects** (whether input may change).

For a first-occurrence search, a useful contract is: input is a sorted array; return the smallest index containing the target, or `-1` if none exists; do not mutate the array. “Return the target” is not precise enough. Ask about duplicates, empty input, numerical limits, and impossible cases before designing an implementation.

An abstract data type specifies behavior, such as map lookup. A data structure supplies a representation, such as a hash table or balanced search tree. The same abstraction can have different operation costs.

## Mathematical toolkit

- A **set** ignores order and multiplicity; a **multiset** retains counts; a **sequence** retains positions. Choosing the wrong model can lose information.
- `A subset B` means every member of `A` is in `B`; a counterexample is one member of `A` outside `B`.
- A function maps every domain element to exactly one codomain element. Injective means no two distinct inputs share an output; bijective means injective and onto. Bijections are useful for counting without duplication.
- A relation may be reflexive, symmetric, or transitive. An equivalence relation partitions a set into classes, as in connected components. A partial order permits incomparable elements, as in dependency constraints.
- `for every x, there exists y` does not mean one `y` works for all `x`. Quantifier order often explains incorrect correctness arguments.
- To disprove a universal claim, one valid counterexample is enough. To prove it, many successful tests are not enough.

Useful identities:

| Expression | Value or interpretation |
|---|---|
| `1 + ... + n` | `n(n+1)/2` |
| `1 + 2 + ... + 2^k` | `2^(k+1)-1` |
| `log_b(x*y)` | `log_b x + log_b y`, for positive arguments |
| Number of subsets of an n-element set | `2^n` |
| Number of permutations of n distinct elements | `n!` |
| Number of k-element subsets | `n! / (k! (n-k)!)` |
| Number of nonempty contiguous ranges | `n(n+1)/2` |

The product rule multiplies independent stages of choice. The sum rule adds disjoint alternatives. If alternatives overlap, subtract the overlap or partition them first. “Subarray” is contiguous; “subsequence” preserves order but may skip positions; “subset” does not retain order.

## Proof techniques

**Direct proof:** derive the claim from definitions. **Contradiction:** assume the claim is false and derive an impossibility. **Induction:** establish a base case and show that a smaller established case implies the next. Strong induction may use all smaller cases, making it natural for recursive algorithms. Structural induction follows a recursive object, such as a tree's children.

A loop invariant is a statement true at a specified point in every iteration. A complete loop proof has four obligations:

1. Initialization establishes the invariant.
2. Maintenance preserves it after the loop body.
3. Exit plus the invariant implies the postcondition.
4. A well-founded variant, such as the remaining length, decreases and proves termination.

Partial correctness proves the postcondition **if** execution finishes. Total correctness adds termination. A recursive proof likewise needs smaller recursive inputs; “the recursive call works” alone is circular reasoning.

## Worked proof: maximum of a nonempty array

```text
best = a[0]
for i = 1 .. n-1:
    best = max(best, a[i])
return best
```

At the start of iteration `i`, `best` is the maximum of `a[0..i)`. Initialization handles the one-element prefix. Taking the maximum with `a[i]` extends the claim to `a[0..i+1)`. On exit, `i=n`, so the entire array is covered. The number of unprocessed entries decreases each iteration.

Initializing `best=0` violates the invariant for all-negative arrays. The smallest useful counterexample is `[-1]`. Empty input is outside this contract; if it must be accepted, define an optional result or an exception rather than silently returning zero.

## Certificates and validation

A certificate is evidence that an answer satisfies a property. Given a proposed startup order, create `position[service]`; check that every service occurs once and every dependency's prerequisite occurs earlier. This validator is independent of how the order was produced. It can accept both `[0,1,2,3]` and `[0,2,1,3]`.

Validating an answer is not always enough to establish optimality. A feasible schedule may be slower than another. Optimization algorithms need a lower bound, an exchange argument, or a recurrence proving no better answer exists.

## Explain it in English

> “The invariant describes what is already correct. The decreasing variant explains why the algorithm stops.”

**Vocabulary:** precondition, postcondition, witness, counterexample, induction hypothesis, necessary, sufficient.

## Practice

Attempt the [unit 01 exercise set](../../problems/practice/01-mathematics-and-correctness.md). Exercises and hints live in `problems/`; this chapter contains the theory.

## Attribution and references

**Provenance:** This chapter is a synthesis of the sources mapped below. Standard definitions, algorithms and proof techniques belong to those established references; the explanatory wording, traces, diagrams and Java examples were written for this repository. No source passage is quoted verbatim.

| Section / claim | Source used | How it is used |
|---|---|---|
| Contracts, invariants and certificates | [Demaine, Ku and Solomon, MIT 6.006 (Spring 2020)](https://ocw.mit.edu/courses/6-006-introduction-to-algorithms-spring-2020/pages/lecture-notes/) | Lecture 1; standard specification/correctness framework, restated here. |
| Logic, induction, counting and relations | [Lehman, Leighton and Meyer, Mathematics for Computer Science](https://ocw.mit.edu/courses/6-042j-mathematics-for-computer-science-spring-2015/pages/readings/) | Corresponding proof, counting and relation chapters; definitions and identities. |

See [SOURCES.md](../../SOURCES.md) for editions, review scope, and the distinction between consulted material and further reading.
