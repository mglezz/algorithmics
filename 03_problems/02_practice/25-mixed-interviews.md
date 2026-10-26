# 25 - Mixed Interview Challenges

<!-- study-navigation -->
[← Previous: Unit 24](24-complexity-and-advanced-design.md) · [Index](README.md) · [Next: Practice sets →](README.md)
<!-- /study-navigation -->

[Practice index](README.md) | Theory: [Solving, Testing, and Communicating](../../01_algorithms/14_problem-solving/25-solving-testing-and-communication.md)

**Status:** Suggested practice; no solution or completion is implied. These prompts and hints were written for this repository, not copied from a recruiting question bank.

## Your deliverable

Write a specification, your solution, a correctness argument, time/space analysis, and tests. Record independent attempts in [PROGRESS.md](../../PROGRESS.md).

## Exercises

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

<details><summary>Hints and checkpoints</summary>

### Java starting point

For the synthesis task, start with immutable nodes so that unchanged subtrees can be shared across versions. A leaf has null children. This representation does not yet perform queries or updates.

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

**Complete the reasoning:** Implement an update by allocating nodes on one root-to-leaf path and retaining untouched children. Keep every version root and test that an update leaves old queries unchanged.

</details>

---

<!-- study-navigation -->
[← Previous: Unit 24](24-complexity-and-advanced-design.md) · [Index](README.md) · [Next: Practice sets →](README.md)
<!-- /study-navigation -->
