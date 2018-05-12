package Sorting;
import java.util.*;

public class Main {
    // main
    public static void main(String args[]){
        //grab the size of the array from the user
        Scanner input = new Scanner(System.in);
        System.out.println("Enter array size: ");
        int n = input.nextInt();

        // creating two arrays, one for quickhigh to sort and one for quickmiddle to sort
        int array1[] = generateRandomArray(n);
        int array2[] = generateRandomArray(n);
        int array3[] = generateRandomArray(n);

        //creating quicksort object
        quicksort quick1 = new quicksort();

        // testing on high pivot
        System.out.println("\nTesting quicksort using high pivot\n");
        printArray(array1);
        quick1.sortHigh(array1);
        printArray(array1);

        //testing on middle pivot
        System.out.println("\nTesting quicksort using middle pivot\n");
        printArray(array2);
        quick1.sortMiddle(array2);
        printArray(array2);

        //test on merge sort
        System.out.println("\nTesting Merge sort\n");
        MergeSort myMerg = new MergeSort();
        printArray(array3);
        myMerg.mergeSort(array3);
        printArray(array3);
    }

    // generates random array of size n with numbers 1-100
    static int[] generateRandomArray(int n){

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
    static void printArray(int array[]){
        for(int i: array){
            System.out.print(i+" ");
        }
        System.out.println();
    }
}
