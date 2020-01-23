package RequestInheritance;

import java.util.UUID;

/**
 * PostEncrypedFormRequest class, extends PostFormRequest
 */
public class PostEncryptedFormRequest extends PostFormRequest {
    /**
     * stores EncryptionScheme
     */
    private String EncryptionScheme;
    /**
     * stores counter
     */
    private static int counter= 0;

    /**
     * constructor sets ID, IP, form, and EncryptionScheme
     * increases counter
     * @param ID
     * @param IP
     * @param form
     * @param EncryptionScheme
     */
    PostEncryptedFormRequest(UUID ID, String IP, Form form, String EncryptionScheme)
    {
        super(ID,IP,form);
        this.EncryptionScheme = EncryptionScheme;
        counter++;
    }

    /**
     * returns count
     * @return
     */
    public static int count()
    {
        return counter;
    }

    /**
     * overrides the toString, prints everything in the super class and
     * prints the EncryptionScheme
     * @return
     */
    @Override
    public String toString() {
        System.out.println(super.toString());
        return "This Form was encrypted using: " + EncryptionScheme;
    }
}
