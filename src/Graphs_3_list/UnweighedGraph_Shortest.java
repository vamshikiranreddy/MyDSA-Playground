package Graphs_3_list;

import java.util.*;

public class UnweighedGraph_Shortest {
    public static void main(String[] args) {
        int n = 6; // number of nodes (0 to 5)
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Add undirected edges
        addEdge(graph, 0, 1);
        addEdge(graph, 0, 2);
        addEdge(graph, 1, 3);
        addEdge(graph, 2, 4);
        addEdge(graph, 3, 5);
        addEdge(graph, 4, 5);

        int src = 0;
        int dst = 5;

        int shortestDist = bfsShortestPath(graph, src, dst, n);
        System.out.println("Shortest path length from " + src + " to " + dst + " is: " + shortestDist);
    }

    static void addEdge(List<List<Integer>> graph, int u, int v) {
        graph.get(u).add(v);
        graph.get(v).add(u); // because undirected
    }

    static int bfsShortestPath(List<List<Integer>> graph, int src, int dst, int n) {
        boolean[] visited = new boolean[n];
        int[] dist = new int[n];
        Arrays.fill(dist, -1); // -1 means unreachable

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(src);
        visited[src] = true;
        dist[src] = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();

            if (node == dst) return dist[node]; // stop when we reach destination

            for (int neighbor : graph.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    dist[neighbor] = dist[node] + 1;
                    queue.offer(neighbor);
                }
            }
        }
        return -1; // destination not reachable
    }
}
