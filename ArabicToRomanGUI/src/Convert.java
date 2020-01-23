/**
 * this is the Convert class.
 * It converts Roman to Arabic and vice versa
 */
public class Convert {

    /**
     * variable that stores user input Arabic Number
     */
    private int ArabicNum;
    /**
     * a const Pair array that links important conversions
     */
    final Pair values[] = new Pair[18];
    /**
     * a const Pair array that links important conversions
     */
    final Pair valuesForRoman[] = new Pair[7];
    /**
     * saves the length of the values array
     */
    final int lengthofPair = values.length;
    /**
     * variable that stores the user Input Roman number
     */
    private String RomanNum;

    /**
     * Constructor to change an Arabic num into a roman num
     * @param UserInput
     */
    Convert(int UserInput)
    {
        if(UserInput == 0 || UserInput < 0)
        {
            throw new IllegalArgumentException("Roman Number System Doesn't have 0");
        }

        ArabicNum = UserInput;

        initializeValues();

    }

    /**
     * Constructor to change a Roman Num to an Arabic num
     * @param UserInput
     */
    Convert(String UserInput)
    {

        RomanNum  = UserInput;
        initializeValuesForRoman();
    }

    /**
     * initializes the values array
     */
    private void initializeValues()
    {
        values[17] = new Pair("I",1);
        values[16] = new Pair("II",2);
        values[15] = new Pair("III",3);
        values[14] = new Pair("IV",4);
        values[13] = new Pair("V",5);
        values[12] = new Pair("VI",6);
        values[11] = new Pair("VIII",7);
        values[10] = new Pair("VIII",8);
        values[9] = new Pair("IX",9);
        values[8] = new Pair("X",10);
        values[7] = new Pair("XL",40);
        values[6] = new Pair("L",50);
        values[5] = new Pair("XC",90);
        values[4] = new Pair("C",100);
        values[3] = new Pair("CD",400);
        values[2] = new Pair("D",500);
        values[1] = new Pair("CM",900);
        values[0] = new Pair("M",1000);

    }
    /**
     * initialize valuesForRoman array
     */
    public void initializeValuesForRoman()
    {
        valuesForRoman[0] = new Pair("I",1);
        valuesForRoman[1] = new Pair("V",5);
        valuesForRoman[2] = new Pair("X",10);
        valuesForRoman[3] = new Pair("L",50);
        valuesForRoman[4] = new Pair("C",100);
        valuesForRoman[5] = new Pair("D",500);
        valuesForRoman[6] = new Pair("M",1000);
    }

    /**
     * This method changes the private variable arabic number into a string and returns it
     * @return
     */
    public String Arabic_Roman()
    {
        String output = "";

        //greedy algorithm
        for(int i=0;i < lengthofPair;i++)
        {
            //subtract 1000,500,100, etc till 0
            if(ArabicNum-values[i].getArabicNum() >=0)
            {
                output = output + values[i].getRomanNum();
                ArabicNum = ArabicNum - values[i].getArabicNum();
            }
        }

        return output;
    }

    /**
     * This method changes the private variable roman number into an arabic number and returns it
     * @return
     */
    public int Roman_Arabic()
    {
        int LastIndexRoman = RomanNum.length()-1;
        int previous = 0;
        int output=0;

        // greedy algorithm
        for(int i=LastIndexRoman; i>= 0;i--)
        {
            for (int j=0;j < valuesForRoman.length; j++)
            {
                if (valuesForRoman[j].getRomanNum().charAt(0) == RomanNum.charAt(i))// goes into loop even if they match
                {
                    //if previous is greater than current string, current is subtract
                    if(previous > valuesForRoman[j].getArabicNum())
                    {
                        output = output - valuesForRoman[j].getArabicNum();
                    }
                    else
                    {
                        output = output+ valuesForRoman[j].getArabicNum();
                    }
                    previous = valuesForRoman[j].getArabicNum();
                }
            }
        }
        return output;
    }

}

