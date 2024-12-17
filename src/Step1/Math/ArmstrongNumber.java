package Step1.Math;

public class ArmstrongNumber {
    private static boolean checkArmstrong(int num){
        int sum = 0;
        int k = String.valueOf(num).length();
        int n = num;
        while (n > 0){
            int temp = num %10;
            sum += Math.pow(temp, k);
            num = num / 10;
        }
        return sum == num ? true : false;
    }
    public static void main(String[] args) {
        int num = 153;
        boolean ans = checkArmstrong(num);
        System.out.println(ans);
    }
}


/*
A number is armstrong number if the sum of cube of the individual number is equal to that number
 */