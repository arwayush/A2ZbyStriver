package Step1.patterns;

import java.util.Scanner;

public class pattern8 {
        private  static void reversepyramid(int n){
        for (int i = 0; i <n; i++) {
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
            reversepyramid(n);
        }
}
/*
 0 -> 0,9,0
 1 -> 1,7,1
 2 -> 2,5,2
 3 -> 3,3,3
 4 -> 4,1,4
 */