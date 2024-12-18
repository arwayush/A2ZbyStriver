package Step1.Recursion;
//using the recursion we will do some questions
//printing from the 1 -> n
import java.util.Scanner;

public class Base {
    //function to print the number from 1 to n using recursion
    private static void print1toN(int i, int n){
        //base case
        if(i > n) return;
        System.out.println(i);
        print1toN(i+1, n);
    }

    //function to print the number from n to 1 using recursion
    private static void printNto1(int i, int n){
        //base condition
        if(i<1) return;
        System.out.println(i);
        printNto1(i-1, n);
    }

    //function to print the number from 1 to n without using func(n+1), but we will do this using backtracking
    private static void print1toNBackTrack(int i, int n){
        if(i <1) return; //base condition
        print1toNBackTrack(i-1, n);
        System.out.println(i);
    }

    //funtion to print number from n to 1, using backtrack
    private static void printNto1BackTrack(int i, int n) {
        if (i > n) return; // base case
        printNto1BackTrack(i + 1, n); // recursive call
        System.out.println(i); // print during backtracking
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
//        print1toN(1, n);
//        printNto1(n, n);
//        print1toNBackTrack(n,n);
        printNto1BackTrack(1, n);
    }
}
