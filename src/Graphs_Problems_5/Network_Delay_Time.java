package Graphs_Problems_5;

import java.util.*;

public class Network_Delay_Time {

    static class Pair {
        int node;
        int dst;
        Pair(int node, int dst) {
            this.node = node;
            this.dst = dst;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        // adjacency list
        List<List<Integer>> alist = new ArrayList<>();
        for (int i = 0; i <= n; i++)
            alist.add(new ArrayList<>());
        
        // weights map
        Map<String, Integer> Weights = new HashMap<>();
        for (int[] time : times) {
            int u = time[0];
            int v = time[1];
            int w = time[2];
            alist.get(u).add(v);
            Weights.put(u + "-" + v, w);
        }

        boolean[] visited = new boolean[n + 1];
        int[] distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[k] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.dst));
        pq.offer(new Pair(k, 0));

        while (!pq.isEmpty()) {
            int uIdx = pq.peek().node;
            int d = pq.peek().dst;
            pq.poll();

            if (visited[uIdx]) continue;
            if (d > distance[uIdx]) continue;

            visited[uIdx] = true;

            for (int vIdx : alist.get(uIdx)) {
                String key = uIdx + "-" + vIdx;
                int w = Weights.get(key);
                if (distance[uIdx] + w < distance[vIdx]) {
                    distance[vIdx] = distance[uIdx] + w;
                    pq.offer(new Pair(vIdx, distance[vIdx]));
                }
            }
        }

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (distance[i] == Integer.MAX_VALUE) return -1;
            ans = Math.max(ans, distance[i]);
        }
        return ans;
    }

    // Example usage
    public static void main(String[] args) {
        Network_Delay_Time solver = new Network_Delay_Time();
        int[][] times = {
            {2, 1, 1},
            {2, 3, 1},
            {3, 4, 1}
        };
        int n = 4, k = 2;
        System.out.println("Network Delay Time = " + solver.networkDelayTime(times, n, k)); // 2
    }
}
