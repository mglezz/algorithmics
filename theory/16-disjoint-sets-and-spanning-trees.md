# 16 - Disjoint Sets and Minimum Spanning Trees

[Curriculum](README.md) | Prerequisites: 10, 12-14

## Connectivity under merging

A disjoint-set union structure (DSU, or union-find) maintains a partition of elements into components. `find(x)` returns a representative; `union(a,b)` merges the two components if distinct. Representatives are implementation details, not inherently the smallest labels or original vertices.

Represent each component as a parent-pointer tree. A root points to itself. Union by size attaches the smaller root beneath the larger root. Without compression, a node's depth can increase only when its component at least doubles, so depth is `O(log n)`. Path compression or path halving shortens find paths; combined with size/rank balancing, a sequence of operations has inverse-Ackermann amortized cost per operation, conventionally `O(alpha(n))`. This is extremely slow-growing, but is not a literal worst-case constant guarantee for one call.

```java
static final class DisjointSet {
    private final int[] parent;
    private final int[] size;

    DisjointSet(int n) {
        if (n < 0) throw new IllegalArgumentException("Size must be nonnegative");
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    int find(int x) {
        while (x != parent[x]) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA == rootB) return false;
        if (size[rootA] < size[rootB]) {
            int temporary = rootA;
            rootA = rootB;
            rootB = temporary;
        }
        parent[rootB] = rootA;
        size[rootA] += size[rootB];
        return true;
    }
}
```

The constructor initializes `n` singleton components in `O(n)` time and space. Operations require indices in `[0,n)`. Size values are meaningful only at roots. A failed union changes no component membership, although finds may compress paths.

DSU answers connectivity, not a path between vertices. Ordinary DSU also does not handle arbitrary edge deletion: a merged component might split. Offline reversal, rollback structures, or dynamic-connectivity algorithms solve different versions of that problem.

## Spanning trees and their objective

For a connected undirected weighted graph, a spanning tree connects every vertex without a cycle; an MST minimizes the **sum of selected edge weights**. A shortest-path tree minimizes source-to-vertex path lengths, which is a different objective. Negative edge weights are allowed for MSTs. Disconnected input yields a minimum spanning forest, not a single spanning tree.

## Cut and cycle arguments

A cut partitions vertices into two nonempty groups. If a cut respects the edges already chosen, a minimum-weight edge crossing that cut can be added while preserving compatibility with some MST. Proof: if an MST omits it, add it to create a cycle; the cycle includes another crossing edge. Replacing that edge cannot increase weight.

On a cycle, a **strictly** heaviest edge belongs to no MST. With ties, a maximum-weight edge can be excluded from some MST, but need not be excluded from every MST. Distinct edge weights guarantee uniqueness; they are sufficient but not necessary.

## Kruskal and Prim

**Kruskal:** sort edges by nondecreasing weight; accept an edge exactly when its endpoints currently belong to different DSU components. Each accepted edge joins components without a cycle. The cut property makes the choice safe. Stop after `V-1` accepted edges for connected nonempty input; otherwise detect disconnection. Time is `O(V+E log(E+1)+E alpha(V))`; sorting generally dominates. Retain chosen edges if a witness is required.

**Prim:** start from one vertex and repeatedly choose the cheapest edge crossing from the current tree to an outside vertex. A lazy edge heap may contain obsolete internal edges; discard them on removal. This variant takes `O(V+E log(E+1))` time with up to `O(E)` heap entries. An indexed eager version stores the best connecting edge per outside vertex and takes `O((V+E) log(V+1))`. An adjacency-matrix implementation takes `O(V^2)`, useful for dense graphs.

Example: on a triangle with weights `ab=2`, `bc=3`, `ac=9`, Kruskal accepts the first two edges and rejects the third because it closes a cycle. The minimum total is five, regardless of a chosen source.

## Practice

1. Count connected components while edges are added, decrementing only after a successful union.
2. Detect the first redundant undirected edge, including parallel-edge cases.
3. Implement Kruskal and verify the output connects all vertices, has no cycle, and contains `V-1` edges when connected.
4. Give an MST that is not a shortest-path tree from a specified source.

<details><summary>Hints and checkpoints</summary>

1. Begin with `n` components. Repeated unions must not decrement twice.
2. If endpoints already have the same representative, the edge is redundant for connectivity.
3. Feasibility alone does not prove minimum weight; compare tiny graphs against exhaustive spanning-tree enumeration.
4. Use triangle weights `sa=2`, `ab=2`, `sb=3`: the MST uses total four, but its route from s to b has length four instead of three.

</details>

**Explain aloud:** “The light edge crossing this cut is safe by an exchange argument.” Vocabulary: representative, component, path compression, cut, spanning forest, safe edge.

## Sources

- [Erickson, Disjoint Sets](https://jeffe.cs.illinois.edu/teaching/algorithms/notes/11-unionfind.pdf): balancing, compression, and amortized analysis.
- [Erickson, Minimum Spanning Trees](https://jeffe.cs.illinois.edu/teaching/algorithms/book/07-mst.pdf): cut properties, Kruskal, and Prim.
