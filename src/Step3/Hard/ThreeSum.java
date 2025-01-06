package Step3.Hard;

import java.util.*;

public class ThreeSum {
//    This takes the O(n^3 * Log(number of unique triplets)
    private static void Brute(int[] arr){
        Set<List<Integer>> st = new HashSet<>();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j <n; j++) {
                for (int k = j+1; k < n; k++) {
                    if(arr[i] + arr[j] + arr[k] == 0){
                        List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k]);
                        temp.sort(null);
                        st.add(temp);
                    }
                }
            }
        }
        List<List<Integer>> ans = new ArrayList<>(st);
        System.out.println(ans);
    }
//    this takes the T.C. O(N2 * log(no. of unique triplets))
   private static void Better(int[] arr){
        int n = arr.length;
        Set<List<Integer>> st = new HashSet<>();
       for (int i = 0; i < n; i++) {
           Set<Integer> hashset = new HashSet<>();
           for (int j = i+1; j < n; j++) {
               int third = - (arr[i] + arr[j]);

               if(hashset.contains(third)){
                   List<Integer> temp = Arrays.asList(arr[i], arr[j], third);
                   temp.sort(null);
                   st.add(temp);
               }
               hashset.add(arr[j]);
           }
       }
       List<List<Integer>> ans = new ArrayList<>(st);
       System.out.println(ans);
   }

   private static void Optimal(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();
        int n = arr.length;
        for (int i = 0; i <n; i++) {
           if(i != 0 && arr[i] == arr[i-1]) continue;
           //moving 2 pointers
           int j = i+1;
           int k = n-1;
           while (j < k){
               int sum = arr[i] + arr[j] + arr[k];
               if(sum < 0){
                   j++;
               } else if (sum > 0) {
                   k--;
               }else{
                   List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k]);
                   ans.add(temp);
                   j++;
                   k--;
                   // skipping the duplicates
                   while (j < k && arr[j] == arr[j-1]) j++;
                   while (j < k && arr[k] == arr[k+1]) k--;
               }
           }
        }
       System.out.println(ans);
   }

    public static void main(String[] args) {
        int arr[] = {-1,0,1,2,-1,-4};
        Brute(arr);
        Better(arr);
        Optimal(arr);
    }
}
/*

 */