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


        //bruteforce approach (o) n2
        System.out.println(trapedWater(height));

        //better approach approach (O) n space (O) n
        System.out.println(trapedWaterV2(height1));
        //
    }

    private static int trapedWaterV2(int[] height1) {
        int l = height1.length;
        int[] leftMax = new int[l];
        int[] rightMax = new int[l];

        int max = height1[0];
        for(int i = 0; i < height1.length ; i++) {
            max =Math.max(max,height1[i]);
            leftMax[i] = max;
        }

         max = height1[l-1];
        for(int i = l-1; i >=0 ; i--) {
            max = Math.max(max,height1[i]);
            rightMax[i] = max;
        }
        int result = 0;
        for (int i=0;i < l;i++) {
            result += Math.min(leftMax[i],rightMax[i]) - height1[i];
        }
        return result;

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
