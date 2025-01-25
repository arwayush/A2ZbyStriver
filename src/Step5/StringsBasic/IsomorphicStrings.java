package Step5.StringsBasic;

import java.util.*;

public class IsomorphicStrings {
    public static boolean checkIsoEfficient(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;

        Map<Character, Character> mapping = new HashMap<>();
        Set<Character> mappedValues = new HashSet<>(); // Tracks already mapped characters

        for (int i = 0; i < s1.length(); i++) {
            char original = s1.charAt(i);
            char replacement = s2.charAt(i);

            if (mapping.containsKey(original)) {
                if (mapping.get(original) != replacement)
                    return false; // Mismatch in mapping
            } else {
                if (mappedValues.contains(replacement))
                    return false; // Ensures bijective mapping (one-to-one)

                mapping.put(original, replacement);
                mappedValues.add(replacement);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String st = "egg";
        String st2 = "add";
//        System.out.println(checkIsobrute(st, st2));
        System.out.println(checkIsoEfficient(st, st2));
    }
}
