package Step5.StringsBasic;

public class StringAnagram {
    public static boolean checkAnagrams(String str1, String str2) {
        if (str1.length() != str2.length()) return false;

        int[] freq = new int[128]; // Supports all ASCII characters

        for (int i = 0; i < str1.length(); i++) {
            freq[Character.toLowerCase(str1.charAt(i))]++; // Convert to lowercase
            freq[Character.toLowerCase(str2.charAt(i))]--; // Convert to lowercase
        }

        for (int count : freq) {
            if (count != 0) return false; // If any count is non-zero, not an anagram
        }
        return true;
    }


    public static void main(String[] args) {
        String Str1 = "INTEGER";
        String Str2 = "TEGERNI";
        System.out.println(checkAnagrams(Str1, Str2));
    }
}
