package Step4.BSOnAnswers;

public class KthMissingPositiveNumber {

    private static void Brute(int[] arr, int k) {
        int count = 0, curr = 1, idx = 0;
        while (true) {
            if (idx < arr.length && arr[idx] == curr) {
                idx++;
            } else {
                count++;
                if (count == k) {
                    System.out.println(curr); // Print the k-th missing number
                    return; // Exit the method
                }
            }
            curr++;
        }
    }

    // Binary Search Method and takes the T.C. of O(logN)
    private static int BS(int[] arr, int k) {
        int n = arr.length;
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int missing = arr[mid] - (mid + 1); // Missing count up to mid
            if (missing < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return k + high + 1;
    }

    public static void main(String[] args) {
        int vec[] = {4, 7, 9, 10};
        int k = 1;

        // Brute Force Method
        Brute(vec, k);

        // Binary Search Method
        int ans = BS(vec, k);
        System.out.println(ans);
    }
}
