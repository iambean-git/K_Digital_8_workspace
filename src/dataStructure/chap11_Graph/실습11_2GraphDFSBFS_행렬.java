package Chap11_그래프;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

class Graph2 {
    int[][] matrix;
    int n;
    boolean[] visited;

    public Graph2(int vertices) {
        this.matrix = new int[vertices][vertices];
        this.n = vertices;
        this.visited = new boolean[n];
    }

    // Insert an edge into the graph
    public void insertEdge(int start, int end) {
        matrix[start][end] = 1;
        matrix[end][start] = 1;
    }

    // Display adjacency matrix
    public void displayMatrix() {
        System.out.println("Adjacency Matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    // BFS implementation using a queue
    void BFS(int v) {
        visited = new boolean[n]; // Reset visited array
        Queue<Integer> q = new LinkedList<>();
        visited[v] = true;
        q.add(v);

        System.out.print("BFS traversal: ");
        while (!q.isEmpty()) {
            int v1 = q.poll();
            System.out.print(v1 + " ");
            for (int i = 0; i < n; i++) {
                if (matrix[v1][i] != 0 && !visited[i]) {
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
        System.out.println();
    }

    // Recursive DFS
    void DFS(int v) {
        visited = new boolean[n]; // Reset visited array
        System.out.print("DFS traversal (recursive): ");
        _DFS(v);
        System.out.println();
    }

    private void _DFS(int v) {
        visited[v] = true;
        System.out.print(v + " ");
        for (int i = 0; i < n; i++) {
            if (matrix[v][i] != 0 && !visited[i]) {
                _DFS(i);
            }
        }
    }

    // Non-recursive DFS using a stack
    void NonRecursiveDFS(int v) {
        visited = new boolean[n]; // Reset visited array
        Stack<Integer> stack = new Stack<>();
        stack.push(v);

        System.out.print("DFS traversal (non-recursive): ");
        while (!stack.isEmpty()) {
            int current = stack.pop();
            if (!visited[current]) {
                visited[current] = true;
                System.out.print(current + " ");
                for (int i = n - 1; i >= 0; i--) { // Traverse in reverse for consistent order
                    if (matrix[current][i] != 0 && !visited[i]) {
                        stack.push(i);
                    }
                }
            }
        }
        System.out.println();
    }
}

public class 실습11_2GraphDFSBFS_행렬 {
    static final int N = 8;

    static int[][] makeGraph() {
        return new int[][]{
            {0, 1, 1, 0, 0, 0, 0, 0},
            {1, 0, 0, 1, 1, 0, 0, 0},
            {1, 0, 0, 0, 0, 1, 1, 0},
            {0, 1, 0, 0, 0, 0, 0, 1},
            {0, 1, 0, 0, 0, 0, 0, 1},
            {0, 0, 1, 0, 0, 0, 0, 1},
            {0, 0, 1, 0, 0, 0, 0, 1},
            {0, 0, 0, 1, 1, 1, 1, 0}
        };
    }
    static void showMatrix(int[][]m) {
    	System.out.println("adjacency matrix::");
    	for (int[] row : m) {
    		for (int num: row) {
    			System.out.print(num + " ");
    		}
    		System.out.println();
    	}
    }
    public static void main(String[] args) {
        int[][] matrix = makeGraph();
        showMatrix(matrix);
        Scanner sc = new Scanner(System.in);
        int select;
        int startNode = 0; // Default start node for BFS/DFS

        Graph2 g = new Graph2(N);

        // Initialize the graph with edges from the matrix
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 1) {
                    g.insertEdge(i, j);
                }
            }
        }

        while (true) {
            System.out.println("\n명령 선택 1: 그래프 행렬 출력, 2: BFS, 3: DFS (Recursive), 4: DFS (Non-Recursive), 5: 종료 => ");
            select = sc.nextInt();
            switch (select) {
                case 1:
                    g.displayMatrix();
                    break;
                case 2:
                    System.out.println("Start BFS from node: " + startNode);
                    g.BFS(startNode);
                    break;
                case 3:
                    System.out.println("Start DFS (recursive) from node: " + startNode);
                    g.DFS(startNode);
                    break;
                case 4:
                    System.out.println("Start DFS (non-recursive) from node: " + startNode);
                    g.NonRecursiveDFS(startNode);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("WRONG INPUT. Re-Enter.");
                    break;
            }
        }
    }
}
