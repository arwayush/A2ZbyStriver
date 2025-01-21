package Step4.BSOn2DArrayss;

import java.util.Arrays;

public class PeakElementIn2DArray {
    private static int findMaxIndex(int[][] mat, int n, int col) {
        int maxVal = -1;
        int index = -1;
        for (int i = 0; i < n; i++) {
            if (mat[i][col] > maxVal) {
                maxVal = mat[i][col];
                index = i;
            }
        }
        return index;
    }

    private static int[] func(int[][] mat, int n, int m) {
        int low = 0, high = m - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int maxRowIndex = findMaxIndex(mat, n, mid);
            int left = mid - 1 >= 0 ? mat[maxRowIndex][mid - 1] : -1;
            int right = mid + 1 < m ? mat[maxRowIndex][mid + 1] : -1;

            if (mat[maxRowIndex][mid] > left && mat[maxRowIndex][mid] > right) {
                return new int[]{maxRowIndex, mid};
            } else if (mat[maxRowIndex][mid] < left) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[][] mat = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        int n = mat.length;
        int m = mat[0].length;
        System.out.println(Arrays.toString(func(mat, n, m)));
    }
}
