package chap05_Recursive;

import java.util.Stack;

class Graph {
    private int numVertex; // 노드 숫자
    private int[][] graph; // Adjacency matrix
    private int[] path; // 해밀턴 경로를 배열로 저장

    Graph(int[][] graph) {
        this.numVertex = graph.length;
        this.graph = graph;
        this.path = new int[numVertex];
        
        // 미방문 경로는 -1로 초기화
        for (int i = 0; i < numVertex; i++) {
            path[i] = -1;
        }
    }

    boolean findPath(int start) {
    	int p = start;//시작노드
        Stack<Integer> stack = new Stack<>();
        path[p] = 0;
        stack.push(p); // 노드 p부터 시작

        int pos = 1;

        while (!stack.isEmpty()) {
            int currentVertex = stack.peek();
            System.out.println("node=" + currentVertex);

            if (pos == numVertex) {
            	System.out.println("경로 찾다");

            }
            
            boolean foundNext = false;
            for (int i = path[currentVertex]+1; i < numVertex; i++) {

            }

            if (!foundNext) {
                // Backtrack
            }

        }

        System.out.println("해밀턴 경로 없다.");
        return false;
    }

    boolean isSafe(int currentNode, int nextNode) {
        // 새로 방문할 노드 v가 이전에 방문할 노드에 연결되었는지 검사
        //  새로 방문할 노드가 이전 경로에 있는지 조사
    	
    	return false;

    }

    void showPath() {
        System.out.println("해밀턴 경로:");
        for (int i = 0; i < numVertex; i++) {
            System.out.print(path[i] + " ");
        }
        System.out.println(path[0]); // 해밀턴 경로
    }
}
public class train_5_9_1해밀톤경로 {
    public static void main(String[] args) {
        int[][] graph = {
            {0, 1, 0, 1, 0, 0},
            {1, 0, 1, 1, 1, 0},
            {0, 1, 0, 0, 1, 1},
            {1, 1, 0, 0, 1, 0},
            {0, 1, 1, 1, 0, 1},
            {0, 0, 1, 0, 1, 0}
        };
        
        Graph g = new Graph(graph);
        g.findPath(0);
    }
}
