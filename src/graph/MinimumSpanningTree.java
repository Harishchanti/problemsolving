package graph;

/*
Given a weighted, undirected, and connected graph with V vertices and a 2D array edges[][],
where each element edges[i] = [u, v, w] represents an edge between vertices u and v with weight w,
 return the sum of the weights of all edges in the graph's Minimum Spanning Tree (MST).


 Input: V = 3, E = 3, Edges = [[0, 1, 5], [1, 2, 3], [0, 2, 1]]

Output: 4


Input: V = 2, E = 1, Edges = [[0 1 5]]



Output: 5
Explanation: Only one Spanning Tree is possible which has a weight of 5.

 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MinimumSpanningTree {
    public static void main(String[] args) {

        int[][] city1 = { { 1, 2, 1 },
                        { 1, 3, 2 },
                        { 1, 4, 3 },
                        { 1, 5, 4 },
                        { 2, 3, 5 },
                        { 2, 5, 7 },
                        { 3, 4, 6 } };
        System.out.println(findMST(5, city1));

        int[][] city2 = { { 1, 2, 1 },
                        { 1, 3, 1 },
                        { 1, 4, 100 },
                        { 2, 3, 1 },
                        { 4, 5, 2 },
                        { 4, 6, 2 },
                        { 5, 6, 2 } };
        System.out.println(findMST(6, city2));

    }

    private static int findMST(int V, int[][] city) {

        List<List<Edge>> adj = new ArrayList<>();
        for (int i = 0; i <= V; i++) adj.add(new ArrayList<>()); // 1-based indexing

        // Convert edge list to adjacency list
        for (int[] edge : city) {
            int u = edge[0], v = edge[1], w = edge[2];
            adj.get(u).add(new Edge(u,v, w));
            adj.get(v).add(new Edge(v,u, w));
        }

        PriorityQueue<Edge> pq =
                new PriorityQueue<>(Comparator.comparingInt(o -> o.weight));
        boolean[] visited = new boolean[V+1];

        pq.add(new Edge(-1,1, 0)); // Start from node 1

        int minSum =0;

        while (!pq.isEmpty()) {
            Edge e = pq.poll();

            if(visited[e.node]) {
                continue;
            }
            visited[e.node] = true;

            minSum += e.weight;

            for (Edge edge : adj.get(e.node)) {
                pq.add(new Edge(e.node,edge.node,edge.weight));
            }
        }
        return minSum;
    }
}

class Edge {

    int node, weight, parent;

    Edge(int parent,int node, int weight) {
        this.node = node;
        this.weight = weight;
        this.parent = parent;
    }
}