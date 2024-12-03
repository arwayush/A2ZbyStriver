package Step1.patterns;

import java.util.Scanner;

public class pattern18 {
    private static void rightAngledTriangledAlpha(int n){
        for (int i = 0; i < n; i++) {
            char ch = (char)('E'- i);
            for (char j = ch; j<='E'; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        rightAngledTriangledAlpha(n);
    }
}


/*
E
DE
CDE
BCDE
ABCDE

 */