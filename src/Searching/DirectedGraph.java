package Searching;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class DirectedGraph {
    //Use a hash map to store node values for quick look ups
    HashMap<String, GraphNode> myGraph;

    // constructor
    public DirectedGraph(){
        myGraph = new HashMap<>();
    }
    //Creates a graph based off a file
    void CreateGraph(String fileName){
        String s;
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))){
            while((s = br.readLine()) != null){
                System.out.println(s);
                ParseLine(s);
            }
        }catch(IOException exc){
            System.out.println("I/O Error: "+exc);
        }
    }
    //Parses a line of file creating nodes and edge, assumes each line is in the format "A B 2"
    private void ParseLine(String s) {
        String[] temp = s.split(" ", 3);
        String Node1 = temp[0];
        String Node2 = temp[1];
        Integer Edge = Integer.parseInt(temp[2]);

        if (!myGraph.containsKey(Node1)) {
            myGraph.put(Node1, new GraphNode(Node1));
        }
        if (!myGraph.containsKey(Node2)) {
            myGraph.put(Node2, new GraphNode(Node2));
        }
        myGraph.get(Node1).AddEdge(new GraphEdge(myGraph.get(Node1), myGraph.get(Node2), Edge));
    }

}
