package Step3.Easy;

import java.util.*;

public class UnionOfTwoSortedArray {
//    Using the tree sort algo to put the elements in the sorted order
//    the T.C. of this approach is  O( (m+n)log(m+n) )
    private static void approach1(int[] arr1, int[] arr2){
        TreeSet<Integer> hs = new TreeSet<>();
        for (int i = 0; i < arr1.length; i++) {
            hs.add(arr1[i]);
        }
        for (int i = 0; i < arr2.length; i++) {
            hs.add(arr2[i]);
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for(int it: hs){
            ans.add(it);
        }
        System.out.println(ans);
    }
//    In this approach we will be using the unordered_map
//    The T.C. of this is O( (n+m) log(m+n) )
    private static void approach2(int[]arr1, int[] arr2){
        HashMap<Integer, Integer> freq = new HashMap<>();
        ArrayList<Integer> ans = new ArrayList<>();
        int n = arr1.length;
        int m = arr2.length;
        //putting elements of the arr1
        for (int i = 0; i < n; i++) {
            freq.put(arr1[i], freq.getOrDefault(arr1[i], 0)+1);
        }
        // putting the elements of the arr2
        for (int i = 0; i < m; i++) {
            freq.put(arr2[i], freq.getOrDefault(arr2[i], 0)+1);
        }

        for(int it : freq.keySet())
            ans.add(it);
        System.out.println(ans);

    }
//   Works good and gives the T.C. of the O(n+m) if both the arrays are sorted
    private static void twoPointers(int[] arr1, int[] arr2){
        int i = 0, j = 0;
        int n = arr1.length;
        int m = arr2.length;
        ArrayList<Integer> ans = new ArrayList<>();
        while (i<n && j<m){
            if(arr1[i] <= arr2[j]){
                if(ans.size() == 0 || ans.get(ans.size()-1) != arr1[i])
                    ans.add(arr1[i]);
                i++;
            }else{
                if(ans.size() == 0 || ans.get(ans.size()-1) != arr2[j])
                    ans.add(arr2[j]);
                j++;
            }
        }

        while (i < n){
            if(ans.get(ans.size()-1) != arr1[i])
                ans.add(arr1[i]);
            i++;
        }
        while (j < m){
            if(ans.get(ans.size()-1) != arr2[j])
                ans.add(arr2[j]);
            j++;
        }
        System.out.println(ans);
    }


    public static void main(String[] args) {
        int arr1[] = {1,2,3,4,5,6,7,8,9,10};
        int arr2[] = {2,3,4,4,5,11,12};
        approach1(arr1, arr2);
        approach2(arr1, arr2);
        twoPointers(arr1, arr2);
    }
}
