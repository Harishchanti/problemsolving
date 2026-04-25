package array;

public class EqualElementsInArray {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] a = new int[] { 2, 1, 2, 2, 55 };
        int t = 5;
        System.out.println(maxEqlualNumbers(a, t)); // 3

    }

    private static int maxEqlualNumbers(int[] a, int t) {
        int count = 1;
        int max = a[0];
        for (int i = 1; i < a.length; i++) {

            if (max == a[i]) {
                count++;
            } else {
                count--;

                if (count == 0) {
                    max = a[i];
                    count = 1;
                }
            }

        }

        return max;
    }

}
