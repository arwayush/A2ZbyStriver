package Step7;

import java.util.Scanner;

public class PrintNto1 {
    private static void ReversePrint(int i, int n){
        if (i < 1) return;
        System.out.println(i);
        ReversePrint(i-1, n);
    }
    public static void main(String[] args) {
        System.out.print("Give the Number: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ReversePrint(n, n);
    }
}
