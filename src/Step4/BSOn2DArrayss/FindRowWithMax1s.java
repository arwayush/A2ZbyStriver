package Step4.BSOn2DArrayss;

public class FindRowWithMax1s {
//    This naive and Brute force approach takes the Time Complexity of O(n*m)
    private static void Brute(int[][] matrix){
        int ind = -1;
        int max_cnt = -1;
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            int cnt_ones = 0;
            for (int j = 0; j < matrix[i].length; j++) { // Use matrix[i].length for column count
                if (matrix[i][j] == 1) {
                    cnt_ones++;
                }
            }
            // Update max_cnt and ind after completing the row
            if (cnt_ones > max_cnt) {
                max_cnt = cnt_ones;
                ind = i;
            }
        }
        System.out.println(ind);
    }

    private static int lower(int[] arr, int x){
        int n = arr.length;
        int low = 0, high = n-1, ans = n;
        while(low <= high){
            int mid = (low + high) / 2;
            if(arr[mid] >= x){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return ans;
    }
//    The T.C. is O(n * log2M) ans S.C. of O(1)
    private static void BS(int[][] matrix){
        int cnt_max = 0;
        int index = -1;
        int n = matrix.length;
        int m = matrix[0].length;
        for (int i = 0; i < n; i++) {
            int count_ones = m-lower(matrix[i], 1);
            if(count_ones > cnt_max){
                cnt_max = count_ones;
                index = i;
            }
        }
        System.out.println(index);
    }


    public static void main(String[] args) {
        int[][] mat = {{0, 0, 1, 1, 1},
                      {0, 0, 0, 0, 0},
                      {0, 1, 1, 1, 1},
                      {0, 0, 0, 0, 0},
                      {0, 1, 1, 1, 1}};
        Brute(mat);
        BS(mat);
    }
}
