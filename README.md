# Algorithmics

Algorithms and data structures in English, with Java examples and a separate space for your own practice.

## Where things belong

| Folder | Purpose |
|---|---|
| [algorithms/](algorithms/README.md) | Algorithm theory: concepts, proofs, complexity, worked examples and sources |
| [data-structures/](data-structures/README.md) | Data structure theory: representation, invariants, operations, costs and sources |
| [problems/](problems/README.md) | Exercises you work on, your solutions, tests and reviews |
| [notes/](notes/README.md) | Short revision sheets and quick lookup documents |
| [tests/](tests/README.md) | Checks for documentation links and executable theory examples |

## Start studying

1. Follow the [curriculum](CURRICULUM.md), which links the theory across both folders.
2. Read a chapter, trace its worked example, and explain its invariant in English.
3. Attempt the linked [practice set](problems/practice/README.md) before opening the hints.
4. Keep your implementations in their own problem folders and record evidence in [PROGRESS.md](PROGRESS.md).
5. Use [quick notes](notes/README.md) to recall something you have already studied.

The existing [Service Startup Dependencies](problems/serviceDependencies/README.md) exercise is connected to the [topological-order chapter](algorithms/graphs/14-traversal-and-topological-order.md).

## Sources and review

Each theory chapter maps sections to named sources and distinguishes standard algorithms from repository-written explanations, diagrams and code. [SOURCES.md](SOURCES.md) records references, attribution policy, review corrections and limits.

This is a broad study course with advanced extensions, not an official Google syllabus or an exhaustive algorithms textbook. Check the specific role and recruiter instructions for current interview requirements.

## Verify the material

With PowerShell and a JDK supporting Java 17 compilation:

```powershell
powershell -NoProfile -ExecutionPolicy Bypass -File .\tests\verify-theory.ps1
```

The policy option affects only this process. The script checks local links and Markdown structure, compiles Java directly from the theory, and runs property/differential checks. See [tests/README.md](tests/README.md) for exact coverage.
