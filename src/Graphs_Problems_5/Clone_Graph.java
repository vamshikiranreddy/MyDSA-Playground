package Graphs_Problems_5;

import java.util.*;

public class Clone_Graph {
	static class Node {
		public int val;
		public List<Node> neighbors;

		public Node() {
			neighbors = new ArrayList<>();
		}

		public Node(int val) {
			this.val = val;
			neighbors = new ArrayList<>();
		}

		public Node(int val, List<Node> neighbors) {
			this.val = val;
			this.neighbors = neighbors;
		}
	}

	// -------- DFS approach --------
	static Map<Node, Node> cloneMap = new HashMap<>();

	static public Node cloneGraphDFS(Node node) {
		if (node == null)
			return null;
		if (cloneMap.containsKey(node))
			return cloneMap.get(node);

		Node copy = new Node(node.val);
		cloneMap.put(node, copy);

		for (Node neighbor : node.neighbors) {
			copy.neighbors.add(cloneGraphDFS(neighbor));
		}
		return copy;
	}

	// -------- BFS approach --------
	static public Node cloneGraphBFS(Node node) {
		if (node == null) return null;

		Map<Node, Node> map = new HashMap<>();
		Queue<Node> queue = new LinkedList<>();

		// create the clone root
		Node cloneRoot = new Node(node.val);
		map.put(node, cloneRoot);
		queue.offer(node);

		while (!queue.isEmpty()) {
			Node curr = queue.poll();

			for (Node neigh : curr.neighbors) {
				if (!map.containsKey(neigh)) {
					// create clone of neighbor
					Node cloneNeigh = new Node(neigh.val);
					map.put(neigh, cloneNeigh);
					queue.offer(neigh);
				}
				// link the neighbor to current's clone
				map.get(curr).neighbors.add(map.get(neigh));
			}
		}
		return cloneRoot;
	}

	public static void main(String[] args) {
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);

		n1.neighbors.add(n2);
		n1.neighbors.add(n4);

		n2.neighbors.add(n1);
		n2.neighbors.add(n3);

		n3.neighbors.add(n2);
		n3.neighbors.add(n4);

		n4.neighbors.add(n1);
		n4.neighbors.add(n3);

		System.out.println("Original Graph:");
		printGraph(n1);

		// DFS clone
		Node clonedDFS = cloneGraphDFS(n1);
		System.out.println("\nCloned Graph (DFS):");
		printGraph(clonedDFS);

		// BFS clone
		Node clonedBFS = cloneGraphBFS(n1);
		System.out.println("\nCloned Graph (BFS):");
		printGraph(clonedBFS);
	}

	public static void printGraph(Node node) {
		if (node == null) {
			System.out.println("Graph is empty.");
			return;
		}

		Set<Integer> visited = new HashSet<>();
		Queue<Node> queue = new LinkedList<>();
		queue.offer(node);
		visited.add(node.val);

		while (!queue.isEmpty()) {
			Node curr = queue.poll();
			System.out.print("Node " + curr.val + " -> ");

			for (Node neigh : curr.neighbors) {
				System.out.print(neigh.val + " ");
				if (!visited.contains(neigh.val)) {
					visited.add(neigh.val);
					queue.offer(neigh);
				}
			}
			System.out.println();
		}
	}
}
