package subarray;

import java.util.HashMap;
import java.util.Map;

// https://youtu.be/HbbYPQc-Oo4

public class CountAllSubArraySumEqualstoK {
    // 2 = 3
    // 3 = 6
    // 4 = 10
    // 5 = 15
    // L = n * (n + 1) / 2

    public static void main(String[] args) {
        int a[] = {3, 4, 7, 2, -3, 1, 4, 2, 1};
        //int a[] = {1, 2, 3, 4, 5};

        // you need to find all the sub array sum value equals to given number
        System.out.println(findAllSubArraySums(a, 7));// Solution in n2
        System.out.println(findAllSubArraySumsOptimized(a, 7));// Solution in n
    }

    private static int findAllSubArraySumsOptimized(int[] a, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        int sum = 0, count = 0;

        for (int i = 0; i < a.length; i++) {
            sum += a[i];

            if(sum == k) count++;

            if(!map.containsKey(sum)) map.put(sum,1);
            else map.put(sum,map.get(sum)+1);

            //if(a[i] == k) count++;



            if(map.containsKey(sum-k)) count += map.get(sum-k);
        }

        return count;
    }

    private static int findAllSubArraySums(int[] a, int k) {

        int count = 0;

        int[] leftSum = new int[a.length];
        leftSum[0] = a[0];
        for (int i = 1; i < a.length; i++) {
            leftSum[i] = a[i] + leftSum[i - 1];
        }

        for (int i = 0; i < a.length; i++) {
            for (int j = i; j < a.length; j++) {
                int sum = 0;
                if (i == 0) {
                    sum = a[j];
                } else {
                    sum = leftSum[j] - leftSum[i - 1];
                }

                if (sum == k) count++;
            }
        }

        return count;
    }

    private static void printSubArray(int[] a, int i, int j) {
        for (int k = i; k <= j; k++) {
            System.out.print(a[k] + " , ");
        }
        System.out.println();
    }
}
