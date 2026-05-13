package graph;

import java.util.*;

public class IsBipartiteGraph {
    public static void main(String[] args) {

        /*
       Input: graph = [[1,2,3],[0,2],[0,1,3],[0,2]]
       Output: false
       Explanation: There is no way to partition the nodes into two independent sets such that every edge connects a node in one and a node in the other.
*/
        int[][] graph = { { 1, 2, 3 }, { 0, 2 }, { 0, 1, 3 }, { 0, 2 } };

        System.out.println(isBipartite(graph));

        /*
        Input: graph = [[1,3],[0,2],[1,3],[0,2]]
        Output: true
        Explanation: We can partition the nodes into two sets: {0, 2} and {1, 3}.
        */

        graph = new int[][] { { 1, 3 }, { 0, 2 }, { 1, 3 }, { 0, 2 } };

        System.out.println(isBipartite(graph));

    }

    // using DFS
    static public boolean isBipartite(int[][] graph) {

        Map<Integer, List<Integer>> adjMap = getAdjustcentMap(graph);

        int n = graph.length;
        int[] colors = new int[n];
        Arrays.fill(colors, -1);

        // red = 1
        // green = 0

        for (int i = 0; i < n; i++) {
            if (colors[i] == -1) {
                if (!checkIfBipartite(adjMap, 1, i, colors)) {
                    return false;
                }
            }

        }

        return true;
    }

    static boolean checkIfBipartite(Map<Integer, List<Integer>> adjMap,
            int color, int u, int[] colors) {

        colors[u] = color;

        for (int v : adjMap.get(u)) {

            if (colors[v] == colors[u]) {
                return false;
            }

            if (colors[v] == -1) {// never colord or never visted.

                int newColor = 1 - color;//(color == 0) ? 1 : color;

                if (!checkIfBipartite(adjMap, newColor, v, colors)) {
                    return false;
                }
            }

        }
        return true;
    }

    static Map<Integer, List<Integer>> getAdjustcentMap(int[][] graph) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < graph.length; i++) {
            map.put(i, new ArrayList<Integer>());
        }
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                List<Integer> list = map.get(i);
                list.add(graph[i][j]);
                map.put(i, list);
            }
        }

        return map;
    }
}
