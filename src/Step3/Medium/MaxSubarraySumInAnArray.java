package Step3.Medium;

public class MaxSubarraySumInAnArray {
//    The code with the T.C. of O(n^3), S.C. of O(1)
    protected static void Brute(int[] arr){
        int n = arr.length;
        int maxSum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum = 0;
                for (int k = i; k <=j; k++) {
                    sum += arr[k];
                }
                maxSum = Math.max(maxSum, sum);
            }
        }
        System.out.println(maxSum);
    }
//    A slightly better code with the T.C. of O(n^2) and S.C. of the O(1)
    protected static void Better(int[] arr) {
        int n = arr.length;
        int maxSum = Integer.MIN_VALUE; // Handles cases with all negative values
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j]; // Use cumulative sum instead of a separate loop
                maxSum = Math.max(maxSum, sum);
            }
        }
        System.out.println(maxSum);
    }
//    This is the best approach with the T.C. of O(n) and S.C. of the O(1)
    protected static void Kadane(int[] arr){
        int maxi  = Integer.MIN_VALUE;
        int sum = 0;
       for(int num : arr){
           sum += num;
           if(sum > maxi)
               maxi = sum;
           if(sum < 0)
               sum = 0;
       }
        System.out.println(maxi);
    }

    public static void main(String[] args) {
        int arr[] = {-2,1,-3,4,-1,2,1,-5,4};
        Brute(arr);
        Better(arr);
        Kadane(arr);

    }
}
/*
find the contiguous subarray which has the largest sum and returns its sum and prints the subarray.
Kadane Algorithm :-
 */