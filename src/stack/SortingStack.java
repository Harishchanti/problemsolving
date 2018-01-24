package stack;

import java.util.Stack;

public class SortingStack {

	public static void main(String[] args) {
		Stack<Integer> s = new Stack<Integer>();
		load(s);
		while (!s.isEmpty()) {
			System.out.print(s.pop() + " ");
		}
		load(s);
		System.out.println();
		sort(s);
		while (!s.isEmpty()) {
			System.out.print(s.pop() + " ");
		}
	}

	private static void load(Stack<Integer> s) {
		s.push(-1);
		s.push(11);
		s.push(22);
		s.push(-14);
	}

	private static void sort(Stack<Integer> s) {
		if (!s.isEmpty()) {
			int c = s.pop();
			sort(s);
			sortStack(s, c);
		}

	}

	private static void sortStack(Stack<Integer> s, int c) {

		if (s.isEmpty() || c < s.peek()) {
			s.push(c);
			return;
		}
		int t = s.pop();
		sortStack(s, c);
		s.push(t);

	}

}
