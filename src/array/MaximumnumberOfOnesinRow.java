package array;

public class MaximumnumberOfOnesinRow {
/*
 * 0 1 1 1
0 0 1 1
1 1 1 1  // this row has maximum 1s
0 0 0 0
 */
	public static void main(String[] args) {
		int[][] a = new int[][] {
			{0, 1, 1, 1},
			{0 ,0, 1, 1},
			{0 ,1, 1, 1},
			{0 ,0, 0, 0},
			{1 ,1, 1, 1}
		};
		//System.out.println(findRow(a,4));
		System.out.println(findmaxOnce(a,5,4));
	}

	private static int findmaxOnce(int[][] a, int m, int n) {
		int i = 0;
		int j = n - 1;
		while (j >= 0) {
			while (a[i][j] != 0) {
				j--;
				if (j < 0) {
					return n;
				}
			}
			if (i >= m - 1) {
				break;
			}
			i++;
		}
		return n - (j + 1);
	}

private static int findRow(int[][] a,int column) {
	int row = 0;
	int maxOnes= 0;
	int j = column - 1;
	int maxRow = 0;
	for(int i= 0; i < a.length;i++ ) {
		
		while( j > -1 && a[i][j] !=0) {
			j--;
		}
		int ones = column - (j+1); 
		if(ones  == column) {
			return i;
		}
		if(ones > maxOnes ) {
			maxOnes = ones;
			maxRow = i;
		}
	}
	return maxRow;
}

}
