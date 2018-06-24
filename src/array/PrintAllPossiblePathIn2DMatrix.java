package array;

/*
 * Input : 1 2 3
        4 5 6
Output : 1 4 5 6
         1 2 5 6
         1 2 3 6

Input : 1 2 
        3 4
Output : 1 2 4
         1 3 4

https://www.geeksforgeeks.org/print-all-possible-paths-from-top-left-to-bottom-right-of-a-mxn-matrix/
 */
public class PrintAllPossiblePathIn2DMatrix {

	public static void main(String[] args) {
		int m = 2, n = 3;
		int[][] a = new int[][] { 
			{ 1, 2, 3 },
			{ 4, 5, 6 } };
		int[] output = new int[m + n];
		printAllPaths(a, 0, 0, m, n, output, 0);
	}

	private static void printAllPaths(int[][] a, int i, int j, int m, int n, int[] output, int pi) {

		// when you reached bottom you can only move right adding all right
		// element in output
		if (i == m - 1) {
			for (int k = j; k < n; k++) {
				output[pi + k - j] = a[i][k];
			}
			for (int l = 0; l < pi + n - j; l++) {
				System.out.print(output[l] + " ");
			}
			System.out.println();
			return;
		}

		// Reached the right corner of the matrix we are left with only the
		// downward movement.
		if (j == n - 1) {
			for (int k = i; k < m; k++) {
				output[pi + k - i] = a[k][j];
			}
			for (int l = 0; l < pi + m - i; l++) {
				System.out.print(output[l] + " ");
			}
			System.out.println();
			return;
		}
		output[pi] = a[i][j];
		printAllPaths(a, i + 1, j, m, n, output, pi + 1);
		printAllPaths(a, i, j + 1, m, n, output, pi + 1);
	}

}
