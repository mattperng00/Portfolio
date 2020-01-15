package RequestInheritance;

/**
 * video class
 */
public class Video {
    /**
     * stores URL
     */
    private String URL;
    /**
     * stores video
     */
    private String video;
    /**
     * stores name
     */
    private String Name;

    /**
     * constructor that sets URL,video,Name
     * @param URL
     * @param video
     * @param Name
     */
    Video(String URL, String video, String Name)
    {
        this.URL=URL;
        this.video = video;
        this.Name = Name;
    }

    /**
     * overrides the toString, prints everything in the super class and
     * prints URL, video, and Name
     * @return
     */
    @Override
    public String toString() {

        return "Universal Resource Locator (URL): " + URL + "\nVideo: " + video + "\nBy: " + Name;
    }
}
