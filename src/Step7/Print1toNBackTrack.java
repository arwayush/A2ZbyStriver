package Step7;

import java.util.Scanner;

public class Print1toNBackTrack {
    private static void BackTrack(int i, int n){
        if (i < 1) return;
        BackTrack(i-1, n);
        System.out.println(i);
    }
    public static void main(String[] args) {
        System.out.print("Give the Number: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        BackTrack(n,n);
    }
}
