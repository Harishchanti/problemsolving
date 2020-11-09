package leetcode_medium;

// https://www.geeksforgeeks.org/trapping-rain-water/

public class TappingRainWater {

    static int arr[] = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};

    static int findWater(int n) {
        // left[i] contains height of tallest bar to the
        // left of i'th bar including itself
        int left[] = new int[n];

        // Right [i] contains height of tallest bar to
        // the right of ith bar including itself
        int right[] = new int[n];

        // Initialize result
        int water = 0;

        // Fill left array
        left[0] = arr[0];
        for (int i = 1; i < n; i++)
            left[i] = Math.max(left[i - 1], arr[i]);

        // Fill right array
        right[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--)
            right[i] = Math.max(right[i + 1], arr[i]);

        // Calculate the accumulated water element by element
        // consider the amount of water on i'th bar, the
        // amount of water accumulated on this particular
        // bar will be equal to min(left[i], right[i]) - arr[i] .
        for (int i = 0; i < n; i++)
            water += Math.min(left[i], right[i]) - arr[i];

        return water;
    }

    // Driver method to test the above function
    public static void main(String[] args) {

        System.out.println("Maximum water that can be accumulated is " + findWater(arr.length));
        System.out.println("Maximum water that can be accumulated is " + findWaterOptimized(arr.length));
    }

    private static int findWaterOptimized(int length) {
        int count = 0;

        int i = 0, j = arr.length - 1;
        int maxLeft = 0, maxRight = 0;

        while (i <= j) {

            maxLeft = Math.max(maxLeft, arr[i]);
            maxRight = Math.max(maxRight, arr[j]);

            if (maxLeft <= maxRight) {
                count += maxLeft - arr[i];
                i++;
            }else {
                count += maxRight -arr[j];
                j--;
            }

        }
        return count;
    }
}
