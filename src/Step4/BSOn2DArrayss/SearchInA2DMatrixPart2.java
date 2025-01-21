package Step4.BSOn2DArrayss;

import Step1.Collections.ArrayList;

public class SearchInA2DMatrixPart2 {
//    The T.C. is O(n*m) and S.C. is O(1)
    private static boolean BruteForce(int[][] mat, int n , int m, int target){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(mat[i][j] == target){
                    return true;
                }
            }
        }
        return false;
    }

    protected static boolean BS(int[] arr, int target){
        int n = arr.length;
        int low = 0, high = n-1;
        while (low <= high){
            int mid = (low + high) / 2;
            if(arr[mid] == target) return true;
            if(arr[mid] <= target) low = mid + 1;
            else high = mid - 1;
        }
        return false;
    }
//    The T.C. of this is O(n * log M) and S.C. is O(1)
    private static boolean Better(int[][] mat, int n, int target){
        for (int i = 0; i <n; i++) {
            boolean flag = BS(mat[i], target);
            if (flag == true) return true;
        }
        return false;
    }
//    The T.C. of the O(n+m) and S.C. of O(1)
    private static boolean Optimal(int[][] mat, int n, int m, int target){
        int row = 0, col = m - 1;
        while (row < n && col >= 0){
            if (mat[row][col] == target) return  true;
            else if (mat[row][col] < target) row++;
            else col--;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] mat = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        int target = 100;
        int n = mat.length;
        int m = mat[0].length;
        System.out.println(BruteForce(mat, n, m, target));
        System.out.println(Better(mat, n, target));
        System.out.println(Optimal(mat, n, m, target));
    }
}
/*
Every Row is Sorted     left -> right
Every Column is sorted  top -> bottom
 */