package Sorting;

public class MergeSort {
    void mergeSort(int arr[]){
        mSort(arr, 0, arr.length-1);
    }

    private void mSort(int arr[], int left, int right){
        if ( right > left){
            // split array in half
            int middle = (left+right)/2;
            // call merge sort on left
            mSort(arr, left, middle);
            //call merge sort on right
            mSort(arr, middle+1, right);
            //merge the two together
            merge(arr, left , middle , right);
        }
    }
    private void merge(int arr[], int l, int m, int r){
        // create temp arrays so we can merge them
        int size1 = m-l+1;
        int size2 = r-m;
        int arr1[] = new int[size1];
        int arr2[] = new int[size2];

        // fill temp array one with l to m values
        for (int i = 0; i < size1; i++){
            arr1[i] = arr[i];
        }
        //fill temp array two with m to r values
        for (int i = m; i < size2; i++){
            arr2[i] = arr[i];
        }
        // merge arrays back together
        int s = l; // the start of arr
        int s1 = 0; // the start of arr1
        int s2 = m; // the start of arr2

        // while neither array is empty start
        // putting them back together from smallest->largest
        while (s1 < size1 && s2 < size2){
            if (arr1[s1] < arr2[s2]) {
                arr[s++] = arr1[s1++];
            }else {
                arr[s++] = arr2[s2++];
            }
        }
        // if s1 is still < size1 add the rest to the end of arr
        while (s1 < size1){
            arr[s++] = arr1[s1++];
        }
        // likewise for s2
        while(s2 < size2){
            arr[s++] = arr2[s2++];
        }
    }
}
