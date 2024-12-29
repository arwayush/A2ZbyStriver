//https://leetcode.com/problems/sort-colors/submissions/1491479413/
package Step3.Medium;

import java.util.Arrays;

public class SortingNumberswith012 {
//    This is the pre-built function which takes the O(n*logN)
    private static void Brute(int[] arr){
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
//  This will take nearly O(n) and good approach
    protected static void Better(int[] arr){
        int cnt0 = 0, cnt1 = 0, cnt2 = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if(arr[i] == 0) cnt0++;
            else if (arr[i] == 1) cnt1++;
            else cnt2++;
        }
        for (int i = 0; i < cnt0; i++) {
            arr[i] = 0;
        }
        for (int i = cnt0; i < cnt0+cnt1; i++) {
            arr[i] = 1;
        }
        for (int i = cnt0+cnt1; i < n; i++) {
            arr[i] = 2;
        }
        System.out.println(Arrays.toString(arr));

    }
//   Dutch National Flag Algorithm
    protected static void Optimal(int[] arr) {
        int n = arr.length;
        int low = 0, mid = 0, high = n - 1;
        while (mid <= high) {
            if (arr[mid] == 0) {
                // Inline swap to move 0 to the front
                int temp = arr[low];
                arr[low] = arr[mid];
                arr[mid] = temp;
                low++;
                mid++;
            } else if (arr[mid] == 1) {
                // Move mid pointer for 1
                mid++;
            } else {
                // Inline swap to move 2 to the end
                int temp = arr[mid];
                arr[mid] = arr[high];
                arr[high] = temp;
                high--;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
    public static void main(String[] args) {
        int[] arr = {2,0,2,1,1,0};
        Brute(arr);
        Better(arr);
        Optimal(arr);

    }
}
/*
Dutch National Flag Algo - This algorithm contains 3 pointers i.e. low, mid, and high, and 3 main rules.  The rules are the following:

arr[0….low-1] contains 0. [Extreme left part]
arr[low….mid-1] contains 1.
arr[high+1….n-1] contains 2. [Extreme right part], n = size of the array

The middle part i.e. arr[mid.....high] is the unsorted segment


Steps to Algo
1. if arr[mid] == 0 we will swap arr[low] and arr[mid] and increment the pointers
2. if arr[mid] == 1, we will increment the mid pointer and then index mid-1
3. if arr[mid] == 2, we will swap the arr[mid] and arr[high]
 */