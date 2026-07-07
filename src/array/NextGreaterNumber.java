package array;

import java.util.Arrays;

public class NextGreaterNumber {
    static void swap(int[] ar, int i, int j) {
        int temp = ar[i];
        ar[i] = ar[j];
        ar[j] = temp;
    }//  1 2 3 4 5 => 12354  5, 4, 5, 7, 4, 3, 1  => 5 ,4,7,5,4,3,1 = > 5,4,7 1,3,4,5

    static void findNext(int[] ar, int n) {
        int i;

        for (i = n - 1; i > 0; i--) {
            if (ar[i] > ar[i - 1]) {
                break;
            }
        }

        if (i == 0) {
            System.out.println("Not possible");
        } else {
            swap(ar, i - 1, i);
            Arrays.sort(ar, i, n);
            System.out.print("Next number with same" + " set of digits is ");
            for (i = 0; i < n; i++)
                System.out.print(ar[i] + " ");
        }
    }

    public static void main(String[] args) {
        char[] digits = { '1','2' }; // { 5, 4, 7, 6, 3, 2, 1 }; //  5,7,1,2,3,4,6
        int n = digits.length;
        //findNext(digits, n);// 1,2,3,4,5 => 1,2,3,5,4
        System.out.println(nextPermutation(String.valueOf(digits)));
    }

    // Function to find the next permutation of a given
    // string
    static String nextPermutation(String N)
    {
        // If number of digits is 1 then just return "Not
        // Possible"
        if (N.length() == 1) {
            return "Not Possible";
        }

        // Start from the right most digit and find the
        // first digit that is smaller than the digit next
        // to it.
        int i;
        for (i = N.length() - 1; i > 0; i--) {
            if (N.charAt(i) > N.charAt(i - 1)) {
                break;
            }
        }

        // If i is 0 that means elements are in decreasing
        // order. Therefore, no greater element possible.
        if (i == 0) {
            return "Not Possible";
        }

        // Find the smallest digit on right side of (i-1)'th
        // digit that is greater than N.charAt(i-1)
        for (int j = N.length() - 1; j >= i; j--) {
            if (N.charAt(i - 1) < N.charAt(j)) {
                // Swap the found smallest digit i.e.
                // N.charAt(j) with N.charAt(i-1)
                char[] charArray = N.toCharArray();
                char temp = charArray[i - 1];
                charArray[i - 1] = charArray[j];
                charArray[j] = temp;
                N = new String(charArray);
                break;
            }
        }

        // Reverse the digits after (i-1) because the digits
        // after (i-1) are in decreasing order and thus we
        // will get the smallest element possible from these
        // digits
        char[] charArray = N.toCharArray();
        reverse(charArray, i, N.length() - 1);
        return new String(charArray);
    }

    // Utility function to reverse a portion of a character
    // array
    static void reverse(char[] arr, int start, int end)
    {
        while (start < end) {
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
