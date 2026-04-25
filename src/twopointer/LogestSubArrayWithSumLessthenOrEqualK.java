package twopointer;

public class LogestSubArrayWithSumLessthenOrEqualK {
    public static void main(String[] args) {

        int[] arr = { 10, 5, 2, 17, 1, 10, 1, 1, 4 };
        int k = 15;
        System.out.println(longestSubarray(arr, k));
    }

    private static int longestSubarray(int[] arr, int k) {
        int res = -1, l = 0;
        int tempSum = 0;

        for (int r = 0; r < arr.length; r++) {
            tempSum += arr[r];
            while (tempSum > k && l <= r) {
                tempSum -= arr[l];
                l++;
            }

            if (tempSum <= k) {
                res = Math.max(res, r - l + 1);
            }

        }
        return res;
    }
}
