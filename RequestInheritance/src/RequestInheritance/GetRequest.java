package RequestInheritance;

import java.util.UUID;

/**
 * GetRequest class, extends Request
 */
public class GetRequest extends Request{
    /**
     * stores the URL
     */
    String URL;
    /**
     * stores the number of URL
     */
    private static int counter =0;

    /**
     * GetRequest constructor takes in ID and URL
     * increases counter
     * @param ID
     * @param URL
     */
    GetRequest(UUID ID, String URL)
    {
        super(ID);
        this.URL = URL;
        counter++;
    }

    /**
     * return count
     * @return
     */
    public static int count()
    {
        return counter;
    }

    /**
     * overrides the toString, prints everything in the super class and
     * prints URL
     * @return
     */
    @Override
    public String toString() {
        System.out.println(super.toString());
        return "Universal Resource Locator (URL): " + this.URL;
    }
}
