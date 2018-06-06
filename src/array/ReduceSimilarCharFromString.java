package array;

import java.util.Stack;

public class ReduceSimilarCharFromString {

	public static void main(String[] args) {

		String s = "abba"; // ""
		String s1 = "aba"; // "aba"
		String s2 = "1acccca"; // "abdba"

		System.out.println(reduce(s2));
		System.out.println(stackBasedApproch(s2));

	}

	private static String stackBasedApproch(String s) {
		Stack<Character> stak = new Stack<Character>();
		int i = 1;
		String result = "";
		stak.push(s.charAt(0));
		while (s.length() > i) {
			if (stak.peek().equals(s.charAt(i))) {
				stak.pop();
			} else {
				stak.push(s.charAt(i));
			}
			i++;
		}
		if (stak.isEmpty()) {
			return result;
		} else {
			while (!stak.isEmpty()) {
				result += stak.pop();
			}
		}
		return result;
	}

	/// Alternative solution would be using stake
	private static String reduce(String s) {

		if (s.length() <= 1) {
			return s;
		}

		char[] charArray = s.toCharArray();
		char left = charArray[0];
		char right = charArray[1];
		if (charArray.length == 2) {
			if (left == right) {
				return "";
			} else {
				return new String(charArray);
			}
		}

		for (int i = 1; i < s.length() - 1; i++) {
			right = charArray[i];

			if (left == right) {
				return reduce(s.substring(0, i - 1) + s.substring(i + 1, s.length()));
			} else {
				left = right;
				// right = charArray[i + 1];
			}
		}

		return new String(charArray);
	}

}
