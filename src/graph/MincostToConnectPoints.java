package graph;

import java.util.*;

/*
Min Cost to Connect Points


You are given a 2-D integer array points, where points[i] = [xi, yi]. Each points[i] represents a distinct point on a 2-D plane.
The cost of connecting two points [xi, yi] and [xj, yj] is the manhattan distance between the two points, i.e. |xi - xj| + |yi - yj|.
Return the minimum cost to connect all points together, such that there exists exactly one path between each pair of points.

Input: points = [[0,0],[2,2],[3,3],[2,4],[4,2]]

Output: 10

 */
public class MincostToConnectPoints {
    public static void main(String[] args) {
        int[][] points = { { 0, 0 },
                            { 2, 2 },
                            { 3, 3 },
                            { 2, 4 },
                            { 4, 2 } };
        System.out.println(minCostConnectPoints(points));
    }

    static int minCostConnectPoints(int[][] points) {
        Map<Integer, List<Edge>> adjMap = new HashMap<>();

        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {

                int weight = Math.abs(points[j][0] - points[i][0]) + Math.abs(
                        points[j][1] - points[i][1]);

                adjMap.computeIfAbsent(i, k -> new ArrayList<Edge>())
                        .add(new Edge(i, j, weight));

                adjMap.computeIfAbsent(j, k -> new ArrayList<Edge>())
                        .add(new Edge(j, i, weight));
            }
        }

        Set<Integer> visited = new HashSet<>();

        PriorityQueue<Edge> pq = new PriorityQueue<>(
                Comparator.comparingInt(o -> o.weight));

        int sum = 0;

        pq.add(new Edge(-1, 0, 0));

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();

            if (visited.contains(edge.node))
                continue;

            visited.add(edge.node);

            for (Edge e : adjMap.getOrDefault(edge.node, new ArrayList<>())) {
                pq.add(new Edge(edge.node, e.node, e.weight));
            }

            sum += edge.weight;

        }

        return sum;

    }

    static class Edge {
        Integer parent;
        Integer node;
        int weight;

        Edge(Integer parent, Integer node, int weight) {
            this.parent = parent;
            this.node = node;
            this.weight = weight;
        }
    }
}


