# 23 - Strong Connectivity, Tree Queries, Matching, and Flow

[Practice index](README.md) | Theory: [Strong Connectivity, Tree Queries, Matching, and Flow](../../algorithms/graphs/23-advanced-graphs-and-flow.md)

**Status:** Suggested practice; no solution or completion is implied. These prompts and hints were written for this repository, not copied from a recruiting question bank.

## Your deliverable

Write a specification, your solution, a correctness argument, time/space analysis, and tests. Record independent attempts in [PROGRESS.md](../../PROGRESS.md).

## Exercises

1. Compress SCCs and compute reachability-related summaries on the condensation DAG.
2. Find bridges in a graph containing parallel edges and disconnected components.
3. Answer tree-distance queries after one preprocessing pass.
4. Build a matching example requiring reassignment through a backward residual edge.
5. After computing max flow, output a cut certificate and verify equal values.

<details><summary>Hints and checkpoints</summary>

1. Deduplicate intercomponent edges when the subsequent computation treats them as unique.
2. Ignore only the exact parent edge, not all edges to the parent vertex.
3. LCA identifies the shared root-path prefix counted twice.
4. One left vertex can take either of two tasks while another can take only the first.
5. BFS residual positive-capacity edges from the source after termination.

</details>
