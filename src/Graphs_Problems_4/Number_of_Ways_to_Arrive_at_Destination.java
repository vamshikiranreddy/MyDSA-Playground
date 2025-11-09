package Graphs_Problems_4;

import java.util.*;

public class Number_of_Ways_to_Arrive_at_Destination {

    static class Solution {
        static class Pair {
            int node;
            long dist;
            Pair(int node, long dist) {
                this.node = node;
                this.dist = dist;
            }
        }

        static int countPaths(int n, int[][] roads) {
            List<List<Integer>> alist = new ArrayList<>();
            Map<String, Integer> weights = new HashMap<>();

            for (int i = 0; i < n; i++) alist.add(new ArrayList<>());

            for (int[] road : roads) {
                int u = road[0];
                int v = road[1];
                int w = road[2];
                alist.get(u).add(v);
                alist.get(v).add(u);
                weights.put(u + "-" + v, w);
                weights.put(v + "-" + u, w);
            }

            long[] distance = new long[n];
            Arrays.fill(distance, Long.MAX_VALUE);
            int[] ways = new int[n];
            ways[0] = 1;
            distance[0] = 0;

            PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a.dist));
            pq.offer(new Pair(0, 0));
            int MOD = 1_000_000_007;

            while (!pq.isEmpty()) {
                int uVal = pq.peek().node;
                long d = pq.peek().dist;
                pq.poll();

                if (d > distance[uVal]) continue;

                for (int vVal : alist.get(uVal)) {
                    String key = uVal + "-" + vVal;
                    int w = weights.get(key);
                    if (distance[uVal] + w < distance[vVal]) {
                        distance[vVal] = distance[uVal] + w;
                        pq.offer(new Pair(vVal, distance[vVal]));
                        ways[vVal] = ways[uVal];
                    } else if (distance[uVal] + w == distance[vVal]) {
                        ways[vVal] = (ways[uVal] + ways[vVal]) % MOD;
                    }
                }
            }
            return ways[n - 1] % MOD;
        }
    }

    // main method
    public static void main(String[] args) {
        int[][] roads = {
            {0,6,7},
            {0,1,2},
            {1,2,3},
            {1,3,3},
            {6,3,3},
            {3,5,1},
            {6,5,1},
            {2,5,1},
            {0,4,5},
            {4,6,2}
        };

        int n = 7; // number of nodes (0 to 6)

        int result = Solution.countPaths(n, roads);

        System.out.println("Number of ways to reach destination = " + result);
    }
}
