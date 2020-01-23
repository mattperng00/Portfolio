package RequestInheritance;

/**
 * Payment Class
 */
public class Payment{
    /**
     * stores randName
     */
    private String RandName;
    /**
     * stores nextInt
     */
    private int nextInt;
    /**
     * stores RandName2
     */
    private String RandName2;

    /**
     * Payment constructor, sets randName,randName2,nextInt
     * increases counter
     * @param RandName
     * @param nextInt
     * @param RandName2
     */
    Payment(String RandName,int nextInt,String RandName2)
    {
        this.RandName = RandName;
        this.nextInt = nextInt;
        this.RandName2 = RandName2;
    }

    /**
     * overrides the toString, prints everything in the super class and
     * prints randName,randName2,randInt
     * @return
     */
    @Override
    public String toString() {
        System.out.println(super.toString());
        return "Payment Data\n"
                + "Payment Sender " + RandName
                + "\nPayment Amount: $" + nextInt
                + "\nPayment receiver" + RandName2;
    }
}
