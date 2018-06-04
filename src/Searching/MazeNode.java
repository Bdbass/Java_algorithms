package Searching;

public class MazeNode {

    public int value;
    public int cost;
    public MazeNode prev;

    MazeNode(int v){
        value = v;
        cost = Integer.MAX_VALUE;
        prev = null;
    }

}
