/**
 * Main class
 * runs program
 */
public class Main {

    /**
     * the main method that calls all the functions
     * @param args
     */
    public static void main(String[] args)
    {
        double distance [] = {1.5,3.5,2,2,8};
        KNearestNeighbor open = new KNearestNeighbor(distance,5);
        open.KNN("oral_exam1/S27_MachineLearning_Medium/S27-MLMedium.csv");

    }
}
