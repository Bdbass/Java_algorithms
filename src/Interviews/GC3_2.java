package Interviews;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class GC3_2 {

    //driver function
    public static void main(String args[]){
        int[][] map = {{0, 1, 1, 0}, {0, 0, 0, 1}, {1, 1, 0, 0}, {1, 1, 1, 0}};
        //int [][] map = {{0, 0, 0, 0, 0, 0}, {1, 1, 1, 1, 1, 0}, {0, 0, 0, 0, 0, 0}, {0, 1, 1, 1, 1, 1}, {0, 1, 1, 1, 1, 1}, {0, 0, 0, 0, 0, 0}};
        System.out.println(answer(map));
    }
    public static int answer(int[][] maze){
        //create two maps, one for A* start-> finish and one for the A* finish-> start
        Node[][] mapA = createMap(maze);
        Node[][] mapB = createMap(maze);

        //saves the distance returned by A*
        int distance = aStar(0, 0, maze[0].length-1, maze.length-1, mapA);
        //updates the distance if a shorter route is found by breaking down a wall
        distance = reverseAStar(maze[0].length-1, maze.length-1, 0, 0, mapA, mapB, distance);
        return distance;
    }
    //follows A* search algorithm, returns smallest route distance
    private static int aStar(int x1, int y1, int x2, int y2, Node[][] map){

        //creates a pq with first element being map[0][0]
        PriorityQueue<Node> pq = createPq(1 + manhattanDistance(x1, y1, x2, y2), map[x1][y1]);

        //search for exit, until it is found or all avenues were searched
        while (!pq.isEmpty()){
            //pop element off of pq, set to visited
            Node current_node = pq.poll();
            current_node.setVisited(true);

            // if we found the node we're searching for return its cost
            if (current_node.getX() == x2 && current_node.getY() == y2) return current_node.getCost();

            //add all unvisited neighbors to pq
            for(Node neighbor : createNeighborList(current_node, map)){
                //if we found a shorter path, update cost
                updateCost(x2, y2, pq, current_node, neighbor);
            }

        }
        //if no route was found, return max val
        return Integer.MAX_VALUE;
    }
    //Prepares a pq with map[0][0] for the A* search
    private static PriorityQueue<Node> createPq(int priority, Node node) {
        //set start location to cost of 1, and priority to manhattan dist. + 1
        node.setCost(1);
        node.setPriority(priority);

        //create pq and add start to pq
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(node);
        return pq;
    }
    //follows A* search algorithm but from finish -> start, looks for shortcuts as well
    private static int reverseAStar(int x1, int y1, int x2, int y2, Node[][] map_A, Node[][] map_B, int distance){

        //create pq for A_Star
        PriorityQueue<Node> pq = createPq(1 + manhattanDistance(x1, y1, x2, y2), map_B[x1][y1]);

        //search for end, until it is found or all avenues were searched
        while (!pq.isEmpty()){
            //pop element off of pq, set to visited
            Node current_node = pq.poll();
            current_node.setVisited(true);

            //bridge check
            distance = bridgeCheck(map_A, current_node, distance);

            // if we found the node we're search for return its cost
            if (current_node.getX() == x2 && current_node.getY() == y2) return distance;

            //add all unvisited neighbors to pq
            for(Node neighbor : createNeighborList(current_node, map_B)){
                updateCost(x2, y2, pq, current_node, neighbor);
            }
        }
        return distance;
    }
    //looks for bridges(shortcuts) i.e. 010
    private static int bridgeCheck(Node[][] map, Node n, int distance){
        int x = n.getX();
        int y = n.getY();
        int cost;

        /*
            Each direction is looking for a bridge, a 010, where the rightmost/leftmost/topmost zero has been searched
            by the first A* search, and the bridge creates a shortcut that decreases the distance from start-> finish
         */

        //right
        if (x + 2 < map.length && map[x+1][y].isWall() && !map[x+2][y].isWall() && map[x+2][y].isVisited()){
            cost = map[x+2][y].getCost()+1+n.getCost();
            distance = cost < distance ? cost : distance;
        }
        //left
        if (x - 2  >= 0 && map[x-1][y].isWall() && !map[x-2][y].isWall() && map[x-2][y].isVisited()){
            cost = map[x-2][y].getCost()+1+n.getCost();
            distance = cost < distance ? cost: distance;
        }
        //top
        if (y - 2 >= 0 && map[x][y-1].isWall() && !map[x][y-2].isWall() && map[x][y-2].isVisited()){
            cost = map[x][y-2].getCost()+1+n.getCost();
            distance = cost < distance ? cost: distance;
        }
        return distance;
    }
    // Updates a node's cost if need be, and inserts it back into pq
    private static void updateCost(int x2, int y2, PriorityQueue<Node> pq, Node current_node, Node neighbor) {
        int cost = current_node.getCost()+1;

        //if the new cost is lower, update neighbor and update its status in pq
        if (cost < neighbor.getCost()){
            neighbor.setCost(cost);

            //if it was already in the pq, remove it and add it w/ new cost
            if(pq.contains(neighbor)) pq.remove(neighbor);
            neighbor.setPriority(cost+manhattanDistance(neighbor.getX(), neighbor.getY(), x2, y2));
            pq.add(neighbor);

        }
    }
    //returns a list of unvisited neighbors
    private static ArrayList<Node> createNeighborList(Node n, Node[][] map){
        ArrayList<Node> neighbor_list = new ArrayList<>();
        int x = n.getX();
        int y = n.getY();
        // add cardinal neighbors to list
        for (int i = -1; i < 2; i+=2){
            if (x+i >= 0 && x+i < map.length && !map[x+i][y].isVisited() && !map[x+i][y].isWall()) neighbor_list.add(map[x+i][y]);
            if (y+i >= 0 && y+i < map[x].length && !map[x][y+i].isVisited() && !map[x][y+i].isWall()) neighbor_list.add(map[x][y+i]);
        }
        return neighbor_list;
    }
    //returns a 2-dim node array of size w x l, also reverses orientation of array, x <-> y
    private static Node[][] createMap(int[][] m){
        int w = m.length;
        int l = m[0].length;

        Node[][] map = new Node[l][w];
        for (int i = 0 ; i < w; i++){
            for (int j = 0; j < l; j++){
                map[j][i] = m[i][j] == 0 ? new Node(j, i, false) : new Node(j, i, true);
            }
        }
        return map;
    }
    //returns the manhat. distance between a coordinate pair (heuristic)
    public static int manhattanDistance(int x1, int y1, int x2, int y2){
        //calculate distance between points
        int x = x2 - x1;
        int y = y2 - y1;
        //take abs value of points
        x = x > 0 ? x: -x;
        y = y > 0? y: -y;
        return x+y;
    }
}

//represents a node of the map
class Node implements Comparable<Node>{

    private int cost;
    private int priority;
    private boolean visited;
    private boolean wall;
    private int x;
    private int y;

    Node (){
        cost = Integer.MAX_VALUE;
        priority = Integer.MAX_VALUE;
        visited = false;
        x = -1;
        y = -1;
        wall = true;
    }
    Node (int x, int y, boolean wall){
        cost = Integer.MAX_VALUE;
        priority = Integer.MAX_VALUE;
        visited = false;
        this.x = x;
        this.y = y;
        this.wall = wall;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public boolean isWall() {
        return wall;
    }

    public void setWall(boolean wall) {
        this.wall = wall;
    }

    @Override
    public int compareTo(Node n) {
        if (this.getCost() > n.getCost()) return 1;
        return -1;
    }
}

