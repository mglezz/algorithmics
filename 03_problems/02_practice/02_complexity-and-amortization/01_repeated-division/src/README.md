# 02.01 - Repeated Division - Solution

[Exercise](../README.md)

The method counts how many times a positive integer must be divided by three to reach zero. Java integer division discards the decimal part. For example, `200 → 66 → 22 → 7 → 2 → 0` takes five divisions.

The counter increases once per division. Each positive value becomes smaller, so the loop eventually reaches zero and the counter gives the correct answer.

The exact count is `floor(log₃(n)) + 1`, where `floor` means rounding down. The logarithm tells us how many times we can divide by three before reaching a value below three. One final division makes that value zero. For inputs `1, 2, 3, 8, 9`, the counts are `1, 1, 2, 2, 3`.

Time is Θ(log n): multiplying the input by three adds just one iteration. Extra space is O(1), because the method only keeps a few variables.

The code only runs the loop for positive inputs. For `null`, zero, or negative inputs, it prints a message and returns `0`.
