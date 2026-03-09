package array;

/*\

Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

https://www.geeksforgeeks.org/dsa/trapping-rain-water/

Input: height = [4,2,0,3,2,5]
Output: 9
 */
public class TappingRainWater {

    public static void main(String[] args) {
        int[] height = { 4, 2, 0, 3, 2, 5 };// 9
        int[] height1 = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 }; // 6   // {0,0,1,0,1,2,1,0,0,1}


        System.out.println(trapedWater(height));
        System.out.println(trapedWater(height1));
        //
    }

    private static int trapedWater(int[] height) {
        int result = 0;
        for (int i = 0; i < height.length ; i++) {

            int leftMax = height[i];
            for (int j = i - 1; j >= 0; j--) {
                leftMax = Math.max(leftMax, height[j]);
            }

            int rightMax = height[i];
            for (int j = i + 1; j < height.length; j++) {
                rightMax = Math.max(rightMax, height[j]);
            }

            int minHight = Math.min(leftMax, rightMax)-height[i];
           // 0,0,1,0,1,2,1,0,0,1
            result += minHight;

        }
        return result;
    }
}
