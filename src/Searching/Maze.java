package Searching;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Maze {
    //2-D int array representing a maze
    // 0's are open spaces, 1's are walls
    MazeNode[][] myMaze;

    //constructor
    public Maze(String fileName){
        CreateMaze(fileName);
    }
    //creates maze based off a file
    public void CreateMaze(String fileName){
        String s;
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))){
            s = br.readLine();
            String[] _s = s.split(" ");
            int x = Integer.parseInt(_s[0]);
            int y = Integer.parseInt(_s[1]);
            myMaze = new MazeNode[x][y];
            int currentY = 0;
            while((s = br.readLine()) != null){
                //System.out.println(s);
                ParseLine(s, currentY++);
            }
        }catch(IOException exc){
            System.out.println("I/O Error: "+exc);
        }
    }
    private void ParseLine(String line, int currentY){
        for (int i = 0; i < myMaze.length; i++) {
            myMaze[i][currentY] = new MazeNode(Integer.parseInt(line.substring(i, i+1)), i, currentY);
        }
    }
    public void PrintMaze(){
        for (int y = 0; y < myMaze[0].length; y++) {
            for (int x = 0; x < myMaze.length; x++){
                System.out.print(myMaze[x][y].value+" ");
            }
            System.out.println();

        }
    }
}
