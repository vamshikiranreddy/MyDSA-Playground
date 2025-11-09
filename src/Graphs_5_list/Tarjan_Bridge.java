package Graphs_5_list;

import java.util.*;

public class Tarjan_Bridge {
	static class Node {
		int data;

		Node(int data) {
			this.data = data;
		}
	}

	static class Graph {
		List<LinkedList<Node>> alist;
		Map<Integer, Integer> dataToIdx;

		Graph() {
			alist = new ArrayList<>();
			dataToIdx = new HashMap<>();
		}

		public void Create(Node node) {
			LinkedList<Node> current_list = new LinkedList<>();
			current_list.add(node);
			alist.add(current_list);
			dataToIdx.put(node.data, alist.size() - 1);
		}

		public void AddEdge(int src, int dst) {
			// UnDirected for Tarjan's Algo
			LinkedList<Node> currentList1 = alist.get(src);
			Node dstNode = alist.get(dst).get(0);
			currentList1.add(dstNode);
			
			LinkedList<Node> currentList2 = alist.get(dst);
			Node srcNode = alist.get(src).get(0);
			currentList2.add(srcNode);

		}

		public void print() {
			System.out.println("The Adjecency List :-");
			for (int i = 0; i < alist.size(); i++) {
				System.out.print(alist.get(i).get(0).data + "->");
				for (int j = 1; j < alist.get(i).size(); j++) {
					System.out.print(alist.get(i).get(j).data + " ");
				}
				System.out.println();
			}
		}

		List<List<Integer>> tarjan_list = new ArrayList<>();
		int time = 0;
		public List<List<Integer>> Tarjan_Bridge() {
			int V = alist.size();
			boolean[] visited = new boolean[V];
			int[] disc_time = new int[V];
			int[] low_disc_time = new int[V];
			for (int i = 0; i < V; i++) {
				if (!visited[i]) {
					DFS(i, -1, visited, disc_time, low_disc_time);
				}
			}
			return tarjan_list;
		}

		public void DFS(int uIdx, int parentidx, boolean[] visited, int[] disc_time, int[] low_disc_time) {
			visited[uIdx] = true;
			disc_time[uIdx] = low_disc_time[uIdx] = time++;
			for(int i = 1;i<alist.get(uIdx).size();i++) {
				int vVal = alist.get(uIdx).get(i).data;
				int vIdx = dataToIdx.get(vVal); 
				
				if(vIdx == parentidx) continue;
				
				if(!visited[vIdx]) {
					DFS(vIdx,uIdx,visited,disc_time,low_disc_time);
					low_disc_time[uIdx] = Math.min(low_disc_time[uIdx],low_disc_time[vIdx]); // backtracking updation
					if(disc_time[uIdx] < low_disc_time[vIdx]) {
						List<Integer> bridge = new ArrayList<>();
						bridge.add(alist.get(uIdx).get(0).data);
						bridge.add(alist.get(vIdx).get(0).data);
						tarjan_list.add(bridge);
					}
				}else { // if neighbour is already visited
					low_disc_time[uIdx] = Math.min(low_disc_time[uIdx], disc_time[vIdx]);// To get the lowest time of visit in the cycle
				}
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
		System.out.println("The Bridge In The Graph is between : ");
		List<List<Integer>> result = graph.Tarjan_Bridge();
		System.out.println(result);
		in.close();

	}
}
