package backtracking;

import java.util.*;

/*
Given an array nums of unique integers, return all possible subsets of nums.

The solution set must not contain duplicate subsets. You may return the solution in any order.

Example 1:

Input: nums = [1,2,3]

Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
Example 2:

Input: nums = [7]

Output: [[],[7]]
 */
// [Naive Approach] Using Recursion – O(2^n) Time and O(n) Space
public class SubSet {
    static List<List<Integer>> result = new ArrayList<>();

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        subsets(nums);
        result.forEach(r -> {
            r.forEach(g -> System.out.print(g+" "));
            System.out.println();
        });
    }

    public static void subsets(int[] nums) {
        List<Integer> current = new ArrayList<Integer>();

        findSubset(nums, 0, current);
    }

    static void findSubset(int[] nums, int pos, List<Integer> current) {

        if (pos >= nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        current.add(nums[pos]);
        findSubset(nums, pos + 1, current);

        current.remove(current.size() - 1);
        findSubset(nums, pos + 1, current);

    }
}
