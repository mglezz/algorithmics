
public class Main02_02 {

    public static void main(String[] args) {

        String[] words1 = {"cat", "dog", "cat", "cat"};
        String[] words2 = {"", ""};
        String[] words3 = {};
        String[] words4 = {"cat", "cat", "cat", "cat", "cat", "cat", "dog"};

        Algorithm02_02 algorithm = new Algorithm02_02();

        check(algorithm, words1, 3);
        check(algorithm, words2, 1);
        check(algorithm, words3, 0);
        check(algorithm, words4, 15);
        check(algorithm, new String[]{"cat", "cat", "cat", "cat"}, 6);
        check(algorithm, new String[]{"cat", "ca", "", "cat"}, 1);
        check(algorithm, new String[]{"cat"}, 0);

        String prefix = "a".repeat(100);
        check(algorithm, new String[]{prefix + "b", prefix + "c", prefix + "b"}, 1);

        System.out.println("All checks passed.");

    }

    private static void check(Algorithm02_02 algorithm, String[] words, long expected) {
        long actual = algorithm.countEqualPairs(words);
        if (actual != expected) {
            throw new AssertionError("Expected " + expected + " pairs, but got " + actual);
        }
    }

}
