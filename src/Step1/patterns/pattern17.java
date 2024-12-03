package Step1.patterns;

import java.util.Scanner;

public class pattern17 {
    private static void pyramidAlpha(int n){
        for (int i = 0; i < n; i++) {
            //space
            for (int j = 0; j <n-i-1; j++) {
                System.out.print(" ");
            }
            //alphabet
            int ch = 65;
            int breakpoint = (2*i+1)/2;
            for (int j = 1; j <=2*i+1 ; j++) {
                System.out.print((char)ch);
                if(j<= breakpoint) ch++;
                else ch--;
            }
            //space
            for (int j = 0; j <n-i-1; j++) {
                System.out.print(" ");
            }

            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        pyramidAlpha(n);
    }
}


/*
     A
    ABA
   ABCBA
  ABCDCBA
 ABCDEDCBA
ABCDEFEDCBA

 */
