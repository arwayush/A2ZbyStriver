package Step3.Easy;

import java.util.HashMap;
import java.util.Iterator;

public class MissingNumberInArray {
    // Run a loop from 1 to n, the T.C. of this approach is O(n^2)
    private static void brute(int[] arr, int n) {
        // Outer loop from 1 to n
        for (int i = 1; i <= n; i++) {
            int flag = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == i) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                System.out.println(i);
            }
        }
    }
//In this approach we need to give the n as the largest element in the array, then it will be possible to create a hash array for that
    private static void hashArr(int[] arr, int n){
        int[] hash = new int[n+1];
        for (int i = 0; i <arr.length; i++) {
            hash[arr[i]]++;
        }
        for (int i = 1; i <=n; i++) {
            if(hash[i] == 0){
                System.out.println(i);
            }
        }

    }
// Not good approach as it can only find the 1 number missing, but good in T.C. which is O(n)
    private static void Summation(int[] arr){
        int n = 8;
        int sum_of_first_N_nums = (n*(n+1))/2;
        int sum_of_total_nums_of_arr = 0;
        for (int i = 0; i < n - 1; i++) {
            sum_of_total_nums_of_arr += arr[i];
        }
        int diff = sum_of_first_N_nums - sum_of_total_nums_of_arr;
        System.out.println(diff);
    }
// Not good approach as it can only find the 1 number missing, but good in T.C. which is O(n)
    private static void Xor(int[] arr){
        int n= 8;
        int xor1 = 0, xor2 = 0;
        for (int i = 0; i < n-1; i++) {
            xor2 = xor2 ^ arr[i];
            xor1 = xor1 ^ (i+1);
        }
        xor1 = xor1 ^ n;
        System.out.println(xor1 ^ xor2);
    }


    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 5, 6, 7, 8};
        int n = 10; // Total range endpoint
//        brute(arr, n);
//        hashArr(arr, n);
//        Summation(arr);
        Xor(arr);

    }
}
