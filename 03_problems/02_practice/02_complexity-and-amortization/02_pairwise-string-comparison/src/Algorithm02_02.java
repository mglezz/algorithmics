
public class Algorithm02_02 {

    public long countEqualPairs(String[] words) {

        int equalWords = 0;
        int equalChars = 0;
        boolean equal = true;

        for (int i = 0; i < words.length - 1; i++) {

            String actualWord = words[i];
            String nextWord = words[i + 1];

            char[] actualWordChar = actualWord.toCharArray();
            char[] nextWordChar = nextWord.toCharArray();

            for (int j = 0; j < actualWordChar.length; j++) {

                if (actualWordChar[j] == nextWordChar[j]) {

                    equalChars++;

                } else {

                    equal = false;

                }
            }

            if (equal == true) {
                equalWords++;
            }

        }

        System.out.print("Equal strings in the array { " );
        for (int i = 0; i < words.length; i++) {
            System.out.print("(" + words[i] + ") ");
        }
        System.out.println("} = " + equalWords);
        return equalWords;
    }

}
