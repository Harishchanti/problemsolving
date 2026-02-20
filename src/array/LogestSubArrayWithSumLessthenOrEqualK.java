package array;

public class LogestSubArrayWithSumLessthenOrEqualK {
    public static void main(String[] args) {

        int[] arr = { 10, 5, 2, 7, 1, -10 };
        int k = 15;
        System.out.println(longestSubarray(arr, k));
    }

    private static int longestSubarray(int[] arr, int k) {
        int res = -1, l = 0;
        int tempSum = 0;
        for (int r = 0; r < arr.length; r++) {
            tempSum = arr[r];
            while (tempSum>k && l<r) {
                l++;
            }

            if (tempSum <= k) {
                res = Math.max(res, r - l + 1);
            }

        }
        return res;
    }
}
