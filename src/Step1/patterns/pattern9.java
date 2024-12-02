package Step1.patterns;

import java.util.Scanner;

public class pattern9 {
    private static void doublesidedtriangle(int n){
        for (int i = 0; i <=n; i++) {
            //space
            for (int j = 0; j <n-i-1; j++) {
                System.out.print(" ");
            }
            //stars
            for (int j = 0; j <2*i+1; j++) {
                System.out.print("* ");
            }
            //space
            for (int j = 0; j < n-i-1; j++) {
                System.out.print(" ");
            }
            System.out.println();
        }
        for (int i = 0; i <=n; i++) {
            //space
            for (int j=0; j<i; j++) {
                System.out.print(" ");
            }
            //stars
            for (int j=0; j<2*n-(2*i+1); j++) {
                System.out.print("* ");
            }
            //space
            for (int j=0; j<i; j++) {
                System.out.print(" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        doublesidedtriangle(n);
    }
}
