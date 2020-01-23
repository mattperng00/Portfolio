package RequestInheritance;

import java.util.UUID;

/**
 * PostEncryptedPaymentRequest class
 * extends PostPaymentRequest
 */
public class PostEncryptedPaymentRequest extends PostPaymentRequest{
    /**
     * stores counter
     */
    private static int counter=0;
    /**
     * stores RandomEncryptionScheme
     */
    private String RandomEncryptionScheme;

    /**
     * constructor sets ID,IP,payment,RandomEncryptionSheme
     * increases counter
     * @param ID
     * @param IP
     * @param payment
     * @param RandomEncryptionScheme
     */
    PostEncryptedPaymentRequest(UUID ID, String IP, Payment payment, String RandomEncryptionScheme )
    {
        super(ID,IP,payment);
        this.RandomEncryptionScheme = RandomEncryptionScheme;
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
     * prints RandomEncryptionScheme
     * @return
     */
    @Override
    public String toString() {
        System.out.println(super.toString());
        return "This payment was encrypted using: " + RandomEncryptionScheme;
    }
}
