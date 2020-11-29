package company_interview;

import java.util.HashMap;
import java.util.Map;

public class Vera {

    /*
    Example 1:
Input: pattern = "abba", str = "dog cat cat dog"
Output: true
Example 2:
Input:pattern = "abba", str = "dog cat cat fish"
Output: false
Example 3:
Input: pattern = "aaaa", str = "dog cat cat dog"
Output: false
Example 4:
Input: pattern = "abba", str = "dog dog dog dog"
Output: false

     */
    public static void main(String[] args) {
        String pattern = "abba";
        String str = "dog cat cat dog";
        String[][] s = {{"abba", "dog cat cat dog"},
                {"abba", "dog cat cat fish"},
                {"aaaa", "dog cat cat dog"},
                {"abba", "dog dog dog dog"}
        };
        for (int i = 0; i < s.length; i++) {
            System.out.println(checkIffollwosPatterns(s[i][0], s[i][1]));
        }


        String[][] p = {{"aa", "a*"},
                {"aa", "a"},
                {"aaaabb", "a*aab*"},
                {"abc", "..."}
        };
        for (int i = 0; i < s.length; i++) {
            char[] pc = p[i][0].toCharArray();
            char[] pd = p[i][1].toCharArray();

            System.out.println(checkIfCorrectPattern(pc, pc.length, pd, pd.length,0,0));
        }


    }

    private static boolean checkIfCorrectPattern(char[] s, int sl, char[] p, int pl, int i, int j) {

        /*if(s[i] ==p[j]) return  true;

        if(p[j]=="*" && prv)

        if(p[i] =="*" && prev != s[i])
        if(s[i] !=  p[j]) return false;*/

    return false;
    }

    private static boolean checkIffollwosPatterns(String pattern, String str) {
        char[] c = pattern.toCharArray();
        String[] s = str.split(" ");
        Map<Character, String> map = new HashMap<>();
        if (c.length != s.length) return false;

        for (int i = 0; i < c.length; i++) {

            String temp = map.get(c[i]);

            if (temp != null && !temp.equalsIgnoreCase(s[i])) return false;

            map.put(c[i], s[i]);
        }
        return true;
    }
}
