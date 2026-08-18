package leetcode_medium;

// https://www.geeksforgeeks.org/print-concatenation-of-zig-zag-string-form-in-n-rows/amp/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrintConcatenationofZigZag {
    static void printZigZagConcat(String str,

                                  int n) {


        // Corner Case (Only one row)

        if (n == 1) {
            System.out.print(str);
            return;
        }
        char[] str1 = str.toCharArray();
        // Find length of string
        int len = str.length();
        // Create an array of
        // strings for all n rows
        String[] arr = new String[n];
        Arrays.fill(arr, "");
        // Initialize index for
        // array of strings arr[]
        int row = 0;
        boolean down = true; // True if we are moving
        // down in rows, else false
        // Travers through
        // given string
        for (int i = 0; i < len; ++i) {
            // append current character
            // to current row
            arr[row] += (str1[i]);
            // If last row is reached,
            // change direction to 'up'
            if (row == n - 1) {
                down = false;
            }
            // If 1st row is reached,
            // change direction to 'down'
            else if (row == 0) {
                down = true;
            }
            // If direction is down,
            // increment, else decrement
            if (down) {
                row++;
            } else {
                row--;
            }
        }

        // Print concatenation
        // of all rows
        for (int i = 0; i < n; ++i) {
            System.out.print(arr[i]);
        }

    }


    // Driver Code

    public static void main(String[] args) {

        String str = "GEEKSFORGEEKS";

        int n = 3;

        printZigZagConcat(str, n);
        System.out.println();
        System.out.println(printZigZagConcatV2(str,n));

    }

    private static String printZigZagConcatV2(String str, int n) {
        List<StringBuilder> rows = new ArrayList<>(n);
        for(int  i = 0; i< n;i++) rows.add(new StringBuilder());

        if (n <= 1)
            return str;

        int step = 0;
        int d = 1;

        for(char c : str.toCharArray()) {

            rows.get(step).append(c);

            if(step == 0 ) {
                d = 1;
            } else if( step == n-1 ) {
                d = -1;
            }

            step = step + d;

        }
        StringBuilder result = new StringBuilder();
        for(StringBuilder sb :rows){
            result.append(sb.toString());
        }
        return result.toString();

    }

}
