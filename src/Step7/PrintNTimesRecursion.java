package Step7;

import java.util.Scanner;

public class PrintNTimesRecursion {
//    T.C. is O(n) and S.C. is O(n), uses internal memory of stack space
    private static void Recurse(int i, int n){
        //base condition, decided on the condition
        if (i > n) return;
        System.out.println("Hare Krishna " + i);
        Recurse(i+1, n);

    }
    public static void main(String[] args) {
        System.out.println("Give the Number, the times you wants to print:");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Recurse(1, n);
    }
}
