package dataStructure.chap02;
/*
 * 2장 과제2 - 정수 배열 정렬
 * 배열의 크기는 20개, top 변수가 현재 배열에 저장된 갯수를 저장 
 */
import java.util.Arrays;
//교재 67 - 실습 2-5
//2번 실습
import java.util.Random;
public class Test02_2_5_정수배열정렬 {
	static int top = 0;
	static final int MAX_LENGTH = 20;
	public static void main(String[] args) {
		float []data = new float[MAX_LENGTH];// 0.0 ~ 1.0 사이의 실수를 저장
		inputData(data, 10);//10개의 난수를 입력
		showData("실수 난수 입력", data);//top 개수 만큼 출력

		reverse(data);//역순으로 재배치 - 교재 67페이지 참조
		showData("역순 재배치", data);
		System.out.println(Arrays.toString(data));	 // 교재 84페이지 코드 참조
		showData("실수 스트링의 정렬", data);
		sortData(data);//교재 205 bubbleSort() 함수 코드를 사용 - 올림차순으로 정렬
		showData("버블정렬", data);
		float realData = (new Random()).nextFloat();//실수 난수 생성
		insertData(data, realData);//입력 실수보다 큰 숫자를 우측으로 이동
		System.out.println("삽입할 실수 : "+ realData);
		showData("실수 삽입후", data);
	}
	
	static void showData(String msg, float[] arr) {//실수 배열을 top 갯수만 출력
		System.out.println(msg);
		for(int i=0; i<top; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();

	}
	static void inputData(float[] arr, int n) {
		//난수 실수를 입력
		for(int i=0; i<n; i++) {
			Random rand = new Random();
			float f = rand.nextFloat();
			arr[i] = f;
			top += 1;
		}
	}
	
	private static void reverse(float[] arr) {
		for(int i=0; i<top/2; i++) {
			swap(arr, i, top-i-1);
		}
	}
	
	static void swap(float[] arr, int i, int j){
		float t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}
	
	static void sortData(float[] arr) {//올림차순으로 정렬 - top 갯수를 사용
		//교재 205 bubbleSort() 함수 코드를 사용 - 올림차순으로 정렬
		
		for(int i=0; i<top-1; i++) {
			for(int j=top-1; j>i; j--) {
				if(arr[j-1] > arr[j])
					swap(arr, j-1, j);
			}
		}
	}
	
	static void insertData(float[] arr, float f) {//insert되는 실수 값이 insert될 위치를 찾아 보다 큰 값은 우측으로 이동
		int j = top;
		while(j>0 && arr[j-1]>f) {
			arr[j] = arr[j-1];
			j--;
		}
		arr[j] = f;
		top++;
	}
}

