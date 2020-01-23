import java.util.*;

/**
 * This class runs the Depth First Search and Breadth First Search
 */
public class DFS_BFS {

    /**
     * Function: Runs the Depth First Search. Usually depth first search is used with a stack. I used a queue because the LinkedList lets me
     *           add to the back and pop the back.
     * @param graph  Hashmap of graph
     * @param words ArrayList of words
     */
    public static ArrayList<String> DFS(HashMap<String, ArrayList<String>> graph, ArrayList<String> words)
    {
        // create an already visted map
        HashMap<String,Boolean> alreadyVisited = new HashMap<>();
        //sets all vertices as not yet visited
        for(int i =0; i<words.size();i++)
        {
            alreadyVisited.put(words.get(i),false);
        }
        // sets up the stack
        Queue<String> nextVertx = new LinkedList<>();
        //sets first vertex as omens
        nextVertx.add("omens");
        // once added to stack, change to already visited to prevent multiple identical vertex to enqueue
        alreadyVisited.put("omens",true);

        //array storing path
        ArrayList<String> path = new ArrayList<>();

        int counter=0;
        //while stack is not empty
        while(!nextVertx.isEmpty())
        {
            //pop off the stack
            String temp = ((LinkedList<String>) nextVertx).getLast();
            ((LinkedList<String>) nextVertx).removeLast();
            //add popped off vertex to the graph
            path.add(temp);
            counter = counter+ graph.get(temp).size();
            //grabs the next vertices connected to the current vertex, and adds it the the stack (back of the nextVertex)
            for (int i=0; i< graph.get(temp).size();i++)
            {
                String vertex = graph.get(temp).get(i);
                //checks if the connected vertices are unvisited
                if(!alreadyVisited.get(vertex))
                {
                    // add vertices to stack and mark as visited
                    ((LinkedList<String>) nextVertx).add(vertex);
                    alreadyVisited.put(vertex,true);
                }
                counter = counter+ graph.get(temp).size();
            }
        }
        System.out.println(path);
        System.out.println(graph.size()-671-counter);
        return path;
    }

    /**
     * Function: Runs the Breadth First Search
     * @param graph takes in the graph
     * @param words takes in the set of words
     */
    public static ArrayList<String> BFS(HashMap<String, ArrayList<String>> graph, ArrayList<String> words)
    {
        // create an already visted map
        HashMap<String,Boolean> alreadyVisited = new HashMap<>();
        //sets all vertices as not yet visited
        for(int i =0; i<words.size();i++)
        {
            alreadyVisited.put(words.get(i),false);
        }
        // sets up the queue
        Queue<String> nextVertx = new LinkedList<>();
        //sets first vertex as omens
        nextVertx.add("omens");
        // once added to queue, change to already visited to prevent multiple identical vertex to enqueue
        alreadyVisited.put("omens",true);

        //array storing path
        ArrayList<String> path = new ArrayList<>();
        int counter=1;
        //while queue is empty
        while(!nextVertx.isEmpty())
        {
            //pop off the last element
            String temp = ((LinkedList<String>) nextVertx).getLast();
            ((LinkedList<String>) nextVertx).removeLast();
            // add to the path
            path.add(temp);
            //grabs the next vertices connected to the current vertex, and adds it the the front of the queue (first element of nextVertex)
            for (int i=0; i< graph.get(temp).size();i++)
            {
                //grabs first connected vertex
                String vertex = graph.get(temp).get(i);
                //if vertex isn't visited
                if(!alreadyVisited.get(vertex))
                {
                    // add to front of queue
                    ((LinkedList<String>) nextVertx).add(0,vertex);
                    //mark as visited
                    alreadyVisited.put(vertex,true);

                }
                counter = counter+ graph.get(temp).size();
            }
        }
        System.out.println(path);
        System.out.println(graph.size()-671-counter);
        return path;
    }

}
