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
        if (LR < Arr[m] && Arr[m] < RL)
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
        int[] Arr = { 10, 1, 2, 3, 4, 8, 6, 5,
                7, 12, 9, 8, 13, 15, 11 };

        int n = 15;
        System.out.print(
                "Number of Binary Searchable Indexes: ");
        System.out.println(countBinarySearchableIndex(
                Arr, 0, n - 1, Integer.MIN_VALUE, Integer.MAX_VALUE ));
    }
}
