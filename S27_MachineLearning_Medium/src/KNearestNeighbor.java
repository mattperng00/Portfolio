import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * KNearestNeighbor class which takes in data points and finds the closest points
 * to the user input's point
 */
public class KNearestNeighbor {
    /**
     * creates an array to store each individual data point in an index
     */
    private double FileValues [] = new double[5 ];
    /**
     * stores all the distances and class from the user input
     */
    private ArrayList<Pair> distanceAndClass = new ArrayList<>();
    /**
     * stores the user's array input
     */
    private double userValues[];
    /**
     * stores how many data points he wants
     */
    private int k1;

    /**
     * constructor that takes in a double array and k
     * input is the user input data points and k is how many
     * data points needs to be found close to input
     * @param input
     * @param k
     */
    KNearestNeighbor(double [] input, int k)
    {
        userValues = input;
        this.k1 = k;
    }

    /**
     * reads in file, parses each line into data points, stores class and distances
     * sorts distanceAndClass
     * take first k elements in the distanceAndClass and prints what class it belongs to
     * @param fileName
     */

    public void KNN(String fileName)
    {
        File file = new File(fileName);
        Machine_Learning findDistance = new Machine_Learning();
        // tries to open file,
        try
        {
            Scanner iostream = new Scanner(file);
            int counter=0; //array index counter
            //while the file still has a next line
            while(iostream.hasNext())
            {
                String data = iostream.next(); // go to next line
                while(data.contains(","))
                {
                    // parses the data by by the ','
                    FileValues[counter] = Double.valueOf(data.substring(0,data.indexOf(",")));
                    data = data.substring(data.indexOf(",")+1);
                    if(data.contains(",") == false)
                    {
                        data = data.substring(1,data.length()-1);
                        double distance = findDistance.DistanceFormula(FileValues,userValues);
                        distanceAndClass.add(new Pair(distance,data));
                        counter = 0; //resets the array index
                    }
                    else
                    {
                        counter++;
                    }
                }
            }
        }
        // if files doens't exit, catch an exception
        catch (FileNotFoundException e)
        {
            e.printStackTrace(); // helps diagnose what went wrong with your code
        }

        //since it's an array list, I need collestions.sort. needed to overide because I am comparing pairs
        Collections.sort(distanceAndClass, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if(o1.grabData() > o2.grabData())
                {
                    return 1;
                }
                else
                {
                    return -1;
                }
            }
        });
        int class1=0;
        int class2=0;

        for (int i=0; i<k1; i++)
        {
            if(distanceAndClass.get(i).grabClass().equals("class1"))
            {
                class1++;
            }
            else
            {
                class2++;
            }
        }

        if(class1 > class2)
        {
            System.out.println("New Data Point belongs to class1");
        }
        else
        {
            System.out.println("New Data Point belongs to class2");
        }
    }


}
