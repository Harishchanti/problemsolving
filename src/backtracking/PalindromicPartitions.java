package backtracking;

/*
Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.



Example 1:

Input: s = "aab"
Output: [["a","a","b"],["aa","b"]]
Example 2:

Input: s = "a"
Output: [["a"]]
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PalindromicPartitions {
    public static void main(String[] args) {
        String input = "aab";
        List<List<String>> result = new ArrayList<>();
        List<String> curr = new ArrayList<>();
        findAllPalindromicPartition(input, curr, result);
        result.forEach(System.out::println);
    }

    private static void findAllPalindromicPartition(String input,
            List<String> curr,
            List<List<String>> result) {

        if (input.isEmpty()) {
            result.add(new ArrayList<>(curr));
            return;
        }
        for (int i = 0; i < input.length(); i++) {
            String part = input.substring(0, i + 1);

            if (isPalindromString(part)) {

                curr.add(part);

                findAllPalindromicPartition(input.substring(i + 1), curr,
                        result);

                curr.remove(curr.size() - 1);
            }
        }

    }

    private static boolean isPalindromString(String substring) {
        String rev = new StringBuilder(substring).reverse().toString();
        return rev.equalsIgnoreCase(substring);
    }
}
