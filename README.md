# Algorithmics

Algorithms and data structures in English, with Java examples and a separate space for own practice.

## Where things belong

| Folder | Purpose |
|---|---|
| [01_algorithms/](01_algorithms/README.md) | Algorithm theory: concepts, proofs, complexity, worked examples and sources |
| [02_data-structures/](02_data-structures/README.md) | Data structure theory: representation, invariants, operations, costs and sources |
| [03_problems/](03_problems/README.md) | Exercises you work on, your solutions, tests and reviews |
| [04_notes/](04_notes/README.md) | Short revision sheets and quick lookup documents |
| [05_tests/](05_tests/README.md) | Checks for documentation links and executable theory examples |

## Start studying

1. Follow the [curriculum](CURRICULUM.md), which links the theory across both folders.
2. Read a chapter, trace its worked example, and explain its invariant in English.
3. Attempt the linked [practice set](03_problems/02_practice/README.md) before opening the hints.
4. Keep your implementations in their own problem folders and record evidence in [PROGRESS.md](PROGRESS.md).
5. Use [quick notes](04_notes/README.md) to recall something you have already studied.

The existing [Service Startup Dependencies](03_problems/01_serviceDependencies/README.md) exercise is connected to the [topological-order chapter](01_algorithms/08_graphs/14-traversal-and-topological-order.md).

## Study index

Follow this route across both theory folders. Each chapter links to the previous and next chapter and back to this index, at both ends of the page. Practice sets and quick notes follow their own indexes. At a route boundary, navigation returns to its index.

Folder prefixes order siblings; the unit numbers below define the study sequence across folders. Use the next available two-digit folder prefix when adding a problem.

### Main route

| Unit | Topic | Prerequisites | Demonstrate |
|---|---|---|---|
| [01](01_algorithms/01_foundations/01-mathematics-and-correctness.md) | Discrete mathematics and correctness | Basic programming | State a contract and prove an invariant |
| [02](01_algorithms/01_foundations/02-complexity-and-amortization.md) | Complexity, recurrences, amortization | 01 | Derive bounds with explicit assumptions |
| [03](01_algorithms/01_foundations/03-java-for-interviews.md) | Java and the standard library | 02 | Choose collections and avoid numerical traps |
| [04A](02_data-structures/01_arrays-and-strings/04-arrays-and-strings.md) / [04B](01_algorithms/02_range-queries/04-prefix-sums-and-difference-arrays.md) | Arrays, strings, prefix and difference arrays | 01-03 | Turn range queries into prefix operations |
| [05](02_data-structures/02_hash-tables/05-hash-tables.md) | Hashing and dictionaries | 02-04 | Design keys and qualify expected costs |
| [06](01_algorithms/03_two-pointers/06-two-pointers-and-sliding-windows.md) | Two pointers and windows | 04-05 | Justify every discarded candidate |
| [07](02_data-structures/03_linked-lists/07-linked-lists.md) | Linked lists | 01-03 | Rewire references safely |
| [08A](02_data-structures/04_stacks-and-queues/08-stacks-and-queues.md) / [08B](01_algorithms/04_monotonic-structures/08-monotonic-stacks-and-deques.md) | Stacks, queues, monotonic structures | 04, 07 | Prove amortized linear scans |
| [09](01_algorithms/05_searching/09-binary-search.md) | Binary and parametric search | 01-04 | Search a monotone predicate safely |
| [10](01_algorithms/06_sorting/10-sorting-and-selection.md) | Sorting, selection, divide and conquer | 02, 04, 09 | Explain stability and lower bounds |
| [11](01_algorithms/07_backtracking/11-recursion-and-backtracking.md) | Recursion, exhaustive search, pruning | 01-02, 04 | Enumerate without omissions or duplicates |
| [12](02_data-structures/05_trees/12-trees-and-ordered-maps.md) | Trees, BSTs, balance, augmentation | 07, 09, 11 | Derive tree recurrences |
| [13](02_data-structures/06_heaps/13-heaps-and-priority-queues.md) | Heaps and priority queues | 04, 12 | Maintain top-k values and merge streams |
| [14A](02_data-structures/07_graphs/14-graph-representations.md) / [14B](01_algorithms/08_graphs/14-traversal-and-topological-order.md) | Graph modeling, BFS, DFS, DAGs | 08, 11 | Model dependencies and detect cycles |
| [15](01_algorithms/08_graphs/15-shortest-paths.md) | Weighted shortest paths | 13-14 | Choose the right relaxation order |
| [16A](02_data-structures/08_disjoint-sets/16-disjoint-sets.md) / [16B](01_algorithms/08_graphs/16-minimum-spanning-trees.md) | Union-find and spanning trees | 10, 12-14 | Prove safe edges |
| [17](01_algorithms/09_greedy/17-greedy-and-intervals.md) | Greedy proofs, intervals, sweeps | 10, 13-16 | Give an exchange proof or counterexample |
| [18](01_algorithms/10_dynamic-programming/18-dynamic-programming.md) | Dynamic programming foundations | 11, 14, 17 | Define sufficient states and transitions |
| [19](01_algorithms/10_dynamic-programming/19-dynamic-programming-patterns.md) | Sequence, interval, tree, subset DP | 12, 18 | Reconstruct answers and justify update order |
| [20A](02_data-structures/09_tries/20-tries.md) / [20B](01_algorithms/11_strings/20-string-matching.md) | Tries, KMP, Z, rolling hashes | 04-05, 12 | Match without repeated work |

### Advanced route

These topics broaden judgment. Their inclusion is an educational choice, not a claim about Google question frequencies. Prioritize independent mastery of the main route.

| Unit | Topic | Prerequisites | Demonstrate |
|---|---|---|---|
| [21](02_data-structures/10_range-queries/21-range-query-data-structures.md) | Fenwick trees, segment trees, sparse tables | 04, 09, 12 | Choose structures from algebra and update model |
| [22](01_algorithms/12_mathematics/22-bits-number-theory-and-randomness.md) | Bits, number theory, probability | 01-03, 11 | Handle representation and prove sampling invariants |
| [23](01_algorithms/08_graphs/23-advanced-graphs-and-flow.md) | SCCs, bridges, LCA, matching, flow | 12, 14-16 | Reduce problems and use residual edges |
| [24](01_algorithms/13_advanced/24-complexity-and-advanced-design.md) | Hardness, approximation, geometry, external memory | 01-23 | Recognize limits and extensions |
| [25](01_algorithms/14_problem-solving/25-solving-testing-and-communication.md) | Testing, synthesis, English communication | Main route | Solve, explain, test, and adapt under time constraints |

## Sources and review

Each theory chapter maps sections to named sources and distinguishes standard algorithms from repository-written explanations, diagrams and code. [SOURCES.md](SOURCES.md) records references, attribution policy, review corrections and limits.

This is a broad study course with advanced extensions, not an official Google syllabus or an exhaustive algorithms textbook. Check the specific role and recruiter instructions for current interview requirements.

---

<!-- study-navigation -->
[← Previous: Overview](README.md) · [Index](README.md) · [Next: Study guide →](CURRICULUM.md)
<!-- /study-navigation -->
