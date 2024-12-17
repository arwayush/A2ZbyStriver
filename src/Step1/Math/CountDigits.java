package Step1.Math;
import java.util.Scanner;

public class CountDigits {
    // Function to count the number
    // of digits in an integer 'n'.
    public static int countDigits(int n) {
        // Initialize a counter variable
        // 'cnt' to store the count of digits.
        int cnt = 0;
        // While loop iterates until 'n'
        // becomes 0 (no more digits left).
        while (n > 0) {
            // Increment the counter
            // for each digit encountered.
            cnt = cnt + 1;
            // Divide 'n' by 10 to
            // remove the last digit.
            n = n / 10;
        }
        // Return the
        // count of digits.
        return cnt;
    }

    private static int OptimizedCountDigits(int n){
        int cnt = (int) (Math.log10(n) + 1);
        return cnt;
    }

    public static void main(String[] args) {
        int N = 329823;
        System.out.println("N: " + N);
        int digits = countDigits(N);
        System.out.println("Number of Digits in N: " + digits);
        int digit = OptimizedCountDigits(N);
        System.out.println("The number of digits from the optimized approach are:" +digit);
    }
}


