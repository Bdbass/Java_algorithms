package Sorting;

public class quicksort {

    // main sortMiddle
    void sortMiddle(int arr[]){
        sortMiddleHelper(arr, 0, arr.length-1);
    }
    // sorts based of middle pivot, good if we think the array is already partially sorted
    private void sortMiddleHelper(int array[], int low, int high){
        //Helps for visualizing the sorted array
            //printArray(array);
            //System.out.println("low"+low);
           //System.out.println("high"+high);

        //recursive case
        if (low < high){
            //partition the array
            int pos = partitionMiddle(array, low, high);
            //call sort on left and right partitions
            sortMiddleHelper(array, low, pos-1);
            sortMiddleHelper(array, pos, high);
        }
    }
    // seperated the array into a low and high partition, pivot is not necessarily right in the middle
    private int partitionMiddle(int array[], int low, int high){
        int pivot = array[(low+high)/2];
        while(low <= high){
            while(array[low] < pivot) low++;
            while(array[high] > pivot) high--;
            if (low <= high){
                swap(array, low, high);
                low++; 
                high--; 
            }
        }
        return low;
    }

    //Main sort high function
    void sortHigh(int arr[]){
        sortHighHelper(arr, 0, arr.length-1);
    }

    // Quicksorts using highest index as pivot
    private void sortHighHelper(int array[], int low, int high){
        //recursive case
        if (low < high){
            //partition the array
            int pos = partitionHigh(array, low, high);
            //call sort on left and right partitions
            sortHighHelper(array, low, pos-1);
            sortHighHelper(array, pos+1, high);
        }
    }
    // puts smaller elements on left, larger on right,
    // returns position of the pivot
    private int partitionHigh(int array[], int low, int high){
        //assign pivot to the last element in array
        int pivot = array[high];
        //assign i with the index of the smallest element
        int i = low;
        //loop to put all smaller elements on the left and larger on the right
        for (int j = low; j < high; j++){
            //if element is smaller, put it on the left
            if (array[j] <= pivot){
                swap(array, j, i);
                i++;
            }
        }
		/* since we went to high-1(our pivot position) we need
		to put the pivot in the correct location */
        swap(array, i, high);
        // i is the location of our pivot now, so return it
        return i;
    }

    // swaps two positions in an array
    private void swap(int array[], int pos1, int pos2){
        int temp = array[pos1];
        array[pos1] = array[pos2];
        array[pos2] = temp;
    }

}
