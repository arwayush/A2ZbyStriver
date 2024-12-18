package Step1.Recursion;

public class SumOfFirstNNaturalNumbersRecursion {
    public static int func(int n){
        //base case
        if(n==0) return 0;
        return n + func(n-1);
    }
    public static void main(String[] args) {
        int n = 5;
        System.out.println(func(n));
    }
}
