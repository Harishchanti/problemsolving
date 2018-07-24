package array;

public class FindElementAccringMoreThenHalf {
    public static void main(String[] arg) {
        int[] a = {1, 1, 1, 1, 1, 1, 3, 3, 3, 3, 1, 3};
        System.out.println(findElementAccoringMoreThenHalf(a));
    }

    private static int findElementAccoringMoreThenHalf(int[] a) {
        int count = 1;
        int mj = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] == mj) {
                count += 1;
            } else {
                count -= 1;
                if (count == 0) {
                    mj = a[i];
                    count = 1;
                }
            }
        }
        return mj;
    }
}
