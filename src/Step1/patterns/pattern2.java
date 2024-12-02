package Step1.patterns;

import java.util.Scanner;

public class pattern2 {
    private static void rightAngledTriangle(int n){
        for (int i = 1; i <=n; i++) {
            for(int j=1; j<=i; j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        rightAngledTriangle(n);
    }
}
