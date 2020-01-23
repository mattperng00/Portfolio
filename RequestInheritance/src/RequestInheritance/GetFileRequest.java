package RequestInheritance;

import java.util.UUID;

/**
 * extends Request
 * GetFileRequest class
 */
public class GetFileRequest extends Request{
    /**
     * stores the file object
     */
    File File;
    /**
     * creates a counter for the # of files
     */
    private static int counter =0;

    /**
     * Constructor, grabs the ID and File
     * increases counter
     * @param ID
     * @param File
     */
    GetFileRequest(UUID ID, File File)
    {
        super(ID);
        this.File = File;
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
     * prints file info
     * @return
     */
    @Override
    public String toString() {
        System.out.println(super.toString());
        return File.toString();
    }
}
