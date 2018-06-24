package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*You are given an array a comprising  integers. You have to calculate the magic value of the array . Magic value of an array is equal to the difference between the sum of good integers in an array and the sum of the bad integers in an array.

Good integers are the ones whose indexes are not changed in an array when sorted , rest are bad.

Input format
First line of input contain a single integer .
Second line of input contain  space separated integers, elements of array .

input:

10
0 4 0 0 1 3 4 1 0 2 

output :
-13
*/
public class DiffrenaceInGoodAndBadIndex {
	static int goodSum;
	static int badSum;

	static class Minmax {
		int min;
		int max;

		public int getMin() {
			return min;
		}

		public Minmax(int min, int max) {
			super();
			this.min = min;
			this.max = max;
		}

		public void setMin(int min) {
			this.min = min;
		}

		public int getMax() {
			return max;
		}

		public void setMax(int max) {
			this.max = max;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);
		int size = s.nextInt();
		int[] a = new int[size];
		int[] b = new int[size];
		int i,j;
		for (i = 0; i < size; i++) {
			a[i] = s.nextInt();
			b[i] = a[i];// s.nextInt();
		}
		Arrays.sort(a);
		Map<Integer, Minmax> eleRangMap = new HashMap<Integer, Minmax>();
		for (i = 0; i < size; i++) {
			if (eleRangMap.containsKey(a[i]) ) {
				eleRangMap.get(a[i]).setMax(i);
			} else {
				eleRangMap.put(a[i], new Minmax(i,i));
			}
		}
		for(i=0;i<size;i++) {
			if(i>=eleRangMap.get(b[i]).min &&i<=eleRangMap.get(b[i]).max) {
				goodSum +=b[i];
			}else {
				badSum +=b[i];
			}
		}
		System.out.println(goodSum - badSum);
		
	}
}
