package chap11_Graph;

import java.util.Arrays;
import java.util.Scanner;

class Graph3 {
    private static final int NMAX = 10;
    private static final int MAX_WEIGHT = 999999;

    private int[][] length = new int[NMAX][NMAX];
    private int[] dist = new int[NMAX];
    private boolean[] s = new boolean[NMAX];
    private final int n;
    public Graph3(int nodeSize) {
    	n = nodeSize;
    	
    	//모든 경우에 길이 없는 무한대로 설정
    	for(int i=0; i<n; i++) {
    		for(int j=0; j<n; j++) {
    			length[i][j] = MAX_WEIGHT;
    		}
    	}
    }


    public void insertEdge(int start, int end, int weight) {
    	length[start][end] = weight;
    }

    public void displayConnectionMatrix() {
    	for(int i=0; i<n; i++) {
        	for(int j=0; j<n; j++) {
        		if(length[i][j] == MAX_WEIGHT)	continue;
        		else {
        			System.out.print(" "+i + "->" + j + " (w="+length[i][j]+")  ");
        		}
        		
        	}
        	System.out.println();
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
    	// s: 방문 여부 체크하기 위한 배열 (false로 초기화)
        Arrays.fill(s, false);
        for (int i = 0; i < n; i++) {
            dist[i] = length[startNode][i];
        }
        s[startNode] = true;
        dist[startNode] = 0;

        for (int i = 0; i < n - 1; i++) {
        	int m = choose();
        	s[m] = true;
        	for(int w=0; w<n; w++) {
        		if( !s[w] && dist[m] + length[m][w] < dist[w] ) {
        			dist[w] = dist[m] + length[m][w];
        		}
        	}
        }
        printDistances(startNode);
    }

    private int choose() {
        int minDist = MAX_WEIGHT;
        int index = -1;
        for(int i=0; i<n; i++) {
        	if(!s[i] && dist[i] < minDist ) {
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
public class train_실습과제11_5최단경로 {
	static void showMatrix(int[][] m) {
		System.out.println("Adjacency matrix:");
		for (int[] row : m) {
			for (int num : row) {
				System.out.print(num + " ");
			}
			System.out.println();
		}
	}
    public static int[][] makeGraph1() {
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
        Graph3 g = null;

        System.out.println("1: 그래프(가중치 마이너스), 2: 그래프(도시간 거리)");
        int select = scanner.nextInt();
        if (select == 1) {
            int[][] matrix = makeGraph1();
            showMatrix(matrix);
            g = new Graph3(7);
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
            g = new Graph3(8);
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
