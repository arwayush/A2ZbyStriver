package Step4.BSOn2DArrayss;

import Step4.BSOnAnswers.MinDaysToMakeBouquets;

public class SearchInASorted2DMatrix {
//    The T.C. is O(n*m) ans S.C. is O(1)
    private static boolean BruteForce(int[][] mat, int n , int m, int target){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(mat[i][j] == target){
                    System.out.println(mat[i][j]);
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
//    This is slightly better approach and it takes the T.C. of O(n + log m) and S.C. of O(1)
    private static boolean BetterApproach(int[][] mat, int n, int m, int target){
        for (int i = 0; i < n; i++) {
            if(mat[i][0] <= target && target <= mat[i][m-1]){
                return BS(mat[i], target);
            }
        }
        return false;
    }

//    Takes only the T.C. of O(log(n*m)) and S.C. of O(1)
    private static boolean OptimizedApp(int[][] mat, int n, int m, int target){
        int low = 0, high = n*m-1;
        while (low <= high){
            int mid = (low + high) / 2;
            int row = mid / m, col = mid % m;
            if(mat[row][col] ==target) return true;
            else if (mat[row][col] < target) low = mid + 1;
            else high = mid - 1;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] mat = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}};
        int n = mat.length; //gives the number of rows
        int m = mat[0].length; // gives the number of columns
        int target = 4;
        boolean ans = BruteForce(mat, n, m, target);
        System.out.println(ans);
        boolean ans2 = BetterApproach( mat, n, m, target);
        System.out.println(ans2);
        boolean ans3 = OptimizedApp(mat, n, m, target);
        System.out.println(ans3);
    }
}
/*
For the most optimized approach we will apply the BS on the [assumed imaginary 1-D array]
and the coordinates of the number can be find by
row = /m
col = %m
 */