package Step1.Hashing;

import java.util.HashMap;
import java.util.Map;

public class HighestAndLowestFreq {
    //Running the algo with the Brute force approach
    private static void calcBrute(int[] arr){
        int n = arr.length;
        boolean vis[] = new boolean[n];
        int maxi = 0, mini = n;
        int maxEle = 0, minEle = 0;
        for (int i = 0; i < n; i++) {
            //skip the element if already processed
            if(vis[i] == true)
                continue;

            //count frequency
            int count = 1;
            for (int j = i + 1; j < n; j++) {
                if (arr[i] == arr[j]) {
                    vis[j] = true;
                    count++;
                }
            }
            if(count > maxi){
                maxEle = arr[i];
                maxi = count;
            }

            if(count < mini){
                minEle = arr[i];
                mini = count;
            }
        }
        System.out.println("highest frequency: " + maxEle+ " -> " +maxi);
        System.out.println("lowest frequency: " + minEle+ " -> " +mini);

    }
    private static void calcHashing(int arr[]){
        HashMap<Integer, Integer> mp = new HashMap<>();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if(!mp.containsKey(arr[i])){
                mp.put(arr[i], 1);
            }else{
                mp.put(arr[i], mp.get(arr[i]) + 1);
            }
        }
        int maxFreq = 0, minFreq = n;
        int maxEle = 0, minEle = 0;
        // Traverse through map and find the elements
        for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
            int count = entry.getValue();
            int element = entry.getKey();

            if (count > maxFreq) {
                maxEle = element;
                maxFreq = count;
            }
            if (count < minFreq) {
                minEle = element;
                minFreq = count;
            }
        }

        System.out.println("The highest frequency element is: " + maxEle);
        System.out.println("The lowest frequency element is: " + minEle);
    }


    public static void main(String[] args) {
        int[] arr = {2,2,3,4,4,2};
        calcBrute(arr);
//        calcHashing(arr);
    }
}
/*

 */