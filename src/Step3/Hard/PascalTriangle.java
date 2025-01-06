package Step3.Hard;

import java.util.ArrayList;

public class PascalTriangle {
    private static void RowCol(int row, int col){
        int res = 1;
        for (int i = 0; i < col; i++) {
            res = res * (row-i);
            res = res/(i+1);
        }
        System.out.println(res);
    }
//    The T.C. of this will be O(n), ans S.C. will be O(1)
    private static void PrintRow(int row){
        int ans = 1;
        System.out.print(ans+ "  ");
        for (int i = 1; i < row; i++) {
            ans = ans * (row-i);
            ans = ans / (i);
            System.out.print(ans+ " ");
        }
    }

    private static void PrintPascalTriangle(int row){
        int ans = 1;
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        for (int i = 1; i < row; i++) {
            ans = ans * (row - i);
            ans = ans / i;
            arr.add(ans);
        }
        System.out.println(arr);
    }
    public static void main(String[] args) {
        int row = 4, col = 2;
        RowCol(row, col);
        PrintRow(row);
        for (int i = 0; i < row; i++) {
            PrintPascalTriangle(i);
        }

    }
}
/*
Type:1
 - In the pascal triangle, if the specific element needs to find out at the given row and column
 - then use the (n-1)C(r-1), formula







 */