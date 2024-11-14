package chap11_Graph;

import java.util.Arrays;
import java.util.Scanner;

class Graph5 {
    private static final int NMAX = 10;
    private static final int MAX_WEIGHT = 999999;

    private int[][] length = new int[NMAX][NMAX];
    private int[] dist = new int[NMAX];
    private boolean[] s = new boolean[NMAX];
    private final int n;
    public Graph5(int nodeSize) {
        n = nodeSize;
        for (int i = 0; i < NMAX; i++) {
            for (int j = 0; j < NMAX; j++) {
                length[i][j] = MAX_WEIGHT;//i ~ j 간의 거리가 무한대 표시 > 길없음
            }
        }
    }


    public void insertEdge(int start, int end, int weight) {
        if (start >= n || end >= n || start < 0 || end < 0) {
            System.out.println("노드 번호 오류. 최대 노드 번호: " + (n - 1));
            return;
        }
        length[start][end] = weight;
    }

    public void displayConnectionMatrix() {
        for (int i = 0; i < n; i++) {
            boolean exists = false;
            for (int k = 0; k < n; k++) {
                if (length[i][k] == MAX_WEIGHT) continue;
                exists = true;
                System.out.print(i + " -> " + k + " (w=" + length[i][k] + "), ");
            }
            if (exists) System.out.println();
        }
    }

    public boolean isNonNegativeEdgeCost() {
        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n; k++) {
                if (length[i][k] < 0) return false;
            }
        }
        return true;
    }

    public void shortestPath(int startNode) {
        Arrays.fill(s, false);
        for (int i = 0; i < n; i++) {
            dist[i] = length[startNode][i];
        }
        s[startNode] = true;
        dist[startNode] = 0;

        for (int i = 0; i < n - 1; i++) {
            int u = choose();
            s[u] = true;
            for (int w = 0; w < n; w++) {
                if (!s[w] && dist[u] + length[u][w] < dist[w]) {
                    dist[w] = dist[u] + length[u][w];
                }
            }
        }
        printDistances(startNode);
    }

    private int choose() {
        int minDist = MAX_WEIGHT;
        int index = -1;
        for (int i = 0; i < n; i++) {
            if (!s[i] && dist[i] < minDist) {
                minDist = dist[i];
                index = i;
            }
        }
        return index;
    }

    private void printDistances(int startNode) {
        System.out.print("출발노드 " + startNode + ": ");
        for (int i = 0; i < n; i++) {
        	System.out.print("->("+i+")");
            System.out.print((dist[i] == MAX_WEIGHT ? "∞" : dist[i]) + " ");
        }
        System.out.println();
    }
}
public class 실습11_5최단경로 {
	static void showMatrix(int[][] m) {
		System.out.println("Adjacency matrix:");
		for (int[] row : m) {
			for (int num : row) {
				System.out.print(num + " ");
			}
			System.out.println();
		}
	}
    public static int[][] makeGraph1() {	//가중치가 마이너스일때
        return new int[][]{
            {0, 6, 5, 7, 0, 0, 0},
            {6, 0, -2, 0, -1, 0, 0},
            {5, -2, 0, -2, 1, 0, 0},
            {7, 0, -2, 0, 0, -1, 0},
            {0, -1, 1, 0, 0, 0, 3},
            {0, 0, 0, -1, 0, 0, 8},
            {0, 0, 0, 0, 3, 8, 0}
        };
    }

    public static int[][] makeGraph2() {
        return new int[][]{
            {0, 300, 1000, 0, 0, 0, 0, 1700},
            {300, 0, 800, 0, 0, 0, 0, 0},
            {1000, 800, 0, 1200, 0, 0, 0, 0},
            {0, 0, 0, 1200, 1500, 1000, 0, 0},
            {0, 0, 0, 1500, 0, 250, 0, 0},
            {0, 0, 0, 1000, 250, 0, 900, 1400},
            {0, 0, 0, 0, 0, 900, 0, 1000},
            {1700, 0, 0, 0, 0, 1400, 1000, 0}
        };
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Graph5 g = null;

        System.out.println("1: 그래프(가중치 마이너스), 2: 그래프(도시간 거리)");
        int select = scanner.nextInt();
        if (select == 1) {
            int[][] matrix = makeGraph1();
            showMatrix(matrix);
            g = new Graph5(7);
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    if (matrix[i][j] != 0) {
                        g.insertEdge(i, j, matrix[i][j]);
                    }
                }
            }
        } else if (select == 2) {
            int[][] matrix = makeGraph2();
            showMatrix(matrix);
            g = new Graph5(8);
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    if (matrix[i][j] != 0) {
                        g.insertEdge(i, j, matrix[i][j]);
                    }
                }
            }
        } else {
            System.out.println("Invalid input. Exiting.");
            scanner.close();
            return;
        }

        while (true) {
            System.out.print("\nCommands: 1: Display Matrix, 2: Dijkstra (non-negative), 3: Quit => ");
            select = scanner.nextInt();
            if (select == 3) break;

            switch (select) {
                case 1:
                    g.displayConnectionMatrix();
                    break;
                case 2:
                    if (g.isNonNegativeEdgeCost()) {
                        System.out.print("Start node: ");
                        int startNode = scanner.nextInt();
                        g.shortestPath(startNode);
                    } else {
                        System.out.println("Negative edge가 존재하므로 Bellman-Ford 알고리즘 사용해야 한다.");
                    }
                    break;
                default:
                    System.out.println("Invalid input. Try again.");
            }
        }
        scanner.close();
    }
}
