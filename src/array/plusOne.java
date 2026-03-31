package array;

public class plusOne {
    public static void main(String[] args) {
        int[] digits = { 1, 9, 9 };// [7,2,8,5,0,9,1,2,9,5,3,6,6,7,3,2,8,4,3,7,9,5,7,7,4,7,4,9,4,7,0,1,1,1,7,4,0,0,6]

        int[] result = plusOne(digits);
        for (int i : result) {
            System.out.print(i + ",");
        }
    }

    public static int[] plusOne(int[] digits) {
        int size = digits.length;
        int i = 0;

        for (i = size - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i] += 1;
                break;
            } else {
                digits[i] = 0;
            }
        }

        if (i == -1) {
            int[] newDigits = new int[size + 1];
            newDigits[0] = 1;
            return newDigits;
        }

        return digits;
    }
}
