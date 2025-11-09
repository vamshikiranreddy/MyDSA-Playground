package Graphs_1_List;

import java.util.*;

public class Graph_BFS_List {
	static class Node {
		int data;

		Node(int data) {
			this.data = data;
		}
	}

	static class Graph {
		static ArrayList<LinkedList<Node>> alist = new ArrayList<>();
		static Map<Integer, Integer> dataToIdx = new HashMap<>();

		Graph() {
			alist = new ArrayList<>();
			dataToIdx = new HashMap<>();
		}

		public static void Create(Node node) {
			LinkedList<Node> currentList = new LinkedList<>();
			currentList.add(node);
			alist.add(currentList);
			dataToIdx.put(node.data, alist.size() - 1);
		}

		public static void AddEdge(int src, int dst) {
			LinkedList<Node> currentList = alist.get(src);
			Node dstNode = alist.get(dst).get(0);
			currentList.add(dstNode);

			// If Undirected
			LinkedList<Node> reverseList = alist.get(dst);
			Node srcNode = alist.get(src).get(0);
			reverseList.add(srcNode);

		}

		public static void Print() {
			System.out.println("The Adjecency List");
			for (LinkedList<Node> currentList : alist) {
				System.out.print(currentList.get(0).data + "->");
				for (int i = 1; i < currentList.size(); i++) {
					System.out.print(currentList.get(i).data + " ");
				}
				System.out.println();
			}
		}

		public static void Bfs() {
			Queue<Integer> queue = new LinkedList<>();
			boolean visited[] = new boolean[alist.size()];
			Arrays.fill(visited, false);
			System.out.println("BFS Traverse");
			for (int i = 0; i < alist.size(); i++) {
				if (!visited[i]) {
					visited[i] = true;
					queue.add(i);

					while (!queue.isEmpty()) {
						int currentIdx = queue.poll();
						System.out.print(alist.get(currentIdx).get(0).data + " ");
						for (int j = 1; j < alist.get(currentIdx).size(); j++) {
							int NeighbourData = alist.get(currentIdx).get(j).data;
							int neighbourIdx = dataToIdx.get(NeighbourData);
							if (!visited[neighbourIdx]) {
								visited[neighbourIdx] = true;
								queue.offer(neighbourIdx);
							}
						}
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter The Number Of Nodes Required :");
		int NumNodes = in.nextInt();
		System.out.println("Enter The Data For each Node");
		for (int i = 0; i < NumNodes; i++) {
			int data = in.nextInt();
			Graph.Create(new Node(data));
		}
		System.out.println("Enter The Number of Edges");
		int NumEdges = in.nextInt();
		System.out.println("Enter The Src And Dst in a line for each Node");
		for (int i = 0; i < NumEdges; i++) {
			int src = in.nextInt();
			int dst = in.nextInt();
			Graph.AddEdge(src, dst);
		}
		Graph.Print();
		Graph.Bfs();
		in.close();
	}

}
