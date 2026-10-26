public class Main01_01 {

    public static void main(String[] args) {
        
        int[] array1 = {0, 1, 1, 2, 3, 4, 4};

        int[] array2 = {0, 2, 2, 4, 4, 6, 6};

        int[] array3 = {3, 3, 3, 5, 5, 7, 8, 9, 9, 10 , 10};

        Algorithm01_01 algorithm = new Algorithm01_01();

        algorithm.removeDuplicated(array1);
        algorithm.removeDuplicated(array2);
        algorithm.removeDuplicated(array3);

    }


}
