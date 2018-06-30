package array;

public class MultipleOfElement {

	public static void main(String[] args) {
		int[] a = { 2, 3, 4, 5 };
		multiplicationOfEle(a);

	}

	private static void multiplicationOfEle(int[] arr) {
		int[] result = new int[arr.length];
	    result[result.length-1] = 1;
	  
	    for(int i=arr.length-2; i>=0; i--) {
	        result[i] = result[i+1] * arr[i+1];
	    }
	  
	    int left = 1;
	    for(int i=0; i<arr.length; i++) {
	        result[i] *= left;
	        left *= arr[i];
	    }

		for (int i = 0; i < arr.length; i++) {
			System.out.print(result[i] + " ");
		}

	}

}
