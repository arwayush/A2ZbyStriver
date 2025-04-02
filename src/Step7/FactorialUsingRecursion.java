package Step7;

import java.util.Scanner;

public class FactorialUsingRecursion {
//    The T.C. is O(n) and S.C. is O(n) for the stack space
    private static int fact(int n){
        if (n == 0) return 1;
        return n*fact(n-1);
    }
    public static void main(String[] args) {
        System.out.print("Give the Number for Factorial: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(fact(n));

    }
}
