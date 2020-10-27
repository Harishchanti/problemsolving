public class CasaOne {

    public static void main(String[] args) {
        int[] a = {3, 4, 5, 6, 1, 2};
        //int[] a = {9, 10, 11, 1, 2, 3, 4};

        System.out.println(findPointOfRotaion(a));
    }

    static int findPointOfRotaion(int[] a) {


        int start = 0, end = a.length - 1;
        int N = a.length;

        while (start <= end) {

            int mid = (start + end) / 2;
            int mid_r = (mid + 1) % N;
            int mid_l = (mid - 1 + N) % N;

            if (a[mid] <= a[mid_r] && a[mid] <= a[mid_l]) return mid;

            else if (a[mid] <= a[end]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
}
