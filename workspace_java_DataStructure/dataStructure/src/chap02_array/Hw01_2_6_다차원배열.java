package chap02_array;

/*
 * 3번째 실습
 * 교재 83 - 배열 처리 + function parameter 전달 숙달 훈련 
 *  함수에서 배열을 리턴할 때 리턴 타입 정의할 수 있어야 한다
 */

import java.util.Random;
public class Hw01_2_6_다차원배열 {

	public static void main(String[] args) {
		int [][]A = new int[2][3];
		int [][]B = new int[3][4];
		int [][]C = new int[2][4];

		inputData(A);inputData(B);
		int [][]D = A.clone();//교재83 - 배열 복제
		System.out.println("A[2][3] = ");
		showData("행렬 A", A);
		System.out.println("D[2][3] = ");
		showData("행렬 D", D);
		System.out.println();
		System.out.println("B[3][4] = ");
		showData("행렬 B", B);
		int [][]E = addMatrix(A,D);
		System.out.println("E[2][3] = ");
		showData("행렬 E", E);
//		System.out.println("A와 B는 " + equals(A,B));
//		System.out.println("A와 D는 " + equals(A,D));
		
		C = multiplyMatrix(A,B);
		System.out.println("C[2][4] = ");
		showData("행렬 C", C);

		int [][]F = transposeMatrix(B);
		System.out.println("F[3][2] = ");
		showData("행렬 F", F);
		C= multiplyMatrixTransposed(A,F);
		showData("행렬 곱셈 결과-전치행렬 사용", C);
	}
	
	static void inputData(int[][] data) {
		for(int i=0; i<data.length; i++) {
			for(int j=0; j<data[i].length; j++) {
				Random rand = new Random();
				int randN = rand.nextInt(10);
				data[i][j]=randN;
			}
		}
	}
	
	static void showData(String msg, int[][] items) {
		System.out.println(msg);	
		for(int i=0; i<items.length; i++) {
			for(int j=0; j<items[i].length; j++) {
				System.out.print(items[i][j] + " ");
			}
			System.out.println();
		}
	}

	static boolean equals(int[][]a, int[][]b) {
		int lenX = a.length;
		int lenY = a[0].length;
		
		//배열의 크기가 같은지 1차 검사
		if(lenX==b.length && lenY==b[0].length) {
			
			//배열의 내용이 같은지 2차 검사
			for(int i=0; i<lenX; i++) {
				for(int j=0; j<lenY; j++) {
					if(a[i][j] != b[i][j])	return false;	
				}
			}
			//모든 조건 검사 후 안걸리면 참
			return true;
			
		} else return false;
	}
	
	static int[][] addMatrix(int [][]X, int[][]Y) {
		int lenA = X.length;
		int lenB = X[0].length;
		int[][] newArr = new int[lenA][lenB];
		for(int i=0; i<lenA; i++) {
			for(int j=0; j<lenB; j++) {
				newArr[i][j] = X[i][j] + Y[i][j];
			}
		}
		return newArr;
	}
	
	static int[][] multiplyMatrix(int [][]X, int[][]Y) {
		int rowX = X.length;
		int colX = X[0].length;
		int colY = Y[0].length;
		int[][] result = new int[rowX][colY];
		for (int i=0; i<rowX; i++) {
			for(int k=0; k<colY; k++) {
				for(int j=0; j<colX; j++) {
					result[i][k] += X[i][j] * Y[j][k];
				}
			}
		}
		return result;
	}
	
	static int[][] transposeMatrix(int [][]X) {
		int lenY = X.length;
		int lenX = X[0].length;
		int[][] newArr = new int[lenX][lenY];
		
		for(int i=0; i<lenY; i++) {
			for(int j=0; j<lenX; j++) {
				newArr[j][i] = X[i][j];
			}
		}
		
		return newArr;
	}
	
	static int[][] multiplyMatrixTransposed(int [][]X, int[][]Y){
		int[][] result = new int[X.length][Y.length];
		
		for(int i=0; i<X.length; i++) {
			for(int k=0; k<Y.length; k++) {
				for(int j=0; j<X[0].length; j++) {
					result[i][k]+=X[i][j] * Y[k][j];	
				}
			}
		}
		return result;
	}
}

