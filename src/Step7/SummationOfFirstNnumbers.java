package Step7;

import java.util.Scanner;

public class SummationOfFirstNnumbers {
    private static void summation(int i, int sum){
      if (i < 1){
          System.out.println(sum);
          return;
      }
      summation(i-1, sum+i);
    }
    private static int functionalRecursion(int n){
        if (n == 0) return 0; //base condition
        return n + functionalRecursion(n-1);
    }
    public static void main(String[] args) {
        System.out.print("Give the Number: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        summation(n, 0);
        int sum = functionalRecursion(n);
        System.out.println(sum);
    }
}
