package dataStructure.chap11_Graph;

import java.util.*;

class Edge4 implements Comparable<Edge4> {
	int src;
	int dest;
	int weight;

	public Edge4(int src, int dest, int weight) {
		this.src = src;
		this.dest = dest;
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "<" + src + ", " + dest + ", " + weight + ">";
	}

	@Override
	public int compareTo(Edge4 e) {
		return Integer.compare(this.weight, e.weight);
	}
}

class Sets2 {
	
	int[] parent;

	public Sets2(int n) {
		parent = new int[n];
		Arrays.fill(parent, -1);
	}

	public int find(int i) {
		while (parent[i] > -1) {
			i = parent[i];
		}
		return i;
	}
	public void union(int x, int y) {
		int xRoot = find(x);
		int yRoot = find(y);
		if (xRoot != yRoot) {
			int n1 = parent[xRoot];
			int n2 = parent[yRoot];
			parent[yRoot] = xRoot;
			parent[xRoot] = n1 + n2;
		}
	}
}
public class 실습11_4최소spanningtree_matrix {
	static void KruskalMST(int[][] matrix) {
		int n = matrix.length;
		List<Edge4> edges = new ArrayList<>();

		// 인접 행렬에서 모든 간선 추출
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) { // Avoid duplicate edges
				if (matrix[i][j] != 0) {
					edges.add(new Edge4(i, j, matrix[i][j]));
				}
			}
		}

		// 간선을 가중치 기준으로 정렬
		Collections.sort(edges);

		// Kruskal 알고리즘을 위한 Disjoint Set 초기화
		Sets2 ds = new Sets2(n);
		List<Edge4> mst = new ArrayList<>();

		for (Edge4 edge : edges) {
			int root1 = ds.find(edge.src);
			int root2 = ds.find(edge.dest);

			// 사이클을 만들지 않는 경우만 MST에 추가
			if (root1 != root2) {
				mst.add(edge);
				ds.union(root1, root2);
			}
		}

		// MST 출력
		if (mst.size() != n - 1) {
			System.out.println("No spanning tree found.");
		} else {
			System.out.println("Minimum Spanning Tree:");
			for (Edge4 edge : mst) {
				System.out.println(edge);
			}
		}
	}

	static final int N = 7;

	static int[][] makeGraph() {
		return new int[][]{
			{0, 28, 0, 0, 0, 10, 0},
			{28, 0, 16, 0, 0, 0, 14},
			{0, 16, 0, 12, 0, 0, 0},
			{0, 0, 12, 0, 22, 0, 18},
			{0, 0, 0, 22, 0, 25, 24},
			{10, 0, 0, 0, 25, 0, 0},
			{0, 14, 0, 18, 24, 0, 0},
		};
	}

	static void showMatrix(int[][] m) {
		System.out.println("Adjacency matrix:");
		for (int[] row : m) {
			for (int num : row) {
				System.out.print(num + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int[][] matrix = makeGraph();
		showMatrix(matrix);

		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("\n명령선택:: 1. Adjacency Matrix 출력, 2. spanningTree (Kruskal), 3: Quit => ");
			int select = sc.nextInt();
			switch (select) {
			case 1:
				showMatrix(matrix);
				break;
			case 2:
				System.out.println("\nMinimal Spanning Tree 작업 시작");
				KruskalMST(matrix);
				break;
			case 3:
				sc.close();
				System.exit(0);
			default:
				System.out.println("잘못된 입력입니다. 다시 시도하세요.");
			}
		}
	}
}
