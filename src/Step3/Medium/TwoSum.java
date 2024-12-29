package Step3.Medium;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
//    The T.C. of this is the O(n^2)
    private static void Brute(int[] arr, int target){
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if(i == j) continue;
                if(arr[i] + arr[j] == target)
                    System.out.println(i+ " & " +j);
            }
        }
    }
//   This will run with the T.C. of the O(n * logn) and the S.C. of the O(n)
    private static void Hashing(int[] arr, int target){
        HashMap<Integer, Integer> mp = new HashMap<>();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int temp = arr[i];
            int rem = target - temp;
            if(mp.containsKey(rem)){
                System.out.println(i+ " and " +mp.get(rem));
            }
            mp.put(arr[i], i);
        }
    }

    private static void Optimal(int[] arr, int target){
        int n = arr.length;
        int left = 0, right = n - 1;
        Arrays.sort(arr);

        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == target) {
                System.out.println(arr[left] + " + " + arr[right]);
                left++;  // Move forward to look for other pairs
                right--; // Move backward to avoid infinite loop
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }

    }
    }

    public static void main(String[] args) {
        int[] arr = {2,6,5,8,11};
        int target = 14;
//        Brute(arr, target);
//        Hashing(arr, target);
        Optimal(arr, target);
    }
}
