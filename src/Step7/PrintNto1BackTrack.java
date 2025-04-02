package Step7;

import java.util.Scanner;

public class PrintNto1BackTrack {
    private static void PrintReverseBackTrack(int i, int n){
        if (i > n) return; //base case
        PrintReverseBackTrack(i+1, n);
        System.out.println(i);

    }
    public static void main(String[] args) {
        System.out.print("Give the Number: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PrintReverseBackTrack(1,n);
    }
}
