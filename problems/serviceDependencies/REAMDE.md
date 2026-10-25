### Coding problem: Service Startup Dependencies

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

