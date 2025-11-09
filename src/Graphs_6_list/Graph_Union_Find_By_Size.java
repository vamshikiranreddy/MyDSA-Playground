package Graphs_6_list;

import java.util.*;

public class Graph_Union_Find_By_Size {

	static class Node {
		int data;

		Node(int data) {
			this.data = data;
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

			public void AddEdges(int src, int dst, int w) {
				LinkedList<Node> temp_list_1 = alist.get(src);
				Node dstNode = alist.get(dst).get(0);
				temp_list_1.add(dstNode);
				weights.put(src + "-" + dst, w);

				LinkedList<Node> temp_list_2 = alist.get(dst);
				Node srcNode = alist.get(src).get(0);
				temp_list_2.add(srcNode);
				weights.put(dst + "-" + src, w);
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

		static class UnionFind {
			int[] parent;
			int[] size;
			int count;

			UnionFind(int n) {
				parent = new int[n];
				size = new int[n];
				count = n;
				// fill the parent And Size
				for (int i = 0; i < n; i++) {
					parent[i] = i;
					size[i] = 1;
				}
			}

			// PathCompression
			public int findUParent(int node) {
				if (node == parent[node])
					return node; // find the parent
				return parent[node] = findUParent(parent[node]); // fill the parent while BackTracking
			}

			// To Find If The Nodes are Of One Component
			public boolean isConnected(int u, int v) {
				return findUParent(u) == findUParent(v);
			}

			public void Union(int u, int v) {
				int Ul_u = findUParent(u);
				int Ul_v = findUParent(v);

				if (Ul_u == Ul_v)
					return;
				// case 1 if u's size is less than v connect u to v
				if(size[Ul_u] < size[Ul_v]) {
					parent[Ul_u] = Ul_v;
					size[Ul_v] += size[Ul_u];
				}else {
					parent[Ul_v] = Ul_u;
					size[Ul_u] += size[Ul_v];
				}
				count--;// if parents are diffrent it decreases
			}

			// Get Count
			int getCount() {
				return count;
			}

		}

		public static void main(String[] args) {
			Scanner in = new Scanner(System.in);
			Graph graph = new Graph();
			System.out.println("Enter The Number Of Nodes Required :- ");
			int numofNodes = in.nextInt();
			UnionFind uf = new UnionFind(numofNodes);
			System.out.println("Enter The Data Of The Nodes :- ");
			for (int i = 0; i < numofNodes; i++) {
				int data = in.nextInt();
				graph.Create(new Node(data));
			}
			System.out.println("Enter The Number Of Edges Required :- ");
			int numOfEdges = in.nextInt();
			System.out.println("Enter The Src And Dst (node data) And Weight for each Edge :- ");
			for (int i = 0; i < numOfEdges; i++) {
			    int srcData = in.nextInt();
			    int dstData = in.nextInt();
			    int w = in.nextInt();

			    // Convert data to index
			    int u = graph.datatoIdx.get(srcData);
			    int v = graph.datatoIdx.get(dstData);

			    uf.Union(u, v);
			    graph.AddEdges(u, v, w);
			}
			graph.Print();
			System.out.println("Enter The Number Of Quires Required For Union Find");
			int numofQ = in.nextInt();
			System.out.println("Enter The Src And Dst For the Edges to be Checked :-");
			for (int i = 0; i < numofQ; i++) {
				int u = in.nextInt();
				int v = in.nextInt();
				if (uf.isConnected(u, v))
					System.out.println(u + " and " + v + " are connected.");
				else
					System.out.println(u + " and " + v + " are Not connected.");
			}
			System.out.println("And The Number Of DisjointSets Are : " + uf.getCount());
			in.close();

		}
	}
}
