package Graphs_Problems_4;

import java.util.*;

public class Critical_Connections_in_a_Network {
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Example graph: n = 4, edges = [[0,1],[1,2],[2,0],[1,3]]
        int n = 4;
        List<List<Integer>> connections = new ArrayList<>();
        connections.add(Arrays.asList(0, 1));
        connections.add(Arrays.asList(1, 2));
        connections.add(Arrays.asList(2, 0));
        connections.add(Arrays.asList(1, 3));

        List<List<Integer>> result = sol.criticalConnections(n, connections);
        System.out.println("Critical Connections: " + result);
        // Expected Output: [[1, 3]]
    }
}

class Solution {
    List<List<Integer>> bridges;
    int time;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        bridges = new ArrayList<>();
        time = 0;

        // Build adjacency list
        List<List<Integer>> alist = new ArrayList<>();
        for (int i = 0; i < n; i++) alist.add(new ArrayList<>());
        for (List<Integer> list : connections) {
            int u = list.get(0);
            int v = list.get(1);
            alist.get(u).add(v);
            alist.get(v).add(u);
        }

        int[] dis_time = new int[n];
        int[] low_dis_time = new int[n];
        boolean[] visited = new boolean[n];

        // Run DFS for all components
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, -1, dis_time, low_dis_time, visited, alist);
            }
        }
        return bridges;
    }

    private void dfs(int uIdx, int parentidx, int[] dis_time, int[] low_dis_time,
                     boolean[] visited, List<List<Integer>> alist) {
        visited[uIdx] = true;
        dis_time[uIdx] = low_dis_time[uIdx] = time++;

        for (int vIdx : alist.get(uIdx)) {
            if (vIdx == parentidx) continue; // skip edge to parent
            if (!visited[vIdx]) {
                dfs(vIdx, uIdx, dis_time, low_dis_time, visited, alist);
                low_dis_time[uIdx] = Math.min(low_dis_time[uIdx], low_dis_time[vIdx]);

                // Bridge condition
                if (dis_time[uIdx] < low_dis_time[vIdx]) {
                    bridges.add(Arrays.asList(uIdx, vIdx));
                }
            } else {
                low_dis_time[uIdx] = Math.min(low_dis_time[uIdx], dis_time[vIdx]);
            }
        }
    }
}
