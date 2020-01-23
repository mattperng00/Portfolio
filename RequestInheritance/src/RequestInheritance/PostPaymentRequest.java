package RequestInheritance;

import java.util.UUID;

/**
 * PostPaymentRequest class
 * extends PostRequest
 */
public class PostPaymentRequest extends PostRequest{
    /**
     * stores payment object
     */
    private Payment Payment;
    /**
     * stores counter
     */
    private static int counter=0;

    /**
     * constructor that sets ID,IP,payment
     * increases counter
     * @param ID
     * @param IP
     * @param payment
     */
    PostPaymentRequest(UUID ID, String IP, Payment payment)
    {
        super(ID,IP);
        this.Payment=  payment;
        counter++;
    }

    /**
     * return counter
     * @return
     */
    public static int count()
    {
        return counter;
    }

    /**
     * overrides the toString, prints everything in the super class and
     * prints Payment object to string
     * @return
     */
    @Override
    public String toString() {
        System.out.println(super.toString());
        return Payment.toString();
    }
}
