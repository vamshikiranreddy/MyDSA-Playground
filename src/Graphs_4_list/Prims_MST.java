package Graphs_4_list;

import java.util.*;

public class Prims_MST {

	static class Node {
		int data;

		Node(int data) {
			this.data = data;
		}
	}

	static class Pair {
		int node;
		int dst;

		Pair(int node, int dst) {
			this.node = node;
			this.dst = dst;
		}
	}

	// PRIM'S Algo uses Undirected-Weighed

	public static class Graph {
		List<LinkedList<Node>> alist;
		Map<Integer, Integer> dataToIdx;
		Map<String, Integer> weights;

		Graph() {
			alist = new ArrayList<>();
			dataToIdx = new HashMap<>();
			weights = new HashMap<>();
		}

		public void Create(Node node) {
			LinkedList<Node> currentList = new LinkedList<>();
			currentList.add(node);
			alist.add(currentList);
			dataToIdx.put(node.data, alist.size() - 1);
		}

		public void AddEdges(int srcIdx, int dstIdx, int w) {
			LinkedList<Node> temp_list_1 = alist.get(srcIdx);
			Node dstNode = alist.get(dstIdx).get(0);
			temp_list_1.add(dstNode);
			weights.put(srcIdx + "-" + dstIdx, w);

			LinkedList<Node> temp_list_2 = alist.get(dstIdx);
			Node srcNode = alist.get(srcIdx).get(0);
			temp_list_2.add(srcNode);
			weights.put(dstIdx + "-" + srcIdx, w);
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

		public void MST_Prims() {
			int V = alist.size();
			boolean[] visited = new boolean[V];
			Arrays.fill(visited, false);
			PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.dst));
			int totalWeight = 0;
			pq.offer(new Pair(0, 0)); // start from 0 index
			while (!pq.isEmpty()) {
				Pair current = pq.poll();
				int uIdx = current.node;
				int uVal = alist.get(uIdx).get(0).data;
				int w = current.dst;

				if (visited[uIdx])
					continue;
				visited[uIdx] = true;
				totalWeight += w;
				for (int i = 1; i < alist.get(uIdx).size(); i++) {
					int vVal = alist.get(uIdx).get(i).data;
					int vIdx = dataToIdx.get(vVal);
					if (!visited[vIdx]) {
						String Key = uIdx + "-" + vIdx;
						int edgeWeight = weights.getOrDefault(Key, Integer.MAX_VALUE);
						pq.offer(new Pair(vIdx, edgeWeight));

					}

				}
			}
			System.out.println("The Minimum Weight Of The MST is " + totalWeight);
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Graph graph = new Graph();
		System.out.println("Enter The Num Of Nodes Needed :-");
		int NumOfNodes = in.nextInt();
		System.out.println("Enter The Data For Nodes :-");
		for (int i = 0; i < NumOfNodes; i++) {
			int data = in.nextInt();
			graph.Create(new Node(data));
		}
		System.out.println("Enter The No  Of Edges :- ");
		int NumOfEdges = in.nextInt();
		System.out.println("Enter The Src,Dst,Weights : -");
		for (int i = 0; i < NumOfEdges; i++) {
			int srcVal = in.nextInt();
			int dstVal = in.nextInt();
			int srcIdx = graph.dataToIdx.get(srcVal);
			int dstIdx = graph.dataToIdx.get(dstVal);
			int w = in.nextInt();
			graph.AddEdges(srcIdx, dstIdx, w);
		}
		graph.Print();
		graph.MST_Prims();
		in.close();
	}
}
