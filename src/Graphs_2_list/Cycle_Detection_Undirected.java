package Graphs_2_list;

import java.util.*;

public class Cycle_Detection_Undirected {
	static class Node{
		int data;
		Node(int data){
			this.data = data;
		}
	}
	static class Graph{
		List<LinkedList<Node>> alist;
		Map<Integer,Integer> DataToIdx;
		
		Graph(){
			alist = new ArrayList<>();
			DataToIdx = new HashMap<>();
		}
		
		public  void Create(Node node) {
			LinkedList<Node> currentList = new LinkedList<>();
			currentList.add(node);
			alist.add(currentList);
			DataToIdx.put(node.data, alist.size()-1);
		}
		
		public void AddEdges(int src,int dst) {
			LinkedList <Node>currentList = alist.get(src);
			Node dstNode = alist.get(dst).get(0);
			currentList.add(dstNode);
			
			LinkedList<Node> currentList_2 = alist.get(dst);
			Node srcNode = alist.get(src).get(0);
			currentList_2.add(srcNode);
		}
		
		public void Print() {
			System.out.println("The Adjecency-List");
			for(int i = 0;i<alist.size();i++) {
				System.out.print(alist.get(i).get(0).data + " -> ");
				for(int j = 1;j<alist.get(i).size();j++) {
					System.out.print(alist.get(i).get(j).data + " ");
				}
				System.out.println();
			}
		}
		
		
		//Cycle-Detection [Parent-Check]	
		
		public boolean CycleCheck() {
			boolean visited[] = new boolean[alist.size()];
			for(int i = 0;i<alist.size();i++) {
				if(!visited[i]) {
					if(Dfs(i,-1,visited)) {
						return true;
					}
				}
			}
			return false;
		}

		public boolean Dfs(int currentidx , int parentidx, boolean[] visited) {
			visited[currentidx] = true;
			for(int i = 1;i<alist.get(currentidx).size();i++) {
				int neighbourdata = alist.get(currentidx).get(i).data;
				int neighbouridx  = DataToIdx.get(neighbourdata);
				if(!visited[neighbouridx]) {
					if(Dfs(neighbouridx,currentidx,visited)) {
						return true;//does the check for each node
					}
				}else if(neighbouridx != parentidx) {
					return true;//condition check
				}
			}
			return false;
		}
		
	}
	
	public static void main(String[]args) {
		Scanner in = new Scanner(System.in);
		Graph graph = new Graph();
		System.out.println("Enter The Number Of Nodes");
		int numOfNodes = in.nextInt();
		System.out.println("Enter The Data : ");
		for(int i = 0;i<numOfNodes;i++) {
			int data = in.nextInt();
			graph.Create(new Node(data));
		}
		System.out.println("Enter The Number Of Edges Required :  ");
		int numOfEdges = in.nextInt();
		System.out.println("Enter The SOURCE And Destinations for these Edges : ");
		for(int i = 0;i< numOfEdges;i++) {
			int Src = in.nextInt();
			int Dst = in.nextInt();
			graph.AddEdges(Src,Dst);
		}
		graph.Print();
		
		if(graph.CycleCheck()) {
			System.out.println("The Undirected Graph Has A Cycle !!!!!");
		}else {
			System.out.println("The Undirected Graph Dosn't Have A Cycle !!!!!");
		}
		in.close();
	}
}
