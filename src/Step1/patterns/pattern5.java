package Step1.patterns;

import java.util.Scanner;

public class pattern5 {
    private  static  void  reversedTriangle(int n){
        for (int i = 1; i <=n; i++) {
            for (int j = 0; j < n-i+1; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        reversedTriangle(n);
    }
}
/*
 * * * * *
 * * * *
 * * *
 * *
 *
 */