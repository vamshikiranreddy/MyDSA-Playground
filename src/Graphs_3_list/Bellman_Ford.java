package Graphs_3_list;

import java.util.*;

public class Bellman_Ford {

	static class Node {
		int data;

		Node(int data) {
			this.data = data;
		}
	}

	static class Graph {
		List<LinkedList<Node>> alist;
		Map<Integer, Integer> dataToIdx;
		Map<String, Integer> weights;

		Graph() {
			alist = new ArrayList<>();
			dataToIdx = new HashMap<>();
			weights = new HashMap<>();
		}

		public void Create(Node node) {
			LinkedList<Node> CurrentList = new LinkedList<>();
			CurrentList.add(node);
			alist.add(CurrentList);
			dataToIdx.put(node.data, alist.size() - 1);
		}

		public void AddEdges(int src, int dst, int w) {
			LinkedList<Node> templist_1 = alist.get(src);
			Node dstNode = alist.get(dst).get(0);
			templist_1.add(dstNode);
			weights.put(src + "-" + dst, w);

			// If Directed Comment The Snippet Below

			//LinkedList<Node> templist_2 = alist.get(dst);
			//Node srcNode = alist.get(src).get(0);
			//templist_2.add(srcNode);
			//weights.put(dst + "-" + src, w);
		}

		public void Print() {
			System.out.println("The Adjecency List :-");
			for (int i = 0; i < alist.size(); i++) {
				System.out.print(alist.get(i).get(0).data + " ->");
				for (int j = 1; j < alist.get(i).size(); j++) {
					System.out.print(alist.get(i).get(j).data + " ");
				}
				System.out.println();
			}
		}

		public void Bellman_Ford(int src) {
			int V = alist.size();
			int distance[] = new int[V];
			int srcIdx = dataToIdx.get(src);
			Arrays.fill(distance, Integer.MAX_VALUE);
			distance[srcIdx] = 0;

			// Relaxation V-1 Times
			for (int i = 0; i < V - 1; i++) {
				for (int uIdx = 0; uIdx < alist.size(); uIdx++) {
					int uVal = alist.get(uIdx).get(0).data;
					for (int j = 1; j < alist.get(uIdx).size(); j++) {
						int vVal = alist.get(uIdx).get(j).data;
						int vIdx = dataToIdx.get(vVal);
						String key = uVal + "-" + vVal;
						int w = weights.getOrDefault(key, Integer.MAX_VALUE);
						// Relaxation
						if (distance[uIdx] + w < distance[vIdx]) {
							distance[vIdx] = distance[uIdx] + w;
						}
					}
				}
			}
			// For Negetive Cycles
			for (int uIdx = 0; uIdx < alist.size(); uIdx++) {
				int uVal = alist.get(uIdx).get(0).data;
				for (int j = 1; j < alist.get(uIdx).size(); j++) {
					int vVal = alist.get(uIdx).get(j).data;
					int vIdx = dataToIdx.get(vVal);
					String key = uVal + "-" + vVal;
					int w = weights.getOrDefault(key, Integer.MAX_VALUE);
					if (distance[uIdx] + w < distance[vIdx]) {
						System.out.println("Negetive Cycle Detected !!!!!!!!!!");
						return;
					}
				}
			}
			// Print distances
			System.out.println("\nShortest distances from node " + src + ":");
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
		System.out.println("Enter The Number Of Nodes Required :-");
		int NumOfNodes = in.nextInt();
		System.out.println("Enter The Data to be Stored In The Nodes :- ");
		for (int i = 0; i < NumOfNodes; i++) {
			int data = in.nextInt();
			graph.Create(new Node(data));
		}
		System.out.println("Enter The Number Of Edges Required With Source,Destination,Weights:-");
		int NumOfEdges = in.nextInt();
		System.out.println("Enter The src,dst,w for the respected Edges :-");
		for (int i = 0; i < NumOfEdges; i++) {
			int src = in.nextInt();
			int dst = in.nextInt();
			int w = in.nextInt();
			graph.AddEdges(src, dst, w);
		}
		graph.Print();
		System.out.println("Enter The src Value For Algorithm :-");
		int src = in.nextInt();
		graph.Bellman_Ford(src);
		in.close();
	}
}
