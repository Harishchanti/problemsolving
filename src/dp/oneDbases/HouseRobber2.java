package dp.oneDbases;
/*
You are a professional robber planning to rob houses along a street.
Each house has a certain amount of money stashed. All houses at this place are arranged in a circle.
That means the first house is the neighbor of the last one. Meanwhile,
adjacent houses have a security system connected, and it will automatically
contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house,
return the maximum amount of money you can rob tonight without alerting the police.


Example 1:

Input: nums = [2,3,2]
Output: 3
Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2), because they are adjacent houses.
Example 2:

Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.
Example 3:

Input: nums = [1,2,3]
Output: 3

 */

public class HouseRobber2 {
    private static int[] nums;

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        System.out.println(maxTheftIncircle(nums));
    }

    private static int maxTheftIncircle(int[] nums) {

        int l = nums.length;

        if (l == 1)
            return nums[0];

        if (l == 2)
            return Math.max(nums[0], nums[1]);

        int first = maxTheftIncircleUtil(nums, 0, l - 1);
        int last = maxTheftIncircleUtil(nums, 1, l);
        return Math.max(first, last);
    }

    private static int maxTheftIncircleUtil(int[] nums, int i, int l) {
        if (i >= l) {
            return 0;
        }

        int include = nums[i] + maxTheftIncircleUtil(nums, i + 2, l);
        int exclude = maxTheftIncircleUtil(nums, i + 1, l);

        return Math.max(include, exclude);
    }
}
