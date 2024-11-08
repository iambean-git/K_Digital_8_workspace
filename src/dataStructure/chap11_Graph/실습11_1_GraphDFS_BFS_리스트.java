package dataStructure.chap11_Graph;
import java.util.*;

class Graph {
	LinkedList<Integer>[] headNodes;
	int n;
	boolean[] visited;

	@SuppressWarnings("unchecked")
	public Graph(int vertices) {
		n = vertices;
		headNodes = new LinkedList[n];
		visited = new boolean[n];

		for (int i = 0; i < n; i++) {
			headNodes[i] = new LinkedList<>();
			visited[i] = false;
		}
	}

	void displayAdjacencyLists() {
		for (int i = 0; i < n; i++) {
			System.out.print("[" + i + "]");
			for (int node : headNodes[i]) {
				System.out.print(" -> " + node);
			}
			System.out.println();
		}
	}

	void insertEdge(int start, int end) {
		if (start < 0 || start >= n || end < 0 || end >= n) {
			System.out.println("The node number is out of bounds.");
			return;
		}

		headNodes[start].add(end);
		//adjacencyList[end].add(start);
	}

	void bfs(int startNode) {
		boolean[] visited = new boolean[n];
		Queue<Integer> queue = new LinkedList<>();

		visited[startNode] = true;
		queue.add(startNode);

		System.out.print("BFS traversal: ");
		while (!queue.isEmpty()) {
			int node = queue.poll();
			System.out.print(node + " ");

			for (int neighbor : headNodes[node]) {
				if (!visited[neighbor]) {
					visited[neighbor] = true;
					queue.add(neighbor);
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
			int node = stack.pop();
			System.out.print(node + " ");

			for (int neighbor : headNodes[node]) {
				if (!visited[neighbor]) {
					stack.push(neighbor);
					visited[neighbor] = true;
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

public class 실습11_1_GraphDFS_BFS_리스트 {
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
