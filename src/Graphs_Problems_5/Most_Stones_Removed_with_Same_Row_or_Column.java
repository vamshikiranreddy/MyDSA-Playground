package Graphs_Problems_5;

import java.util.*;

public class Most_Stones_Removed_with_Same_Row_or_Column {
    
    static class DisjointSet {
        int[] parent;
        int[] rank;

        DisjointSet(int n) {
            parent = new int[n + 1];
            rank = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        int findUp(int node) {
            if (node == parent[node]) return node;
            return parent[node] = findUp(parent[node]); // path compression
        }

        void Union(int u, int v) {
            int Up_u = findUp(u);
            int Up_v = findUp(v);
            if (Up_u == Up_v) return;

            if (rank[Up_u] < rank[Up_v]) {
                parent[Up_u] = Up_v;
            } else if (rank[Up_v] < rank[Up_u]) {
                parent[Up_v] = Up_u;
            } else {
                parent[Up_v] = Up_u;
                rank[Up_u]++;
            }
        }
    }

    public int removeStones(int[][] stones) {
        int totalStones = stones.length;
        int maxRow = 0, maxCol = 0;

        for (int[] stone : stones) {
            maxRow = Math.max(maxRow, stone[0]);
            maxCol = Math.max(maxCol, stone[1]);
        }

        DisjointSet ds = new DisjointSet(maxRow + maxCol + 1);
        Set<Integer> nodes = new HashSet<>();

        for (int[] stone : stones) {
            int row = stone[0];
            int col = stone[1] + maxRow + 1; // shift columns
            ds.Union(row, col);
            nodes.add(row);
            nodes.add(col);
        }

        int count = 0;
        for (int node : nodes) {
            if (ds.findUp(node) == node) count++;
        }

        return totalStones - count;
    }

    // 🔹 Main method for testing
    public static void main(String[] args) {
        Most_Stones_Removed_with_Same_Row_or_Column solver = new Most_Stones_Removed_with_Same_Row_or_Column();

        int[][] stones1 = {{0,0},{0,1},{1,0},{1,2},{2,1},{2,2}};
        int[][] stones2 = {{0,0},{0,2},{1,1},{2,0},{2,2}};

        System.out.println("Result 1: " + solver.removeStones(stones1)); // Expected 5
        System.out.println("Result 2: " + solver.removeStones(stones2)); // Expected 3
    }
}
