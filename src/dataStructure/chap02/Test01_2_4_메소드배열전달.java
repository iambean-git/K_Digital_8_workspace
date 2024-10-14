package dataStructure.chap02;

/*
 * 2장과제1: 메소드 함수에 parameter 전달
 * 메소드에 배열 전달 실습: 교재 59 - 메소드의 매개변수로 배열 사용하기
 * function parameters를 작성할 수 있어야 한다 
 */

import java.util.Random;
public class Test01_2_4_메소드배열전달 {
	static int top = 0;
	static final int MAX_LENGTH = 20;
	public static void main(String[] args) {
		int []data = new int[10];
		inputData(data);
		showData("소스데이터",data);
		int max = findMax(data);
		System.out.println("\nmax = " + max);
		boolean existValue = findValue(data, 3);
		System.out.println("찾는 값 = " + 3 + ", 존재여부 = " + existValue);
		reverse(data);// 역순으로 출력 
		showData("역순 데이터", data);
		
	}
	
	//top 갯수까지 출력한다 [1,2,3]등으로 출력하도록 작성
	static void showData(String msg, int[] arr) {
		System.out.println(msg);
		for(int i=0; i<top; i++) {
			System.out.print(arr[i]+" ");
		}
	}
	
	
	static void inputData(int[] arr) {//교재 63 - 난수의 생성
		//top이 배열에 저장된 갯수를 저장
		for(int i=0; i<arr.length; i++) {
			Random rand = new Random();
			int n = rand.nextInt(100);
			arr[i] = n;			
			top +=1;
		}
	}
	
	
	//최대값을 리턴한다
	static int findMax(int[] arr) {
		int max = arr[0];
		for(int i=1; i<arr.length; i++) {
			if(arr[i]>max)	max=arr[i];			
		}
		return max;
	}
	

	//items[]에 value 값이 있는지를 찾아 존재하면 true, 없으면 false 리턴
	static boolean findValue(int[] arr, int num) {
		for(int i=0; i<arr.length; i++) {
			if(arr[i]==num)	return true;
		}
		return false;
	}
	
	static void swap(int[] arr, int i, int j){
		int t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}
	
	private static void reverse(int[] arr) {
		int len = arr.length;
		for(int i=0; i<len/2; i++) {
			swap(arr, i, len-i-1);
		}
	}
}