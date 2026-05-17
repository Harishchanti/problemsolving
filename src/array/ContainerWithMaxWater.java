package array;

public class ContainerWithMaxWater {

    public static void main(String[] args) {
        int[] height = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };// {1,1};
        System.out.println(maxArea(height));
    }

    static int maxArea(int[] height) {
        int l = 0, r = height.length - 1, maxWater = 0;

        while (l < r) {

            int w = r - l;
            int h = Math.min(height[l], height[r]);

            int water = w * h;
            maxWater = Math.max(water, maxWater);

            if (height[l] > height[r]) {
                r--;
            } else {
                l++;
            }

        }
        return maxWater;
    }
}
