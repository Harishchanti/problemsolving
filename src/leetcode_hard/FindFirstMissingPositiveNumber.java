package leetcode_hard;
/*
Given an unsorted integer array nums. Return the smallest positive integer that is not present in nums.

You must implement an algorithm that runs in O(n) time and uses O(1) auxiliary space.

 */
public class FindFirstMissingPositiveNumber {
    public static void main(String[] args) {
        int[] a = { 1, 1 };// {1,2,0}  , {3,4,-1,1} , {7,8,9,11,12}

        System.out.println(findFirstMissingPositiveNumber(a));
    }

    private static int findFirstMissingPositiveNumber(int[] nums) {
        int l = nums.length;
        for (int i = 0; i < l; i++) {

            while (nums[i] >= 1 && nums[i] <= l && nums[nums[i] - 1] != nums[i]) {
                swap(nums, nums[i] - 1, i);
            }
        }
        for (int i = 0; i < l; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();

        for (int i = 0; i < l; i++) {
            if (i + 1 != nums[i])
                return i + 1;
        }

        return l + 1;
    }

    static void swap(int[] nums, int j, int i) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[temp - 1] = temp;
    }

}
