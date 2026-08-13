package slidingwindow;

import java.util.*;

public class PermutationInString {
    public static void main(String[] args) {
        String s1 = "trinitrophenylmethylnitramine";
        String s2 = "dinitrophenylhydrazinetrinitrophenylmethylnitramine";
        System.out.println(checkInclusion(s1, s2));
    }

    public static boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> feqMap = new HashMap<>();
        int requiredCount = s1.length();

        for (Character c : s1.toCharArray()) {
            feqMap.put(c, feqMap.getOrDefault(c, 0) + 1);
        }

        System.out.println(feqMap);
        int l = 0, r = 0, len = s2.length(), w = s1.length();

        while (r < len) {

            char key = s2.charAt(r);

            if ((r - l + 1) > w) {
                char t = s2.charAt(l);

                feqMap.put(t, feqMap.get(t) + 1);

                if(feqMap.get(t) > 0) {
                    requiredCount++;
                }
                l++;
            }

            if (feqMap.containsKey(key) && feqMap.get(key) > 0) {
                requiredCount--;
            }

            feqMap.put(key, feqMap.getOrDefault(key,0) - 1);

            if ((r - l + 1) == w && requiredCount == 0)
                return true;

            r++;

        }

        return false;
    }
}
