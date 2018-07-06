package array;

import java.util.Stack;

public class MazeProblem {

	static class Path {
		int i, j;

		Path(int i, int j) {
			this.i = i;
			this.j = j;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + i;
			result = prime * result + j;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Path other = (Path) obj;
			if (i != other.i)
				return false;
			if (j != other.j)
				return false;
			return true;
		}
	}

	public static void main(String[] args) {
		int[][] a = { 
				{ 0, 0, 0, 0, 0, 1, 0 }, 
				{ 1, 1, 0, 1, 0, 0, 1 }, 
				{ 0, 1, 0, 0, 1, 1, 1 },
				{ 1, 1, 1, 0, 0, 1, 0 }, 
				{ 1, 1, 1, 1, 0, 0, 1 }, 
				{ 0, 0, 0, 0, 0, 0, 0 }, 
				{ 1, 1, 0, 1, 1, 1, 0 } 
				};
		Stack<Path> stack = new Stack<Path>();
		stack.push(new Path(0, 0));
		findPathV2(a, a.length - 1, a[0].length - 1, stack);

	}

	private static void printPath(Stack<Path> stack) {
		if (!stack.isEmpty()) {
			Path d = stack.pop();
			printPath(stack);
			System.out.print("(" + d.i + "," + d.j + ")->");
		}
	}

	private static void findPathV2(int[][] a, int m, int n, Stack<Path> stack) {
		boolean falg = false;
		int h = 0, k = 0;
		while (!stack.isEmpty()) {
			if (!stack.isEmpty()) {
				Path peek = stack.peek();
				h = peek.i;
				k = peek.j;
			}
			if (h == m && k == n) {
				falg = true;
				break;
			}
			boolean p = dfs(a, m, n, h, k, stack);
			if (!p) {
				Path pop = stack.pop();
				a[pop.i][pop.j] = 1;
			}
		}
		if (falg) {
			System.out.print("Path Present \nStart->");
			printPath(stack);
			System.out.print("End");
		} else {
			System.out.println("Not present");
		}
	}

	private static boolean dfs(int[][] a, int m, int n, int i, int j, Stack<Path> stack) {
		if ((j + 1) <= n && a[i][j + 1] == 0 && !stack.contains(new Path(i, j + 1))) {
			stack.add(new Path(i, j + 1));
			return true;

		}
		if ((j - 1) >= 0 && a[i][j - 1] == 0 && !stack.contains(new Path(i, j - 1))) {
			stack.add(new Path(i, j - 1));
			return true;
		}
		if ((i + 1) <= m && a[i + 1][j] == 0 && !stack.contains(new Path(i + 1, j))) {
			stack.add(new Path(i + 1, j));
			return true;
		}
		if ((i - 1) >= 0 && a[i - 1][j] == 0 && !stack.contains(new Path(i - 1, j))) {
			stack.add(new Path(i - 1, j));
			return true;
		}
		return false;
	}

}
