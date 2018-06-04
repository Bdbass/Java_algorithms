package Searching;
import Searching.PriorityQueues.PQ_ArrayList;
import java.lang.StringBuilder;
import javafx.util.Pair;

public class Astar {
    //Main function
    public static void main(String args[]) {
        Maze maze = new Maze("Maze.txt");
        maze.PrintMaze();
        //Dijkstras.BackTrack(Astar(maze, "E", "C"));
    }

    static boolean ValidateEntries(Pair<Integer, Integer> start, Pair<Integer, Integer> end) {
        return false;
    }

    //    //Astar's shortest path algorithm
    static MazeNode Astar(Maze maze, Pair<Integer, Integer> start, Pair<Integer, Integer> end) {
//        // return null if graph does not contain either start or end
        if (!ValidateEntries(start, end)) {
            MazeNode NOTFOUND = new MazeNode(-1);
            return NOTFOUND;
        }
        return new MazeNode(0);
    }
//
//        //Dijkstra's algorithm
//        PQ_ArrayList<GraphNode, Double> pq = new PQ_ArrayList<>();
//        //set start cost to 0
//        directedGraph.myGraph.get(start).setCost(0);
//        //add start node to pq with priority of 0
//        pq.enqueue(directedGraph.myGraph.get(start), 3.0);
//
//        //loop until pq is empty
//        while(!pq.isEmpty()){
//            //dequeue vertex w/ highest priority and set as visited
//            GraphNode current = pq.dequeue();
//            if(current.getName().equals(end)) return current;
//            current.setVisited(true);
//            //loop through all unvisited neighbors of current
//            for(GraphEdge i: current.getEdges()){
//                double Cost = current.getCost()+i.weight;
//                if (!i.stop.isVisited()){
//                    // if the new cost is less than the old cost update it and add it to the queue
//                    if (Cost < i.stop.getCost()){
//                        i.stop.setPrevious(i.start);
//                        i.stop.setCost(Cost);
//                        pq.enqueue(i.stop, Cost);
//                    }
//                }
//            }
//        }
//        return NOTFOUND;
//    }
}
