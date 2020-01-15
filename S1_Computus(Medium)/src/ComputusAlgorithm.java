import java.util.HashMap;

/**
 * Class that finds the date of easter in any given year
 */
public class ComputusAlgorithm {

    /**
     * stores year the user wants to find easter
     */
    private int year;

    /**
     * Constructor for class
     * @param year stores year the user wants to find the date of easter
     */
    public ComputusAlgorithm(int year)
    {
        this.year=year;

    }

    /**
     * This is "Gauss' Easter algorithm" taken from wikipedia
     * the constructor takes in the year and uses the private variable year to calculate the easter date
     * @return
     */
    public  String computus()
    {
            String date = "";
            int a = year % 19;
            int b = year % 4;
            int c = year % 7;
            int k = Math.floorDiv(year,100);
            int p = Math.floorDiv((13+8*k),25);
            int q = Math.floorDiv(k,4);
            int M = (15-p+k-q) %30;
            int N = (4+k-q)%7;
            int d = (19*a+M) % 30;
            int e = (2*b + 4*c + 6*d + N) % 7;
            int day = 22+d+e;
            int day2 = d+e-9;
            if(day > 30)
            {
                date ="April " + day2;
            }
            else
            {
                date = "March " + day;
            }
            if(d==29 && e ==6)
            {
                date = "April " + 19;
            }
            else if(d==28 && e==6 && (11*M + 11)%30 <19)
            {
                date = "April " + 18;
            }
            date = "Easter: " + date;
            return date;
    }

    /**
     * Finds the how many days Easter appears on each day
     * uses for loop from year 0-5700000, and calls computus() to find the date
     * @param x
     * @return
     */
    public HashMap<String,Integer> easterRepeat(int x)
    {
        HashMap<String,Integer> dateCount = new HashMap<>();
        for(int i=0; i < x; i++)
        {
            year = i;
            String date = computus();

            if(!dateCount.containsKey(date))
            { dateCount.put(computus(),1);
            }
            else
            {

                dateCount.put(date,dateCount.get(date)+1);
            }
        }
        return dateCount;
    }
}
