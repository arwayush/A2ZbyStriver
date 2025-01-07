package Step3.Hard;

import java.util.*;

public class MergeOverlappingSubIntervals {
//    The T.C. of this is nearly O(N*logN) + O(2*N) and S.C. of O(n)
    private static void Brute(int[][] arr){
        int n = arr.length;
        Arrays.sort(arr, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int start = arr[i][0];
            int end = arr[i][1];
            if(!ans.isEmpty() && end <= ans.get(ans.size()-1).get(1)){
                continue;
            }
            //check the rest of the intervals
            for (int j = i+1; j < n; j++) {
                if(arr[j][0] <= end){
                    end = Math.max(end, arr[j][1]);
                }else{
                    break;
                }
            }
            ans.add(Arrays.asList(start, end));
        }
        System.out.println(ans);
    }
//   The T.C. of this is nearly O(N*logN) + O(N) ans S.C. of O(n)
    private static void Optimal(int[][] arr){
         int n = arr.length;
        Arrays.sort(arr, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
         List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if(ans.isEmpty() || arr[i][0] > ans.get(ans.size()-1).get(1)){
                ans.add(Arrays.asList(arr[i][0], arr[i][1]));
            }else {
                ans.get(ans.size()-1).set(1, Math.max(ans.get(ans.size()-1).get(1), arr[i][1]));
            }
        }
        System.out.println(ans);
    }
    public static void main(String[] args) {
        int intervals[][] = {{1,3}, {2,6}, {8,10}, {15,18}};
        Brute(intervals);
        Optimal(intervals);
    }
}
