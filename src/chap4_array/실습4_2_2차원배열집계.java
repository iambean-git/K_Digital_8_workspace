package chap4_array;

public class 실습4_2_2차원배열집계 {

	public static void main(String[] args) {
		// 2차원 배열 생성 및 초기화
    	/*
    	 * 2차원 행렬 [3][4]을 matrix 정수 변수로 선언하고 12개 값을 초기화
    	 */
		
		int[][] arr2 = {{10,25,31,24},{12,2,80,54},{11,54,97,5}};
		
        // 최대값, 최소값, 합 개수 초기화
    	/*
    	 * max, min, sum, count 정수 변수를 선언, 초기 값 지정
    	 * for 문을 사용하여 최대, 최소, 합, 개수를 계산  
    	 */

		int max = 0;
		int min = 100;
		int sum = 0;
		int count = 0;
		
		for (int i=0; i<arr2.length; i++) {
			for (int j=0; j<arr2[i].length; j++) {
				if (arr2[i][j]>max) max=arr2[i][j];
				if (arr2[i][j]<min) min=arr2[i][j];
				sum += arr2[i][j];
				count += 1;
			}
		}
		
        // 평균 계산
    	/*
    	 * sum을 사용하여 평균을 avg 변수로 선언하여 저장
    	 */
		
		double avg = 0;
		avg = (double)sum/count;

        // 결과 출력
    	/*
    	 * 2차원 배열을 행렬 형태(테이블 형태)로 출력
    	 * 최대, 최소, 합, 개수, 평균을 다음과 같이 출력
    	 * "최대=**, 최소=**, 합 = **, 갯수=**, 평균=**"
    	 */
		
		for (int i=0; i<arr2.length; i++) {
			System.out.print("[");
			for (int j=0; j<arr2[i].length; j++) {
				System.out.print(arr2[i][j] );
				if(j != arr2[i].length-1) System.out.print(", "); 
				
			}
			System.out.print("]");
			System.out.println();
		}
		
		System.out.println("\n최대 = " + max + " ,최소 = " + min + " ,합 = " + sum + ", 갯수 = " + count + ", 평균 = " + avg);
		

	}

}
