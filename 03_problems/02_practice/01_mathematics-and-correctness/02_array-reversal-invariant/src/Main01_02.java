public class Main01_02 {
    
    public static void main(String[] args) {
        
        int[] array1 = {0, 1, 2, 3, 4, 5, 6};

        int[] array2 = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20};

        Algorithm01_02 algorithm = new Algorithm01_02();

        algorithm.reverse(array1);
        algorithm.reverse(array2);
    }
}
