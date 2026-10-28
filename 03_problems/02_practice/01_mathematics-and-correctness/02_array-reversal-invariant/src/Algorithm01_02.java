public class Algorithm01_02 {
    
    public void reverse(int[] array){

        int[] reversedArray = new int[array.length];
        int actualPosition = 0;
        int reversedPosition = array.length - 1;

        for (int i = 0; i < array.length; i++) {
            reversedArray[i] = array[reversedPosition - actualPosition];

            actualPosition++;
        }

        System.out.println("The original array is...");
        System.out.print("{ ");
        for (int i = 0; i < array.length; i++) {
            System.out.print("[" + array[i] + "] ");
        }
        System.out.println(" }");
        System.out.println("The reversed array is...");
        System.out.print("{ ");
        for (int i = 0; i < reversedArray.length; i++) {
            System.out.print("[" + reversedArray[i] + "] ");
        }
        System.out.println(" }");
        System.out.println("");
        
    }

}
