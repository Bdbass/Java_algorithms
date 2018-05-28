package Searching;
import java.util.*;

// Represents a node of a graph
public class GraphNode {
    private String name;
    private double cost;
    private boolean visited;
    private GraphNode previous;
    private ArrayList<GraphEdge> edges;

    //constructor
    public GraphNode(String Name){
        name = Name;
        cost = Double.MAX_VALUE;
        previous = null;
        edges = new ArrayList<>();
        visited = false;
    }

    //Getters
    public String getName() {return name;}
    public double getCost() {return cost;}
    public boolean isVisited() {return visited;}
    GraphNode getPrevious() {return previous;}
    public ArrayList<GraphEdge> getEdges() {return edges; }

    //Setters
    public void setCost(double cost) {
        this.cost = cost;
    }
    public void setVisited(boolean visited) {
        this.visited = visited;
    }
    void AddEdge(GraphEdge edge){
        edges.add(edge);
    }
    public void setPrevious(GraphNode previous) {this.previous = previous;}
}
