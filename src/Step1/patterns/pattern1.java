package Step1.patterns;

import java.util.Scanner;
public class pattern1 {
    private static void box(int n){
        for (int i = 1; i <=n; i++) {
            for (int j = 1; j <=n; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        //takes the input from the user
        n = sc.nextInt();
        box(n);
    }
}
