package Step3.Easy;

import java.util.HashMap;
import java.util.Map;

public class LongestSubarrayWithSumKPosNeg {
//    The T.C. of this approach is O(n^3)
    protected static void Brute(int[] arr, int k){
        int n =arr.length;
        int len = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum = 0;
                for (int l= i; l <=j; l++) {
                    sum += arr[l];
                }
                if(sum ==k)
                    len = Math.max(len, j-i+1);
            }
        }
        System.out.println(len);
    }
//    The T.C. of the approach is O(n^2), which uses 2 nested loops
    protected static void Better(int[] arr, int k){
        int n = arr.length;
        int len = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];

                if(sum == k){
                    len = Math.max(len, j-i+1);
                }
            }
        }
        System.out.println(len);
    }
//    The T.C. of the app will be nearly O(n) or O(n*logn)
    protected static void Optimal(int[] arr, int k){
        int n = arr.length;
        Map<Integer, Integer> preSum = new HashMap<>();
        int sum = 0;
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];

            if(sum == k){
                maxLen = Math.max(maxLen, i+1);
            }
            //calc the sum of remaining part
            int rem = sum - k;
            if(!preSum.containsKey(sum)){
                preSum.put(sum, i);
            }
        }
        System.out.println(maxLen);
    }
    public static void main(String[] args) {
        int[] arr = {-1,1,1};
        int k = 1;
        Brute(arr, k);
        Better(arr, k);
        Optimal(arr, k);
    }
}
