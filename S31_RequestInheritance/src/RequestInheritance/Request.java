package RequestInheritance;

import java.util.UUID;

/**
 * Request Class
 */
public class Request {
    /**
     * stores ID
     */
    private UUID ID;
    /**
     * stores counter
     */
    private static int counter =0;

    /**
     * constructor that sets ID and increases counter
     * @param ID
     */
    Request(UUID ID)
    {
        this.ID = ID;
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
     * prints ID
     * @return
     */
    @Override
    public String toString() {
        System.out.println(super.toString());
        return "UUID: " + ID;
    }
}
