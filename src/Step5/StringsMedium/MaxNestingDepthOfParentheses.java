package Step5.StringsMedium;

public class MaxNestingDepthOfParentheses {
    private static int Nesting(String s){
        int maxCnt = 0;
        int cnt = 0;
        for(char c : s.toCharArray()){
            if(c == '('){
                cnt++;
            }else if (c == ')'){
                cnt--;
            }
            maxCnt = Math.max(cnt, maxCnt);
        }
        return maxCnt;
    }
    public static void main(String[] args) {
        String s = "(1+(2*3)+((8)/4))+1";
        System.out.println(Nesting(s));
    }
}
