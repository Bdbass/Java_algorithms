package Searching;
import javafx.util.Pair;

public class MazeNode {

    public int value;
    public double cost;
    public MazeNode prev;
    public int x;
    public int y;
    public boolean visited;

    MazeNode(int v, int x, int y){
        value = v;
        cost = Integer.MAX_VALUE;
        prev = null;
        this.x = x;
        this.y = y;
        visited = false;
    }
    public boolean isSame(Pair<Integer, Integer> Loc){
        if (x == Loc.getKey() && y == Loc.getValue()) return true;
        return false;
    }

}
