package string;

/*
Given an array of characters chars, compress it using the following algorithm:

Begin with an empty string s. For each group of consecutive repeating characters in chars:

If the group's length is 1, append the character to s.
Otherwise, append the character followed by the group's length.
The compressed string s should not be returned separately, but instead, be stored in the input character array chars. Note that group lengths that are 10 or longer will be split into multiple characters in chars.

After you are done modifying the input array, return the new length of the array.

You must write an algorithm that uses only constant extra space.

Note: The characters in the array beyond the returned length do not matter and should be ignored.



Example 1:

Input: chars = ["a","a","b","b","c","c","c"]
Output: 6
Explanation: The groups are "aa", "bb", and "ccc". This compresses to "a2b2c3".
Example 2:

Input: chars = ["a"]
Output: 1
Explanation: The only group is "a", which remains uncompressed since it's a single character.
Example 3:

Input: chars = ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
Output: 4
Explanation: The groups are "a" and "bbbbbbbbbbbb". This compresses to "ab12".
 */
public class StringCompression {

    public static void main(String[] args) {
        int l = 0;
        char[] input = { 'a', 'a', 'b', 'b', 'c', 'c', 'c' };
        l = compress(input);
        //System.out.println(compress(input));
        printArr(input, l);

        char[] input1 =
                { 'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b',
                        'b' };
        l = compress(input1);
        //System.out.println(compress(input1));
        printArr(input1, l);

        char[] input2 = { 'a' };
        l = compress(input2);
        //System.out.println(compress(input2));
        printArr(input2, l);
    }

    private static void printArr(char[] input, int l) {
        for (int i = 0; i < l; i++) {
            System.out.print(input[i] + " ");
        }
        System.out.println();
    }

    private static int compress(char[] chars) {

        char currentChar;
        int count, n = chars.length;
        int index = 0, i = 0;

        while (i < n) {

            currentChar = chars[i];
            count = 0;

            while (i < n && currentChar == chars[i]) {
                i++;
                count++;
            }

            chars[index++] = currentChar;

            if (count > 1) {
                char[] countArr = String.valueOf(count).toCharArray();
                for (int j = 0; j < countArr.length; j++) {
                    chars[index++] = countArr[j];
                }
            }
        }

        return index;

    }
}
