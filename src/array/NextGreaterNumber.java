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
            System.out.print("Next number with same" +
                    " set of digits is ");
            for (i = 0; i < n; i++)
                System.out.print(ar[i] + " ");
        }
    }

    public static void main(String[] args) {
        int[] digits = { 5 , 4, 7 , 5, 3, 1, 2 }; //  5 , 4, 7 , 5, 3, 1, 2
        int n = digits.length;
        findNext(digits, n);
    }
}
