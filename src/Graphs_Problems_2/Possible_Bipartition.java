package Graphs_Problems_2;

import java.util.*;

public class Possible_Bipartition {

    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<List<Integer>> alist = new ArrayList<>();
        for (int i = 0; i <= n; i++)
            alist.add(new ArrayList<>());

        // Build graph
        for (int[] edge : dislikes) {
            int u = edge[0];
            int v = edge[1];
            alist.get(u).add(v);
            alist.get(v).add(u);
        }

        int[] color = new int[n + 1]; // 1-based indexing
        Arrays.fill(color, 0);

        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= n; i++) { // start from 1
            if (color[i] == 0) {
                color[i] = 1;
                q.offer(i);

                while (!q.isEmpty()) {
                    int currNode = q.poll();
                    for (int neighbor : alist.get(currNode)) {
                        if (color[neighbor] == 0) {
                            color[neighbor] = -color[currNode];
                            q.offer(neighbor);
                        } else if (color[neighbor] == color[currNode]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    // For quick testing
    public static void main(String[] args) {
        Possible_Bipartition sol = new Possible_Bipartition();
        int n = 4;
        int[][] dislikes = {{1, 2}, {1, 3}, {2, 4}};
        
        System.out.println(sol.possibleBipartition(n, dislikes)); // true
    }
}
