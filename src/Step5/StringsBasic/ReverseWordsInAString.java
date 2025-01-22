package Step5.StringsBasic;
import java.util.*;
public class ReverseWordsInAString {
    private static void Brute(String str){
        String[] split = str.split(" ");
        StringBuilder ans = new StringBuilder();
        for(int i = split.length-1; i>=0; i--){
            System.out.println(split[i]);
        }
    }

    private static void StackApproach(String str){
        Stack<String> st = new Stack<>();
        StringBuilder word = new StringBuilder();
        str = str.trim();
        for(char c : str.toCharArray()){

        }
    }

    public static void main(String[] args) {
        String str = "This is an amazing program";
        Brute(str);
        StackApproach(str);
    }
}
