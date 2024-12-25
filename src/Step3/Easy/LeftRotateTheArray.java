package Step3.Easy;

import java.util.*;

public class LeftRotateTheArray {
    private static void brute(int[] arr, int n){
        ArrayList<Integer> as = new ArrayList<>();
        for (int num : arr) {
            as.add(num);
        }
        for (int i = 0; i < n; i++) {
            int temp = arr[i];
            as.remove(as.get(0));
            as.add(temp);
        }
        System.out.println(as);
    }

    private static void dummyArr(int[]arr, int n){
        int temp[]=new int[n];
        for (int i = 1; i < n; i++) {
            temp[i - 1] = arr[i];
        }
        temp[n - 1] = arr[0];
        System.out.println(Arrays.toString(temp));
    }

    private static void ShiftArr(int[] arr, int n, int k){
        for (int j = 0; j < k; j++) {
            int temp = arr[0];
            for (int i = 0; i < n-1; i++) {
                arr[i] = arr[i+1];
            }
            arr[n-1] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }

    //main function
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int n = arr.length;
        int k = 3;
//        brute(arr, n);
        dummyArr(arr, n);
        ShiftArr(arr, n, k);
    }
}
