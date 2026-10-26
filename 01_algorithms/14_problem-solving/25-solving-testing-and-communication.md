# 25 - Solving, Testing, and Communicating

<!-- study-navigation -->
[← Previous: Unit 24](../13_advanced/24-complexity-and-advanced-design.md) · [Index](../../README.md#study-index) · [Next: Study index →](../../README.md#study-index)
<!-- /study-navigation -->

[Curriculum](../../CURRICULUM.md) | [Quick reference](../../04_notes/interview-checklist.md)

> **Core idea:** Make the specification, proof, implementation and validation agree, and explain the decisions clearly.

## On this page

- [Preparation target](#preparation-target)
- [Worked visual](#worked-visual)
- [A repeatable problem-solving conversation](#a-repeatable-problem-solving-conversation)
- [Testing as an independent argument](#testing-as-an-independent-argument)
- [Boundary checklist](#boundary-checklist)
- [Review rubric and broader preparation](#review-rubric-and-broader-preparation)
- [Practice](#practice)
- [Attribution and references](#attribution-and-references)

## Preparation target

Your target is independent problem solving: extract a specification, propose a baseline, justify an improvement, implement it, test it, and adapt when constraints change. This curriculum is not an official Google question list, hiring rubric, or guarantee of success. Application requirements and interview formats vary; confirm the actual role's details with the recruiter and job posting.

Google's public preparation materials emphasize 01_algorithms/data structures, communication, coding, and testing. Its published engineer advice also recommends explaining your thinking aloud. Those are useful preparation signals, not evidence for a universal number of rounds or a mandated language. See the dated official sources below.

## Worked visual

| Claim during an explanation | Evidence to supply |
|---|---|
| This is the required output | A precise postcondition |
| This step is safe | An invariant or exchange argument |
| The implementation is efficient | An operation count with assumptions |
| The returned witness is valid | An independent property check |
| The answer is optimal | A recurrence, lower bound or optimality proof |

## A repeatable problem-solving conversation

1. **Clarify:** restate inputs, outputs, constraints, duplicates, mutability, and impossible cases. Ask focused questions that affect the algorithm.
2. **Model:** name the mathematical object: sequence, multiset, graph, interval family, or state space. Work a small example by hand.
3. **Baseline:** give a correct simple method and its resource cost. It provides a reference and often a testing oracle.
4. **Improve:** identify repeated work, exploitable order, a sufficient state, or a safe elimination rule. Compare one or two plausible options.
5. **Justify:** state the invariant, exchange argument, or recurrence before the details obscure it.
6. **Implement:** choose clear names and consistent boundaries. Explain important decisions without narrating every keystroke.
7. **Validate:** trace normal, boundary, and adversarial cases; revisit arithmetic and space assumptions.
8. **Adapt:** explain what changes for streaming input, negative weights, duplicates, memory limits, or requested reconstruction.

For a self-organized 45-minute practice session, a possible allocation is five minutes for clarification, ten for design and proof, twenty for implementation, and ten for testing and follow-up. This is a training format, not a claim about Google's timing. Adjust based on what your reviews reveal.

## Testing as an independent argument

Examples show behavior; properties test the specification. For sorting, check order **and** the input multiset. For shortest paths, validate a reconstructed path's edges and cost; a valid path alone does not establish optimality. For topological sorting, validate every dependency relation instead of comparing one arbitrary order.

**Differential testing** compares a fast solution with a deliberately simple oracle on many small cases. Enumerate all subsets for small knapsack; scan all intervals for a window problem; use a cubic all-pairs method to check small nonnegative shortest-path instances. Keep the oracle structurally different from the optimized solution so the same bug is less likely to be duplicated.

**Metamorphic testing** checks how answers should change under controlled input transformations. Relabeling graph vertices preserves connectivity; reversing a list twice restores the same nodes and order; sorting a sorted result changes nothing. Ensure a transformation preserves the actual contract: shuffling an array does not preserve subarray answers.

Use deterministic random seeds for reproducibility, then reduce failing cases to the smallest counterexample. Random tests supplement a proof; they do not replace one. For randomized algorithms, distinguish testing returned-answer correctness from testing distribution or runtime properties.

## Boundary checklist

| Dimension | Representative cases |
|---|---|
| Size | Empty, singleton, smallest valid nontrivial case, long chain |
| Values | Zero, negatives if allowed, duplicates, integer extremes |
| Order | Sorted, reverse sorted, alternating extremes, all equal |
| Existence | No solution, one solution, many solutions |
| Graph structure | Isolated vertices, disconnected components, self-loop, cycle, parallel edges |
| Mutation | Input reused after the call, shared references, repeated calls |
| Output | Tie rules, unique vs all answers, count vs witness, stable identity |

Do not spend an interview defending impossible inputs if the stated contract already excludes them. State the assumption and focus on legal adversarial cases.

## Review rubric and broader preparation

After each mock, score specification, modeling, correctness reasoning, implementation, analysis, testing, and communication separately as: unable yet, completed with help, independent, or independent after a delay. These are personal study categories, not Google's scoring system. Record one concrete improvement instead of a vague judgment such as “bad at DP.”

For internship preparation, build strong evidence from coursework, personal projects, and independent problem solving. Prepare truthful explanations of your contributions, design decisions, bugs, and collaboration. As you move toward full-time roles, continue operating-systems, networking, databases, concurrency, API design, and role-appropriate system design alongside algorithms. DSA mastery alone is not the entire software-engineering skill set.

## Practice

Attempt the [unit 25 exercise set](../../03_problems/02_practice/25-mixed-interviews.md). Exercises and hints live in `03_problems/`; this chapter contains the theory.

## Attribution and references

**Provenance:** This chapter is a synthesis of the sources mapped below. Standard definitions, algorithms and proof techniques belong to those established references; the explanatory wording, traces, diagrams and Java examples were written for this repository. No source passage is quoted verbatim.

| Section / claim | Source used | How it is used |
|---|---|---|
| Public interview preparation guidance | [Life at Google, coding interview preparation (2019)](https://www.youtube.com/watch?v=6ZZX9iIgFoo) | Historical guidance on communication, coding and testing. |
| Speaking aloud and explaining reasoning | [Jason Rowland, Google engineer interview (March 17, 2022)](https://blog.google/company-news/inside-google/life-at-google/google-engineer-shares-her-technical-interview-tips/) | Published personal advice; not a current hiring-process specification. |
| Testing framework and study rubric | This repository | Repository-authored recommendations and exercise design; no Google scoring claim. |

See [SOURCES.md](../../SOURCES.md) for editions, review scope, and the distinction between consulted material and further reading.

---

<!-- study-navigation -->
[← Previous: Unit 24](../13_advanced/24-complexity-and-advanced-design.md) · [Index](../../README.md#study-index) · [Next: Study index →](../../README.md#study-index)
<!-- /study-navigation -->
