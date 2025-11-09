package Graphs_1_Matrix;
import java.util.*;

public class Graph_Matrix_BFS {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		System.out.println("Enter number of nodes:");
		int n = in.nextInt();

		int[][] matrix = new int[n][n];

		System.out.println("Enter number of edges:");
		int e = in.nextInt();

		System.out.println("Enter edges (src dst):");
		for (int i = 0; i < e; i++) {
			int src = in.nextInt();
			int dst = in.nextInt();
			matrix[src][dst] = 1;

			// For undirected graph, add this:
			// matrix[dst][src] = 1;
		}

		System.out.println("Enter starting node index for BFS:");
		int start = in.nextInt();

		bfs(matrix, start);

		in.close();
	}

	public static void bfs(int[][] matrix, int start) {
		int n = matrix.length;
		boolean[] visited = new boolean[n];
		Queue<Integer> queue = new LinkedList<>();

		visited[start] = true;
		queue.add(start);

		System.out.println("BFS Traversal:");
		while (!queue.isEmpty()) {
			int current = queue.poll();
			System.out.print(current + " ");

			for (int i = 0; i < n; i++) {
				if (matrix[current][i] == 1 && !visited[i]) {
					visited[i] = true;
					queue.add(i);
				}
			}
		}
	}
}
