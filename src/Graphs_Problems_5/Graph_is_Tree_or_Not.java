package Graphs_Problems_5;

import java.util.*;

public class Graph_is_Tree_or_Not {

    // DFS helper for cycle detection
    private boolean dfs(int node, int parent, List<List<Integer>> adj, boolean[] visited) {
        visited[node] = true;

        for (int neigh : adj.get(node)) {
            if (!visited[neigh]) {
                if (dfs(neigh, node, adj, visited)) {
                    return true; // cycle found
                }
            } else if (neigh != parent) {
                return true; // cycle detected
            }
        }
        return false;
    }

    // Main function to check if graph is a tree
    public boolean isTree(int n, List<List<Integer>> adj) {
        boolean[] visited = new boolean[n];

        // 1. Check for cycle
        if (dfs(0, -1, adj, visited)) {
            return false;
        }

        // 2. Check connectivity: all nodes must be visited
        for (boolean v : visited) {
            if (!v) return false;
        }

        return true;
    }

    // Example usage
    public static void main(String[] args) {
        Graph_is_Tree_or_Not obj = new Graph_is_Tree_or_Not();

        int n = 5;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        // Example: tree edges
        adj.get(0).add(1); adj.get(1).add(0);
        adj.get(0).add(2); adj.get(2).add(0);
        adj.get(1).add(3); adj.get(3).add(1);
        adj.get(1).add(4); adj.get(4).add(1);

        System.out.println(obj.isTree(n, adj)); // true
    }
}
