package subarray;

/*
Given an integer array nums, return an array output where output[i] is the product of all the elements of nums except nums[i].

Each product is guaranteed to fit in a 32-bit integer.

Follow-up: Could you solve it in
O
(
n
)
O(n) time without using the division operation?

Example 1:

Input: nums = [1,2,4,6]

Output: [48,24,12,8]
Example 2:

Input: nums = [-1,0,1,2,3]

Output: [0,-6,0,0,0]
Constraints:

2 <= nums.length <= 100,000
-30 <= nums[i] <= 30
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

 */
public class ProductOfArrayExceptItself {
    public static void main(String[] args) {
        //int[] a = { 1, 2, 4, 6 };
        int[] a = { -1, 0, 1, 2, 3 };

        int[] result = solveProduct(a);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }

    static int[] solveProduct(int[] nums) {
        int tLeft = 1, tRight = 1, l = nums.length;

        int[] left = new int[l];
        int[] right = new int[l];
        int[] result = new int[l];

        left[0] = 1;
        for (int i = 1; i < l; i++) {
            tLeft *= nums[i - 1];
            left[i] = tLeft;
        }

        right[l - 1] = 1;
        for (int i = l - 2; i >= 0; i--) {
            tRight *= nums[i + 1];
            right[i] = tRight;

        }

        for (int i = 0; i < l; i++) {
            result[i] = left[i] * right[i];
        }
        return result;

    }

}
