package subarray;
// https://www.geeksforgeeks.org/longest-subarray-with-absolute-difference-between-elements-less-than-or-equal-to-k-using-heaps/

public class LongestSubArrayDiffrenceIsLessThenK {
    // Java implementation to find the Longest subarray
// of the given array with absolute difference between
// elements less than or equal to integer K


    public static int computeLongestSubarray(int arr[],
                                             int k) {
        // maxLength is 1 because k >= 0,
        // a single element, subarray will always
        // have absolute difference zero
        int maxLength = 1;

        // Check for all possible subarrays
        for (int i = 0; i < arr.length; i++) {
            // Initalization of minimum &
            // maximum of current subarray
            int minOfSub = arr[i];
            int maxOfSub = arr[i];

            for (int j = i + 1; j < arr.length; j++) {

                // Update the values for minimum & maximum
                if (arr[j] > maxOfSub)
                    maxOfSub = arr[j];

                if (arr[j] < minOfSub)
                    minOfSub = arr[j];

                // Check if current subarray satisfies
                // the given condition
                if ((maxOfSub - minOfSub) <= k) {
                    int currLength = j - i + 1;

                    // Update the value for maxLength
                    if (maxLength < currLength)
                        maxLength = currLength;
                }
            }
        }

        // Return the final result
        return maxLength;
    }

    // Driver Code
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 6, 7};

        int k = 2;

        int maxLength = computeLongestSubarray(arr, k);
        System.out.println(maxLength);
    }


}
