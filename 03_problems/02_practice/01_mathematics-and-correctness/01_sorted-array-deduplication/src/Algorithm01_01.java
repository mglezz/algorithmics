public class Algorithm01_01 {

    public int removeDuplicated(int[] array) {
        if (array.length == 0) {
            return 0;
        }

        int usefulLength = 1;

        for (int i = 1; i < array.length; i++) {
            if (array[i] != array[usefulLength - 1]) {
                array[usefulLength] = array[i];
                usefulLength++;
            }
        }

        System.out.println("The final array without repetitions is...");
        System.out.print("{ ");
        for (int i = 0; i < usefulLength; i++) {
            System.out.print("[" + array[i] + "] ");
        }
        System.out.println(" }");

        return usefulLength;
    }
}
