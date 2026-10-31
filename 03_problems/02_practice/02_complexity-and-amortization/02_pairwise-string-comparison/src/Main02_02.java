
public class Main02_02 {

    public static void main(String[] args) {

        String[] words1 = {"cat", "dog", "cat", "cat"};
        String[] words2 = {"", ""};
        String[] words3 = {};
        String[] words4 = {"cat", "cat", "cat", "cat", "cat", "cat", "dog"};

        Algorithm02_02 algorithm = new Algorithm02_02();

        algorithm.countEqualPairs(words1);
        algorithm.countEqualPairs(words2);
        algorithm.countEqualPairs(words3);
        algorithm.countEqualPairs(words4);

    }

}
