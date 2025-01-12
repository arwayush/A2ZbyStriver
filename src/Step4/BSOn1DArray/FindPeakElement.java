package Step4.BSOn1DArray;

import java.util.Optional;

public class FindPeakElement {
    private static int Brute(int[] arr){
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if((i == 0 || arr[i-1] < arr[i]) && (i == n-1 || arr[i+1] < arr[i])){
                return i;
            }
        }
        return -1;
    }
    private static int Optimal(int[] arr){
        int n = arr.length;
        //edge cases
        if( n== 1) return 0;
        if(arr[0] > arr[1]) return 0;
        if(arr[n-1] > arr[n-2]) return n-1;

        int low = 1, high = n-2;
        while (low <= high) {
            int mid = (low + high) / 2;

            // If arr[mid] is the peak:
            if (arr[mid - 1] < arr[mid] && arr[mid]> arr[mid+1])
                return mid;

            // If we are in the left:
            if (arr[mid] > arr[mid - 1]) low = mid + 1;

                // If we are in the right:
                // Or, arr[mid] is a common point:
            else high = mid - 1;
        }
        // Dummy return statement
        return -1;

    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7,8,5,1};
        System.out.println("Solution from the Brute Force is: "+Brute(arr));
        System.out.println("Solution from the Brute Force is: "+ Optimal(arr));

    }
}
