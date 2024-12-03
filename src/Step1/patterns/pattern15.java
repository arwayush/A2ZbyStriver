package Step1.patterns;

import java.util.Scanner;

public class pattern15 {
    private static void invertedRightTriangle(int n){
        for (int i = 0; i < n; i++) {
            char ch = 'A';
            for (int j = 1; j<=n-i ; j++) {
                System.out.print(ch);
                ch++;
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        invertedRightTriangle(n);
    }
}

/*
ABCDE -
ABCD
ABC
AB
A
 */
