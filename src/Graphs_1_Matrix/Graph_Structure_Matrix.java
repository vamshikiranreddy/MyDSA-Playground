package Graphs_1_Matrix;
import java.util.*;
public class Graph_Structure_Matrix {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		System.out.println("Enter the number of nodes:");
		int n = in.nextInt();

		int[][] adjMatrix = new int[n][n]; // n x n matrix initialized to 0

		System.out.println("Enter the number of edges:");
		int e = in.nextInt();

		System.out.println("Enter edges (src dst) as 0-based indices:");
		for (int i = 0; i < e; i++) {
			int src = in.nextInt();
			int dst = in.nextInt();

			// Directed graph
			adjMatrix[src][dst] = 1;

			// For undirected graph, also add:
			// adjMatrix[dst][src] = 1;
		}

		System.out.println("Adjacency Matrix:");
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(adjMatrix[i][j] + " ");
			}
			System.out.println();
		}

		in.close();

	}

}
