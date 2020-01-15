package RequestInheritance;

import java.util.UUID;

/**
 * class PostFormRequest
 * extends PostRequest
 */
public class PostFormRequest extends PostRequest {

    /**
     * stores the form object
     */
    private Form form;
    /**
     * stores counter
     */
    private static int counter=0;

    /**
     * constructor that sets ID, IP, and form
     * increases counter
     * @param ID
     * @param IP
     * @param form
     */
    PostFormRequest(UUID ID,String IP, Form form)
    {
        super(ID,IP);
        this.form = form;
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
     * prints the form object
     * @return
     */
    @Override
    public String toString() {
        System.out.println(super.toString());
        return "Form Data \n" + form.toString();
    }
}
