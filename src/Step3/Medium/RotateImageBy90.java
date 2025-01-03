package Step3.Medium;

import java.util.Arrays;

public class RotateImageBy90 {
//    The T.C. of this will be T.C. of O(n*n), and the S.C. of this will be O(n*n)
    private static void Brute(int[][]mat, int n, int m){
        int[][] dummy = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dummy[j][n-i-1] = mat[i][j];
            }
        }
        System.out.println(Arrays.deepToString(dummy));
    }
/*
1. We will transpose the matrix
2. reverse each row of the matrix
 */
//    This will only take the T.C. of the O(n*m + n*m), but S.C. of O(1)
    private static void Better(int[][] mat, int n, int m){
        for (int i = 0; i < n; i++) {
            for (int j = i; j <m ; j++) {
                int temp = 0;
                temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m/2; j++) {
                int temp = 0;
                temp = mat[i][j];
                mat[i][j] = mat[i][n-1-j];
                mat[i][n-1-j] = temp;
            }
        }
        System.out.println(Arrays.deepToString(mat));
    }
    public static void main(String[] args) {
        int[][] mat = {{1,2,3}, {4,5,6}, {7,8,9}};
        int n = mat.length;
        int m = mat[0].length;
        Brute(mat, n, m);
        Better(mat, n, m);
    }
}
