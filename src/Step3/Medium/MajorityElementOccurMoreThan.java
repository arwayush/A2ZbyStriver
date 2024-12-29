package Step3.Medium;

import java.util.HashMap;
import java.util.Map;

public class MajorityElementOccurMoreThan {
//    This is the approach with the T.C. of the O(n^2)
    protected static void Brute(int[] arr){
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = i+1; j < n; j++) {
                if(arr[i] == arr[j]){
                    count++;
                }
            }
            if(count >= n/2){
                System.out.println(arr[i]);
            }
        }
    }
//    This is the better approach with the T.C. of O(n * logN)
    protected static void Hashing(int[] arr){
        HashMap<Integer, Integer> mp = new HashMap<>();
        int n = arr.length;
        // creating an hashmap and putting its frequency
        for (int i = 0; i < n; i++) {
            mp.put(arr[i], mp.getOrDefault(arr[i], 0 )+ 1);
        }
        //finding the majority elemetn
        for (Map.Entry<Integer, Integer> it: mp.entrySet()){
            if(it.getValue() > n/2)
                System.out.println(it.getKey());
        }
    }
//    In this approach we will dynamically count all the elements in the single run, i.e. T.C. O(n)
    protected static void Optimal(int[] arr){
        int n = arr.length;
        int cnt = 0;
        int element = 0;
        for (int i = 0; i < n; i++) {
            if(cnt == 0){
                cnt = 1;
                element = arr[i];
            } else if (element == arr[i]) {
                cnt++;
            }else{
                cnt--;
            }
        }

        int cnt1 = 0;
        for (int i = 0; i < n; i++) {
            if(arr[i] == element) cnt1++;
        }
        if(cnt1 > (n/2)){
            System.out.println(element);
        }else {
            System.out.println("No Element");
        }
    }

    public static void main(String[] args) {
        int[] arr = {4,4,2,4,3,4,4,3,2,4};
        Brute(arr);
        Hashing(arr);
        Optimal(arr);

    }
}
/*
We will find the element which will come more than N/2 times in the array

 */