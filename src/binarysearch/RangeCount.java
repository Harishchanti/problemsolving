package binarysearch;

public class RangeCount {
    public static int countInRange(int[] nums, int left, int right) {
        int start = lowerBound(nums, left);
        int end = upperBound(nums, right);

        System.out.println("start : "+ start  + " End : "+ end);
        return end - start;
    }

    // First index where nums[index] >= target
    private static int lowerBound(int[] nums, int target) {
        int low = 0;
        int high = nums.length;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] >= target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    // First index where nums[index] > target
    private static int upperBound(int[] nums, int target) {
        int low = 0;
        int high = nums.length;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] > target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    public static void main(String[] args) {

       /* int[] nums{ 1, 2, 4, 4, 5, 7, 8, 10 };

        System.out.println(countInRange(nums, 4, 7)); // 4
        System.out.println(countInRange(nums, 3, 4)); // 2
        System.out.println(countInRange(nums, 6, 9)); // 2
        System.out.println(countInRange(nums, 11, 20)); // 0*/

        int[] nums = {100,230,250,300,300,500};
        System.out.println(countInRange(nums, 120, 120));// 4 (5-1)
        System.out.println(countInRange(nums, 110, 250));// 2 (3-1)
        System.out.println(countInRange(nums, 300, 300));// 2 (5-3)
    }


}
