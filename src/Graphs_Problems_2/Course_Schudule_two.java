package Graphs_Problems_2;

import java.util.*;

public class Course_Schudule_two {

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        int[] indegree = new int[numCourses];

        // Initialize adjacency list
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }

        // Build the graph and indegree array
        for (int[] prereq : prerequisites) {
            int u = prereq[1]; // prerequisite course
            int v = prereq[0]; // course to take after u
            adjList.get(u).add(v);
            indegree[v]++;
        }

        // Queue for courses with no prerequisites
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int[] order = new int[numCourses];
        int index = 0;

        // Process courses
        while (!queue.isEmpty()) {
            int course = queue.poll();
            order[index++] = course;

            for (int neighbor : adjList.get(course)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        // If not all courses processed, cycle exists → return empty array
        if (index != numCourses) {
            return new int[0];
        }

        return order; // valid topological order
    }

    public static void main(String[] args) {
        // Example usage
        int numCourses = 4;
        int[][] prerequisites = {
                {1, 0},
                {2, 0},
                {3, 1},
                {3, 2}
        };

        int[] order = findOrder(numCourses, prerequisites);

        if (order.length == 0) {
            System.out.println("No valid order exists (cycle detected).");
        } else {
            System.out.println("A possible course order:");
            System.out.println(Arrays.toString(order));
        }
    }
}
