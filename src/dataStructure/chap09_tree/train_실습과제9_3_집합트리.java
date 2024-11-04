package Chap9_Tree;

import java.util.Arrays;

class Sets {
    private int[] parent;
    private int n;

    public Sets(int sz) {
        n = sz;
        parent = new int[sz + 1]; // 집합 1 ~ N
        Arrays.fill(parent, -1);  //  -1로 초기화
    }

    public void display() {
        System.out.print("display:index=  ");
        for (int i = 1; i <= n; i++) {
            System.out.printf("%3d", i);
        }
        System.out.println();

        System.out.print("display:value= ");
        for (int i = 1; i <= n; i++) {
            System.out.printf("%3d", parent[i]);
        }
        System.out.println();
    }
    public void delete(int n) {
        if (n < 1 || n > this.n) {
            System.out.println("Invalid element index.");
            return;
        }

        //삭제할 element의 root를 찾는다


        // 같은 집합의 모든 elements의 parent가 n이면 root를 가리키게 한다


        // 삭제 처리는 -1로 표시하여 삭제 처리

    }

    public void simpleUnion(int i, int j) {
        // i,j의 root를 찾아 union
        i = simpleFind(i);
        j = simpleFind(j);
        if (i == j) return;
        //simple union 구현

    }

    public int simpleFind(int i) {
        // i를 포함한 집합의 root를 반환

        return i;
    }

    public void weightedUnion(int i, int j) {
        // i, j가 속한 집합의 root를 찾아 union, 단 집합갯수가 작은 것이 child로 union
        i = simpleFind(i);
        j = simpleFind(j);
        if (i == j) return;
        // union 구현

    }

}
public class train_실습과제9_3_집합트리 {
    public static void main(String[] args) {
        Sets m = new Sets(20);
        m.simpleUnion(7, 1);
        m.simpleUnion(2, 3);
        m.simpleUnion(4, 5);
        m.simpleUnion(6, 7);
        m.simpleUnion(4, 2);
        m.simpleUnion(5, 7);
        m.simpleUnion(8, 10);
        m.simpleUnion(13, 11);
        m.simpleUnion(12, 9);
        m.simpleUnion(14, 20);
        m.simpleUnion(16, 19);
        m.simpleUnion(17, 18);
        m.simpleUnion(12, 19);
        m.simpleUnion(13, 15);
        System.out.println("SimpleUnion() 실행 결과::");
        m.display();

        m.weightedUnion(1, 2);
        m.weightedUnion(1, 4);
        m.weightedUnion(3, 9);
        m.weightedUnion(7, 15);
        m.weightedUnion(12, 18);
        m.weightedUnion(4, 16);
        System.out.println("WeightedUnion() 실행 결과::");
        if (m.simpleFind(2) == m.simpleFind(18))
        	System.out.println("2, 18은 같은 집합이다");
        else
        	System.out.println("2, 18은 다른 집합이다");
        m.display();
        System.out.println("***2를 집합에서 삭제한다***");
        m.delete(2);
        if (m.simpleFind(2) == m.simpleFind(18))
        	System.out.println("2, 18은 같은 집합이다");
        else
        	System.out.println("2, 18은 다른 집합이다");
        
    }
}
