package array;

//Binary search based question
public class RotationArry {

	public static void main(String[] args) {
		int[] a = new int[] { 6, 8, 1, 2, 3, 4, 5 };
		int[] b = new int[] { 1, 5, 5, 5, 5, 5, 5, 5, 6 };
		int n = 2;
		int m = 5;
		System.out.println("Element " + n + " Found at index " + findElement(a, n));
		System.out.println("Point of Rotaion of Sorted array : " + finddPointOfRotation(a));
		System.out.println("Maximum number of occurence element : " + getNoOfOccurrence(b, m));

	}

	private static int getNoOfOccurrence(int[] b, int m) {
		int l = binarySearh(b, m, "L");
		int r = binarySearh(b, m, "R");
		return (l == -1 || r == -1) ? -1 : (r - l) + 1;
	}

	private static int binarySearh(int[] a, int m, String pos) {
		int low = 0, high = a.length - 1, l = a.length, mid = -1;

		while (low <= high) {
			mid = (low + high) / 2;
			int mid_l = (mid - 1 + l) % l;
			int mid_r = (mid + 1) % l;

			if (a[mid] == m) {
				if (pos.equals("L")) {
					if (a[mid_l] < a[mid]) {
						return mid;
					} else {
						high = mid - 1;
					}
				}
				if (pos.equals("R")) {
					if (a[mid_r] > a[mid]) {
						return mid;
					} else {
						low = mid + 1;

					}
				}

			} else if (a[mid] >= m) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return mid;
	}

	private static int finddPointOfRotation(int[] a) {
		int low = 0, high = a.length - 1, l = a.length, mid, mid_l, mid_r;

		while (low <= high) {
			mid = (low + high) / 2;
			mid_l = (mid - 1 + l) % l;
			mid_r = (mid + 1) % l;

			if (a[mid_l] >= a[mid] && a[mid] <= a[mid_r]) {
				return mid;
			} else if (a[mid] <= a[high]) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}

		return -1;
	}

	private static int findElement(int[] a, int n) {
		int mid = -1, low = 0, high = a.length - 1;

		while (low <= high) {
			mid = (low + high) / 2;
			if (a[mid] == n) {
				return mid;
			} else if (a[mid] >= a[low]) {
				if (n <= a[mid] && n >= a[low]) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			} else if (a[mid] <= a[high]) {
				if (n >= a[mid] && n <= a[high]) {
					low = mid + 1;
				} else {
					high = mid - 1;
				}
			}

		}

		return -1;
	}

}
