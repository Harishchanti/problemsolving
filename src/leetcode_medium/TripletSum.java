package leetcode_medium;

import java.util.Arrays;
import java.util.HashSet;

public class TripletSum {

    // returns true if there is triplet
    // with sum equal to 'sum' present
    // in A[]. Also, prints the triplet
    static boolean find3Numbers(int A[],
                                int arr_size, int sum) {
        // Fix the first element as A[i]
        for (int i = 0; i < arr_size - 2; i++) {

            // Find pair in subarray A[i+1..n-1]
            // with sum equal to sum - A[i]
            HashSet<Integer> s = new HashSet<Integer>();
            int curr_sum = sum - A[i];
            for (int j = i + 1; j < arr_size; j++) {
                if (s.contains(curr_sum - A[j])) {
                    System.out.printf("Triplet is %d, % d, % d ", A[i],
                            A[j], curr_sum - A[j]);
                    return true;
                }
                s.add(A[j]);
            }
        }

        // If we reach here, then no triplet was found
        return false;
    }

    static void tripletSumEqualsToZero(int arr[]) {
        boolean found = false;

        // sort array elements
        Arrays.sort(arr);
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            // initialize left and right
            int l = i + 1;
            int r = n - 1;
            int x = arr[i];
            while (l < r) {
                if (x + arr[l] + arr[r] == 0) {
                    // print elements if it's sum is zero
                    System.out.print(x + " ");
                    System.out.print(arr[l] + " ");
                    System.out.println(arr[r] + " ");

                    l++;
                    r--;
                    found = true;
                }

                // If sum of three elements is less
                // than zero then increment in left
                else if (x + arr[l] + arr[r] < 0)
                    l++;

                    // if sum is greater than zero than
                    // decrement in right side
                else
                    r--;
            }
        }

        if (found == false)
            System.out.println(" No Triplet Found");
    }

    /* Driver code */
    public static void main(String[] args) {
        int A[] = {1, 4, 45, 6, 10, 8, 17};
        int sum = 22;
        int arr_size = A.length;

        find3Numbers(A, arr_size, sum);
        //int[] a = {};
        int a[] = {0, -1, 2, -3, 1};
        tripletSumEqualsToZero(a);
    }


}
