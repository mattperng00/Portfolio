package RequestInheritance;

/**
 * File class
 */
public class File {
    /**
     * stores path of the file
     */
    private String path;
    /**
     * stores type of file
     */
    private String type;

    /**
     * constructor that takes int he file path and type
     * @param path
     * @param type
     */
    File(String path, String type)
    {
        this.path=path;
        this.type=type;
    }

}
