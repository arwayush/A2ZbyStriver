package Step5.StringsMedium;

public class SumOfBeautyOfAllSubstrings {

    private static int beauty(int[] freq) {
        int maxFreq = Integer.MIN_VALUE;
        int minFreq = Integer.MAX_VALUE;

        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                maxFreq = Math.max(maxFreq, freq[i]);
                minFreq = Math.min(minFreq, freq[i]);
            }
        }
        return maxFreq - minFreq;
    }

    private static int beautySumed(String s) {
        int res = 0;

        for (int i = 0; i < s.length(); i++) {
            int[] freq = new int[26];

            for (int j = i; j < s.length(); j++) {
                freq[s.charAt(j) - 'a']++;  // Fix: Use 'j' instead of 'i'
                res += beauty(freq);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "aabcbaa";
        System.out.println(beautySumed(s));  // Corrected function call
    }
}
