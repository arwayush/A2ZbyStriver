package Step4.BSOn2DArrayss;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

public class MedianOfRowWiseSortedMatrix {
//    T.C. is O[n*m] + O[(n*m)log(n*m)] ans S.C. O(n*m)
    private static void BruteForce(int[][] mat, int n, int m){
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans.add(mat[i][j]);
            }
        }
        Collections.sort(ans);
        System.out.println(ans.get((n*m)/2));
    }


    static int upperBound(int[] arr, int x, int n) {
        int low = 0, high = n - 1;
        int ans = n;

        while (low <= high) {
            int mid = (low + high) / 2;
            // Check if this is a possible upper bound
            if (arr[mid] > x) {
                ans = mid;
                // Look for a smaller index on the left
                high = mid - 1;
            } else {
                // Move right
                low = mid + 1;
            }
        }
        return ans;
    }

    static int countSmallEqual(int[][] matrix, int n, int m, int x) {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            cnt += upperBound(matrix[i], x, m); // Pass m for column length
        }
        return cnt;
    }

    private static void Better(int[][] mat, int n, int m) {
        int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;
        // Identify the minimum and maximum elements in the matrix
        for (int i = 0; i < n; i++) {
            low = Math.min(low, mat[i][0]);
            high = Math.max(high, mat[i][m - 1]);
        }

        int req = (n * m + 1) / 2; // Median position (1-based indexing)

        while (low <= high) {
            int mid = (low + high) / 2;
            int smallEqual = countSmallEqual(mat, n, m, mid);

            if (smallEqual < req) {
                // Median lies on the right
                low = mid + 1;
            } else {
                // Median lies on the left or is the current element
                high = mid - 1;
            }
        }

        // The median will be the first value greater than `high`
        System.out.println(low);
    }

    public static void main(String[] args) {
        int[][] mat = {{1,5,7,9,11}, {2,3,4,5,10}, {9,10,12,14,16}};
        int n = mat.length;
        int m = mat[0].length;
        BruteForce(mat, n, m);
        Better(mat, n, m);
    }
}
/*
If we try to assume the matrix in the m*n and start from the 0 to m*n and will find the middle value
row = mid / m
col = mid % m
 */
