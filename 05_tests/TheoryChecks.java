import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import servicedependencies.SimpleAlgorithm;

/** Differential and property checks for examples extracted by verify-theory.ps1. */
public final class TheoryChecks {
    private static final Random RANDOM = new Random(20261025L);
    private static long checks;

    private TheoryChecks() { }

    private static void check(boolean condition, String message) {
        checks++;
        if (!condition) throw new AssertionError(message);
    }

    private static void expectException(Class<? extends RuntimeException> type, Runnable action) {
        try {
            action.run();
        } catch (RuntimeException exception) {
            check(type.isInstance(exception), "Unexpected exception: " + exception);
            return;
        }
        throw new AssertionError("Expected " + type.getSimpleName());
    }

    private static int[] randomArray(int size, int bound) {
        int[] values = new int[size];
        for (int i = 0; i < size; i++) values[i] = RANDOM.nextInt(bound * 2 + 1) - bound;
        return values;
    }

    private static void checkArrays() {
        int[][] boundaries = {{}, {Integer.MIN_VALUE}, {Integer.MAX_VALUE, Integer.MAX_VALUE},
                {Integer.MIN_VALUE, Integer.MAX_VALUE}, {0, 0, 0}};
        for (int[] values : boundaries) checkPrefixesAndBounds(values);
        for (int trial = 0; trial < 500; trial++) {
            int[] values = randomArray(RANDOM.nextInt(25), 10);
            checkPrefixesAndBounds(values);
            for (long target = -15; target <= 15; target++) {
                long expected = 0;
                for (int left = 0; left < values.length; left++) {
                    long sum = 0;
                    for (int right = left; right < values.length; right++) {
                        sum += values[right];
                        if (sum == target) expected++;
                    }
                }
                check(TheoryExamples.countTargetSubarrays(values, target) == expected,
                        "Target-sum count: " + Arrays.toString(values) + " target=" + target);
            }
            int[] nonnegative = Arrays.stream(values).map(Math::abs).toArray();
            long target = RANDOM.nextInt(60) + 1;
            int shortest = Integer.MAX_VALUE;
            for (int left = 0; left < nonnegative.length; left++) {
                long sum = 0;
                for (int right = left; right < nonnegative.length; right++) {
                    sum += nonnegative[right];
                    if (sum >= target) shortest = Math.min(shortest, right - left + 1);
                }
            }
            if (shortest == Integer.MAX_VALUE) shortest = 0;
            check(TheoryExamples.shortestAtLeast(nonnegative, target) == shortest, "Shortest window");
        }
        check(TheoryExamples.countTargetSubarrays(new int[]{0, 0}, 0) == 3, "Prefix multiplicity");
        check(TheoryExamples.countTargetSubarrays(new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE},
                2L * Integer.MAX_VALUE) == 1, "Wide target sum");
        check(TheoryExamples.shortestAtLeast(new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE},
                2L * Integer.MAX_VALUE) == 2, "Wide window sum");
        expectException(IllegalArgumentException.class, () -> TheoryExamples.shortestAtLeast(new int[]{-1}, 1));
        expectException(IllegalArgumentException.class, () -> TheoryExamples.shortestAtLeast(new int[]{1}, 0));
    }

    private static void checkPrefixesAndBounds(int[] input) {
        int[] unchanged = input.clone();
        long[] prefix = TheoryExamples.prefixSums(input);
        check(prefix.length == input.length + 1 && prefix[0] == 0, "Prefix shape");
        for (int left = 0; left <= input.length; left++) {
            long expected = 0;
            for (int right = left; right <= input.length; right++) {
                if (right > left) expected += input[right - 1];
                check(prefix[right] - prefix[left] == expected, "Prefix range");
            }
        }
        check(Arrays.equals(input, unchanged), "Prefix input mutation");
        int[] sorted = input.clone();
        Arrays.sort(sorted);
        for (int target : new int[]{Integer.MIN_VALUE, -11, -5, 0, 4, 11, Integer.MAX_VALUE}) {
            int expected = 0;
            while (expected < sorted.length && sorted[expected] < target) expected++;
            check(TheoryExamples.lowerBound(sorted, target) == expected, "Lower bound");
        }
    }

    private static void checkDynamicProgramming() {
        for (int trial = 0; trial < 400; trial++) {
            int[] values = randomArray(RANDOM.nextInt(15), 15);
            long expected = 0;
            for (int mask = 0; mask < (1 << values.length); mask++) {
                if ((mask & (mask << 1)) != 0) continue;
                long sum = 0;
                for (int i = 0; i < values.length; i++) if ((mask & (1 << i)) != 0) sum += values[i];
                expected = Math.max(expected, sum);
            }
            check(TheoryExamples.maximumNonAdjacentSum(values) == expected, "Nonadjacent DP");
        }
        check(TheoryExamples.maximumNonAdjacentSum(new int[]{Integer.MAX_VALUE, 0, Integer.MAX_VALUE})
                == 2L * Integer.MAX_VALUE, "Wide DP sum");
    }

    private static void checkLists() {
        for (int size = 0; size <= 100; size++) {
            TheoryExamples.ListNode[] nodes = new TheoryExamples.ListNode[size];
            for (int i = 0; i < size; i++) nodes[i] = new TheoryExamples.ListNode(i % 3);
            for (int i = 1; i < size; i++) nodes[i - 1].next = nodes[i];
            TheoryExamples.ListNode reversed = TheoryExamples.reverse(size == 0 ? null : nodes[0]);
            TheoryExamples.ListNode cursor = reversed;
            for (int i = size - 1; i >= 0; i--) {
                check(cursor == nodes[i], "Reversal must preserve node identity and reverse order");
                cursor = cursor.next;
            }
            check(cursor == null, "Reversal termination");
            cursor = TheoryExamples.reverse(reversed);
            for (int i = 0; i < size; i++) {
                check(cursor == nodes[i], "Double reversal identity");
                cursor = cursor.next;
            }
            check(cursor == null, "Double reversal termination");
        }
    }

    private static String randomString(int maximumLength) {
        char[] alphabet = {'a', 'b', 'c', '\u0000', '\ud83d', '\ude00'};
        StringBuilder result = new StringBuilder();
        int length = RANDOM.nextInt(maximumLength + 1);
        for (int i = 0; i < length; i++) result.append(alphabet[RANDOM.nextInt(alphabet.length)]);
        return result.toString();
    }

    private static void checkStrings() {
        String[][] cases = {{"", ""}, {"", "a"}, {"aaaaa", "aaa"},
                {"abababaca", "ababaca"}, {"hello", "xyz"}, {"abc", "abc"}};
        for (String[] pair : cases) checkStringPair(pair[0], pair[1]);
        for (int trial = 0; trial < 2000; trial++) checkStringPair(randomString(40), randomString(12));
    }

    private static void checkStringPair(String text, String pattern) {
        check(TheoryExamples.firstMatch(text, pattern) == text.indexOf(pattern), "KMP first match");
        int[] pi = TheoryExamples.prefixFunction(pattern);
        for (int end = 0; end < pattern.length(); end++) {
            int expected = 0;
            for (int length = 1; length <= end; length++) {
                if (pattern.substring(0, length).equals(pattern.substring(end + 1 - length, end + 1))) {
                    expected = length;
                }
            }
            check(pi[end] == expected, "Prefix-function border");
        }
    }

    private static void checkDisjointSets() {
        for (int size = 1; size <= 30; size++) {
            TheoryExamples.DisjointSet actual = new TheoryExamples.DisjointSet(size);
            int[] labels = new int[size];
            for (int i = 0; i < size; i++) labels[i] = i;
            for (int operation = 0; operation < 200; operation++) {
                int a = RANDOM.nextInt(size);
                int b = RANDOM.nextInt(size);
                boolean different = labels[a] != labels[b];
                check(actual.union(a, b) == different, "DSU union result");
                int oldLabel = labels[b];
                int newLabel = labels[a];
                for (int i = 0; i < size; i++) if (labels[i] == oldLabel) labels[i] = newLabel;
                for (int i = 0; i < size; i++) {
                    check((actual.find(a) == actual.find(i)) == (labels[a] == labels[i]), "DSU partition");
                }
            }
        }
        expectException(IllegalArgumentException.class, () -> new TheoryExamples.DisjointSet(-1));
    }

    private static void checkFenwick() {
        for (int size = 0; size <= 50; size++) {
            TheoryExamples.Fenwick actual = new TheoryExamples.Fenwick(size);
            long[] values = new long[size];
            for (int operation = 0; operation < 300; operation++) {
                if (size > 0 && RANDOM.nextBoolean()) {
                    int index = RANDOM.nextInt(size);
                    long delta = RANDOM.nextInt(2001) - 1000;
                    actual.add(index, delta);
                    values[index] += delta;
                }
                int left = RANDOM.nextInt(size + 1);
                int right = left + RANDOM.nextInt(size - left + 1);
                long expected = 0;
                for (int i = left; i < right; i++) expected += values[i];
                check(actual.rangeSum(left, right) == expected, "Fenwick range");
            }
            final int count = size;
            expectException(IndexOutOfBoundsException.class, () -> actual.add(count, 1));
            expectException(IndexOutOfBoundsException.class, () -> actual.prefixSum(-1));
        }
        TheoryExamples.Fenwick tree = new TheoryExamples.Fenwick(2);
        tree.add(0, 3_000_000_000L);
        tree.add(1, -1);
        check(tree.rangeSum(0, 2) == 2_999_999_999L, "Wide Fenwick sum");
        expectException(IllegalArgumentException.class, () -> tree.rangeSum(2, 1));
        expectException(IllegalArgumentException.class, () -> new TheoryExamples.Fenwick(-1));
    }

    private static void checkTopologicalOrders() {
        checkDependencyGraph(0, new int[0][]);
        for (int mask = 0; mask < (1 << 9); mask++) {
            List<int[]> edges = new ArrayList<>();
            for (int from = 0; from < 3; from++) {
                for (int to = 0; to < 3; to++) {
                    if ((mask & (1 << (from * 3 + to))) != 0) edges.add(new int[]{to, from});
                }
            }
            checkDependencyGraph(3, edges.toArray(new int[0][]));
        }
        for (int trial = 0; trial < 300; trial++) {
            int size = RANDOM.nextInt(9);
            List<int[]> edges = new ArrayList<>();
            for (int from = 0; from < size; from++) {
                for (int to = 0; to < size; to++) {
                    if (RANDOM.nextInt(8) == 0) {
                        edges.add(new int[]{to, from});
                        if (RANDOM.nextBoolean()) edges.add(new int[]{to, from});
                    }
                }
            }
            checkDependencyGraph(size, edges.toArray(new int[0][]));
        }
        checkDependencyGraph(4, new int[][]{{1, 0}, {1, 0}, {2, 0}, {3, 1}, {3, 2}});
        checkDependencyGraph(4, new int[][]{{2, 1}, {1, 2}});
    }

    private static void checkDependencyGraph(int size, int[][] dependencies) {
        // Transitive closure provides a structurally independent cycle oracle.
        boolean[][] reachable = new boolean[size][size];
        for (int[] dependency : dependencies) reachable[dependency[1]][dependency[0]] = true;
        for (int k = 0; k < size; k++) {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) reachable[i][j] |= reachable[i][k] && reachable[k][j];
            }
        }
        boolean cyclic = false;
        for (int i = 0; i < size; i++) cyclic |= reachable[i][i];
        int[] order = new SimpleAlgorithm().findStartupOrder(size, dependencies);
        if (cyclic) {
            check(order.length == 0, "Cyclic graph must have no startup order");
            return;
        }
        check(order.length == size, "DAG order must include every service");
        int[] position = new int[size];
        Arrays.fill(position, -1);
        for (int i = 0; i < order.length; i++) {
            int vertex = order[i];
            check(vertex >= 0 && vertex < size, "Vertex range");
            check(position[vertex] == -1, "Duplicate vertex");
            position[vertex] = i;
        }
        for (int[] dependency : dependencies) {
            check(position[dependency[1]] < position[dependency[0]], "Dependency order");
        }
    }

    public static void main(String[] args) {
        checkArrays();
        checkDynamicProgramming();
        checkLists();
        checkStrings();
        checkDisjointSets();
        checkFenwick();
        checkTopologicalOrders();
        System.out.println("Passed " + checks + " deterministic property and differential checks.");
    }
}
