package RequestInheritance;

import java.util.HashMap;

/**
 * Form class
 */
public class Form {
    /**
     * stores the field object
     */
    HashMap<String, String> fields;

    /**
     * constructor that sets fields
     * @param fields
     */
    Form(HashMap<String, String> fields )
    {
        this.fields= fields;
    }

    /**
     * overrides the toString, prints everything in the super class and
     * prints the fields information
     * @return
     */
    @Override
    public String toString() {
        System.out.println(super.toString());
        return "Label: Favorite Color \n"
                + "Value: " + fields.get("Favorite color")
                + "\nLabel: Favorite Encryption scheme\n"
                + "Value: " + fields.get("Favorite encryption scheme")
                + "\nLabel: Name\n"
                + "Value: " + fields.get("Name")
                ;

    }
}
