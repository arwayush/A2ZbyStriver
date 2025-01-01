package Step3.Medium;

import java.util.Arrays;
import java.util.HashSet;

public class LongestConsecutiveSequenceInArray {
    private static boolean linearSearch(int[] arr, int num){
        int n =arr.length;
        for (int i = 0; i < n; i++) {
            if(arr[i] == num)
                return true;
        }
        return false;
    }
//    This approach takes nearly O(n^2)
    protected static void Brute(int[] arr){
        int n = arr.length;
        int longest = 1;
        for (int i = 0; i < n; i++) {
            int x = arr[i];
            int cnt = 1;
            while (linearSearch(arr, x+1) == true){
                x += 1;
                cnt += 1;
            }
            longest = Math.max(longest, cnt);
        }
        System.out.println(longest);
    }
//    This is the O(n*logN), in this array gets distorted
    protected static void Better(int[] arr){
        Arrays.sort(arr);
        int longest = 1, cnt = 0, lastSmaller = Integer.MIN_VALUE, n = arr.length;
        for (int i = 0; i < n; i++) {
            if(arr[i]-1 == lastSmaller){
                cnt += 1;
                lastSmaller = arr[i];
            } else if (lastSmaller != arr[i]) {
                cnt = 1;
                lastSmaller = arr[i];
            }
            longest = Math.max(longest, cnt);
        }
        System.out.println(longest);
    }

     protected static void Optimal(int[] arr){
        int n = arr.length;
        if( n == 0) System.out.println(0);
        int longest = 1;
        HashSet<Integer> st = new HashSet<>();
         for (int i = 0; i < n; i++) {
             st.add(arr[i]);
         }
      // find the longest sequence
      for(int it :st){
          if(!st.contains(it-1)){
              int cnt = 1;
              int x = it;
              while (st.contains(x+1)){
                  x = x + 1;
                  cnt += 1;
              }
              longest = Math.max(longest, cnt);
          }
      }
         System.out.println(longest);

     }
    public static void main(String[] args) {
        int[] arr = {100, 200, 1, 3, 2, 4, 0};
        Brute(arr);
        Better(arr);
        Optimal(arr);
    }
}
