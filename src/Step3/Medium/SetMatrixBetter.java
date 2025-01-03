package Step3.Medium;

import java.util.Arrays;

public class SetMatrixBetter {
//   The T.C. of this approach is O(n*m) and the S.C. is O(n+m)
    private static void Better(int[][] matrix, int n, int m){
        int row[] = new int[n];
        int col[]  = new int[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(matrix[i][j] ==0){
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(row[i] == 1 || col[j] == 1){
                    matrix[i][j] = 0;
                }
            }
        }
        System.out.println(Arrays.deepToString(matrix));
    }
//   In the optimal approach instead of taking a different row and columns, we will take the row and columns as the first row and first column of the matrix itself

    private static void Optimized(int[][] matrix, int n, int m){

    }
    public static void main(String[] args) {
        int[][] matrix = {{1,0,1}, {1,1,1}, {1,1,1}};
        int n = matrix.length;
        int m = matrix[0].length;
        Better(matrix, n,m);
    }
}
/*
check the matrix and keep the track of the column and row which needs to be made zero

 */