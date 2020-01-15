package RequestInheritance;

import java.util.UUID;

/**
 * PostRequest class
 * extends Request
 */
public class PostRequest extends Request{
    /**
     * stores IP
     */
    private String IP;
    /**
     * stores counter
     */
    private static int counter =0;

    /**
     * constructor that sets ID, and IP
     * increases counter
     * @param ID
     * @param IP
     */
    PostRequest(UUID ID, String IP)
    {
        super(ID);
        this.IP = IP;
        counter++;

    }

    /**
     * returns counter
     * @return
     */
    public static int count()
    {
        return counter;
    }

    /**
     * overrides the toString, prints everything in the super class and
     * prints the IP
     * @return
     */
    @Override
    public String toString() {
        System.out.println(super.toString());
        return "Post request to server with IP address: " + IP;
    }
}
