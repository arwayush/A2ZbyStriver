package Step1.Math;

public class CheckPallindrome {
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
        int num = 12221;
        int rev = reverse(num);
        //if the reverse of number is equal to the number than it is palindrome
        if(num == rev){
            System.out.println("yes, It is palindrome.");
        }else{
            System.out.println("No");
        }
    }
}
