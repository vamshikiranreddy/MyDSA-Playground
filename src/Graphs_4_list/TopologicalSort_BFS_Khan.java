package Graphs_4_list;

import java.util.*;

public class TopologicalSort_BFS_Khan {

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

		public void AddEdge(int src, int dst) {
			LinkedList<Node> temp = alist.get(src);
			Node dstNode = alist.get(dst).get(0);
			temp.add(dstNode);
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

		public List<Integer> Khan_Topo() {
			int V = alist.size();
			int[] indegree = new int[V];
			for(int i = 0;i<V;i++) {
				for(int j = 1;j<alist.get(i).size();j++) {
					int neighbourdata = alist.get(i).get(j).data;
					int neighbouridx = dataToIdx.get(neighbourdata);
					indegree[neighbouridx]++;
				}
			}
			Queue<Integer> q = new LinkedList<>();
			List<Integer> topo = new ArrayList<>();
			for(int i = 0;i<V;i++) {
				if(indegree[i] == 0) q.offer(i);
			}
			while(!q.isEmpty()) {
				int topNode = q.peek();
				q.poll();
				topo.add(alist.get(topNode).get(0).data);
				for(int i = 1;i<alist.get(topNode).size();i++) {
					int neighbourdata = alist.get(topNode).get(i).data;
					int neighbouridx = dataToIdx.get(neighbourdata);
					indegree[neighbouridx]--;
					if(indegree[neighbouridx] == 0) q.offer(neighbouridx);
				}
			}
			return topo;
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Graph graph = new Graph();
		System.out.println("Enter The Number Of Nodes Required :- ");
		int NumOfNodes = in.nextInt();
		System.out.println("Enter The Data :-");
		for (int i = 0; i < NumOfNodes; i++) {
			int data = in.nextInt();
			graph.Create(new Node(data));
		}
		System.out.println("Enter The Number Of Edges Required :- ");
		int NumOfEdges = in.nextInt();
		System.out.println("Enter The Sources And Destination Node data");
		for (int i = 0; i < NumOfEdges; i++) {
			int srcData = in.nextInt();
			int dstData = in.nextInt();

			int srcIdx = graph.dataToIdx.get(srcData);
			int dstIdx = graph.dataToIdx.get(dstData);
			graph.AddEdge(srcIdx, dstIdx);
		}
		graph.print();
		List<Integer> result = graph.Khan_Topo();
		System.out.println("The Topological sorting is (u -> v)");
		System.out.println(result);
		in.close();
	}

}
