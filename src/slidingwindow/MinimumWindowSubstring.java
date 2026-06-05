package slidingwindow;

import java.util.*;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        /*
        Input: s = "OUZODYXAZV", t = "XYZ"

Output: "YXAZ"


Input: s = "x", t = "xy"

Output: ""

Input: s = "xyz", t = "xyz"

Output: "xyz"

Input: s = "aa", t = "aa"

Output: "aa"

         */
        String s = "OUZODYXAZV", t = "XYZ";
        System.out.println(minWindow(s, t));
    }

    static String minWindow(String s, String t) {

        if (t.isEmpty() || s.length() < t.length())
            return "";

        int i = 0, j = 0, requiredCount = 0, start_i = 0;
        int minWindowSize = Integer.MAX_VALUE;

        Map<Character, Integer> charMap = new HashMap<>();

        for (char c : t.toCharArray()) {
            requiredCount++;
            charMap.put(c, charMap.getOrDefault(c, 0) + 1);
        }

        while (j < s.length()) {

            char c = s.charAt(j);

            if (charMap.containsKey(c) && charMap.get(c) > 0) {
                requiredCount--;
            }

            charMap.put(c,charMap.getOrDefault(c,0)-1);

            while (requiredCount == 0) {

                charMap.compute(s.charAt(i), (k, count) -> count + 1);

                if (charMap.get(s.charAt(i)) > 0) {
                    requiredCount++;
                }

                if (minWindowSize > (j - i + 1)) {
                    minWindowSize = j - i + 1;
                    start_i = i;
                }
                i++;

            }
            j++;
        }
        System.out.println(
                "start_i : " + start_i + " minWindowSize : " + minWindowSize);
        return minWindowSize != Integer.MAX_VALUE ?
                s.substring(start_i, start_i + minWindowSize) : "";

    }
}
