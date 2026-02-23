package array;

public class MaximumSum {

	/*
	 * Function to return max sum such that no two elements are adjacent
	 */
	int FindMaxSum(int[] arr, int n) {
		int incl = arr[0];
		int excl = 0;
		int excl_new;
		int i;

		for (i = 1; i < n; i++) {
			/* current max excluding i */
			excl_new = Math.max(incl, excl);

			/* current max including i */
			incl = excl + arr[i];
			excl = excl_new;
		}

		/* return max of incl and excl */
		return (Math.max(incl, excl));
	}

	/*
	 * Function to return max sum such that no three elements are adjecent
	 */

	private int FindMaxSumNothreeAdjecent(int[] a, int length) {

		int[] sum = new int[a.length];
		sum[0] = a[0];
		sum[1] = a[0] + a[1];

		sum[2] = max(sum[1], sum[0] + a[2], a[1] + a[2]);

		for (int i = 3; i < a.length; i++) {
			sum[i] = max(sum[i - 1], sum[i - 2] + a[i], sum[i - 3] + a[i - 1] + a[i]);
		}

		return sum[a.length - 1];
	}

	private int max(int i, int j, int z) {
		int maxij = i > j ? i : j;

		return (maxij > z) ? maxij : z;
	}

	// Driver program to test above functions
	public static void main(String[] args) {
		MaximumSum sum = new MaximumSum();
		int arr[] = new int[] { 5, 5, 10, 100, 10, 5 };
		int arr1[] = new int[] { 100, 1000, 100, 1000, 1 };
		System.out.println("No two adjecent element : " + sum.FindMaxSum(arr, arr.length));

		System.out.println("No three adjecent element : " + sum.FindMaxSumNothreeAdjecent(arr1, arr.length));
	}

}
