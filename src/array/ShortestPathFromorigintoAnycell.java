package array;

public class ShortestPathFromorigintoAnycell {

	public static void main(String[] args) {
		int cost[][] = new int[][] { 
			{ 1, 2, 3 }, 
			{ 4, 9, 2 }, 
			{ 1, 5, 3 } };
		System.out.println(findShortestPath(cost, 2, 2));// 1, 2, 2, 3

	}

	private static int findShortestPath(int[][] cost, int m, int n) {
		if (n < 0 || m < 0)
			return Integer.MAX_VALUE;
		else if (m == 0 && n == 0)
			return cost[m][n];
		else
			return cost[m][n] + min(findShortestPath(cost, m - 1, n - 1), findShortestPath(cost, m - 1, n),
					findShortestPath(cost, m, n - 1));

	}
	private static int min(int i, int j, int k) {
		int f = (i < j) ? i : j;
		return (f < k) ? f : k;
	}

}
