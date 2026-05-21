package backtracking;

import java.util.*;

/*
You are given an array nums of integers, which may contain duplicates. Return all possible subsets.

The solution must not contain duplicate subsets. You may return the solution in any order.

Example 1:

Input: nums = [1,2,1]

Output: [[],[1],[1,2],[1,1],[1,2,1],[2]]
Example 2:

Input: nums = [7,7]

Output: [[],[7], [7,7]]
 */
// [Naive Approach] Using Recursion – O(2^n) Time and O(n) Space
public class SubSet2 {
    static List<List<Integer>> result = new ArrayList<>();

    public static void main(String[] args) {
        int[] nums = { 1, 2, 1 };
        subsetsWithDup(nums);
        result.forEach(r -> {
            r.forEach(g -> System.out.print(g + " "));
            System.out.println();
        });

        /*List<List<Integer>> r = new ArrayList<>();
        r.add(Arrays.asList(1,3,3));r.add(Arrays.asList(1,2,3));

        System.out.println(r.contains(Arrays.asList(1,3,3)));*/
    }

    public static void subsetsWithDup(int[] nums) {
        List<Integer> current = new ArrayList<Integer>();
        Arrays.sort(nums);
        findSubset(nums, 0, current);
    }

    static void findSubset(int[] nums, int pos, List<Integer> current) {

        if (result.contains(current)) {
            return;
        }

        result.add(new ArrayList<>(current));

        for (int i = pos; i < nums.length; i++) {
            current.add(nums[i]);

            findSubset(nums, i + 1, current);

            current.remove(current.size() - 1);
        }

    }
}
