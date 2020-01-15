import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Class: ThanksgivingTest
 * validates the program
 */
class ThanksgivingTummyTest {
    /**
     * creates new list of food
     */
    private ArrayList<Food> food = new ArrayList<>();
    /**
     * creates new food object turkey
     */
    private Food turkey = new Food("turkey",3,4);
    /**
     * creates new food object pie
     */
    private Food pie = new Food("pie",2,2);
    /**
     * creates new food object potatoes
     */
    private Food potatoes = new Food("potatoes",4,5);
    /**
     * creates new food object gravy
     */
    private Food gravy = new Food("gravy",10,10);
    /**
     * creates new food object stuffing
     */
    private Food stuffing = new Food("stuffing",2,3);
    /**
     * creates new food object cranberries
     */
    private Food cranberries = new Food("cranberries",7,5);
    /**
     * creates new food object cassrole
     */
    private Food cassarole = new Food("cassarole",12,17);
    /**
     * initializes capacity
     */
    private int capacity =20;

    /**
     * appends all foods to the list
     */
    public void add()
    {

        food.add(turkey);
        food.add(pie);
        food.add(potatoes);
        food.add(gravy);
        food.add(stuffing);
        food.add(cranberries);
        food.add(cassarole);
    }
    /**
     * test case 1 from test_cases.txt
     */
    @Test
    public void test1()
    {
        food.add(turkey);
        food.add(pie);
        food.add(potatoes);
        food.add(gravy);
        food.add(stuffing);
        food.add(cranberries);
        food.add(cassarole);
        ThanksgivingTummy tummy = new ThanksgivingTummy(capacity,food);
        assertEquals(30,tummy.getOptEnjoyment());
    }

}