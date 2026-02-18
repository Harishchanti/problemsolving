package array;

public class LongestPalindromicSubString {
    public static void main(String[] args) {
        String s = "forgeeksskeegfor";
        System.out.println(getLongestPal(s));
    }

    /*
    Step-by-step approach:

* Iterate through each character in the string, treating it as the center of a potential palindrome.

* For each center, expand in two ways: one for odd-length palindromes (center at index i) and one for even-length palindromes (center between indices i and i+1)
* Use two pointers low and high to track the left and right boundaries of the current palindrome.
* While low and high are in bounds and s[low] == s[high], expand outward.
* If the current palindrome length (high - low + 1) is greater than the previous maximum, update the starting index and max length.
* After checking all centers, return the substring starting at start with length maxLen.
     */

    static String getLongestPal(String s) {
        int n = s.length();

        int start = 0, maxLen = 1;

        for (int i = 0; i < n; i++) {

            // this runs two times for both odd and even
            // length palindromes.
            // j = 0 means odd and j = 1 means even length
            for (int j = 0; j <= 1; j++) {
                int low = i;
                int high = i + j;

                // expand substring while it is a palindrome
                // and in bounds
                while (low >= 0 && high < n && s.charAt(low) == s.charAt(
                        high)) {
                    int currLen = high - low + 1;
                    if (currLen > maxLen) {
                        start = low;
                        maxLen = currLen;
                    }
                    low--;
                    high++;
                }
            }
        }

        return s.substring(start, start + maxLen);
    }

}
