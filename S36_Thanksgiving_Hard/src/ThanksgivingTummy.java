import java.util.ArrayList;
import java.util.Collections;

/**
 * Class ThanksgivingTummy:
 * calculates optimal enjoyment
 */
public class ThanksgivingTummy{

    /**
     * stores the capacity of user
     */
    private double capacity;
    /**
     * stores the list of food
     */
    private ArrayList<Food> food;
    /**
     * sets the opEnjoyment, which is going to be the return value
     */
    private double optEnjoyment=0;

    /**
     * Constructor setting capacity and food list
     * @param capacity
     * @param food
     */
    ThanksgivingTummy(double capacity, ArrayList<Food> food)
    {
        this.food = food;
        this.capacity = capacity;
    }


    /**
     * greedly subtracts the best ratio food from capacity till you can't fit any, then the next best item and subtract from capacity
     */
    public void optimalEnjoyment ()
    {

        //sorts from greatest ratio to least
        Collections.sort(food);
        int counter=0;

        //if capacity isn't 0 or counter doens't go past food.size()
        while(capacity >= 0 && counter < food.size())
       {
            //checks capcity - most optimal food is not <0
           if(capacity - food.get(counter).getWeight() >=0)
           {
               capacity = capacity - food.get(counter).getWeight();
               food.get(counter).add();
           }
           // if capacity- current most optimal food < 0, move to next most optimal food
           else
           {
               counter++;
           }
       }

        //grabs the count of each food and multiplies it by the enjoyment, then adds it to the total enjoyment
       for(int i=0; i <food.size();i++)
       {
           System.out.println("You ate " + food.get(i).getCount() + " " + food.get(i).getName() );
           if(food.get(i).getCount() > 0)
           {
               optEnjoyment = optEnjoyment + food.get(i).getEnjoyment()*food.get(i).getCount();
           }
       }

       System.out.println("Optimal Enjoyment: " + optEnjoyment);
    }

    /**
     * returns the optimal enjoyment
     * @return
     */
    public double getOptEnjoyment()
    {
        optimalEnjoyment();
        return optEnjoyment;
    }


}
