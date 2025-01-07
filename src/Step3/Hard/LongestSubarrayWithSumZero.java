package Step3.Hard;
import java.util.*;
public class LongestSubarrayWithSumZero {
//    The time complexity of the given code is O(n^2), S.C. O(1)
    private static void Brute(int[] arr){
        List<List<Integer>> ans = new ArrayList<>();
        int n = arr.length;
        int len = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                if(sum == 0){
                    List<Integer> temp = new ArrayList<>();
                    len = Math.max(len, j-i+1);
                }
            }
        }
        System.out.println(len);
    }
//    The T.C. of this will be nearly O(n) and S.C. of this will be O(n)
    private static void Optimal(int[] arr){
        HashMap<Integer,Integer> mp = new HashMap<>();
        int n = arr.length;
        int maxi = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if(sum == 0){
                maxi = i+1;
            }else {
                if(mp.get(sum) != null){
                    maxi = Math.max(maxi, i-mp.get(sum));
                }else {
                    mp.put(sum, i);
                }
            }
        }
        System.out.println(maxi);
    }
    public static void main(String[] args) {
        int arr[] = {9, -3, 3, -1, 6, -5};
        Brute(arr);
        Optimal(arr);
    }
}
