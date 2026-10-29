
public class Algorithm02_01 {

    public Integer divide(Integer number) {

        Integer result = number;

        while (result > 0) {
            result = result / 3;
        }

        System.out.println("The result is... " + result);
        return result;
    }

}
