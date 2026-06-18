package subarray;
// https://www.geeksforgeeks.org/longest-subarray-with-absolute-difference-between-elements-less-than-or-equal-to-k-using-heaps/

import java.util.*;

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

    public static int computeLongestSubarrayV2(int arr[],
            int k)
    {
        // Stores the maximum length subarray so far
        int maxLength = 0;

        Deque<Integer> maxHeap = new LinkedList<>();
        Deque<Integer> minHeap = new LinkedList<>();

        // Marks to the beginning and end
        // pointer for current subarray
        int beg = 0, end = 0;

        while (end < arr.length) {

            // Stores the current element being
            // added to the subarray
            int currEl = arr[end];

            // Remove indices of all elements smaller
            // than or equal to current from maxHeap
            while (!maxHeap.isEmpty() &&
                    arr[maxHeap.peekLast()] <= currEl)
                maxHeap.removeLast();

            // Add current element's index to maxHeap
            maxHeap.addLast(end);

            // Remove indices of all elements larger
            // than or equal to current from minHeap
            while (!minHeap.isEmpty() &&
                    arr[minHeap.peekLast()] >= currEl)
                minHeap.removeLast();

            // Add current element's index to minHeap
            minHeap.addLast(end);

            // Index of maximum of current subarray
            int maxOfSub = arr[maxHeap.peekFirst()];

            // Index of minimum of current subarray
            int minOfSub = arr[minHeap.peekFirst()];

            // check if the largest possible difference
            // between a pair of elements <= k
            if (maxOfSub - minOfSub <= k) {
                // Length of current subarray
                int currLength = end - beg + 1;

                // Update maxLength
                if (maxLength < currLength)
                    maxLength = currLength;
            }

            else {
                // If current subarray doesn't satisfy
                // the condition then remove the starting
                // element from subarray that satisfy
                // increment the beginning pointer
                beg++;

                // Remove elements from heaps that
                // are not in the subarray anymore
                while (!minHeap.isEmpty() &&
                        minHeap.peekFirst() < beg)
                    minHeap.removeFirst();

                while (!maxHeap.isEmpty() &&
                        maxHeap.peekFirst() < beg)
                    maxHeap.removeFirst();
            }

            end++;
        }

        // Return the final answer
        return maxLength;
    }

    // Driver Code
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 6, 7};

        int k = 2;

        int maxLength = computeLongestSubarrayV2(arr, k);
        System.out.println(maxLength);
    }


}
