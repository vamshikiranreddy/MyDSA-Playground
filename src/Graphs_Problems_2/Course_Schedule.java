package Graphs_Problems_2;

import java.util.*;

public class Course_Schedule {

    // Method to check if all courses can be finished given prerequisites
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        int[] indegree = new int[numCourses];

        // Initialize adjacency list
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }

        // Build the graph and compute in-degrees
        for (int[] prereq : prerequisites) {
            int u = prereq[1]; // prerequisite course
            int v = prereq[0]; // course dependent on u
            adjList.get(u).add(v);
            indegree[v]++;
        }

        // Use a queue to process courses with no prerequisites
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int completedCourses = 0;

        // Process nodes in topological order
        while (!queue.isEmpty()) {
            int course = queue.poll();
            completedCourses++;

            for (int neighbor : adjList.get(course)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0)
                    queue.offer(neighbor);
            }
        }

        // All courses can be finished if we processed all of them
        return completedCourses == numCourses;
    }

    public static void main(String[] args) {
        // Example usage
        int numCourses = 4;
        int[][] prerequisites = { {1, 0}, {2, 1}, {3, 2} };

        if (canFinish(numCourses, prerequisites)) {
            System.out.println("All courses can be finished.");
        } else {
            System.out.println("Not possible to finish all courses due to a cycle.");
        }
    }
}
