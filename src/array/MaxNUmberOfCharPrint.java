package array;

import java.util.Comparator;
import java.util.PriorityQueue;

// https://www.geeksforgeeks.org/how-to-print-maximum-number-of-a-using-given-four-keys/
public class MaxNUmberOfCharPrint {
    public static void main(String[] arg) {
        int N;

        // for the rest of the array we
        // will rely on the previous
        // entries to compute new ones
        for (N = 1; N <= 20; N++)
            System.out.println("Maximum Number of A's with keystrokes is " +
                    N + findoptimal(N));
    }

    static int findoptimal(int N)
    {
        // The optimal string length is N
        // when N is smaller than 7
        if (N <= 6)
            return N;

        // Initialize result
        int max = 0;

        // TRY ALL POSSIBLE BREAK-POINTS
        // For any keystroke N, we need to
        // loop from N-3 keystrokes back to
        // 1 keystroke to find a breakpoint
        // 'b' after which we will have Ctrl-A,
        //  Ctrl-C and then only Ctrl-V all the way.
        int b;
        for (b = N - 3; b >= 1; b--)
        {
            // If the breakpoint is s at b'th
            // keystroke then the optimal string
            // would have length
            // (n-b-1)*screen[b-1];
            int curr = (N - b - 1) * findoptimal(b);
            if (curr > max)
                max = curr;
        }
        return max;
    }
}

