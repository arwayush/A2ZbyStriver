package Step5.StringsBasic;

public class LongestCommonPrefix {
    private static String longestCommon(String[] str){
        String res = str[0];
        for (int i = 1; i < str.length; i++) {
            res = common(res, str[i]);
        }
        return res;
    }
    private static String common(String s1, String s2){
        int mini = Math.min(s1.length(), s2.length());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < mini; i++) {
            if (s1.charAt(i) == s2.charAt(i)) {
                sb.append(s1.charAt(i));
            }else {
                break;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] str = {"flower", "flow", "flight"};
        String ans = longestCommon(str);
        System.out.println(ans);
    }
}
