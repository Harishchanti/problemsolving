package string;

import java.util.Stack;

public class FindPalindromString {
    public static void main(String[] arg) {
        String testString1 = "1234xyzyx5678";
        String testString2 = "madam";
        String testString3 = "abcc";
        String testString4 = "not";
        String testString5 = "abcdefghijklmnopqrstuvwxyz";
        String testString6 = "1232";
        System.out.println(testString1 + " " + isPalindrom(testString1));
        System.out.println(testString2 + " " + isPalindrom(testString2));
        System.out.println(testString3 + " " + isPalindrom(testString3));
        System.out.println(testString4 + " " + isPalindrom(testString4));
        System.out.println(testString5 + " " + isPalindrom(testString5));
        System.out.println(testString6 + " " + isPalindrom(testString6));
    }

    private static boolean isPalindrom(String str) {

        Stack<Character> s = new Stack<Character>();
        char[] carArr = str.toCharArray();
        for (int i = 0; i < carArr.length; i++) {
            char c = carArr[i];
            if (!s.empty()) {
                char top = s.peek();
                if (c == top) {
                    return true;
                }
                if (s.size() > 1) {
                    s.pop();
                    char sec = s.peek();
                    if (c == sec) {
                        return true;
                    } else {
                        s.push(top);
                    }
                }
            }
            s.push(c);
        }
        return false;
    }
}
