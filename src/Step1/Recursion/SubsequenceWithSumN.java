package Step1.Recursion;

import java.util.*;

public class SubsequenceWithSumN {
    private static void func(int ind, ArrayList<Integer> ls, int s, int sum, int[] arr, int n) {
        if (ind == n) {
            if (s == sum) {
                for (Integer it : ls) {
                    System.out.print(it + " ");
                }
                System.out.println();
            }
            return;
        }

        // Include the current element
        ls.add(arr[ind]);
        s += arr[ind];
        func(ind + 1, ls, s, sum, arr, n);

        // Backtrack and exclude the current element
        s -= arr[ind];
        ls.remove(ls.size() - 1);
        func(ind + 1, ls, s, sum, arr, n);
    }

    public static void main(String[] args) {
        ArrayList<Integer> ls = new ArrayList<>();
        int[] arr = {1, 2, 1};
        Scanner sc = new Scanner(System.in);
        int sum = sc.nextInt();
        int n = arr.length;
        func(0, ls, 0, sum, arr, n);
    }
}
