package Step3.Easy;

import java.util.HashMap;
import java.util.Map;

public class FindTheNumberThatAppearsOnce {
//    For the every element in the array we will check the whole array from starting to end, The T.C. of this is O(n^2)
    private static void Brute(int[] arr, int n){
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if(arr[i] == arr[j]){
                    count++;
                }
            }
            if(count == 1)
                System.out.println(arr[i]);
        }
    }
//    The T.C. of the program is O(N*logM)
    private static void Hashing(int[]arr, int n){
        HashMap<Integer, Integer> hs = new HashMap<>();
        for(int num : arr){
            hs.put(num, hs.getOrDefault(num, 0) +1);
        }
       //Traversing on the hashmap
        for(Map.Entry<Integer, Integer> it: hs.entrySet()){
            if(it.getValue() == 1)
                System.out.println(it.getKey());
        }
    }

    private static void Xor(int[] arr, int n){
        int xor = 0;
        for (int i = 0; i < n; i++) {
            xor ^= arr[i];
        }
        System.out.println(xor);
    }


    public static void main(String[] args) {
        int[] arr = {4,1,2,1,2};
        int n = arr.length;
//        Brute(arr, n);
        Hashing(arr, n);
        Xor(arr, n);
    }
}
/*
xor of 2 same numbers is always 0 eg;- n^n = 0
xor of num with 0 is number eg:- n^0 = n

 */