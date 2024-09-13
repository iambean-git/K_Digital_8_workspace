package chap4_array;

//import java.util.Arrays;

public class 실습4_1_배열생성최대값 {

	public static void main(String[] args) {
		// 1차원 배열 생성 및 초기화
		/*
		 * 정수 1차원 배열 price를 선언하고 5개 값으로 초기화
		 */
		int[] price = {1500,750,890,2000,1300};
		
	    // for문을 사용한 최대값 찾기
		/*
		 * 최대값 변수를 priceMax로 선언한 후에 for 문을 사용하여 최대값을 찾는다
		 * 배열 price는 확장형 for 문으로 출력, 출력 형태는 다음과 같다:
		 * [1,2,3,4,5]
		 * 최대값 출력은 다음과 같다
		 * 최대값 = **
		 * 
		 */
		System.out.print("[ ");
		for (int num:price) {
			System.out.print(num + " ");
			
		}
		System.out.println("]");
		
		//System.out.println(Arrays.toString(price));
		
		int max = 0;
		for (int num:price) {
			if (num > max) max=num;
		}
		System.out.println("최댓값 = " + max );
	}

}
