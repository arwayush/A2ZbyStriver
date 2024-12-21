package Step1.Hashing;

import java.util.*;

public class CountFrequencyArray {

    //this is the function which takes the T.C. of O(n^2)
    private static void countFreqBrute(int[] arr, int n){
        boolean[] vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            //skip the element
            if(vis[i])
                continue;
            int count = 1;
            for (int j = i + 1; j < n; j++) {
                    if (arr[i] == arr[j]) {
                        count++;
                        vis[j] = true;
                    }
            }

            System.out.println(arr[i]+ "->" +count);
        }
    }

    //This is the better approach with using the hasharray
    private static void countFreqHashArray(int[] arr, int n){
        int[] hash = new int[12];
        for (int i = 0; i < n; i++) {
            hash[arr[i]]++;
        }
        for (int i = 0; i < hash.length; i++) {
            if(hash[i] != 0){
                System.out.println(i+ "->" +hash[i]);
            }
        }
    }

    //Best approach using the data structures i.e. hashmap, T.C. of O(n)
    private static void countFreqDS(int[] arr, int n){
        HashMap<Integer,Integer> mp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if(!mp.containsKey(arr[i])){
                mp.put(arr[i], 1);
            }else{
                mp.put(arr[i], mp.get(arr[i]) + 1);
            }
        }
        //traverse through the map
        for(Map.Entry<Integer, Integer> entry: mp.entrySet()){
            System.out.println(entry.getKey() + " -> " +entry.getValue());
        }
    }


    public static void main(String[] args) {
        int[] arr = {10, 5, 10, 11, 10, 5};
        int n = arr.length;
//        countFreqBrute(arr, n);
//        countFreqHashArray(arr, n);
        countFreqDS(arr, n);
    }
}
