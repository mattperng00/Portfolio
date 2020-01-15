package RequestInheritance;

import java.util.UUID;

/**
 * GetVideoRequest class
 * extends Request
 */
public class GetVideoRequest extends Request {
    /**
     * stores video object
     */
    Video video;
    /**
     * stores counter
     */
    private static int counter=0;

    /**
     * Constructor, sets ID and video
     * increases counter
     * @param ID
     * @param video
     */
    GetVideoRequest(UUID ID, Video video)
    {
        super(ID);
        this.video=video;
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
     * prints the video object
     * @return
     */
    @Override
    public String toString() {
        System.out.println(super.toString());
        return video.toString();
    }
}
