package Interviews;

public class matrix {

    public static void printSpiral(int sizeX, int sizeY, int x, int y){

        if (sizeX > 0 && sizeY > 0){
            int i = 0;
            int j = 0;

            while (i < sizeX-1){
                System.out.println(i+x + ", " + (y+j));
                i++;
            }
            while (j < sizeY-1 ){
                System.out.println(i+x + ", " + (y+j));
                j++;
            }
            while (i > 0){
                System.out.println(i+x + ", " + (j+y));
                i--;
            }
            while (j > 0){
                System.out.println(i+x+", " + (j+y));
                j--;
            }
            printSpiral(sizeX-2, sizeY-2, x+1, y+1);
        }
    }

    public static void main(String args[]){
        printSpiral(4, 4, 0, 0);
    }
}
