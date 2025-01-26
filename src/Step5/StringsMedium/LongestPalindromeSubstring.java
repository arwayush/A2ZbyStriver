package Step5.StringsMedium;

public class LongestPalindromeSubstring {

    // Function to check if a substring is a palindrome
    public static boolean isPalindrome(String s, int i, int j){
        while (i < j){
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

    // Function to find the longest palindromic substring
    private static String longestPalindrome(String s){
        int n = s.length();
        int maxi = 0, start = 0, end = 0; // Moved inside function to avoid static variable issues

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (isPalindrome(s, i, j)) {
                    if((j - i + 1) > maxi){
                        maxi = j - i + 1;
                        start = i;
                        end = j;
                    }
                }
            }
        }
        return s.substring(start, end + 1);
    }

    public static void main(String[] args) {
        String s = "babad";
        System.out.println(longestPalindrome(s));
    }
}
