
public class Algorithm02_02 {

    public long countEqualPairs(String[] words) {

        long equalPairs = 0;
        long numberComparations = 0;

        for (int i = 0; i < words.length - 1; i++) {

            String actualWord = words[i];

            for (int j = i + 1; j < words.length; j++) {

                boolean equal = true;

                String nextWord = words[j];

                System.out.println("Actual comparison ... " + actualWord + " & " + nextWord);

                if (actualWord.length() == nextWord.length()) {
                    for (int k = 0; k < actualWord.length(); k++) {
                        numberComparations++;
                        if (actualWord.charAt(k) != nextWord.charAt(k)) {
                            equal = false;
                            break;
                        }
                    }
                } else {
                    equal = false;
                }

                if (equal) {
                    equalPairs++;
                    System.out.println(actualWord + " = " + nextWord + " (" + equalPairs + ")");
                } else {
                    System.out.println(actualWord + " =/= " + nextWord);
                }

            }
        }
        System.out.println("");

        System.out.print("Equal strings in the array { ");
        for (int i = 0; i < words.length; i++) {
            System.out.print("(" + words[i] + ") ");
        }
        System.out.println("} = " + equalPairs);
        System.out.println("Number of characters compared = " + numberComparations);
        System.out.println("");

        return equalPairs;
    }

}
