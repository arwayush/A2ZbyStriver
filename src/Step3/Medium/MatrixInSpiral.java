package Step3.Medium;

import java.util.ArrayList;

public class MatrixInSpiral {
    private static void Approach(int[][] mat, int n, int m){
        int left = 0, right = m-1, top = 0, bottom = n-1;
        ArrayList<Integer> ans = new ArrayList<>();
        while (top <=  bottom && left <= right){
            //print right
            for (int i = left; i <=right; i++) {
                ans.add(mat[top][i]);
            }
            top++;
            for (int i = top; i <=bottom ; i++) {
                ans.add(mat[i][right]);
            }
            right--;
            if(top <= bottom){
                for (int i = right; i>=left; i--){
                    ans.add(mat[bottom][i]);
                }
                bottom--;
            }

            if(left <= right){
                for(int i = bottom; i>= top; i--){
                    ans.add(mat[i][left]);
                }
                left++;
            }
        }
        System.out.println(ans);
    }
    public static void main(String[] args) {
        int Matrix[][] = { { 1, 2, 3, 4 },
                          { 5, 6, 7, 8 },
                          { 9, 10, 11, 12 },
                          { 13, 14, 15, 16 } };
        int n = Matrix.length;
        int m = Matrix[0].length;
        Approach(Matrix, n, m);
    }
}
