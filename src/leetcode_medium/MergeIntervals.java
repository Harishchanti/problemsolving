package leetcode_medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

 

Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
Example 2:

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
Example 3:

Input: intervals = [[4,7],[1,4]]
Output: [[1,7]]
Explanation: Intervals [1,4] and [4,7] are considered overlapping.

 */
public class MergeIntervals {
    public static void main(String[] args) {
        int[][] a = { {4,4},{5,6} };
        /*int[][] result = mergeIntervals(a);// O (nlogn)
        for (int[] r : result) {
            System.out.println("(" + r[0] + "," + r[1] + ")");
        }*/

        int x = Integer.MAX_VALUE+1;
        int y = Integer.MAX_VALUE;
        int m = Integer.MIN_VALUE;

        System.out.println(y+" : "+x +" "+m);
        int[][] result1 = mergeIntervalsV2(a);// O (n * 10000)
        for (int[] r : result1) {
            System.out.println("(" + r[0] + "," + r[1] + ")");
        }

    }

    private static int[][] mergeIntervalsV2(int[][] intervals) {

        int MAX = 10000;

        // For each start, store the farthest end
        int[] maxEndAtStart = new int[MAX + 1];
        boolean[] hasStart = new boolean[MAX + 1];

        for (int[] it : intervals) {
            int s = it[0], e = it[1];
            hasStart[s] = true;
            maxEndAtStart[s] = Math.max(maxEndAtStart[s], e);
        }

        List<int[]> result = new ArrayList<>();

        int curStart = -1;
        int curEnd = -1;

        for (int s = 0; s <= MAX; s++) {
            if (!hasStart[s]) continue;

            int e = maxEndAtStart[s];

            if (curStart == -1) {
                // start first interval
                curStart = s;
                curEnd = e;
            } else if (s <= curEnd) {
                // overlap → merge
                curEnd = Math.max(curEnd, e);
            } else {
                // gap → push previous interval
                result.add(new int[]{curStart, curEnd});
                curStart = s;
                curEnd = e;
            }
        }

        if (curStart != -1) {
            result.add(new int[]{curStart, curEnd});
        }

        return result.toArray(new int[result.size()][]);
    }

    private static int[][] mergeIntervals(int[][] a) {
        Arrays.sort(a, Comparator.comparingInt(o -> o[0]));
        int[] prev = a[0];
        int k = 0;
        List<int[]> result = new ArrayList<>();
        for (int j = 1; j < a.length; j++) {

            if (a[j][0] < prev[1]) {
                prev[1] = Math.max(a[j][1], prev[1]);
            } else {
                result.add(new int[] { prev[0], prev[1] });
                prev = a[j];
            }
        }
        result.add(new int[] { prev[0], prev[1] });

        return result.toArray(new int[0][0]);
    }
}
