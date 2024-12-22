package Step2.Sorting;

import java.util.Arrays;

public class InsertionSort {
    private static void insert(int[] arr, int n){
        for (int i = 0; i <=n-1; i++) {
            int j = i;
            while (j > 0 && arr[j-1] > arr[j]){
                int temp = arr[j-1];
                arr[j-1] = arr[j];
                arr[j] = temp;

                j--;
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {1,2,4,53,900,5,64,3,3,67,74};
        int n = arr.length;
        insert(arr, n);
        System.out.println(Arrays.toString(arr));
    }
}


/*
Insertion sort -> always takes the element and places at its correct order
T.C. -> it will be n * (n+1) / 2 -> O(n^2) -> worst case
Best case will be -> O(n)

 */
