package Step1.Recursion;

import java.util.Scanner;

public class FactorialOfNNumbers {
    public static int fact(int n){
        //base case
        if(n == 0) return 1;
        return n * fact(n-1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(fact(n));
    }
}
/*
Time complexity = O(n)
Space = O(n) -> because the n times the value will be waiting to return
 */