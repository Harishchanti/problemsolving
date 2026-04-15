package subarray;

// https://www.geeksforgeeks.org/largest-sum-contiguous-subarray/

public class MaximumSumOfSubArray {
    public static void main(String[] args) {
        int[] a = { -2, -3, 4, -1, -2, 1, 5, -3 };
        System.out.println("Maximum contiguous sum is " +
                maxSubArraySum(a));
        // print the sub array
        System.out.println("Print subarray ");
        printMaxSumSubArray(a);
    }

    private static void printMaxSumSubArray(int[] a) {
        int maxSum = Integer.MIN_VALUE, temp = 0;
        int m = 0, size = 0;

        for (int i = 0; i < a.length; i++) {

            temp = temp + a[i];
            if (maxSum < temp) {
                maxSum = temp;
                size = Math.max(size, i - m);
            }

            if (temp <= 0) {
                m = i;
                temp = 0;
            }
        }
        System.out.println("Max sum is " + maxSum + " and size is " + size);
        for (int i = m+1; i <= m + size; i++) {
            System.out.print(a[i] + " ");
        }
    }

    static int maxSubArraySum(int a[]) {
        int size = a.length;
        int max_so_far = Integer.MIN_VALUE, max_ending_here = 0;

        for (int i = 0; i < size; i++) {
            max_ending_here = max_ending_here + a[i];
            if (max_so_far < max_ending_here)
                max_so_far = max_ending_here;
            if (max_ending_here < 0)
                max_ending_here = 0;
        }
        return max_so_far;
    }
}
