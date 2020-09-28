package array;

public class PrintAllSubArrays {
    public static void main(String[] a) {
        int[] ar = {1, 2, 3, 4};
       // printSubArrays(ar, 0, 0);

        for (int i = 0; i < ar.length; i++) {
            for (int j = i + 1; j < ar.length; j++) {

                for (int z = i; z < j; z++) {
                   // System.out.print(i+" "+j+" "+z);
                    //int d = a[z];
                    System.out.print(ar[z]+" ");
                }
                System.out.println();
            }
        }
    }

    static void printSubArrays(int[] arr, int start, int end) {
        // Stop if we have reached the end of the array
        if (end == arr.length)
            return;

            // Increment the end point and start from 0
        else if (start > end)
            printSubArrays(arr, 0, end + 1);

            // Print the subarray and increment the starting point
        else {
            // System.out.print("[");
            for (int i = start; i <= end; i++) {
                System.out.print(arr[i] + ", ");
            }
            System.out.println();
            //System.out.println(arr[end] + "]");
            printSubArrays(arr, start + 1, end);
        }

        return;
    }

}
