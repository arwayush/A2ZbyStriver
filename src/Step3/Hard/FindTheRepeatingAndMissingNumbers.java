package Step3.Hard;

import java.util.ArrayList;
import java.util.Arrays;

public class FindTheRepeatingAndMissingNumbers {
//    The T.C. of this will be O(n^2)
    private static void Brute(int[] arr){
        int n= arr.length;
        int repeating = -1, missing =-1;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if(arr[j] == i){
                    count++;
                }
                if (count == 2) repeating = i;
                if (count == 0) missing = i;
                if (repeating != -1 && missing != -1)
                    break;
            }
        }
        System.out.println(missing);
        System.out.println(repeating);
    }
//    The T.C. of this will be O(2n), and S.C. of this will be O(n)
    private static void Better(int[] arr){
        int n = arr.length;
        int[] HashArr =  new int[n + 1];
       for (int i = 0; i<n; i++){
           HashArr[arr[i]]++;
       }
       int repeat = -1, missing = -1;
        for (int i = 1; i <= n; i++) {
            if(HashArr[i] == 2) repeat = i;
            else if (HashArr[i] == 0) missing = i;
            if (repeat != -1 && missing != -1)
                break;
        }
        System.out.println("The repeating number is : " +repeat);
        System.out.println("The missing number is: " +missing);
    }
//    The T.C. of this will be O(n), and the S.C. O(1)
    private static void OptimalMaths(int[] arr){
        //find the sum of the first natural numbers, and subtract
        // next find the difference of the squares and sum of natural numbers
        ArrayList<Integer> ans = new ArrayList<>();
        int n = arr.length;
        int SN = (n * (n+1)) / 2;
        int S2N = (n*(n+1)*(2*n+1)) / 6;
        int s = 0, s2 = 0;
        for (int i = 0; i < n; i++) {
            s += arr[i];
            s2 += arr[i] * arr[i];
        }
        int val1 = s - SN;
        int val2 = s2 - S2N;
        val2 = val2 / val1;
        int x = (val1 + val2) / 2;
        int y = x - val1;
        ans.add(x);
        ans.add(y);
        System.out.println(ans);
    }

    public static void main(String[] args) {
        int[] arr = {4,3,6,2,1,1};
        Brute(arr);
        Better(arr);
        OptimalMaths(arr);
    }
}
/*
   we need to give back the repeat number and missing number

 */