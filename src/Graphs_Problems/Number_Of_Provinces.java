package Graphs_Problems;

import java.util.*;

public class Number_Of_Provinces {
	static class Node {
		int data;

		Node(int data) {
			this.data = data;
		}
	}

	static class Graph {
		List<LinkedList<Node>> alist;
		Map<Integer, Integer> datatoIdx;
		Map<String, Integer> weights;

		Graph() {
			alist = new ArrayList<>();
			datatoIdx = new HashMap<>();
			weights = new HashMap<>();
		}

		public void Create(Node node) {
			LinkedList<Node> currentList = new LinkedList<>();
			currentList.add(node);
			alist.add(currentList);
			datatoIdx.put(node.data, alist.size() - 1);
		}

		public void AddEdge(int src, int dst) {
			LinkedList<Node> temp_list_1 = alist.get(src);
			Node dstNode = alist.get(dst).get(0);
			temp_list_1.add(dstNode);

			LinkedList<Node> temp_list_2 = alist.get(dst);
			Node srcNode = alist.get(src).get(0);
			temp_list_2.add(srcNode);
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
	}

	static class DisjointSet {
		int[] parent;
		int[] rank;

		DisjointSet(int V) {
			parent = new int[V];
			rank = new int[V];
			for (int i = 0; i < V; i++) {
				parent[i] = i;
			}
		}

		public int findUlParent(int node) {
			if (node == parent[node])
				return node;
			return parent[node] = findUlParent(parent[node]);
		}

		public void Union(int u, int v) {
			int Ul_u = findUlParent(u);
			int Ul_v = findUlParent(v);

			if (Ul_u == Ul_v)
				return;
			if (rank[Ul_u] < rank[Ul_v]) {
				parent[Ul_u] = Ul_v;
				rank[Ul_v]++;
			} else if (rank[Ul_v] < rank[Ul_u]) {
				parent[Ul_v] = Ul_u;
				rank[Ul_u]++;
			} else {
				parent[Ul_v] = Ul_u;
				rank[Ul_u]++;
			}
		}

	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Graph graph = new Graph();
		System.out.println("Enter The Number Of Nodes Required :- ");
		int numofNodes = in.nextInt();
		System.out.println("Enter The Data Of The Nodes :- ");
		for (int i = 0; i < numofNodes; i++) {
			int data = in.nextInt();
			graph.Create(new Node(data));
		}
		System.out.println("Enter The Number Of Edges Required :- ");
		int numOfEdges = in.nextInt();
		System.out.println("Enter The Src And Dst node's data for each Edges :- ");
		for (int i = 0; i < numOfEdges; i++) {
			int src = in.nextInt();
			int dst = in.nextInt();

			int srcidx = graph.datatoIdx.get(src);
			int dstidx = graph.datatoIdx.get(dst);
			graph.AddEdge(srcidx, dstidx);
		}
		graph.Print();

		int V = graph.alist.size();
		DisjointSet uf = new DisjointSet(V);

		for (int i = 0; i < V; i++) {
			for (int j = 1; j < graph.alist.get(i).size(); j++) {
				int u = i;
				int v = graph.datatoIdx.get(graph.alist.get(i).get(j).data);
				uf.Union(u, v);
			}
		}
		int count = 0;
		for (int i = 0; i < V; i++) {
			if (uf.parent[i] == i)
				count++;
		}
		
		System.out.println(" The Number Of Provinces Are :-" + count);
		in.close();
	}
	
	// -----------------------------------------
		// DFS Version for Counting Provinces
		/*
		static void dfs(int nodeIdx, boolean[] visited, Graph graph) {
			visited[nodeIdx] = true;
			LinkedList<Node> neighbors = graph.alist.get(nodeIdx);
			for (int i = 1; i < neighbors.size(); i++) {
				int neighborIdx = graph.datatoIdx.get(neighbors.get(i).data);
				if (!visited[neighborIdx]) {
					dfs(neighborIdx, visited, graph);
				}
			}
		}

		// Uncomment this and replace main’s logic if you want to use DFS instead:
		static int countProvincesDFS(Graph graph) {
			int V = graph.alist.size();
			boolean[] visited = new boolean[V];
			int count = 0;

			for (int i = 0; i < V; i++) {
				if (!visited[i]) {
					count++;
					dfs(i, visited, graph);
				}
			}
			return count;
		}
		*/
		// -----------------------------------------
}
