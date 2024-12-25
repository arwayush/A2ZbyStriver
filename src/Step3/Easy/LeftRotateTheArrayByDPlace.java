package Step3.Easy;
import java.util.*;
//The T.C. for the algorithm is O(n) ans S.C. of O(1), because no extra space is required
class ReversalAlgo{
    private static void reverse(int[] arr, int start, int end){
        while (start <= end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
    protected static void reversal(int[] arr, int n, int k){
        reverse(arr, n-k, n-1); //reverse last k elements
        reverse(arr, 0, n-k-1); //reverse first n-k elements
        reverse(arr, 0, n-1); //reverse whole array
        System.out.println(Arrays.toString(arr));
    }
}


public class LeftRotateTheArrayByDPlace {
//    this algo only takes the Time complexity O(n), and S.C. of O(k), because of extra space
    private static void rotateTempArr(int[] arr, int n, int k){

        int temp[] = new int[n];
        for (int i = 0; i <k ; i++) {
            temp[i] = arr[n+i-k]; // n+i-k
        }
        for (int i = 0; i <n-k ; i++) {
            temp[i+k] = arr[i];
        }

        System.out.println(Arrays.toString(temp));
    }

//    Main function
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7};
        int k = 4;
        int n = arr.length;
        k = k%n;
        if(k == 0) {
            System.out.println(Arrays.toString(arr));
        }
        rotateTempArr(arr, n, k);
        ReversalAlgo.reversal(arr, n, k);
    }
}
