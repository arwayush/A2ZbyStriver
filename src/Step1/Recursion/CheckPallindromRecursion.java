package Step1.Recursion;

public class CheckPallindromRecursion {
    private static boolean pallin(int i, String str){
        int n = str.length();
        //base condition
        if(i >= n/2) return true; //if at any position, this situation comes
        if(str.charAt(i) != str.charAt(n-i-1)) return false; //if any two pointers are not equal
        return pallin(i+1, str); //recursive call
    }
    public static void main(String[] args) {
        String str = "MADAM";
        System.out.println("The given string is pallindrome:" +pallin(0, str));
    }
}
//T.C. will be O(n/2)
