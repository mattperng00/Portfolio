/**
 * Pair class, links two data points together
 */
public class Pair {
    /**
     * stores data point
     */
    private double data;
    /**
     * stores class of data point
     */
    private String Class;

    /**
     * User inputs data point and data's class into constructor
     * @param data
     * @param Class
     */
    Pair(Double data, String Class)
    {
        this.data = data;
        this.Class =Class ;

    }

    /**
     * returns data point
     * @return
     */
    public double grabData()
    {
        return data;
    }

    /**
     * returns data's class
     * @return
     */
    public String grabClass ()
    {
        return Class;
    }


}