package Graphs_Problems_2;

import java.util.*;

public class Find_Safe_Nodes {

    public static void main(String[] args) {
        int[][] graph = {
            {1, 2}, // 0 -> 1, 2
            {2, 3}, // 1 -> 2, 3
            {5},    // 2 -> 5
            {0},    // 3 -> 0 (cycle)
            {5},    // 4 -> 5
            {},     // 5 -> terminal
            {}      // 6 -> terminal
        };

        List<Integer> safeNodes = eventualSafeNodes(graph);
        System.out.println("Safe Nodes: " + safeNodes);
    }

    public static List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        boolean[] visited = new boolean[n];
        boolean[] callStack = new boolean[n]; // like recursion stack
        boolean[] safe = new boolean[n];      // store safe status

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, graph, visited, callStack, safe);
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (safe[i]) {
                result.add(i);
            }
        }
        return result;
    }

    private static boolean dfs(int node, int[][] graph, boolean[] visited, boolean[] callStack, boolean[] safe) {
        visited[node] = true;
        callStack[node] = true;

        for (int neighbor : graph[node]) {
            // Cycle found
            if (callStack[neighbor]) return false;

            // Not visited → explore
            if (!visited[neighbor]) {
                if (!dfs(neighbor, graph, visited, callStack, safe)) return false;
            }
            // Visited but not safe → unsafe
            else if (!safe[neighbor]) {
                return false;
            }
        }

        callStack[node] = false;
        safe[node] = true; // Mark as safe
        return true;
    }
}
