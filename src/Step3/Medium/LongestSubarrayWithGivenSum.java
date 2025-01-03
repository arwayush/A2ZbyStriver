package Step3.Medium;

import java.util.HashMap;

public class LongestSubarrayWithGivenSum {
//    The T.C. of this code is nearly equals to O(n^2), and S.C. is equal to O(1)
    private static void Brute(int[] arr, int k){
        int count = 0, n = arr.length;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                if(sum == k){
                    count++;
                }
            }
        }
        System.out.println(count);
    }
//   The T.C. of this will be nearly equals to O(n) or O(n*logN)
    private static void Optimal(int[] arr, int k){
        int n = arr.length, preSum = 0, cnt = 0;
        HashMap<Integer, Integer> mp = new HashMap<>();
        mp.put(0, 1);
        for (int i = 0; i < n; i++) {
            //adding the curr element to the preSum
            preSum += arr[i];
            //calc x-k'
            int remove = preSum - k;
            // Add the number of the subarrays to be removed
            cnt += mp.getOrDefault(remove, 0);
            //update the count of prefix sum in the map
            mp.put(preSum, mp.getOrDefault(preSum, 0) + 1);
        }
        System.out.println(cnt);

    }


    public static void main(String[] args) {
        int [] arr = {3, 1, 2, 4};
        int k = 6;
        Brute(arr, k);
        Optimal(arr, k);
    }
}
