package Step1.patterns;
import java.util.Scanner;
public class pattern7 {
    private  static void pyramid(int N){
        for (int i = 0; i < N; i++) {
            // For printing the spaces before stars in each row
            for (int j = 0; j < N - i - 1; j++) {
                System.out.print(" ");
            }

            // For printing the stars in each row
            for (int j = 0; j < 2 * i + 1; j++) {

                System.out.print("*");
            }

            // For printing the spaces after the stars in each row
            for (int j = 0; j < N - i - 1; j++) {
                System.out.print(" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        pyramid(n);
    }
}
/*
5 number of rows
1 -> 1 col [4,1,4]
2 -> 3 col [3,3,3]
3 -> 5 col [2,5,2]
4 -> 7 col [1,7,1]
5 -> 9 col [0,9,0]
 */