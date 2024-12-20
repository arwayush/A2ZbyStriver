package Step1.Recursion;
import java.util.*;
public class SubsequenceWithTheSumNRecursionOnly1ValuePrint {

    //function to call the vale
    private static boolean func(int ind, ArrayList<Integer> ls, int s, int sum, int[] arr, int n) {
        if (ind == n) {
            if (s == sum) {
                System.out.println(ls); // Print the first valid subsequence
                return true; // Return true to stop further recursion
            }
            return false; // Continue recursion if no valid subsequence is found
        }

        // Include the current element
        ls.add(arr[ind]);
        s += arr[ind];
        if (func(ind + 1, ls, s, sum, arr, n)) {
            return true; // Stop recursion if a valid subsequence is found
        }

        // Backtrack and exclude the current element
        s -= arr[ind];
        ls.remove(ls.size() - 1);
        if (func(ind + 1, ls, s, sum, arr, n)) {
            return true; // Stop recursion if a valid subsequence is found
        }

        return false; // No valid subsequence found in this branch
    }
    public static void main(String[] args) {
        ArrayList<Integer> ls = new ArrayList<>();
        int[] arr = {1, 2, 1};
        int sum = 2;
        int n = arr.length;

        // Call the function
        func(0, ls, 0, sum, arr, n);
    }
}
