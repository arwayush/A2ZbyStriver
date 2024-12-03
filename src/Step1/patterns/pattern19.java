package Step1.patterns;

import java.util.Scanner;

public class pattern19 {
    private static void patt(int n){

        //first half
        int inis = 0;
        for (int i = 0; i <n; i++) {
            //stars
            for (int j = 1; j <=n-i ; j++) {
                System.out.print("*");
            }
            //spaces
            for (int j = 0; j < inis; j++) {
                System.out.print(" ");
            }
            //stars
            for (int j = 1; j <=n-i ; j++) {
                System.out.print("*");
            }
            inis += 2;
            System.out.println();
        }

        //2nd half
        inis = 8;
        for (int i = 1; i <=n ; i++) {
            //stars
            for (int j = 1; j <=i ; j++) {
                System.out.print("*");
            }
            //spaces
            for (int j = 0; j < inis; j++) {
                System.out.print(" ");
            }
            //stars
            for (int j = 1; j <=i; j++) {
                System.out.print("*");
            }
            inis -= 2;
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        patt(n);
    }
}

/*
   stars spaces stars

0 -> 5 0 5
1 -> 4 2 4
2 -> 3 4 3
3 -> 2 6 2
4 -> 1 8 1
5 -> 1 8 1
6
7
8
9
 */
