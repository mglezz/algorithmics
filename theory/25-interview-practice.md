# 25 - Interview Practice, Testing, and Technical English

[Curriculum](README.md) | Prerequisite: the main route

## Preparation target

Your target is independent problem solving: extract a specification, propose a baseline, justify an improvement, implement it, test it, and adapt when constraints change. This curriculum is not an official Google question list, hiring rubric, or guarantee of success. Application requirements and interview formats vary; confirm the actual role's details with the recruiter and job posting.

Google's public preparation materials emphasize algorithms/data structures, communication, coding, and testing. Its published engineer advice also recommends explaining your thinking aloud. Those are useful preparation signals, not evidence for a universal number of rounds or a mandated language. See the dated official sources below.

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

## Practice ladder with concrete tasks

These are original exercise prompts, not claimed leaked or recurring company questions.

| Stage | Task | Required follow-up |
|---|---|---|
| Foundation | Find the first index at which a sorted array reaches a threshold | Count equal values using two boundaries |
| Sequence | Count contiguous ranges summing to a target, with negatives allowed | Return the longest such range |
| Structure | Support cache lookup/update and eviction of the least recently used item | State invariants and test overwrites/capacity zero |
| Graph | Return a legal service startup order | Return a cycle witness or the smallest legal order |
| Paths | Find a cheapest route with one optional free edge | Explain why vertex-only visited state is insufficient |
| Greedy / DP | Choose nonoverlapping jobs to maximize count | Change the objective to total job value |
| DP | Return a longest increasing subsequence | Explain why tails alone do not reconstruct it |
| Advanced | Support interleaved point updates and range sums | Extend to range additions and justify the new structure |
| Synthesis | Maintain versioned service-cost arrays and query an old version's range total | Explain persistence, sharing, and memory growth |

For each task, first solve without notes, then review the relevant unit, then solve a different variation after a delay. Do not mark a problem independent if you needed the main idea from a hint.

## English explanation toolkit

Use these as sentence patterns, not a script to recite regardless of the problem:

- “May I assume the input is sorted and contains no null entries?”
- “A straightforward solution examines every pair and takes quadratic time.”
- “The invariant is that this prefix already contains the final answer for those positions.”
- “This state records the information that affects all future choices.”
- “That greedy choice needs an exchange argument; here is why it is safe.”
- “The bound is expected, assuming the hash function distributes keys appropriately.”
- “The auxiliary space includes the recursion stack but excludes the returned output.”
- “This counterexample breaks the monotonicity required by my first approach.”
- “I will trace the empty case and then a case with repeated values.”
- “I found an off-by-one error in the right boundary; the interval is half-open.”

Distinguish **memoization** from memorization, **subsequence** from substring, **optimal** from merely valid, and **amortized** from average-case. Say “at most,” “at least,” and “exactly” precisely: they often determine the algorithm.

## Review rubric and broader preparation

After each mock, score specification, modeling, correctness reasoning, implementation, analysis, testing, and communication separately as: unable yet, completed with help, independent, or independent after a delay. These are personal study categories, not Google's scoring system. Record one concrete improvement instead of a vague judgment such as “bad at DP.”

For internship preparation, build strong evidence from coursework, personal projects, and independent problem solving. Prepare truthful explanations of your contributions, design decisions, bugs, and collaboration. As you move toward full-time roles, continue operating-systems, networking, databases, concurrency, API design, and role-appropriate system design alongside algorithms. DSA mastery alone is not the entire software-engineering skill set.

## Sources

- [Life at Google, Prepare for Your Google Interview: Coding](https://www.youtube.com/watch?v=6ZZX9iIgFoo), published July 2019: official coding-preparation guidance, including communication and testing. Historical guidance, not a current process specification.
- [Google, A Google engineer shares her technical interview tips](https://blog.google/company-news/inside-google/life-at-google/google-engineer-shares-her-technical-interview-tips/), April 2022: practice speaking aloud and explain your reasoning.
- [Google Careers interview preparation entry point](https://www.google.com/about/careers/applications/interview-tips): check current material and recruiter instructions. The text retrieval during this repository's preparation exposed mostly navigation, so no specific hiring-process claim is based on its page body.
- [MIT 6.006 practice problems](https://ocw.mit.edu/courses/6-006-introduction-to-algorithms-spring-2020/pages/practice-problems/) and [Erickson's coursework archive](https://jeffe.cs.illinois.edu/teaching/algorithms/hwex.html): additional university-level exercises. Attempt problems before consulting any provided solutions.
