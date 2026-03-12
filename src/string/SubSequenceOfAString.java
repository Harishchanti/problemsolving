package string;

public class SubSequenceOfAString {

    static int maxSubsequenceSubString(String X, String Y,
            int n, int m) {

        // Base Case
        if (n == 0 || m == 0)
            return 0;

        // Calls on smaller inputs
        System.out.println("X.charAt(n - 1) : " + String.valueOf(
                X.charAt(n - 1) + " and Y.charAt(m - 1) : " + String.valueOf(
                        Y.charAt(m - 1))));
        // if the last char of both Strings are equal
        if (X.charAt(n - 1) == Y.charAt(m - 1)) {
            return 1
                    + maxSubsequenceSubString(X, Y, n - 1,
                    m - 1);
        }

        // if the last char of both Strings are not equal
        else {
            return maxSubsequenceSubString(X, Y, n - 1, m);
        }
    }

    public static int maxSubsequenceSubstringV2(String X, String Y, int N,
            int M) {

        // Initialize a variable to keep track of the maximum length
        int maxi = 0;

        // Outer loop to traverse through each character of Y
        for (int i = 0; i < M; i++) {
            int t = i; // Initialize a pointer 't' to track position in Y

            // Inner loop to traverse through each character of X
            for (int j = 0; j < N; j++) {
                // If characters from X and Y match, move pointer 't' in Y
                if (Y.charAt(t) == X.charAt(j)) {
                    t++;
                }

                // Update the maximum length found so far
                maxi = Math.max(maxi, t - i);
            }
        }

        // Return the maximum length of the subsequence substring
        return maxi;
    }

    // Driver code
    public static void main(String[] args) {
        String X = "abcd";
        String Y = "bacdbdcd";
        int n = X.length(), m = Y.length();
        int maximum_length
                = 0; // as minimum length can be 0 only.
       /* for (int i = 0; i <= m;
             i++) // traversing for every length of Y.
        {
            int temp_ans
                    = maxSubsequenceSubString(X, Y, n, i);
            System.out.println("temp Sum " + temp_ans);
            if (temp_ans > maximum_length)
                maximum_length = temp_ans;
        }*/
        maximum_length = maxSubsequenceSubstringV2(X, Y, n, m);
        System.out.println(
                "Length for maximum possible Subsequence of String X which is SubString of Y->"
                        + maximum_length);

    }
}
