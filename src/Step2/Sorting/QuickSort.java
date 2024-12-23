package Step2.Sorting;

import java.util.Arrays;

public class QuickSort {
    private static int partition(int[] arr, int low, int high){
        int pivot = arr[low];
        int i = low;
        int j = high;

        while (i < j){
            while (arr[i] <= pivot && i <= high-1){
                i++;
            }
            while (arr[j] > pivot && j>= low+1){
                j--;
            }
            if(i<j){
               int temp = arr[i];
               arr[i] = arr[j];
               arr[j] = temp;
            }
        }
        int temp = arr[low];
        arr[low] = arr[j];
        arr[j] = temp;
        return  j;
    }

    private static void qs(int[] arr, int low, int high){
        if(low < high){
            int pIndex = partition(arr, low, high);
            qs(arr, low, pIndex - 1);
            qs(arr, pIndex + 1, high);
        }
    }
    public static void main(String[] args) {
        int[] arr = {3,5,7,42,4,68,85,22,4,79,4};
        qs(arr, 0, arr.length -1);
        System.out.println(Arrays.toString(arr));
    }
}
/*
Quick Sort :-

T.C. of the algo is O(n*logn)
S.C. is O(1)
 */