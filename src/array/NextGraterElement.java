package array;

import java.util.Stack;

public class NextGraterElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = new int[] { 4, 5, 2, 25 };
		nextGraterElement(a);
	}

	private static char[] nextGraterElement(int[] a) {
		Stack<Integer> s = new Stack<Integer>();

		s.push(a[0]);
		int i = 1;

		while (i < a.length) {

			int next = a[i];

			if (!s.isEmpty()) {
				int ele = s.pop();

				while (ele < next) {
					System.out.println(ele + " -- > " + next);
					if (s.isEmpty()) {
						break;
					}
					ele = s.pop();
				}
				if (ele > next) {
					s.push(ele);
				}
			}
			s.push(next);
			i++;
		}

		while (!s.isEmpty()) {
			System.out.println(s.pop() + "-- > " + -1);
		}

		return null;
	}

}
