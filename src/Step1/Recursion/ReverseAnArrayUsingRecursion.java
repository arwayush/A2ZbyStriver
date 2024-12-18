package Step1.Recursion;

import java.util.Arrays;

public class ReverseAnArrayUsingRecursion {

    //function to reverse the array with the one variable only
    private static void fun(int i, int[]arr, int n){
        //base case
        if(i >= n/2) return;

        //swapping the array
        int temp = arr[i];
        arr[i] = arr[n-i-1];
        arr[n-i-1] = temp;

        //recursive calling the ffunction
        fun(i+1, arr, n);

    }

    //function to reverse array using 2 variables
    private static void func(int[] arr, int start, int end){
        //base condi
        if(start >=  end)
            return;

        //swappin the element
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;

        //recursive call
        func(arr, start+1, end-1);
    }

    //main function
    public static void main(String[] args) {
        int[] arr = {2,3,4,5,6,6};
        int n = arr.length;
//        fun(0, arr, n);
        int start = 0;
        int end = n-1;
        func(arr, start, end);
        System.out.println(Arrays.toString(arr));
    }
}
