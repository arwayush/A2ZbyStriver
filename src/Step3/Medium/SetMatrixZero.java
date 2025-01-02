package Step3.Medium;

import java.util.*;

public class SetMatrixZero {

    static void markRow(ArrayList<ArrayList<Integer>> matrix, int n, int m, int i) {
        // set all non-zero elements as -1 in the row i:
        for (int j = 0; j < m; j++) {
            if (matrix.get(i).get(j) != 0) {
                matrix.get(i).set(j, -1);
            }
        }
    }
    static void markCol(ArrayList<ArrayList<Integer>> matrix, int n, int m, int j) {
        // set all non-zero elements as -1 in the col j:
        for (int i = 0; i < n; i++) {
            if (matrix.get(i).get(j) != 0) {
                matrix.get(i).set(j, -1);
            }
        }
    }
//   Time Complexity: O((N*M)*(N + M)) + O(N*M), where N = no. of rows in the matrix and M = no. of columns in the matrix.
    protected static void Brute(ArrayList<ArrayList<Integer>> matrix, int n, int m){
        //setting -1 for all the rows and columns
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(matrix.get(i).get(j) == 0){
                    markRow(matrix, n, m, i);
                    markCol(matrix, n, m, j);
                }
            }
        }
        //putting 0 at the place of -1
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(matrix.get(i).get(j) == -1){
                    matrix.get(i).set(j, 0);
                }
            }
        }
        System.out.println(matrix);
    }
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        matrix.add(new ArrayList<>(Arrays.asList(0,1,2,0)));
        matrix.add(new ArrayList<>(Arrays.asList(3,4,5,2)));
        matrix.add(new ArrayList<>(Arrays.asList(1,3,1,5)));
        int n = matrix.size();
        int m = matrix.get(0).size();
        Brute(matrix, n, m);

    }
}
/*
  [0,1,2,0]   ->  [0,0,0,0]
  [3,4,5,2]  ->  [0,4,5,0]
  [1,3,1,5]   ->  [0,3,1,0]
 -> In this the row and the column which contain the zero will make whole the  row and column as zero

 */