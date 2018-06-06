package Searching;
import Searching.PriorityQueues.PQ_ArrayList;
import java.lang.StringBuilder;
import java.util.ArrayList;

import javafx.util.Pair;

public class Astar {
    //Main function
    public static void main(String args[]) {
        Maze maze = new Maze("Maze.txt");
        maze.PrintMaze();
        RecursiveBackTrack(AStar(maze, new Pair<>(2,2), new Pair<>(0,2)));
    }

    private static void RecursiveBackTrack(MazeNode mazeNode){
        if (mazeNode.prev != null) RecursiveBackTrack(mazeNode.prev);
        System.out.println("x: " + mazeNode.x + " y: " +mazeNode.y);
    }
    //returns true if the given start and end are in the bounds of the maze and not an obstacle
    private static boolean ValidateEntries(Pair<Integer, Integer> start, Pair<Integer, Integer> end, Maze maze) {
        return start.getKey() >= 0 && start.getKey() < maze.myMaze.length
                && start.getValue() >= 0 && start.getValue() < maze.myMaze[0].length &&
                end.getKey() >= 0 && end.getKey() < maze.myMaze.length &&
                end.getValue() >= 0 && end.getValue() < maze.myMaze[0].length
                && maze.myMaze[start.getKey()][start.getValue()].value == 0 &&
                maze.myMaze[end.getKey()][end.getValue()].value == 0;
    }
    //uses manhattan distance to form a heuristic, with walls being cost of 2 and open paths a cost of 1
    private static double heuristic(Pair<Integer, Integer> start, Pair<Integer, Integer> end, Maze maze){
        // initialize an array list to store the MazeNodes
        ArrayList<MazeNode> path = new ArrayList<>();
        // initialize start and end points for easier reference
        int x = start.getKey();
        int y = start.getValue();
        int x1 = end.getKey();
        int y1 = end.getValue();
        // add all the MazeNodes on the way to the end point
        while (x > x1) path.add(maze.myMaze[x--][y]);
        while (x < x1) path.add(maze.myMaze[x++][y]);
        while (y > y1) path.add(maze.myMaze[x][y--]);
        while (y < y1) path.add(maze.myMaze[x][y++]);
        //calculate heuristic using the path we made
        // (add 2 for MazeNodes of value 1, 1 for maze nodes of value 0)
        double myHueristic = 0;
        for (MazeNode i: path){
            myHueristic+=i.value+1;
        }
        return myHueristic;
    }

    // returns all the neighbors of a given node
    private static ArrayList<MazeNode>GetNeighbors(MazeNode current, Maze maze){
        ArrayList<MazeNode> neighbors = new ArrayList<>();
        //possible neighbors are top, bottom, left, right
        for (int x = current.x-1, y = current.y-1; x < current.x+2 && y < current.y+2; x+=2, y+=2){
            if (x >= 0 && x < maze.myMaze.length && maze.myMaze[x][current.y].value == 0){
                neighbors.add(maze.myMaze[x][current.y]);
            }
            if (y >= 0 && y < maze.myMaze[current.x].length && maze.myMaze[current.x][y].value == 0){
                neighbors.add(maze.myMaze[current.x][y]);
            }
        }
        return neighbors;
    }

    //Astar's shortest path algorithm
    static MazeNode AStar(Maze maze, Pair<Integer, Integer> start, Pair<Integer, Integer> end) {
        // return null if graph does not contain either start or end or either of them are walls
        MazeNode NOTFOUND = new MazeNode(-1, -1, -1);
        if (!ValidateEntries(start, end, maze)) {
            return NOTFOUND;
        }
        //A* algorithm
        PQ_ArrayList<MazeNode, Double> pq = new PQ_ArrayList<>();
        //set start cost to 0
        maze.myMaze[start.getKey()][start.getValue()].cost = 0;
        //add start node to pq with priority of heuristic
        pq.enqueue(maze.myMaze[start.getKey()][start.getValue()], heuristic(start, end, maze));
        //loop until pq is empty
        while(!pq.isEmpty()){
            //dequeue vertex w/ highest priority and set as visited
            MazeNode current = pq.dequeue();
            if(current.isSame(end)) return current;
            current.visited = true;
            //loop through all unvisited neighbors of current
            for(MazeNode i: GetNeighbors(current, maze)){
                double Cost = current.cost+1;
                if (!i.visited){
                    // if the new cost is less than the old cost update it and add it to the queue
                    if (Cost < i.cost){
                        i.prev = current;
                        i.cost = Cost;
                        pq.enqueue(i, Cost+heuristic(new Pair<>(i.x, i.y), end, maze));
                    }
                }
            }
        }

        return NOTFOUND;
    }
}
