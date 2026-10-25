# Technical English: Quick Reference

[Quick-reference index](README.md) | [Curriculum](../CURRICULUM.md)

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

## Full explanations

- [Communication and interview practice](../algorithms/problem-solving/25-solving-testing-and-communication.md)

These are summaries of the linked chapters. Their source attribution is in those chapters and [SOURCES.md](../SOURCES.md).
