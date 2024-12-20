package Step1.Recursion;

import java.util.*;

public class SubsequencesRecursion {
    private static void Sub(int ind, ArrayList<Integer> ls, int[] arr, int n){
        //base condition
        if(ind  == n){
            for(Integer it : ls)
                System.out.print(it);
            if(ls.size() == 0)
                System.out.print("{}");
            System.out.println();
            return;
        }

        //take or pick the particular element
        ls.add(arr[ind]);
        Sub(ind+1, ls, arr, n);
        ls.removeLast();

        //Do not take condition
        Sub(ind+1, ls, arr, n);
    }
    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 7}; // Array declaration
        int n = arr.length;    // Get the length of the array
        ArrayList<Integer> ls = new ArrayList<>();
        Sub(0, ls, arr, n);
    }
}
/*
Subsequence -> A contigous or non-contigous sequence, which follows the order
arr -> [3,1,2]
3
1
2
3,1
1,2
3,2
3,1,2
-> in the above example elements are contigous as well as non-contigous, but all of them follows order
-> T.C. is 2^n  -> for every recursion call, and the number of times the element comes are also 2^n
           n -> for running of the for loop
-> Total T.C. is O(2^n * n)
-> S.C. is O(n), which is equal to the depth of the array
 */