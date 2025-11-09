package Graphs_4_list;

import java.util.*;

public class Kosaraju_Algorithm {
	static class Node {
		int data;

		Node(int data) {
			this.data = data;
		}
	}

	static class Graph {
		List<LinkedList<Node>> alist;
		Map<Integer, Integer> dataToIdx;
		List<LinkedList<Node>> reverse_alist = new ArrayList<>();

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
			// Directed for Kosaraju's algo
			LinkedList<Node> currentList = alist.get(src);
			Node dstNode = alist.get(dst).get(0);
			currentList.add(dstNode);
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

		public void print_reverse() {
			System.out.println("The reverse Adjecency List :-");
			for (int i = 0; i < reverse_alist.size(); i++) {
				System.out.print(reverse_alist.get(i).get(0).data + "->");
				for (int j = 1; j < reverse_alist.get(i).size(); j++) {
					System.out.print(reverse_alist.get(i).get(j).data + " ");
				}
				System.out.println();
			}
		}

		public void DFS_1(int currentidx, boolean[] visited, Stack<Integer> stack) {
			visited[currentidx] = true;
			for (int i = 1; i < alist.get(currentidx).size(); i++) {
				int neighbourdata = alist.get(currentidx).get(i).data;
				int neighbouridx = dataToIdx.get(neighbourdata);
				if (!visited[neighbouridx]) {
					DFS_1(neighbouridx, visited, stack);
				}
			}
			stack.push(currentidx);
		}

		public List<LinkedList<Node>> reverse_graph() {
			// Add The HeadNdoes Same AsUsual
			for (int i = 0; i < alist.size(); i++) {
				LinkedList<Node> temp = new LinkedList<>();
				temp.add(alist.get(i).get(0));
				reverse_alist.add(temp);
			}
			for (int i = 0; i < alist.size(); i++) {
				int uVal = alist.get(i).get(0).data;
				for (int j = 1; j < alist.get(i).size(); j++) {
					int vVal = alist.get(i).get(j).data;
					int vIdx = dataToIdx.get(vVal);
					reverse_alist.get(vIdx).add(new Node(uVal)); // u-> v == v -> u
				}
			}
			return reverse_alist;
		}

		public void DFS_2(int currentidx, boolean[] visited, List<Integer> temp) {
			visited[currentidx] = true;
			temp.add(reverse_alist.get(currentidx).get(0).data);
			for (int i = 1; i < alist.get(currentidx).size(); i++) {
				int neighbourdata = reverse_alist.get(i).get(0).data;
				int neighbouridx = dataToIdx.get(neighbourdata);
				if (!visited[neighbouridx]) {
					DFS_2(neighbouridx, visited, temp);
				}
			}
		}

		public void Kosaraju_SCC() {
			// DSF_1 for Stack Fill
			int V = alist.size();
			boolean[] visited = new boolean[V];
			Arrays.fill(visited, false);
			Stack<Integer> stack = new Stack<>();
			for (int i = 0; i < V; i++) {
				if (!visited[i]) {
					DFS_1(i, visited, stack);
				}
			}

			// reverse the Graph
			reverse_alist = reverse_graph();
			print_reverse();
			// DFS_2 on the order of The Stack Elements
			Arrays.fill(visited, false);
			while (!stack.isEmpty()) {
				int idx = stack.pop();
				if (!visited[idx]) {
					List<Integer> temp = new ArrayList<>();
					DFS_2(idx, visited, temp);
					System.out.println(temp);
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
		graph.Kosaraju_SCC();
		in.close();

	}

}
