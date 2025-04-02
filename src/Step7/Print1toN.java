package Step7;

import java.util.Scanner;

public class Print1toN {
    public static void recurse(int i, int n){
        //base condition
        if (i > n) return;
        System.out.println(i);
        recurse(i+1, n);
    }
    public static void main(String[] args) {
        System.out.print("Give the Number, the times you wants to print:");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        recurse(1, n);
    }
}
