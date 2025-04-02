package Step7;

public class ChekIfTheStringIsPallindromRecursion {
//    t.c. is O(n/2) and S.C. is auxillary space
    private static boolean PallindromeCheck(String str, int i, int n){
        if (i >= n/2) return true;
        if (str.charAt(i) != str.charAt(n - i - 1)) return false;
        return PallindromeCheck(str, i+1,n);
    }
    public static void main(String[] args) {
        String str = "MdaAM";
        int i = 0, n = str.length();
        System.out.println(PallindromeCheck(str, i, n));
    }
}
