package Step5.StringsMedium;

public class ReverseEveryWordInAString {

    private static String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");  // Ensures multiple spaces are handled
        StringBuilder ans = new StringBuilder();

        for (String word : words) {
            StringBuilder reversedWord = new StringBuilder(word).reverse();
            ans.append(reversedWord).append(" ");
        }

        return ans.toString().trim();  // Trim to remove extra space at the end
    }

    public static void main(String[] args) {
        String s = "Arwayush is coding";
        System.out.println(reverseWords(s));  // Expected: "hsuyawrA si gnidoc"
    }
}
