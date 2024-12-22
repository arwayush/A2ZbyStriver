package Step2.Sorting;

import java.util.Arrays;

public class BubbleSort {
    private static void bubble(int[] arr, int n){
        for (int i = n-1; i >= 0 ; i--) {
            int didSwap = 0;
            for (int j = 0; j <= i-1 ; j++) {
                if(arr[j] > arr[j+1]){
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                    didSwap = 1;
                }
            }
            if(didSwap == 0)
                break;
        }
    }
    public static void main(String[] args) {
        int[] arr = {1,4,63,2,4,7,964,2};
        int n = arr.length;
        bubble(arr, n);
        System.out.println(Arrays.toString(arr));
    }
}
/*
Bubble Sort -> It pushes the maximum to the last index by adjacent swapping, opposite to the selection sort
- in the bubble sort we will check the 2 adjacent numbers and put the bigger element in the 2nd number,
- we do this for whole array, check adjacent again and again and put the
- If the array is sorted already then it will not run,
T.C. -> n*(n+1) / 2 -> O(n^2) -> worst Case complexity
T.C. -> O(n) -> best case complexity, if none of the swaps took place


 */