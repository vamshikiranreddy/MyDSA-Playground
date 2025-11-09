package Graphs_6_list;

import java.util.*;

public class M_Coloring {
	static class Node {
		int data;

		Node(int data) {
			this.data = data;
		}
	}

	static class Graph {
		List<LinkedList<Node>> adj;
		Map<Integer, Integer> DataToIdx;

		Graph() {
			adj = new ArrayList<>();
			DataToIdx = new HashMap<>();
		}

		public void Create(Node node) {
			LinkedList<Node> currList = new LinkedList<>();
			currList.add(node);
			adj.add(currList);
			DataToIdx.put(node.data, adj.size() - 1);
		}

		public void AddEdge(int src, int dst) {
			LinkedList<Node> currentList1 = adj.get(src);
			Node dstNode = adj.get(dst).get(0);
			currentList1.add(dstNode);

			LinkedList<Node> currentList2 = adj.get(dst);
			Node srcNode = adj.get(src).get(0);
			currentList2.add(srcNode);
		}

		public boolean isPossible(int m) {
			int V = adj.size();
			int[] colors = new int[V];
			Arrays.fill(colors, 0);
			return recursion(colors, m, 0, V);
		}

		private boolean recursion(int[] colors, int m, int nodeIdx, int V) {
			if (nodeIdx == V)
				return true;
			for (int color = 1; color <= m; color++) {
				if (isSafe(nodeIdx, colors, color)) {
					colors[nodeIdx] = color;
					if (recursion(colors, m, nodeIdx + 1,V))
						return true;
					colors[nodeIdx] = 0;
				}
			}
			return false;
		}

		private boolean isSafe(int nodeIdx, int[] colors, int color) {
			for (int i = 1; i < adj.get(nodeIdx).size(); i++) {
				int neighData = adj.get(nodeIdx).get(i).data;
				int neighIdx = DataToIdx.get(neighData);
				if (colors[neighIdx] == color)
					return false;

			}
			return true;
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Graph graph = new Graph();
		System.out.println("Enter The Number Of Nodes Required : -");
		int NumOfNodes = in.nextInt();
		System.out.println("Enter The Data for Nodes");
		for (int i = 0; i < NumOfNodes; i++) {
			int data = in.nextInt();
			graph.Create(new Node(data));
		}
		System.out.println("Enter The Number Of Edges : ");
		int NumOfEdges = in.nextInt();
		System.out.println("Enter The Src And Dst Node's data");
		for (int i = 0; i < NumOfEdges; i++) {
			int srcData = in.nextInt();
			int dstData = in.nextInt();

			int srcIdx = graph.DataToIdx.get(srcData);
			int dstIdx = graph.DataToIdx.get(dstData);

			graph.AddEdge(srcIdx, dstIdx);
		}
		System.out.println("Enter The Number Of Colors Required :- ");
		int m = in.nextInt();
		if (graph.isPossible(m)) {
			System.out.println("It's Possible To Color The Graph in M colors");
		} else {
			System.out.println("It's Not Possible To Color The Graph in M colors");
		}
		in.close();
	}

}
