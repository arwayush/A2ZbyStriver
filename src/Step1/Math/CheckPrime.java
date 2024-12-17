package Step1.Math;

public class CheckPrime {
    //It takes the O(n) time complexity as it runs from the 1 -> number
    private static boolean brute(int num){
        for (int i = 2; i <num ; i++) {
            if(num%i == 0){
                return false;
            }
        }
        return true;
    }

    //Optimized approach with the time complexity of O(sqrt(n))
    private static boolean Optimal(int num){
        int sqrt = (int)Math.sqrt(num);
        for (int i = 2; i < sqrt; i++) {
            if(num%i == 0){
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        int num  = 5;
        System.out.println(brute(num));
        System.out.println(Optimal(num));
    }
}
