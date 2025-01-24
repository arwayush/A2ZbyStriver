package Step5.StringsBasic;

public class LargestOddNumberInString {
    private static String func(String str){
        int len = str.length()-1;
        while (len >= 0){
            int d = str.charAt(len) - '0';
            if(d %2 == 1)
                return str.substring(0, len+1);
            len--;
        }
        return "";
    }
    public static void main(String[] args) {
        String str = "2345667654";
        String ans = func(str);
        System.out.println(ans);
    }
}
/*
last se traverse karne par jo bhi odd number mil jaaye
waha se 0 - last odd number

 */