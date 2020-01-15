import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class: UserInput
 * that grabs user input
 */
public class UserInput {
    /**
     * constructor asks user for food,weight,enjoyment, and capacity
     */
    public UserInput()
    {
        boolean x = true;
        System.out.println("Enter tummy capacity");
        Scanner input = new Scanner(System.in);
        int capacity = input.nextInt();
        ArrayList<Food> list  = new ArrayList<>();
        while(x)
        {
            System.out.println("Enter in food name");
            Scanner food = new Scanner(System.in);
            String userFood = food.next();

            System.out.println("Enter in weight of food");
            int weight = input.nextInt();

            System.out.println("Enter in enjoyment of food");
            int enjoyment = input.nextInt();

            list.add(new Food(userFood,weight,enjoyment));

            System.out.println("press 1 to continue or 2 to stop");
            int choice = input.nextInt();
            if(choice ==2)
            {
                x=false;
            }
        }
        ThanksgivingTummy start = new ThanksgivingTummy(capacity,list);
    }
}
