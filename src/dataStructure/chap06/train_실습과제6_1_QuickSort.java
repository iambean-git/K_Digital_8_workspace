package dataStructure.chap06;

import java.util.Stack;

//stack 1개를 사용한 non-recursve QuickSort() 구현

class Point {
	private int ix;
	private int iy;

	public Point(int x, int y) {
		ix = x;
		iy = y;
	}

	public int getX() {
		return ix;
	}

	public int getY() {
		return iy;
	}

	public void setX(int x) {
		ix = x;
	}

	public void setY(int y) {
		iy = y;
	}
}

public class train_실습과제6_1_QuickSort {

//퀵 정렬(비재귀 버전)

	// --- 배열 요소 a[idx1]와 a[idx2]의 값을 교환 ---//
	static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;
	}

	// --- 퀵 정렬(비재귀 버전)---//
	static void quickSort(int[] a, int left, int right) {

		Stack<Point> stack = new Stack<>();
		Point pt = new Point(left, right);
		stack.push(pt);
		
		while(!stack.isEmpty()) {
			Point tmp = stack.pop();
			int pl = left = tmp.getX();		//왼쪽 커서
			int pr = right = tmp.getY();	//오른쪽 커서
				
			int pivot = a[(left+right) / 2];	//피벗 (가운데 요소)
			
			do {
				while(a[pl] < pivot)	pl++;
				while(a[pr] > pivot)	pr--;
				
				if(pl<=pr)	swap(a,pl++, pr--);
			} while(pl<=pr);
			
			//요소가 1개이면 아래 조건이 해당 안됨 (즉, 남은 요소가 2개이상)
			if(left<pr) stack.push(new Point(left,pr));
			
			if(pl<right) stack.push(new Point(pl, right));
		}

	}

	public static void main(String[] args) {
		int nx = 10;
		int[] x = new int[10];
		for (int ix = 0; ix < 10; ix++) {
			double d = Math.random();
			x[ix] = (int) (d * 20);
		}
		for (int i = 0; i < nx; i++)
			System.out.print(" " + x[i]);
		System.out.println();
		

		quickSort(x, 0, nx - 1); // 배열 x를 퀵정렬

		System.out.println("오름차순으로 정렬했습니다.");
		for (int i = 0; i < nx; i++)
			System.out.print(" " + x[i]);
	}
}
