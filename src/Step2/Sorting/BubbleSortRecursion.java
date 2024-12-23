package Step2.Sorting;

import java.util.Arrays;

public class BubbleSortRecursion {
    private static void BSR(int[] arr, int n){
        //Base condition
        if(n==1) return;
        int doSwap = 0;
        for (int i = 0; i <= n-2; i++) {
            if(arr[i] > arr[i+1]){
                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
                doSwap = 1;
            }
        }
        if(doSwap == 0) return;
        BSR(arr, n-1);
    }
    public static void main(String[] args) {
        int[] arr = {1,3,5,7,32,5,77,43,65};
        int n = arr.length;
        BSR(arr, n);
        System.out.println(Arrays.toString(arr));
    }
}



/*
Basically The time complexity goes to the T.C. of O(n^2)
S.C. -> O(n) Recursion stack spac


If the array is already sorted, then we need to reduce the T.C. by not going for the function call
 */