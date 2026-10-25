# Algorithms and Data Structures Curriculum

[Algorithms](algorithms/README.md) | [Data structures](data-structures/README.md) | [Quick notes](notes/README.md) | [Practice](problems/practice/README.md)

## How to study

Read, trace by hand, explain the invariant or recurrence, implement from memory, test against a small brute-force solution, and solve a changed version. Say the explanation aloud in English. Return after a few days without looking at the previous code.

The units are learning material, not evidence that you have mastered them. Use [the progress log](PROGRESS.md) for that distinction. See the [source register](SOURCES.md) for the verification policy and further reading.

## Main route

| Unit | Topic | Prerequisites | Demonstrate |
|---|---|---|---|
| [01](algorithms/foundations/01-mathematics-and-correctness.md) | Discrete mathematics and correctness | Basic programming | State a contract and prove an invariant |
| [02](algorithms/foundations/02-complexity-and-amortization.md) | Complexity, recurrences, amortization | 01 | Derive bounds with explicit assumptions |
| [03](algorithms/foundations/03-java-for-interviews.md) | Java and the standard library | 02 | Choose collections and avoid numerical traps |
| [04A](data-structures/arrays-and-strings/04-arrays-and-strings.md) / [04B](algorithms/range-queries/04-prefix-sums-and-difference-arrays.md) | Arrays, strings, prefix and difference arrays | 01-03 | Turn range queries into prefix operations |
| [05](data-structures/hash-tables/05-hash-tables.md) | Hashing and dictionaries | 02-04 | Design keys and qualify expected costs |
| [06](algorithms/two-pointers/06-two-pointers-and-sliding-windows.md) | Two pointers and windows | 04-05 | Justify every discarded candidate |
| [07](data-structures/linked-lists/07-linked-lists.md) | Linked lists | 01-03 | Rewire references safely |
| [08A](data-structures/stacks-and-queues/08-stacks-and-queues.md) / [08B](algorithms/monotonic-structures/08-monotonic-stacks-and-deques.md) | Stacks, queues, monotonic structures | 04, 07 | Prove amortized linear scans |
| [09](algorithms/searching/09-binary-search.md) | Binary and parametric search | 01-04 | Search a monotone predicate safely |
| [10](algorithms/sorting/10-sorting-and-selection.md) | Sorting, selection, divide and conquer | 02, 04, 09 | Explain stability and lower bounds |
| [11](algorithms/backtracking/11-recursion-and-backtracking.md) | Recursion, exhaustive search, pruning | 01-02, 04 | Enumerate without omissions or duplicates |
| [12](data-structures/trees/12-trees-and-ordered-maps.md) | Trees, BSTs, balance, augmentation | 07, 09, 11 | Derive tree recurrences |
| [13](data-structures/heaps/13-heaps-and-priority-queues.md) | Heaps and priority queues | 04, 12 | Maintain top-k values and merge streams |
| [14A](data-structures/graphs/14-graph-representations.md) / [14B](algorithms/graphs/14-traversal-and-topological-order.md) | Graph modeling, BFS, DFS, DAGs | 08, 11 | Model dependencies and detect cycles |
| [15](algorithms/graphs/15-shortest-paths.md) | Weighted shortest paths | 13-14 | Choose the right relaxation order |
| [16A](data-structures/disjoint-sets/16-disjoint-sets.md) / [16B](algorithms/graphs/16-minimum-spanning-trees.md) | Union-find and spanning trees | 10, 12-14 | Prove safe edges |
| [17](algorithms/greedy/17-greedy-and-intervals.md) | Greedy proofs, intervals, sweeps | 10, 13-16 | Give an exchange proof or counterexample |
| [18](algorithms/dynamic-programming/18-dynamic-programming.md) | Dynamic programming foundations | 11, 14, 17 | Define sufficient states and transitions |
| [19](algorithms/dynamic-programming/19-dynamic-programming-patterns.md) | Sequence, interval, tree, subset DP | 12, 18 | Reconstruct answers and justify update order |
| [20A](data-structures/tries/20-tries.md) / [20B](algorithms/strings/20-string-matching.md) | Tries, KMP, Z, rolling hashes | 04-05, 12 | Match without repeated work |

## Advanced route

These topics broaden judgment. Their inclusion is an educational choice, not a claim about Google question frequencies. Prioritize independent mastery of the main route.

| Unit | Topic | Prerequisites | Demonstrate |
|---|---|---|---|
| [21](data-structures/range-queries/21-range-query-data-structures.md) | Fenwick trees, segment trees, sparse tables | 04, 09, 12 | Choose structures from algebra and update model |
| [22](algorithms/mathematics/22-bits-number-theory-and-randomness.md) | Bits, number theory, probability | 01-03, 11 | Handle representation and prove sampling invariants |
| [23](algorithms/graphs/23-advanced-graphs-and-flow.md) | SCCs, bridges, LCA, matching, flow | 12, 14-16 | Reduce problems and use residual edges |
| [24](algorithms/advanced/24-complexity-and-advanced-design.md) | Hardness, approximation, geometry, external memory | 01-23 | Recognize limits and extensions |
| [25](algorithms/problem-solving/25-solving-testing-and-communication.md) | Testing, synthesis, English communication | Main route | Solve, explain, test, and adapt under time constraints |

## Learning cycle

Learn one unit; implement its central operation; solve two small exercises and one unfamiliar variation; review an older topic; then attempt a mixed practice interview. Revisit prerequisites when you can reproduce code but cannot justify it.

Suggested review intervals are next day, one week, and roughly one month. Adjust to recall and workload. These are planning defaults, not guarantees about time to mastery.

## Conventions

- Arrays and vertices are zero-indexed; ranges are half-open `[left, right)` unless stated otherwise.
- `n` denotes item count, `V` vertices, `E` edges, and `h` tree height unless redefined.
- Auxiliary space excludes input and output unless stated; recursion stacks count.
- Bounds assume fixed-width arithmetic and constant-time key operations unless qualified.
- `text` blocks are pseudocode. `java` blocks are complete static members for a class with `import java.util.*;`.
- Exercise sets and hints live in `problems/practice/`. Notes are short lookup sheets; full explanations live in `algorithms/` and `data-structures/`.
