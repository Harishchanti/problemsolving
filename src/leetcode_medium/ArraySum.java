package leetcode_medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given an array and list of queries that contains and starting
 and end indexes we have to find the sum of arrays from staring to
 end indexes and add it to the list for each query.
eg.
 */
public class ArraySum {
    public static void main(String[] args) {
        int[] a = {1, 2, 5, 8, 9, 10};
        List<List<Integer>> l = new ArrayList<>();
        l.add(Arrays.asList(2, 5));
        l.add(Arrays.asList(3, 5));

        List<Integer> outPut = findSumBetweenIndex(a, l);
        System.out.println();
        outPut.forEach(o -> System.out.print(o + " "));

        // {1,2,5,8,9,10} , and queries = List<List<Integer>> queries= [[2,5],[3,5]];
        //output=list<Integer> =[32,27]
    }

    private static List<Integer> findSumBetweenIndex(int[] a, List<List<Integer>> l) {
        List<Integer> output = new ArrayList<>();
        int[] right = new int[a.length];
        right[0] = a[0];
        for (int i = 1; i < a.length; i++) {
            right[i] = right[i - 1] + a[i];
        }
        for (int i : right) System.out.print(i + " ");
        for (List<Integer> s : l) {
            int i = s.get(0);
            int j = s.get(1);
            output.add(right[j] - right[i-1]);
        }

        return output;
    }
}
