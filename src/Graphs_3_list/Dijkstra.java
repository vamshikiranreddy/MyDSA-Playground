package Graphs_3_list;

import java.util.*;

public class Dijkstra {
	static class Pair {
		int node;
		int dst;

		Pair(int node, int dst) {
			this.dst = dst;
			this.node = node;
		}
	}

	static class Node {
		int data;

		Node(int data) {
			this.data = data;
		}
	}

	static class Graph {
		List<LinkedList<Node>> alist;
		Map<Integer, Integer> datatoIdx;
		Map<String, Integer> weight;

		Graph() {
			alist = new ArrayList<>();
			datatoIdx = new HashMap<>();
			weight = new HashMap<>();
		}

		public void Create(Node node) {
			LinkedList<Node> currentList = new LinkedList<>();
			currentList.add(node);
			alist.add(currentList);
			datatoIdx.put(node.data, alist.size() - 1);
		}

		public void addEdges(int src, int dst, int w) {
			LinkedList<Node> currentList_1 = alist.get(src);
			Node dstNode = alist.get(dst).get(0);
			currentList_1.add(dstNode);
			weight.put(src + "-" + dst, w);

			// If Directed Comment Below Snipet
			LinkedList<Node> currentList_2 = alist.get(dst);
			Node srcNode = alist.get(src).get(0);
			currentList_2.add(srcNode);
			weight.put(dst + "-" + src, w);
		}

		public void Print() {
			System.out.println("The Adjecency List");
			for (int i = 0; i < alist.size(); i++) {
				System.out.print(alist.get(i).get(0).data + "->");
				for (int j = 1; j < alist.get(i).size(); j++) {
					System.out.print(alist.get(i).get(j).data + " ");
				}
				System.out.println();
			}
		}

		public void Dijskastra(int srcVal) {
			int V = alist.size();
			boolean visited[] = new boolean[V];
			int distance[] = new int[V];
			Arrays.fill(distance, Integer.MAX_VALUE);
			int srcIdx = datatoIdx.get(srcVal);
			distance[srcIdx] = 0;

			PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.dst));
			pq.offer(new Pair(srcIdx, 0));

			while (!pq.isEmpty()) {
				Pair current = pq.poll();
				int uIdx = current.node;
				int uVal = alist.get(uIdx).get(0).data;

				if (visited[uIdx])
					continue;
				visited[uIdx] = true;

				for (int i = 1; i < alist.get(uIdx).size(); i++) {
					int vVal = alist.get(uIdx).get(i).data;
					int vIdx = datatoIdx.get(vVal);

					String edgeKey = uVal + "-" + vVal;
					int w = weight.getOrDefault(edgeKey, Integer.MAX_VALUE);

					if (distance[uIdx] + w < distance[vIdx]) {
						distance[vIdx] = distance[uIdx] + w;
						pq.offer(new Pair(vIdx, distance[vIdx]));
					}
				}
			}
			System.out.println("Shortest distances from node " + srcVal + ":");
			for (int i = 0; i < V; i++) {
				int nodeVal = alist.get(i).get(0).data;
				System.out.println(
						"To node " + nodeVal + " -> " + (distance[i] == Integer.MAX_VALUE ? "∞" : distance[i]));
			}

		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Graph graph = new Graph();
		System.out.println("Enter The Number Of Nodes");
		int numOfNodes = in.nextInt();
		System.out.println("Enter The Data : ");
		for (int i = 0; i < numOfNodes; i++) {
			int data = in.nextInt();
			graph.Create(new Node(data));
		}
		System.out.println("Enter The Number Of Edges Required :  ");
		int numOfEdges = in.nextInt();
		System.out.println("Enter The Source And Weight And Destinations for these Edges : ");
		for (int i = 0; i < numOfEdges; i++) {
			int Src = in.nextInt();
			int Dst = in.nextInt();
			int w = in.nextInt();
			graph.addEdges(Src, Dst, w);
		}
		graph.Print();
		System.out.println("Enter The Source Element ");
		int srcVal = in.nextInt();
		graph.Dijskastra(srcVal);
	}
}
