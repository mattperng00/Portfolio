import java.util.ArrayList;
import java.util.HashMap;

public class main {
    public static void main(String[] args) {
        System.out.println("------------------------- Easy ----------------------------------------");
        ArrayList<String> words = AdjacencyList.readInFile("C:\\Git\\mperng_swd\\oral_exam2\\S35_GraphAlgos\\src\\words.dat");
        HashMap<String, ArrayList<String>> graph = AdjacencyList.adjacancyList(words);
        System.out.println("------------------------- Medium --------------------------------------");
        ArrayList<String> pathDFS = DFS_BFS.DFS(graph,words);
        DFS_BFS.BFS(graph,words);
        System.out.println("------------------------- Hard ----------------------------------------");
        MST.primsAlgorithm(graph,words,"pills");



    }
}
