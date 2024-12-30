package Step3.Medium;

import java.util.*;

public class RearrangeArrayElementsBySign {
//    This is the mind Boggling approach and only just takes the O(n) and S.C. O(n/2 + n/2)
    protected static void Brute(int[] arr){
        int n = arr.length;
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();
        for(int num : arr){
            if(num > 0) pos.add(num);
            else neg.add(num);
        }
        //positives on even indices, negatives on odd
        for (int i = 0; i < n / 2; i++) {
            arr[2*i] = pos.get(i);
            arr[2*i+1] = neg.get(i);
        }

        System.out.println(Arrays.toString(arr));
    }
//    This is the approach with the O(n), and takes only 3ms
    protected static void Optimal(int[] arr){
        int n = arr.length;
        ArrayList<Integer> ans = new ArrayList<>(Collections.nCopies(n, 0));
        int posI = 0, negI = 1;
        for (int i = 0; i < n; i++) {
            if(arr[i] < 0){
                ans.set(negI, arr[i]);
                negI += 2;
            }else{
                ans.set(posI, arr[i]);
                posI+=2;
            }
        }
        System.out.println(ans);
    }
    public static void main(String[] args) {
        int[] arr = {1,2,-4,-5};
        Brute(arr);
        Optimal(arr);
    }
}
/*
Input is - [1, 2, -4, -5]
Output is - [1, -4, 2, -5]
 */