package Graphs_3_list;

import java.util.*;

public class Floyd_Warshall {
	static class Node {
		int data;

		Node(int data) {
			this.data = data;
		}
	}

	static class Graph {
		List<LinkedList<Node>> alist;
		Map<Integer, Integer> datatoIdx;
		Map<String, Integer> Weights;

		Graph() {
			alist = new ArrayList<>();
			datatoIdx = new HashMap<>();
			Weights = new HashMap<>();
		}

		public void Create(Node node) {
			LinkedList<Node> list = new LinkedList<>();
			list.add(node);
			alist.add(list);
			datatoIdx.put(node.data, alist.size() - 1);
		}

		public void addEdge(int src, int dst, int w) {
			LinkedList<Node> temp_list1 = alist.get(src);
			Node dstNode = alist.get(dst).get(0);
			temp_list1.add(dstNode);
			Weights.put(src + "-" + dst, w);

			LinkedList<Node> temp_list2 = alist.get(dst);
			Node srcNode = alist.get(src).get(0);
			temp_list2.add(srcNode);
			Weights.put(dst + "-" + src, w);
		}

		public void Print() {
			int V = alist.size();
			System.out.println("The Adjecency List :- ");
			for (int i = 0; i < V; i++) {
				System.out.print(alist.get(i).get(0).data + "-> ");
				for (int j = 1; j < alist.get(i).size(); j++) {
					System.out.print(alist.get(i).get(j).data + " ");
				}
				System.out.println();
			}
		}

		public void floyd_warshall() {
			int V = alist.size();
			int[][] distance = new int[V][V];
			// creating the 2D Array
			for (int i = 0; i < V; i++) {
				for (int j = 0; j < V; j++) {
					if (i == j)
						distance[i][j] = 0;
					else {
						int u = alist.get(i).get(0).data;
						int v = alist.get(j).get(0).data;
						String key = u + "-" + v;
						distance[i][j] = Weights.getOrDefault(key, Integer.MAX_VALUE / 2);// /2 is for avoiding over
																							// flow
					}
				}
			}
			// for every node from u -> v
			for (int k = 0; k < V; k++) {
				for (int i = 0; i < V; i++) {
					for (int j = 0; j < V; j++) {
						if (distance[i][k] + distance[k][j] < distance[i][j]) {
							distance[i][j] = distance[i][k] + distance[k][j];
						}
					}
				}
			}

			System.out.println("\nAll-Pairs Shortest Distances (Floyd-Warshall):");
			for (int i = 0; i < V; i++) {
				for (int j = 0; j < V; j++) {
					int u = alist.get(i).get(0).data;
					int v = alist.get(j).get(0).data;
					System.out.print("From " + u + " to " + v + " -> ");
					if (distance[i][j] >= Integer.MAX_VALUE / 2) {
						System.out.println("∞");
					} else {
						System.out.println("Cost = " + distance[i][j]);
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Graph graph = new Graph();
		System.out.println("Enter The Number Of Nodes Required :- ");
		int numOfNodes = in.nextInt();
		System.out.println("Enter The Data For Nodes");
		for (int i = 0; i < numOfNodes; i++) {
			int data = in.nextInt();
			graph.Create(new Node(data));
		}
		System.out.println("Enter The Number Of Edges Required :- ");
		int numOfEdges = in.nextInt();
		System.out.println("Enter The Src Dst And Weights for The Edges : -");
		for (int i = 0; i < numOfEdges; i++) {
			int src = in.nextInt();
			int dst = in.nextInt();
			int w = in.nextInt();
			graph.addEdge(src, dst, w);
		}
		graph.Print();
		System.out.println("The Floyd-Warshall Algorithm :- ");
		graph.floyd_warshall();
		in.close();
	}

}