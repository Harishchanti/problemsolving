package monocept;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaxnumberDivisibles {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NQ = br.readLine().split(" ");
		int N = Integer.parseInt(NQ[0]);
		int t = Integer.parseInt(NQ[1]);
		int[] arr = new int[N];

		List<Integer> s = new ArrayList<Integer>();

		String[] el = br.readLine().split(" ");
		for (int i = 0; i < el.length; i++) {
			Integer minDiv = getMinDiv(Integer.parseInt(el[i]));
			if(minDiv != 0) {
				s.add(minDiv);
			}
			arr[i] = Integer.parseInt(el[i]);
		}
		Collections.sort(s);
		System.out.println(s);
		while (t-- > 0) {
			int count = Integer.parseInt(br.readLine());
			int max = 0;
			for (Integer g : s) {
				if ((count - g) >= 0) {
					max++;
					count -= g;
				}
			}
			System.out.println(max);
		}
	}

	private static Integer getMinDiv(int n) {
		int count = 0;
		int sm = getSmallestFactor(n);
		while (n > 1) {
			n = n / sm;
			count++;
		}
		return count;
	}

	private static int getSmallestFactor(int N) {
		for (int i = 2; i * i <= N; i++) {
			if (N % i == 0)
				return i;
		}
		return N;
	}

}

/*
 * 3 3 8 9 12 3 10 1
 */