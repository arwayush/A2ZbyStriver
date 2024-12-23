package Step2.Sorting;

import java.util.Arrays;

public class InsertionSortRecursion {
    private static void ISR(int[] arr,int i, int n){
        if( i== n) return; //base case
        int j = i;
        while (j > 0 && arr[j-1] > arr[j]){
            int temp = arr[j-1];
            arr[j-1] = arr[j];
            arr[j] =temp;
            j--;
        }

        ISR(arr, i+1, n);
    }
    public static void main(String[] args) {
        int[] arr = {10,45,3,24,675,3,24,6,3,24,6,8};
        int n = arr.length;
        ISR(arr,0, n);
        System.out.println(Arrays.toString(arr));
    }
}
