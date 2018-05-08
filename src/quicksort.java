public class quicksort {
    // sorts based of middle pivot, good if we think the array is already partially sorted
    void sortMiddle(int array[], int low, int high){
        //Helps for visualizing the sorted array
            //printArray(array);
            //System.out.println("low"+low);
           //System.out.println("high"+high);

        //recursive case
        if (low < high){
            //partition the array
            int pos = partitionMiddle(array, low, high);
            //call sort on left and right partitions
            sortMiddle(array, low, pos-1);
            sortMiddle(array, pos, high);
        }
    }
    // seperated the array into a low and high partition, pivot is not necessarily right in the middle
    int partitionMiddle(int array[], int low, int high){
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
     void sortHigh(int array[], int low, int high){
        //recursive case
        if (low < high){
            //partition the array
            int pos = partitionHigh(array, low, high);
            //call sort on left and right partitions
            sortHigh(array, low, pos-1);
            sortHigh(array, pos+1, high);
        }
    }
    // puts smaller elements on left, larger on right,
    // returns position of the pivot
    int partitionHigh(int array[], int low, int high){
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
    void swap(int array[], int pos1, int pos2){
        int temp = array[pos1];
        array[pos1] = array[pos2];
        array[pos2] = temp;
    }

    //prints out the array
    static void printArray(int array[]){
        for (int i = 0; i < array.length; i++){
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }

    // main
    public static void main(String args[]){
        int array1[] = {34, 12, 56, 2, 77, 9, 0, -12, 13, 4, 2};
        int array3[] = {34, 12, 56, 2, 77, 9, 0, -12, 13, 4, 2};

        printArray(array1);

        quicksort ob = new quicksort();
        ob.sortHigh(array1, 0, array1.length-1);
        printArray(array1);

        printArray(array3);
        ob.sortMiddle(array3, 0, array3.length-1);
        printArray(array3);
    }
}
