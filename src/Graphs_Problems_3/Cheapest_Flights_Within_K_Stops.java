package Graphs_Problems_3;

import java.util.*;

public class Cheapest_Flights_Within_K_Stops {

	static class Solution {
		class Truple {
			int stops;
			int node;
			int cost;

			Truple(int stops, int node, int cost) {
				this.node = node;
				this.stops = stops;
				this.cost = cost;
			}
		}

		public int CheapestFLight(int n, int flights[][], int src, int dst, int k) {
			List<List<Integer>> alist = new ArrayList<>();
			for (int i = 0; i < n; i++)
				alist.add(new ArrayList<>());

			Map<String, Integer> weights = new HashMap<>();
			for (int[] flight : flights) {
				int u = flight[0];
				int v = flight[1];
				int w = flight[2];
				String key = u + "-" + v;
				weights.put(key, w);
				alist.get(u).add(v);
			}

			int[] minCost = new int[n];
			Arrays.fill(minCost, Integer.MAX_VALUE);
			minCost[src] = 0;

			Queue<Truple> queue = new LinkedList<>();
			queue.offer(new Truple(0, src, 0));

			while (!queue.isEmpty()) {
				Truple cur = queue.poll();
				int uVal = cur.node;
				int currCost = cur.cost;
				int currStops = cur.stops;

				if (currStops > k)
					continue;

				for (int vVal : alist.get(uVal)) {
					String key = uVal + "-" + vVal;
					int w = weights.get(key);

					if (currCost + w < minCost[vVal] && currStops <= k) {
						minCost[vVal] = currCost + w;
						queue.offer(new Truple(currStops + 1, vVal, minCost[vVal]));
					}
				}
			}

			return minCost[dst] == Integer.MAX_VALUE ? -1 : minCost[dst];
		}
	}

	public static void main(String[] args) {
		Solution sol = new Solution();

		int n = 4;
		int[][] flights = { { 0, 1, 100 }, { 1, 2, 100 }, { 2, 3, 100 }, { 0, 2, 500 } };
		int src = 0, dst = 3, k = 1;

		int result = sol.CheapestFLight(n, flights, src, dst, k);
		System.out.println("Cheapest price: " + result);
	}
}
