package Step1.patterns;

import java.util.Scanner;

public class pattern6 {
    private static void reverseTriangled(int n){
        for (int i = 1; i <=n; i++) {
            for (int j =1; j <=n-i+1; j++) {
                System.out.print(j+ " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int n;
        Scanner sc =new Scanner(System.in);
        n = sc.nextInt();
        reverseTriangled(n);
    }
}
/*
1 2 3 4 5
1 2 3 4
1 2 3
1 2
1
 */