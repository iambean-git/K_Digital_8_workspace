package dataStructure.chap03;

/*
* 3장 1번 실습과제: 03-3 정수배열이진검색
* 함수(메소드)에 parameter 전달 방식을 표현하는 능력의 숙달 훈련
* 함수(메소드) 전체를 작성하는 훈련 
* 3장 - 1번 실습 과제 > 2번 실습: 스트링 객체의 정렬과 이진 탐색 > 3번 실습: 객체 정렬과 이진 탐색
*/
import java.util.Arrays;
import java.util.Random;
public class Test01_3_4_정수배열이진탐색 {

	public static void main(String[] args) {
		int []data = new int[30];
		inputData(data);// 구현 반복 숙달 훈련 - 100 이하 난수를 생성

		showList("정렬 전 배열[]:: ", data);
		Arrays.sort(data);
		showList("정렬 후 배열[]:: ", data);// 구현 반복 숙달 훈련

		int key = (new Random()).nextInt(100);
		boolean resultIndex = linearSearch(data, key);//교재 99-100:실습 3-1 참조, 교재 102: 실습 3-2
		//Arrays 클래스에 linear search는 없기 때문에 구현해야 한다 
		System.out.println("\nlinearSearch(13): key = " + key + ", result = " + resultIndex);
		key = (new Random()).nextInt(100);
		/*
		 * 교재 109~113
		 */
		resultIndex = binarySearch(data, key);//함수 구현이 필요
		System.out.println("\nbinarySearch(19): key = " + key + ", result = " + resultIndex);
		
		key = (new Random()).nextInt(100);
		/*
		 * 교재 115 Arrays.binarySearch에 의한 검색
		 */
		int resultIndex1 = Arrays.binarySearch(data, key);
		System.out.println("\nArrays.binarySearch(10): result = " + resultIndex1);

	}
	
	static void inputData(int[] arr) {
		for(int i=0; i<arr.length; i++) {
			Random rand = new Random();
			int tmp = rand.nextInt(101);
			arr[i] = tmp;
		}
	}
	
	static void showList(String msg, int[] arr) {
		System.out.print(msg);
		for(int i=0; i<arr.length; i++)
			System.out.print(arr[i]+ " ");
		System.out.println();
	}
	
	static boolean linearSearch(int[] arr, int key) {
		int i = 0;
		while(i<arr.length) {
			if(arr[i]==key)	return true;
			i++;
		}
		return false;
	}
	
	static boolean binarySearch(int[]arr, int key) {
		int pl = 0;
		int pr = arr.length-1;
		
		while (pl<=pr) {
			int pc = (pl+pr)/2;
			if(arr[pc]==key)	
				return true;
			else if(arr[pc]<key)	
				pl = pc + 1;
			else 
				pr = pc - 1;
		}
		return false;
	}
}
