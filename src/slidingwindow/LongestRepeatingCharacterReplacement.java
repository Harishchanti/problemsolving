package slidingwindow;

import java.util.HashMap;
import java.util.Map;

/*
You are given a string s consisting of only uppercase english characters and an integer k. You can choose up to k characters of the string and replace them with any other uppercase English character.

After performing at most k replacements, return the length of the longest substring which contains only one distinct character.

Example 1:

Input: s = "XYYX", k = 2

Output: 4
Explanation: Either replace the 'X's with 'Y's, or replace the 'Y's with 'X's.

Example 2:

Input: s = "AAABABB", k = 1

Output: 5
Constraints:

1 <= s.length <= 100,000
0 <= k <= s.length
s consists of only uppercase english characters.

 */
public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {

        String s = "XYYX";
        int k = 2;

        System.out.println(getLongestRepeatingCharacterReplacement(s, k));
    }

    private static int getLongestRepeatingCharacterReplacement(String s,
            int k) {
        int l = 0, r = 0, n = s.length(), max = 0, maxFeq = 0;
        char[] c = s.toCharArray();
        Map<Character, Integer> feq = new HashMap<>();

        while (r < n) {

            feq.put(c[r], feq.getOrDefault(c[r], 0) + 1);

            maxFeq = Math.max(maxFeq, feq.get(c[r]));

            while ((r - l + 1) - maxFeq > k) {
                feq.put(c[l], feq.get(c[l]) - 1);
                l++;
            }
            max = Math.max(max, r - l + 1);
            r++;

        }
        return max;
    }
}
