package array;

public class MinmumNumberOfSwaps {
    public static void main(String[] args) {
        int[] a = {1, 0, 1, 0, 1, 1};
        System.out.println(minSwaps(a));
    }

    private static int minSwaps(int[] a) {
        // Count number of 1s in the array
        int countOnes = 0;
        int i;
        for (i = 0; i < a.length; i++) {
            if (a[i] == 1) countOnes++;
        }

        // count number of 1s in array size of length of Number of 1s
        int x = countOnes;
        int count = 0;
        for (i = 0; i < x; i++) {
            if (a[i] == 1) {
                count++;
            }
        }
        // countOnes = 4 , count = 2 at this point

       int maxOnes = count;
        for (i = 1; i <= a.length - x; i++) {
            if (a[i - 1] == 1) count--;
            if (a[i + x - 1] == 1) count++;
            if (count > maxOnes) maxOnes = count;
        }
        return x - maxOnes;
    }
}
