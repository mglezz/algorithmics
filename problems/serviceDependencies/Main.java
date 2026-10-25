package problems.serviceDependencies;

public class Main {
    public static void main(String[] args) {

        int numberServices = 4;

        int[][] dependencies = {
            {1, 0},
            {2, 0},
            {3, 1},
            {3, 2}
        };

        Algorithm algorithm = new Algorithm();  

        algorithm.findStartupOrder(numberServices, dependencies, true);

    }    

}