package Searching;

import Searching.PriorityQueues.PQ_ArrayList;
import java.lang.StringBuilder;

public class Dijkstras {

    //Main function
    public static void main(String args[]){
        DirectedGraph DG = new DirectedGraph();
        DG.CreateGraph("DirectedGraph.txt");
        BackTrack(Dijkstra(DG, "E", "C"));
    }

    //Uses the previous nodes to backtrack and make the correct path
    static void BackTrack(GraphNode graphNode){
        GraphNode temp = graphNode;
        StringBuilder nodePath = new StringBuilder();
        while (temp != null){
            nodePath.append(temp.getName()+" ");
            temp = temp.getPrevious();
        }
        nodePath.reverse();
        System.out.println("Path is:"+nodePath);
        System.out.println("Cost is: "+graphNode.getCost());

    }
    //Dijkstra's shortest path algorithm
    static GraphNode Dijkstra(DirectedGraph directedGraph, String start, String end){
        // return null if graph does not contain either start or end
        GraphNode NOTFOUND = new GraphNode("DNUOF TON");
        if (!directedGraph.myGraph.containsKey(start) ||
                !directedGraph.myGraph.containsKey(end)){
            return NOTFOUND;
        }

        //Dijkstra's algorithm
        PQ_ArrayList<GraphNode, Double> pq = new PQ_ArrayList<>();
        //set start cost to 0
        directedGraph.myGraph.get(start).setCost(0);
        //add start node to pq with priority of 0
        pq.enqueue(directedGraph.myGraph.get(start), 3.0);

        //loop until pq is empty
        while(!pq.isEmpty()){
            //dequeue vertex w/ highest priority and set as visited
            GraphNode current = pq.dequeue();
            if(current.getName().equals(end)) return current;
            current.setVisited(true);
            //loop through all unvisited neighbors of current
            for(GraphEdge i: current.getEdges()){
                double Cost = current.getCost()+i.weight;
                if (!i.stop.isVisited()){
                    // if the new cost is less than the old cost update it and add it to the queue
                    if (Cost < i.stop.getCost()){
                        i.stop.setPrevious(i.start);
                        i.stop.setCost(Cost);
                        pq.enqueue(i.stop, Cost);
                    }
                }
            }
        }
        return NOTFOUND;
    }
}