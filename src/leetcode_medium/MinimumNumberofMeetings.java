package leetcode_medium;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MinimumNumberofMeetings {
    public static void main(String[] args) {
        int[][] a = {{3, 4},
                     {1, 5},
                     {4, 5},
                     {3, 5},
                     {2, 5},
                     {8, 9}
                    };
        System.out.print(minMeetingRooms(a));
    }

    public static int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> (a[0] == b[0] ? (a[1] - b[1]) : (a[0] - b[0])));
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        for (int[] i : intervals) {
            if (!queue.isEmpty() && queue.peek() <= i[0])
                queue.poll();
            queue.add(i[1]);
        }
        return queue.size();
    }
}
