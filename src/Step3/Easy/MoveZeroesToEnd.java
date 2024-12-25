package Step3.Easy;

import java.util.ArrayList;
import java.util.Arrays;

public class MoveZeroesToEnd {
//    The Time Complexity of the problem is O(N) + O(X) + O(N-X) ~ O(2*N), where N = total no. of elements,
    private static void brute(int[] arr){
        int n = arr.length;
        ArrayList<Integer> temp = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if(arr[i] != 0)
                temp.add(arr[i]);
        }
        int nonZero = temp.size(); //finding the non-zero elements
        for (int i = 0; i < nonZero; i++) { //putting all the non-zero elements into the array
            arr[i] = temp.get(i);
        }
        for (int i = nonZero; i < n; i++) { //now putting the remaining zero elements into the array
            arr[i] = 0;
        }
    }


//    The T.C. of the following approach is the O(n)
    private static void Optimized(int[] arr){
        int n = arr.length;
        int j = -1;
        for (int i = 0; i < n; i++) {
            if(arr[i] == 0) {
                j = i;
                break;
            }
        }
        if( j == -1) return;
        for (int i = j+1; i < n; i++) {
            if(arr[i] != 0){
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                j++;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

//    Main function
    public static void main(String[] args) {
        int[] arr = { 1 ,0 ,2 ,3 ,0 ,4 ,0 ,1};
        brute(arr);
        Optimized(arr);
        System.out.println(Arrays.toString(arr));
    }
}
