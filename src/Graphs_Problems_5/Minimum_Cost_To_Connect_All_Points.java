package Graphs_Problems_5;

import java.util.*;

public class Minimum_Cost_To_Connect_All_Points {

    // 🔹 Kruskal's MST using DSU
    static class SolutionDSU {
        class Pair {
            int node;
            int dst;
            Pair(int node, int dst) {
                this.node = node;
                this.dst = dst;
            }
        }
        class Edges {
            int src;
            int dst;
            int w;
            Edges(int src, int dst, int w) {
                this.src = src;
                this.dst = dst;
                this.w = w;
            }
        }
        class DisJointSet {
            int[] parent;
            int[] rank;

            DisJointSet(int n) {
                parent = new int[n];
                rank = new int[n];
                for (int i = 0; i < n; i++) {
                    parent[i] = i;
                }
            }

            int findUltimateParent(int node) {
                if (node == parent[node])
                    return node;
                return parent[node] = findUltimateParent(parent[node]);
            }

            void Union(int uIdx, int vIdx) {
                int uUp = findUltimateParent(uIdx);
                int vUp = findUltimateParent(vIdx);
                if (uUp == vUp) return;
                if (rank[uUp] < rank[vUp]) {
                    parent[uUp] = vUp;
                    rank[uUp]++;
                } else if (rank[vUp] < rank[uUp]) {
                    parent[vUp] = uUp;
                    rank[vUp]++;
                } else {
                    parent[vUp] = uUp;
                    rank[uUp]++;
                }
            }
        }

        public int minCost(int[][] houses) {
            int n = houses.length;
            List<List<Integer>> alist = new ArrayList<>();
            for (int i = 0; i < n; i++) alist.add(new ArrayList<>());
            Map<String, Integer> weights = new HashMap<>();
            List<Edges> edges = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    alist.get(i).add(j);
                    alist.get(j).add(i);
                    int w = Math.abs(houses[i][0] - houses[j][0]) +
                            Math.abs(houses[i][1] - houses[j][1]); // ✅ fixed formula
                    weights.put(i + "-" + j, w);
                    weights.put(j + "-" + i, w);
                    edges.add(new Edges(i, j, w));
                    edges.add(new Edges(j, i, w));
                }
            }
            Collections.sort(edges, Comparator.comparingInt(a -> a.w));
            DisJointSet ds = new DisJointSet(n);
            int MST_Weight = 0;
            for (Edges edge : edges) {
                int u = edge.src;
                int v = edge.dst;
                int w = edge.w;
                if (ds.findUltimateParent(u) != ds.findUltimateParent(v)) {
                    MST_Weight += w;
                    ds.Union(u, v);
                }
            }
            return MST_Weight;
        }
    }

    // 🔹 Prim's MST using PQ
    static class SolutionPrim {
        class Pair {
            int node;
            int dst;
            Pair(int node, int dst) {
                this.node = node;
                this.dst = dst;
            }
        }

        public int minCostConnectPoints(int[][] points) {
            int n = points.length;
            List<List<Integer>> alist = new ArrayList<>();
            for (int i = 0; i < n; i++) alist.add(new ArrayList<>());
            Map<String, Integer> weights = new HashMap<>();
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    alist.get(i).add(j);
                    alist.get(j).add(i);
                    int w = Math.abs(points[i][0] - points[j][0]) +
                            Math.abs(points[i][1] - points[j][1]); // ✅ fixed formula
                    weights.put(i + "-" + j, w);
                    weights.put(j + "-" + i, w);
                }
            }
            boolean[] visited = new boolean[n];
            PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.dst));
            pq.offer(new Pair(0, 0));
            int totalWeight = 0;
            int count = 0;
            while (!pq.isEmpty() && count < n) {
                int uIdx = pq.peek().node;
                int currWeight = pq.peek().dst;
                pq.poll();
                if (visited[uIdx]) continue;
                visited[uIdx] = true;
                count++;
                totalWeight += currWeight;
                for (int vIdx : alist.get(uIdx)) {
                    String key = uIdx + "-" + vIdx;
                    int w = weights.get(key);
                    if (!visited[vIdx]) {
                        pq.offer(new Pair(vIdx, w));
                    }
                }
            }
            return totalWeight;
        }
    }

    // 🔹 Example main method
    public static void main(String[] args) {
        int[][] points = {
            {0, 0},
            {2, 2},
            {3, 10},
            {5, 2},
            {7, 0}
        };

        SolutionDSU kruskal = new SolutionDSU();
        SolutionPrim prim = new SolutionPrim();

        System.out.println("Kruskal (DSU) MST cost: " + kruskal.minCost(points));
        System.out.println("Prim (PQ) MST cost: " + prim.minCostConnectPoints(points));
    }
}
