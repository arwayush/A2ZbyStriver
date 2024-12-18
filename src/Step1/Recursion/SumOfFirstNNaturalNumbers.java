package Step1.Recursion;

import java.util.Scanner;

public class SumOfFirstNNaturalNumbers {

    //Brute force approach with the T.C. O(n)
    private static void Sum(int n){
        int sum = 0;
        for (int i = 1; i <=n; i++) {
            sum += i;
        }
        System.out.println(sum);
    }

    //Better Approach using the summation formula
    private static void Formula(int n){
        int sum = n * (n+1) / 2;
        System.out.println(sum);
    }

    //main function
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Sum(n);
        Formula(n);
    }
}
