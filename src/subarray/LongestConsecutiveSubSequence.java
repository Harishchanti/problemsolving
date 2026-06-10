package subarray;

import java.util.HashSet;

/*
128. Longest Consecutive Sequence
Medium
Topics
premium lock icon
Companies
Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.



Example 1:

Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
Example 2:

Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9
Example 3:

Input: nums = [1,0,1,2]
Output: 3

 */
public class LongestConsecutiveSubSequence {
    public static void main(String[] args) {
        int[] a = { 100, 4, 200, 1, 3, 2 };
        HashSet<Integer> hs = new HashSet<>();
        int max = 0;

        for (int i : a)
            hs.add(i);

        for (int n : hs) {

            if (!hs.contains(n - 1)) {

                int s = n;
                int c = 1;

                while (hs.contains(s + 1)) {
                    c++;
                    s++;
                }

                if (c > max) {
                    max = c;
                }

            }

        }
        System.out.println(max);
    }
}
