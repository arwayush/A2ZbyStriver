package Step1.patterns;

import java.util.Scanner;

public class pattern13 {
    private static void rightAngledNumbers(int n){
        int num = 1;
        for (int i = 0; i <n; i++) {
            for (int j = 0; j<=i; j++){
                System.out.print(num+ " ");
                num++;
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        rightAngledNumbers(n);
    }
}

/*
1
2 3
4 5 6
7 8 9 10
11 12 13 14 15

 */