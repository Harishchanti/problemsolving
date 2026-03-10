package graph;

import java.util.*;

public class CourseSchedule {
    public static void main(String[] args) {

        int numCourses = 2;
        int[][] prerequisites = { { 0, 1 } };// 1-->0
        System.out.println(canFinish(numCourses, prerequisites));
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {

        Map<Integer, List<Integer>> adjMap = new HashMap<>();
        List<Integer> list = null;

        int[] indegree = new int[numCourses];

        for(int i = 0; i< numCourses; i++) {
            adjMap.put(i,new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {

            int v = prerequisites[i][0];
            int u = prerequisites[i][1];

            list = adjMap.get(u);
            list.add(v);

            indegree[v]++; // { { 0, 1 } };// 1 --> 0
            adjMap.put(u, list);
        }



        return isTopoligicalSort(adjMap, numCourses, indegree);

    }

    private static boolean isTopoligicalSort(Map<Integer, List<Integer>> adjMap,
            int numCourses, int[] indegree) {

        Queue<Integer> queue = new LinkedList<>();
        int count = 0;

        for (int i = 0; i < indegree.length; i++) {

            if (indegree[i] == 0) {
                queue.add(i);
                count++;
            }
        }

        while (!queue.isEmpty()) {
            int u = queue.poll();

            for (Integer v : adjMap.get(u)) {

                indegree[v]--;

                if (indegree[v] == 0) {
                    queue.add(v);
                    count++;
                }
            }

        }

        if (count == numCourses)
            return true;

        return false;
    }

}
