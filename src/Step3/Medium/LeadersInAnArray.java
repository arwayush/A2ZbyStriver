package Step3.Medium;

import java.util.*;
public class LeadersInAnArray {
//    This approach will take the Time Complexity of O(n^2)
    private static void Brute(int[] arr){
        int n =arr.length;
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            boolean flag = true;
            for (int j = i+1; j < n; j++) {
               if(arr[j] > arr[i]){
                   flag = false;
                   break;
               }
            }
            if(flag){
                ans.add(arr[i]);
            }
        }
        System.out.println(ans);
    }
//    In this approach we will traverse from the back to the front and keep a max variable and whosoever is greater than the max, will be our answer and we will add that to our ans array
//    Takes only a single iteration, i.e. O(n)
    private static void Optimized(int[] arr){
        ArrayList<Integer> ans = new ArrayList<>();
        int n = arr.length;
        int max = arr[n-1];
        ans.add(arr[n-1]);
        for(int i = n-2; i>=0; i--){
            if(arr[i] > max){
                ans.add(arr[i]);
                max  = arr[i];
            }
        }
        System.out.println(ans);
    }
    public static void main(String[] args) {
        int[] arr = {10, 22, 12, 3, 0, 6};
        Brute(arr);
        Optimized(arr);
    }
}
