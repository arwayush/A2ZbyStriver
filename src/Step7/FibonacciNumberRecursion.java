package Step7;

public class FibonacciNumberRecursion {
    private static int fib(int n){
        if (n <= 1) return n;
        return fib(n-1) + fib(n-2);
    }
    public static void main(String[] args) {
        int n = 8;
        System.out.println(fib(n));
    }
}
/*
to find the f(n), we need to find the f(n-1) and f(n-2)

 */