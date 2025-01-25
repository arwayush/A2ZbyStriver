package Step5.StringsBasic;

public class RotationOfString {
    private static boolean checkRotation(String s, String goal){
        if (s.length() != goal.length()) return false;
        return (s+s).contains(goal);
    }
    public static void main(String[] args) {
        String s = "abcde";
        String t = "ebdca";
        System.out.println(checkRotation(s, t));
    }
}
