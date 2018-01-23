package array;

public class RotationArry {

	public static void main(String[] args) {
		int[] a = new int[] { 3, 4, 5, 6, 8, 1, 2 };
		System.out.println(find(a, 3));

	}

	private static int find(int[] a, int n) {
		int mid = -1, low = 0, high = a.length - 1;

		while (low <= high) {
			mid = (low + high) / 2;

			if (a[mid] == n) {
				return mid;
			} else if (n < a[mid]) {
				if (n >= a[low]) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			} else if (n > a[mid]) {
				if (n <= a[high]) {
					low = mid + 1;
				} else {
					high = mid - 1;
				}
			}

		}

		return mid;
	}

}
