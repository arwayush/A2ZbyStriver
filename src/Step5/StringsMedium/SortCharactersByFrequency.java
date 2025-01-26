package Step5.StringsMedium;

import java.util.*;

public class SortCharactersByFrequency {
    private static void Sort(String str){
        HashMap<Character, Integer> mp = new HashMap<>();

        // Count frequency of each character
        for (char ch : str.toCharArray()) {
            mp.put(ch, mp.getOrDefault(ch, 0) + 1);
        }

        // Store frequency-to-character mappings in a list
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(mp.entrySet());

        // Sort list based on frequency in descending order
        list.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        // Build sorted output string
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : list) {
            char ch = entry.getKey();
            int freq = entry.getValue();
            sb.append(String.valueOf(ch).repeat(freq)); // Append character 'freq' times
        }

        System.out.println(sb.toString());


    }
    public static void main(String[] args) {
        String s = "tree";
        Sort(s);
    }
}
/*
Input is :- tree
output is :- eert
 */
