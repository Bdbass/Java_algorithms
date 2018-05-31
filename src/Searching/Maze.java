package Searching;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Maze {
    //2-D int array representing a maze
    // 0's are open spaces, 1's are walls
    int[][] myMaze;

    //constructor
    public Maze(String fileName){
        CreateMaze(fileName);
    }
    //creates maze based off a file
    public void CreateMaze(String fileName){
        String s;
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))){
            s = br.readLine();
            int rows = Integer.parseInt(s);
            int cols = Integer.parseInt(s.substring(1));
            myMaze = new int[rows][cols];
            int currentCol = 0;
            while((s = br.readLine()) != null){
                System.out.println(s);
                ParseLine(s, currentCol++);
            }
        }catch(IOException exc){
            System.out.println("I/O Error: "+exc);
        }
    }
    private void ParseLine(String line, int col){
        for (int i = 0; i < line.length(); i++) {
            myMaze[i][col] = (int)line.charAt(i);
        }
    }
}
