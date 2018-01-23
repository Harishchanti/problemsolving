package array;

public class TwoArrayProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n = 3;
		int a[] = new int[] { 2, 1, 500 };
		int b[] = new int[] { 21, 1, 51 }; // 21 + 500

		int[] dpA = new int[n];
		int[] dpB = new int[n];

		dpA[n - 1] = a[n - 1];
		dpB[n - 1] = b[n - 1];

		for (int i = n - 2; i >= 0; i--) {
			dpA[i] = max(dpA[i + 1] + a[i], dpB[i + 1]);
			dpB[i] = max(dpB[i + 1] + b[i], dpA[i + 1]);
		}

		System.out.println(dpA[0] > dpB[0] ? dpA[0] : dpB[0]);
	}

	private static int max(int i, int j) {
		return i > j ? i : j;
	}

}
