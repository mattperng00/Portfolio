import java.util.*;

/**
 * class MST
 * Creates a Minimum Spanning Tree using Prims Algorithm
 */
public class MST {
    /**
     * Method: primsAlgorithm
     * runs the prims algorithm
     * @param graph
     * @param words
     * @param start
     */
    public static void primsAlgorithm(HashMap<String, ArrayList<String>> graph,ArrayList<String> words, String start)
    {
        HashMap<String,Boolean> connected = new HashMap<>();
        ArrayList<String> conncetedWords = new ArrayList<>();
        //sets all vertices as not yet visited
        for(int i =0; i<words.size();i++)
        {
            if(graph.get(words.get(i)) != null)
            {
                connected.put(words.get(i),false);
                conncetedWords.add(words.get(i));
            }
        }
        //saves weight of tree
        int weight =0;
        //saves trees that are visited
        ArrayList<String> visited = new ArrayList<>();
        //saves tree
        ArrayList<String> tree = new ArrayList<>();
        tree.add(start);
        //saves edges
        HashMap<String,Integer> edges = new HashMap<>();
        //vertices needed to be traversed
        Queue<String> path = new LinkedList<>();
        path.add(start);
        while(!path.isEmpty())
        {
            //grab first out of the Queue
            String current = ((LinkedList<String>) path).getFirst();
            ((LinkedList<String>) path).removeFirst();

            //find the connections of the first grabbed vertex
            for (int i=0; i <graph.get(current).size();i++)
            {
                String temp = graph.get(current).get(i);
                //if connected vertex has not been visited yet add to Queue
                if(!connected.get(temp))
                {
                    ((LinkedList<String>) path).add(temp);
                    //makes sure the vertices are marked as visited to prevent it to go in the Queue again
                    connected.put(temp,true);
                    connected.put(current,true);
                    //adds the edge between vertex1 and the connected vertex2 and edge weight between them
                    //visited keeps track of edges visited
                    if(!visited.contains(current+temp) && !visited.contains(temp+current))
                    {
                        edges.put(current+temp,setWeight(current,temp));

                    }
                    visited.add(current+temp);
                }

            }

            //search for smallest weight
            String minKey =null;
            for (Map.Entry<String, Integer> entry : edges.entrySet()) {
                if(minKey==null)
                {
                    minKey = entry.getKey();
                }
                else if(entry.getValue() < edges.get(minKey))
                {
                    minKey = entry.getKey();
                }
            }
            boolean x = false;
            if(minKey != null)
            {
                String vertex1 = minKey.substring(5,10);
                String vertex2 = minKey.substring(0,5);
                //if vertex isn't contained in tree add it
                if(tree.contains(vertex1))
                {
                    tree.add(vertex1);
                    x = true;
                }
                if(!tree.contains(vertex2))
                {
                    tree.add(vertex2);
                    x=true;
                }
                //if x is false, means the edge weight was already added
                if(x)
                {
                    weight = weight + edges.get(minKey);
                }
                //remove edge
                edges.remove(minKey);
            }
        }
        System.out.println(tree);
        System.out.println("Weight: " + weight);
    }

    /**
     * Gets the weight of two words
     * @param vertex1
     * @param veterx2
     * @return
     */
    private static int setWeight(String vertex1,String veterx2)
    {
        int weight =0;
        String vertex = vertex1+veterx2;
        for (int i=0; i<vertex.length();i++)
        {
            weight = weight+ Character.getNumericValue(vertex.charAt(i));
        }
        return weight;
    }


}

