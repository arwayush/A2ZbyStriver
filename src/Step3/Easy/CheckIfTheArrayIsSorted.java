package Step3.Easy;

import java.util.Arrays;

public class CheckIfTheArrayIsSorted {
//    This approach takes the O(n^2) to check if the array is sorted or not
    private static boolean brute(int[] arr){
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[i])
                    return false;
            }
        }
        return true;
    }
//    most basic yet optimized approach and it takes O(n)
    private static boolean check(int[] arr){
        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            if(arr[i] > arr[i+1])
                return false;
        }
        return true;
    }
//    The time waste approach, but it takes T.C. of O(n+n) i.e. O(n)
    private static boolean timeWasteApp(int[] arr){
        int  n = arr.length;
        int[] copy = Arrays.copyOf(arr, n); //O(n)
        for (int i = 0; i < n; i++) { //O(n)
            if(arr[i] != copy[i])
                return false;
        }
        return true;
    }


    public static void main(String[] args) {
        int[] arr = {1,4,7,8,9,52};
        System.out.println(brute(arr));
        System.out.println(check(arr));
        System.out.println(timeWasteApp(arr));
    }
}




/*
There is a special case in the leetcode problem, which is the rotation of the array
class Solution {
    public boolean check(int[] arr) {
        int n = arr.length;
        int countBreaks = 0;

        for (int i = 0; i < n; i++) {
            // Check if the current element is smaller than the previous element
            if (arr[i] < arr[(i - 1 + n) % n]) {
                countBreaks++;
            }
            // More than one break means it's not sorted and rotated
            if (countBreaks > 1) {
                return false;
            }
        }

        return true;
    }
}

 */