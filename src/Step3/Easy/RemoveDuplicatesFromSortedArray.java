package Step3.Easy;

import java.util.ArrayList;
import java.util.*;
import java.util.HashSet;

public class RemoveDuplicatesFromSortedArray {
    //This is the approach with the T.c. of O(n+k) and S.C. of O(n)
    //where n is the size of the original array and 'k' is the size of the hashset with unique value
    private static void hashSet(int[] arr){
        HashSet<Integer> hs = new HashSet<>(); //O(1)
        for (int num: arr){ //O(n)
            hs.add(num);
        }
        System.out.println(hs);
    }

//    The T.c. of this approach is O(n) only
    private static void Optimized(int[] arr) {
        ArrayList<Integer> ans = new ArrayList<>();
        int i = 0;
        ans.add(arr[i]);
        for (int j = 1; j < arr.length; j++) {
            if (arr[i] != arr[j]) {
                i++;
                arr[i] = arr[j];
                ans.add(arr[i]);
            }
        }
        System.out.println(ans);
    }


    public static void main(String[] args) {
        int[]arr = {1,1,1,2,2,3,3,3,3,4,4};
        hashSet(arr);
        Optimized(arr);
    }
}
