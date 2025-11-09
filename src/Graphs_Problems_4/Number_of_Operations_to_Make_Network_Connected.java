package Graphs_Problems_4;

import java.util.*;

public class Number_of_Operations_to_Make_Network_Connected {

    static class DisjointSet {
        int[] parent;
        int[] rank;

        DisjointSet(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        int findUp(int node) {
            if (node == parent[node]) return node;
            return parent[node] = findUp(parent[node]); // path compression
        }

        void union(int u, int v) {
            int pu = findUp(u);
            int pv = findUp(v);
            if (pu == pv) return;

            if (rank[pu] < rank[pv]) {
                parent[pu] = pv;
            } else if (rank[pv] < rank[pu]) {
                parent[pv] = pu;
            } else {
                parent[pv] = pu;
                rank[pu]++;
            }
        }
    }

    public static int makeConnected(int n, int[][] connections) {
        int edges = connections.length;
        if (edges < n - 1) {
            return -1; // Not enough cables
        }

        DisjointSet ds = new DisjointSet(n);
        for (int[] conn : connections) {
            ds.union(conn[0], conn[1]);
        }

        Set<Integer> components = new HashSet<>();
        for (int i = 0; i < n; i++) {
            components.add(ds.findUp(i));
        }

        return components.size() - 1;
    }

    public static void main(String[] args) {
        int n = 6;
        int[][] connections = {
            {0, 1}, {0, 2}, {0, 3}, {1, 2}, {4, 5}
        };

        int result = makeConnected(n, connections);
        System.out.println("Minimum operations required = " + result);
    }
}
