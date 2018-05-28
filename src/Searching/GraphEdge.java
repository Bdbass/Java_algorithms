package Searching;

// represents an edge of a directed graph
public class GraphEdge {
    GraphNode start;
    GraphNode stop;
    double weight;

    //constructor
    public GraphEdge(GraphNode start, GraphNode stop, double weight) {
        this.stop = stop;
        this.start = start;
        this.weight = weight;
    }
}
