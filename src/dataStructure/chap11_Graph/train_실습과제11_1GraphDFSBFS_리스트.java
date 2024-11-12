package dataStructure.chap11_Graph;

import java.util.*;
import java.util.Stack;

class Graph {
	LinkedList<Integer>[] headNodes;
	int n;
	boolean[] visited;

	public Graph(int vertices) {
		n = vertices;
		headNodes = new LinkedList[n];
		visited = new boolean[n];
		
		for(int i=0; i<n; i++) {
			headNodes[i] = new LinkedList<>();
		}
	}

	void displayAdjacencyLists() {
		for(int i=0; i<n; i++) {
			System.out.print("[" + i + "]");
			for (int node : headNodes[i]) {
				System.out.print(" -> " + node);
			}
			System.out.println();
		}
	}

	void insertEdge(int start, int end) {
		headNodes[start].add(end);
	}

	void bfs(int startNode) {
		boolean[] visited = new boolean[n];
		Queue<Integer> queue = new LinkedList<>();
		
		for(int i=0; i<n; i++) {
			visited[i] = false;
		}
		
		visited[startNode] = true;
		queue.add(startNode);

		System.out.print("BFS traversal: ");
		while (!queue.isEmpty()) {
			int pNode = queue.remove();
			System.out.print(pNode + " ");
			for(int node : headNodes[pNode]) {
				if(!visited[node]) {
					queue.add(node);
					visited[node] = true;
				}
			}
		}
		System.out.println();
	}

	void dfs(int startNode) {
		Arrays.fill(visited, false);
		System.out.print("DFS traversal: ");
		nonRecursiveDfs(startNode);
		System.out.println();
	}

	void nonRecursiveDfs(int startNode) {
		Stack<Integer> stack = new Stack<>();
		
		stack.push(startNode);
		visited[startNode] = true;

		while (!stack.isEmpty()) {
			int pNode = stack.pop();
			System.out.print(pNode + " ");
			
			for(int node : headNodes[pNode]) {
				if(!visited[node]) {
					stack.push(node);
					visited[node] = true;
				}
			}
		}
	}
}

class InputGraph3 {
	int start, end;

	InputGraph3(int start, int end) {
		this.start = start;
		this.end = end;
	}
}
public class train_실습과제11_1GraphDFSBFS_리스트 {
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
		Graph g = new Graph(N);

		while (true) {
			System.out.println("\nChoose Command: 1: Add edges, 2: Display Adjacency List, 3: BFS, 4: DFS, 5: Exit => ");
			int select = sc.nextInt();
			switch (select) {
			case 1:
				List<InputGraph3> inputData = new ArrayList<>();
				for (int i = 0; i < matrix.length; i++) {
					for (int j = 0; j < matrix[0].length; j++) {
						if (matrix[i][j] == 1) {
							inputData.add(new InputGraph3(i, j));
						}
					}
				}
				for (InputGraph3 edge : inputData) {
					g.insertEdge(edge.start, edge.end);
				}
				break;

			case 2:
				g.displayAdjacencyLists();
				break;

			case 3:
				System.out.print("Enter starting node for BFS: ");
				int startBfsNode = sc.nextInt();
				g.bfs(startBfsNode);
				break;

			case 4:
				System.out.print("Enter starting node for DFS: ");
				int startDfsNode = sc.nextInt();
				g.dfs(startDfsNode);
				break;

			case 5:
				sc.close();
				System.exit(0);

			default:
				System.out.println("Invalid input. Please re-enter.");
			}
		}
	}
}
