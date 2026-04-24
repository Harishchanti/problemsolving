package backtracking;

import java.util.ArrayList;
import java.util.List;

/*
Input:  s = "ABC"
Output: "ABC", "ACB", "BAC", "BCA", "CAB", "CBA"

Input: s = "XY"
Output: "XY", "YX"

Input: s = "AAA"
Output: "AAA", "AAA", "AAA", "AAA", "AAA", "AAA" 
 */
public class PermutationOfStrings {
    public static void main(String[] args) {
        String input = "ABC";
        char[] cArr = input.toCharArray();
        List<String> result = new ArrayList<>();
        findAllPermutaions(cArr, 0, result);

        result.forEach(System.out::println);
    }

    private static void findAllPermutaions(char[] cArr, int idx,
            List<String> result) {

        if (idx >= cArr.length) {
            result.add(new String(cArr));
            return;
        }
        for (int i = idx; i < cArr.length; i++) {
            swapChar(cArr, i, idx);// Do something
            findAllPermutaions(cArr, idx + 1, result);// explore
            swapChar(cArr, i, idx);// Undo
        }
    }

    private static void swapChar(char[] cArr, int i, int j) {
        char c = cArr[i];
        cArr[i] = cArr[j];
        cArr[j] = c;
    }
}
