package Step4.BSOnAnswers;

import java.util.Arrays;

public class AggressiveCows {
    public static boolean canWePlace(int[] arr, int dist, int cows){
        int n = arr.length;
        int cntCow = 1; // Place the first cow in the first stall
        int last = arr[0]; // Position of the last placed cow

        for (int i = 1; i < n; i++) {
            if (arr[i] - last >= dist) { // Place the next cow if the distance is sufficient
                cntCow++;
                last = arr[i];
            }
            if (cntCow >= cows) return true; // Successfully placed all cows
        }
        return false; // Not enough stalls to place all cows with the given distance
    }
    private static int Brute(int[] arr, int k){
        Arrays.sort(arr);
        int n = arr.length;
        int limit = arr[n-1] - arr[0];
        for (int i = 1; i <=limit; i++) {
            if(canWePlace(arr, i, k) == false){
                return (i-1);
            }
        }
        return limit;
    }

    private static int BS(int[] arr, int k){
        Arrays.sort(arr);
        int n = arr.length;
        int low = 1, high = arr[n-1] - arr[0];
        int ans = 1;
        while (low <= high){
            int mid = (low + high) / 2;
            if(canWePlace(arr, mid, k) == true){
                ans = mid;
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return  ans;
    }

    public static void main(String[] args) {
        int cows[] = {0,3,4,7,10,9};
        int nums = 4;
        int ans = Brute(cows, nums);
        System.out.println(ans);
        int ans2 = BS(cows, nums);
        System.out.println(ans2);
    }
}
