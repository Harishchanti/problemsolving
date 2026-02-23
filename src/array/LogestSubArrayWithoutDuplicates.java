package array;

public class LogestSubArrayWithoutDuplicates {
    public static void main(String[] args) {

        String input = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(input));

    }

    public static int lengthOfLongestSubstring(String s) {

        if (s.length() <= 1)
            return s.length();

        boolean[] visted = new boolean[128];
        int r = 0, l = 0, res = 0;

        while (r < s.length()) {

            while (visted[s.charAt(r)]) {
                visted[s.charAt(l)] = false;
                l++;
            }

            visted[s.charAt(r)] = true;

            res = Math.max(res, r - l + 1);
            r++;

        }
        return res;
    }
}
