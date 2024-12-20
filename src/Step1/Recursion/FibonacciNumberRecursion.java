package Step1.Recursion;

import java.util.Scanner;

public class FibonacciNumberRecursion {
    private static int fib(int n){
        if(n <= 1) return n;  //base case
        return fib(n-1) + fib(n-2);

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = fib(n);
        System.out.println(ans);
    }
}


/*
In case of the multiple recursion calls, 1 function executes and then returns, and then another function executes and then
again executes and come back

->  as we can see in the above code that 2 recursion calls were made,
1st f(n-1) -> this will executes and come back
2nd f(n-2)  -> next this will execute and come back
The Time complexity will be near about T.C. O(2^n), it is exponential in nature. beacause every function calls 2 functions recursively



 */