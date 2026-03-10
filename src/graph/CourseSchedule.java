package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseSchedule {
    public static void main(String[] args) {

        int numCourses = 2;
        int[][] prerequisites = { { 0, 1 } };// 1-->0
        System.out.println(canFinish(numCourses, prerequisites));
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        // check if topological sorting is possible

        Map<Integer, List<Integer>> adjMap = new HashMap<>();

        for (int i = 0; i < prerequisites.length; i++) {
            List<Integer> list = null;
            int v = prerequisites[i][0];
            int u = prerequisites[i][1];

            if (adjMap.containsKey(u)) {
                list = adjMap.get(u);
                list.add(v);
            } else {
                list = new ArrayList<>();
                list.add(v);

            }
            adjMap.put(u, list);
        }
      /*  for(int i=0; i < numCourses;i++) {
            if(!adjMap.containsKey(i)) {
                adjMap.put(i,new ArrayList<>());
            }
        }
        boolean[] visited = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {

            if (!visited[i] && DFS(adjMap, i, visited, -1)) {
                return true;
            }
        }
*/
        return false;

    }

    private static boolean DFS(Map<Integer, List<Integer>> adjMap, int u,
            boolean[] visited, int parent) {

      /*  visited[u] = true;
        List<Integer> path = adjMap.get(u);

        for (int v : path) {

            if (visited[v] && v == parent) {
                return true;

            } else if (!visited[v] && v != parent) {
                DFS(adjMap, v, visited, u);
            }

        }
        return false;*/
        return false;
    }
}
