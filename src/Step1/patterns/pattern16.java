package Step1.patterns;

import java.util.Scanner;

public class pattern16 {
    private static void rightAngled(int n){
        for (int i = 0; i < n; i++) {
            int ch = 65 + i;
            for (int j = 0; j <=i; j++) {
                System.out.print((char)ch);
            }

            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        rightAngled(n);
    }
}


/*
A
BB
CCC
DDDD
EEEEE
 */
