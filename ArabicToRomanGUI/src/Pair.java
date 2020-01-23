/**
 * class Pair, couples a arabic number and a roman num
 */
public class Pair {

    /**
     * variable to store Arabic number
     */
    private int ArabicNum;
    /**
     * variable to store roman num
     */
    private String RomanNum;


    /**
     * constructor that stores roman num and arabic num
     * @param y
     * @param x
     */
    Pair(String y,Integer x)
    {
        ArabicNum = x;
        RomanNum = y;

    }

    /**
     * returns the arabic num
     * @return
     */
    public int getArabicNum()
    {
        return ArabicNum;
    }

    /**
     * returns roman num
     * @return
     */
    public String getRomanNum()
    {
        return RomanNum;
    }




}
