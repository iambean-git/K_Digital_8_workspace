package basicJava.chap4_array;

import java.util.Arrays;

public class Test33 {

	public static void main(String[] args) {
		
		/* 에러발생
		int[] score;
		score = {90,85,78,100,98};
		*/
		
		/*
		 * 성공 
		 * int[] score; 
		 * score = new int[] {90,85,78,100,98};
		 */
		 		 
		int[] arr = {10,20,30,40,50};
		
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);
		System.out.println(arr[3]);
		System.out.println(arr[4]);
		
		System.out.println(Arrays.toString(arr));
	}

}
