package Step5.StringsBasic;

public class RemoveOutermostParenthesis {
    public static String removeOuterParentheses(String s) {
        StringBuilder result = new StringBuilder();
        int balance = 0; // Keeps track of the depth of parentheses

        for (char c : s.toCharArray()) {
            if (c == '(') {
                if (balance > 0) {
                    result.append(c); // Append only if it's not an outermost '('
                }
                balance++;
            } else if (c == ')') {
                balance--;
                if (balance > 0) {
                    result.append(c); // Append only if it's not an outermost ')'
                }
            }
        }

        return result.toString();
    }
    public static void main(String[] args) {
        String str = new String("(()())(())");
        String ans = removeOuterParentheses(str);
        System.out.println(ans);
    }
}

/*
 System.out.println('a' + 'b'); -> converts to the ascii value
        System.out.println("a" + "b"); -> takes the string value
        System.out.println((char) ('a' + 3)); ->
        when an integer is concatenated with a string, it is converted to its wrapper class integer, it will be converted to its wrapper class and it will call the toString() method




        System.out.printf("formated number is %.1f", a);
        System.out.println();
        System.out.printf("Pi is %.2f",  Math.PI);
        System.out.printf("I am %s the only person in the world who is %s", "Ayush","Billionare");






























 */