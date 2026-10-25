# Sources, Verification, and Further Study

[Curriculum](CURRICULUM.md)

Reference review date: **2026-10-25**. This is the review date, not the publication date of the linked material.

## Editorial policy

The theory is a source-based synthesis: standard definitions, algorithms, and proof techniques are attributed to their authors in each chapter's section-to-source table. Wording, worked traces, diagrams, exercise prompts, and Java examples were written for this repository. There are no verbatim excerpts or copied textbook diagrams in these notes. This is a broad course with advanced starting points, not an exhaustive encyclopedia or an official employer curriculum.

Use primary teaching sources and official language documentation before community summaries. Distinguish mathematical guarantees, implementation-dependent behavior, and personal study recommendations. Each theory chapter now identifies which source supports which section, rather than presenting a bibliography as blanket attribution. Every complexity claim needs its model: graph representation, key cost, alphabet, numeric width, randomness, and whether output is counted. A link to a textbook is not a substitute for those assumptions.

The review consulted course indexes, selected lecture PDFs, relevant textbook sections, and Java API contracts. It did not audit every page of every book. The executable checks cover the nine Java example blocks and the existing clean service-dependency implementation; pseudocode, all suggested exercises, and every advanced algorithm are not claimed to have executable test coverage.

## Core references and reading map

| Reference | Use in this course | Reading pointers |
|---|---|---|
| [MIT 6.006, Spring 2020](https://ocw.mit.edu/courses/6-006-introduction-to-algorithms-spring-2020/pages/lecture-notes/) | Foundations, structures, graphs, DP | 1: model/correctness; 2: sequences; 3-5: sorting/hashing; 6-8: trees/heaps; 9-14: graphs/paths; 15-18: DP; 19: complexity |
| [Open Data Structures, Java edition, Pat Morin](https://opendatastructures.org/ods-java/Contents.html) | Representation and operation-cost analysis | Chapters 2-3: arrays/lists; 5: hashing; 6-9: search trees; 10: heaps; 11: sorting; 12: graphs; 14: external memory |
| [Algorithms, Jeff Erickson](https://jeffe.cs.illinois.edu/teaching/algorithms/) | Proof-oriented algorithm design | Chapters 1-4: recursion/backtracking/DP/greedy; 5-9: graphs; 10-11: flows; 12: hardness |
| [MIT Mathematics for Computer Science](https://ocw.mit.edu/courses/6-042j-mathematics-for-computer-science-spring-2015/pages/readings/) | Mathematical prerequisites | Proofs, induction, relations, counting, modular arithmetic, probability |
| [Competitive Programmer's Handbook, Antti Laaksonen](https://cses.fi/book/book.pdf) | Additional technique coverage | Range queries, tree queries, bit operations, number theory, geometry, advanced structures |

MIT and Erickson sometimes use different path terminology: one source's “path” may permit repetition while another uses “walk” for that object. Read local definitions. Likewise, sources may use one-based arrays or inclusive intervals; this repository defaults to zero-based half-open intervals. Translate the mathematics, not just the syntax.

The handbook uses C++; Java overflow, shifts, string operations, reference semantics, and collections must be checked separately. Source code from another language is not evidence for a Java library guarantee.

## Specific verification anchors

- **Resizing and operation costs:** [Open Data Structures, array-based lists](https://opendatastructures.org/ods-java/2_Array_Based_Lists.html), checked against Java's documented `ArrayList` and deque contracts. Amortized append does not imply worst-case constant append.
- **Trees and heap construction:** MIT lectures 6-8 and Open Data Structures tree/heap chapters. The linear heap-build argument counts nodes by height, rather than assigning root-height work to every node.
- **Traversal and shortest paths:** MIT lectures 9-14 and [Erickson's shortest-path chapter](https://jeffe.cs.illinois.edu/teaching/algorithms/book/08-sssp.pdf). Distinguish negative edges, reachable negative cycles, and lazy versus indexed heaps.
- **MST and DSU:** [MST chapter](https://jeffe.cs.illinois.edu/teaching/algorithms/book/07-mst.pdf) and [disjoint-set notes](https://jeffe.cs.illinois.edu/teaching/algorithms/notes/11-unionfind.pdf). The notes separate worst-case operation bounds from sequence-level amortization.
- **DP and greedy reasoning:** [DP chapter](https://jeffe.cs.illinois.edu/teaching/algorithms/book/03-dynprog.pdf), [greedy chapter](https://jeffe.cs.illinois.edu/teaching/algorithms/book/04-greedy.pdf), and MIT lectures 15-18. The exercises here use explicit contracts and independently derived recurrences.
- **KMP:** [Cornell CS312 string-matching lecture](https://www.cs.cornell.edu/courses/cs312/2002sp/lectures/lec25.htm) and [Erickson's string notes](https://jeffe.cs.illinois.edu/teaching/algorithms/notes/07-strings.pdf). Prefix-table indexing conventions differ; the Java implementation is tested against exact search and a brute-force border oracle.
- **Range structures:** the handbook's range-query and advanced-segment-tree sections, plus [HKOI's Data Structures III teaching slides](https://assets.hkoi.org/training2022/ds-iii.pdf). Check cancellation for prefix sums, binary blocks for Fenwick trees, and idempotence before overlapping sparse-table ranges.
- **Reservoir sampling:** [Stanford CS168 sampling notes](https://theory.stanford.edu/~tim/s17/l/l13.pdf) and [NIST's reservoir-sampling entry](https://xlinux.nist.gov/dads/HTML/reservoirSampling.html). A uniform subset guarantee is stronger than merely having equal marginal inclusion probabilities.
- **Flow and hardness:** [flow chapter](https://jeffe.cs.illinois.edu/teaching/algorithms/book/10-maxflow.pdf) and [NP-hardness chapter](https://jeffe.cs.illinois.edu/teaching/algorithms/book/12-nphard.pdf). Pay attention to residual reverse edges, capacity assumptions, and reduction direction.

## Java reference version

The examples target Java 17-compatible syntax. The following **Java 21** documentation was consulted as a fixed reference, not as a claim that Java 21 is the newest release or the interview runtime:

- [HashMap](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/HashMap.html): hashing assumptions, iteration order, capacity.
- [ArrayList](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/ArrayList.html): indexed access, amortized append, growth policy.
- [ArrayDeque](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/ArrayDeque.html): endpoint operations and null restrictions.
- [PriorityQueue](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/PriorityQueue.html): heap operations, arbitrary removal, unsorted iteration.
- [TreeMap](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/TreeMap.html): logarithmic operations and comparison-based key equivalence.
- [String](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/String.html): immutability and UTF-16 indexing.
- [Java Language Specification, chapter 15](https://docs.oracle.com/javase/specs/jls/se21/html/jls-15.html): promotions, arithmetic, evaluation, and shifts.

## Specialist continuation

- [MIT 6.851 lecture catalogue](https://courses.csail.mit.edu/6.851/spring12/lectures/): persistence, dynamic structures, geometric structures, and memory hierarchy.
- [CMU String Algorithms](https://www.cs.cmu.edu/~02414/schedule.html): exact/inexact matching, suffix structures, and compressed indexing.
- [Stanford CS168](https://web.stanford.edu/class/cs168/): sampling, hashing, estimation, and modern algorithmic tools.
- [Erickson's supplementary notes](https://jeffe.cs.illinois.edu/teaching/algorithms/): recurrence solving, amortization, approximation, FFT, probability, and fast exponential algorithms.

These are next courses for depth, not prerequisites to beginning internship interview practice.

## Google-specific evidence and limits

The [official 2019 coding-preparation video](https://www.youtube.com/watch?v=6ZZX9iIgFoo) and [March 17, 2022 engineer interview](https://blog.google/company-news/inside-google/life-at-google/google-engineer-shares-her-technical-interview-tips/) support practicing technical communication, coding, algorithms, and testing. They are historical public guidance. They do not establish today's exact rounds, accepted languages, eligibility, or question distribution.

The [current careers preparation URL](https://www.google.com/about/careers/applications/interview-tips) was checked, but its retrieved body largely exposed navigation. No detailed process claim was inferred from that incomplete retrieval. Third-party reposts of purported confidential recruiting documents were not used as authority.

For current requirements, use the specific public job description and direct recruiter instructions. No application was made and no external message was sent as part of preparing these notes.

## Reproduce the local checks

From the repository root in PowerShell, with a JDK supporting `--release 17` available:

```powershell
powershell -NoProfile -ExecutionPolicy Bypass -File .\tests\verify-theory.ps1
```

The script verifies local documentation targets and balanced code fences, extracts every `java` block into a temporary class, compiles with warnings treated as errors, and runs deterministic property/differential checks. Generated classes are stored in a unique operating-system temporary directory and removed afterward. The execution-policy option is scoped to this invocation and does not change the saved machine policy; use `./tests/verify-theory.ps1` directly if scripts are already permitted. External URLs require a separate online review; the local script does not claim to check them.

When correcting a unit, record the precise failed claim, counterexample or authoritative source, changed assumption, and any relevant new regression test. Keep a correction in its own descriptive commit rather than silently changing the learning history.
