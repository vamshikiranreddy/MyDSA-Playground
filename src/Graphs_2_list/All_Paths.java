package Graphs_2_list;

import java.util.*;

public class All_Paths {
	static class Node {
		int data;

		Node(int data) {
			this.data = data;
		}
	}

	static class Graph {
		List<LinkedList<Node>> alist;
		Map<Integer, Integer> dataToIdx;
		
		Graph(){
			alist = new ArrayList<>();
			dataToIdx = new HashMap<>();
		}

		public void Create(Node node) {
			LinkedList<Node> currentlist = new LinkedList<>();
			currentlist.add(node);
			alist.add(currentlist);
			dataToIdx.put(node.data, alist.size() - 1);
		}

		public void AddEdge(int src, int dst) {
			LinkedList<Node> currentList = alist.get(src);
			Node dstNode = alist.get(dst).get(0);
			currentList.add(dstNode);
			// If directed comment this below snipet
			LinkedList<Node> currentList_2 = alist.get(dst);
			Node srcNode = alist.get(src).get(0);
			currentList_2.add(srcNode);
		}

		public void print() {
			System.out.println("The Adjecency List : -");
			for (int i = 0; i < alist.size(); i++) {
				System.out.print(alist.get(i).get(0).data + "->");
				for (int j = 1; j < alist.get(i).size(); j++) {
					System.out.print(alist.get(i).get(j).data + " ");
				}
				System.out.println();
			}
		}

		public List<List<Integer>> AllPaths(int srcdata, int dstdata) {
			List<List<Integer>> result = new ArrayList<>();
			List<Integer> Path = new ArrayList<>();
			boolean[] visited = new boolean[alist.size()];
			int srcidx = dataToIdx.get(srcdata);
			int dstidx = dataToIdx.get(dstdata);
			dfs(srcidx, dstidx, visited, result, Path);
			return result;
		}

		private void dfs(int curridx, int dstidx, boolean[] visited, List<List<Integer>> result, List<Integer> path) {
			visited[curridx] = true;
			path.add(alist.get(curridx).get(0).data);
			if (curridx == dstidx) {
				result.add(new ArrayList<>(path));
			} else {
				for (int i = 1; i < alist.get(curridx).size(); i++) {
					int neighbourdata = alist.get(curridx).get(i).data;
					int neighbouridx = dataToIdx.get(neighbourdata);
					if (!visited[neighbouridx]) {
						dfs(neighbouridx, dstidx, visited, result, path);
					}
				}
			}
			path.remove(path.size() - 1); // backtracking
			visited[curridx] = false; // backtracking
		}

	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Graph graph = new Graph();
		System.out.println("Enter The Number Of Nodes :- ");
		int NumOfNodes = in.nextInt();
		System.out.println("Enter The Data :- ");
		for (int i = 0; i < NumOfNodes; i++) {
			int data = in.nextInt();
			graph.Create(new Node(data));
		}
		System.out.println("Enter The Number Of Edges :- ");
		int NumOfEdges = in.nextInt();
		System.out.println("Enter The Source and Destination for each edge");
		for (int i = 0; i < NumOfEdges; i++) {
			int src = in.nextInt();
			int dst = in.nextInt();
			graph.AddEdge(src, dst);
		}

		graph.print();

		System.out.println("Enter The Source Data ");
		int sourcedata = in.nextInt();
		System.out.println("Enter The Destination Data ");
		int destinationdata = in.nextInt();
		List<List<Integer>> result = graph.AllPaths(sourcedata, destinationdata);
		System.out.println("The Paths");
		for (List<Integer> list : result) {
			System.out.print(list + " ");
		}
		in.close();

	}

}
