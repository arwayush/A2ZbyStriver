package Step1.Math;
import java.util.Scanner;
public class GCDof2Numbers {

    //Brute force approach with the T.C of O(min(n, m))
    private static int BruteGCD(int n, int m){
        int gcd = 1;
        int mini = Math.min(n, m);
        for (int i = 1; i < mini; i++) {
            if(n%i == 0 && m%i == 0){
                gcd = i;
            }
        }
        return gcd;
    }

    //Better approach with the T.C. of O(min(n,m)) -> but it will starts from the bigger number till 1
    private static int BetterGCD(int n, int m){
        int gcd = 1;
        int mini = Math.min(n, m);
        for (int i = mini; i >=1; i--) {
            if(n%i == 0 && m%i == 0){
                gcd = i;
                break;
            }

        }
        return gcd;
    }

    //Using the Euclidean approach -> which says that GCD of 2 numbers remains same even if the smaller number is substracted from the larger number
    private static int OptimizedGCD(int n, int m){
        while (n>0 && m>0){
            if(n > m){
                n = n-m;
            }else{
                m = m-n;
            }
        }

        if(n == 0){
            return m;
        }else {
            return n;
        }
    }

    //main function where the program starts
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        sc.close();

        int ans = BruteGCD(num1, num2);
        System.out.println("The greatest common divisor of the 2 numbers is: " +ans);

        int ans2 = BetterGCD(num1, num2);
        System.out.println("The Greatest Common Divisor with better approach is: " +ans2);

        int ans3 = OptimizedGCD(num1, num2);
        System.out.println("The GCD from the optimized appoach is: " +ans3);
    }
}
/*

 */