package array;

public class CountBinarySearchableElement {
    static int countBinarySearchableIndex(int[] Arr, int l,
            int r, int LR,
            int RL) {
        // Invalid indexes
        if (l > r) {
            return 0;
        }
        int ans = 0;

        // Finding the middle element of the current array
        // (arr[l], ... arr[r]) Similar to as we do in
        // binary search
        int m = (l + r) / 2;

        // If these conditions follow that means Arr[m] is
        // binary searchable.
        if (LR <= Arr[m] && Arr[m] <= RL)
            ans = 1;

        // Finding the binary searchable elements to the
        // left of middle(m) element
        int l_ans = countBinarySearchableIndex(
                Arr, l, m - 1, LR, Math.min(RL, Arr[m]));

        // Finding the binary searchable elements to the
        // right of middle(m) element
        int r_ans = countBinarySearchableIndex(
                Arr, m + 1, r, Math.max(LR, Arr[m]), RL);

        return ans + l_ans + r_ans;
    }

    public static void main(String[] args) {
        //int[] Arr = { 10, 1, 2, 3, 4, 8, 6, 5, 7, 12, 9, 8, 13, 15, 11 };
        int[] Arr = { 3, 3, 2 };
        int n = Arr.length;

        // bruteforce approach
        System.out.println("Count : " + countBinarySearchableV1(Arr));

        // optimizes approach.
        System.out.print(
                "Number of Binary Searchable Indexes: ");
        System.out.println(countBinarySearchableIndex(
                Arr, 0, n - 1, Integer.MIN_VALUE, Integer.MAX_VALUE));
    }

    private static int countBinarySearchableV1(int[] arr) {
        int count = 0;
        for (int a : arr) {
            if (found(a, arr)) {
                count++;
            }
        }
        return count;
    }

    private static boolean found(int a, int[] arr) {
        int i = 0;
        int j = arr.length;

        while (i < j) {
            int mid = (i + j) / 2;

            if (arr[mid] == a)
                return true;
            else if (a > arr[mid]) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return false;
    }
}
