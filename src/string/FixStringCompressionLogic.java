package string;

import java.util.*;

/*
// Modifying limit: Maximum 2 lines allowed to change
public static String repairCompression(String s) {
    Map<Character, Integer> counts = new TreeMap<>();
    for (int i = 0; i < s.length(); i += 2) {
        char ch = s.charAt(i);
        int val = s.charAt(i + 1) - '0'; // BUG HERE: Fails if count > 9 (e.g., '1', '0')
        counts.put(ch, counts.getOrDefault(ch, 0) + val);
    }
    StringBuilder sb = new StringBuilder();
    for (Map.Entry<Character, Integer> entry : counts.entrySet()) {
        sb.append(entry.getKey()).append(entry.getValue());
    }
    return sb.toString();
}
 */
public class FixStringCompressionLogic {
    public static void main(String[] args) {
        String input = "a3c9b2c2";
        System.out.println(repairCompression(input));// a3b2c11
    }

    // Modifying limit: Maximum 2 lines allowed to change
    static String repairCompression(String s) {
        Map<Character, Integer> counts = new TreeMap<>();
        int i = 0, l = s.length();
        char[] cArr = s.toCharArray();
        char cs = '#';
        while (i < l) {
            char c = cArr[i];

            if (Character.isDigit(c)) {
                int num = 0;

                while (i < l && Character.isDigit(cArr[i])) {
                    num = num * 10 + cArr[i] - '0';
                    i++;
                }
                i--;
                counts.put(cs, counts.getOrDefault(cs, 0) + num);

            } else if (Character.isAlphabetic(c)) {

                cs = c;
            }
            i++;
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : counts.entrySet()) {
            sb.append(entry.getKey()).append(entry.getValue());
        }
        return sb.toString();
    }
}

       /* for (int i = 0; i < s.length(); i += 2) {
            char ch = s.charAt(i);
            int val = s.charAt(
                    i + 1) - '0'; // BUG HERE: Fails if count > 9 (e.g., '1', '0')
            counts.put(ch, counts.getOrDefault(ch, 0) + val);
        }/

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : counts.entrySet()) {
            sb.append(entry.getKey()).append(entry.getValue());
        }
        return sb.toString();
    }
}*/
