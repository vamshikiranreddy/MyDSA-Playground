package Graphs_5_list;

import java.util.*;

public class Baipartite_DFS {
	static boolean isBaptrite = true;

	static class Node {
		int data;

		Node(int data) {
			this.data = data;
		}
	}

	static class Graph {
		List<LinkedList<Node>> alist;
		Map<Integer, Integer> datatoIdx;

		Graph() {
			alist = new ArrayList<>();
			datatoIdx = new HashMap<>();
		}

		public void Create(Node node) {
			LinkedList<Node> currentList = new LinkedList<>();
			currentList.add(node);
			alist.add(currentList);
			datatoIdx.put(node.data, alist.size() - 1);
		}

		public void AddEdge(int src, int dst) {
			LinkedList<Node> currentList1 = alist.get(src);
			Node dstNode = alist.get(dst).get(0);
			currentList1.add(dstNode);

			LinkedList<Node> currentList2 = alist.get(dst);
			Node srcNode = alist.get(src).get(0);
			currentList2.add(srcNode);
		}

		public void Print() {
			System.out.println("The Adjecenct List :-");
			for (int i = 0; i < alist.size(); i++) {
				System.out.print(alist.get(i).get(0).data + "->");
				for (int j = 1; j < alist.get(i).size(); j++) {
					System.out.print(alist.get(i).get(j).data + " ");
				}
				System.out.println();
			}
		}

		public void Baptrite() {
			int V = alist.size();
			int color[] = new int[V];
			Arrays.fill(color, 0);
			for (int i = 0; i < V; i++) {
				if (color[i] == 0) {
					if (!DFS(i, 1, color)) {
						isBaptrite = false;
					}
				}
			}
		}

		public boolean DFS(int currentidx, int currentcolor, int[] color) {
			color[currentidx] = currentcolor;
			for (int i = 1; i < alist.get(currentidx).size(); i++) {
				int neighbourdata = alist.get(currentidx).get(i).data;
				int neighbouridx = datatoIdx.get(neighbourdata);
				if (color[neighbouridx] == 0) {
					if (!DFS(neighbouridx, -currentcolor, color)) {
						return false;
					}
				} else if (color[neighbouridx] == color[currentidx]) {
					return false;
				}
			}
			return true;
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
		System.out.println("Enter The Src And Dst for each Edges :- ");
		for (int i = 0; i < numOfEdges; i++) {
			int src = in.nextInt();
			int dst = in.nextInt();
			graph.AddEdge(src, dst);
		}
		graph.Print();
		graph.Baptrite();
		if (isBaptrite) {
			System.out.println("Yes The Graph Is Baptrite");
		} else {
			System.out.println("No The Graph Is Not Baptrite");
		}
		in.close();

	}

}
