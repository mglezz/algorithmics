
public class Algorithm02_01 {

    public Integer divide(Integer number) {

        Integer result = number;
        int iterationsNumber = 0;

        if (number != null && number > 0) {
            while (result > 0) {
                result = result / 3;
                iterationsNumber++;
            }
            System.out.println("You have to divide {" + number + "} by three " + iterationsNumber + " times to get 0.");

        } else if (number == null) {

            System.out.println(number + " can not be divided by anything");

        } else if (number < 0) {

            System.out.println(number + " is negative and negatives are not allowed");

        } else {
            System.out.println("Dividing 0 by 3 gives 0");
        }

        return iterationsNumber;
    }

}
