# Coding problem: Service Startup Dependencies

<!-- study-navigation -->
[← Previous: Problems](../README.md) · [Index](../README.md) · [Next: Practice sets →](../02_practice/README.md)
<!-- /study-navigation -->

"Imagine we're working with a distributed system consisting of `n` services, numbered from `0` to `n - 1`. Some services depend on others. A service can only start after all the services it depends on have successfully started. You're given the number of services and a list of dependencies. Your task is to write a function that returns a valid order in which all services can be started. If it's impossible to start all services because of conflicting dependencies, return an empty array."

Example 1
``` java
n = 4

dependencies = {
    {1, 0},
    {2, 0},
    {3, 1},
    {3, 2}
};
```

Each pair `{a, b}` means that service `a` depends on service `b`.

A valid result could be:
```java
[0, 1, 2, 3]
```

Another valid result is:
```java
[0, 2, 1, 3]
```

Example 2
```java
n = 2

dependencies = {
    {0, 1},
    {1, 0}
};
```

Expected result:
```java
[]
```



Here's the function signature:"
```java
public int[] findStartupOrder(int n, int[][] dependencies) {

}
```

"Your solution must work for any valid number of services, including services with no dependencies, and must return an empty array if a circular dependency prevents all services from starting. You can use standard Java collections such as `HashMap`, `ArrayList`, `Queue`, or anything else you consider appropriate.

<details><summary>Hints and Java starting point</summary>

### Java starting point

For each [service, prerequisite] pair, direct the edge from the prerequisite to the service. The helper below only builds the representation; implement the ready queue, processing loop, and cycle check yourself. Assume valid vertex IDs and keep duplicate edges consistently in both structures.

<!-- java-hint -->
```java
static List<List<Integer>> buildGraph(int n, int[][] dependencies, int[] indegree) {
    // indegree must be a fresh zero-filled array of length n.
    List<List<Integer>> graph = new ArrayList<>();
    for (int vertex = 0; vertex < n; vertex++) graph.add(new ArrayList<>());
    for (int[] pair : dependencies) {
        int service = pair[0];
        int prerequisite = pair[1];
        graph.get(prerequisite).add(service);
        indegree[service]++;
    }
    return graph;
}
```
<!-- /java-hint -->

**Complete the reasoning:** Import java.util.* and place the helper inside your class. Start with every zero-indegree vertex, including isolated services. A partial order is not a valid answer when fewer than n vertices are processed.

</details>

---

<!-- study-navigation -->
[← Previous: Problems](../README.md) · [Index](../README.md) · [Next: Practice sets →](../02_practice/README.md)
<!-- /study-navigation -->
