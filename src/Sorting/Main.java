package Sorting;
import java.util.*;

public class Main {
    // main
    public static void main(String args[]){
        Main newMain = new Main();
        // creating two arrays, one for quickhigh to sort and one for quickmiddle to sort
        int array1[] = newMain.generateRandomArray();
        int array2[] = newMain.generateRandomArray();
        int array3[] = newMain.generateRandomArray();

        //creating quicksort object
        quicksort quick1 = new quicksort();

        // testing on high pivot
        System.out.println("Testing quicksort using high pivot\n");
        newMain.printArray(array1);
        quick1.sortHigh(array1);
        newMain.printArray(array1);

        //testing on middle pivot
        System.out.println("\nTesting quicksort using middle pivot\n");
        newMain.printArray(array2);
        quick1.sortMiddle(array2);
        newMain.printArray(array2);

        //test on merge sort
        System.out.println("\nTesting quicksort using middle pivot\n");
        MergeSort myMerg = new MergeSort();
        newMain.printArray(array3);
        myMerg.mergeSort(array3);
        newMain.printArray(array3);
    }

    // generates random array of size n with numbers 1-100
    private int[] generateRandomArray(){

        //grab the size of the array from the user
        Scanner input = new Scanner(System.in);
        System.out.println("Enter array size: ");
        int n = input.nextInt();

        // make an array to hold the random numbers, make a random variable
        int newArray[] = new int[n];
        Random myRand = new Random();

        //add n random values to array
        for (int i = 0; i < n; i++){
            newArray[i] = myRand.nextInt(100);
        }

        return newArray;
    }

    //prints out the array
    private void printArray(int array[]){
        for(int i: array){
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }
}
