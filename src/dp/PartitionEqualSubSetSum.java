package dp;

/*
416. partition equal subset sum mik

Given an integer array nums, return true if you can partition the array into two subsets such that the sum of the elements in both subsets is equal or false otherwise.



Example 1:

Input: nums = [1,5,11,5]
Output: true
Explanation: The array can be partitioned as [1, 5, 5] and [11].
Example 2:

Input: nums = [1,2,3,5]
Output: false
Explanation: The array cannot be partitioned into equal sum subsets.


Constraints:

1 <= nums.length <= 200
1 <= nums[i] <= 100
 */
public class PartitionEqualSubSetSum {

    static Boolean[][] dp = new Boolean[201][20001];

    public static void main(String[] args) {
        int[] intput = { 1, 5, 11, 5 };
        System.out.println(canPartition(intput));
    }

    private static boolean canPartition(int[] intput) {
        /*
        1. If sum of all the elements in array is odd, then patition is not possible.
        2. if total sum of array s then, subarray sum must te s/2
         ie, x= s/2 => 2 * x = s;

         if we can find a subset whose sum is x, then we can say there is possiblity of patition with equal sum
           */
        int sum = 0, x;
        for (int i : intput) {
            sum += i;
        }
        if (sum % 2 != 0)
            return false;
        x = sum / 2;
        return canPartitionUtil(intput, x, 0);
    }

    private static boolean canPartitionUtil(int[] intput, int targetSum,
            int idx) {

        if (targetSum == 0) {
            return true;
        }

        if (targetSum < 0) {
            return false;
        }
        if (idx >= intput.length) {
            return false;
        }

        if (dp[idx][targetSum] != null) {
            return dp[idx][targetSum];
        }

        boolean take = false;
        if (targetSum >= intput[idx]) {
            take = canPartitionUtil(intput, targetSum - intput[idx], idx + 1);
        }
        boolean notTake = canPartitionUtil(intput, targetSum, idx + 1);

        return dp[idx][targetSum] = (take || notTake);
    }
}
