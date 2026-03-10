package bfs_dfs;

import java.util.*;

public class HopsCalculator {

    // Function to build the adjacency list representation of the graph
    private Map<Integer, List<Integer>> buildAdjacencyList(int numNodes,
            int[][] edges) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int i = 0; i < numNodes; i++) {
            adj.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            adj.get(from).add(to);
        }
        return adj;
    }

    // Function to perform BFS to find the shortest path (hops) from a source to all other nodes
    private int bfsHops(Map<Integer, List<Integer>> adj, int startNode,
            int endNode) {
        Queue<Integer> queue = new LinkedList<>();
        Map<Integer, Integer> distances = new HashMap<>();
        Set<Integer> visited = new HashSet<>();

        queue.add(startNode);
        visited.add(startNode);
        distances.put(startNode, 0);

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();

            // If we reached the destination, return the number of hops
            if (currentNode == endNode) {
                return distances.get(currentNode);
            }

            for (int neighbor : adj.getOrDefault(currentNode,
                    Collections.emptyList())) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    distances.put(neighbor, distances.get(currentNode) + 1);
                    queue.add(neighbor);
                }
            }
        }

        // If the endNode is unreachable, return -1 or a specific indicator
        return -1;
    }

    // Function to process a list of queries and return the results
    public List<Integer> getHopsCount(int numNodes, int[][] edges,
            List<int[]> queries) {
        Map<Integer, List<Integer>> adj = buildAdjacencyList(numNodes, edges);
        List<Integer> results = new ArrayList<>();

        for (int[] query : queries) {
            int from = query[0];
            int to = query[1];
            results.add(bfsHops(adj, from, to));
        }

        return results;
    }

    public static void main(String[] args) {
        HopsCalculator sol = new HopsCalculator();
        int numNodes = 6;

        // Edges in the format {from, to}

        //  0 --> 1 -- > 3
        //  0 --> 2 -- > 3 --> 4 -- > 5

        int[][] edges = {
                { 0, 1 }, { 0, 2 }, { 1, 3 }, { 2, 3 }, { 3, 4 }, { 4, 5 }
        };

        // Queries in the format {from, to}
        List<int[]> queries = new ArrayList<>();
        queries.add(new int[] { 0, 4 });
        queries.add(new int[] { 1, 5 });
        queries.add(new int[] { 5, 0 }); // Unreachable path

        List<Integer> hopsCounts = sol.getHopsCount(numNodes, edges, queries);

        List<Integer> hopsCountsDfs =
                sol.getHopsCountUsingDFS(numNodes, edges, queries);

        System.out.println(
                "Hops counts for queries: " + hopsCounts); // Expected: [3, 2, -1]
        System.out.println(
                "Hops counts for queries: " + hopsCountsDfs);
    }

    public List<Integer> getHopsCountUsingDFS(int numNodes, int[][] edges,
            List<int[]> queries) {
        Map<Integer, List<Integer>> adj = buildAdjacencyList(numNodes, edges);
        List<Integer> results = new ArrayList<>();

        for (int[] query : queries) {
            int from = query[0];
            int to = query[1];
            int[] count = { Integer.MAX_VALUE };
            //int count = 0;
            Set<Integer> set = new HashSet<>();
            DFSHops(adj, from, to, count, set, 0);
            results.add(count[0] != Integer.MAX_VALUE ? count[0] : -1);
        }

        return results;
    }

    private void DFSHops(Map<Integer, List<Integer>> adj, int from, int to,
            int[] count, Set<Integer> set, int hop) {

        if (from == to) {
            count[0] = Math.min(count[0], hop);
            return;
        }
        set.add(from);
        for (int i : adj.get(from)) {
            if (!set.contains(i)) {
                set.add(i);
                DFSHops(adj, i, to, count, set, hop + 1);
            }
        }
        set.remove(from);

    }
}
