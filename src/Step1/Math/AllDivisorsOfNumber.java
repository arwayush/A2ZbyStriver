package Step1.Math;

public class AllDivisorsOfNumber {
    //brute force approach runs with the T.C. of O(n)
    private static void divisor(int num){
        for (int i = 1; i<=num; i++) {
            if(num % i == 0){
                System.out.print(i+ " ");
            }
        }
        System.out.println();
    }

    //Better approach with the T.C; of O(sqrt(n))
    private static void optimized(int num){
        int sqrt = (int) Math.sqrt(num);
        for (int i = 1; i <= sqrt; i++) {
            if(num % i == 0){
                System.out.print(i+ " ");
                if(i != num/i){
                    System.out.print(num/i+ " ");
                }
            }
        }

    }

    public static void main(String[] args) {
        int n = 12;
        divisor(n);
        optimized(n);
    }
}
