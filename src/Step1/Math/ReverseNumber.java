package Step1.Math;

public class ReverseNumber {
    private static int reverse(int n){
        int num = 0;
        while (n > 0){
            int temp = n%10;
            num = num * 10 + temp;
            n /= 10;
        }
        return num;
    }
    public static void main(String[] args) {
        int n = 2345566;
        int reversed = reverse(n);
        System.out.println("The ans from the brute force approach is:" +reversed);
    }
}
