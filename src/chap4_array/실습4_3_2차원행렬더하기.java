package chap4_array;

public class 실습4_3_2차원행렬더하기 {

	public static void main(String[] args) {
		// 두 개의 2차원 배열 생성 및 초기화
		/*
		 * 행렬 [5][7] A, B를 정수로 선언하고 12개의 값을 초기화
		 */
		
		int[][] A = {{1,2,3,4,5,6,7},
					{8,9,10,11,12,13,14},
					{15,16,17,18,19,20,21},
					{22,23,24,25,26,27,28},
					{29,30,31,32,33,34,35}};
		int[][] B = {{51,52,53,54,55,56,57},
					{58,59,60,61,62,63,64},
					{65,66,67,68,69,70,71},
					{72,73,74,75,76,77,78},
					{79,80,81,82,83,84,85},};
	
	    // 결과를 저장할 2차원 배열
		/*
		 * C = A + B => 행렬 A와 B를 더하여 C에 넣기 위한 정수 배열 C를 선언
		 */
		
		int C[][] = new int[5][7];
		
		for(int i=0; i<A.length; i++) {
			for(int j=0; j<A[i].length; j++) {
				C[i][j] = A[i][j] + B[i][j];
			}
		}
		
	    // 행렬 더하기
		/*
		 * A, B를 더한 결과를 저장하는 C를 구하는 for 문 구현
		 */
	
	
	    // 결과 출력
		/*
		 * 행렬 A, B, C를 출력하는 코드 작성
		 * 출력 형태는 
		 * "A = 
		 *      1,2,3,4,5,6,7
		 *      8,9, ...
		 *  B = 
		 *  
		 *  C = 
		 */
		
		System.out.println("행렬A");
		for(int i=0; i<A.length; i++) {
			for(int j=0; j<A[i].length; j++) {
				System.out.print(A[i][j] + "\t");
			}
			System.out.println();
		}
		
		System.out.println("\n행렬B");
		for(int i=0; i<B.length; i++) {
			for(int j=0; j<B[i].length; j++) {
				System.out.print(B[i][j] + "\t");
			}
			System.out.println();
		}
		
		System.out.println("\n행렬C");
		for(int i=0; i<C.length; i++) {
			for(int j=0; j<C[i].length; j++) {
				System.out.print(C[i][j] + "\t");
			}
			System.out.println();
		}
	}

}
