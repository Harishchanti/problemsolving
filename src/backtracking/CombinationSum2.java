package backtracking;

import java.util.*;

/*
Combination Sum II
Medium
Topics
Company Tags
Hints
You are given an array of integers candidates, which may contain duplicates, and a target integer target. Your task is to return a list of all unique combinations of candidates where the chosen numbers sum to target.

Each element from candidates may be chosen at most once within a combination. The solution set must not contain duplicate combinations.

You may return the combinations in any order and the order of the numbers in each combination can be in any order.

Example 1:

Input: candidates = [9,2,2,4,6,1,5], target = 8

Output: [
  [1,2,5],
  [2,2,4],
  [2,6]
]
Example 2:

Input: candidates = [1,2,3,4,5], target = 7

Output: [
  [1,2,4],
  [2,5],
  [3,4]
]
 */
public class CombinationSum2 {

    static Set<List<Integer>> result = new HashSet<>();

    public static void main(String[] args) {
        int[] candidates = { 9, 2, 2, 4, 6, 1, 5 };
        int target = 8;
        combinationSum2(candidates, target);

        result.forEach(r -> {
            r.forEach(g -> System.out.print(g + " "));
            System.out.println();
        });
    }

    public static List<List<Integer>> combinationSum2(int[] candidates,
            int target) {
        List<Integer> current = new ArrayList<>();
        Arrays.sort(candidates);
        generateAllPossibleCombinaitonSum(candidates, 0, target, current);
        return new ArrayList<>(result);
    }

    static void generateAllPossibleCombinaitonSum(int[] nums, int pos,
            int target, List<Integer> current) {

        if (target < 0) {
            return;
        }

        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = pos; i < nums.length; i++) {

            if (i > pos && nums[i] == nums[i - 1]) {
                continue;
            }
            current.add(nums[i]);
            generateAllPossibleCombinaitonSum(nums, i + 1, target - nums[i],
                    current);
            current.remove(current.size() - 1);
        }

    }
}
