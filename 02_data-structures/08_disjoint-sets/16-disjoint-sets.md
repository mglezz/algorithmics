# 16A - Disjoint Sets

<!-- study-navigation -->
[← Previous: Unit 15](../../01_algorithms/08_graphs/15-shortest-paths.md) · [Index](../../README.md#study-index) · [Next: Unit 16B →](../../01_algorithms/08_graphs/16-minimum-spanning-trees.md)
<!-- /study-navigation -->

[Curriculum](../../CURRICULUM.md) | [Quick reference](../../04_notes/graphs.md) | [Companion chapter](../../01_algorithms/08_graphs/16-minimum-spanning-trees.md)

> **Core idea:** DSU maintains a partition under merges; it does not retain graph paths or support arbitrary deletions.

## On this page

- [Connectivity under merging](#connectivity-under-merging)
- [Worked visual](#worked-visual)
- [Practice](#practice)
- [Attribution and references](#attribution-and-references)

## Connectivity under merging

A disjoint-set union structure (DSU, or union-find) maintains a partition of elements into components. `find(x)` returns a representative; `union(a,b)` merges the two components if distinct. Representatives are implementation details, not inherently the smallest labels or original vertices.

Represent each component as a parent-pointer tree. A root points to itself. Union by size attaches the smaller root beneath the larger root. Without compression, a node's depth can increase only when its component at least doubles, so depth is `O(log n)`. Path compression or path halving shortens find paths; combined with size/rank balancing, a sequence of operations has inverse-Ackermann amortized cost per operation, conventionally `O(alpha(n))`. This is extremely slow-growing, but is not a literal worst-case constant guarantee for one call.

### Reference implementation

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

### Cost and operation contract

The constructor initializes `n` singleton components in `O(n)` time and space. Operations require indices in `[0,n)`. Size values are meaningful only at roots. A failed union changes no component membership, although finds may compress paths.

### What DSU does not retain

DSU answers connectivity, not a path between vertices. Ordinary DSU also does not handle arbitrary edge deletion: a merged component might split. Offline reversal, rollback structures, or dynamic-connectivity algorithms solve different versions of that problem.

## Worked visual

| Operation | Partition | Result |
|---|---|---|
| Initialize 4 elements | {0}, {1}, {2}, {3} | 4 components |
| union(0,1) | {0,1}, {2}, {3} | true |
| union(2,3) | {0,1}, {2,3} | true |
| union(1,3) | {0,1,2,3} | true |
| union(0,2) | {0,1,2,3} | false |

## Practice

Attempt the [unit 16 exercise set](../../03_problems/02_practice/16_disjoint-sets-and-spanning-trees/README.md). Exercises and hints live in `03_problems/`; this chapter contains the theory.

## Attribution and references

**Provenance:** This chapter is a synthesis of the sources mapped below. Standard definitions, algorithms and proof techniques belong to those established references; the explanatory wording, traces, diagrams and Java examples were written for this repository. No source passage is quoted verbatim.

| Section / claim | Source used | How it is used |
|---|---|---|
| Disjoint-set forest and amortized analysis | [Jeff Erickson, supplementary notes: Disjoint Sets](https://jeffe.cs.illinois.edu/teaching/algorithms/notes/11-unionfind.pdf) | Union by size/rank and path compression; restated with a path-halving example. |

See [SOURCES.md](../../SOURCES.md) for editions, review scope, and the distinction between consulted material and further reading.

---

<!-- study-navigation -->
[← Previous: Unit 15](../../01_algorithms/08_graphs/15-shortest-paths.md) · [Index](../../README.md#study-index) · [Next: Unit 16B →](../../01_algorithms/08_graphs/16-minimum-spanning-trees.md)
<!-- /study-navigation -->
