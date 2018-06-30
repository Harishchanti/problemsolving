package array;

public class ILandProblems {

	public static void main(String[] args) {

		int M[][] = new int[][] { 
			{ 1, 1, 0, 1, 0 }, 
			{ 0, 1, 0, 0, 1 },
			{ 1, 0, 0, 1, 1 },
			{ 0, 0, 0, 0, 0 },
			{ 1, 0, 1, 0, 1 }

		};
		System.out.println(findNoOfIlands(M));

	}

	private static int findNoOfIlands(int[][] a) {
		int r = a.length;
		int c = a[0].length;
		int count = 0;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (a[i][j] == 1) {

					DFS(a, i, j);
					count++;
				}
			}
		}
		return count;
	}

	private static void DFS(int[][] a, int i, int j) {

		if (i < 0 || i >= a.length || j < 0 || j >= a[i].length || a[i][j] == 0)
			return;

		a[i][j] = 0;
		for (int r = i - 1; r <= i + 1; r++) {
			for (int c = j - 1; c <= j + 1; c++) {
				if (r != i || c != j) {
					DFS(a, r, c);
				}
			}
		}

	}

}
