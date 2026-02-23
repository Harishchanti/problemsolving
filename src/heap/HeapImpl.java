package heap;

public class HeapImpl {

	static int N;

	public static void main(String[] args) {
		//int[] arr = new int[] { 3, 4, 14, 1, -5, -1 };
        int arr[] = {1, 3, 5, 4, 6, 13, 10, 9, 8, 15, 17};

		heapify(arr);

		for (int i = N; i > 0; i--)

		{

			swap(arr, 0, i);

			N = N - 1;

			minheap(arr, 0);

		}
		for (int j = 0; j < arr.length; j++) {

			System.out.print(arr[j] + " ");
		}
	}

	/* Function to build a heap */

	public static void heapify(int arr[])

	{

		N = arr.length - 1;

		for (int i = N / 2; i >= 0; i--)

			minheap(arr, i);

	}

	/* Function to swap largest element in heap */

	public static void minheap(int arr[], int i)

	{

		int left = 2 * i;

		int right = 2 * i + 1;

		int max = i;

		if (left <= N && arr[left] > arr[max])

			max = left;

		if (right <= N && arr[right] > arr[max])

			max = right;

		if (max != i)

		{

			swap(arr, i, max);

			minheap(arr, max);

		}

	}

	/* Function to swap two numbers in an array */

	public static void swap(int arr[], int i, int j)

	{

		int tmp = arr[i];

		arr[i] = arr[j];

		arr[j] = tmp;

	}
}
/*
 *
 * heapSort(a, a.length-1 );
 * 
 * }
 * 
 * private static void heapSort(int[] a, int n) {
 * 
 * for (int i = n / 2; i >= 0; i--) { maxHeap(a, i); } for(int j = 0 ; j <
 * a.length; j++) { System.out.print(a[j] + " "); } int j = a.length - 1; while
 * (j >= 0) { System.out.print(a[0] + " "); swap(j, 0, a);for(int j = 0 ; j <
 * a.length; j++) { System.out.print(a[j] + " "); }
 * 
 * j++; } }
 * 
 * private static void maxHeap(int[] a, int i) { int left = 2 * i; int right =
 * (2 * i + 1); int s = i; if (left >= 0 && a[i] < a[left]) { s = left; } if
 * (right < a.length && a[i] < a[right]) { s = right; }
 * 
 * if (s != i) { swap(s, i, a); maxHeap(a, s); }
 * 
 * }
 * 
 * private static void swap(int i, int j, int[] a) {
 * 
 * int temp = a[i]; a[i] = a[j]; a[j] = temp; }
 */
