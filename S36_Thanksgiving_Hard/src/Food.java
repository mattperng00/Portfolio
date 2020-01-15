/**
 * Class: Food
 * saves enjoyment,weight,name,ratio,and count
 */
public class Food implements Comparable<Food> {
    /**
     * stores food name
     */
    private String name;
    /**
     * stores weight of food
     */
    private double weight;
    /**
     * stores enjoyment of food
     */
    private double enjoyment;
    /**
     * stores count this certain food being eaten
     */
    private int count;
    /**
     * stores the ratio of the food
     */
    private double ratio;

    /**
     * Constructor takes in the name,weight,enjoyment
     * @param name
     * @param weight
     * @param enjoyment
     */
    public Food(String name, double weight, double enjoyment)
    {
        this.name = name;
        this.weight = weight;
        this.enjoyment = enjoyment;
        this.ratio = enjoyment/weight;
    }

    /**
     * returns enjoyment
     * @return
     */
    public double getEnjoyment() {
        return enjoyment;
    }

    /**
     * returns weight
     * @return
     */
    public double getWeight() {
        return weight;
    }

    /**
     * returns name
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * returns ratio
     * @return
     */
    public double getRatio()
    {
        return ratio;
    }

    /**
     * returns count
     * @return
     */
    public int getCount()
    {
        return count;
    }

    /**
     * adds to count
     */
    public void add()
    {
        count++;
    }


    /**
     * compares to food ratios
     * @param o
     * @return
     */
    @Override
    public int compareTo(Food o) {
        return Double.compare(o.ratio,this.ratio);
    }
}
