package Step3.Easy;

import java.util.Arrays;

public class LongestSubarrayWithSumKPositives {
//    The Time complexity of this Code is nearly O(n^3)
    private static void Solution1(int[]arr, int n, long sum){
        int len = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int s=0;
                for (int k = i; k <=j ; k++) {
                    s += arr[k];
                }
                if(s == sum)
                    len = Math.max(len, j-i+1);
            }
        }
        System.out.println(len);
    }
//    The T.C. of this approach is very improved and is nearly O(n^2)
    private static void Solution2(int[] arr, int n, long sum){
        int len = 0;
        for (int i = 0; i < n; i++) {
            long s = 0;
            for (int j = 0; j < n; j++) {
                s += arr[j];
                if(s == sum)
                    len = Math.max(len, j-i+1);
            }
        }
        System.out.println(len);
    }
//   The t.c. of this app will be the o(n * logn)
    private static void Solution3(int[] arr, int n, long sum){
        int[] prefixSum = new int[n];
        for (int i = 0; i < n; i++) {
            prefixSum[i] = prefixSum[i-1] + arr[i];
        }
        System.out.println(Arrays.toString(prefixSum));
    }

//   Works well with the +ve numbers and zeroes, T.C. O(2n), S.C. O(1)
    private static void Solution4(int[] arr, int n, long sum){
        int left = 0, right  = 0;
        long s = arr[0];
        int maxlen = 0;
        while (right  < n){
            while (left <=  right && s > sum){
                s -= arr[left];
                left++;
            }
            if(s == sum){
                maxlen =  Math.max(maxlen, right-left+1);
            }
            right++;
            if (right < n ) s+= arr[right];
        }
        System.out.println(maxlen);
    }

    public static void main(String[] args) {
        int[] arr = {2,3,5,1,9};
        int n = arr.length;
//        Solution1(arr, n, 10);
//        Solution2(arr, n, 10);
//        Solution3(arr, n, 10);
        Solution4(arr, n, 10);
    }
}
