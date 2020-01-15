import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 */
public class  AdjacencyList {


    /**
     * Function: Reads in file
     * @param fileName
     * @return ArrayList of words
     */
    public static ArrayList<String> readInFile(String fileName)
    {
        File file = new File(fileName);
        ArrayList<String> words = new ArrayList<>();

        try
        {
            Scanner iostream = new Scanner(file);
            while(iostream.hasNext())
            {
                String data = iostream.next();
                words.add(data);
            }
        }
        catch(Exception e)
        {
            System.out.println("error");
        }

        return words;
    }

    /**
     * Function: creates a graph with a Hashmap. Stores index and an ArrayList of vertices it is connected to
     * @param words
     * @return
     */
    public static HashMap<String,ArrayList<String>> adjacancyList(ArrayList<String> words)
    {
        //keeping track of connections and non connections
        int connections =0;
        int nonConnections=0;
        //creating file
//        File file = new File(fileName);
        //creating the graph
        HashMap<String,ArrayList<String>> vertex = new HashMap<>();
        //reads in file and stores it into words
//        ArrayList<String> words = readInFile(fileName);

        for(int i =0; i< words.size();i++)
        {
            //creates a new arrayList for every key in the hashmap
            ArrayList<String> edges = new ArrayList<>();
            //adds empty arraylist with the key
            vertex.put(words.get(i),edges);
            int counter=0;
            for(int j=0; j<words.size();j++)
            {
                //if words differ by 1 letter
                if(checkEdge(words.get(i).toCharArray(),words.get(j).toCharArray()))
                {
                    // add to arrayList at i'th key
                    edges.add(words.get(j));
                    // add to connections
                    connections++;
                }
                else
                {
                    counter ++;
                    // if the i'th word has 'counter == word.size()' number, means no connections
                    if(counter == words.size())
                    {
                        nonConnections++;
                    }
                }
            }
        }

        System.out.println((double)connections/words.size());
        System.out.println(nonConnections);

        int maxVerticies =0;
        ArrayList<String> vertexMax = new ArrayList<>();
        for (Map.Entry<String, ArrayList<String>> entry : vertex.entrySet()) {
            if(entry.getValue().size() > maxVerticies)
            {
                maxVerticies = entry.getValue().size();
            }
            else if(entry.getValue().size() == maxVerticies)
            {
                vertexMax.add(entry.getKey());
            }
        }
        System.out.print("nodes with most edges: " + vertexMax + " with " + maxVerticies + " vertices each \n");

        return vertex;
    }

    /**
        Function Name: checkEdge
        Function Input: char array x , char array y
        Function: checks if two char array's differ by one letter
                   if differs by 1, return 'true'
                   otherwise return 'false'
     */
    public static boolean checkEdge(char[] x, char[] y)
    {
        int counter=0;
        for (int i=0;i<x.length;i++)
        {
            if(x[i] == y[i])
            {
                counter++;
            }
        }
        if(counter == 4)
        {
            return true;
        }
        return false;
    }

}
