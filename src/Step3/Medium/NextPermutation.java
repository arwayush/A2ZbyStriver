package Step3.Medium;

import java.util.Arrays;
// Takes the T.C. of the O(3*N)
class Optimization{

    // Reverse part of the array between two indices
    public static void reverseArray(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    // Optimal function to find the next permutation
    public static void Optimal(int[] arr) {
        int n = arr.length;
        // Step 1: Find the breakpoint
        int ind = -1;
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] < arr[i + 1]) {
                ind = i;
                break;
            }
        }

        // Step 2: Handle the case where no breakpoint exists
        if (ind == -1) {
            reverseArray(arr, 0, n - 1);
            return; // Return since no further processing is needed
        }

        // Step 3: Find the next greater element and swap with arr[ind]
        for (int i = n - 1; i > ind; i--) {
            if (arr[i] > arr[ind]) {
                int temp = arr[i];
                arr[i] = arr[ind];
                arr[ind] = temp;
                break;
            }
        }

        // Step 4: Reverse the right half of the array
        reverseArray(arr, ind + 1, n - 1);
    }

}
public class NextPermutation {
    public static void main(String[] args) {
        int[] arr = {1,1,1,5,1};
        System.out.println("Original Array: " + Arrays.toString(arr));

        Optimization.Optimal(arr);

        System.out.println("Next Permutation: " + Arrays.toString(arr));
    }
}
