package Step1.patterns;

import java.util.Scanner;

public class pattern14 {
    private static void rightAngledtriangle(int n){
        for (int i = 0; i < n; i++) {
            int ascii = 65;
            for (int j = 0; j <=i; j++) {
                char ch = (char)ascii;
                System.out.print(ch+ " ");
                ascii++;
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        rightAngledtriangle(n);
    }
}
/*
A
A B
A B C
A B C D
A B C D E j
 */
