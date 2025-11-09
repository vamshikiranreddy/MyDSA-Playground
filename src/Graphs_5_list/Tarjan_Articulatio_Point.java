package Graphs_5_list;

import java.util.*;

public class Tarjan_Articulatio_Point {
	static class Node {
		int data;

		Node(int data) {
			this.data = data;
		}
	}

	static class Graph {
		List<LinkedList<Node>> alist;
		Map<Integer, Integer> datatoidx;
		List<Integer> Articulation_point;

		Graph() {
			alist = new ArrayList<>();
			datatoidx = new HashMap<>();
			Articulation_point = new ArrayList<>();
		}

		public void Create(Node node) {
			LinkedList<Node> temp = new LinkedList<>();
			temp.add(node);
			alist.add(temp);
			datatoidx.put(node.data, alist.size() - 1);
		}

		public void AddEdge(int src, int dst) {
			LinkedList<Node> temp_1 = alist.get(src);
			Node dstNode = alist.get(dst).get(0);
			temp_1.add(dstNode);

			LinkedList<Node> temp_2 = alist.get(dst);
			Node srcNode = alist.get(src).get(0);
			temp_2.add(srcNode);
		}

		public void print() {
			System.out.println("The Adjecenct List :-");
			for (int i = 0; i < alist.size(); i++) {
				System.out.print(alist.get(i).get(0).data + "->");
				for (int j = 1; j < alist.get(i).size(); j++) {
					System.out.print(alist.get(i).get(j).data + " ");
				}
				System.out.println();
			}
		}

		public List<Integer> Tarjan_AP() {
			int V = alist.size();
			boolean[] visited = new boolean[V];
			int disc_time[] = new int[V];
			int low_disc_time[] = new int[V];
			for (int i = 0; i < V; i++) {
				if (!visited[i]) {
					DFS(i, -1, visited, disc_time, low_disc_time);
				}
			}
			return Articulation_point;
		}

		int time = 0;

		public void DFS(int uIdx, int parentidx, boolean[] visited, int[] disc_time, int[] low_disc_time) {
			visited[uIdx] = true;
			disc_time[uIdx] = low_disc_time[uIdx] = time++;
			int children = 0;
			for (int i = 1; i < alist.get(uIdx).size(); i++) {
				int vVal = alist.get(uIdx).get(i).data;
				int vIdx = datatoidx.get(vVal);

				// if the neighbour is a parent ignore
				if (vIdx == parentidx)
					continue;

				// if not visited
				if (!visited[vIdx]) {
					DFS(vIdx, uIdx, visited, disc_time, low_disc_time);
					low_disc_time[uIdx] = Math.min(low_disc_time[uIdx], low_disc_time[vIdx]);
					children++;

					// Condition for an internal node for AP
					// 1 - if there is dist[uIdx] <= low[vIdx] (= for Nodes)
					// 2 - if there is an cycle(parent = -1)

					if (parentidx != -1 && disc_time[uIdx] <= low_disc_time[vIdx]) {
						Articulation_point.add(alist.get(uIdx).get(0).data);
					}
				} else { // if the neighbour is already visited 
					low_disc_time[uIdx] = Math.min(low_disc_time[uIdx], disc_time[vIdx]);
				}
			}
			// NOW check for the First Node foe AP
			if(parentidx == -1 && children > 1) {
				Articulation_point.add(alist.get(uIdx).get(0).data);
			}

		}

	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Graph graph = new Graph();
		System.out.println("Enter The Number Of Nodes Required :-");
		int NumOfNodes = in.nextInt();
		System.out.println("Enter The Data");
		for (int i = 0; i < NumOfNodes; i++) {
			int data = in.nextInt();
			graph.Create(new Node(data));
		}
		System.out.println("Enter The Nomber Of Edges Required :- ");
		int NumOfEdges = in.nextInt();
		System.out.println("Enter The Src And Dst in a line for each Node :-");
		for (int i = 0; i < NumOfEdges; i++) {
			int src = in.nextInt();
			int dst = in.nextInt();
			graph.AddEdge(src, dst);
		}
		graph.print();
		System.out.println("The Articulation point In The Graph are : ");
		List<Integer> result = graph.Tarjan_AP();
		System.out.println(result);
		in.close();

	}

}
