package dp;

import java.util.Arrays;

public class LogestIncreasingSubSequence {
    public static void main(String[] args) {
        int[] nums = { 10, 9, 2, 5, 3, 7, 101,
                18 };// {2,2,2} => 1 ;//{3, 4, 5, 1, 2, 3, 4}; => 4 //{5, 8, 3, 7, 9, 1}; => 3 //{ 10, 9, 2, 5, 3, 7, 101, 18 } =>4;
        int[][] dp = new int[nums.length + 1][nums.length + 1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        System.out.println(lengthOfLIS(nums, 0, -1, dp));
    }

    private static int lengthOfLIS(int[] nums, int i, int p, int[][] dp) {

        if (i >= nums.length)
            return 0;

        if (p != -1 && dp[i][p] != -1)
            return dp[i][p];

        int include = 0;
        if (p == -1 || nums[i] > nums[p]) {
            include = 1 + lengthOfLIS(nums, i + 1, i, dp);
        }
        int exclude = lengthOfLIS(nums, i + 1, p, dp);
        if (p != -1) {
            dp[i][p] = Math.max(include, exclude);
        }

        return p != -1 ? dp[i][p] : Math.max(include, exclude);

    }
}
