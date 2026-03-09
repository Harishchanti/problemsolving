package array;

/*\

Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

https://www.geeksforgeeks.org/dsa/trapping-rain-water/

Input: height = [4,2,0,3,2,5]
Output: 9
 */
public class TappingRainWater {

    public static void main(String[] args) {
        int[] height = { 4, 2, 0, 3, 2, 5 };
        System.out.println(trapedWater(height));
    }

    private static int trapedWater(int[] height) {
        int result = 0;
        for (int i = 1; i < height.length - 1; i++) {

            int leftMax = height[i];
            for (int j = i - 1; j >= 0; j--) {
                leftMax = Math.max(leftMax, height[j]);
            }

            int rightMax = height[i];
            for (int j = i + 1; j < height.length; j++) {
                rightMax = Math.max(leftMax, height[j]);
            }

            int minHight = Math.min(leftMax, rightMax);

            result += minHight - height[i];

        }
        return result;
    }
}
