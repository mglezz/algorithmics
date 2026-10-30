# 01.03 - Zero-Indegree Counterexample - Solution

[Exercise](../README.md)

The statement is false. Consider three vertices: `A`, `B`, and `C`. Leave `A` isolated and add the edges `B → C` and `C → B`.

No edge enters `A`, so its indegree is zero. However, `B → C → B` is a cycle. This shows that a graph can have both a vertex with no incoming edges and a cycle.
