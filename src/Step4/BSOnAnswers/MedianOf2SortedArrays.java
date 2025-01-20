package Step4.BSOnAnswers;

import java.util.ArrayList;

public class MedianOf2SortedArrays {

    // Brute Force: The T.C. is O(n + m), and the S.C. O(n1+n2)
    private static int BruteForce(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;
        ArrayList<Integer> arr3 = new ArrayList<>();
        int i = 0, j = 0;

        // Merge both arrays into one sorted array
        while (i < n && j < m) {
            if (arr1[i] < arr2[j]) arr3.add(arr1[i++]);
            else arr3.add(arr2[j++]);
        }
        while (i < n) arr3.add(arr1[i++]); // Add remaining elements of arr1
        while (j < m) arr3.add(arr2[j++]); // Add remaining elements of arr2

        int size = n + m;
        if (size % 2 == 1) {
            return arr3.get(size / 2); // Odd length: return middle element
        } else {
            return (arr3.get(size / 2) + arr3.get((size / 2) - 1)) / 2; // Even length: average of middle elements
        }
    }

    // Better Approach: O(n + m), and S.C. of O(1)
    private static int Better(int[] arr1, int[] arr2) {
        int n = arr1.length, m = arr2.length;
        int i = 0, j = 0, cnt = 0;
        int sum = n + m;
        int ind2 = sum / 2;
        int ind1 = ind2 - 1;

        int ind1el = -1, ind2el = -1;

        // Simulate merging while counting up to median indices
        while (i < n && j < m) {
            if (arr1[i] < arr2[j]) {
                if (cnt == ind1) ind1el = arr1[i];
                if (cnt == ind2) ind2el = arr1[i];
                i++;
            } else {
                if (cnt == ind1) ind1el = arr2[j];
                if (cnt == ind2) ind2el = arr2[j];
                j++;
            }
            cnt++;
        }

        while (i < n) {
            if (cnt == ind1) ind1el = arr1[i];
            if (cnt == ind2) ind2el = arr1[i];
            cnt++;
            i++;
        }

        while (j < m) {
            if (cnt == ind1) ind1el = arr2[j];
            if (cnt == ind2) ind2el = arr2[j];
            cnt++;
            j++;
        }

        if (sum % 2 == 1) {
            return ind2el; // Odd length: return middle element
        }
        return (ind1el + ind2el) / 2; // Even length: average of middle elements
    }
//    Optimal approach with the use of Binary Search and T.C. of O(log(min(n1,n2))) and S.C. of O(1)
private static int Optimized(int[] arr1, int[] arr2) {
    int n1 = arr1.length, n2 = arr2.length;

    // Ensure the first array is smaller or equal in size to the second
    if (n1 > n2) return Optimized(arr2, arr1);

    int low = 0, high = n1, left = (n1 + n2 + 1) / 2; // Total elements on the left side
    int n = n1 + n2;

    while (low <= high) {
        int mid1 = (low + high) >> 1;
        int mid2 = left - mid1;

        int l1 = (mid1 > 0) ? arr1[mid1 - 1] : Integer.MIN_VALUE; // Left of arr1
        int l2 = (mid2 > 0) ? arr2[mid2 - 1] : Integer.MIN_VALUE; // Left of arr2
        int r1 = (mid1 < n1) ? arr1[mid1] : Integer.MAX_VALUE;    // Right of arr1
        int r2 = (mid2 < n2) ? arr2[mid2] : Integer.MAX_VALUE;    // Right of arr2

        if (l1 <= r2 && l2 <= r1) {
            // Correct partition found
            if (n % 2 == 1) {
                return Math.max(l1, l2); // Odd-length: median is the max of the left side
            } else {
                int leftMax = Math.max(l1, l2);
                int rightMin = Math.min(r1, r2);
                return (leftMax + rightMin) / 2; // Even-length: median is average of middle two
            }
        } else if (l1 > r2) {
            high = mid1 - 1; // Move partition left
        } else {
            low = mid1 + 1; // Move partition right
        }
    }

    return 0; // Should never reach here if arrays are valid
}

    public static void main(String[] args) {
        int[] arr1 = {1, 4, 7, 10, 12};
        int[] arr2 = {2, 3, 6, 15};

        int ans = BruteForce(arr1, arr2);
        System.out.println("The median of 2 sorted arrays (BruteForce) is: " + ans);

        int ans2 = Better(arr1, arr2);
        System.out.println("The median of 2 sorted arrays (Better) is: " + ans2);

        int ans3 = Optimized(arr1, arr2);
        System.out.println("The median of 2 sorted arrays (Optimized) is: " + ans3);
    }
}
