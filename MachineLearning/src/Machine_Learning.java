/**
 * Machine_Learning class:
 * calculate method CosineSimilarity
 *calculate method Euclidean distance
 *calculate method Hamming Distance
 */
public class Machine_Learning {

    /**
     *CosineSimilarty method, calculates the cosine similarty
     *Throws exception if lengths of arrays aren't equal length
     * @param x
     * @param y
     * @return
     */
    public double CosineSimilarity(double[] x, double [] y)
    {
        double dotProductSum =0;
        double xMagnitude = 0;
        double yMagnitude = 0;

        if(x.length != y.length)
        {
            throw new IllegalArgumentException("lengths of arrays aren't equal");
        }

        for(int i=0; i <x.length;i++)
        {
            dotProductSum = x[i] * y[i] + dotProductSum;
        }
        for(int i=0; i<x.length;i++)
        {
            xMagnitude = x[i]*x[i] + xMagnitude;
            yMagnitude = y[i]*y[i] + yMagnitude;
        }

        xMagnitude =    java.lang.Math.sqrt(xMagnitude);
        yMagnitude = Math.sqrt(yMagnitude);

        double output = dotProductSum/ (xMagnitude*yMagnitude);


        return output;
    }

    /**
     * calculates the euclidean formula
     * Throws exception if lengths of arrays aren't equal length
     * @param x
     * @param y
     * @return
     */
    public double DistanceFormula(double []x, double[]y)
    {
        if(x.length != y.length)
        {
            throw new IllegalArgumentException("lengths of arrays aren't equal");
        }
        double sum=0;
        for (int i =0;i<x.length;i++)
        {
            sum = sum + java.lang.Math.pow(x[i]-y[i],2);
        }
        return java.lang.Math.sqrt(sum);
    }

    /**
     * calculates the hamming distance
     * Throws exception if Strings aren't equal length
     * Throws expcetion if Strings aren't binary
     * @param x
     * @param y
     * @return
     */
    public int HammingDistance(String x, String y)
    {
        int counter = 0;
        if(x.length() != y.length())
        {
            throw new IllegalArgumentException("lengths of arrays aren't equal");
        }

        for(int i=0; i<x.length();i++)
        {
            if (x.charAt(i) != y.charAt(i))
            {
                counter++;
            }
        }
        return counter;
    }
}
