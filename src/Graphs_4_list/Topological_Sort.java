package Graphs_4_list;

import java.util.*;

public class Topological_Sort {
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
			LinkedList<Node> temp = new LinkedList<>();
			temp.add(node);
			alist.add(temp);
			dataToIdx.put(node.data, alist.size() - 1);
		}

		public void AddEdges(int src, int dst) {
			// Topological Sort Only Works On DAG[Direceted - Acyclisc Graph]
			LinkedList<Node> current_list = alist.get(src);
			Node dstNode = alist.get(dst).get(0);
			current_list.add(dstNode);
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

		public List<Integer> Topo_Sort() {
			int V = alist.size();
			boolean[] visited = new boolean[V];
			Stack<Integer> stack = new Stack<>();
			for (int i = 0; i < V; i++) {
				if (!visited[i]) {
					DFS(i, visited, stack);
				}
			}
			List<Integer> result = new ArrayList<>();
			while (!stack.isEmpty()) {
				int idx = stack.pop();
				result.add(alist.get(idx).get(0).data);
			}
			return result;
		}

		public void DFS(int currentidx, boolean[] visited, Stack<Integer> stack) {
			visited[currentidx] = true;
			for (int j = 1; j < alist.get(currentidx).size(); j++) {
				int neighbourdata = alist.get(currentidx).get(j).data;
				int neighbouridx = dataToIdx.get(neighbourdata);
				if (!visited[neighbouridx]) {
					DFS(neighbouridx, visited, stack);
				}
			}
			stack.push(currentidx);
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
			graph.AddEdges(src, dst);
		}
		graph.print();
		List<Integer> topo_sort = graph.Topo_Sort();
		System.out.println("The Topological Order Of The Nodes Are:- ");
		System.out.println(topo_sort);
		in.close();
	}
}
