package heap;

import java.util.*;

/*
347. Top K Frequent Elements
Solved
Medium
Topics
premium lock icon
Companies
Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.



Example 1:

Input: nums = [1,1,1,2,2,3], k = 2

Output: [1,2]

Example 2:

Input: nums = [1], k = 1

Output: [1]

Example 3:

Input: nums = [1,2,1,2,1,2,3,1,3,2], k = 2

Output: [1,2]


 */
public class TopKElements {

    public static void main(String[] args) {
        int[] a =
                { 1, 2, 1, 2, 1, 2, 3, 1, 3, 2, 4, 4, 4, 4, 4, 5, 5, 6, 6, 6 };
        int k = 4;
        int[] res = topKFrequent(a, k);
        for (int i : res) {
            System.out.print(i + " ");
        }
    }

    static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i : nums) {
            int c = map.getOrDefault(i, 0);
            map.put(i, c + 1);
        }

        PriorityQueue<Integer> pq =
                new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));

        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            pq.add(e.getKey());
        }
        int[] r = new int[k];
        int i = 0;
        while (i < k) {
            r[i++] = pq.poll();
        }

        return r;
    }
}

class TopKFrequentStream {
    private Map<Integer, Integer> freqMap = new HashMap<>();
    private int k;

    public TopKFrequentStream(int k) {
        this.k = k;
    }

    public void add(int num) {
        freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
    }

    public List<Integer> getTopK() {
        PriorityQueue<int[]> minHeap =
                new PriorityQueue<>((a, b) -> a[1] - b[1]);

        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            int number = entry.getKey();
            int freq = entry.getValue();

            if (minHeap.size() < k) {
                minHeap.offer(new int[] { number, freq });
            } else if (freq > minHeap.peek()[1]) {
                minHeap.poll();
                minHeap.offer(new int[] { number, freq });
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            result.add(minHeap.poll()[0]);
        }

        return result;
    }
}