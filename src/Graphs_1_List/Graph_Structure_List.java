package Graphs_1_List;

import java.util.*;

public class Graph_Structure_List {
	static class Node {
		int data;

		Node(int data) {
			this.data = data;
		}
	}

	static class Graph {
		static ArrayList<LinkedList<Node>> alist = new ArrayList<>();

		private static void Create(Node node) {
			LinkedList<Node> currentList = new LinkedList<>();
			currentList.add(node);
			alist.add(currentList);
		}

		private static void AddEdges(int src, int dst) {
			LinkedList<Node> currentList = alist.get(src);
			Node dstNode = alist.get(dst).get(0);
			currentList.add(dstNode);
			// If Undirected
			LinkedList<Node> reverseList = alist.get(dst);
			Node srcNode = alist.get(src).get(0);
			reverseList.add(srcNode);
		}

		private static void Print() {
			System.out.println("The Adjecency List :-");
			for (List<Node> currentList : alist) {
				System.out.print(currentList.get(0).data + "->");
				for (int i = 1; i < currentList.size(); i++) {
					System.out.print(currentList.get(i).data + " ");
				}
				System.out.println();
			}
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter The Number Of Nodes");
		int numNodes = in.nextInt();
		System.out.println("Enter The Data (Each line data represents each node) :-");
		for (int i = 0; i < numNodes; i++) {
			int data = in.nextInt();
			Graph.Create(new Node(data));
		}
		System.out.println("Enter The Number Of Edges :- ");
		int numEdges = in.nextInt();
		System.out.println("Enter The Sources And Destinations for each Node");
		for (int i = 0; i < numEdges; i++) {
			int src = in.nextInt();
			int dst = in.nextInt();
			Graph.AddEdges(src, dst);
		}

		System.out.println("The Graph :-");
		Graph.Print();
		in.close();
	}

}
