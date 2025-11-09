package Graphs_Problems_4;

public class Redundant_Connection {

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

        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]); // path compression
            }
            return parent[x];
        }

        boolean union(int u, int v) {
            int pu = find(u);
            int pv = find(v);
            if (pu == pv) return false; // cycle detected

            if (rank[pu] < rank[pv]) {
                parent[pu] = pv;
            } else if (rank[pv] < rank[pu]) {
                parent[pv] = pu;
            } else {
                parent[pv] = pu;
                rank[pu]++;
            }
            return true;
        }
    }

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        DisjointSet dsu = new DisjointSet(n);

        for (int[] edge : edges) {
            if (!dsu.union(edge[0], edge[1])) {
                return edge; // this edge creates a cycle
            }
        }
        return new int[0]; // should never reach here
    }

    public static void main(String[] args) {
        Redundant_Connection rc = new Redundant_Connection();
        int[][] edges = {
                {1, 2},
                {1, 3},
                {2, 3}
        };

        int[] redundant = rc.findRedundantConnection(edges);
        System.out.println("Redundant edge: [" + redundant[0] + ", " + redundant[1] + "]");
    }
}
