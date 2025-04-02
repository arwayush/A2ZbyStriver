package Step7;

import java.util.Arrays;

public class ReverseArrayRecursion {
    private static void reverseUsingSinglePointer(int[] arr, int i,  int n){
        if (i >= n/2) return;
        int temp = arr[i];
        arr[i] = arr[n-i-1];
        arr[n-i-1] = temp;
        reverse(arr, i+1,  n);
    }
    private static void reverse(int[] arr, int low, int high){
        if (low >= high) return; // base condition
        int temp = arr[low];
        arr[low] = arr[high];
        arr[high] = temp;
        reverse(arr, low+1, high-1); //recursive call
    }
    public static void main(String[] args) {
        int[] arr = {3,5,6,8,5,3,24,6,7,53,90};
        int low = 0, high = arr.length;
        reverse(arr, low, high-1);
        System.out.println(Arrays.toString(arr));
    }
}
/*
Using 2 pointers for the reversing of the array in the recursion
 */